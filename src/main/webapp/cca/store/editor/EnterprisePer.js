
/**
 * 
 */
Ext.define('RYIVS.store.editor.EnterprisePer', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.editor.EnterprisePer',
	// 是否自动加载
	autoLoad : false,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionEnterpPer.read,
			create :  actionEnterpPer.create,
			update :  actionEnterpPer.update,
			destroy : actionEnterpPer.destroy
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