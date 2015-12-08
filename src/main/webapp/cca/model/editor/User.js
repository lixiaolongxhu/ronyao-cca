/**
 * 用户管理
 */
Ext.define('RYIVS.model.editor.User', {
	extend : 'Ext.data.Model',
	fields : [ 'id', 'rank', 'uname', 'passwd', 'type', 'rname', 'telephone', 'mobile'],
	
	validations : [ {
		type : 'length',
		field : 'uname',
		min : 1
	}],
	
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
