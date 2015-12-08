//Model
Ext.define('RYIVS.model.editor.EventRule', {
	extend : 'Ext.data.Model',
	fields : [ 
		'id', 'resid', 'almType', 'name',  
		{name:'type',defaultValue: 2} 
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
		extraParams : {'type':2},
		reader : {
			type : 'json',
			root : 'records'
		},

		writer : {
			type : 'json'
		}
	}
});