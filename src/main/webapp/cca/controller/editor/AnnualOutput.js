
Ext.define('RYIVS.controller.editor.AnnualOutput', {
	extend : 'Ext.app.Controller',
	models : ['editor.AnnualOutput'],
	views :  ['editor.AnnualOutput'],
	stores : ['editor.AnnualOutput'],

	init : function() {
		this.control({
      		
     		
     		  'annualOutput button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 }
   		 });
	},
	
	/**excel 导出
	 * 
	 */
   exporterExcel :function(){
 
   		window.location.href='../../ui/annualOutput/excel';
   }
	
});
