//Model
Ext.define('RYIVS.model.editor.Controller', {
	extend : 'Ext.data.Model',
	fields : [ 'id', 'no', 'type', 'ip', 'port', 'user', 'pass', 'name'],
	validations : [ {
		type : 'format',
		field : 'ip',
		matcher : /^((25[0-5])|(2[0-4]\d)|(1\d\d)|([1-9]\d)|\d)(\.((25[0-5])|(2[0-4]\d)|(1\d\d)|([1-9]\d)|\d)){3}$/
	} ],
	proxy : {
		type : 'direct',
		api : {
			read : actionEquipment.readEqp,
			create : actionEquipment.createEqp,
			update : actionEquipment.updateEqp,
			destroy : actionEquipment.destroyEqp
		},
		extraParams:{
			type : 2
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