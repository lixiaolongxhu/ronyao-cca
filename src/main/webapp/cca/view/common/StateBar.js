Ext.define('RYIVS.view.common.StateBar', {
	extend : 'Ext.toolbar.Toolbar',
	alias : 'widget.mainStateBar',
	items : [ {
		xtype : 'tbseparator'
	}, {
		xtype : 'label',
		text : '当前用户：' + appCfg.uname
	}, {
		xtype : 'tbseparator'
	}, {
		xtype : 'button',
		icon : 'res/icon/user_edit.png',
		text : '修改密码',
		handler : function(b, e) {
			Ext.create('RYIVS.view.common.EditPassword').show();
		}
	}, {
		xtype : 'tbseparator'
	}/*, {
		xtype : 'button',
		icon : 'res/icon/control.png',
		text : '本地参数设置',
		handler : function(b, e) {
			Ext.create('RYIVS.view.common.UserFolder').show();
		}
	}, {
		xtype:'button',
		text:'在线帮助',
		handler:function(b,e){
			var nwin = window.open();
			nwin.location = 'help.htm';
		}
	}*/, {
		xtype : 'tbfill'
	}, {
		xtype : 'button',
		iconCls : 's_exit',
		text : '退出系统',
		handler : function(b, e) {
			Ext.Ajax.request({
				url : 'ui/logout',
				success : function(response) {
					location.href = "index.jsp";
				}
			});
		}
	} ],
	initComponent : function() {
		this.callParent(arguments);
	}
});
