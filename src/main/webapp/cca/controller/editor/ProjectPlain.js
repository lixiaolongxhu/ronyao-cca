
Ext.define('RYIVS.controller.editor.ProjectPlain', {
			extend : 'Ext.app.Controller',
			models : ['editor.ProjectPlain'],
			views : ['editor.ProjectPlain'],
			stores : ['editor.ProjectPlain'],
			refs : [ {
				ref : 'projectPlainGrid',
				selector : 'projectPlain'
			}
//			,{
//				ref : 'userLogPagingToolBar',
//				selector : 'gridEditUserLog pagingtoolbar[id=pagingtool]'
//			}
			],
			init : function() {	
				this.control({
							'projectPlain' : {
								activate : this.onActivate,
								afterrender:this.onAfterrender
							},
							'projectPlain button[itemId=addButton]' : {
								click : this.onAdd
							},
							'projectPlain button[itemId=removeButton]' : {
								click : this.onDelete
							},
							'projectPlain button[itemId=refreshButton]' : {
								click : this.onRefresh
							},
							'projectPlain button[itemId=searchButton]' : {
								click:this.onSearch
							}
//							,
//							'projectPlain button[itemId=clearnButton]' : {
//								click:this.onClear
//							}
						});
				controller.UserLogGrid = this;
			},

			// 当标签激活时
			onActivate : function(pa, options) {
			
//				var store = this.getUserLogGrid().items.items[0].store;
//				store.load({params:{page:1,start:0,limit:36}});
//				var pagetoolbar = this.getUserLogPagingToolBar();
//            	pagetoolbar.moveFirst();
			},
			onAfterrender : function(pa, options) {
			//		alert(" onAfterrender");
				var searchYear = this.getProjectPlainGrid().query('#searchYear')[0].getValue()+'';
				//var searchYear=Ext.Date.format(new Date(),"Y");
				var store = this.getProjectPlainGrid().items.items[0].store;
				store.proxy.setExtraParam("searchYear", searchYear);
				store.load({params:{page:1,start:0,limit:36}});
				
//				var pagetoolbar = this.getUserLogPagingToolBar();
//            	pagetoolbar.moveFirst();
			},
			
			
			
			onAdd : function(obj){
				//alert(Ext.Date.format(new Date(),"Y"));
				// this.ownerCt.ownerCt.rowEditing.cancelEdit();
				var editGrid = obj.ownerCt.ownerCt;
	
				// 如果是子表需要按需把外键进行添加
	
				var insertRecord = {};
	
				if (editGrid.newRecord != undefined) {
					insertRecord = editGrid.newRecord;
				}
				var searchYear = editGrid.query('#searchYear')[0].getValue()+'';
			//	insertRecord[0].set('year',searchYear);
			//	alert(insertRecord);
				editGrid.store.insert(0, insertRecord);
				obj.ownerCt.ownerCt.rowEditing.startEdit(0, 0);
			},
			
			
			//单击删除按钮
			onDelete:function(obj){
//            	var grid = obj.ownerCt.ownerCt;
//            	var localStore = grid.getStore();
//            	var list = grid.getSelectionModel().getSelection();
//            	var jsonArr =[];
//            	var record = null;
//            	for(var i=0,len=list.length;i<len;i++){
//            		record = list[i];
//            		jsonArr.push(record.data);
//            	}
//            	Ext.MessageBox.confirm('提示','确认删除选中日志记录？',function(btn){
//            		if(btn=='yes'){
//            			Ext.getBody().mask("日志删除中,请稍候...");
//            			actionUserLog.removeUserLog(jsonArr,function(obj){
//            				if(obj>0){
//            					Ext.getBody().unmask();
//            					localStore.load();
//            				}
//            			})
//            		}
//            	});
				
				Ext.Msg.show({
				title : '删除警告',
				msg : '请再次确认删除，删除该数据将删除与之相关联的数据',
				buttons : Ext.Msg.YESNO,
				fn : function(rst) {
					
					var ctlType = obj.ownerCt.ownerCt.ownerCt.xtype;
					var temp = obj.ownerCt.ownerCt;
					if (rst != 'no') {
						var sm = obj.ownerCt.ownerCt.getSelectionModel();
						obj.ownerCt.ownerCt.rowEditing.cancelEdit();
						obj.ownerCt.ownerCt.store.remove(sm.getSelection());
						if (obj.ownerCt.ownerCt.store.getCount() > 0) {
							sm.select(0);
						}
					}
					
				},
				scope : this,
				icon : Ext.window.MessageBox.QUESTION
			});

            },
            
            //单击查询按钮
            onSearch:function(obj){
//				var pagetoolbar = this.getUserLogPagingToolBar();
//				pagetoolbar.items.items[4].setValue(1);
            	var grid = obj.ownerCt.ownerCt;
            	var searchYear = grid.query('#searchYear')[0].getValue()+'';
//            	var et = new Date(grid.query('#end_time')[0].getValue()+'');
				var store =grid.getStore();
				if(searchYear != null  && searchYear!=''){
//					this.beginTime=bt.getFullYear()+"-"+(bt.getMonth()+1)+"-"+bt.getDate();
				//	alert(this.searchYear);
				//	alert(searchYear);
					store.proxy.setExtraParam("searchYear", searchYear);
				}
//				if(et !='Invalid Date'){
//					this.endTime=et.getFullYear()+"-"+(et.getMonth()+1)+"-"+et.getDate();
//					store.proxy.setExtraParam("endTime", this.endTime);
//				}
				store.load({
					params:{page:1,start:0,limit:36},
					scope : this,
					callback : function(records, operation, success) {}
				});
//				pagetoolbar.moveFirst();
            },
            
            onRefresh:function(obj){
            	var grid = obj.ownerCt.ownerCt;
            	var store =grid.getStore();
            	store.load();
            }
            
//            onClear:function(obj){
//            	var grid = obj.ownerCt.ownerCt;
//            	grid.query('#begin_time')[0].setValue("");
//            	grid.query('#end_time')[0].setValue("");
//            	var store =grid.getStore();
//            	delete store.proxy.extraParams.beginTime;
//            	delete store.proxy.extraParams.endTime;
//            	store.load();
//            	var pagetoolbar = this.getUserLogPagingToolBar();
//            	pagetoolbar.moveFirst();
//            }

		});