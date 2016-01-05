
Ext.define('RYIVS.controller.editor.EnterpriseEquip', {
	extend : 'Ext.app.Controller',
	models : ['editor.EnterpriseEquip'],

	stores : ['editor.EnterpriseEquip'],
	
	views :  ['editor.EnterpriseEquip','display.EnterpriseEquip'],
	
	init : function() {
		this.control({
			'enterpriseEquip ':{
        	
				afterrender:this.onAfterrender
     		 },
      		
     		  'enterpriseEquip button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 },
     		 
     		 
     		 'displayEnterpriseEquip ':{
        	
				afterrender:this.onAfterrender
     		 },
      		
     		  'displayEnterpriseEquip button[itemId=buttonExporterExcel]':{
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
 
   		window.location.href='../../ui/enterpriseEquip/excel';
   }
	

	
});
