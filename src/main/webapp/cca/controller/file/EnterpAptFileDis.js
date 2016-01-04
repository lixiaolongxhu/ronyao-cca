Ext.define('RYIVS.controller.file.EnterpAptFileDis', {
	extend : 'Ext.app.Controller',
	models : ['file.EnterpAptFileEdit'],
	stores : ['file.EnterpAptFileEdit'],
	views : [ 'file.EnterpAptFileDis','file.EnterpAptFileEditDis'],
	refs : [{
			selector : 'displayEnterprise',
			ref : 'displayEnterprise'
		},{
			selector : 'enterpAptFileEditDis',
			ref : 'enterpAptFileEditDis'
		}
	],
	init : function(){
		this.control({
			'enterpAptFileDis':{

				afterrender:this.onAfterrender
			}
		});
		controller.enterpAptFileDis = this;
	},
	
	
	//界面建立时只调用一次
	onAfterrender : function(pa, options) {
		//获取企业enterprise选中的grid的值
		var enterpgrid = this.getDisplayEnterprise();
        var  enterpModel = enterpgrid.getSelectionModel().getSelection();  
        var  enterpriseid=enterpModel[0].data.id;
		
//		var searchYear = this.getProjectBuildGrid().query('#projectBuildingSearchYear')[0].getValue()+'';	
//		var store = this.getProjectBuildGrid().items.items[0].store;
        
        var  store=this.getEnterpAptFileEditDis().getStore();
		store.proxy.setExtraParam("enterpriseid", enterpriseid);
		store.load();
//		store.load({params:{page:1,start:0,limit:36}});

				
	}
	
	
	
});