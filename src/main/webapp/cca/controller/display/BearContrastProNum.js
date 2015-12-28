

Ext.define('RYIVS.controller.display.BearContrastProNum', {
	extend : 'Ext.app.Controller',
	models : ['display.BearContrastProNum'],
	views :  ['display.BearContrastProNum'],
	stores : ['display.BearContrastProNum'],

	init : function() {
		this.control({
			'bearContrastProNum ':{
        	
				afterrender:this.onAfterrender
     		 },
      		
     		
     		  'bearContrastProNum button[itemId=buttonExporterExcel]':{
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
   
   		window.location.href='../../ui/bearContrast/projectNum/excel';
   }
});