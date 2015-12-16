/**企业(资质)基本信息管理.
 * 
 */
Ext.define('RYIVS.controller.editor.EnterprisePer', {
	extend : 'Ext.app.Controller',
	models : ['editor.EnterprisePer'],
	views :  ['editor.EnterprisePer'],
	stores : ['editor.EnterprisePer'],

	init : function() {
		this.control({
      		
     		
     		  'enterprisePer button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 }
   		 });
	},
	
	/**excel 导出
	 * 
	 */
   exporterExcel :function(){
   	
   			alert("excel导出测试");
//   		window.location.href='../../ui/excel';
   }

	
});
