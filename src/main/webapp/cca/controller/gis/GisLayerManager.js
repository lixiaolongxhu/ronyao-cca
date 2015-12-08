Ext.define('RYIVS.controller.gis.GisLayerManager', {
	extend : 'Ext.app.Controller',
	models : ['gis.GisLayerList'],
	stores : ['gis.GisLayerList'],
	views : [ 'gis.GisLayerManager','gis.GisLayerList','gis.GisLayerDetail'],
	refs : [{
			selector : 'gisLayerDetail textfield[name=detailLayerNewFilePath]',
			ref : 'file'
		},{
			selector : 'gisLayerDetail textfield[name=detailLayerName]',
			ref : 'layerName'
		},{
			selector : 'gisLayerDetail textfield[name=detailLayerId]',
			ref : 'layerId'
		},{
			selector : 'gisLayerDetail textfield[name=detailLayerFilePath]',
			ref : 'filePath'
		}
	],
	init : function(){
		this.control({
			'gisLayerList':{
				selectionchange:this.onSelectionChange
			},
			'gisLayerDetail button[itemId=gisLayerDetailSubmit]':{
				click:this.onDetailSubmit
			},
			'gisLayerDetail button[itemId=gisLayerDetailReset]':{
				click:this.onDetailReset
			},
			'gisLayerDetail button[itemId=gisLayerWindowClose]':{
				click:this.onWindowClose
			}
		});
		controller.gisLayerManager = this;
	},
	
	onSelectionChange:function(model,record,opt){
		if(record.length==0){
			return;
		}
		var selectedData = record[0].data;
		Ext.ComponentQuery.query("#detailLayerId")[0].setValue(selectedData.id);
		Ext.ComponentQuery.query("#detailLayerName")[0].setValue(selectedData.name);
		Ext.ComponentQuery.query("#detailLayerFilePath")[0].setValue(selectedData.fname);
	},
	
	onDetailSubmit:function(bt){
		var form = bt.ownerCt.ownerCt.getForm();
		var layerId = this.getLayerId().getValue();
		var layerName = this.getLayerName().getValue();
		var filePath = this.getFilePath().getValue();
		var options = {
			method : 'post',
			waitMsg: '请稍等...',
     		success: function(response, options){
     			var msg;
				switch(options.result.reason){
					case 1:
					msg = "修改图层名字成功!";
					break;
					case 2:
					msg = '上传文件成功!';
					break;
				}
				Ext.Msg.show({
					title : '成功',
					msg : msg,
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.INFO,
					scope : this,
					fn : function(btn) {
						if (btn == 'ok') {
							return false;
						}
					}
				});
				controller.gisLayerManager.getGisGisLayerListStore().load();
				controller.gisLayerEditor.reDrawGisLayers();
//				controller.gisLayerEditor.initGisLayers();
			},
			failure : function(response, options){
				var msg;
				switch(options.result.reason){
					case 1:
					msg = "上传失败！";
					break;
					case 2:
					msg = "请上传jpg格式的文件！";
					break;
				}
				Ext.Msg.show({
					title : '失败',
					msg : msg,
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.ERROR,
					scope : this,
					fn : function(btn) {
						if (btn == 'ok') {
							return false;
						}
					}
				});
			}
		};
			
		if(layerId==""){
			options.url = "/controller/upload";
			options.params={
				name : this.getLayerName().getValue()
			}
			if ((this.getFile().getValue() == "")) {
				Ext.Msg.show({
					title : '警告',
					msg : '请先选择上传文件！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARNING,
					scope : this,
					fn : function(btn) {
						if (btn == 'ok') {
							return false;
						}
					}
				});
				return false;
			}
		}else{
			options.url = "/controller/uploadPicture";
			options.params={
				id:this.getLayerId().getValue(),
				name : this.getLayerName().getValue()
			}
		}
		
		if ((this.getLayerName().getValue() == "")) {
			Ext.Msg.show({
				title : '警告',
				msg : '请输入图层名！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.WARNING,
				scope : this,
				fn : function(btn) {
					if (btn == 'ok') {
						return false;
					}
				}
			});
			return false;
		}
			
		
		if(form.isValid()){
			form.submit(options);
		}

	},
	
	onDetailReset:function(bt){
		bt.ownerCt.ownerCt.getForm().reset();
	},
	
	onWindowClose:function(bt){
		bt.ownerCt.ownerCt.ownerCt.close();
	}
	
	
});