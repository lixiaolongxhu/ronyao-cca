

Ext.define('RYIVS.store.editor.ProjectNoBuild', {
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
				read : 	  actionProjectBuild.readNoBuild,
				create :  actionProjectBuild.createNoBuild,
				update :  actionProjectBuild.updateNoBuild,
				destroy : actionProjectBuild.destroyNoBuild
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