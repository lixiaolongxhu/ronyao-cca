
Ext.define('RYIVS.controller.editor.EnterprisePerMan', {
	extend : 'Ext.app.Controller',
	models : ['editor.EnterprisePerMan'],
	views :  ['editor.EnterprisePerManLine','editor.EnterprisePerManPower'],
	stores : ['editor.EnterprisePerManLine','editor.EnterprisePerManPower'],

	init : function() {
		this.control({
      		 'enterprisePerManLine button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcelLine
     		 },
     		 'enterprisePerManPower button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcelPower
     		 }
   		 });
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
