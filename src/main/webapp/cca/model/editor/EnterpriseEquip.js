
Ext.define('RYIVS.model.editor.EnterpriseEquip', {
	extend : 'Ext.data.Model',
	fields : [ 
		{name: 'id', type: 'int',	sortable : true},
		{name: 'enterpriseid', type: 'int',	sortable : true},
		{name: 'bigequipment', type: 'strint',	sortable : true},
		{name: 'smallequipment', type: 'int',	sortable : true},
		{name: 'sum', type: 'int',	sortable : true},
	
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
