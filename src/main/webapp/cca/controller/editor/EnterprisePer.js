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
      		'enterprisePer ':{
        	
				afterrender:this.onAfterrender
     		 },
      		
     		 'enterprisePer button[itemId=buttonPerFileManager]':{
        		click : this.perFileManager
     		 },
     		  'enterprisePer button[itemId=buttonExporterExcel]':{
        		click : this.exporterExcel
     		 }
   		 });
	},
	
	//界面建立时只调用一次
	onAfterrender : function(pa, options) {
		pa.getStore().load();			
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
   	
 
   		window.location.href='../../ui/enterprisePer/excel';
   }

	
});
