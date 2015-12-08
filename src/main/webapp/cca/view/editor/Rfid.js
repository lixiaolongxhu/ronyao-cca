/**定位点编辑
 * 
 */
Ext.define('RYIVS.view.editor.Rfid', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'RYIVS.lib.GridEditBase',
	alias : 'widget.gridEditRfid',
	iconCls : 's_position',
	title : '定位点设置',
	// 定义 Model
	model : 'RYIVS.model.editor.Rfid',
	// 定义 autoload
	autoload : false,
	newRecord : {
		eid : 0,
		type: 9
	},
	// 定义 colums
	columns : [ {
		text : 'ID',
		width : 40,
		sortable : true,
		dataIndex : 'id',
		flex : 1
	}, {
		text : '资源？',
		width : 40,
		sortable : true,
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
	}, {
		header : 'UUID',
		dataIndex : 'uid',
		flex : 2,
		editor : {
			xtype : 'textfield',
			allowBlank : false,
		}
	}, {
		header : '名称',
		dataIndex : 'name',
		flex : 2,
		editor : {
			xtype : 'textfield',
			allowBlank : false,
		}
	} ],

	// 定义拖动后，添加到资源是那类
	dropClass : 3,
	// 使能拖放
	viewConfig : {
		plugins : {
			ddGroup : 'ddgEquipment',
			ptype : 'gridviewdragdrop',
			enableDrop : false
		}
	},
});
