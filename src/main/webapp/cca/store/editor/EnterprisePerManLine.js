
/**施工企业现场人员(线路专业)
 * 
 */
Ext.define('RYIVS.store.editor.EnterprisePerManLine', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.editor.EnterprisePerMan',
	// 是否自动加载
	autoLoad : false,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionEnterpPerManLine.read,
			create :  actionEnterpPerManLine.create,
			update :  actionEnterpPerManLine.update,
			destroy : actionEnterpPerManLine.destroy
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