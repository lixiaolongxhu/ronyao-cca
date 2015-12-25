
Ext.define('RYIVS.controller.editor.Behavior', {
	extend : 'Ext.app.Controller',
	models : ['editor.Behavior'],
	views :  ['editor.Behavior'],
	stores : ['editor.Behavior'],

	init : function() {
		this.control({
			'behavior ':{
        	
				afterrender:this.onAfterrender
     		 },
     		  'behavior button[itemId=buttonExporterExcel]':{
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
 
   		window.location.href='../../ui/behavior/excel';
   }
	
	
	
});
