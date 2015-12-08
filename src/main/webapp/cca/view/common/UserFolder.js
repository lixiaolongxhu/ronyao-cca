Ext.define('RYIVS.view.common.UserFolder', {
	extend : 'Ext.window.Window',
	alias : 'widget.userFolder',
	html : '<embed type="ry-ivs-plugin-misc" width=0 height=0 />',
	iconCls : 's_control',
	height : 160,
	width : 300,
	title : "本地参数设置",
	bodyPadding : 20,
	modal : true,
	misc : null,
	items : [ {
		xtype : 'textfield',
		id : 'imagePath',
		fieldLabel : '抓图路径',
		labelAlign : 'right',
		//value : localStorage.getItem('RYIVS.imagePath'),
		listeners : {
			click : {
				element : 'el',
				fn : function() {
					var f = Ext.ComponentQuery.query('userFolder')[0];
					f.selectFolder('imagePath');
				}
			}
		}
	}, {
		xtype : 'textfield',
		id : 'videoPath',
		fieldLabel : '录像路径',
		labelAlign : 'right',
		//value : localStorage.getItem('RYIVS.videoPath'),
		listeners : {
			click : {
				element : 'el',
				fn : function() {
					var f = Ext.ComponentQuery.query('userFolder')[0];
					f.selectFolder('videoPath');
				}
			}
		}
	} ],

	buttons : [ {
		text : '确定',
		handler : function() {
			if(controller.videoPanel) {
				controller.videoPanel.setPath(localStorage.getItem('RYIVS.imagePath'),localStorage.getItem('RYIVS.videoPath'));
			}
			this.ownerCt.ownerCt.close();
		}
	} ],

	
	selectFolder : function(id) {
		var fo = this.misc.SelectFolder();		
		var input = this.queryById(id);
		input.setValue(fo);
		localStorage.setItem('RYIVS.' + id, fo);
	},
	
	initPlugin : function() {
		if (this.body == undefined) {
			this.misc = null;
		}
		this.misc = this.body.dom.getElementsByTagName("embed")[0];
		if (this.misc == null) {
			return;
		}
	},

	render : function() {
		this.callParent(arguments);
		this.initPlugin();
		this.queryById('imagePath').setValue(localStorage.getItem('RYIVS.imagePath'));
		this.queryById('videoPath').setValue(localStorage.getItem('RYIVS.videoPath'));
	},

	initComponent : function() {
		this.callParent(arguments);
	}
});