/**
 * 修改密码controller
 */
Ext.define('RYIVS.controller.common.EditPassword', {
	extend : 'Ext.app.Controller',
	requires: ['Ext.direct.Manager'],
	views : [ 'common.EditPassword' ],

	refs : [ {
		selector : 'editPasswrod form',
		ref : 'form'
	} ],

	init : function() {
		this.control({
			'editPasswrod button' : {
				click : this.onClick
			},
			'editPasswrod textfield' : {
				keydown : this.onKeydown
			}
		})
	},
	
	onKeydown : function(view, event) {
		//回车键提交表单
		if(event.getKey() === 13) {
			this.onSubmit(view.ownerCt);
		}
	},
	
	onClick : function(obj) {
		var form = obj.ownerCt.ownerCt,
			val = obj.btn;
			
		switch(val) {
			case 1:
				this.onSubmit(form);
				break;
			case 2:
				form.ownerCt.close();
				break;
		}
	},

	onSubmit : function(form) {
		var v1 = form.items.items[0].rawValue,
			v2 = form.items.items[1].rawValue;
		if(v1 != v2) {
			Ext.Msg.show({
				title : '系统提示',
				msg : '两次输入密码不一致！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.INFO
			});
		}else {//提交数据
			if(form.form.isValid()) {
				form.getForm().submit({
	                params : {
	                	id: appCfg.uid
	                },
	                method : 'post',
	                waitTitle : '修改密码',
					waitMsg : '正在保存密码...',
					scope : this,
					success : function(form, formOwnerCt) {
						form.owner.ownerCt.close()
						Ext.Msg.show({
							title : '系统提示',
							msg : '密码修改成功！',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.INFO
						});
					},
					failure : function(form, formOwnerCt) {
						Ext.Msg.show({
	                        title : ' 错误提示',
	                        msg : '密码修改失败！',
	                        buttons : Ext.Msg.OK,
	                        icon : Ext.Msg.ERROR,
	                        scope : this,
							fn : function(btn) {
								if (btn == 'ok') {
									return false;
								}
							}
	                    });
					}
	            }, 200);
			}
		}
	}
});
