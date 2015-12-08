Ext.define('RYIVS.view.layer.TabGis', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.tabgis',
	layout : 'border',
	title : '地图浏览方式',
	iconCls : 's_gis',
	layout : 'border',
	items : [ {
		xtype : 'gisVideo',
		title : '视频播放',
		closable : true,
		closeAction : 'hide',
		region : 'west',
		width : 300,
		hidden : true
	}, {
		xtype : 'gisView',
		region : 'center'
	} ]
});
