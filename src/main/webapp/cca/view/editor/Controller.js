/**
 * 控制器编辑
 */
Ext.define('RYIVS.view.editor.Controller', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'Ext.panel.Panel',
	alias : 'widget.gridEditController',
	layout : 'border',
	iconCls : 's_equipment',
	title : '控制器编辑',
	items : [ {
		region : 'center',
		xtype : 'gridEditBase',
		title : '控制器',
		iconCls : 's_equipment',
		// 定义 Model
		model : 'RYIVS.model.editor.Controller',
		// 定义 autoload
		autoload : false,
		// 主表id
		itemId : 'master',
		// 定义插入的缺省值
		newRecord : {
			type : 1001
		},
		// 定义 colums
		columns : [ {
			text : 'ID',
			dataIndex : 'id'
		}, {
			text : '设备编号',
			dataIndex : 'no',
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 1,
				autoStripChars : true,
				allowDecimals : false
			}
		}, {
			text : 'IP地址',
			dataIndex : 'ip',
			flex : 1,
			editor : {
				allowBlank : false
			}
		}, {
			text : '端口',
			dataIndex : 'port',
			flex : 1,
			editor : {
				allowBlank : false,
				xtype : 'numberfield'
			}
		}, {
			text : '名称',
			dataIndex : 'name',
			flex : 1,
			editor : {
				allowBlank : false
			}
		} ]
	}

	, {
		// 底部面版
		xtype : 'gridEditBase',
		region : 'south',
		height : 300,
		title : '控制器通道',
		iconCls : 's_equipmentcha',
		// 定义 Model
		model : 'RYIVS.model.editor.CtlChannel',
		// 定义 autoload
		autoload : false,
		// 定义拖动后，添加到资源是那类
		dropClass : 2,
		// 主表的id
		master : 'master',
		// 外键名称
		fkey : 'eid',
		// 定义 colums
		columns : [ {
			text : 'ID',
			dataIndex : 'id'
		}, {
			text : '控制器ID',
			dataIndex : 'eid',
			flex : 1
		}, {
			text : '通道编号',
			dataIndex : 'node',
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 1,
				autoStripChars : true,
				allowDecimals : false
			}
		}, {
			text : '通道类型',
			dataIndex : 'type',
			flex : 1,
			editor : {
				allowBlank : false,
				xtype : 'combo',
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.ctrChaResType,
				queryMode : 'local',
				emptyText : '资源类型'
			},
			renderer : function(val) {
				//return ry.util.getResCssClass(val);
				return '<image src="res/mark/' + val + '.png">';
			}
		}, {
			text : '通道名称',
			dataIndex : 'name',
			flex : 1,
			editor : {
				allowBlank : false
			}
		}, {
			text : '资源',
			dataIndex : 'resid',
			flex : 1,
			renderer : function(val) {
				var rst = 0;
				if (val) {
					rst = 1;
				} else {
					rst = 0;
				}
				return ry.constant.trans(rst, ry.constant.yntype);
			}
		} ],
		// 使能拖放
		viewConfig : {
			plugins : {
				ddGroup : 'ddgEquipment',
				ptype : 'gridviewdragdrop',
				enableDrop : false
			},
			emptyText:'<div style="text-align:center; padding:50px; color:gray">没有数据可显示</div>',
	        	deferEmptyText:false
			}
	} ]

});
