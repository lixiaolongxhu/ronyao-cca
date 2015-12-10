
Ext.define('RYIVS.model.editor.EnterpriseApt', {
	extend : 'Ext.data.Model',
	fields : [ 
		{name: 'id', type: 'int',	sortable : true},
		{name: 'aptitudeid', type: 'int',	sortable : true},
		{name: 'aptituderank', type: 'int',	sortable : true},
		{name: 'qualifications', type: 'string',	sortable : true},
		{name: 'practicing', type: 'string',	sortable : true},
		{name: 'charge', type: 'string',	sortable : true},
		{name: 'technical', type: 'string',	sortable : true},
		{name: 'skills', type: 'string',	sortable : true},
		{name: 'jobrange', type: 'string',	sortable : true},
		{name: 'createtime', type: 'string',	sortable : true},
		{name: 'updatetime', type: 'string',	sortable : true}
	],
	
	
	//每个model 必须得有一个验证,保证添加,修改时参数不会向后台重复添加
	validations : [ {
		type : 'format',
		field : 'aptitudeid',
		matcher: /[1-9]\d*/  //正则表达式 ,近允许输入大于0的整数
		},{
		type : 'length',
		field : 'qualifications',
		min: 1  
		
	}]
	
	
	
	
	
	
	
});
