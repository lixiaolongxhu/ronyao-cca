Ext.define('RYIVS.store.control.wind', {
	extend : 'Ext.data.Store',
	model : 'RYIVS.model.control.wind',

	proxy : {
		type : 'ajax',
		url : 'action',
		reader : {
			type : 'json',
			root : 'root'
		},
		extraParams : {
			module : 'getWind'
		}
	},
	autoLoad : false
});
