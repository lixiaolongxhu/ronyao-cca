/**
 * 告警规则编辑
 */
Ext.define('RYIVS.view.editor.AlarmRule', {
	requires : [ 'RYIVS.lib.GridEditBase' ],
	extend : 'Ext.panel.Panel',
	alias : 'widget.gridEditAlarmRule',
	layout : 'border',
	title : '告警规则',
	iconCls : 's_alarm',
	items : [ {
		region : 'center',
		xtype : 'gridEditBase',
		title : '告警规则',
		iconCls : 's_alarmRule',
		// 定义 Model
		model : 'RYIVS.model.editor.AlarmRule',
		// 定义 autoload
		autoload : false,
		// 是否为主表
		itemId : 'master',
		forceFit : true,
		// 定义 colums
		columns : [ {
			text : 'ID',
//			width : 40,
			flex : 1,
			sortable : true,
			dataIndex : 'id'
		}, {
			header : '规则名称',
			dataIndex : 'name',
			flex : 2,
			editor : {
				// defaults to textfield if no xtype is supplied
				allowBlank : false
			}
		}, {
			header : '告警源',
			dataIndex : 'resid',
			flex : 2,
			renderer : function(value) {
				var res = controller.resGrid.getResStore().data.getByKey(value);
				if (res) {
					return res.data.name;
				} else {
					return '资源丢失！';
				}
			}
		}, {
			header : '告警类型',
			flex : 2,
			dataIndex : 'almType',
			renderer : function(value) {
				return ry.constant.trans(value, ry.constant.almtype)
			},
			field : {
				xtype : 'combobox',
				typeAhead : false,
				triggerAction : 'all',
				selectOnTab : true,
				store : ry.constant.almtype,
				valueField : 'value',
				displayField : 'text',
				lazyRender : true,
				editable : false,
				listClass : 'x-combo-list-small'
			},
			editor : {
				allowBlank : false
			}
		} ],

		// 使能拖放
		viewConfig : {
			plugins : {
				ddGroup : 'ddgEquipment',
				ptype : 'gridDragPlugin',
				enableDrop : true,
				enableDrag : false
			}
		}

	}, {
		// 底部面版
		xtype : 'gridEditBase',
		region : 'south',
		height : 300,
		title : '联动动作',
		iconCls : 's_alarmRuleAction',
		itemId : 'slave',
		forceFit : true,
		// 定义 Model
		model : 'RYIVS.model.editor.RuleAction',
		// 定义 autoload
		autoload : false,
		// 是否为主表
		master : 'master',
		// 外键
		fkey : 'rule',
		// 定义 colums
		columns : [ {
			header : 'ID',
//			width : 41,
			flex : 1,
			dataIndex : 'id'
		}, {
			header : '规则 (rule)',
			flex : 2,
			dataIndex : 'rule'
		}, {
			header : '联动资源 (target)',
			dataIndex : 'target',
			flex : 2,
//			width : 150,
			renderer : function(value) {
				var res = controller.resGrid.getResStore().data.getByKey(value);
				if (res) {
					return res.data.name;
				} else {
					return '资源丢失！';
				}
			}

		}, {
			header : '动作 (action)',
			dataIndex : 'action',
//			width : 180,
			flex : 2,
			editor : {
				xtype : 'combobox',
				allowBlank : false,
				typeAhead : false,
				name : 'action',
				editable : false,
				triggerAction : 'all',
				selectOnTab : true,
				store : ry.constant.actiontype,
				valueField : 'value',
				displayField : 'text',
				lazyRender : true,
				listClass : 'x-combo-list-small',
				listeners : {
					change : function(combo, newValue, oldValue, eOpts) {
						var currentRow = combo.ownerCt,
							rec = currentRow.getRecord().data,
							resid = rec.target;
							action = rec.action;
						var parm1Obj = combo.ownerCt.query("combo[comboId=parm1]")[0];
						var parm2Obj = combo.ownerCt.query("numberfield")[1];
						parm1Obj.setValue();
						parm1Obj.store.removeAll();
						switch(newValue) {
							case 1://预置位调用
								var posStore = Ext.create('RYIVS.store.video.RuleActionPtzPos');
								posStore.proxy.setExtraParam('resid',resid);
								posStore.load({
								    scope: this,
								    callback: function(records, operation, success) {
								    	if(success) {
								    		parm1Obj.store.loadData(records);
								    	}
								    }
								});
							   parm1Obj.enable();
							   parm2Obj.disable();
							   break;
							case 2://录像
								parm1Obj.disable();
								parm2Obj.disable();
								break;
							case 3://开关量控制
								parm1Obj.enable();
								parm2Obj.disable();
								parm1Obj.store.loadData(ry.constant.link_switch);
							
								break;
							case 4://空调控制
								parm1Obj.enable();
								parm2Obj.enable();
								parm1Obj.store.loadData(ry.constant.link_air);	
								break;
						}
					}
				}
			},
			
			renderer : function(value) {
				return ry.constant.trans(value, ry.constant.actiontype);
			}
		}, {
			header : '动作延时',
			dataIndex : 'delay',
			flex : 2,
//			width : 180,
			editor : {
				allowBlank : false,
				xtype : 'numberfield'
			}
		}, {
			header : '参数1',
			dataIndex : 'parm1',
//			width : 80,
			flex : 2,
			editor : {
				xtype : 'combobox',
				id : 'parm1_combo',
				allowBlank : false,
				typeAhead : false,
				editable : false,
				queryMode: 'local',
				store : 'common.LinkParm1',
				valueField : 'parm1',
				lazyRender : true,
				triggerAction : 'all',
				displayField : 'parm1Name',
				comboId : 'parm1'
			},
			renderer : function(value, metaData, recrod, rowIndex, colIndex, store, view) {
				var newValue = "";
				var data = recrod.data;
				var parm1 = data.parm1;
				switch(data.action) {
					case 1://预置位调用
						Ext.Ajax.request({
							url : 'controller/queryPtz',
							method : 'POST',
							async : false,
							timeout : 2000,
							params : {resid : data.target, pos : parm1},
							success : function(response) {
								var res = Ext.decode(response.responseText);
								newValue = res.name;
							}
						});
						break;
					case 2://录像
						newValue = '无';
						break;
					case 3://开关量控制
						newValue = ry.constant.trans(parm1,ry.constant.ctlType);
						break;
					case 4://空调控制
					    newValue = ry.constant.trans(parm1,ry.constant.airType);
						break;
				}
				return newValue;
			}
		}, {
			header : '参数2',
			dataIndex : 'parm2',
//			width : 80,
			flex : 2,
			editor : {
				id : 'parm2',
				allowBlank : false,
				xtype : 'numberfield',
				minValue : 0
			},
			renderer : function(value, metaData, record, rowIndex, colIndex, store, view) {
				var rst;
				if(!record.data.parm2){
					rst = "无";
				} else {
					rst = record.data.parm2;
				}
				return rst;
			}
		} ],

		// 使能拖放
		viewConfig : {
			plugins : {
				ddGroup : 'ddgEquipment',
				ptype : 'gridDragPlugin',
				enableDrop : true,
				enableDrag : false
			},
			emptyText:'<div style="text-align:center; padding:50px; color:gray">没有数据可显示</div>',
	        	deferEmptyText:false
			}

	} ],

	initComponent : function() {
		this.callParent(arguments);
		this.query('button[itemId="buttonAdd"]')[0].hide();
		this.query('button[itemId="buttonAdd"]')[1].hide();
	}

});
