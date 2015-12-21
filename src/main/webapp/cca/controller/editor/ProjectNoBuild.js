
Ext.define('RYIVS.controller.editor.ProjectNoBuild', {
			extend : 'Ext.app.Controller',
			models : ['editor.ProjectBuild'],
			views : ['editor.ProjectNoBuild'],
			stores : ['editor.ProjectNoBuild'],
			refs : [ {
				selector : 'projectNoBuild',
				ref : 'projectBuildGrid'
				
			}
//			,{
//				ref : 'userLogPagingToolBar',
//				selector : 'gridEditUserLog pagingtoolbar[id=pagingtool]'
//			}
			],
			init : function() {	
				this.control({
							'projectNoBuild' : {
								activate : this.onActivate,
								afterrender:this.onAfterrender
							},
							'projectNoBuild button[itemId=addButton]' : {
								click : this.onAdd
							},
							'projectNoBuild button[itemId=removeButton]' : {
								click : this.onDelete
							},
							'projectNoBuild button[itemId=refreshButton]' : {
								click : this.onRefresh
							},
							'projectNoBuild button[itemId=searchButton]' : {
								click:this.onSearch
							}

						});
				controller.UserLogGrid = this;
			},

			// 当标签激活时
			onActivate : function(pa, options) {
			

			},
			//界面建立时只调用一次
			onAfterrender : function(pa, options) {
		
				var searchYear = this.getProjectBuildGrid().query('#projectNoBuildSearchYear')[0].getValue()+'';	
				var store = this.getProjectBuildGrid().items.items[0].store;
				store.proxy.setExtraParam("searchYear", searchYear);
				store.load({params:{page:1,start:0,limit:36}});
				
			},
			
			
			
			onAdd : function(obj){
			
				var editGrid = obj.ownerCt.ownerCt;
	
				// 如果是子表需要按需把外键进行添加
	
				var insertRecord = {};
	
				if (editGrid.newRecord != undefined) {
					insertRecord = editGrid.newRecord;
				}
				var searchYear = editGrid.query('#projectNoBuildSearchYear')[0].getValue()+'';
			
				editGrid.store.insert(0, insertRecord);
				obj.ownerCt.ownerCt.rowEditing.startEdit(0, 0);
			},
			
			
			//单击删除按钮
			onDelete:function(obj){

				
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

            	var grid = obj.ownerCt.ownerCt;
            	var searchYear = grid.query('#projectNoBuildSearchYear')[0].getValue()+'';

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
            


		});