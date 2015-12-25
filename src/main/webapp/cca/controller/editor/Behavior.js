
Ext.define('RYIVS.controller.editor.Behavior', {
	extend : 'Ext.app.Controller',
	models : ['editor.Behavior'],
	views :  ['editor.Behavior'],
	stores : ['editor.Behavior'],

	init : function() {
		this.control({
			
     		  'behavior button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 }
     		 
   		 });
	},
	
	/**excel 导出
	 * 
	 */
   exporterExcel :function(){
 
   		window.location.href='../../ui/behavior/excel';
   }
	
	
	
});
