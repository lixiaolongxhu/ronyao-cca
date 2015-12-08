Ext.define('RYIVS.store.video.RuleActionPtzPos', {
	extend : 'Ext.data.Store',
	model : 'RYIVS.model.video.RuleActionPtzPos',
	
	proxy : {
		type : 'direct',
		api : {
			read : actionPtzPos.read,
			destroy : actionPtzPos.destroy,
			update : actionPtzPos.update
		},
		timeout : 2000,
		reader : {
			type : 'json',
			root : 'records'
		},
		writer : {
			type : 'json'
		}
	},
	autoLoad : false
});