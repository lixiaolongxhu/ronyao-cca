
Ext.define('RYIVS.model.display.BearContrastProOutput', {
	extend : 'Ext.data.Model',
	
	/**fields  type
	 * auto (默认值, 意味着无convert方法)
		string
		int
		float
		boolean
		date
	 */
	fields : [ 
		{name: 'supervisorunit', type: 'string',	sortable : true},
		{name: 'enterpriseName', type: 'string',	sortable : true},
		{name: 'outputSum', type: 'int',	sortable : true},
		{name: 'treeYearOutputAverage', type: 'int',	sortable : true},
	
		{name: 'constrast', type: 'int',	sortable : true}
	]
//	,
	
//	//每个model 必须得有一个验证,保证添加,修改时参数不会向后台重复添加
//	validations : [ {
//		type : 'format',
//		field : 'voltagerankid',
//		matcher: /[1-9]\d*/  //正则表达式 ,近允许输入大于0的整数
//		  
//		
//	},
//	{
//		type : 'format',
//		field : 'projecttype',
//		matcher: /[1-9]\d*/  //正则表达式 ,近允许输入大于0的整数
//		  
//		
//	}
//	
//	]
	
	
	
	
	
	
	
});
