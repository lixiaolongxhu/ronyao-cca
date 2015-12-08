/**
 * 用户日志的模型类  提供了对日志的查询和删除操作
 */
Ext.define('RYIVS.model.editor.UserLog',{
	extend:'Ext.data.Model',
	fields:['id','uid','userAction','operateTime','ipAddress','commentInfo']
});
