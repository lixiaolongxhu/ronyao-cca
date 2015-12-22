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
      		
     		 'enterprisePer button[itemId=buttonPerFileManager]':{
        		click : this.perFileManager
     		 },
     		  'enterprisePer button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 }
   		 });
	},
	
	/**企业持证人员文件管理
	 * 
	 */
   perFileManager :function(){
   	  // alert("测试");
   	  Ext.create("RYIVS.view.file.EnterpPerFileMan").show();
   },
	
	/**excel 导出
	 * 
	 */
   exporterExcel :function(){
   	
   			alert("excel导出测试");
//   		window.location.href='../../ui/excel';
   }

	
});
