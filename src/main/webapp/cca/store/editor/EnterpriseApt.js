

Ext.define('RYIVS.store.editor.EnterpriseApt', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.editor.EnterpriseApt',
	// 是否自动加载
	autoLoad : false,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionEnterpApt.read,
			create :  actionEnterpApt.create,
			update :  actionEnterpApt.update,
			destroy : actionEnterpApt.destroy
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