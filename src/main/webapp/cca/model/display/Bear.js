
Ext.define('RYIVS.model.display.Bear', {
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
		{name: 'enterpriseid', type: 'int',	sortable : true},
		{name: 'line500kv', type: 'int',	sortable : true},
		{name: 'line220kv', type: 'int',	sortable : true},
		{name: 'line110kv', type: 'int',	sortable : true},
		{name: 'lineOutput', type: 'int',	sortable : true},
		{name: 'power500kv', type: 'int',	sortable : true},
		{name: 'power220kv', type: 'int',	sortable : true},
		{name: 'power110kv', type: 'int',	sortable : true},
		{name: 'powerOutput', type: 'int',	sortable : true},
		{name: 'outputSum', type: 'int',	sortable : true}
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
