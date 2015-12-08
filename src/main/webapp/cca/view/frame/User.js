/*
 * 用户的界面框架
 */
Ext.define('RYIVS.view.frame.User', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.frameUser',
	region : 'center',
	layout : 'border',
	items : [ {
		// 资源列表
		xtype : 'userResPanel',
		region : 'west',
		width : 200,
		hidden : true
	}, {
		// 主要显示区域
		region : 'center',
		xtype : 'tabpanel',
		id:'righttabpanel',
		alias : 'widget.righttabpanel',
		activeTab : 0,
		items : [ {
			// GIS视图
			id:'tabgis',
			xtype : 'tabgis'
		}, {
			// 传统视图
			id:'tabVideo',
			xtype : 'tabVideo'
		}, {
			// 历史查询
			id:'tabAlarm',
			xtype : 'tabAlarm',
			layout : 'border'
		} ],
		listeners:{
			tabchange:function(tp,p){
				var cCycle = Ext.getCmp('cCycle');
				if(p.id=='tabVideo'){
					cCycle.show();
				}else{
					cCycle.hide();
				}
			}
		}
	}, {
		// 右边的告警列表
		xtype : 'alarms',
		region : 'east'
	} ],
	bbar : [ {
		dock : 'bottom',
		border: 0,
		width : "100%",
		xtype : 'mainStateBar'
	} ],
		
	initComponent:function(){
		flag=false;
		this.callParent(arguments);
		var mainPanel = Ext.getCmp('righttabpanel')
		var cCycle = Ext.create('Ext.button.Cycle', {
			id:'cCycle',
			icon:'../../../res/icon/changCount.png',
		    showText: true,
		    prependText: '宫格模式:',
		    menu:
		    {
		        items: [{
		        	itemId:0,
		            text: '1*1'
		        }, {
		        	itemId:1,
		            text: '2*2'
		        }, {
		        	itemId:2,
		            text: '3*3'
		        }, {
		        	itemId:3,
		            text: '4*4'
		        }/*,{
		        	itemId:4,
		            text: '5*5'
		        },{
		        	itemId:5,
		            text: '6*6'
		        },{
		        	itemId:6,
		            text: '7*7'
		        },{
		        	itemId:7,
		            text: '8*8'
		        }*/]
		    },
		    changeHandler:function(btn,item){
		    	var winCount =item.itemId;
		    	var player =null;
		    	if(this.ownerCt!=undefined){
		    		player = this.ownerCt.ownerCt.items.items[1].items.items[0].player;
		    		player.Plugin_Interface(2,Ext.JSON.encode({layout:3,windows:winCount,max:2}));
		    	}
		    	if(flag==false){
		    		var currentCount=localStorage.getItem('winCount');
		    		numActive = currentCount;
		    	}else{
		    		numActive = winCount;
		    	}
		    	localStorage.setItem('winCount',numActive);
		    }	    
		});	
		flag=true;
		mainPanel.tabBar.add({xtype: 'tbfill'});
		cCycle.setActiveItem(numActive);
		mainPanel.tabBar.add(cCycle);
		cCycle.hide();	
	}
});
