<%@ page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

Ext.require([ 'Ext.Date' ]);

// 流媒体参数

var appCfg = {
	ss_ip : '',
	ss_port : 0,
	uname : '',
	uid : 0,
	debugLevel : 0
};

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


// 资源类型
ry.constant.resourceType = [
<c:forEach items = "${resType}" var = "res" varStatus = "status">
	<c:choose>
		<c:when test="${status.last}">
			[${res.id},'${res.name}']
		</c:when>
		<c:otherwise>
			[${res.id},'${res.name}'],
		</c:otherwise>
	</c:choose>
</c:forEach>
];

//ry.constant.resourceType = [ [ 1, '摄像机' ], [ 2, '电子围栏' ], [ 3, '消防' ], [ 4, '风机' ], [ 5, '空调' ], [ 6, '温湿度传感' ], [ 7, '灯光' ], [ 8, '风速' ], [ 9, '人员定位' ] ];

// 控制器通道类型
ry.constant.ctrChaType = [
<c:forEach items = "${resCat}" var = "res" varStatus = "status">
	<c:choose>
		<c:when test="${status.last}">
			[${res.id},'${res.name}']
		</c:when>
		<c:otherwise>
			[${res.id},'${res.name}'],
		</c:otherwise>
	</c:choose>
</c:forEach>
];
//ry.constant.ctrChaType = [ [ 1, "开关量告警" ], [ 2, "风速传感" ], [ 3, "温湿度传感" ], [ 4, "SF6传感" ], [ 11, "开关控制" ], [ 12, "空调控制" ] ];

// 控制器通道对应的资源类型

ry.constant.ctrChaResType = [ [ 2, '电子围栏' ], [ 3, '消防' ], [ 4, '风机' ], [ 5, '空调' ], [ 6, '温湿度传感' ], [ 7, '灯光' ], [ 8, '风速' ] ];

// 空调控制类型
ry.constant.airCtlType = [ [ 1, '制冷' ], [ 2, '制热' ], [ 3, '除湿' ] ];

// 告警类型
ry.constant.almtype = [
<c:forEach items = "${almType}" var = "res" varStatus = "status">
	<c:choose>
		<c:when test="${status.last}">
			[${res.id},'${res.name}']
		</c:when>
		<c:otherwise>
			[${res.id},'${res.name}'],
		</c:otherwise>
	</c:choose>
</c:forEach>
];
//ry.constant.almtype = [ [ 1, '开关量告警' ], [ 2, '风速告警' ], [ 3, '温度过高' ], [ 4, '湿度过高' ], [ 5, '温度过低' ], [ 6, '湿度过低' ], [7, '温度突变'], [8, '湿度突变'], [ 9, 'SF6告警' ], [ 10, '人员定位' ], [ 101, '视频告警' ] ];

// 联动的动作类型
ry.constant.actiontype = [
<c:forEach items = "${action}" var = "res" varStatus = "status">
	<c:choose>
		<c:when test="${status.last}">
			[${res.id},'${res.name}']
		</c:when>
		<c:otherwise>
			[${res.id},'${res.name}'],
		</c:otherwise>
	</c:choose>
</c:forEach>
];
//ry.constant.actiontype = [ [ 1, 'PTZ调用' ], [ 2, '录像' ], [ 3, '开关控制' ], [ 4, '空调控制' ] ];

// 用户组
ry.constant.usergroup = [ [ 1, '管理组' ], [ 2, '监控组' ] ];

// 用户类型
ry.constant.usertype = [
<c:forEach items = "${userType}" var = "res" varStatus = "status">
	<c:choose>
		<c:when test="${status.last}">
			[${res.id},'${res.name}']
		</c:when>
		<c:otherwise>
			[${res.id},'${res.name}'],
		</c:otherwise>
	</c:choose>
</c:forEach>
];
//ry.constant.usertype = [ [ 1, '配置管理' ], [ 2, '运行监控' ] ];

// 用户等级
ry.constant.userRank = [
<c:forEach items = "${userRank}" var = "res" varStatus = "status">
	<c:choose>
		<c:when test="${status.last}">
			[${res.id},'${res.name}']
		</c:when>
		<c:otherwise>
			[${res.id},'${res.name}'],
		</c:otherwise>
	</c:choose>
</c:forEach>
];
//ry.constant.userRank = [ [ 1, '普通操作人员' ], [ 2, '变电站管理者' ], [ 3, '片区管理者' ], [ 4, '市级管理着' ], [ 5, '省级管理着' ], [ 10, '超级特权' ] ];

/**
 * 常用方法类
 */
Ext.namespace('ry.util');

ry.constant.errtype = '<font color=red>类型不存在</font>';
ry.constant.yntypestore = [ [ 1, "是" ], [ 0, "否" ] ];
ry.constant.yntype = [ [ 0, '<span style="background-color: #992124;">&nbsp;&nbsp;&nbsp;&nbsp;</span>' ],
		[ 1, '<span style="background-color: #4c8e0e;">&nbsp;&nbsp;&nbsp;&nbsp;</span>' ] ];

// 得到资源对应的CSS Class
ry.util.getResCssClass = function(val) {
	return '<div class=resType' + val + '></div>';
}
