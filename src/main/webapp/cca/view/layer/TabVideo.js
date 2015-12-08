/**
 * 传统浏览方式
 */
Ext.define('RYIVS.view.layer.TabVideo', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.tabVideo',
	title : '传统浏览方式',
	iconCls : 's_webcam',
	layout : 'border',
	items : [ {
		xtype : 'videoPanel',
		region : 'center'
	} ]
});