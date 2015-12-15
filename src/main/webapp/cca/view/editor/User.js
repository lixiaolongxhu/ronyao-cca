/**用户编辑
 * 
 */
Ext.define('RYIVS.view.editor.User', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.gridEditUser',
	title : '用户管理',
	iconCls : 's_user',
	// 定义 store
	store : 'editor.User',
	// 定义 autoload
	autoload : false,
	// 定义 colums
	columns : [
//	{
//		text : 'ID',
//		width : 40,
//		sortable : true,
//		dataIndex : 'id',
//		flex : 1
//	}
{xtype: 'rownumberer',minWidth :30,text :'序号'} //设置grid 行号
	, {
		text : '用户名',
		width : 40,
		sortable : true,
		dataIndex : 'loginname',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		},
		flex : 1
	}, {
		header : '用户密码',
		width : 40,
		dataIndex : 'password',
		flex : 2,
		editor : {
			xtype : 'textfield',
			allowBlank : false
		}
	}
//		, {
//		text : '用户类型',
//		dataIndex : 'type',
//		flex : 1,
//		editor : {
//			allowBlank : false,
//			xtype : 'combo',
//			displayField : 'display',
//			valueField : 'value',
//			store : ry.constant.usertype,
//			queryMode : 'local',
//			emptyText : '用户类型'
//		},
//		renderer : function(value) {
//			return ry.constant.trans(value, ry.constant.usertype);
//		}
//	}, {
//		text : '用户等级',
//		width : 50,
//		sortable : true,
//		dataIndex : 'rank',
//		flex : 1,
//		editor : {
//			allowBlank : false,
//			xtype : 'combo',
//			displayField : 'display',
//			valueField : 'value',
//			store : ry.constant.userRank,
//			queryMode : 'local',
//			emptyText : '用户等级'
//		},
//		renderer : function(value) {
//			return ry.constant.trans(value, ry.constant.userRank);
//		}
//	}, {
//		header : '真实姓名',
//		dataIndex : 'rname',
//		flex : 2,
//		editor : {
//			xtype : 'textfield',
//			allowBlank : false
//		}
//	}, {
//		header : '电话号码',
//		dataIndex : 'telephone',
//		flex : 2,
//		editor : {
//			xtype : 'textfield',
//			allowBlank : true
//		}
//	}, {
//		header : '手机号码',
//		dataIndex : 'mobile',
//		flex : 2,
//		editor : {
//			xtype : 'textfield',
//			allowBlank : true
//		}
//	}
	
	]
});
