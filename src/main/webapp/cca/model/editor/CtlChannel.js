//Model
Ext.define('RYIVS.model.editor.CtlChannel', {
	extend : 'Ext.data.Model',
	fields : [ 'id', 'eid', 'type', 'node', 'uid', 'name', 'ext1', 'ext2', 'resid' ],
	validations : [ {
		type : 'length',
		field : 'name',
		min : 1
	} ],
	proxy : {
		type : 'direct',
		api : {
			read : actionEquipment.readEqpCha,
			create : actionEquipment.createEqpCha,
			update : actionEquipment.updateEqpCha,
			destroy : actionEquipment.destroyEqpCha
		},
		extraParams:{
			type : 2
		},
		reader : {
			type : 'json',
			root : 'records',
		},

		writer : {
			type : 'json'
		}
	}
});