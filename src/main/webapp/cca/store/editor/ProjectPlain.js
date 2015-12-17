

Ext.define('RYIVS.store.editor.ProjectPlain', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.editor.ProjectPlain',
	// 是否自动加载
	autoLoad : true,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionProjectPlain.read,
			create :  actionProjectPlain.create,
			update :  actionProjectPlain.update,
			destroy : actionProjectPlain.destroy
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