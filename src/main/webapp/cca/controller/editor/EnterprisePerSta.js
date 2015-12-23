
Ext.define('RYIVS.controller.editor.EnterprisePerSta', {
	extend : 'Ext.app.Controller',
	models : ['editor.EnterprisePerSta'],
	views :  ['editor.EnterprisePerSta'],
	stores : ['editor.EnterprisePerSta'],

	init : function() {
		this.control({
      		
     		
     		  'enterprisePerSta button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 }
   		 });
	},

		/**excel 导出
	 * 
	 */
   exporterExcel :function(){
   	
 
   		window.location.href='../../ui/enterprisePerSta/excel';
   }
});
