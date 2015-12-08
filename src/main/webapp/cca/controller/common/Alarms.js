/*
 * 告警列表管理
 */
Ext.define('RYIVS.controller.common.Alarms', {
	extend : 'Ext.app.Controller',
	stores : [ 'common.Alarms', 'common.AlarmCamera'],
	models : [ 'common.Alarms', 'common.AlarmCamera'],
	views : [ 'common.Alarms' ],

	refs : [ {
		ref : 'alarmsPanel',
		selector : 'alarms'
	} ],

	init : function() {
		this.control({
			// 界面生成时调用一次
			'alarms' : {
				afterrender : this.afterRender
			},
			// 选中一个告警消息
			'alarms > gridpanel' : {
				// 告警选择
				selectionchange : this.alarmClick,
				// 告警双击
				itemdblclick : this.alarmDblClick
			},
			// 选中一个联动摄像机
			'alarms > panel > gridpanel[action=camera]' : {
				itemclick : this.cameraClick
			},
			'alarms button[action=dealAlarms]' : {
				click : this.onDealAlarms
			}
		});

		// 注册全局变量
		controller.alarmList = this;

		// 告警刷新后的事件
		this.getCommonAlarmsStore().on('load', this.onAlarmsLoad, this);
	},
	
	onDealAlarms : function(obj) {
		Ext.Msg.prompt('处理所有告警', '输入处理意见:', function(btn, text) {
			if (btn == 'ok') {
				var v = Ext.String.trim(text);
				// 保存处理意见后刷新
				var item = {
					aid : 0,
					uid : appCfg.uid,
					time : Date.parse(new Date()) / 1000,
					notes : v
				}
				Ext.getBody().mask('正在处理告警...');
				actionAlarm.createAlarmView(item, function(obj) {
					if (obj.success) {
						controller.alarmList.getCommonAlarmsStore().load();
						controller.alarmList.getCommonAlarmCameraStore().removeAll();
						controller.alarmList.getAlarmsPanel().items.items[1].items.items[0].update({});
						Ext.getBody().unmask();
					}
				});
			}
		}, this, 4, "默认处理：一次性处理所有告警记录");
	},

	// 告警消息通知
	onAlarm : function() {
		var store = this.getAlarmsPanel().items.items[0].store;
		store.proxy.extraParams = {
			state : 0
		}
		store.load();
	},

	// 只执行一次
	afterRender : function(panel, eOpts) {
		// 读取未处理的告警
		var store = this.getAlarmsPanel().items.items[0].store;
		store.proxy.extraParams = {
			state : 0
		}
		store.load();
	},

	// 双击告警，进行告警处理
	alarmDblClick : function(view, record, htmlItem, index, event, eOpts) {
		var data = record.data;

		Ext.Msg.prompt('处理意见', '输入处理意见:', function(btn, text) {
			if (btn == 'ok') {
				var v = Ext.String.trim(text);
				// 保存处理意见后刷新
				var item = {
					aid : data.id,
					uid : appCfg.uid,
					time : Date.parse(new Date()) / 1000,
					notes : v
				}
				actionAlarm.createAlarmView(item, this.afterCreateAlarmView);
			}
		}, this, 4);
	},

	// 添加告警处理意见后的返回
	afterCreateAlarmView : function(obj) {
		if (obj.success) {
			controller.alarmList.getCommonAlarmsStore().load();
			controller.alarmList.getCommonAlarmCameraStore().removeAll();
			controller.alarmList.getAlarmsPanel().items.items[1].items.items[0].update({});
		}
	},

	// 查询未处理告警
	onAlarmsLoad : function(store, records, successful, operation, options) {
		if (store.totalCount > 0) {
			// 有告警
			controller.alarmList.getAlarmsPanel().setIconCls('s_alarma');
			var a = document.getElementById('wave.alarm');
			a.play();
			this.getAlarmsPanel().show();
		} else {
			// 没有告警
			controller.alarmList.getAlarmsPanel().setIconCls('s_alarm');
			var a = document.getElementById('wave.alarm');
			a.pause();
			this.getAlarmsPanel().hide();
		}
		// ronyao.gis.layoutGis();
	},

	// 点击告警
	alarmClick : function(view, selections, options) {
		// 如果没有选择，就退出
		if (selections[0] == undefined) {
			return;
		}
		
		var resId = selections[0].data.resid;
		Ext.Ajax.request({
			url:'controller/queryGisResInfoByResId',
			params:{
				resId:resId
			},
			success:function(response,options){
				var rvText = Ext.JSON.decode(response.responseText);
				var baseLayerId = ronyao.gis.map.baseLayer.layerId;
				
				var flag = 0;
				var resources = rvText.Resources;
				var resId=null,layerId=null,layerId1=null;
				if(resources){
					layerId1 = resources[0].layerId;
					resId = resources[0].resId;
					for(var i=0,len=resources.length;i<len;i++){
						layerId = resources[i].layerId;
						if(baseLayerId == layerId){
							ronyao.gis.highLight(resId);
							flag = 1;
							break;
						}
					}
					if(flag!=1){
						ronyao.gis.useResId=1;
						ronyao.gis.highLightByIdAndLayer(resId,layerId1);
					}
				}
			}
		});	

		var detailPanel = this.getAlarmsPanel().items.items[1];

		var date = new Date(selections[0].data.time * 1000);
		
		var value;
		//201为goose告警
		if(201 == selections[0].data.type){
			//value = ry.constant.trans(selections[0].data.parm, ry.constant.gooseAlarmType);
			value = '开关变位';
		} else {
			value = selections[0].data.parm;
		}
		
		var data = {
			aTime : Ext.Date.format(date, 'Y-m-d G:i:s'),
			atName : ry.constant.trans(selections[0].data.type, ry.constant.almtype),
			aValue : value,
			aResName : controller.viewResGrid.getResStore().data.getByKey(selections[0].data.resid).data.name
			
		};

		detailPanel.items.items[0].update(data);

		// 显示关联摄像机
		detailPanel.items.items[1].store.load({
			params : {
				resid : selections[0].data.resid,
				type : selections[0].data.type
			}
		});
	},

	// 一个摄像机被点击
	cameraClick : function(grid, record, item, index, e, options) {
		controller.gisVideo.onResourceSelect(record.data.target, 1);
	}
});
