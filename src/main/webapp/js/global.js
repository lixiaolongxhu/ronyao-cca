Ext.require([ 'Ext.Date' ]);


//注册全局ajax请求返回事件
Ext.Ajax.on('requestcomplete', function(conn, response, options, e) {
			var rst = response.responseText;
			// session 过期处理
			if (rst.indexOf("{timeout:", 0) != -1) {
				/*Ext.Msg.show({
							title : '警告',
							msg : '会话过期，请重新登录!',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.WARNING,
							scope : this,
							fn : function(btn) {
								if (btn == 'ok') {*/
									window.location.href = "index.jsp";
								/*}
							}
						});*/

			}
		}); 




// 流媒体参数

var appCfg = {
	ss_ip : '',
	ss_port : 0,
	uname : '',
	uid : 0,
	utype : 0,
	debugLevel : 0
};

var timelineSelectIndex = null;

// 通用日志函数
/*
 * 日志级别 0：调试消息 1：一般消息 2：普通异常 3：重要异常
 */
var logMessage = function(obj, level, msg) {
	var time = Ext.Date.format(new Date(), 'Y-m-d G:i:s');
	if (level >= appCfg.debugLevel) {
		console.log(time + ' -- ' + obj + ' : ' + msg);
	}
}

// 控制器全局对象
var controller = {

}

// 锁定整个界面
function freezeUI(freeze) {
	Ext.ComponentQuery.query("viewport")[0].setLoading(freeze);
}

// ----------------------------常量-----------------------------
Ext.namespace('ry.constant');

// 把Index翻译成对应的字符串
ry.constant.trans = function(index, type) {
	for ( var i = 0; i < type.length; i++) {
		if (type[i][0] == index) {
			return type[i][1];
		}
	}
	return 0;
}


// 空调控制类型
ry.constant.airCtlType = [[ 1, '制冷' ], [ 2, '制热' ], [ 3, '除湿' ] ];
ry.constant.airType = [[0, '关闭'], [ 1, '制冷' ], [ 2, '制热' ], [ 3, '除湿' ] ];
//联动-空调控制
ry.constant.link_air = [
    {parm1:"0", parm1Name:"关闭"},
    {parm1:"1", parm1Name:"制冷"},
    {parm1:"2", parm1Name:"制热"},
    {parm1:"3", parm1Name:"除湿"}
]

//开关量控制类型
ry.constant.ctlType = [[0, '关闭'], [1, '开启']]
//联动-开关量
ry.constant.link_switch = [
    {parm1:"0", parm1Name:"关闭"},
    {parm1:"1", parm1Name:"开启"}
]


// 用户组
ry.constant.usergroup = [ [ 1, '管理组' ], [ 2, '监控组' ] ];

//GOOSE 告警类型
ry.constant.gooseAlarmType = [[1,'intermediate'], [2,'off'], [3, 'on'], [4,'bad'], [5, 'off'], [6, 'on']];


/**
 * 常用方法类
 */
Ext.namespace('ry.util');
ry.constant.sendtypestore = [ [ 1, "短信" ], [ 2, "电话" ], [3, "电话与短信"] ];
ry.constant.errtype = '<font color=red>类型不存在</font>';
ry.constant.yntypestore = [ [ 1, "是" ], [ 0, "否" ] ];
ry.constant.yntype = [ [ 0, '<span style="background-color: #992124;">&nbsp;&nbsp;&nbsp;&nbsp;</span>' ],
		[ 1, '<span style="background-color: #4c8e0e;">&nbsp;&nbsp;&nbsp;&nbsp;</span>' ] ];

// 得到资源对应的CSS Class
ry.util.getResCssClass = function(val) {
	return '<div class=resType' + val + '></div>';
}
