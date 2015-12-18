

Ext.define('RYIVS.store.display.ProjectBuildBear', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.display.ProjectBuildBear',
	// 是否自动加载
	autoLoad : true,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionProjectBuildBear.read
//			,
//			create :  actionAnnualOutput.create,
//			update :  actionAnnualOutput.update,
//			destroy : actionAnnualOutput.destroy
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