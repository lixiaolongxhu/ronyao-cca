/**
 * author : tqd
 * model : 预置点
 */
Ext.define('RYIVS.model.video.PtzPos', {
	extend : 'Ext.data.Model',
	fields : [ 
		{name: 'id',  type: 'int'},
        {name: 'resid',   type: 'int'},
        {name: 'pos', type: 'string'},
        {name: 'name', type: 'string'}
	],
	
	proxy : {
		type : 'direct',
		api : {
			read : actionPtzPos.read,
//			create : actionPtzPos.create,
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