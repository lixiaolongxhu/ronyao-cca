

Ext.define('RYIVS.controller.display.ProjectBuildBear', {
	extend : 'Ext.app.Controller',
	models : ['display.ProjectBuildBear'],
	views :  ['display.ProjectBuildBear'],
	stores : ['display.ProjectBuildBear'],

		init : function() {
		this.control({
			 'projectBuildBear ':{
        	
				afterrender:this.onAfterrender
     		 },
      		
     		  'projectBuildBear button[itemId=buttonExporterExcel]':{
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
   
   		window.location.href='../../ui/projectBuildBear/excel';
   }
});