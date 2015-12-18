
Ext.define('RYIVS.model.editor.ProjectPlain', {
	extend : 'Ext.data.Model',
	fields : [ 
		{name: 'id', type: 'int',	sortable : true},
		{name: 'voltagerankclassifyid', type: 'int',	sortable : true},
		{name: 'year', type: 'int',	sortable : true},
		{name: 'projectnum', type: 'int',	sortable : true},
	
		{name: 'lineproject', type: 'int',	sortable : true},
		{name: 'powerproject', type: 'int',	sortable : true },
		{name: 'assesslineproject', type: 'int',	sortable : true},
		{name: 'assesspowerproject', type: 'int',	sortable : true},
		{name: 'linelength', type: 'int',	sortable : true},
		{name: 'volume', type: 'int',	sortable : true},
		{name: 'investment', type: 'float',	sortable : true},
		
		
		{name: 'createtime', type: 'string',	sortable : true},
		{name: 'updatetime', type: 'string',	sortable : true}
	]
	,
	
	
	//每个model 必须得有一个验证,保证添加,修改时参数不会向后台重复添加
	validations : [ {
		type : 'format',
		field : 'voltagerankclassifyid',
		matcher: /[1-9]\d*/  //正则表达式 ,近允许输入大于0的整数
		  
		
	},
	 {
		type : 'format',
		field : 'year',
		matcher: /[1-9]\d*/  //正则表达式 ,近允许输入大于0的整数
		  
		
	}
	
	]
	
	
	
	
	
	
	
});
