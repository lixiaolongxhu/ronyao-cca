/**
 * 用户管理
 */
Ext.define('RYIVS.model.editor.User', {
	extend : 'Ext.data.Model',
	fields : [ 'id', 'loginname', 'password'],
	
	
	proxy : {
		type : 'direct',
		api : {
			read : actionUser.read,
			create : actionUser.create,
			update : actionUser.update,
			destroy : actionUser.destroy
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
