
/**施工企业现场人员(变电专业)
 * 
 */
Ext.define('RYIVS.store.editor.EnterprisePerManPower', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.editor.EnterprisePerMan',
	// 是否自动加载
	autoLoad : true,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionEnterpPerManPower.read,
			create :  actionEnterpPerManPower.create,
			update :  actionEnterpPerManPower.update,
			destroy : actionEnterpPerManPower.destroy
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