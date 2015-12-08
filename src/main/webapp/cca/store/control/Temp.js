Ext.define('RYIVS.store.control.Temp', {
	extend : 'Ext.data.Store',
	model : 'RYIVS.model.control.Temp',

	proxy : {
		type : 'direct',
		api : {
			read : actionDataInstant.read
		},
		timeout : 2000,
		
		reader : {
			type : 'json',
			root : 'records'
		},

		writer : {
			type : 'json'
		}
	}
});
