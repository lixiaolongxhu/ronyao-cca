Ext.define('RYIVS.controller.gis.FileUpload', {
			extend : 'Ext.app.Controller',
			views : ['gis.FileUpload'],
			refs : [{
						selector : 'fileUpload textfield[name=file]',
						ref : 'file'
					}, {
						selector : 'fileUpload textfield[name=fname]',
						ref : 'fileName'
					}],

			init : function() {
				this.control({
							'fileUpload  button' : {
								click : this.onClick
							}
						});

			},
			onClick : function(obj) {
				var form = obj.ownerCt.ownerCt;
				debugger;
				if ((this.getFile().getValue() == "")) {
					Ext.Msg.show({
								title : '警告',
								msg : '请先选择上传文件！',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.WARNING,
								scope : this,
								fn : function(btn) {
									if (btn == 'ok') {
										return false;
									}
								}
							});
					return false;
				}
				if ((this.getFileName().getValue() == "")) {
					Ext.Msg.show({
								title : '警告',
								msg : '请输入图层名！',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.WARNING,
								scope : this,
								fn : function(btn) {
									if (btn == 'ok') {
										return false;
									}
								}
							});
					return false;
				}


				if (form.getForm().isValid()) {
					var me = this;
					form.getForm().submit({
								url : '/srv/upload',
								params : {
									fname : this.getFileName().getValue()
								},
								waitMsg : '正在上传...',
								success : function(fp, o) {
									Ext.Msg.show({
												title : '成功',
												msg : '上传文件成功！',
												buttons : Ext.Msg.OK,
												icon : Ext.Msg.INFO,
												scope : this,
												fn : function(btn) {
													if (btn == 'ok') {
														me.getFileName().setValue("");
														form.ownerCt.close();
														return false;
													}
												}
											});
								},
								failure : function(fp, o) {
									var msg;
									switch(o.result.reason){
										case 1:
										msg = "请上传jpg格式的文件！";
										break;
										case 2:
										msg = "上传失败！";
										break;
										default:
										msg = "未知错误!";
									}
									Ext.Msg.show({
												title : '失败',
												msg : msg,
												buttons : Ext.Msg.OK,
												icon : Ext.Msg.ERROR,
												scope : this,
												fn : function(btn) {
													if (btn == 'ok') {
														me.getFileName().setValue("");
														return false;
													}
												}
											});
								}

							});
				}
			}

		})