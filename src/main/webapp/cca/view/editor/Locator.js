//定位器编辑
Ext.define('RYIVS.view.editor.Locator', {
	requires : ['RYIVS.lib.GridEditBase'],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.gridEditLocator',
	title : '定位器设置',
	iconCls: 's_locator',
	// 定义 Model
	model : 'RYIVS.model.editor.Locator',
	// 定义 autoload
	autoload: false,
	// 定义 colums
	columns : [{
		text : 'ID',
		width : 40,
		sortable : true,
		dataIndex : 'id',
		flex: 1
	}, {
		text : '手持机编号(No)',
		width : 40,
		sortable : true,
		dataIndex : 'no',
		editor:{
			xtype: 'textfield',
			allowBlank : false
		},
		flex: 1
	}, {
		header : '名称(name)',
		dataIndex : 'name',
		flex : 2,
		editor:{
			xtype: 'textfield',
			allowBlank : false
		}
	}]
});


