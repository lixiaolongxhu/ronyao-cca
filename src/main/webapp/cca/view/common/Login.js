//登陆界面
Ext.define('RYIVS.view.common.Login', {
	extend : 'Ext.form.FormPanel',
	alias : 'widget.loginForm',
	title : '用户登录',
	iconCls : 's_user',
                                
	id: 'loginForm',
           
    border: false,// 没有边框
    frame: true,
  
    style: { //formpanel位置  
          marginRight: document.documentElement.clientWidth-document.documentElement.clientWidth*0.81,
          marginLeft: document.documentElement.clientWidth-document.documentElement.clientWidth*0.4,
          marginTop: document.documentElement.clientHeight-document.documentElement.clientHeight*0.65,
          marginBottom: document.documentElement.clientHeight-document.documentElement.clientHeight*0.7
    },
    //文本框的宽度配置
    defaults: { 
    	style : {
    		marginTop  : '30px',
    		marginLeft :'20px',
    		marginRight :'20px',
    		marginBottom  :'20px'
    	},
  	    xtype: 'textfield' ,
   		labelSeparator :'：',//分隔符

	    labelWidth : 50,//标签宽度


		allowBlank : false,//是否允许为空
		autowidth : true,
		
		width: 210,//字段宽度

		blankText : '不允许为空',

		labelAlign : 'right'//标签对齐方式
	},
	
	items : [ {
		
			xtype : 'textfield',
			fieldLabel : '用户名',
			labelAlign : 'right',
			cls : 'username',
			name : 'username',
			blankText : '用户名不能为空！',
			// 键盘监听
			enableKeyEvents : true
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
			enableKeyEvents : true
			//value : 'admin'
	}],
	
	buttonAlign : 'center',
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
