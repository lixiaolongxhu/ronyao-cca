
Ext.define('RYIVS.store.file.EnterpPerFileEdit', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.file.EnterpPerFileEdit',
	// 是否自动加载
	autoLoad : true,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionEnterpPerFile.read,
			create :  actionEnterpPerFile.create,
			update :  actionEnterpPerFile.update,
			destroy : actionEnterpPerFile.destroy
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