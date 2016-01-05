
Ext.define('RYIVS.controller.editor.EquipmentBear', {
	extend : 'Ext.app.Controller',
	models : ['editor.EquipmentBear'],
	
	stores : ['editor.EquipmentBear'],
	views :  ['editor.EquipmentBear','display.EquipmentBear'],

	init : function() {
		this.control({
      		 'equipmentBear ':{
        	
				afterrender:this.onAfterrender
     		  },
      		
     	
     		  'equipmentBear button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 },
     		 'displayEquipmentBear ':{
        	
				afterrender:this.onAfterrender
     		  },
      		
     	
     		  'displayEquipmentBear button[itemId=buttonExporterExcel]':{
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
   	
 
   		window.location.href='../../ui/equipmentBear/excel';
   }

	
});
