

Ext.define('RYIVS.store.editor.BehaviorSta', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.editor.BehaviorSta',
	// 是否自动加载
	autoLoad : false,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionBehaviorSta.read,
			create :  actionBehaviorSta.create,
			update :  actionBehaviorSta.update,
			destroy : actionBehaviorSta.destroy
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