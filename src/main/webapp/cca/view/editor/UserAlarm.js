//用户告警方式编辑
Ext.define('RYIVS.view.editor.UserAlarm', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.gridEditUserAlarm',
	title : '用户告警转发',
	iconCls : 's_useralarm',
	// 定义 Model
	model : 'RYIVS.model.editor.UserAlarm',
	// 定义 autoload
	autoload : false,
	// 定义 colums
	columns : [ {
		text : 'ID',
		width : 40,
		sortable : true,
		dataIndex : 'id',
		flex : 1
	}, {
		text : '用户名',
		width : 40,
		sortable : true,
		dataIndex : 'uid',
		flex : 2,
		editor : {
			allowBlank : false,
			xtype : 'combo',
			displayField : 'rname',
			valueField : 'id',
			store : 'common.UserSelect',
			emptyText : '用户名'
		},
		renderer : function(val) {
				// debugger;
				var item = Ext.getStore('common.UserSelect').data.getByKey(val);
				if (item) {
					return item.data.rname;
				} else {
					return '';
				}

			}
	}, {
		header : '告警类型',
		width : 40,
		dataIndex : 'almtype',
		flex : 2,
		editor : {
			allowBlank : false,
			xtype : 'combo',
			displayField : 'display',
			valueField : 'value',
			store : ry.constant.almtype,
			queryMode : 'local',
			emptyText : '告警类型'
		},
		renderer : function(value) {
			return ry.constant.trans(value, ry.constant.almtype);
		}
	}, {
		text : '通知方式',
		dataIndex : 'sendtype',
		flex : 1,
		editor : {
			allowBlank : false,
			xtype : 'combo',
			displayField : 'display',
			valueField : 'value',
			store : ry.constant.sendtypestore,
			queryMode : 'local',
			emptyText : '通知方式'
		},
		renderer : function(value) {
			return ry.constant.trans(value, ry.constant.sendtypestore);
		}
	}]
});