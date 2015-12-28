

Ext.define('RYIVS.controller.display.BearContrastProOutput', {
	extend : 'Ext.app.Controller',
	models : ['display.BearContrastProOutput'],
	views :  ['display.BearContrastProOutput'],
	stores : ['display.BearContrastProOutput'],

	
	init : function() {
		this.control({
			'bearContrastProOutput ':{
        	
				afterrender:this.onAfterrender
     		 },
      		
     		
     		  'bearContrastProOutput button[itemId=buttonExporterExcel]':{
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
   
   		window.location.href='../../ui/bearContrast/output/excel';
   }
});