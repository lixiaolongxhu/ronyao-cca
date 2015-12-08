/**
 * 定位点管理
 */
Ext.define('RYIVS.model.editor.Rfid', {
	extend : 'Ext.data.Model',
	fields : [ 'id', 'eid', 'type', 'node', 'uid', 'name', 'ext1', 'ext2', 'resid' ],
	validations : [ {
		type : 'length',
		field : 'uid',
		min : 10
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
			masterId : 0
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
