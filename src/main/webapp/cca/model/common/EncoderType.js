//温湿度曲线
Ext.define('RYIVS.model.common.EncoderType', {
	extend : 'Ext.data.Model',
	fields : [ 'id', 'name' ],
	proxy : {
		type : 'direct',
		batchActions : false,
		api : {
			read : actionEncoderType.read
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