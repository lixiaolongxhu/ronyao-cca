//Model
Ext.define('RYIVS.model.common.Alarms', {
	extend : 'Ext.data.Model',
	fields : [ 'id', 'resid', 'time', 'type', 'parm' ],
	proxy : {
		type : 'direct',
		api : {
			read : actionAlarm.read
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