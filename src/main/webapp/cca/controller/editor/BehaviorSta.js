
Ext.define('RYIVS.controller.editor.BehaviorSta', {
	extend : 'Ext.app.Controller',
	models : ['editor.BehaviorSta'],

	stores : ['editor.BehaviorSta'],
	
	views :  ['editor.BehaviorSta','display.BehaviorSta'],

	init : function() {
		this.control({
			'behaviorSta ':{
        	
				afterrender:this.onAfterrender
     		 },
      		 'behaviorSta button[itemId=buttonLookOver]':{
        		click : this.lookOver
     		 },
     		 'behaviorSta button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 },
     		 'displayBehaviorSta ':{
        	
				afterrender:this.onAfterrender
     		 },
      		 'displayBehaviorSta button[itemId=buttonLookOver]':{
        		click : this.lookOver
     		 },
     		 'displayBehaviorSta button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 }
     		 
     		 
   		 });
	},
	
	
	/**界面建立时只调用一次
	 * 
	 * @param {} pa
	 * @param {} options
	 */
	onAfterrender : function(pa, options) {
		pa.getStore().load();			
	},
	
	/**查看grid选中行详细详细
	 * 
	 */
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
			    items :[{xtype :'behaviorStaLookover'}]
			    
        	}).show();
        	
        	//alert(" enterpriseAptLookover:  "+Ext.getCmp('enterpriseAptLookover'));
        	//Ext.getCmp 根据id 获取对象是,要求对象必须实例后或者已被调用实例,只被声明,是无法获取到对象的
			var form=Ext.getCmp('behaviorStaLookover').getForm();
			//向form载入model对应的记录
        	form.loadRecord(record);
 			
        }
	},
	
	/**excel 导出
	 * 
	 * 
	 */
   exporterExcel :function(){
   		window.location.href='../../ui/behaviorSta/excel';
   }
	
});
