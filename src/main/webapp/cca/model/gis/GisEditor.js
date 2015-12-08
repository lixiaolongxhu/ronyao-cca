/**
 * 定位器管理
 */
Ext.define('RYIVS.model.gis.GisEditor', {
	extend : 'Ext.data.Model',
	fields : [ 'id', 'resid', 'layer', 'type', 'style', 'data' ],
	proxy : {
		type : 'direct',
		api : {
			read : actionGisRes.read,
			create : actionGisRes.create,
			update : actionGisRes.update,
			destroy : actionGisRes.destroy
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
