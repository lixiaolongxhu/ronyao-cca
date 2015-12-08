/**企业资质信息管理.
 * 
 */
Ext.define('RYIVS.view.editor.Aptitude', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.aptitude',
	title : '企业资质信息',
	iconCls : 's_user',
	region : 'center',
	
	// 定义 Model
	model : 'RYIVS.model.editor.User',
	// 定义 autoload
	autoload : true,
	// 定义 colums
	columns : [ {
		text : '企业资质信息',
		width : 40,
		sortable : true,
		dataIndex : 'id',
		flex : 1
	}, {
		text : '企业资质信息',
		width : 40,
		sortable : true,
		dataIndex : 'loginname',
		editor : {
			xtype : 'textfield',
			allowBlank : false
		},
		flex : 1
	}, {
		header : '企业资质信息',
		width : 40,
		dataIndex : 'password',
		flex : 2,
		editor : {
			xtype : 'textfield',
			allowBlank : false
		}
	}
//	, {
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
	],
	//设置没有数据显示文本
	viewConfig: {
		emptyText:'<div style="text-align:center; padding:50px; color:gray">没有数据可显示</div>',
        deferEmptyText:false
    },
    
	initComponent : function() {
		
		// 4 model 和 store 配置
		this.store = new Ext.data.Store({
			// Store所对应的模型
			model : this.model,
			autoSync : true,
			// 是否自动加载
			autoLoad : this.autoload

		});

		this.callParent(arguments);
		
	}
	
});
