//播放器的对象
Ext.define('RYIVS.view.common.Login', {
	extend : 'Ext.window.Window',
	alias : 'widget.winlogin',
	title : '用户登录',
	width : 300,
	iconCls : 's_user',
	closable : false,
	resizable : false,
	defaults : {
		border : false
	},

	buttonAlign : 'center',

	items : [ {
		xtype : 'form',
		id : 'loginForm',
		bodyStyle : 'padding-top:20px',
		defaultType : 'textfield',
		labelAlign : 'right',
		height : 100,
		frame : true,
		defaults : {
			allowBlank : false,
			autowidth : true,
			width : 210
		},

		items : [ {
			xtype : 'textfield',
			fieldLabel : '用户名',
			labelAlign : 'right',
			cls : 'username',
			name : 'username',
			blankText : '用户名不能为空！',
			// 键盘监听
			enableKeyEvents : true,
			//value : 'admin'
		}, {
			xtype : 'textfield',
			fieldLabel : '密　码',
			labelAlign : 'right',
			cls : 'password',
			name : 'password',
			inputType : 'password',
			blankText : '密码不能为空！',
			// 键盘监听
			enableKeyEvents : true,
			//value : 'admin'
		} ]
	} ],

	buttons : [ {
		text : "登录",
		icon : 'res/icon/login.png',
		id : 'login',
		type : "sub"
	}, {
		text : "重置",
		type : 'reset',
		icon : 'res/icon/sync.png'
	} ],

	initComponent : function() {
		this.callParent(arguments);
	}
});
