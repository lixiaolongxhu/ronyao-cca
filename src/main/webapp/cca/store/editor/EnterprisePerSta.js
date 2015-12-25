

Ext.define('RYIVS.store.editor.EnterprisePerSta', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.editor.EnterprisePerSta',
	// 是否自动加载
	autoLoad : false,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionEnterpPerSta.read,
			create :  actionEnterpPerSta.create,
			update :  actionEnterpPerSta.update,
			destroy : actionEnterpPerSta.destroy
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