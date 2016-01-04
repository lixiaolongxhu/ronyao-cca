/**企业(资质)基本信息管理.
 * 
 */
Ext.define('RYIVS.controller.editor.Enterprise', {
	extend : 'Ext.app.Controller',
	models : ['editor.Enterprise'],
	views :  ['editor.Enterprise','file.EnterpAptFileMan','file.EnterpAptFileEdit','file.EnterpAptFileUpload','display.Enterprise'],
	stores : ['editor.Enterprise'],

	init : function() {
		this.control({
			 'enterprise ':{
				afterrender:this.onAfterrender
     		 },
      		
     		 'enterprise button[itemId=buttonAptFileManager]':{
        		click : this.aptFileManager
     		 },
     		  'enterprise button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 },
     		 
     		 'displayEnterprise ':{
				afterrender:this.onAfterrenderDis
     		 },
     		  'displayEnterprise button[itemId=buttonAptFileManager]':{
        		click : this.aptFileDisplay
     		 },
     		  'displayEnterprise button[itemId=buttonExporterExcel]':{
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
	onAfterrenderDis : function(pa, options) {
		pa.getStore().load();			
	},
	
	/**企业资质文件管理
	 * 
	 */
   aptFileManager :function(){
   	
   		Ext.create("RYIVS.view.file.EnterpAptFileMan").show();
   },
   aptFileDisplay :function(){
   		Ext.create("RYIVS.view.file.EnterpAptFileDis").show();
   },
   
	/**excel 导出
	 * 
	 */
   exporterExcel :function(){
   
   		window.location.href='../../ui/enterprise/excel';
   }
   
});
