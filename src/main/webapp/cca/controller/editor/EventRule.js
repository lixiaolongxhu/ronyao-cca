/**
 * 告警规则管理
 */
Ext.define('RYIVS.controller.editor.EventRule', {
	extend : 'Ext.app.Controller',
	models : [ 'editor.EventRule', 'editor.RuleAction', 'video.RuleActionPtzPos' ],
	stores : [ 'video.RuleActionPtzPos', 'common.LinkParm1' ],
	views : [ 'editor.EventRule' ],

	refs : [ {
		selector : 'eventRule > gridEditBase#master',
		ref : 'ruleGrid'
	}, {
		selector : 'eventRule > gridEditBase#slave',
		ref : 'actionGrid'
	} ],

	init : function() {
		this.control({
			'eventRule > gridEditBase#master' : {
				onDragDrop : this.onRuleDrop
			},
			'eventRule > gridEditBase#slave' : {
				onDragDrop : this.onActionDrop,
				itemdblclick : this.onItemdblclick
			},
			'eventRule' : {
				activate : this.onActivate
			}
		});

		controller.alarmRule = this;
	},
	
	onItemdblclick : function(view, record, item, ndex, e,eOpts) {
		var action = record.data.action;
		var parm1_combo = Ext.getCmp('event_parm1');
		var resid = record.data.target;
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
				break;
			case 2://录像
				break;
			case 3://开关量控制
				parm1_combo.store.loadData(ry.constant.link_switch);
				break;
			case 4://空调控制
				parm1_combo.store.loadData(ry.constant.link_air);
				break;
		}
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
