
Ext.define('RYIVS.controller.editor.EnterpriseApt', {
	extend : 'Ext.app.Controller',
	models : ['editor.EnterpriseApt'],
	views :  ['editor.EnterpriseApt'],
	stores : ['editor.EnterpriseApt'],

	init : function() {
		this.control({
      		'enterpriseApt button[itemId=buttonLookOver]':{
        		click : this.lookOver
     		 }
   		 });
	},
	
	//查看grid选中行详细详细
	lookOver:function(obj){
		
		var grid = obj.ownerCt.ownerCt;
        var localStore = grid.getStore();
        var list = grid.getSelectionModel().getSelection();
        if(list.length){
        	var record=list[0];
        		
        //	alert(record.get('qualifications'))
        	Ext.create('Ext.window.Window', {
			    title: 'Hello',
			    height: 600,
			    width: 800,
			    layout: 'fit',
			    autoScroll :true,
			    autoDestroy : true,
			    modal:true,//为模式窗口
			    html :'<p>'+record.get('qualifications')+'</p>'
			    
        	}).show();

 			
        }
	}
	
});
