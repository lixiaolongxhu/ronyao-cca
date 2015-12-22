
Ext.define('RYIVS.view.file.EnterpPerFileMan', {
	extend : 'Ext.window.Window',
	alias : 'widget.enterpPerFileMan',
	width : 800,
	height : 600,
	title:'企业持证人员文件管理',
	maximizable : true,
	modal : true,
	layout:'border',
	items:[
		{
		xtype : 'enterpPerFileEdit',
		region : 'center'
	},
	{
		xtype : 'enterpPerFileUpload',
		region : 'south'
	}
	
	]
})