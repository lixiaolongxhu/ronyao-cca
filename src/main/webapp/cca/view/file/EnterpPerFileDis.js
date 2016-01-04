
Ext.define('RYIVS.view.file.EnterpPerFileDis', {
	extend : 'Ext.window.Window',
	alias : 'widget.enterpPerFileDis',
	width : 800,
	height : 600,
	title:'企业持证人员文件管理',
	maximizable : true,
	modal : true,
	layout:'border',
	items:[
		{
		xtype : 'enterpPerFileEditDis',
		region : 'center'
	}
	
	]
})