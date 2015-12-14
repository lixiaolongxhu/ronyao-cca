
Ext.define('RYIVS.model.editor.Behavior', {
	extend : 'Ext.data.Model',
	fields : [ 
		{name: 'id', type: 'int',	sortable : true},
		{name: 'enterpriseid', type: 'int',	sortable : true},
		{name: 'year', type: 'int',	sortable : true},
		{name: 'generalbadnum', type: 'int',	sortable : true},
		{name: 'seriousbadnum', type: 'int',	sortable : true},
		{name: 'correction', type: 'float',	sortable : true},
		{name: 'createtime', type: 'string',	sortable : true},
		{name: 'updatetime', type: 'string',	sortable : true}
	],
	
	
	//每个model 必须得有一个验证,保证添加,修改时参数不会向后台重复添加
	validations : [ {
		type : 'format',
		field : 'enterpriseid',
		matcher: /[1-9]\d*/  //正则表达式 ,近允许输入大于0的整数
	}]
	
	
	
});
