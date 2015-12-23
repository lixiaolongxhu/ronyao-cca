
Ext.define('RYIVS.controller.editor.EquipmentBear', {
	extend : 'Ext.app.Controller',
	models : ['editor.EquipmentBear'],
	views :  ['editor.EquipmentBear'],
	stores : ['editor.EquipmentBear'],

	init : function() {
		this.control({
      		
     	
     		  'equipmentBear button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 }
   		 });
	},
		/**excel 导出
	 * 
	 */
   exporterExcel :function(){
   	
 
   		window.location.href='../../ui/equipmentBear/excel';
   }

	
});
