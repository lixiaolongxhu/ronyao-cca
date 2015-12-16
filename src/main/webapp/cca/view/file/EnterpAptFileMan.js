/**企业资质文件管理
 * 
 */

Ext.define('RYIVS.view.file.EnterpAptFileMan', {
	extend : 'Ext.window.Window',
	alias : 'widget.enterpAptFileMan',
	width : 800,
	height : 600,
	title:'企业资质文件管理',
	maximizable : true,
	modal : true,
	layout:'border',
	items:[
		{
		xtype : 'enterpAptFileEdit',
		region : 'center'
	},
	{
		xtype : 'enterpAptFileUpload',
		region : 'south'
	}
	
	]
})