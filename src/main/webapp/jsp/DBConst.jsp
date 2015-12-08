<%@ page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

//读取数据库常量

// 用户组
//ry.constant.usergroup = [ [ 1, '管理组' ], [ 2, '监控组' ] ];
// 空调控制类型
//ry.constant.airCtlType = [ [ 1, '制冷' ], [ 2, '制热' ], [ 3, '除湿' ] ];
// 控制器通道对应的资源类型
//ry.constant.ctrChaResType = [ [ 2, '电子围栏' ], [ 3, '消防' ], [ 4, '风机' ], [ 5, '空调' ], [ 6, '温湿度传感' ], [ 7, '灯光' ], [ 8, '风速' ] ];

// 控制器通道对应的资源类型
ry.constant.ctrChaResType = [
<c:forEach items = "${ctlCharResType}" var = "res" varStatus = "status">
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

