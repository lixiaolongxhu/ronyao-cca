/**
 * 控制器编辑
 */
Ext.define('RYIVS.view.editor.Encoder', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'Ext.panel.Panel',
	alias : 'widget.gridEditEncoder',
	layout : 'border',
	iconCls : 's_video',
	title : '视频编码器',
	items : [ {
		region : 'center',
		xtype : 'gridEditBase',
		title : '视频编码器',
		iconCls : 's_dvr',
		// 定义 Model
		model : 'RYIVS.model.editor.Encoder',
		// 定义 autoload
		autoload : false,
		// 主表id
		itemId : 'master',
		// 定义 colums
		columns : [ {
			text : 'ID',
			dataIndex : 'id'
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
				xtype : 'numberfield',
				minValue : 1,
				autoStripChars : true,
				allowDecimals : false
			}
		}, {
			text : '登陆名',
			dataIndex : 'user',
			flex : 1,
			editor : {
				allowBlank : false
			}
		}, {
			text : '密码',
			dataIndex : 'pass',
			flex : 1,
			editor : {
				allowBlank : false
			}
		}, {
			text : '类型',
			dataIndex : 'type',
			flex : 1,
			editor : {
				allowBlank : true,
				xtype : 'combo',
				editable : false,
				displayField : 'name',
				valueField : 'id',
				store : 'common.EncoderType',
				emptyText : '选择一个型号'
			},
			renderer : function(val) {
				// debugger;
				var item = Ext.getStore('common.EncoderType').data.getByKey(val);
				if (item) {
					return item.data.name;
				} else {
					return '';
				}

			}
		}, {
			text : '名称',
			dataIndex : 'name',
			flex : 1,
			editor : {
				allowBlank : false
			}
		} ]
	}, {
		// 底部面版
		xtype : 'gridEditBase',
		region : 'south',
		height : 300,
		title : '编码器通道',
		iconCls : 's_camera',
		// 定义 Model
		model : 'RYIVS.model.editor.EncChannel',
		// 定义 autoload
		autoload : false,
		// 定义拖动后，添加到资源是那类
		master : 'master',
		fkey : 'eid',
		dropClass : 1,
		// 是否为主表
		isMaster : false,
		// 定义插入的缺省值
		newRecord : {
			type : 1
		},
		// 定义 colums
		columns : [ {
			text : 'ID',
			dataIndex : 'id'
		}, {
			text : '编码器ID',
			dataIndex : 'eid'
		}, {
			text : '通道ID',
			dataIndex : 'node',
			editor : {
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 1,
				autoStripChars : true,
				allowDecimals : false
			}
		}, {
			text : '通道名称',
			dataIndex : 'name',
			flex : 1,
			editor : {
				allowBlank : false
			}
		}, {
			text : '前端存储(是/否)',
			dataIndex : 'ext1',
			flex : 1,
			// align : 'center',
			editor : {
				allowBlank : false,
				xtype : 'combo',
				editable : false,
				displayField : 'display',
				valueField : 'value',
				store : ry.constant.yntypestore,
				queryMode : 'local',
				emptyText : '是/否'
			},
			renderer : function(val) {
				return ry.constant.trans(val, ry.constant.yntype);
			}
		}, {
			text : '多码流(是/否)',
			dataIndex : 'ext2',
			flex : 1,
			// align : 'center',
			editor : {
				allowBlank : true,
				xtype : 'combo',
				displayField : 'display',
				editable : false,
				valueField : 'value',
				store : ry.constant.yntypestore,
				queryMode : 'local',
				emptyText : '是/否'
			},
			renderer : function(val) {
				return ry.constant.trans(val, ry.constant.yntype);
			}
		}, {
			text : '资源？',
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
