/* 
 * 通用的资源Grid
 * 这里只提供资源列表的基本框架
 * 该资源列表可以用户管理员界面和监控界面，具体的行为由相关的Controller进行控制
 */

Ext.define('RYIVS.view.common.ResGrid', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	requires : [ 'RYIVS.lib.GridDragPlugin' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.resGrid',
	title : '资源',
	iconCls: 's_resource',
	hideHeaders: true,
	// 定义 Model
	model : 'RYIVS.model.common.ResGrid',
	// 定义 autoload
	autoload : true,
	// 定义 colums
	columns : [ {
		width : 40,
		dataIndex : 'type',
		align : 'right',
		renderer : function(val) {
			return '<image src="res/mark/' + val + '.png">'
		}
	}, {
		text : '资源列表',
		width : 40,
		sortable : true,
		dataIndex : 'name',
		menuDisabled : true,
		flex : 1,
		editor : {
			allowBlank : false
		},

	} ],

	features : [ Ext.create('Ext.grid.feature.Grouping', {
		groupHeaderTpl : [ '{groupValue:this.formatValue}: 共 ({rows.length}) 个', {
			formatValue : function(value) {
				return ry.constant.trans(value, ry.constant.resourceType);
			}
		} ]
	}) ],

	viewConfig : {
		plugins : {
			ddGroup : 'ddgEquipment',
			ptype : 'gridDragPlugin',
			enableDrop : true,
			enableDrag : true
		}
	},

	// 是否使能拖放
	enableDrag : function(en) {
		var dragPlugin = this.getView().getPlugin();
		if (en) {
			dragPlugin.enable();
		} else {
			dragPlugin.disable();
		}
	},

	// 是否允许删除
	enableDelete : function(en) {
		if (en) {
			this.query('button[itemId="buttonDelete"]')[0].show();
		} else {
			this.query('button[itemId="buttonDelete"]')[0].hide();
		}
	},
	// 得到Res的Store
	getResStore : function() {
		return this.store;
	},
	initComponent : function() {
		this.callParent(arguments);
		this.store.group('type');
		this.query('button[itemId="buttonAdd"]')[0].hide();

		// 禁止编辑
		this.on('beforeedit', function(e) {
			return false;
		});

		// 不使用拖放
		this.enableDrag(false);
		
		controller.viewResGrid = this;

	},
});
