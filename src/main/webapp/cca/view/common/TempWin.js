//温湿度曲线
Ext.define('RYIVS.view.common.TempWin', {
	extend : 'Ext.window.Window',
	alias : 'widget.tempwin',
	title : '温湿度曲线',
	width : 800,
	height : 600,
	maximizable : true,
	modal : true,
	layout : 'fit',
	tbar : [{
		xtype : 'datefield',
		region : 'center',
		maxValue : new Date(),
		value : new Date(),
		editable : false,
		columnWidth : 1
	}, {
		xtype : 'button',
		text : '上一天',
		fun : 1
	}, {
		xtype : 'button',
		text : '下一天',
		fun : 2
	}],

	items : [{
		xtype : 'chart',
		animate : false,
		store : 'common.TempWin',
		insetPadding : 30,
		legend : {
            position: 'bottom'
        },
		axes : [{
			type : 'Numeric',
			position : 'left',
			minimum : -40,
            maximum : 100,
			title : '温湿度',
			grid : true,
			label : {
				renderer : Ext.util.Format.numberRenderer('0,0'),
				font : '10px Arial'
			}
		}, {
			type : 'Time',
			title : ' 时间(24H)',
			position : 'bottom',
			fields : 'time',
			step : [Ext.Date.HOUR, 1],//按那种类型设置轴的间隔，这里是按每小时
			minorTickSteps : 3,//段之间的分隔点数
			dateFormat : 'H',//格式化坐标轴格式
			groupBy : 'year,month,day,hour,minute,second',
			aggregateOp : 'sum',
			grid : true
		}],
		series : [
		//温度曲线
		{
			type : 'line',
			axis : 'left',
			xField : 'time',
			yField : 'val1',
			title : '温度',
			tips : {
				trackMouse : true,
				width : 200,
				height : 40,
				renderer : function(storeItem, item) {
					var d_time = new Date(storeItem.get('time'));
					var s_time = d_time.getFullYear()+"-"+(d_time.getMonth()+1)+"-"+d_time.getDate()+" "+d_time.toLocaleTimeString();
					this.setTitle('温度：' + storeItem.get('val1') + '℃<br/>' + '时间：' + s_time);
				}
			},
			
			//曲线样式
			style : {
				fill : '#adff2f',
				stroke : '#ff2021',
				'stroke-width' : 1
			},
			
			//高亮样式
			highlight : {
				size : 2,
                radius: 5,
                stroke : 'gray'
			},
			
			//标记样式
			markerConfig : {
				type : 'circle',
				size : 2,
				radius : 4,
				'stroke-width' : 0,
				fill : '#ff2020',
				stroke : '#ff2020'
			}
		}, 
		//湿度曲线
		{
			type : 'line',
			axis : 'left',
			xField : 'time',
			yField : 'val2',
			title : '湿度',
			
			tips : {
				trackMouse : true,
				width : 200,
				height : 40,
				renderer : function(storeItem, item) {
					var d_time = new Date(storeItem.get('time'));
					var s_time = d_time.getFullYear()+"-"+(d_time.getMonth()+1)+"-"+d_time.getDate()+" "+d_time.toLocaleTimeString();
					this.setTitle('湿度：' + storeItem.get('val2') + '%<br/>' + '时间：' + s_time);
				}
			},
			style : {
				fill : '#61ff37',
				stroke : '#61ff37',
				'stroke-width' : 1
			},
			highlight : {
				size : 2,
                radius: 4,
                stroke : 'gray'
			},
			markerConfig : {
				type : 'circle',
				size : 2,
				radius : 3,
				'stroke-width' : 0,
				fill : '#32cd32',
				stroke : '#61ff37'
			}
		}]
	}],

	show : function() {
		this.callParent(arguments);
		this.fireEvent('onShow', this);
	},
	initComponent : function() {
		this.callParent(arguments);
		this.addEvents('onShow');
	}
});
