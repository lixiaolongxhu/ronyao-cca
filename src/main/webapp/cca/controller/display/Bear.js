

Ext.define('RYIVS.controller.display.Bear', {
	extend : 'Ext.app.Controller',
	models : ['display.Bear'],
	views :  ['display.Bear'],
	stores : ['display.Bear'],

	init : function() {
		this.control({
      		
			'bear ':{
        	
				afterrender:this.onAfterrender
     		 },
     		
     		  'bear button[itemId=buttonExporterExcel]':{
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
 
   		window.location.href='../../ui/bear/excel';
   }
});