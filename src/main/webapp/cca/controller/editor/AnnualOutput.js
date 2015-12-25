
Ext.define('RYIVS.controller.editor.AnnualOutput', {
	extend : 'Ext.app.Controller',
	models : ['editor.AnnualOutput'],
	views :  ['editor.AnnualOutput'],
	stores : ['editor.AnnualOutput'],

	init : function() {
		this.control({
      		 
			 'annualOutput ':{
      
				afterrender:this.onAfterrender
     		 },
      		
     		
     		 'annualOutput button[itemId=buttonExporterExcel]':{
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
	
	/**excel 导出
	 * 
	 */
   exporterExcel :function(){
 
   		window.location.href='../../ui/annualOutput/excel';
   }
	
});
