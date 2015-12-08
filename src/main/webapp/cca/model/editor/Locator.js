/**
 * 定位器管理
 */
Ext.define('RYIVS.model.editor.Locator', {
	extend : 'Ext.data.Model',
	fields : [ 'id', 'no', 'name' ],
	validations : [ {
		type : 'length',
		field : 'no',
		min : 1
	}, {
		type : 'length',
		field : 'name',
		min : 1
	} ],
	proxy : {
		type : 'direct',
		api : {
			read : actionLocator.read,
			create : actionLocator.create,
			update : actionLocator.update,
			destroy : actionLocator.destroy
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
