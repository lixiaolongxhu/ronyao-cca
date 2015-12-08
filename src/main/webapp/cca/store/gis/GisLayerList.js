Ext.define('RYIVS.store.gis.GisLayerList', {
	extend : 'Ext.data.Store',
	model : 'RYIVS.model.gis.GisLayerList',
	autoLoad : true,
	autoSync : true,
	proxy : {
		type : 'direct',
		api : {
			read : actionLayerList.read,
			destroy : actionLayerList.destroy
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
