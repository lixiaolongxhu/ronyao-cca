/*
 * 历史录像
 */
Ext.define('RYIVS.model.common.EventAndVideo', {
	extend : 'Ext.data.Model',

	proxy : {
		type : 'direct',
		api : {
			read : actionEvent.getEventAndVideoByRange
		},
		reader : {
			root : 'records',// 返回结果集
			type : 'json'
		}
	}
});