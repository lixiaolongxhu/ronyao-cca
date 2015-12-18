
Ext.define('RYIVS.model.editor.ProjectBuild', {
	extend : 'Ext.data.Model',
	fields : [ 
		{name: 'id', type: 'int',	sortable : true},
		{name: 'enterpriseid', type: 'int',	sortable : true},
		{name: 'supervisorunit', type: 'string',	sortable : true},
		{name: 'year', type: 'int',	sortable : true},
		{name: 'classify', type: 'int',	sortable : true},
	
		{name: 'line110kv', type: 'int',	sortable : true},
		{name: 'line220kv', type: 'int',	sortable : true },
		{name: 'line500kv', type: 'int',	sortable : true},
		{name: 'power110kv', type: 'int',	sortable : true},
		{name: 'power220kv', type: 'int',	sortable : true},
		{name: 'power500kv', type: 'int',	sortable : true},
		
		{name: 'createtime', type: 'string',	sortable : true},
		{name: 'updatetime', type: 'string',	sortable : true}
	]
	,
	
	
	//每个model 必须得有一个验证,保证添加,修改时参数不会向后台重复添加
	validations : [ {
		type : 'format',
		field : 'enterpriseid',
		matcher: /[1-9]\d*/  //正则表达式 ,近允许输入大于0的整数
		  
		
	},
	 {
		type : 'format',
		field : 'year',
		matcher: /[1-9]\d*/  //正则表达式 ,近允许输入大于0的整数
		  
		
	}
	
	]
	
	
	
	
	
	
	
});
