
Ext.define('RYIVS.model.editor.BehaviorSta', {
	extend : 'Ext.data.Model',
	fields : [ 
		{name: 'id', type: 'int',	sortable : true},
		{name: 'ranktype', type: 'int',	sortable : true},
		{name: 'sincerity', type: 'string',	sortable : true},
		{name: 'save', type: 'string',	sortable : true},
		{name: 'progress', type: 'string',	sortable : true},
		{name: 'service', type: 'string',	sortable : true},
		{name: 'other', type: 'string',	sortable : true},	
		{name: 'createtime', type: 'string',	sortable : true},
		{name: 'updatetime', type: 'string',	sortable : true}
	],
	
	
	//每个model 必须得有一个验证,保证添加,修改时参数不会向后台重复添加
	validations : [ {
		type : 'format',
		field : 'ranktype',
		matcher: /[1-9]\d*/  //正则表达式 ,近允许输入大于0的整数
		},{
		type : 'length',
		field : 'sincerity',
		min: 1  
		
	}]
	
	
	
	
	
	
	
});
