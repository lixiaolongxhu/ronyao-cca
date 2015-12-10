

Ext.define('RYIVS.store.editor.EquipmentBear', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.editor.EquipmentBear',
	// 是否自动加载
	autoLoad : true,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionEquipmentBear.read,
			create :  actionEquipmentBear.create,
			update :  actionEquipmentBear.update,
			destroy : actionEquipmentBear.destroy
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