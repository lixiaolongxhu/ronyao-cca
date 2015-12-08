
Ext.define('RYIVS.store.editor.UserLog', {
	extend : 'Ext.data.Store',
	model : 'RYIVS.model.editor.UserLog',
//	autoLoad : true,
	autoSync : true,
	proxy : {
		type : 'direct',
		api : {
			read : actionUserLog.read,
			destroy : actionUserLog.destroy
		},

		reader : {
			type : 'json',
			root : 'records'
		},

		writer : {
			type : 'json'
		}
	},
	pageSize:36
	
})