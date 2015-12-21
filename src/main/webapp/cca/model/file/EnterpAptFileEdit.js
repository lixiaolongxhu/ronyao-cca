
Ext.define('RYIVS.model.file.EnterpAptFileEdit', {
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
	]
	
//	validations : [
//	{
//		type : 'length',
//		field : 'loginname',
//		min : 4
//	},
//	{
//		type : 'length',
//		field : 'password',
//		min : 4
//	}
//	]
	

});
