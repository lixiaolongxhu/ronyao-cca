/**
 * 用户日志管理
 */
Ext.define('RYIVS.controller.editor.UserLog', {
			extend : 'Ext.app.Controller',
			models : ['editor.UserLog'],
			views : ['editor.UserLog'],
			stores : ['editor.User', 'editor.UserLog'],
			refs : [ {
				ref : 'userLogGrid',
				selector : 'gridEditUserLog'
			},{
				ref : 'userLogPagingToolBar',
				selector : 'gridEditUserLog pagingtoolbar[id=pagingtool]'
			}],
			init : function() {	
				this.control({
							'gridEditUserLog' : {
								activate : this.onActivate,
								afterrender:this.onAfterrender
							},
							'gridEditUserLog button[itemId=removeButton]' : {
								click : this.onDelete
							},
							'gridEditUserLog button[itemId=refreshButton]' : {
								click : this.onRefresh
							},
							'gridEditUserLog button[itemId=searchButton]' : {
								click:this.onSearch
							},
							'gridEditUserLog button[itemId=clearnButton]' : {
								click:this.onClear
							}
						});
				controller.UserLogGrid = this;
			},

			// 当标签激活时
			onActivate : function(pa, options) {
				var store = this.getUserLogGrid().items.items[0].store;
				store.load({params:{page:1,start:0,limit:36}});
				var pagetoolbar = this.getUserLogPagingToolBar();
            	pagetoolbar.moveFirst();
			},
			onAfterrender : function(pa, options) {
				var store = this.getUserLogGrid().items.items[0].store;
				store.load({params:{page:1,start:0,limit:36}});
				var pagetoolbar = this.getUserLogPagingToolBar();
            	pagetoolbar.moveFirst();
			},
			//单击删除按钮
			onDelete:function(obj){
            	var grid = obj.ownerCt.ownerCt;
            	var localStore = grid.getStore();
            	var list = grid.getSelectionModel().getSelection();
            	var jsonArr =[];
            	var record = null;
            	for(var i=0,len=list.length;i<len;i++){
            		record = list[i];
            		jsonArr.push(record.data);
            	}
            	Ext.MessageBox.confirm('提示','确认删除选中日志记录？',function(btn){
            		if(btn=='yes'){
            			Ext.getBody().mask("日志删除中,请稍候...");
            			actionUserLog.removeUserLog(jsonArr,function(obj){
            				if(obj>0){
            					Ext.getBody().unmask();
            					localStore.load();
            				}
            			})
            		}
            	});
            },
            
            //单击查询按钮
            onSearch:function(obj){
				var pagetoolbar = this.getUserLogPagingToolBar();
				pagetoolbar.items.items[4].setValue(1);
            	var grid = obj.ownerCt.ownerCt;
            	var bt = new Date(grid.query('#begin_time')[0].getValue()+'');
            	var et = new Date(grid.query('#end_time')[0].getValue()+'');
				var store =grid.getStore();
				if(bt !='Invalid Date'){
					this.beginTime=bt.getFullYear()+"-"+(bt.getMonth()+1)+"-"+bt.getDate();
					store.proxy.setExtraParam("beginTime", this.beginTime);
				}
				if(et !='Invalid Date'){
					this.endTime=et.getFullYear()+"-"+(et.getMonth()+1)+"-"+et.getDate();
					store.proxy.setExtraParam("endTime", this.endTime);
				}
				store.load({
					params:{page:1,start:0,limit:36},
					scope : this,
					callback : function(records, operation, success) {}
				});
				pagetoolbar.moveFirst();
            },
            
            onRefresh:function(obj){
            	var grid = obj.ownerCt.ownerCt;
            	var store =grid.getStore();
            	store.load();
            },
            
            onClear:function(obj){
            	var grid = obj.ownerCt.ownerCt;
            	grid.query('#begin_time')[0].setValue("");
            	grid.query('#end_time')[0].setValue("");
            	var store =grid.getStore();
            	delete store.proxy.extraParams.beginTime;
            	delete store.proxy.extraParams.endTime;
            	store.load();
            	var pagetoolbar = this.getUserLogPagingToolBar();
            	pagetoolbar.moveFirst();
            }

		});