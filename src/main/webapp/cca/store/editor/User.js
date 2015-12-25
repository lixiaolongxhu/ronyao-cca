
Ext.define('RYIVS.store.editor.User', {
	extend : 'Ext.data.Store',
	model : 'RYIVS.model.editor.User',
	// 是否自动加载
	autoLoad : false,
	//store 与后台数据自动同步
    autoSync : true,
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
})