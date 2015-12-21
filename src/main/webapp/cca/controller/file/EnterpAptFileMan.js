Ext.define('RYIVS.controller.file.EnterpAptFileMan', {
	extend : 'Ext.app.Controller',
	models : ['file.EnterpAptFileEdit'],
	stores : ['file.EnterpAptFileEdit'],
	views : [ 'file.EnterpAptFileMan','file.EnterpAptFileEdit','file.EnterpAptFileUpload'],
	refs : [{
			selector : 'enterpAptFileUpload textfield[name=aptitudeid]',
			ref : 'aptitudeid'
		},{
			selector : 'enterpAptFileUpload textfield[name=aptituderankid]',
			ref : 'rank'
		},{
			selector : 'enterpAptFileUpload textfield[name=files]',
			ref : 'filePath'
		},{
			selector : 'enterprise',
			ref : 'enterprise'
		},{
			selector : 'enterpAptFileEdit',
			ref : 'enterpAptFileEdit'
		}
	],
	init : function(){
		this.control({
			'enterpAptFileMan':{
//				selectionchange:this.onSelectionChange
				afterrender:this.onAfterrender
			},
			'enterpAptFileUpload button[itemId=enterpAptFileUploadSubmit]':{
				click:this.onDetailSubmit
			},
			'enterpAptFileUpload button[itemId=enterpAptFileUploadReset]':{
				click:this.onDetailReset
			},
			'enterpAptFileUpload button[itemId=enterpAptFileUploadClose]':{
				click:this.onWindowClose
			}
		});
		controller.enterpAptFileMan = this;
	},
	
	
	//界面建立时只调用一次
	onAfterrender : function(pa, options) {
		//获取企业enterprise选中的grid的值
		var enterpgrid = this.getEnterprise();
        var  enterpModel = enterpgrid.getSelectionModel().getSelection();  
        var  enterpriseid=enterpModel[0].data.id;
		
//		var searchYear = this.getProjectBuildGrid().query('#projectBuildingSearchYear')[0].getValue()+'';	
//		var store = this.getProjectBuildGrid().items.items[0].store;
        
        var  store=this.getEnterpAptFileEdit().getStore();
		store.proxy.setExtraParam("enterpriseid", enterpriseid);
		store.load();
//		store.load({params:{page:1,start:0,limit:36}});

				
	},
	
//	onSelectionChange:function(model,record,opt){
//		if(record.length==0){
//			return;
//		}
//		var selectedData = record[0].data;
//		Ext.ComponentQuery.query("#detailLayerId")[0].setValue(selectedData.id);
//		Ext.ComponentQuery.query("#detailLayerName")[0].setValue(selectedData.name);
//		Ext.ComponentQuery.query("#detailLayerFilePath")[0].setValue(selectedData.fname);
//	},
	
	/**文件上传(表单提交)
	 * 
	 * @param {} bt
	 * @return {Boolean}
	 */
	onDetailSubmit:function(bt){
		
		//获取企业enterprise选中的grid的值
		var enterpgrid = this.getEnterprise();
        var  enterpModel = enterpgrid.getSelectionModel().getSelection();  
        var  enterpriseid=enterpModel[0].data.id;
  //    alert(enterpModel[0].data.id);
        
        
        //获取表单
        var form = bt.ownerCt.ownerCt.getForm();
		var aptitudeid = this.getAptitudeid().getValue();
		var rank = this.getRank().getValue();
		var filePath = this.getFilePath().getValue();
		var options = {
			method : 'post',
			waitMsg: '请稍等...',
     		success: function(response, options){
     			var msg;
				switch(options.result.reason){
					case 1:
					msg = "上传文件成功!";
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
				//刷新图片显示grid
		
				controller.enterpAptFileMan.getFileEnterpAptFileEditStore().load();

			},
			failure : function(response, options){
//				alert("出错失败");
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
			
		
		options.url = "/ui/enterpriseApt/uploadImage";
		options.params={
				enterpriseid : enterpriseid
		}
		if ((aptitudeid== "")) {
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
		
		
		if (rank == ""){
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
			//alert("执行表单提交  ");
			form.submit(options);
		}

	},
	
	onDetailReset:function(bt){
		bt.ownerCt.ownerCt.getForm().reset();
	},
	
	/**关闭
	 * 
	 * @param {} bt
	 */
	onWindowClose:function(bt){
//		alert("关闭 ");
		bt.ownerCt.ownerCt.ownerCt.close();
	}
	
	
});