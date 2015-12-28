

Ext.define('RYIVS.store.editor.ProjectBuilding', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.editor.ProjectBuild',
	// 是否自动加载
	autoLoad : false,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
			read : 	  actionProjectBuild.readBuilding,
			create :  actionProjectBuild.createBuilding,
			update :  actionProjectBuild.updateBuilding,
			destroy : actionProjectBuild.destroyBuilding
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