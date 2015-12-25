

Ext.define('RYIVS.store.editor.EnterpriseEquip', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.editor.EnterpriseEquip',
	// 是否自动加载
	autoLoad : false,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionEnterpEquip.read,
			create :  actionEnterpEquip.create,
			update :  actionEnterpEquip.update,
			destroy : actionEnterpEquip.destroy
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