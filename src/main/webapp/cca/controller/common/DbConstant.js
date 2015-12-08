//存放在数据库中的常量与配置
Ext.define('RYIVS.controller.common.DbConstant', {
	extend : 'Ext.app.Controller',
	stores : [ 'common.ResourceTypeCat', 'common.EncoderType' ],
	models : [ 'common.ResourceTypeCat', 'common.EncoderType' ],

	init : function() {

	}
});