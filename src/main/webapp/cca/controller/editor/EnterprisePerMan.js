
Ext.define('RYIVS.controller.editor.EnterprisePerMan', {
	extend : 'Ext.app.Controller',
	models : ['editor.EnterprisePerMan'],
	views :  ['editor.EnterprisePerManLine','editor.EnterprisePerManPower'],
	stores : ['editor.EnterprisePerManLine','editor.EnterprisePerManPower'],

	init : function() {
		this.control({
			'enterprisePerManLine ':{
        	
				afterrender:this.onAfterrenderLine
     		 },
			
			 'enterprisePerManPower ':{
        	
				afterrender:this.onAfterrenderPower
     		 },
			
      		 'enterprisePerManLine button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcelLine
     		 },
     		 'enterprisePerManPower button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcelPower
     		 }
   		 });
   	},
   	
   	/**界面建立时只调用一次
	 * 
	 * @param {} pa
	 * @param {} options
	 */
	onAfterrenderLine : function(pa, options) {
		pa.getStore().load();			
	},
   	
   		/**界面建立时只调用一次
	 * 
	 * @param {} pa
	 * @param {} options
	 */
	onAfterrenderPower : function(pa, options) {
		pa.getStore().load();			
	},
   	
   		/**excel 导出
	 * 
	 * 
	 */
   exporterExcelLine :function(){
   		window.location.href='../../ui/enterprisePerManLine/excel';
   },
   	/**excel 导出
	 * 
	 * 
	 */
   exporterExcelPower :function(){
   		window.location.href='../../ui/enterprisePerManPower/excel';
   }
	
	

	
});
