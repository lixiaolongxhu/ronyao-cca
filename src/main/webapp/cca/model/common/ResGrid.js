//资源Grid
Ext.define('RYIVS.model.common.ResGrid', {
	extend : 'Ext.data.Model',
	fields : [ 'id', 'pid', 'cls', 'type', 'name', 'state', 'ord'],
	validations : [ {
		type : 'length',
		field : 'name',
		min : 1
	} ],
	proxy : {
		type : 'direct',
		api : {
			read : actionResource.read,
			create : actionResource.create,
			update : actionResource.update,
			destroy : actionResource.destroy
		},
		reader : {
			root : 'records',// 返回结果集
			type : 'json'
		}
	}
});