
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
							},
     		 				'projectPlain button[itemId=buttonExporterExcel]':{
        						click : this.exporterExcel
     		 				}

						});
				controller.UserLogGrid = this;
			},

			
			//界面建立时只调用一次
			onAfterrender : function(pa, options) {
		
				var searchYear = this.getProjectPlainGrid().query('#searchYear')[0].getValue()+'';	
				var store = this.getProjectPlainGrid().items.items[0].store;
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
				var searchYear = editGrid.query('#searchYear')[0].getValue()+'';
			
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
            	var searchYear = grid.query('#searchYear')[0].getValue()+'';

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
            },
          /**excel 导出
	 * 
	 */
	   exporterExcel :function(){
	   
   		window.location.href='../../ui/projectPlain/excel';
   		}
   
            


		});