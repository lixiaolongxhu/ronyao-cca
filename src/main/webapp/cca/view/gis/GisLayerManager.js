Ext.define('RYIVS.view.gis.GisLayerManager', {
	extend : 'Ext.window.Window',
	alias : 'widget.gisLayerManager',
	width : 800,
	height : 600,
	title:'Gis图层设置',
	maximizable : true,
	modal : true,
	layout:'border',
	items:[{
		xtype : 'gisLayerList',
		region : 'center'
	},{
		xtype : 'gisLayerDetail',
		region : 'south'
	}]
})