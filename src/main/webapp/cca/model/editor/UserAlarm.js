//Model
Ext.define('RYIVS.model.editor.UserAlarm', {
	extend : 'Ext.data.Model',
	fields : [ 'id', 'uid', 'almtype', 'sendtype' ],
	proxy : {
		type : 'direct',
		api : {
			read : actionUserAlarm.read,
			create : actionUserAlarm.create,
			update : actionUserAlarm.update,
			destroy : actionUserAlarm.destroy
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