
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
		//使用grid的选择模式,获取选择的记录store 与model
		var grid = obj.ownerCt.ownerCt;
        //var localStore = grid.getStore();
        var list = grid.getSelectionModel().getSelection();
        if(list.length){
        	var record=list[0];
      		//弹出模态的window窗体
        	Ext.create('Ext.window.Window', {
//			    title: 'Hello',
			    height: 600,
			    width: 800,
			    layout: 'fit',
			    autoScroll :true,
			    autoDestroy : true,
			    modal:true,//为模式窗口
			    //html :'<p>'+record.get('qualifications')+'</p>'
			    items :[{xtype :'enterpriseAptLookover'}]
			    
        	}).show();
        	
        	//alert(" enterpriseAptLookover:  "+Ext.getCmp('enterpriseAptLookover'));
        	//Ext.getCmp 根据id 获取对象是,要求对象必须实例后或者已被调用实例,只被声明,是无法获取到对象的
			var form=Ext.getCmp('enterpriseAptLookover').getForm();
			//向form载入model对应的记录
        	form.loadRecord(record);
 			
        }
	}
	
});
