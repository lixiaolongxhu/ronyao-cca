

Ext.define('RYIVS.controller.display.BearRevised', {
	extend : 'Ext.app.Controller',
	models : ['display.Bear'],
	views :  ['display.BearRevised'],
	stores : ['display.BearRevised'],

	init : function() {
		this.control({
			'bearRevised ':{
        	
				afterrender:this.onAfterrender
     		 },
     		  'bearRevised button[itemId=buttonExporterExcel]':{
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
 
   		window.location.href='../../ui/bearRevised/excel';
   }
});