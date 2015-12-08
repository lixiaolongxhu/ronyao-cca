//得到告警相关的视频
Ext.define('RYIVS.model.common.AlarmCamera', {
	extend : 'Ext.data.Model',
	fields : [ 'actionId', 'ruleId', 'almRes', 'almType', 'target', 'type', 'name' ],
	proxy : {
		type : 'direct',
		api : {
			read : actionAlarm.getTarget
		},
		reader : {
			type : 'json',
			root : 'records'
		},
		
		writer : {
			type : 'json'
		}
	}
});