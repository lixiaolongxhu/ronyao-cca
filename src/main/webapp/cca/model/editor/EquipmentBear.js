
Ext.define('RYIVS.model.editor.EquipmentBear', {
	extend : 'Ext.data.Model',
	fields : [ 
		{name: 'id', type: 'int',	sortable : true},
		{name: 'name', type: 'string',	sortable : true},
		{name: 'voltagerankid', type: 'int',	sortable : true},
		{name: 'linetype', type: 'int',	sortable : true},
		{name: 'lineplain', type: 'int',	sortable : true, defaultValue :1},
		{name: 'linebrae', type: 'int',	sortable : true, defaultValue :1},
		{name: 'explains', type: 'String',	sortable : true},
		{name: 'createtime', type: 'string',	sortable : true},
		{name: 'updatetime', type: 'string',	sortable : true}
	]
	,
	
	
	//每个model 必须得有一个验证,保证添加,修改时参数不会向后台重复添加
	validations : [ {
		type : 'format',
		field : 'voltagerankid',
		matcher: /[1-9]\d*/  //正则表达式 ,近允许输入大于0的整数
		  
		
	},
	{
		type : 'length',
		field : 'name',
		min:  1
		  
		
	}
	
	]
	
	
	
	
	
	
	
});
