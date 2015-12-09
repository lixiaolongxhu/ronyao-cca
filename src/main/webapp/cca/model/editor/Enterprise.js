/**企业基本信息管理.
 * 
 */
Ext.define('RYIVS.model.editor.Enterprise', {
	extend : 'Ext.data.Model',
	fields : [ 
		{name: 'id', type: 'int',	sortable : true},
		{name: 'supervisorunit', type: 'string',	sortable : true},
		{name: 'name', type: 'string',	sortable : true},
		{name: 'fullname', type: 'string',	sortable : true},
		{name: 'property', type: 'int',	sortable : true},
		{name: 'register', type: 'int',	sortable : true},
		{name: 'assets', type: 'int',	sortable : true},
		{name: 'workers', type: 'int',	sortable : true},
		{name: 'overallrank', type: 'int',	sortable : true},
		{name: 'professionrank', type: 'int',	sortable : true},
		{name: 'output', type: 'int',	sortable : true},
		{name: 'project', type: 'int',	sortable : true},
		{name: 'createtime', type: 'string',	sortable : true},
		{name: 'updatetime', type: 'string',	sortable : true}
	],
	
	
	//每个model 必须得有一个验证,保证添加,修改时参数不会向后台重复添加
	validations : [ {
		type : 'length',
		field : 'fullname',
		min : 1
	}]
	
	
	
	
	
	
	
});
