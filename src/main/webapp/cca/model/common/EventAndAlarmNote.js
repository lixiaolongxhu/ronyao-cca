/*
 * 报警意见
 */
Ext.define('RYIVS.model.common.EventAndAlarmNote', {
	extend : 'Ext.data.Model',

	proxy : {
		type : 'direct',
		api : {
			read : actionEvent.getAlmNoteByAlmId
		},
		reader : {
			root : 'records',// 返回结果集
			type : 'json'
		}
	}
});