

Ext.define('RYIVS.store.editor.EnterprisePerSta', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.editor.EnterprisePerSta',
	// 是否自动加载
	autoLoad : true,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionEnterprisePerSta.read,
			create :  actionEnterprisePerSta.create,
			update :  actionEnterprisePerSta.update,
			destroy : actionEnterprisePerSta.destroy
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