Ext.define('RYIVS.controller.file.EnterpPerFileMan', {
	extend : 'Ext.app.Controller',
	models : ['file.EnterpPerFileEdit'],
	stores : ['file.EnterpPerFileEdit'],
	views : [ 'file.EnterpPerFileMan','file.EnterpPerFileEdit','file.EnterpPerFileUpload'],
	refs : [{
			selector : 'enterpPerFileUpload textfield[name=classify]',
			ref : 'classify'
		},{
			selector : 'enterpPerFileUpload textfield[name=rank]',
			ref : 'rank'
		},{
			selector : 'enterpPerFileUpload textfield[name=files]',
			ref : 'filePath'
		},{
			selector : 'enterprisePer',
			ref : 'enterprisePer'
		},{
			selector : 'enterpPerFileEdit',
			ref : 'enterpPerFileEdit'
		}
	],
	init : function(){
		this.control({
			'enterpPerFileMan':{
//				selectionchange:this.onSelectionChange
				afterrender:this.onAfterrender
			},
			'enterpPerFileUpload button[itemId=enterpPerFileUploadSubmit]':{
				click:this.onDetailSubmit
			},
			'enterpPerFileUpload button[itemId=enterpPerFileUploadReset]':{
				click:this.onDetailReset
			},
			'enterpPerFileUpload button[itemId=enterpPerFileUploadClose]':{
				click:this.onWindowClose
			}
		});
		controller.enterpPerFileMan = this;
	},
	
	
	//界面建立时只调用一次
	onAfterrender : function(pa, options) {
		//获取企业enterprise选中的grid的值
		var enterpgrid = this.getEnterprisePer();
        var  enterpModel = enterpgrid.getSelectionModel().getSelection();  
//      var  enterpriseid=enterpModel[0].data.enterpriseid;
        var  enterpriseperid=enterpModel[0].data.id;
		//alert("enterpriseid : " +enterpriseid);
       
        var  store=this.getEnterpPerFileEdit().getStore();
		store.proxy.setExtraParam("enterpriseperid", enterpriseperid);
		store.load();
//		store.load({params:{page:1,start:0,limit:36}});

				
	},
	

	
	/**文件上传(表单提交)
	 * 
	 * @param {} bt
	 * @return {Boolean}
	 */
	onDetailSubmit:function(bt){
		
		//获取企业enterprise选中的grid的值
		var enterpgrid = this.getEnterprisePer();
        var  enterpModel = enterpgrid.getSelectionModel().getSelection();  
        var  enterpriseid=enterpModel[0].data.enterpriseid;
        var  enterpriseperid=enterpModel[0].data.id;
  //    alert(enterpModel[0].data.id);
       //alert(enterpriseperid);
        
        //获取表单
        var form = bt.ownerCt.ownerCt.getForm();
		var classify = this.getClassify().getValue();
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
		
				controller.enterpPerFileMan.getFileEnterpPerFileEditStore().load();

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
			
		
		options.url = "/ui/enterprisePer/uploadImage";
		options.params={
				enterpriseid : enterpriseid,
				enterpriseperid :enterpriseperid
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