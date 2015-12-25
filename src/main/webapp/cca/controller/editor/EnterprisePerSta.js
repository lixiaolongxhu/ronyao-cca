
Ext.define('RYIVS.controller.editor.EnterprisePerSta', {
	extend : 'Ext.app.Controller',
	models : ['editor.EnterprisePerSta'],
	views :  ['editor.EnterprisePerSta'],
	stores : ['editor.EnterprisePerSta'],

	init : function() {
		this.control({
      		 'enterprisePerSta ':{
        	
				afterrender:this.onAfterrender
     		 },
     		
     		  'enterprisePerSta button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 }
   		 });
	},

	
	
	//界面建立时只调用一次
	onAfterrender : function(pa, options) {
		pa.getStore().load();			
	},
	
	
		/**excel 导出
	 * 
	 */
   exporterExcel :function(){
   	
 
   		window.location.href='../../ui/enterprisePerSta/excel';
   }
});
