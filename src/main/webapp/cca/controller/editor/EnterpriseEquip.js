
Ext.define('RYIVS.controller.editor.EnterpriseEquip', {
	extend : 'Ext.app.Controller',
	models : ['editor.EnterpriseEquip'],
	views :  ['editor.EnterpriseEquip'],
	stores : ['editor.EnterpriseEquip'],

	init : function() {
		this.control({
			
     		  'enterpriseEquip button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 }
     		 
   		 });
	},
	
	/**excel 导出
	 * 
	 */
   exporterExcel :function(){
 
   		window.location.href='../../ui/enterpriseEquip/excel';
   }
	

	
});
