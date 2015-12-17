

Ext.define('RYIVS.store.editor.EnterpriseAssess', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.editor.EnterpriseAssess',
	// 是否自动加载
	autoLoad : true,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionEnterpAssess.read,
			create :  actionEnterpAssess.create,
			update :  actionEnterpAssess.update,
			destroy : actionEnterpAssess.destroy
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