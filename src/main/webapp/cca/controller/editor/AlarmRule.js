/**
 * 告警规则管理
 */
Ext.define('RYIVS.controller.editor.AlarmRule', {
	extend : 'Ext.app.Controller',
	models : [ 'editor.AlarmRule', 'editor.RuleAction', 'video.RuleActionPtzPos' ],
	stores : [ 'video.RuleActionPtzPos', 'common.LinkParm1' ],
	views : [ 'editor.AlarmRule' ],

	refs : [ {
		selector : 'gridEditAlarmRule > gridEditBase#master',
		ref : 'ruleGrid'
	}, {
		selector : 'gridEditAlarmRule > gridEditBase#slave',
		ref : 'actionGrid'
	} ],

	init : function() {
		this.control({
			'gridEditAlarmRule > gridEditBase#master' : {
				onDragDrop : this.onRuleDrop
			},
			'gridEditAlarmRule > gridEditBase#slave' : {
				onDragDrop : this.onActionDrop,
				itemdblclick : this.onItemdblclick
			},
			'gridEditAlarmRule' : {
				activate : this.onActivate
			}
		});

		controller.alarmRule = this;
	},
	
	onItemdblclick : function(view, record, item, ndex, e,eOpts) {
		var action = record.data.action;
		var parm1_combo = Ext.getCmp('parm1_combo');
		var parm2 = Ext.getCmp('parm2');
		var oldValue = parm1_combo.value;
		var resid = record.data.target;
		var newValue = "";
		parm1_combo.store.removeAll();
		switch(action) {
			case 1://预置位调用
				var posStore = Ext.create('RYIVS.store.video.RuleActionPtzPos');
				posStore.proxy.setExtraParam('resid',resid);
				posStore.load({
				    scope: this,
				    callback: function(records, operation, success) {
				    	if(success) {
				    		parm1_combo.store.loadData(records);
				    	}
				    }
				});
				parm1_combo.enable();
				parm2.disable();
				Ext.Ajax.request({
					url : 'controller/queryPtz',
					method : 'POST',
					async : false,
					timeout : 2000,
					params : {resid : resid, pos : oldValue},
					success : function(response) {
						var res = Ext.decode(response.responseText);
						newValue = res.name;
					}
				});
				break;
			case 2://录像
				parm1_combo.disable();
				parm2.disable();
				newValue = '无';
				break;
			case 3://开关量控制
				parm1_combo.enable();
				parm2.disable();
				newValue = ry.constant.trans(oldValue,ry.constant.ctlType);
				parm1_combo.store.loadData(ry.constant.link_switch, false);
				break;
			case 4://空调控制
				parm1_combo.enable();
				parm2.enable();
				newValue = ry.constant.trans(oldValue,ry.constant.airType);
				parm1_combo.store.loadData(ry.constant.link_air);
				break;
		}
		parm1_combo.setValue(parm1_combo.valueToRaw(oldValue));
	},
	
	// 当标签激活时
	onActivate : function(pa, options) {
		pa.items.items[0].store.load();
	},

	// 添加规则
	onRuleDrop : function(data, targetNode, position) {
		var record = data.records[0].data;
		var item = {
			resid : record.id
		};
		this.getRuleGrid().store.insert(0, item)
		this.getRuleGrid().rowEditing.startEdit(0, 0);
	},

	// 添加规则对应的动作
	onActionDrop : function(data, targetNode, position) {
		var record = data.records[0].data;
		this.getActionGrid().newRecord.target = record.id;

		this.getActionGrid().store.insert(0, this.getActionGrid().newRecord);
		this.getActionGrid().rowEditing.startEdit(0, 0);
	}

});
