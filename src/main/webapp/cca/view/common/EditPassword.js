Ext.require([
    'Ext.direct.*',
    'Ext.form.*',
    'Ext.tip.QuickTipManager',
    'Ext.layout.container.Accordion'
]);

Ext.define('RYIVS.view.common.EditPassword', {
	extend : 'Ext.window.Window',
	alias : 'widget.editPasswrod',
	iconCls : 's_key',
	height : 130,
	width : 300,
	resizable : false,
	modal : true,
	layout : {
		type : "fit"
	},
	title : "密码修改",
	items : [ {
		xtype : "form",
		bodyPadding : 10,
		items : [ {
			xtype : "textfield",
			val : 1,
			anchor : "100%",
			inputType : "password",
			fieldLabel : "新密码",
			allowBlank : false,
			blankText : '请输入新密码',
			// 键盘监听
			enableKeyEvents : true,
			labelAlign : "right"
		}, {
			xtype : "textfield",
			val : 2,
			anchor : "100%",
			inputType : "password",
			name : 'passwd',
			fieldLabel : "确认密码",
			allowBlank : false,
			blankText : '请再次输入密码',
			// 键盘监听
			enableKeyEvents : true,
			labelAlign : "right"
		} ],
		
		api : {
			submit : actionUser.updatePwd			
		},
		
		paramOrder: ['id', 'passwd'],
		
		buttons : [ {
			text : "确认",
			formBind: true,
			btn : 1
		}, {
			text : "取消",
			btn : 2
		} ]
	} ]
});