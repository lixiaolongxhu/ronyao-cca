/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : cca

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2015-12-10 14:58:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for aptituderank_classify
-- ----------------------------
DROP TABLE IF EXISTS `aptituderank_classify`;
CREATE TABLE `aptituderank_classify` (
  `id` tinyint(4) NOT NULL COMMENT '企业资质信息等级',
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aptituderank_classify
-- ----------------------------
INSERT INTO `aptituderank_classify` VALUES ('-1', '无等级');
INSERT INTO `aptituderank_classify` VALUES ('1', '一级');
INSERT INTO `aptituderank_classify` VALUES ('2', '二级');
INSERT INTO `aptituderank_classify` VALUES ('3', '三级');

-- ----------------------------
-- Table structure for aptitude_classify
-- ----------------------------
DROP TABLE IF EXISTS `aptitude_classify`;
CREATE TABLE `aptitude_classify` (
  `id` tinyint(4) NOT NULL COMMENT '企业资产分类表   1 总承包 2 专业承包',
  `name` varchar(20) DEFAULT '' COMMENT '企业资质信息分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aptitude_classify
-- ----------------------------
INSERT INTO `aptitude_classify` VALUES ('1', '总承包');
INSERT INTO `aptitude_classify` VALUES ('2', '专业承包');

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
  PRIMARY KEY (`id`),
  KEY `enter_overallRank_id_fk` (`overallRank`),
  KEY `enter_professionRank_id_fk` (`professionRank`),
  CONSTRAINT `enter_professionRank_id_fk` FOREIGN KEY (`professionRank`) REFERENCES `aptituderank_classify` (`id`),
  CONSTRAINT `enter_overallRank_id_fk` FOREIGN KEY (`overallRank`) REFERENCES `aptituderank_classify` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise
-- ----------------------------
INSERT INTO `enterprise` VALUES ('1', '四川成都', '企业简称', '四川成都公司', '2', '0', '0', '0', '1', '1', '0', '0', '', '');
INSERT INTO `enterprise` VALUES ('4', '可入的', '范德萨范德萨发生大幅度', '法撒旦法士大夫撒旦法', '2', '0', '0', '0', '1', '1', '0', '0', '', '');
INSERT INTO `enterprise` VALUES ('9', '3423141234', '21432143214', '4123423', '2', '0', '0', '0', '1', '1', '0', '0', '2015-12-09 12:36:49', '');
INSERT INTO `enterprise` VALUES ('16', '123213', '3213123', '3213123', '2', '0', '0', '0', '1', '1', '0', '0', '2015-12-09 12:36:49', '');
INSERT INTO `enterprise` VALUES ('17', 'fsadfasdf', 'fsadfdsa', 'fsdafsadfads', '1', '0', '0', '0', '1', '1', '0', '0', '2015-12-09 12:36:49', '');
INSERT INTO `enterprise` VALUES ('69', '发撒旦法撒旦法', '防守打法俄方', '发撒旦法撒旦法', '2', '0', '0', '0', '3', '3', '0', '0', '2015-12-09 14:55:05', '');
INSERT INTO `enterprise` VALUES ('70', 'fsadfsadsdfdasf', 'sdafsdaf', 'asdfsdaf', '2', '0', '0', '0', '-1', '-1', '0', '0', '2015-12-10 09:22:23', '');

-- ----------------------------
-- Table structure for enterprise_aptitude
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_aptitude`;
CREATE TABLE `enterprise_aptitude` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '企业资质标准分类 表',
  `aptitudeId` tinyint(4) DEFAULT '1' COMMENT '资质分类',
  `aptitudeRank` tinyint(4) DEFAULT '0' COMMENT '企业资质等级 ',
  `qualifications` varchar(50) DEFAULT '' COMMENT '资质要求',
  `practicing` varchar(100) DEFAULT '' COMMENT '执业资格',
  `charge` varchar(255) DEFAULT '' COMMENT '技术负责人',
  `technical` varchar(255) DEFAULT '' COMMENT '技术人员',
  `skills` varchar(255) DEFAULT '' COMMENT '技能人员',
  `jobRange` varchar(255) DEFAULT '' COMMENT '承包范围',
  `createTime` varchar(20) DEFAULT '',
  `updateTime` varchar(20) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `enter_aptiude_id_fk` (`aptitudeId`),
  KEY `enter_aptiudeRank_id_fk` (`aptitudeRank`),
  CONSTRAINT `enter_aptiudeRank_id_fk` FOREIGN KEY (`aptitudeRank`) REFERENCES `aptituderank_classify` (`id`),
  CONSTRAINT `enter_aptiude_id_fk` FOREIGN KEY (`aptitudeId`) REFERENCES `aptitude_classify` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise_aptitude
-- ----------------------------
INSERT INTO `enterprise_aptitude` VALUES ('2', '2', '2', '佛挡杀佛的佛挡杀佛的佛挡杀佛的', '佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的', '佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的', '佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的', '佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的', '佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的', '2015-12-10 10:34:01', '2015-12-10 10:40:14');
INSERT INTO `enterprise_aptitude` VALUES ('3', '2', '2', '杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的', '杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的', '杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的', '杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的', '杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的', '杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的杀佛的佛挡杀佛的佛挡杀佛的', '2015-12-10 10:39:22', '');

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
-- Table structure for enterprise_person
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_person`;
CREATE TABLE `enterprise_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '施工企业持证人员',
  `enterpriseId` int(11) DEFAULT NULL COMMENT '企业基本信息表外键',
  `constructorOne` tinyint(4) DEFAULT '0' COMMENT '国家注册建造师  一级人数',
  `constructorTwo` tinyint(4) DEFAULT '0' COMMENT '国家注册建造师 二级',
  `constructorTotal` tinyint(4) DEFAULT '0' COMMENT '国家注册建造师  人数 合计',
  `staffMiddle` tinyint(4) DEFAULT '0' COMMENT '中级以上职称人员  中级  ',
  `staffHigh` tinyint(4) DEFAULT '0' COMMENT '中级以上职称人员  高级',
  `staffTotal` tinyint(4) DEFAULT '0' COMMENT '中级以上职称人员  合计',
  `skillMiddle` tinyint(4) DEFAULT '0' COMMENT '中级工以上技术人员   中级',
  `skillHigh` tinyint(4) DEFAULT '0' COMMENT '中级工以上技术人员   高级',
  `skillTech` tinyint(4) DEFAULT '0' COMMENT '中级工以上技术人员  技师',
  `skillTechHigh` tinyint(4) DEFAULT '0' COMMENT '中级工以上技术人员  高级技师',
  `skillTotal` tinyint(4) DEFAULT NULL COMMENT '中级工以上技术人员   合计',
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `enterprise_per_id_fk` (`enterpriseId`),
  CONSTRAINT `enterprise_per_id_fk` FOREIGN KEY (`enterpriseId`) REFERENCES `enterprise` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise_person
-- ----------------------------
INSERT INTO `enterprise_person` VALUES ('17', '16', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2015-12-09 16:12:38', '');
INSERT INTO `enterprise_person` VALUES ('22', '9', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2015-12-09 16:29:07', '');
INSERT INTO `enterprise_person` VALUES ('31', '4', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2015-12-09 16:29:27', '');
INSERT INTO `enterprise_person` VALUES ('34', '16', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2015-12-09 16:35:07', '');
INSERT INTO `enterprise_person` VALUES ('38', '4', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2015-12-09 16:35:19', '');
INSERT INTO `enterprise_person` VALUES ('49', '17', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2015-12-09 16:46:17', '');
INSERT INTO `enterprise_person` VALUES ('50', '69', '1', '2', '3', '2', '2', '4', '1', '2', '3', '4', '10', '2015-12-09 16:49:48', '2015-12-09 17:02:03');
INSERT INTO `enterprise_person` VALUES ('51', '9', '1', '2', '3', '3', '4', '7', '5', '6', '7', '7', '25', '2015-12-09 17:02:49', '');

-- ----------------------------
-- Table structure for enterprise_per_standard
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_per_standard`;
CREATE TABLE `enterprise_per_standard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '企业自身主要人员评估(施工项目部人员构成)',
  `postClassifyId` tinyint(4) DEFAULT NULL COMMENT '岗位名称外键关联',
  `holderRequire` varchar(255) DEFAULT '' COMMENT '持证要求',
  `lineFlatNum` tinyint(4) DEFAULT '1' COMMENT '线路工程,平地需要人员个数',
  `lineMountainNum` tinyint(4) DEFAULT '1' COMMENT '线路工程,山区需要人员个数',
  `powerNum` tinyint(4) DEFAULT '0' COMMENT '变电工程  需要人数',
  `job` tinyint(4) DEFAULT '1' COMMENT '该岗位是否允许其他岗位人员兼职   1 不允许   2 允许',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `per_standard_postClassifyId_fk` (`postClassifyId`) USING BTREE,
  CONSTRAINT `per_standard_postClassifyId_fk` FOREIGN KEY (`postClassifyId`) REFERENCES `post_classify` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise_per_standard
-- ----------------------------
INSERT INTO `enterprise_per_standard` VALUES ('1', '1', 'fdsfdsf法国法士大夫防守打法的发放四大fsa', '1', '1', '1', '1', 'sdafasdfsdf沙发垫范甘迪发郭德纲 大范甘迪个', '2015-12-10 13:27:49', '2015-12-10 13:34:50');
INSERT INTO `enterprise_per_standard` VALUES ('3', '2', 'fsafsadf fdsfsadfds是短发是飞洒地方 士大夫撒旦', '1', '1', '1', '1', '发的发撒旦发送到法撒旦', '2015-12-10 13:40:01', '');
INSERT INTO `enterprise_per_standard` VALUES ('4', '6', '发发士大夫发的发阿三发送到方法撒旦法阿什顿飞', '2', '2', '2', '2', '发生法撒旦法是飞洒第三方师德师风a', '2015-12-10 13:40:26', '2015-12-10 13:41:12');
INSERT INTO `enterprise_per_standard` VALUES ('7', '3', '在想方设法所发生的的发松岛枫搜索岛发松岛枫士大夫撒地方', '1', '1', '1', '1', '分身乏术法撒旦法师法鼎飞丹砂发圣诞送士大夫撒地方十大啥的发送到撒旦法速度多少发送到发', '2015-12-10 13:43:54', '');

-- ----------------------------
-- Table structure for equipment_bear
-- ----------------------------
DROP TABLE IF EXISTS `equipment_bear`;
CREATE TABLE `equipment_bear` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '线路专业 张牵设备承载力 配置信息表',
  `name` varchar(40) DEFAULT '' COMMENT '设备名称说明',
  `voltageRankId` tinyint(4) DEFAULT NULL COMMENT '电压等级 kv',
  `lineType` tinyint(4) DEFAULT '2' COMMENT '线路类型 1 单回  2 双回',
  `linePlain` tinyint(4) DEFAULT '0' COMMENT '平原,丘陵导线展放率(km/月.套)',
  `lineBrae` tinyint(4) DEFAULT '0' COMMENT '山区 导线展放率(km/月.套)',
  `explains` varchar(225) DEFAULT NULL COMMENT '设备的详细说明信息',
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `voltagerankid_fk` (`voltageRankId`,`lineType`) USING BTREE,
  CONSTRAINT `voltagerankid_fk` FOREIGN KEY (`voltageRankId`) REFERENCES `voltage_rank_classify` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipment_bear
-- ----------------------------
INSERT INTO `equipment_bear` VALUES ('5', '放散阀风飒飒的撒放四大', '2', '2', '1', '1', '', '2015-12-10 14:52:36', '');
INSERT INTO `equipment_bear` VALUES ('6', '发士大夫撒safetyas', '1', '1', '1', '1', '法撒旦法师法但是', '2015-12-10 14:52:52', '');
INSERT INTO `equipment_bear` VALUES ('7', '发送到法撒旦发松岛枫', '3', '1', '1', '1', '', '2015-12-10 14:53:45', '');
INSERT INTO `equipment_bear` VALUES ('8', '风飒飒的范德萨范德萨范德萨发生的三大范德萨发的啥', '4', '1', '1', '1', '', '2015-12-10 14:53:57', '');
INSERT INTO `equipment_bear` VALUES ('10', '撒旦法隔热特委托日期尔特天然气问题热武器b', '1', '2', '1', '1', '当然 are撒旦安仁坊a', '2015-12-10 14:55:30', '');
INSERT INTO `equipment_bear` VALUES ('13', '士大夫撒地方松岛枫松岛枫爱妃撒放四大', '3', '2', '1', '1', '', '2015-12-10 14:56:08', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '2', '资质信息', 'enterprise', '2', '2级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('2', '0', '企业基本信息', '', '2', '1级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('3', '2', '人员信息', 'enterprisePer', '2', '2级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('5', '0', '施工承载能力评估', '', '2', '1级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('6', '5', '评估标准', '', '2', '2级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('7', '6', '企业资质对施工承载能力评估', 'enterpriseApt', '2', '3级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('8', '6', '企业自身主要人员评估标准', 'enterprisePerSta', '2', '企业自身主要人员评估(施工项目部人员构成)', '0', '1', null, null);
INSERT INTO `permission` VALUES ('9', '6', '机具设备对工程承载力的评估', 'equipmentBear', '2', '张牵设备承载力配置信息', '0', '1', null, null);
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
-- Table structure for post_classify
-- ----------------------------
DROP TABLE IF EXISTS `post_classify`;
CREATE TABLE `post_classify` (
  `id` tinyint(4) NOT NULL COMMENT '施工企业基本岗位表',
  `name` varchar(100) DEFAULT '' COMMENT '岗位名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post_classify
-- ----------------------------
INSERT INTO `post_classify` VALUES ('1', '项目经理');
INSERT INTO `post_classify` VALUES ('2', '项目总工');
INSERT INTO `post_classify` VALUES ('3', '安全员');
INSERT INTO `post_classify` VALUES ('4', '质检员');
INSERT INTO `post_classify` VALUES ('5', '技术员');
INSERT INTO `post_classify` VALUES ('6', '造价员,资料员,综合员,管理员,材料员,协调员');
INSERT INTO `post_classify` VALUES ('7', '施工队长(班组长)');
INSERT INTO `post_classify` VALUES ('8', '施工队技术员,质检员,兼职安全员');

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
  `status` tinyint(8) DEFAULT '1' COMMENT '1,正常状态，2，取消关注(冻结状态),',
  `createTime` varchar(20) DEFAULT '' COMMENT '记录创建时间',
  `updateTime` varchar(20) DEFAULT '' COMMENT '记录修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_loginName_index` (`loginName`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '', '', '', '', '1', '', '');
INSERT INTO `user` VALUES ('2', '4213', '3241234', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('78', 'user', 'user', null, null, null, null, null, null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=292 DEFAULT CHARSET=utf8 COMMENT='用户日志表';

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
INSERT INTO `user_log` VALUES ('90', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 09:31:59', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('91', '1', '会话超时，用户退出.', '2015-12-09 09:34:22', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('92', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 09:34:46', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('93', '1', '会话超时，用户退出.', '2015-12-09 09:36:28', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('94', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 09:38:40', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('95', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 09:39:46', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('96', '1', '会话超时，用户退出.', '2015-12-09 09:39:46', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('97', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 09:41:34', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('98', '1', '会话超时，用户退出.', '2015-12-09 09:41:58', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('99', '1', '会话超时，用户退出.', '2015-12-09 09:42:40', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('100', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 09:43:00', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('101', '1', '会话超时，用户退出.', '2015-12-09 09:44:10', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('102', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 09:44:50', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('103', '1', '会话超时，用户退出.', '2015-12-09 09:46:04', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('104', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 09:47:04', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('105', '1', '会话超时，用户退出.', '2015-12-09 09:48:16', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('106', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 09:49:14', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('107', '1', '会话超时，用户退出.', '2015-12-09 09:50:52', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('108', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 09:57:27', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('109', '1', '会话超时，用户退出.', '2015-12-09 09:58:34', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('110', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 09:59:13', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('111', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 09:59:48', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('112', '1', '会话超时，用户退出.', '2015-12-09 10:00:28', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('113', '1', '会话超时，用户退出.', '2015-12-09 10:00:52', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('114', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 10:03:25', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('115', '1', '会话超时，用户退出.', '2015-12-09 10:06:10', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('116', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 10:12:05', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('117', '1', '会话超时，用户退出.', '2015-12-09 10:13:23', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('118', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 10:13:37', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('119', '1', '会话超时，用户退出.', '2015-12-09 10:18:11', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('120', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 10:21:00', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('121', '1', '会话超时，用户退出.', '2015-12-09 10:22:11', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('122', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 10:29:21', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('123', '1', '会话超时，用户退出.', '2015-12-09 10:30:29', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('124', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 10:32:42', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('125', '1', '会话超时，用户退出.', '2015-12-09 10:34:41', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('126', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 10:34:48', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('127', '1', '会话超时，用户退出.', '2015-12-09 10:37:11', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('128', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 10:39:28', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('129', '1', '会话超时，用户退出.', '2015-12-09 10:40:53', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('130', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 10:46:58', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('131', '1', '会话超时，用户退出.', '2015-12-09 10:48:47', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('132', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 10:49:28', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('133', '1', '会话超时，用户退出.', '2015-12-09 10:50:59', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('134', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 10:51:39', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('135', '1', '会话超时，用户退出.', '2015-12-09 10:52:47', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('136', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 10:54:29', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('137', '1', '会话超时，用户退出.', '2015-12-09 10:56:11', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('138', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 10:57:05', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('139', '1', '会话超时，用户退出.', '2015-12-09 10:58:53', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('140', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 11:00:25', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('141', '1', '会话超时，用户退出.', '2015-12-09 11:05:53', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('142', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 11:07:42', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('143', '1', '会话超时，用户退出.', '2015-12-09 11:10:23', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('144', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 11:13:01', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('145', '1', '会话超时，用户退出.', '2015-12-09 11:15:47', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('146', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 11:25:35', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('147', '1', '会话超时，用户退出.', '2015-12-09 11:32:14', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('148', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 12:36:30', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('149', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 12:40:25', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('150', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 12:41:52', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('151', '1', '会话超时，用户退出.', '2015-12-09 12:42:00', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('152', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 12:43:14', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('153', '1', '会话超时，用户退出.', '2015-12-09 12:44:00', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('154', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 12:44:36', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('155', '1', '会话超时，用户退出.', '2015-12-09 12:44:48', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('156', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 12:47:58', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('157', '1', '会话超时，用户退出.', '2015-12-09 12:48:48', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('158', '1', '会话超时，用户退出.', '2015-12-09 12:53:00', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('159', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 12:53:24', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('160', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 12:54:52', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('161', '1', '会话超时，用户退出.', '2015-12-09 12:55:31', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('162', '1', '会话超时，用户退出.', '2015-12-09 12:56:07', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('163', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 12:56:18', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('164', '1', '会话超时，用户退出.', '2015-12-09 12:58:01', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('165', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 12:59:06', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('166', '1', '会话超时，用户退出.', '2015-12-09 13:01:41', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('167', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:01:54', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('168', '1', '会话超时，用户退出.', '2015-12-09 13:03:23', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('169', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:04:52', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('170', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:06:00', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('171', '1', '会话超时，用户退出.', '2015-12-09 13:06:46', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('172', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:09:05', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('173', '1', '会话超时，用户退出.', '2015-12-09 13:09:52', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('174', '1', '会话超时，用户退出.', '2015-12-09 13:12:04', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('175', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:12:30', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('176', '1', '会话超时，用户退出.', '2015-12-09 13:14:52', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('177', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:15:20', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('178', '1', '会话超时，用户退出.', '2015-12-09 13:16:34', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('179', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:16:45', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('180', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:26:37', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('181', '1', '会话超时，用户退出.', '2015-12-09 13:29:35', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('182', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:29:55', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('183', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:30:24', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('184', '1', '会话超时，用户退出.', '2015-12-09 13:31:11', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('185', '1', '会话超时，用户退出.', '2015-12-09 13:32:29', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('186', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:34:32', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('187', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:35:45', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('188', '1', '会话超时，用户退出.', '2015-12-09 13:36:29', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('189', '1', '会话超时，用户退出.', '2015-12-09 13:37:41', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('190', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:38:02', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('191', '1', '会话超时，用户退出.', '2015-12-09 13:39:29', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('192', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:40:22', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('193', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:43:40', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('194', '1', '会话超时，用户退出.', '2015-12-09 13:44:17', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('195', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:48:20', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('196', '1', '会话超时，用户退出.', '2015-12-09 13:48:53', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('197', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:50:54', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('198', '1', '会话超时，用户退出.', '2015-12-09 13:55:25', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('199', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 13:56:54', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('200', '1', '会话超时，用户退出.', '2015-12-09 13:59:31', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('201', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 14:00:49', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('202', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 14:03:05', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('203', '1', '会话超时，用户退出.', '2015-12-09 14:03:31', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('204', '1', '会话超时，用户退出.', '2015-12-09 14:04:19', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('205', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 14:05:49', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('206', '1', '会话超时，用户退出.', '2015-12-09 14:08:25', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('207', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 14:08:37', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('208', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 14:09:27', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('209', '1', '会话超时，用户退出.', '2015-12-09 14:10:13', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('210', '1', '会话超时，用户退出.', '2015-12-09 14:10:43', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('211', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 14:16:21', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('212', '1', '会话超时，用户退出.', '2015-12-09 14:17:25', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('213', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 14:17:39', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('214', '1', '会话超时，用户退出.', '2015-12-09 14:19:31', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('215', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 14:21:32', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('216', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 14:22:10', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('217', '1', '会话超时，用户退出.', '2015-12-09 14:22:50', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('218', '1', '会话超时，用户退出.', '2015-12-09 14:23:44', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('219', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 14:25:47', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('220', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 14:49:42', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('221', '1', '会话超时，用户退出.', '2015-12-09 14:52:04', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('222', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 14:54:15', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('223', '1', '操作模块:会话管理,用户注销.', '2015-12-09 14:55:42', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('224', '1', '会话超时，用户退出.', '2015-12-09 14:56:46', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('225', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 14:57:50', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('226', '1', '会话超时，用户退出.', '2015-12-09 15:03:23', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('227', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 16:06:24', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('228', '1', '会话超时，用户退出.', '2015-12-09 16:08:21', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('229', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 16:08:35', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('230', '1', '会话超时，用户退出.', '2015-12-09 16:09:57', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('231', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 16:10:07', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('232', '1', '会话超时，用户退出.', '2015-12-09 16:15:09', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('233', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 16:20:06', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('234', '1', '会话超时，用户退出.', '2015-12-09 16:21:51', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('235', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 16:23:37', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('236', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 16:28:57', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('237', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 16:30:59', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('238', '1', '会话超时，用户退出.', '2015-12-09 16:32:43', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('239', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 16:33:47', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('240', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 16:34:56', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('241', '1', '会话超时，用户退出.', '2015-12-09 16:36:22', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('242', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 16:36:37', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('243', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 16:38:32', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('244', '1', '会话超时，用户退出.', '2015-12-09 16:39:54', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('245', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 16:41:33', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('246', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 16:43:11', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('247', '1', '会话超时，用户退出.', '2015-12-09 16:43:12', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('248', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 16:45:59', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('249', '1', '会话超时，用户退出.', '2015-12-09 16:47:20', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('250', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 16:49:34', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('251', '1', '会话超时，用户退出.', '2015-12-09 16:50:56', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('252', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 17:01:17', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('253', '1', '会话超时，用户退出.', '2015-12-09 17:05:02', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('254', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 17:05:59', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('255', '1', '会话超时，用户退出.', '2015-12-09 17:07:38', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('256', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 17:16:26', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('257', '1', '会话超时，用户退出.', '2015-12-09 17:21:32', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('258', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 17:22:06', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('259', '1', '会话超时，用户退出.', '2015-12-09 17:23:14', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('260', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 17:23:21', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('261', '1', '会话超时，用户退出.', '2015-12-09 17:24:26', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('262', '1', '操作模块:会话管理,用户登陆.', '2015-12-09 17:25:42', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('263', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 09:21:46', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('264', '1', '会话超时，用户退出.', '2015-12-10 09:23:27', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('265', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 09:39:31', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('266', '1', '会话超时，用户退出.', '2015-12-10 09:41:04', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('267', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 10:15:59', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('268', '1', '会话超时，用户退出.', '2015-12-10 10:17:52', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('269', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 10:22:30', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('270', '1', '会话超时，用户退出.', '2015-12-10 10:23:39', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('271', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 10:26:19', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('272', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 10:30:01', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('273', '1', '会话超时，用户退出.', '2015-12-10 10:37:18', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('274', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 10:38:26', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('275', '1', '会话超时，用户退出.', '2015-12-10 10:42:42', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('276', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 13:19:42', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('277', '1', '会话超时，用户退出.', '2015-12-10 13:20:45', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('278', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 13:21:01', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('279', '1', '会话超时，用户退出.', '2015-12-10 13:23:50', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('280', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 13:26:11', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('281', '1', '会话超时，用户退出.', '2015-12-10 13:27:22', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('282', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 13:27:30', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('283', '1', '会话超时，用户退出.', '2015-12-10 13:29:57', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('284', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 13:34:29', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('285', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 13:39:40', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('286', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 14:31:36', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('287', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 14:34:40', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('288', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 14:43:04', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('289', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 14:51:05', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('290', '1', '操作模块:会话管理,用户注销.', '2015-12-10 14:57:02', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('291', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 14:57:08', '0:0:0:0:0:0:0:1', '');

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
  CONSTRAINT `roleId_fk` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`),
  CONSTRAINT `userId_role_fk` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role_link
-- ----------------------------

-- ----------------------------
-- Table structure for voltage_rank_classify
-- ----------------------------
DROP TABLE IF EXISTS `voltage_rank_classify`;
CREATE TABLE `voltage_rank_classify` (
  `id` tinyint(4) NOT NULL COMMENT '电压等级分类表',
  `name` varchar(20) DEFAULT '' COMMENT '电压等级名称',
  `value` int(8) DEFAULT '0' COMMENT '对应的电压  对应单位 kv',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of voltage_rank_classify
-- ----------------------------
INSERT INTO `voltage_rank_classify` VALUES ('1', '500kv以上', '1000');
INSERT INTO `voltage_rank_classify` VALUES ('2', '500kv', '500');
INSERT INTO `voltage_rank_classify` VALUES ('3', '220kv', '220');
INSERT INTO `voltage_rank_classify` VALUES ('4', '110kv', '110');
