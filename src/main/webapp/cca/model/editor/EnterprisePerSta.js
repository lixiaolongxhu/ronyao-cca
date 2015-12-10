
Ext.define('RYIVS.model.editor.EnterprisePerSta', {
	extend : 'Ext.data.Model',
	fields : [ 
		{name: 'id', type: 'int',	sortable : true},
		{name: 'postclassifyid', type: 'int',	sortable : true},
		{name: 'holderrequire', type: 'strint',	sortable : true},
		{name: 'lineflatnum', type: 'int',	sortable : true, defaultValue :1},
		{name: 'linemountainnum', type: 'int',	sortable : true, defaultValue :1},
		{name: 'powernum', type: 'int',	sortable : true, defaultValue :1},
		{name: 'job', type: 'int',	sortable : true},
		{name: 'remark', type: 'string',	sortable : true},
		{name: 'createtime', type: 'string',	sortable : true},
		{name: 'updatetime', type: 'string',	sortable : true}
	],
	
	
	//每个model 必须得有一个验证,保证添加,修改时参数不会向后台重复添加
	validations : [ {
		type : 'format',
		field : 'postclassifyid',
		matcher: /[1-9]\d*/  //正则表达式 ,近允许输入大于0的整数
		  
		
	}]
	
	
	
	
	
	
	
});
