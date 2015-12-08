//温湿度曲线
Ext.define('RYIVS.model.common.TempWin', {
	extend : 'Ext.data.Model',
	fields : [ 'time', 'val1', 'val2' ],
	proxy : {
		type : 'direct',
		api : {
			read : actionDataHistory.read
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