/**企业人员信息.
 * 
 */
Ext.define('RYIVS.model.editor.EnterprisePer', {
	extend : 'Ext.data.Model',
	fields : [ 
		{name: 'id', type: 'int',	sortable : true},
		{name: 'enterpriseid', type: 'int',	sortable : true},
		{name: 'constructorone', type: 'int',	sortable : true},
		{name: 'constructortwo', type: 'int',	sortable : true},
		{name: 'constructortotal', type: 'int',	sortable : true},
		{name: 'staffmiddle', type: 'int',	sortable : true},
		{name: 'staffhigh', type: 'int',	sortable : true},
		{name: 'stafftotal', type: 'int',	sortable : true},
		{name: 'skillmiddle', type: 'int',	sortable : true},
		{name: 'skillhigh', type: 'int',	sortable : true},
		{name: 'skilltech', type: 'int',	sortable : true},
		{name: 'skilltechhigh', type: 'int',	sortable : true},
		{name: 'skilltotal', type: 'int',	sortable : true},
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
