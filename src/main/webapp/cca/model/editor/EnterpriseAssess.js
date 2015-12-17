
Ext.define('RYIVS.model.editor.EnterpriseAssess', {
	extend : 'Ext.data.Model',
	fields : [ 
		{name: 'id', type: 'int',	sortable : true},
		{name: 'category', type: 'string',	sortable : true},
		{name: 'standard', type: 'string',	sortable : true},
		{name: 'projectnumstart', type: 'string',	sortable : true},
		{name: 'projectnumend', type: 'string',	sortable : true},
	
		{name: 'outputstart', type: 'string',	sortable : true},
		{name: 'outputend', type: 'string',	sortable : true},
		
		{name: 'enterprise', type: 'string',	sortable : true},
	
		{name: 'createtime', type: 'string',	sortable : true},
		{name: 'updatetime', type: 'string',	sortable : true}
	],
	
	
	//每个model 必须得有一个验证,保证添加,修改时参数不会向后台重复添加
	validations : [ {
		type : 'length',
		field : 'category',
		min : 1
	}]
	
	
	
	
	
	
	
});
