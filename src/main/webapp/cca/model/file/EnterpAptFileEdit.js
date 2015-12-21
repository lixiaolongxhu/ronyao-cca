
Ext.define('RYIVS.model.file.EnterpAptFileEdit', {
	extend : 'Ext.data.Model',
	fields : [ 
		{name: 'id', type: 'int',	sortable : true},
		{name: 'enterpriseid', type: 'int',	sortable : true},
		{name: 'filetype', type: 'int',	sortable : true},
		{name: 'aptituderankid', type: 'int',	sortable : true},
		{name: 'aptitudeid', type: 'int',	sortable : true},
		{name: 'path', type: 'string',	sortable : true},
		
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
