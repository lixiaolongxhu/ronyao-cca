//温湿度曲线
Ext.define('RYIVS.model.common.ResourceTypeCat', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'id',
		mapping : 'type'
	}, 'cat' ],
	proxy : {
		type : 'direct',
		batchActions : false,
		api : {
			read : actionResourceTypeCat.read
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