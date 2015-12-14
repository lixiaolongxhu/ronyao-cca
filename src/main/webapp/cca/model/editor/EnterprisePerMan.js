
Ext.define('RYIVS.model.editor.EnterprisePerMan', {
	extend : 'Ext.data.Model',
	fields : [ 
		{name: 'id', type: 'int',	sortable : true},
		{name: 'enterpriseid', type: 'int',	sortable : true},
		{name: 'professiontype', type: 'int',	sortable : true},
		{name: 'onemanager', type: 'int',	sortable : true, defaultValue :1},
		{name: 'twomanager', type: 'int',	sortable : true, defaultValue :1},
		{name: 'onechief', type: 'int',	sortable : true, defaultValue :1},
		{name: 'twochief', type: 'int',	sortable : true, defaultValue :1},
		{name: 'safetyofficer', type: 'int',	sortable : true, defaultValue :1},
		{name: 'inspector', type: 'int',	sortable : true, defaultValue :1},
		{name: 'technician', type: 'int',	sortable : true, defaultValue :1},
		{name: 'costmember', type: 'int',	sortable : true, defaultValue :1},
		{name: 'documenter', type: 'int',	sortable : true, defaultValue :1},
		{name: 'integrator', type: 'int',	sortable : true, defaultValue :1},
		{name: 'material', type: 'int',	sortable : true, defaultValue :1},
		{name: 'expeditor', type: 'int',	sortable : true, defaultValue :1},
		{name: 'constructionteam', type: 'int',	sortable : true, defaultValue :1},
		{name: 'plurality', type: 'int',	sortable : true, defaultValue :1},
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
