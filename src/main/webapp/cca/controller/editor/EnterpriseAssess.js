
Ext.define('RYIVS.controller.editor.EnterpriseAssess', {
	extend : 'Ext.app.Controller',
	models : ['editor.EnterpriseAssess'],
	views :  ['editor.EnterpriseAssess'],
	stores : ['editor.EnterpriseAssess'],

	init : function() {
		this.control({
			'enterpriseAssess ':{
        	
				afterrender:this.onAfterrender
     		 },
     		  'enterpriseAssess button[itemId=buttonExporterExcel]':{
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
   
   		window.location.href='../../ui/enterpriseAssess/excel';
   }
});
