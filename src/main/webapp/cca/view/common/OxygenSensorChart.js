/**
 * 氧气百分比曲线
 * author : tqd
 * date ： 2013-4-10
 */
Ext.define('RYIVS.view.common.OxygenSensorChart', {
	extend : 'Ext.window.Window',
	alias : 'widget.oxSenChart',
	title : '氧气浓度变化曲线',
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
		//曲线标题说明
		legend : {
            position: 'bottom'
        },
		axes : [{
			type : 'Numeric',
			position : 'left',
			minimum : 0,
            maximum : 50,
			title : '氧气(O2)百分比(%)',
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
		series : [{
			type : 'line',
			axis : 'left',
			xField : 'time',
			yField : 'val1',
			title : '氧气(O2)曲线',//legend的显示值
			
			//mouseover提示
			tips : {
				trackMouse : true,
				width : 200,
				height : 40,
				renderer : function(storeItem, item) {
					var d_time = new Date(storeItem.get('time'));
					var s_time = d_time.getFullYear()+"-"+(d_time.getMonth()+1)+"-"+d_time.getDate()+" "+d_time.toLocaleTimeString();
					this.setTitle('氧气(O2)浓度：' + storeItem.get('val1') + '(%)<br/>' + '时间：' + s_time);
				}
			},
			style : {
				fill : '#ff2020',
				stroke : '#ff2020',
				'stroke-width' : 1
			},
			//高亮style
			highlight : {
				size : 3,
                radius: 4,
                stroke : 'gray'
			},
			markerConfig : {
				type : 'circle',
				size : 3,
				radius : 3,
				'stroke-width' : 0,
				fill : '#ff2020',
				stroke : '#ff2020'
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
