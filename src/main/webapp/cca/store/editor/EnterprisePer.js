
/**
 * 
 */
Ext.define('RYIVS.store.editor.EnterprisePer', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.editor.EnterprisePer',
	// 是否自动加载
	autoLoad : true,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionEnterprisePer.read,
			create :  actionEnterprisePer.create,
			update :  actionEnterprisePer.update,
			destroy : actionEnterprisePer.destroy
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