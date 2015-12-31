Ext.define('RYIVS.controller.common.Login', {
	extend : 'Ext.app.Controller',
	views : ['common.Login'],

	refs : [{
		selector : 'loginForm',
		ref : 'form'
	}, {
		selector : 'loginForm textfield[name=username]',
		ref : 'username'
	}, {
		selector : 'loginForm textfield[name=password]',
		ref : 'password'
	}],

	init : function() {
		var me = this;
		this.control({
			'loginForm textfield' : {
				keydown : me.onKeydown
			},
			'loginForm button[type=sub]' : {
				click : me.onSubmit,
				dbclick : me.onSubmit
			},
			'loginForm button[type=reset]' : {
				click : me.onReset,
				dbclick : me.onReset
			}

		});
		//页面加载延时，聚焦于用户名组件;
		Ext.defer(function(){
			me.getUsername().focus(true);
		}, 400);
	},
	//监听按键
	onKeydown : function(view, event) {
		//回车键提交表单
		if(event.getKey() === 13) {
			this.onSubmit();
		}
	},
	//提交表单
	onSubmit : function() {
		var me = this;
	//	alert(this);
		me.getForm().submit({
			waitTitle : '登陆',
			waitMsg : '正在登陆',
			url : 'srv/login',
			method : 'post',
			success : function(form, formOwnerCt) {
				// console.log(form, formOwnerCt);
				location.href = "index.jsp";
			},
			failure : function(form, formOwnerCt) {
				Ext.Msg.show({
					title : '系统提示',
					msg : '用户名或密码错误！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.INFO
				});
			}
		})
	},
	//重置表单
	onReset : function() {
		var me = this;
		me.getUsername().setValue();
		me.getPassword().setValue();
	}
});
