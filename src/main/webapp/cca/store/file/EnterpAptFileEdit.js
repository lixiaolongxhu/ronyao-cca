
Ext.define('RYIVS.store.file.EnterpAptFileEdit', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.file.EnterpAptFileEdit',
	// 是否自动加载
	autoLoad : true,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionEnterpFile.read,
			create :  actionEnterpFile.create,
			update :  actionEnterpFile.update,
			destroy : actionEnterpFile.destroy
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