
Ext.define('RYIVS.model.file.EnterpPerFileEdit', {
	extend : 'Ext.data.Model',
	fields : [ 
		
		{name: 'id', type: 'int',	sortable : true},
		{name: 'enterpriseid', type: 'int',	sortable : true},
		{name: 'enterpriseperid', type: 'int',	sortable : true},
		{name: 'classify', type: 'string',	sortable : true},
		{name: 'rank', type: 'string',	sortable : true},
		{name: 'path', type: 'string',	sortable : true},
		{name: 'filetype', type: 'int',	sortable : true},
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
