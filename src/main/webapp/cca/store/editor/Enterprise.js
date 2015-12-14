
/**
 * 
 */
Ext.define('RYIVS.store.editor.Enterprise', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.editor.Enterprise',
	// 是否自动加载
	autoLoad : true,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionEnterp.read,
			create :  actionEnterp.create,
			update :  actionEnterp.update,
			destroy : actionEnterp.destroy
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