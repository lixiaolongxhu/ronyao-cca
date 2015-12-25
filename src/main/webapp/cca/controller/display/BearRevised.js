

Ext.define('RYIVS.controller.display.BearRevised', {
	extend : 'Ext.app.Controller',
	models : ['display.Bear'],
	views :  ['display.BearRevised'],
	stores : ['display.BearRevised'],

	init : function() {
		this.control({
			
     		  'bearRevised button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 }
     		 
   		 });
	},
	
	/**excel 导出
	 * 
	 */
   exporterExcel :function(){
 
   		window.location.href='../../ui/bearRevised/excel';
   }
});