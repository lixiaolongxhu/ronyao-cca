/**
 * 流媒体服务器
 */
Ext.define('RYIVS.view.editor.StreamServer', {
	requires : ['RYIVS.lib.GridEditBase'],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.streamServer',
	title : '流媒体服务器',
	iconCls: 's_sscfg',
	// 定义 Model
	model : 'RYIVS.model.editor.StreamServer',
	// 定义 autoload
	autoload: false,
	// 定义 colums
	columns : [{
		header : 'ID',
		width : 40,
		sortable : true,
		dataIndex : 'id',
		flex: 1
	}, {
		header : '流媒体名称',
		width : 40,
		sortable : true,
		dataIndex : 'name',
		editor:{
			xtype: 'textfield',
			allowBlank : false
		},
		flex: 2
	}, {
		header : 'IP地址',
		dataIndex : 'ip',
		flex : 2,
		editor:{
			xtype: 'textfield',
			allowBlank : false
		}
	}, {
		header : '端口',
		dataIndex : 'port',
		flex : 2,
		editor:{
			xtype: 'textfield',
			allowBlank : false
		}
	}, {
		header : '备注',
		dataIndex : 'comment',
		flex : 2,
		editor:{
			xtype: 'textfield',
			allowBlank : false
		}
	}]
});


