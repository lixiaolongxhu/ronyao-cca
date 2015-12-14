<%@ page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

//读取数据库常量(字典数据)

// 用户组(示例)
//ry.constant.usergroup = [ [ 1, '管理组' ], [ 2, '监控组' ] ];

// 施工企业简称名称列表
ry.constant.enterprise_name = [
<c:forEach items = "${enterprise}" var = "res" varStatus = "status">
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


// 企业资质分类
ry.constant.enterprise_aptitude_classify = [
<c:forEach items = "${aptitudeClassify}" var = "res" varStatus = "status">
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

//企业资质等级   ry.constant.enterprise_aptitude_rank = [[1, '一级'], [ 2, '二级' ], [ 3, '三级' ],[-1,'无等级'] ];
ry.constant.enterprise_aptitude_rank = [
<c:forEach items = "${aptitudeRankClassify}" var = "res" varStatus = "status">
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


// 施工企业岗位名称分类列表
ry.constant.post_classify_name = [
<c:forEach items = "${postClassify}" var = "res" varStatus = "status">
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

// 电压等级分类名称列表
ry.constant.voltageRankClassify_name = [
<c:forEach items = "${voltageRankClassify}" var = "res" varStatus = "status">
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

// //获取当前时间到前10年的列
ry.constant.year = [
<c:forEach items = "${year}" var = "res" varStatus = "status">
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
