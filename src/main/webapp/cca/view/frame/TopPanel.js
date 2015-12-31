

Ext.define('RYIVS.view.frame.TopPanel', {
		extend : 'Ext.panel.Panel',
		alias : 'widget.topPanel',
		region : 'center',
		
		frame :false,
		header :false,
		height: '10%',
		//设置背景色或者图片
		html:'<img src="res/img/top.jpg" height=100% , width=100%></img>'
		
		//设置背景图片  
//      bodyStyle: {  
//                        //background: '#ffc',  
//             background: 'url(res/img/top.jpg) no-repeat #00FFFF ',  
//             padding: '10px'  
//	    }
//        
//      
//       
//        layout : 'border',
//        region : 'east',
//		layout: 'column',
//		items : [ 
//			{
//				xtype : 'panel',
//				width : 600
//			},
//				
//					{
//			xtype : 'panel',
//			
//       		bodyStyle: 'background-color:#a3c6c7;',
//       		layout: 'column',
//       		frame :false,
//       		header : false,
//       		width: 300,
//       		style: {
//            
//          		marginTop  :  '30px'//,
//    			//marginLeft : '20px',
//    		//	marginRight  : '60px'
//    			//marginBottom  :'20px'
//       		}, 
//       		
//       		items :[{
//       		
//			xtype : 'label',
//			text : '当前用户：' + appCfg.uname
//			 
//      
//		 
//		}, {
//			xtype : 'tbseparator'
//			
//		
//		}, {
//			xtype : 'button',
//			icon : 'res/icon/user_edit.png',
//			text : '修改密码',
//			handler : function(b, e) {
//				Ext.create('RYIVS.view.common.EditPassword').show();
//			}
//		
//		}, {
//			xtype : 'tbseparator'
//		}, {
//			xtype : 'tbfill'
//		}, {
//			xtype : 'button',
//			iconCls : 's_exit',
//			text : '退出系统',
//			handler : function(b, e) {
//				Ext.Ajax.request({
//					url : 'ui/logout',
//					success : function(response) {
//						location.href = "index.jsp";
//					}
//				});
//			}
//       			
//       		}]
//		
//		}] 
//
//        
//items :[		{
//				xtype : 'panel',
//				width : 600,
//				height :1,
//				
//			},{
//       		
//			xtype : 'label',
//			text : '当前用户：' + appCfg.uname
//			 
//      
//		 
//		}, {
//			xtype : 'tbseparator'
//			
//		
//		}, {
//			xtype : 'button',
//			icon : 'res/icon/user_edit.png',
//			text : '修改密码',
//			handler : function(b, e) {
//				Ext.create('RYIVS.view.common.EditPassword').show();
//			}
//		
//		}, {
//			xtype : 'tbseparator'
//		}, {
//			xtype : 'tbfill'
//		}, {
//			xtype : 'button',
//			iconCls : 's_exit',
//			text : '退出系统',
//			handler : function(b, e) {
//				Ext.Ajax.request({
//					url : 'ui/logout',
//					success : function(response) {
//						location.href = "index.jsp";
//					}
//				});
//			}
//       			
//       		}]
		

	}
);