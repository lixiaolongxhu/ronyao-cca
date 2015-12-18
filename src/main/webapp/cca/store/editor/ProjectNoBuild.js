

Ext.define('RYIVS.store.editor.ProjectNoBuild', {
	extend : 'Ext.data.Store',
	// Store所对应的模型
	model : 'RYIVS.model.editor.ProjectBuild',
	// 是否自动加载
	autoLoad : true,
	//store 与后台数据自动同步
    autoSync : true,

	proxy : {
		type : 'direct',
		api : {
				read : 	  actionProejctBuild.readNoBuild,
				create :  actionProejctBuild.createNoBuild,
				update :  actionProejctBuild.updateNoBuild,
				destroy : actionProejctBuild.destroyNoBuild
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