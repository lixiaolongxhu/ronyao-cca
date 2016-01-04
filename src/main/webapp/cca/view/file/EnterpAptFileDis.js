/**企业资质文件管理
 * 
 */

Ext.define('RYIVS.view.file.EnterpAptFileDis', {
	extend : 'Ext.window.Window',
	alias : 'widget.enterpAptFileDis',
	width : 800,
	height : 600,
	title:'企业资质文件管理',
	maximizable : true,
	modal : true,
	layout:'border',
	items:[
		{
		xtype : 'enterpAptFileEditDis',
		region : 'center'
	}
	
	]
})