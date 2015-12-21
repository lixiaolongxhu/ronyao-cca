/**企业(资质)基本信息管理.
 * 
 */
Ext.define('RYIVS.controller.editor.Enterprise', {
	extend : 'Ext.app.Controller',
	models : ['editor.Enterprise'],
	views :  ['editor.Enterprise','file.EnterpAptFileMan','file.EnterpAptFileEdit','file.EnterpAptFileUpload'],
	stores : ['editor.Enterprise'],
//	refs : [{
//			selector : 'enterpAptFileEdit',
//			ref : 'enterpAptFileEdit'
//		}
//	],
	init : function() {
		this.control({
			
//			'enterpAptFileEdit':{
////				selectionchange:this.onSelectionChange
//				afterrender:this.onAfterrender
//			},
      		
     		 'enterprise button[itemId=buttonAptFileManager]':{
        		click : this.aptFileManager
     		 },
     		  'enterprise button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 }
   		 });
	},
	
	
	/**企业资质文件管理
	 * 
	 */
   aptFileManager :function(){
   		Ext.create("RYIVS.view.file.EnterpAptFileMan").show();
   },
	/**excel 导出
	 * 
	 */
   exporterExcel :function(){
   	
   			alert("excel导出测试");
//   		window.location.href='../../ui/excel';
   }
   
});
