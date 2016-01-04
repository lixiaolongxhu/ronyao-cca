Ext.define('RYIVS.controller.file.EnterpPerFileDis', {
	extend : 'Ext.app.Controller',
	models : ['file.EnterpPerFileEdit'],
	stores : ['file.EnterpPerFileEdit'],
	views : [ 'file.EnterpPerFileDis','file.EnterpPerFileEditDis','file.EnterpPerFileUpload'],
	refs : [{
			selector : 'displayEnterprisePer',
			ref : 'displayEnterprisePer'
		},{
			selector : 'enterpPerFileEditDis',
			ref : 'enterpPerFileEditDis'
		}
	],
	init : function(){
		this.control({
			'enterpPerFileDis':{
//				selectionchange:this.onSelectionChange
				afterrender:this.onAfterrender
			}
		});
		controller.enterpPerFileDis = this;
	},
	
	
	//界面建立时只调用一次
	onAfterrender : function(pa, options) {
		//获取企业enterprise选中的grid的值
		var enterpgrid = this.getDisplayEnterprisePer();
        var  enterpModel = enterpgrid.getSelectionModel().getSelection();  
//      var  enterpriseid=enterpModel[0].data.enterpriseid;
        var  enterpriseperid=enterpModel[0].data.id;
		//alert("enterpriseid : " +enterpriseid);
       
        var  store=this.getEnterpPerFileEditDis().getStore();
		store.proxy.setExtraParam("enterpriseperid", enterpriseperid);
		store.load();
//		store.load({params:{page:1,start:0,limit:36}});
			
	}
	

	
	
	
});