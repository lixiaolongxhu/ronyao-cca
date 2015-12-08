/*
 * 告警历史查询
 * 历史录像查询界面
 */
Ext.define('RYIVS.view.layer.TabAlarm', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.tabAlarm',
	title : '历史数据',
	iconCls : 's_history',
	layout : 'border',
	items : [ {
		xtype : 'videoPanel',
		region : 'center'
	}, {
		xtype : 'timeline',
		region : 'south'
	} ]
});
