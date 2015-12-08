//Model
Ext.define('RYIVS.model.editor.AlarmRule', {
	extend : 'Ext.data.Model',
	fields : [ 
		'id', 'resid', 'almType', 'name'
		//{name:'type',defaultValue: 1} 
	],
	validations : [ {
		type : 'length',
		field : 'name',
		min : 1
	} ],
	proxy : {
		type : 'direct',
		api : {
			read : actionAlarmRule.read,
			create : actionAlarmRule.create,
			update : actionAlarmRule.update,
			destroy : actionAlarmRule.destroy
		},
		//extraParams : {'type':1},
		reader : {
			type : 'json',
			root : 'records'
		},

		writer : {
			type : 'json'
		}
	}
});