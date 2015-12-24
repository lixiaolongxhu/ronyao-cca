

Ext.define('RYIVS.controller.display.Bear', {
	extend : 'Ext.app.Controller',
	models : ['display.Bear'],
	views :  ['display.Bear'],
	stores : ['display.Bear'],

	init : function() {
		this.control({
      		
     		
     		  'bear button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 }
   		 });
	},
	
	/**excel 导出
	 * 
	 */
   exporterExcel :function(){
 
   		window.location.href='../../ui/bear/excel';
   }
});