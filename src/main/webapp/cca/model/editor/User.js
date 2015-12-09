/**
 * 用户管理
 */
Ext.define('RYIVS.model.editor.User', {
	extend : 'Ext.data.Model',
	fields : [ 'id', 'loginname', 'password'],
	
	validations : [
	{
		type : 'length',
		field : 'loginname',
		min : 4
	},
	{
		type : 'length',
		field : 'password',
		min : 4
	}
	]
	

});
