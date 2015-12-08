/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : cca

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2015-12-08 17:08:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for behavior
-- ----------------------------
DROP TABLE IF EXISTS `behavior`;
CREATE TABLE `behavior` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '施工企业行为记录表',
  `enterpriseId` int(11) DEFAULT '0' COMMENT '施工企业表外键',
  `year` int(10) DEFAULT '0' COMMENT '不良行为发生年月',
  `generalbadNum` tinyint(4) DEFAULT '0' COMMENT '一般不良行为次数',
  `seriousBadNum` tinyint(4) DEFAULT '0' COMMENT '严重不良行为次数',
  `createTime` tinyint(4) DEFAULT NULL,
  `updateTime` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `behavior_enterpriseId_fk` (`enterpriseId`),
  CONSTRAINT `behavior_enterpriseId_fk` FOREIGN KEY (`enterpriseId`) REFERENCES `enterprise` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of behavior
-- ----------------------------

-- ----------------------------
-- Table structure for enterprise
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '施工企业资质信息表',
  `supervisorUnit` varchar(40) DEFAULT '' COMMENT '主管单位',
  `name` varchar(20) DEFAULT '' COMMENT '企业简称',
  `fullName` varchar(40) DEFAULT '' COMMENT '企业全称',
  `property` tinyint(4) DEFAULT '2' COMMENT '企业性质 1 全民 2 集体',
  `register` int(11) DEFAULT '0' COMMENT '注册资本金(万元)',
  `assets` int(11) DEFAULT '0' COMMENT '企业净资产(万元)',
  `workers` int(11) DEFAULT '0' COMMENT '在职职工数',
  `overallRank` tinyint(4) DEFAULT '0' COMMENT '资质 总承包 等级',
  `professionRank` tinyint(4) DEFAULT '0' COMMENT '资质 专业承包  等级',
  `output` int(11) DEFAULT '0' COMMENT '近三年的产值(万元)',
  `project` tinyint(4) DEFAULT '0' COMMENT '近三年工程数量',
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise
-- ----------------------------

-- ----------------------------
-- Table structure for enterprise_file
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_file`;
CREATE TABLE `enterprise_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '企业资质信息上传的附件表',
  `enterpriseId` int(11) DEFAULT NULL,
  `fileType` tinyint(4) DEFAULT '1' COMMENT '上传的文件类型 1 图片',
  `aptitudeType` tinyint(4) DEFAULT '1' COMMENT ' 企业资质类型1  总承包 ,2 专业承包 ',
  `path` varchar(50) DEFAULT '' COMMENT '文件存储的路径',
  `createTime` varchar(20) DEFAULT NULL,
  `updatTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `enterprise_file_id_fk` (`enterpriseId`),
  CONSTRAINT `enterprise_file_id_fk` FOREIGN KEY (`enterpriseId`) REFERENCES `enterprise` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise_file
-- ----------------------------

-- ----------------------------
-- Table structure for equipment_bear
-- ----------------------------
DROP TABLE IF EXISTS `equipment_bear`;
CREATE TABLE `equipment_bear` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '线路专业 张牵设备承载力 配置信息表',
  `name` varchar(40) DEFAULT '' COMMENT '设备名称说明',
  `voltageLevel` int(11) DEFAULT '0' COMMENT '电压等级 kv',
  `lineType` tinyint(4) DEFAULT '2' COMMENT '线路类型 1 单回  2 双回',
  `linePlain` tinyint(4) DEFAULT '0' COMMENT '平原,丘陵导线展放率(km/月.套)',
  `lineBrae` tinyint(4) DEFAULT '0' COMMENT '山区 导线展放率(km/月.套)',
  `explain` text COMMENT '设备的详细说明信息',
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipment_bear
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识的主键',
  `parentId` int(11) DEFAULT '0' COMMENT '上级编号',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '权限资源名称',
  `url` varchar(50) DEFAULT '' COMMENT '访问权限的资源文件路径',
  `type` tinyint(4) DEFAULT '2' COMMENT '权限类型  1 接口 ，2 菜单',
  `description` varchar(50) DEFAULT '' COMMENT '描述',
  `weight` tinyint(8) DEFAULT '0' COMMENT '同级权限的排序或者显示顺序，值越大，就越靠前显示',
  `status` tinyint(4) DEFAULT '1' COMMENT '1,正常状态，2，取消关注,3默认(首选)状态,4锁定状态(用户锁定)',
  `createTime` varchar(0) DEFAULT NULL COMMENT '创建时间',
  `updateTime` varchar(0) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `permission_name_index` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '2', '资质信息', 'gridEditUser', '2', '2级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('2', '0', '企业基本信息', 'gridEditUser', '2', '1级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('3', '2', '人员信息', 'aptitude', '2', '2级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('5', '0', '施工承载能力评估', '', '2', '1级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('6', '5', '评估标准', '', '2', '2级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('7', '6', '企业资质对施工承载能力评估', '', '2', '3级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('8', '6', '企业自身主要人员评估标准', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('9', '6', '机具设备对工程承载力的评估', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('10', '6', '施工项目团队工程施工产值', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('11', '6', '施工企业不良行文分类标准', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('12', '5', '现场管理人员', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('13', '12', '线路专业人员', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('14', '12', '变电专业人员', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('15', '5', '施工装备信息', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('16', '5', '承载能力计算结果', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('17', '5', '不良行为影响', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('18', '17', '不良行为影响修正系数', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('19', '17', '不良行为影响修正结果', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('20', '5', '施工企业评估分类', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('21', '5', '评估情况与近三年承揽情况的比较', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('22', '21', '工程数量对比情况', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('23', '21', '产值对比情况', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('24', '0', '评估结果应用', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('25', '24', '下一年度公司新开发工项目情况', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('26', '24', '各施工单位已承揽工程情况', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('27', '26', '在建工程情况', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('28', '26', '中标未开工情况', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('29', '24', '施工单位剩余承载能力', '', '2', '', '0', '1', null, null);

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '施工企业线路专业,与变电专业的人员配备表',
  `enterpriseId` int(11) NOT NULL COMMENT '施工企业表外键',
  `professionType` tinyint(4) DEFAULT '1' COMMENT '施工企业人员专业类型 1 线路专业 2 变电专业',
  `oneManager` tinyint(4) DEFAULT '0' COMMENT '330kv级以上项目一级建造师项目经理',
  `twoManager` tinyint(4) DEFAULT '0' COMMENT '220kv 及一下二级建造师项目经理',
  `oneChief` tinyint(4) DEFAULT '0' COMMENT '220kv 及以上的上级项目总工',
  `twoChief` tinyint(4) DEFAULT '0' COMMENT '110kv 级以下的下级项目总工',
  `safetyOfficer` tinyint(4) DEFAULT '0' COMMENT '安全员',
  `inspector` tinyint(4) DEFAULT '0' COMMENT '质检员',
  `technician` tinyint(4) DEFAULT '0' COMMENT '技术员',
  `costMember` tinyint(4) DEFAULT '0' COMMENT '造价员',
  `documenter` tinyint(4) DEFAULT '0' COMMENT '资料员',
  `integrator` tinyint(4) DEFAULT '0' COMMENT '综合管理员',
  `material` tinyint(4) DEFAULT '0' COMMENT '材料员',
  `expeditor` tinyint(4) DEFAULT '0' COMMENT '协调员',
  `constructionTeam` tinyint(4) DEFAULT '0' COMMENT '施工队长',
  `plurality` tinyint(4) DEFAULT '0' COMMENT ' 施工队,技术员,质检员,兼职安全员等',
  `createTime` varchar(20) DEFAULT '',
  `updateTime` varchar(20) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `person_enter_fk` (`enterpriseId`),
  CONSTRAINT `person_enter_fk` FOREIGN KEY (`enterpriseId`) REFERENCES `enterprise` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------

-- ----------------------------
-- Table structure for project_config
-- ----------------------------
DROP TABLE IF EXISTS `project_config`;
CREATE TABLE `project_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '施工项目完成量配置表',
  `voltageLlevel` int(11) DEFAULT '0' COMMENT '电压等级',
  `type` tinyint(4) DEFAULT '1' COMMENT '施工项目类型 1线程工程 2 变电项目',
  `number` decimal(10,2) DEFAULT '0.00' COMMENT ' 单个项目对应合理工期内完成数量(个/年)',
  `outputValue` decimal(10,2) DEFAULT '0.00' COMMENT '施工项目年产值 (万元/年)',
  `timeLimit` tinyint(4) DEFAULT '12' COMMENT '计算的合理工期 (个月)',
  `createTime` varchar(20) DEFAULT '',
  `updateTime` varchar(20) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_config
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识的主键',
  `parentId` int(11) NOT NULL DEFAULT '0' COMMENT '父角色编码',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称 唯一约束，不允许为空',
  `status` tinyint(4) DEFAULT '1' COMMENT '记录状态 1 可用 2 不可用',
  `createTime` varchar(20) DEFAULT '' COMMENT '记录创建时间',
  `updateTime` varchar(20) DEFAULT '' COMMENT '记录修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name_index` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_permission_link
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_link`;
CREATE TABLE `role_permission_link` (
  `roleId` int(11) NOT NULL COMMENT '角色唯一标识，外键（与permissionUuid组成联合主键）',
  `permissionId` int(11) NOT NULL COMMENT '权限唯一约束，外键',
  `status` tinyint(4) DEFAULT '1' COMMENT '1 可用 2 不可用',
  `createTime` varchar(20) DEFAULT '',
  `updateTime` varchar(20) DEFAULT '',
  PRIMARY KEY (`roleId`,`permissionId`),
  KEY `role_permissioin_link_permissionUuid` (`permissionId`),
  KEY `role_permission_link_roleid` (`roleId`),
  CONSTRAINT `perId_fk` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`),
  CONSTRAINT `roleId_per_fk` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission_link
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识的主键；不允许为空',
  `loginName` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号(登陆名)唯一约束，不允许为空，用户登陆名',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '不允许为空；使用MD5加密后保存',
  `token` varchar(40) DEFAULT '' COMMENT '用户的令牌码token',
  `realName` varchar(20) DEFAULT '' COMMENT '真实姓名',
  `nickname` varchar(20) DEFAULT '' COMMENT '昵称',
  `portraitPath` varchar(50) DEFAULT '' COMMENT '头像图片的相对路径',
  `status` tinyint(8) NOT NULL DEFAULT '1' COMMENT '1,正常状态，2，取消关注(冻结状态),',
  `createTime` varchar(20) NOT NULL DEFAULT '' COMMENT '记录创建时间',
  `updateTime` varchar(20) DEFAULT '' COMMENT '记录修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_loginName_index` (`loginName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '', '', '', '', '1', '', '');

-- ----------------------------
-- Table structure for user_log
-- ----------------------------
DROP TABLE IF EXISTS `user_log`;
CREATE TABLE `user_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `user_action` varchar(100) NOT NULL,
  `operate_time` datetime NOT NULL,
  `ip_address` varchar(50) NOT NULL,
  `comment_info` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_log_uid_fk` (`uid`),
  CONSTRAINT `user_log_uid_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COMMENT='用户日志表';

-- ----------------------------
-- Records of user_log
-- ----------------------------
INSERT INTO `user_log` VALUES ('1', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 10:39:19', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('2', '1', '会话超时，用户退出.', '2015-12-08 10:40:25', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('3', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 10:40:46', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('4', '1', '会话超时，用户退出.', '2015-12-08 10:42:37', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('5', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 13:19:01', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('6', '1', '会话超时，用户退出.', '2015-12-08 13:20:05', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('7', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 13:21:26', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('8', '1', '会话超时，用户退出.', '2015-12-08 13:24:11', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('9', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 13:28:26', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('10', '1', '会话超时，用户退出.', '2015-12-08 13:30:53', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('11', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 13:32:33', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('12', '1', '会话超时，用户退出.', '2015-12-08 13:34:17', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('13', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 13:43:31', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('14', '1', '会话超时，用户退出.', '2015-12-08 13:45:29', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('15', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 13:46:51', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('16', '1', '会话超时，用户退出.', '2015-12-08 13:48:05', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('17', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 13:50:53', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('18', '1', '会话超时，用户退出.', '2015-12-08 13:52:53', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('19', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 13:53:36', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('20', '1', '会话超时，用户退出.', '2015-12-08 13:54:59', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('21', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 13:56:31', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('22', '1', '会话超时，用户退出.', '2015-12-08 13:57:35', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('23', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 13:59:47', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('24', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 14:01:02', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('25', '1', '会话超时，用户退出.', '2015-12-08 14:01:23', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('26', '1', '会话超时，用户退出.', '2015-12-08 14:02:11', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('27', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 14:04:07', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('28', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 14:04:42', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('29', '1', '会话超时，用户退出.', '2015-12-08 14:05:12', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('30', '1', '会话超时，用户退出.', '2015-12-08 14:08:17', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('31', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 14:08:23', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('32', '1', '会话超时，用户退出.', '2015-12-08 14:10:30', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('33', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 14:13:54', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('34', '1', '会话超时，用户退出.', '2015-12-08 14:15:00', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('35', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 14:28:20', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('36', '1', '会话超时，用户退出.', '2015-12-08 14:29:42', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('37', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 14:30:39', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('38', '1', '会话超时，用户退出.', '2015-12-08 14:31:54', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('39', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 14:33:03', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('40', '1', '会话超时，用户退出.', '2015-12-08 14:34:30', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('41', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 14:35:18', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('42', '1', '会话超时，用户退出.', '2015-12-08 14:37:24', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('43', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 14:39:16', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('44', '1', '会话超时，用户退出.', '2015-12-08 14:40:24', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('45', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 14:41:39', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('46', '1', '会话超时，用户退出.', '2015-12-08 14:46:18', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('47', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 14:49:52', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('48', '1', '会话超时，用户退出.', '2015-12-08 14:51:00', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('49', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 14:52:23', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('50', '1', '会话超时，用户退出.', '2015-12-08 14:53:30', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('51', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 14:55:07', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('52', '1', '会话超时，用户退出.', '2015-12-08 14:56:24', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('53', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:04:41', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('54', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:05:58', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('55', '1', '会话超时，用户退出.', '2015-12-08 15:06:42', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('56', '1', '会话超时，用户退出.', '2015-12-08 15:07:06', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('57', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:08:07', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('58', '1', '会话超时，用户退出.', '2015-12-08 15:09:18', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('59', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:09:38', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('60', '1', '会话超时，用户退出.', '2015-12-08 15:11:12', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('61', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:12:44', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('62', '1', '会话超时，用户退出.', '2015-12-08 15:14:13', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('63', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:17:16', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('64', '1', '会话超时，用户退出.', '2015-12-08 15:18:49', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('65', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:19:33', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('66', '1', '会话超时，用户退出.', '2015-12-08 15:21:07', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('67', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:21:36', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('68', '1', '会话超时，用户退出.', '2015-12-08 15:22:55', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('69', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:23:33', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('70', '1', '会话超时，用户退出.', '2015-12-08 15:26:07', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('71', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:28:09', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('72', '1', '会话超时，用户退出.', '2015-12-08 15:30:55', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('73', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:33:33', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('74', '1', '会话超时，用户退出.', '2015-12-08 15:34:43', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('75', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:38:01', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('76', '1', '会话超时，用户退出.', '2015-12-08 15:40:35', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('77', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:40:46', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('78', '1', '会话超时，用户退出.', '2015-12-08 15:44:05', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('79', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:45:07', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('80', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:49:14', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('81', '1', '会话超时，用户退出.', '2015-12-08 15:53:55', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('82', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:54:37', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('83', '1', '会话超时，用户退出.', '2015-12-08 15:57:43', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('84', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 15:59:01', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('85', '1', '会话超时，用户退出.', '2015-12-08 16:01:19', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('86', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 16:28:17', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('87', '1', '会话超时，用户退出.', '2015-12-08 16:33:07', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('88', '1', '操作模块:会话管理,用户登陆.', '2015-12-08 16:33:43', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('89', '1', '会话超时，用户退出.', '2015-12-08 16:34:49', '192.168.1.240', '');

-- ----------------------------
-- Table structure for user_role_link
-- ----------------------------
DROP TABLE IF EXISTS `user_role_link`;
CREATE TABLE `user_role_link` (
  `userId` int(11) NOT NULL COMMENT '用户唯一标识，外键 ',
  `roleId` int(11) NOT NULL COMMENT '角色唯一标识，外键',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态 1 可用  2 不可用 ',
  `createTime` varchar(20) DEFAULT '' COMMENT '记录创建时间',
  `updateTime` varchar(20) DEFAULT '' COMMENT '修改时间',
  PRIMARY KEY (`userId`,`roleId`),
  KEY `user_role_link_roleUuid` (`roleId`),
  KEY `user_role_link_userId` (`userId`),
  CONSTRAINT `userId_role_fk` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  CONSTRAINT `roleId_fk` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role_link
-- ----------------------------
