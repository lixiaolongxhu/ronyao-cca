/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : cca

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2016-01-06 14:18:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for annual_output
-- ----------------------------
DROP TABLE IF EXISTS `annual_output`;
CREATE TABLE `annual_output` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '施工姓名部年产值配置表',
  `voltageRankId` int(4) DEFAULT NULL COMMENT '电压等级外键关联  kv',
  `projectType` tinyint(4) DEFAULT '1' COMMENT ' 1 线路工程项目 2 变电工程项目',
  `timeLimit` tinyint(4) DEFAULT '1' COMMENT '合理工期  单位月',
  `projectNum` decimal(10,2) DEFAULT '0.00' COMMENT '单个项目部完成项目个数(个/年)',
  `annualOutPut` int(11) DEFAULT '0' COMMENT '年产值',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `createTime` varchar(20) DEFAULT '',
  `updateTime` varchar(20) DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `annual_voltageRankId_fk` (`voltageRankId`,`projectType`) USING BTREE,
  CONSTRAINT `output_voltaget_fk` FOREIGN KEY (`voltageRankId`) REFERENCES `voltage_rank_classify` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of annual_output
-- ----------------------------
INSERT INTO `annual_output` VALUES ('7', '1', '1', '18', '0.67', '17000', '特高压线路', '2015-12-15 16:32:16', '2015-12-15 16:36:18');
INSERT INTO `annual_output` VALUES ('8', '2', '1', '16', '0.75', '6400', '', '2015-12-15 16:32:36', '');
INSERT INTO `annual_output` VALUES ('9', '3', '1', '14', '0.86', '3200', '', '2015-12-15 16:33:00', '');
INSERT INTO `annual_output` VALUES ('10', '4', '1', '12', '1.00', '1600', '', '2015-12-15 16:33:22', '');
INSERT INTO `annual_output` VALUES ('12', '1', '2', '18', '0.63', '8500', '特高压变电', '2015-12-15 16:34:05', '2015-12-15 16:36:26');
INSERT INTO `annual_output` VALUES ('13', '2', '2', '16', '0.75', '6800', '', '2015-12-15 16:34:31', '');
INSERT INTO `annual_output` VALUES ('14', '3', '2', '14', '0.86', '2500', '', '2015-12-15 16:35:01', '');
INSERT INTO `annual_output` VALUES ('15', '4', '2', '12', '1.00', '1400', '', '2015-12-15 16:35:18', '');

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
  `correction` decimal(10,2) DEFAULT NULL COMMENT '修正系数',
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `behavior_enterpriseId_fk` (`enterpriseId`,`year`) USING BTREE,
  CONSTRAINT `behavior_enterpriseId_fk` FOREIGN KEY (`enterpriseId`) REFERENCES `enterprise` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of behavior
-- ----------------------------
INSERT INTO `behavior` VALUES ('1', '78', '2015', '1', '0', '1.00', '2015-12-30 15:25:12', '');
INSERT INTO `behavior` VALUES ('2', '79', '2015', '1', '0', '1.00', '2015-12-30 15:25:21', '');
INSERT INTO `behavior` VALUES ('3', '80', '2015', '1', '0', '1.00', '2015-12-30 15:25:41', '');
INSERT INTO `behavior` VALUES ('4', '81', '2015', '0', '0', '1.00', '2015-12-30 15:25:49', '');
INSERT INTO `behavior` VALUES ('5', '82', '2015', '0', '0', '1.00', '2015-12-30 15:26:09', '');
INSERT INTO `behavior` VALUES ('6', '83', '2015', '1', '0', '1.00', '2015-12-30 15:26:23', '');
INSERT INTO `behavior` VALUES ('7', '84', '2015', '0', '0', '1.00', '2015-12-30 15:26:56', '');
INSERT INTO `behavior` VALUES ('8', '85', '2015', '3', '0', '0.80', '2015-12-30 15:27:11', '');
INSERT INTO `behavior` VALUES ('9', '86', '2015', '0', '0', '1.00', '2015-12-30 15:27:47', '');
INSERT INTO `behavior` VALUES ('10', '87', '2015', '1', '0', '1.00', '2015-12-30 15:27:57', '2015-12-30 15:45:57');
INSERT INTO `behavior` VALUES ('11', '88', '2015', '0', '0', '1.00', '2015-12-30 15:46:41', '');
INSERT INTO `behavior` VALUES ('12', '89', '2015', '0', '1', '0.80', '2015-12-30 15:46:51', '');
INSERT INTO `behavior` VALUES ('13', '90', '2015', '0', '0', '1.00', '2015-12-30 15:47:00', '');
INSERT INTO `behavior` VALUES ('14', '91', '2015', '0', '0', '1.00', '2015-12-30 15:47:10', '');
INSERT INTO `behavior` VALUES ('15', '92', '2015', '3', '0', '0.80', '2015-12-30 15:47:24', '');
INSERT INTO `behavior` VALUES ('16', '93', '2015', '0', '0', '1.00', '2015-12-30 15:47:39', '');
INSERT INTO `behavior` VALUES ('17', '94', '2015', '0', '0', '1.00', '2015-12-30 16:08:28', '');
INSERT INTO `behavior` VALUES ('18', '95', '2015', '1', '0', '1.00', '2015-12-30 16:08:42', '');
INSERT INTO `behavior` VALUES ('19', '96', '2015', '1', '0', '1.00', '2015-12-30 16:09:00', '');
INSERT INTO `behavior` VALUES ('20', '97', '2015', '0', '0', '1.00', '2015-12-30 16:09:12', '');
INSERT INTO `behavior` VALUES ('21', '98', '2015', '1', '0', '1.00', '2015-12-30 16:09:28', '');
INSERT INTO `behavior` VALUES ('22', '99', '2015', '0', '0', '1.00', '2015-12-30 16:09:45', '');
INSERT INTO `behavior` VALUES ('23', '100', '2015', '0', '0', '1.00', '2015-12-30 16:10:04', '');
INSERT INTO `behavior` VALUES ('24', '101', '2015', '0', '0', '1.00', '2015-12-30 16:10:24', '');
INSERT INTO `behavior` VALUES ('25', '102', '2015', '4', '1', '0.60', '2015-12-30 16:11:12', '');
INSERT INTO `behavior` VALUES ('26', '103', '2015', '1', '0', '1.00', '2015-12-30 16:11:23', '');
INSERT INTO `behavior` VALUES ('27', '78', '2014', '0', '0', '1.00', '2016-01-05 13:57:13', '');

-- ----------------------------
-- Table structure for behavior_standard
-- ----------------------------
DROP TABLE IF EXISTS `behavior_standard`;
CREATE TABLE `behavior_standard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '不良行为分类标准配置',
  `rankType` tinyint(4) DEFAULT NULL COMMENT '不良行为等级分类 1 严重不良行为  2 一般不良行为',
  `sincerity` text COMMENT '诚信 ',
  `save` text COMMENT '安全质量',
  `progress` text COMMENT '履约进度',
  `service` text COMMENT '服务',
  `other` text COMMENT '其他',
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of behavior_standard
-- ----------------------------
INSERT INTO `behavior_standard` VALUES ('5', '1', '1.以行贿手段骗取中标的； \n2.捏造事实或者提供虚假投诉材料， 诋毁、 排挤其他承包商进行恶意投诉的；\n3.在投标过程中相互串通投标或者与招标人串通投标的；\n4.在参与招标采购活动中提供虚假信息、 伪造证明文件或资质业绩信息发生实质性变化未及时作出说明， 对中标结果造成实质性影响的；\n5.被国家有关行政监督部门取消投标资格， 但依然参与工程投标的；\n6.拖欠或克扣劳动者工资引起上访给公司造成严重不良社会影响的；\n7.伪造虚假工程量， 骗取工程款的；\n8.违法转包或对主体工程、关键性工作进行分包的。', '9.因承包商原因发生五级及以上人身安全事件，或电网、设备安全事件，或质量事件的；\n10.不按图施工、偷工减料或使用不合格乙供材料等，致使工程存在安全质量隐患的；\n11.因承包商原因未实现工程达标投产及国网优质工程目标的；\n12.因承包商原因引发不稳定事件， 或因不良事件经新闻媒介曝光，给公司带来负面影响的。', '13.拒不履行合同或单方中止合同， 给工程造成严重影响的；\n14.因承包商原因，导致工程未按里程碑计划开工、投产，延误超过60天的。', '15.项目经理、主要技术人员不能胜任工作，业主或建设管理单位（业主项目部）明确要求更换，承包商拒不更换或久拖不决的；\n16.拒不服从业主或建设管理单位（业主项目部）正常管理，对工程建设造成不良影响的；', '17.一个自然年内在公司系统内发生三次及以上一般不良行为的 ；\n18.其他经公司 认定为严重不良 行为的。', '2015-12-29 15:43:31', '');
INSERT INTO `behavior_standard` VALUES ('6', '2', '1.拖欠或克扣劳动者工资引起上访给公司造成不良社会影响的；\n2.违反合同约定对非主体工程进行分包的。', '3.因承包商原因发生以下情况之一的：发生六级人身事件，发生因工程建设引起的六级电网及设备事件， 发生六级质量事件，发生六级及以上施工机械设备事件，发生火灾事故，发生环境污染事件，发生负主要责任的一般及以上交通事故，发生基建信息安全事件，发生对公司造成影响的安全稳定事件；\n4.因承包商原因造成工程“标准工艺” 应用率低于合同约定值的；\n5.现场安全文明施工管理混乱，承包商拒不整改或多次整改仍达不到要求的；\n6.施工安全风险管控不到位，未落实风险分级管控和挂牌督查要求的；\n7.安全文明措施费挪作他用的；\n8.对分包单位管理不力，对工程建设造成损失或影响的。', '9.因承包商原因， 导致工程未按里程碑计划开工、 投产， 延误超过30天的；\n10.工程进度滞后， 承包商拒不整改或多次整改仍达不到要求的。', '11.未按合同约定或投标文件中承诺、业主或建设管理单位（业主项目部） 要求投入人力、机具等资源的；\n12.项目经理、主要管理人员、主要技术人员不能胜任工作， 被业主或建设管理单位（业主项目部）投诉的；\n13.不配合属地协调工作， 造成属地协调工作无法有效开展，被业主或建设管理单位、属地公司投诉的；\n14.拒不参加施工图会检、工程协调会等会议的；\n15.拒不配合建设管理单位（业主项目部）开展工程全过程创优（流动红旗、 鲁班奖等）工作的；\n16.档案资料管理不到位， 致使过程档案资料不齐全，或不能及时按要求移交完整工程档案资料的；\n17.基建管理信息系统填报准确性、完整性、及时性较差的；\n18.在质保期内不积极配合建设管理单位进行消缺，影响设备正常运行的。\n19.因承包商原因造成工程不能按时结算的。', '20.其他经公司认定为一般不良行为的。', '2015-12-29 15:44:12', '');

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
  `outputLast` int(8) DEFAULT '0' COMMENT '当前年份对应的去年产值',
  `outputBefore` int(8) DEFAULT '0' COMMENT '当前年份对应的前年产值',
  `outputBeforeLast` int(8) DEFAULT '0' COMMENT '当前年份对应的上前年产值',
  `project` int(4) DEFAULT '0' COMMENT '近三年工程数量',
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  `projectLast` int(8) DEFAULT '0' COMMENT '当前年份对应的去年完成的工程数',
  `projectBefore` int(8) DEFAULT '0' COMMENT '当前年份对应的前年完成的工程数',
  `projectBeforeLast` int(8) DEFAULT '0' COMMENT '当前年份对应的上前年完成的工程数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `enter_fullname_id` (`fullName`),
  KEY `enter_overallRank_id_fk` (`overallRank`),
  KEY `enter_professionRank_id_fk` (`professionRank`),
  CONSTRAINT `enter_overallRank_id_fk` FOREIGN KEY (`overallRank`) REFERENCES `aptituderank_classify` (`id`),
  CONSTRAINT `enter_professionRank_id_fk` FOREIGN KEY (`professionRank`) REFERENCES `aptituderank_classify` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise
-- ----------------------------
INSERT INTO `enterprise` VALUES ('78', '四川公司', '四川送变电', '四川电力送变电建设公司', '1', '8800', '40030', '1069', '1', '1', '249625', '249625', '0', '0', '30', '2015-12-29 11:22:29', '2015-12-29 11:23:06', '10', '10', '10');
INSERT INTO `enterprise` VALUES ('79', '科锐得', '四川蜀能', '四川蜀能电力有限公司', '2', '7107', '0', '602', '-1', '1', '163338', '163338', '0', '0', '29', '2015-12-29 11:24:24', '', '10', '10', '9');
INSERT INTO `enterprise` VALUES ('80', '成都', '成都电建', '四川电力建设公司', '2', '10000', '20768', '332', '1', '2', '125716', '125716', '0', '0', '54', '2015-12-29 11:25:53', '', '54', '0', '0');
INSERT INTO `enterprise` VALUES ('81', '成都', '成都供用电', '成都供用电工程公司', '2', '2100', '10400', '384', '-1', '2', '43233', '43233', '0', '0', '40', '2015-12-29 11:27:28', '2015-12-30 14:31:58', '20', '15', '5');
INSERT INTO `enterprise` VALUES ('82', '成都', '成都宏业', '四川宏业电力集团有限公司', '2', '10000', '26143', '1087', '2', '2', '14168', '14168', '0', '0', '12', '2015-12-29 11:29:07', '', '12', '0', '0');
INSERT INTO `enterprise` VALUES ('83', '乐山', '乐山嘉能佳', '四川嘉能佳电力集团有限责任公司', '2', '11396', '14470', '131', '2', '-1', '43500', '43400', '40', '60', '25', '2015-12-29 12:12:37', '', '10', '2', '13');
INSERT INTO `enterprise` VALUES ('84', '攀枝花', '攀枝花网源', '攀枝花网源电力建设工程公司', '2', '4500', '11940', '1254', '2', '2', '17217', '17217', '0', '0', '10', '2015-12-29 13:20:44', '', '10', '0', '0');
INSERT INTO `enterprise` VALUES ('85', '德阳', '德阳明源', '德阳明源电力（集团）有限公司', '2', '7000', '23018', '215', '1', '-1', '46514', '46514', '0', '0', '22', '2015-12-29 13:22:13', '', '22', '0', '0');
INSERT INTO `enterprise` VALUES ('86', '眉山', '眉山多能', '眉山多能电力建设有限责任公司', '2', '2400', '4336', '173', '-1', '2', '6160', '6160', '0', '0', '8', '2015-12-29 13:23:41', '', '8', '0', '0');
INSERT INTO `enterprise` VALUES ('87', '雅安', '雅安科元', '雅安科元电力建设有限公司', '2', '1200', '25152', '653', '-1', '3', '10055', '10055', '0', '0', '14', '2015-12-29 13:26:14', '', '14', '0', '0');
INSERT INTO `enterprise` VALUES ('88', '达州', '达州惠特', '四川惠特电力投资建设有限公司', '2', '4800', '13100', '465', '2', '-1', '26884', '26884', '0', '0', '19', '2015-12-29 13:29:04', '', '19', '0', '0');
INSERT INTO `enterprise` VALUES ('89', '绵阳', '绵阳启明星', '绵阳启明星集团有限公司', '2', '6000', '28000', '544', '2', '-1', '65900', '65900', '0', '0', '51', '2015-12-29 13:30:37', '', '51', '0', '0');
INSERT INTO `enterprise` VALUES ('90', '宜宾', '宜宾远能', '宜宾远能电业集团有限责任公司', '2', '6202', '5500', '471', '2', '-1', '12106', '12106', '0', '0', '10', '2015-12-29 13:32:24', '', '10', '0', '0');
INSERT INTO `enterprise` VALUES ('91', '凉山', '西昌电力', '西昌电力工程公司', '2', '2400', '807', '402', '2', '2', '9473', '9473', '0', '0', '15', '2015-12-29 13:33:35', '', '15', '0', '0');
INSERT INTO `enterprise` VALUES ('92', '内江', '内江星原', '内江星原电力集团有限责任公司', '2', '5000', '37360', '764', '2', '2', '19491', '19491', '0', '0', '22', '2015-12-29 13:34:59', '', '22', '0', '0');
INSERT INTO `enterprise` VALUES ('93', '广元', '广元电力', '广元电力开发总公司', '2', '4000', '14022', '1452', '-1', '2', '6134', '6134', '0', '0', '5', '2015-12-29 13:36:33', '', '5', '0', '0');
INSERT INTO `enterprise` VALUES ('94', '广元', '广元天源', '四川苍溪天源电力开发有限公司', '2', '1500', '2235', '203', '-1', '3', '1027', '1027', '0', '0', '2', '2015-12-29 13:37:36', '', '2', '0', '0');
INSERT INTO `enterprise` VALUES ('95', '泸州', '泸州合能', '泸州合能实业有限责任公司', '2', '4888', '8731', '80', '2', '2', '11634', '11634', '0', '0', '8', '2015-12-29 13:40:04', '', '8', '0', '0');
INSERT INTO `enterprise` VALUES ('96', '南充', '南充恒通', '四川南充恒通电力有限公司', '2', '4100', '6529', '500', '2', '-1', '23193', '23193', '0', '0', '6', '2015-12-29 13:41:12', '', '6', '0', '0');
INSERT INTO `enterprise` VALUES ('97', '自贡', '自贡电建', '自贡电力建设集团有限公司', '2', '2418', '2608', '417', '-1', '2', '16012', '16012', '0', '0', '7', '2015-12-29 13:42:13', '', '7', '0', '0');
INSERT INTO `enterprise` VALUES ('98', '广安', '广安和源', '四川和源电力有限公司', '2', '2056', '3947', '299', '-1', '2', '25770', '25770', '0', '0', '10', '2015-12-29 13:43:25', '', '10', '0', '0');
INSERT INTO `enterprise` VALUES ('99', '资阳', '资阳资源', '资阳资源电力集团有限公司', '2', '5125', '6301', '1359', '-1', '2', '13246', '13246', '0', '0', '8', '2015-12-29 13:44:32', '', '8', '0', '0');
INSERT INTO `enterprise` VALUES ('100', '遂宁', '遂宁江源', '遂宁市江源实业有限公司', '2', '2400', '2387', '466', '-1', '2', '12947', '12947', '0', '0', '10', '2015-12-29 13:46:11', '', '10', '0', '0');
INSERT INTO `enterprise` VALUES ('101', '巴中', '巴中和兴', '四川巴中和兴电力有限责任公司', '2', '2460', '2660', '519', '-1', '2', '12475', '12475', '0', '0', '6', '2015-12-29 13:50:01', '', '6', '0', '0');
INSERT INTO `enterprise` VALUES ('102', '甘孜', '甘孜电建', '甘孜电力建设有限公司', '2', '1200', '3246', '12', '-1', '3', '0', '0', '0', '0', '0', '2015-12-29 13:51:30', '', '0', '0', '0');
INSERT INTO `enterprise` VALUES ('103', '格瑞德', '电力实业', '四川电力实业总公司', '2', '2400', '0', '238', '2', '2', '10150', '10150', '0', '0', '6', '2015-12-29 13:52:43', '', '6', '0', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise_aptitude
-- ----------------------------
INSERT INTO `enterprise_aptitude` VALUES ('6', '1', '1', '净资产1亿元以上', '机电工程专业一级注册建造师不少于15人', '具有10年以上从事工程施工技术管理工作经历，且具有电力工程相关专业高级职称', '电力工程相关专业中级以上职称人员不少于60人，持有岗位证书的施工现场管理人员不少于50人，且施工员、质量员、安全员、造价员、资料员等人员齐全', '经考核或培训合格的中级工以上技术工人不少于150人', '可承担各类发电工程、各种电压等级送电线路和变电站工程的施工', '2015-12-29 15:35:48', '');
INSERT INTO `enterprise_aptitude` VALUES ('7', '1', '2', '净资产4000万元以上', '机电工程专业注册建造师不少于10人', '具有8年以上从事工程施工技术管理工作经历，且具有电力工程相关专业高级职称或机电工程专业一级注册建造师执业资格', '电力工程相关专业中级以上职称人员不少于30人，持有岗位证书的施工现场管理人员不少于30人，且施工员、质量员、安全员、资料员等人员齐全', '经考核或培训合格的中级工以上技术工人不少于75人', '可承担单机容量20万千瓦以下发电工程、220千伏以下送电线路和相同电压等级变电站工程的施工', '2015-12-29 15:36:23', '');
INSERT INTO `enterprise_aptitude` VALUES ('8', '1', '3', '净资产800万元以上', '', '具有5年以上从事工程施工技术管理工作经历，且具有电力工程相关专业中级以上职称或机电工程专业注册建造师执业资格，技术负责人（或注册建造师）主持完成过本类别工程业绩不少于2项', '电力工程相关专业中级以上职称人员不少于10人，持有岗位证书的施工现场管理人员不少于15人，且施工员、质量员、安全员、资料员等人员齐全', '经考核或培训合格的中级工以上技术工人不少于30人', '可承担单机容量10万千瓦以下发电工程、110千伏以下送电线路和相同电压等级变电站工程的施工', '2015-12-29 15:36:53', '');
INSERT INTO `enterprise_aptitude` VALUES ('9', '2', '1', '净资产5000万元以上', '机电工程专业一级注册建造师不少于10人', '具有10年以上从事工程施工技术管理工作经历，且具有电力工程相关专业高级职称', '电力工程相关专业中级以上职称人员不少于60人，持有岗位证书的施工现场管理人员不少于40人，且质量员、安全员、资料员、造价员等人员齐全', '电力工程相关专业中级以上职称人员不少于60人，持有岗位证书的施工现场管理人员不少于40人，且质量员、安全员、资料员、造价员等人员齐全', '可承担各种电压等级的送电线路和变电站工程的施工', '2015-12-29 15:37:26', '');
INSERT INTO `enterprise_aptitude` VALUES ('10', '2', '2', '净资产3000万元以上', '机电工程专业注册建造师不少于8人', '具有8年以上从事工程施工技术管理工作经历，且具有电力工程相关专业高级职称或机电工程专业一级注册建造师执业资格', '电力工程相关专业中级以上职称人员不少于40人，持有岗位证书的施工现场管理人员不少于30人，且质量员、安全员、资料员、造价员等人员齐全', '经考核或培训合格的线路架设工、变电安装工等中级工以上技术工人不少于30人', '可承担220千伏以下电压等级的送电线路和变电站工程的施工', '2015-12-29 15:38:12', '');
INSERT INTO `enterprise_aptitude` VALUES ('11', '2', '3', '净资产800万元以上', '机电工程专业注册建造师不少于3人', '具有5年以上从事工程施工技术管理工作经历，且具有电力工程相关专业中级以上职称或机电工程专业注册建造师执业资格', '电力工程相关专业中级以上职称人员不少于20人，持有岗位证书的施工现场管理人员不少于20人，且质量员、安全员、资料员、造价员等人员齐全', '经考核或培训合格的线路架设工、变电安装工等中级工以上技术工人不少于30人', '可承担110千伏以下电压等级的送电线路和变电站工程的施工', '2015-12-29 15:39:00', '');

-- ----------------------------
-- Table structure for enterprise_assess
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_assess`;
CREATE TABLE `enterprise_assess` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '施工企业批过分类(与修正后的承载能力对比)',
  `category` varchar(10) DEFAULT '' COMMENT '类别',
  `standard` varchar(255) DEFAULT '' COMMENT '标准',
  `projectNumStart` int(4) DEFAULT '0' COMMENT '可承载工程数量  大于该数',
  `projectNumEnd` int(4) DEFAULT NULL COMMENT '可承载工程数量  小于该数',
  `outputStart` decimal(10,2) DEFAULT NULL COMMENT '可承载工程产值 (单位 亿元) 大于该值',
  `outputEnd` decimal(10,2) DEFAULT NULL COMMENT '可承载工程产值 (单位 亿元) 小于该值',
  `enterprise` text COMMENT '对应分类标准满足条件的企业信息, 该信息由程序动态生成',
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `enter_assess_category_uniquie` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise_assess
-- ----------------------------
INSERT INTO `enterprise_assess` VALUES ('1', 'A类', '施工管理、技术力量强，主要工序工作由自己员工承担，少量采用劳务分包', '15', null, '10.00', null, null, '2015-12-17 11:26:36', '2015-12-30 16:17:42');
INSERT INTO `enterprise_assess` VALUES ('3', 'B类', '施工管理、技术力量较强，主要工序工作由自己员工承担，部分采用劳务分包', '7', '12', '4.00', '6.00', '', '2015-12-17 11:37:00', '2015-12-30 16:17:57');
INSERT INTO `enterprise_assess` VALUES ('4', 'C类', '施工管理、技术力量较强，主要工序工作由自己员工承担或管控，部分采用劳务分包', '6', '12', '2.00', '3.00', '', '2015-12-17 11:38:36', '2015-12-30 16:18:08');
INSERT INTO `enterprise_assess` VALUES ('5', 'D类', '施工管理、技术力量一般，主要工序工作由自己员工承担或管控，大部分采用劳务分包', '4', '8', '1.00', '2.00', '', '2015-12-17 12:22:51', '2015-12-30 16:18:20');
INSERT INTO `enterprise_assess` VALUES ('6', 'E类', '有少量的施工管理、技术力量，主要工序工作由自己员工管控，主要采用劳务分包', '3', '6', '0.50', '1.50', '', '2015-12-17 12:23:11', '2015-12-30 16:18:30');
INSERT INTO `enterprise_assess` VALUES ('7', 'F类', '有少量的施工管理、技术力量，主要工序工作由自己员工管控，主要采用劳务分包', '1', '3', null, '0.50', '', '2015-12-17 12:25:51', '2015-12-30 16:19:50');

-- ----------------------------
-- Table structure for enterprise_equipment
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_equipment`;
CREATE TABLE `enterprise_equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '企业施工装备信息',
  `enterpriseId` int(11) NOT NULL COMMENT '施工企业名称信息外键',
  `bigEquipment` int(4) DEFAULT '0' COMMENT '大张牵设备(套)',
  `smallEquipment` int(4) DEFAULT '0' COMMENT '小张牵设备(套)',
  `sum` int(4) DEFAULT '0' COMMENT '合计',
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `enter_equipement_id_fk` (`enterpriseId`) USING BTREE,
  CONSTRAINT `enter_equipement_id_fk` FOREIGN KEY (`enterpriseId`) REFERENCES `enterprise` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise_equipment
-- ----------------------------
INSERT INTO `enterprise_equipment` VALUES ('1', '78', '17', '30', '47', '2015-12-30 14:01:58', '');
INSERT INTO `enterprise_equipment` VALUES ('2', '79', '2', '3', '5', '2015-12-30 14:02:07', '');
INSERT INTO `enterprise_equipment` VALUES ('3', '80', '4', '13', '17', '2015-12-30 14:02:15', '');
INSERT INTO `enterprise_equipment` VALUES ('4', '81', '1', '2', '3', '2015-12-30 14:02:30', '');
INSERT INTO `enterprise_equipment` VALUES ('5', '82', '0', '0', '0', '2015-12-30 14:02:40', '');
INSERT INTO `enterprise_equipment` VALUES ('6', '83', '0', '2', '2', '2015-12-30 14:02:46', '');
INSERT INTO `enterprise_equipment` VALUES ('7', '84', '1', '0', '1', '2015-12-30 14:02:55', '');
INSERT INTO `enterprise_equipment` VALUES ('8', '85', '2', '3', '5', '2015-12-30 14:03:02', '');
INSERT INTO `enterprise_equipment` VALUES ('9', '86', '2', '1', '3', '2015-12-30 14:03:11', '');
INSERT INTO `enterprise_equipment` VALUES ('10', '87', '0', '1', '1', '2015-12-30 14:03:19', '');
INSERT INTO `enterprise_equipment` VALUES ('11', '88', '0', '1', '1', '2015-12-30 14:03:34', '');
INSERT INTO `enterprise_equipment` VALUES ('12', '89', '1', '2', '3', '2015-12-30 14:03:44', '');
INSERT INTO `enterprise_equipment` VALUES ('13', '90', '0', '0', '0', '2015-12-30 14:03:55', '');
INSERT INTO `enterprise_equipment` VALUES ('14', '91', '0', '0', '0', '2015-12-30 14:04:04', '');
INSERT INTO `enterprise_equipment` VALUES ('15', '92', '4', '3', '7', '2015-12-30 14:04:30', '');
INSERT INTO `enterprise_equipment` VALUES ('16', '93', '3', '6', '9', '2015-12-30 14:04:43', '2015-12-30 14:05:01');
INSERT INTO `enterprise_equipment` VALUES ('17', '94', '0', '1', '1', '2015-12-30 14:05:12', '');
INSERT INTO `enterprise_equipment` VALUES ('18', '95', '1', '1', '2', '2015-12-30 14:05:22', '');
INSERT INTO `enterprise_equipment` VALUES ('19', '96', '3', '8', '11', '2015-12-30 14:05:41', '');
INSERT INTO `enterprise_equipment` VALUES ('20', '97', '0', '0', '0', '2015-12-30 14:05:53', '');
INSERT INTO `enterprise_equipment` VALUES ('21', '98', '0', '0', '0', '2015-12-30 14:06:00', '');
INSERT INTO `enterprise_equipment` VALUES ('22', '99', '1', '4', '5', '2015-12-30 14:06:15', '');
INSERT INTO `enterprise_equipment` VALUES ('23', '100', '1', '2', '3', '2015-12-30 14:06:28', '');
INSERT INTO `enterprise_equipment` VALUES ('24', '101', '1', '1', '2', '2015-12-30 14:06:40', '');
INSERT INTO `enterprise_equipment` VALUES ('25', '102', '0', '2', '2', '2015-12-30 14:06:52', '');
INSERT INTO `enterprise_equipment` VALUES ('26', '103', '0', '0', '0', '2015-12-30 14:07:09', '');

-- ----------------------------
-- Table structure for enterprise_file
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_file`;
CREATE TABLE `enterprise_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '企业资质信息上传的附件表',
  `enterpriseId` int(11) DEFAULT NULL,
  `fileType` tinyint(4) DEFAULT '1' COMMENT '上传的文件类型 1 图片',
  `aptitudeRankId` tinyint(4) DEFAULT '1' COMMENT '资质分类等级',
  `aptitudeId` tinyint(4) DEFAULT '1' COMMENT ' 企业资质类型1  总承包 ,2 专业承包 ',
  `path` varchar(50) DEFAULT '' COMMENT '文件存储的路径',
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `enterprise_file_id_fk` (`enterpriseId`),
  KEY `enterprise_file_aptitudeId_fk` (`aptitudeId`),
  KEY `enterprise_fileaptitudeRankId_fk` (`aptitudeRankId`),
  CONSTRAINT `enterprise_fileaptitudeRankId_fk` FOREIGN KEY (`aptitudeRankId`) REFERENCES `aptituderank_classify` (`id`),
  CONSTRAINT `enterprise_file_aptitudeId_fk` FOREIGN KEY (`aptitudeId`) REFERENCES `aptitude_classify` (`id`),
  CONSTRAINT `enterprise_file_id_fk` FOREIGN KEY (`enterpriseId`) REFERENCES `enterprise` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise_file
-- ----------------------------
INSERT INTO `enterprise_file` VALUES ('1', '78', '1', '1', '1', '20160104144929145.jpg', '2016-01-04 14:49:29', null);

-- ----------------------------
-- Table structure for enterprise_person
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_person`;
CREATE TABLE `enterprise_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '施工企业持证人员',
  `enterpriseId` int(11) DEFAULT NULL COMMENT '企业基本信息表外键',
  `constructorOne` int(8) DEFAULT '0' COMMENT '国家注册建造师  一级人数',
  `constructorTwo` int(8) DEFAULT '0' COMMENT '国家注册建造师 二级',
  `constructorTotal` int(8) DEFAULT '0' COMMENT '国家注册建造师  人数 合计',
  `staffMiddle` int(8) DEFAULT '0' COMMENT '中级以上职称人员  中级  ',
  `staffHigh` int(8) DEFAULT '0' COMMENT '中级以上职称人员  高级',
  `staffTotal` int(8) DEFAULT '0' COMMENT '中级以上职称人员  合计',
  `skillMiddle` int(8) DEFAULT '0' COMMENT '中级工以上技术人员   中级',
  `skillHigh` int(8) DEFAULT '0' COMMENT '中级工以上技术人员   高级',
  `skillTech` int(8) DEFAULT '0' COMMENT '中级工以上技术人员  技师',
  `skillTechHigh` int(8) DEFAULT '0' COMMENT '中级工以上技术人员  高级技师',
  `skillTotal` int(8) DEFAULT NULL COMMENT '中级工以上技术人员   合计',
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `enterprise_per_id_fk` (`enterpriseId`) USING BTREE,
  CONSTRAINT `enterprise_per_id_fk` FOREIGN KEY (`enterpriseId`) REFERENCES `enterprise` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise_person
-- ----------------------------
INSERT INTO `enterprise_person` VALUES ('3', '78', '36', '27', '63', '146', '54', '200', '47', '187', '293', '42', '569', '2015-12-29 13:55:46', '');
INSERT INTO `enterprise_person` VALUES ('4', '79', '15', '44', '59', '23', '9', '32', '80', '14', '38', '0', '132', '2015-12-29 13:56:19', '');
INSERT INTO `enterprise_person` VALUES ('5', '80', '7', '63', '70', '33', '5', '38', '66', '53', '43', '0', '162', '2015-12-29 13:57:02', '');
INSERT INTO `enterprise_person` VALUES ('6', '81', '6', '41', '47', '23', '3', '26', '26', '77', '24', '0', '127', '2015-12-29 13:57:53', '');
INSERT INTO `enterprise_person` VALUES ('7', '82', '4', '77', '81', '49', '7', '56', '96', '50', '35', '0', '181', '2015-12-29 13:58:26', '');
INSERT INTO `enterprise_person` VALUES ('8', '83', '0', '60', '60', '80', '30', '110', '293', '134', '80', '8', '515', '2015-12-29 14:06:58', '');
INSERT INTO `enterprise_person` VALUES ('9', '84', '1', '25', '26', '33', '8', '41', '3', '93', '31', '0', '127', '2015-12-29 14:07:45', '');
INSERT INTO `enterprise_person` VALUES ('10', '85', '17', '42', '59', '112', '24', '136', '383', '172', '153', '0', '708', '2015-12-29 14:08:10', '');
INSERT INTO `enterprise_person` VALUES ('11', '86', '3', '26', '29', '30', '9', '39', '41', '12', '20', '0', '73', '2015-12-29 14:09:02', '2015-12-29 14:09:43');
INSERT INTO `enterprise_person` VALUES ('12', '87', '5', '10', '15', '60', '4', '64', '0', '231', '132', '0', '363', '2015-12-29 14:10:22', '');
INSERT INTO `enterprise_person` VALUES ('13', '88', '1', '19', '20', '78', '5', '83', '58', '26', '17', '0', '101', '2015-12-29 14:11:01', '');
INSERT INTO `enterprise_person` VALUES ('14', '89', '9', '15', '24', '47', '14', '61', '172', '31', '23', '0', '226', '2015-12-29 14:11:27', '');
INSERT INTO `enterprise_person` VALUES ('15', '90', '1', '22', '23', '38', '12', '50', '78', '85', '20', '0', '183', '2015-12-29 14:11:49', '');
INSERT INTO `enterprise_person` VALUES ('16', '91', '0', '29', '29', '11', '4', '15', '40', '6', '0', '0', '46', '2015-12-29 14:12:43', '');
INSERT INTO `enterprise_person` VALUES ('17', '92', '1', '12', '13', '42', '15', '57', '42', '15', '196', '0', '253', '2015-12-29 14:13:15', '');
INSERT INTO `enterprise_person` VALUES ('18', '93', '1', '13', '14', '37', '9', '46', '134', '155', '57', '0', '346', '2015-12-29 14:14:03', '');
INSERT INTO `enterprise_person` VALUES ('19', '94', '0', '7', '7', '48', '0', '48', '18', '90', '12', '0', '120', '2015-12-29 14:14:26', '');
INSERT INTO `enterprise_person` VALUES ('20', '95', '1', '35', '36', '10', '5', '15', '2', '8', '11', '0', '21', '2015-12-29 14:15:01', '');
INSERT INTO `enterprise_person` VALUES ('21', '96', '1', '21', '22', '54', '7', '61', '5', '1', '8', '0', '14', '2015-12-29 14:15:35', '');
INSERT INTO `enterprise_person` VALUES ('22', '97', '2', '16', '18', '32', '19', '51', '36', '44', '37', '0', '117', '2015-12-29 14:16:20', '');
INSERT INTO `enterprise_person` VALUES ('23', '98', '7', '10', '17', '7', '8', '15', '84', '49', '62', '0', '195', '2015-12-29 14:16:47', '');
INSERT INTO `enterprise_person` VALUES ('24', '99', '0', '27', '27', '39', '4', '43', '213', '198', '101', '0', '512', '2015-12-29 14:17:17', '');
INSERT INTO `enterprise_person` VALUES ('25', '100', '0', '18', '18', '43', '6', '49', '40', '45', '53', '0', '138', '2015-12-29 14:17:53', '');
INSERT INTO `enterprise_person` VALUES ('26', '101', '0', '15', '15', '42', '2', '44', '4', '12', '5', '1', '22', '2015-12-29 14:18:13', '');
INSERT INTO `enterprise_person` VALUES ('27', '102', '0', '9', '9', '13', '0', '13', '31', '1', '4', '0', '36', '2015-12-29 14:18:38', '');
INSERT INTO `enterprise_person` VALUES ('28', '103', '4', '14', '18', '24', '1', '25', '29', '2', '3', '2', '36', '2015-12-29 14:19:07', '');

-- ----------------------------
-- Table structure for enterprise_per_file
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_per_file`;
CREATE TABLE `enterprise_per_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '企业持证人员情况附件记录表',
  `enterpriseId` int(11) DEFAULT '0' COMMENT '企业id 用于方便前端显示企业名称信息',
  `enterprisePerId` int(11) DEFAULT '0' COMMENT '企业持证人员基本信息表外键',
  `classify` varchar(30) DEFAULT '' COMMENT '持证人员分类',
  `rank` varchar(10) DEFAULT '' COMMENT '持证人员等级',
  `path` varchar(50) DEFAULT '' COMMENT '附件存放相对路径名称',
  `fileType` tinyint(4) DEFAULT '1' COMMENT '文件类型 1 图片',
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `enterprise_person_enterprisePerId_fk` (`enterprisePerId`),
  CONSTRAINT `enterprise_person_enterprisePerId_fk` FOREIGN KEY (`enterprisePerId`) REFERENCES `enterprise_person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise_per_file
-- ----------------------------
INSERT INTO `enterprise_per_file` VALUES ('1', '78', '3', '中级以上职称人员', '二级', '20160104162837381.jpg', '1', '2016-01-04 16:28:37', null);

-- ----------------------------
-- Table structure for enterprise_per_manage
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_per_manage`;
CREATE TABLE `enterprise_per_manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '施工企业 (现场管理人员)     线路专业,与变电专业的人员配备表',
  `enterpriseId` int(11) NOT NULL COMMENT '施工企业表外键',
  `professionType` int(4) DEFAULT '1' COMMENT '施工企业人员专业类型 1 线路专业 2 变电专业',
  `oneManager` int(4) DEFAULT '0' COMMENT '330kv级以上项目一级建造师项目经理',
  `twoManager` int(4) DEFAULT '0' COMMENT '220kv 及一下二级建造师项目经理',
  `oneChief` int(4) DEFAULT '0' COMMENT '220kv 及以上的上级项目总工',
  `twoChief` int(4) DEFAULT '0' COMMENT '110kv 级以下的下级项目总工',
  `safetyOfficer` int(4) DEFAULT '0' COMMENT '安全员',
  `inspector` int(4) DEFAULT '0' COMMENT '质检员',
  `technician` int(4) DEFAULT '0' COMMENT '技术员',
  `costMember` int(4) DEFAULT '0' COMMENT '造价员',
  `documenter` int(4) DEFAULT '0' COMMENT '资料员',
  `integrator` int(4) DEFAULT '0' COMMENT '综合管理员',
  `material` int(4) DEFAULT '0' COMMENT '材料员',
  `expeditor` int(4) DEFAULT '0' COMMENT '协调员',
  `constructionTeam` int(4) DEFAULT '0' COMMENT '施工队长',
  `plurality` int(4) DEFAULT '0' COMMENT ' 施工队,技术员,质检员,兼职安全员等',
  `sum` int(4) DEFAULT '0' COMMENT '人员合计',
  `createTime` varchar(20) DEFAULT '',
  `updateTime` varchar(20) DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `person_enter_fk` (`enterpriseId`,`professionType`) USING BTREE,
  CONSTRAINT `person_enter_fk` FOREIGN KEY (`enterpriseId`) REFERENCES `enterprise` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise_per_manage
-- ----------------------------
INSERT INTO `enterprise_per_manage` VALUES ('24', '78', '1', '15', '18', '15', '15', '29', '24', '30', '22', '21', '45', '25', '20', '51', '71', '401', '2015-12-29 16:03:09', '');
INSERT INTO `enterprise_per_manage` VALUES ('25', '79', '1', '7', '3', '7', '4', '10', '10', '11', '15', '7', '6', '6', '7', '30', '10', '133', '2015-12-29 16:04:00', '');
INSERT INTO `enterprise_per_manage` VALUES ('26', '80', '1', '3', '20', '8', '4', '6', '23', '25', '7', '5', '5', '4', '5', '0', '5', '120', '2015-12-29 16:04:26', '');
INSERT INTO `enterprise_per_manage` VALUES ('27', '81', '1', '4', '65', '7', '50', '7', '7', '7', '7', '10', '20', '7', '0', '0', '16', '207', '2015-12-29 16:04:52', '');
INSERT INTO `enterprise_per_manage` VALUES ('28', '82', '1', '0', '12', '2', '2', '8', '4', '12', '6', '11', '8', '5', '4', '12', '4', '90', '2015-12-29 16:05:21', '');
INSERT INTO `enterprise_per_manage` VALUES ('29', '83', '1', '0', '7', '5', '7', '27', '15', '29', '8', '15', '18', '18', '20', '28', '30', '227', '2015-12-29 16:15:43', '');
INSERT INTO `enterprise_per_manage` VALUES ('30', '84', '1', '1', '7', '8', '21', '10', '8', '15', '5', '3', '5', '8', '7', '10', '18', '126', '2015-12-29 16:16:49', '');
INSERT INTO `enterprise_per_manage` VALUES ('31', '85', '1', '9', '15', '8', '15', '13', '8', '15', '10', '13', '18', '13', '20', '40', '15', '212', '2015-12-29 16:18:40', '2015-12-29 16:18:57');
INSERT INTO `enterprise_per_manage` VALUES ('32', '86', '1', '1', '9', '3', '5', '8', '10', '9', '8', '12', '9', '10', '12', '55', '14', '165', '2015-12-29 16:19:50', '');
INSERT INTO `enterprise_per_manage` VALUES ('33', '87', '1', '2', '4', '2', '5', '5', '5', '17', '4', '3', '5', '6', '4', '9', '21', '92', '2015-12-29 16:20:23', '');
INSERT INTO `enterprise_per_manage` VALUES ('34', '88', '1', '0', '11', '6', '13', '5', '6', '5', '2', '5', '6', '7', '12', '12', '33', '123', '2015-12-29 16:20:51', '');
INSERT INTO `enterprise_per_manage` VALUES ('35', '89', '1', '2', '7', '23', '8', '6', '6', '31', '5', '4', '5', '6', '8', '6', '10', '127', '2015-12-29 16:21:31', '');
INSERT INTO `enterprise_per_manage` VALUES ('36', '90', '1', '0', '17', '5', '5', '17', '5', '25', '4', '6', '5', '4', '4', '20', '40', '157', '2015-12-29 16:22:06', '');
INSERT INTO `enterprise_per_manage` VALUES ('37', '91', '1', '0', '16', '7', '5', '6', '1', '3', '2', '1', '1', '1', '1', '1', '2', '47', '2015-12-29 16:23:03', '');
INSERT INTO `enterprise_per_manage` VALUES ('38', '92', '1', '0', '6', '6', '10', '7', '8', '8', '6', '12', '8', '6', '8', '36', '12', '133', '2015-12-29 16:23:34', '');
INSERT INTO `enterprise_per_manage` VALUES ('39', '93', '1', '1', '6', '28', '31', '6', '8', '65', '7', '2', '3', '4', '2', '11', '12', '186', '2015-12-29 16:28:40', '');
INSERT INTO `enterprise_per_manage` VALUES ('40', '94', '1', '0', '4', '3', '16', '4', '3', '35', '6', '3', '3', '3', '3', '15', '9', '107', '2015-12-29 16:29:25', '');
INSERT INTO `enterprise_per_manage` VALUES ('41', '95', '1', '1', '17', '3', '4', '2', '10', '16', '5', '4', '4', '2', '4', '6', '16', '94', '2015-12-29 16:29:55', '2015-12-29 16:30:09');
INSERT INTO `enterprise_per_manage` VALUES ('42', '96', '1', '0', '2', '2', '7', '9', '9', '9', '9', '9', '9', '9', '9', '54', '111', '248', '2015-12-29 16:31:52', '');
INSERT INTO `enterprise_per_manage` VALUES ('43', '97', '1', '2', '11', '23', '18', '5', '2', '12', '5', '4', '4', '5', '5', '24', '88', '208', '2015-12-29 16:32:48', '');
INSERT INTO `enterprise_per_manage` VALUES ('44', '98', '1', '4', '6', '20', '30', '4', '2', '12', '2', '3', '3', '3', '3', '12', '30', '134', '2015-12-29 16:33:40', '');
INSERT INTO `enterprise_per_manage` VALUES ('45', '99', '1', '0', '3', '3', '6', '8', '4', '32', '4', '8', '10', '10', '10', '10', '10', '118', '2015-12-29 16:34:15', '');
INSERT INTO `enterprise_per_manage` VALUES ('46', '100', '1', '0', '18', '6', '10', '6', '6', '8', '6', '4', '4', '4', '4', '24', '48', '148', '2015-12-29 16:34:49', '');
INSERT INTO `enterprise_per_manage` VALUES ('47', '101', '1', '0', '6', '8', '10', '6', '8', '18', '5', '12', '8', '10', '10', '20', '55', '176', '2015-12-29 16:37:16', '');
INSERT INTO `enterprise_per_manage` VALUES ('48', '102', '1', '0', '3', '0', '2', '2', '2', '2', '2', '2', '2', '2', '2', '12', '23', '56', '2015-12-29 16:35:22', '');
INSERT INTO `enterprise_per_manage` VALUES ('49', '103', '1', '3', '17', '18', '10', '12', '6', '25', '6', '6', '0', '7', '0', '24', '55', '189', '2015-12-29 16:35:57', '2015-12-29 16:36:05');
INSERT INTO `enterprise_per_manage` VALUES ('50', '78', '2', '10', '15', '41', '66', '36', '32', '45', '13', '10', '15', '6', '6', '24', '50', '369', '2015-12-30 10:17:05', '');
INSERT INTO `enterprise_per_manage` VALUES ('51', '79', '2', '5', '6', '5', '3', '13', '7', '10', '14', '5', '5', '5', '5', '30', '7', '120', '2015-12-30 10:17:31', '');
INSERT INTO `enterprise_per_manage` VALUES ('52', '80', '2', '4', '21', '9', '3', '8', '25', '31', '8', '12', '12', '11', '12', '0', '12', '168', '2015-12-30 10:17:58', '2015-12-30 10:18:10');
INSERT INTO `enterprise_per_manage` VALUES ('53', '81', '2', '2', '50', '5', '30', '4', '4', '4', '4', '6', '10', '5', '0', '0', '12', '136', '2015-12-30 10:18:45', '');
INSERT INTO `enterprise_per_manage` VALUES ('54', '82', '2', '0', '10', '2', '2', '4', '3', '8', '4', '7', '4', '4', '4', '9', '3', '64', '2015-12-30 10:19:11', '');
INSERT INTO `enterprise_per_manage` VALUES ('55', '83', '2', '0', '5', '3', '5', '28', '25', '25', '8', '12', '12', '15', '2', '30', '20', '190', '2015-12-30 10:32:12', '2015-12-30 10:32:52');
INSERT INTO `enterprise_per_manage` VALUES ('56', '84', '2', '0', '18', '33', '45', '11', '12', '20', '6', '4', '8', '12', '4', '13', '19', '205', '2015-12-30 10:34:44', '');
INSERT INTO `enterprise_per_manage` VALUES ('57', '85', '2', '8', '14', '10', '15', '12', '8', '22', '12', '17', '19', '13', '26', '56', '13', '245', '2015-12-30 10:35:19', '');
INSERT INTO `enterprise_per_manage` VALUES ('58', '86', '2', '2', '7', '5', '6', '12', '9', '8', '7', '8', '7', '9', '8', '60', '12', '160', '2015-12-30 10:35:49', '');
INSERT INTO `enterprise_per_manage` VALUES ('59', '87', '2', '3', '6', '4', '8', '8', '8', '23', '6', '5', '6', '10', '7', '40', '32', '166', '2015-12-30 10:36:32', '');
INSERT INTO `enterprise_per_manage` VALUES ('60', '88', '2', '1', '10', '5', '11', '4', '5', '4', '2', '5', '6', '7', '4', '5', '45', '114', '2015-12-30 10:37:08', '');
INSERT INTO `enterprise_per_manage` VALUES ('61', '89', '2', '2', '5', '34', '8', '5', '8', '31', '5', '4', '5', '6', '8', '6', '10', '137', '2015-12-30 10:39:11', '');
INSERT INTO `enterprise_per_manage` VALUES ('62', '90', '2', '0', '9', '5', '5', '15', '4', '25', '2', '4', '3', '2', '2', '18', '30', '124', '2015-12-30 10:40:10', '');
INSERT INTO `enterprise_per_manage` VALUES ('63', '91', '2', '0', '16', '6', '5', '4', '1', '3', '0', '1', '1', '1', '1', '1', '2', '42', '2015-12-30 10:40:41', '');
INSERT INTO `enterprise_per_manage` VALUES ('64', '92', '2', '1', '6', '6', '9', '12', '6', '7', '6', '8', '8', '10', '6', '65', '13', '163', '2015-12-30 10:41:09', '');
INSERT INTO `enterprise_per_manage` VALUES ('65', '93', '2', '0', '6', '26', '32', '6', '8', '68', '7', '3', '4', '3', '2', '12', '13', '190', '2015-12-30 10:41:43', '');
INSERT INTO `enterprise_per_manage` VALUES ('66', '94', '2', '0', '3', '5', '9', '2', '3', '18', '2', '2', '2', '2', '1', '10', '8', '67', '2015-12-30 10:42:11', '');
INSERT INTO `enterprise_per_manage` VALUES ('67', '95', '2', '1', '19', '3', '4', '2', '12', '20', '5', '4', '4', '2', '4', '10', '16', '106', '2015-12-30 10:42:40', '');
INSERT INTO `enterprise_per_manage` VALUES ('68', '96', '2', '0', '1', '1', '2', '3', '3', '3', '3', '6', '6', '3', '3', '33', '63', '130', '2015-12-30 10:46:04', '');
INSERT INTO `enterprise_per_manage` VALUES ('69', '97', '2', '2', '2', '16', '24', '5', '2', '14', '5', '5', '5', '6', '6', '50', '134', '276', '2015-12-30 10:46:37', '');
INSERT INTO `enterprise_per_manage` VALUES ('70', '98', '2', '3', '6', '15', '15', '2', '2', '9', '2', '3', '3', '3', '3', '12', '20', '98', '2015-12-30 10:47:00', '');
INSERT INTO `enterprise_per_manage` VALUES ('71', '99', '2', '0', '2', '1', '4', '13', '3', '24', '4', '6', '6', '6', '6', '6', '6', '87', '2015-12-30 10:47:26', '');
INSERT INTO `enterprise_per_manage` VALUES ('72', '100', '2', '0', '18', '6', '12', '8', '8', '10', '6', '5', '5', '5', '5', '50', '100', '238', '2015-12-30 10:47:52', '2015-12-30 10:48:09');
INSERT INTO `enterprise_per_manage` VALUES ('73', '101', '2', '0', '6', '9', '12', '8', '7', '20', '5', '20', '9', '12', '10', '18', '50', '186', '2015-12-30 10:48:45', '');
INSERT INTO `enterprise_per_manage` VALUES ('74', '102', '2', '0', '3', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '10', '20', '42', '2015-12-30 10:49:07', '');
INSERT INTO `enterprise_per_manage` VALUES ('75', '103', '2', '2', '10', '12', '8', '11', '5', '21', '5', '4', '0', '6', '0', '20', '47', '151', '2015-12-30 10:49:35', '');

-- ----------------------------
-- Table structure for enterprise_per_standard
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_per_standard`;
CREATE TABLE `enterprise_per_standard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '企业自身主要人员评估(施工项目部人员构成)',
  `postClassifyId` int(4) DEFAULT NULL COMMENT '岗位名称外键关联',
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
  CONSTRAINT `enterpirse_per_sta_postClas_fk` FOREIGN KEY (`postClassifyId`) REFERENCES `post_classify` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise_per_standard
-- ----------------------------
INSERT INTO `enterprise_per_standard` VALUES ('1', '1', '330kv级以上的一级建造师,二级建造师', '1', '1', '1', '1', '项目经理', '2015-12-10 13:27:49', '2015-12-14 15:23:24');
INSERT INTO `enterprise_per_standard` VALUES ('2', '2', '220kv 以及以上中级技师', '1', '1', '1', '1', '项目总工', '2015-12-10 13:40:01', '2015-12-14 15:23:31');
INSERT INTO `enterprise_per_standard` VALUES ('3', '3', '安全合格证', '1', '1', '1', '1', '安全员', '2015-12-10 13:43:54', '2015-12-14 15:23:52');
INSERT INTO `enterprise_per_standard` VALUES ('4', '4', '质量合格培训证', '1', '1', '1', '1', '质检员', '2015-12-14 15:21:12', '2015-12-14 15:24:20');
INSERT INTO `enterprise_per_standard` VALUES ('5', '5', '', '1', '1', '1', '2', '技术员', '2015-12-14 15:27:07', '');
INSERT INTO `enterprise_per_standard` VALUES ('6', '6', '', '2', '2', '3', '2', '造价员,资料员,综合员,管理员,材料员,协调员', '2015-12-10 13:40:26', '2015-12-22 10:22:46');
INSERT INTO `enterprise_per_standard` VALUES ('7', '7', '', '6', '8', '10', '2', '施工队长(班组长)(线路长度按40km双回计算)', '2015-12-10 15:16:50', '2015-12-14 15:24:25');
INSERT INTO `enterprise_per_standard` VALUES ('8', '8', '', '12', '16', '16', '2', '施工队技术员,质检员,兼职安全员', '2015-12-10 15:08:20', '2015-12-14 15:30:30');

-- ----------------------------
-- Table structure for equipment_bear
-- ----------------------------
DROP TABLE IF EXISTS `equipment_bear`;
CREATE TABLE `equipment_bear` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '线路专业 张牵设备承载力 配置信息表',
  `name` varchar(40) DEFAULT '' COMMENT '设备名称说明',
  `voltageRankId` int(4) DEFAULT NULL COMMENT '电压等级 kv',
  `lineType` tinyint(4) DEFAULT '2' COMMENT '线路类型 1 单回  2 双回',
  `linePlain` tinyint(4) DEFAULT '0' COMMENT '平原,丘陵导线展放率(km/月.套)',
  `lineBrae` tinyint(4) DEFAULT '0' COMMENT '山区 导线展放率(km/月.套)',
  `explains` varchar(225) DEFAULT NULL COMMENT '设备的详细说明信息',
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `voltagerankid_fk` (`voltageRankId`,`lineType`) USING BTREE,
  CONSTRAINT `equipement_bear_volta_fk` FOREIGN KEY (`voltageRankId`) REFERENCES `voltage_rank_classify` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipment_bear
-- ----------------------------
INSERT INTO `equipment_bear` VALUES ('14', '特高压用张牵设备一套', '1', '1', '20', '15', '包含1台25T及以上吨位牵引机和1台四线配套吨位张力机 （或2台二线配套吨位张力机）\\小牵引机及小张力机各1台', '2015-12-15 16:26:22', '2015-12-29 15:40:58');
INSERT INTO `equipment_bear` VALUES ('15', '特高压用张牵设备一套', '1', '2', '12', '9', '包含1台25T及以上吨位牵引机和1台四线配套吨位张力机（或2台二线配套吨位张力机）\\小牵引机及小张力机各1台', '2015-12-15 16:26:49', '2015-12-29 15:41:10');
INSERT INTO `equipment_bear` VALUES ('16', '大张牵设备一套', '2', '1', '20', '15', '包含1台15T及以上吨位牵引机和1台四线配套吨位张力机 （或2台二线配套吨位张力机）\\小牵引机及小张力机各1台', '2015-12-15 16:28:13', '2015-12-29 15:41:20');
INSERT INTO `equipment_bear` VALUES ('17', '大张牵设备一套', '2', '2', '12', '9', '包含1台15T及以上吨位牵引机和1台四线配套吨位张力机（或2台二线配套吨位张力机）\\小牵引机及小张力机各1台', '2015-12-15 16:28:33', '2015-12-29 15:41:28');
INSERT INTO `equipment_bear` VALUES ('18', '大张牵设备一套', '3', '1', '25', '18', '包含1台15T及以上吨位牵引机和1台配套吨位张力机\\小牵引机及小张力机各1台', '2015-12-15 16:29:03', '2015-12-29 15:41:33');
INSERT INTO `equipment_bear` VALUES ('19', '大张牵设备一套', '3', '2', '20', '15', '包含1台15T及以上吨位牵引机和1台配套吨位张力机\\小牵引机及小张力机各1台', '2015-12-15 16:29:29', '2015-12-29 15:41:42');
INSERT INTO `equipment_bear` VALUES ('20', '小张牵设备一套', '4', '1', '25', '18', '包含1台9T及以下吨位牵引机和1台单线配套吨位张力机', '2015-12-15 16:30:05', '2015-12-29 15:41:47');
INSERT INTO `equipment_bear` VALUES ('21', '小张牵设备一套', '4', '2', '20', '15', '包含1台9T及以下吨位牵引机和1台两线配套吨位张力机', '2015-12-15 16:30:23', '2015-12-29 15:41:53');

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
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '2', '资质信息', 'enterprise', '2', '2级菜单 1资质信息--tabpanel id', '0', '1', null, null);
INSERT INTO `permission` VALUES ('2', '0', '企业基本信息', '', '2', '1级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('3', '2', '人员信息', 'enterprisePer', '2', '2级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('5', '0', '施工承载能力评估', '', '2', '1级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('6', '5', '评估标准', '', '2', '2级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('7', '6', '企业资质对施工承载能力评估', 'enterpriseApt', '2', '3级菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('8', '6', '企业自身主要人员评估标准', 'enterprisePerSta', '2', '企业自身主要人员评估(施工项目部人员构成)', '0', '1', null, null);
INSERT INTO `permission` VALUES ('9', '6', '机具设备对工程承载力的评估', 'equipmentBear', '2', '张牵设备承载力配置信息', '0', '1', null, null);
INSERT INTO `permission` VALUES ('10', '6', '施工项目团队工程施工产值', 'annualOutput', '2', '施工项目年产值评估标准表配置', '0', '1', null, null);
INSERT INTO `permission` VALUES ('11', '6', '施工企业不良行文分类标准', 'behaviorSta', '2', '施工企业不良行为分类标准', '0', '1', null, null);
INSERT INTO `permission` VALUES ('12', '5', '现场管理人员', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('13', '12', '线路专业人员', 'enterprisePerManLine', '2', '施工企业现场管理人员(线路专业)', '0', '1', null, null);
INSERT INTO `permission` VALUES ('14', '12', '变电专业人员', 'enterprisePerManPower', '2', '施工企业现场管理人员(变电专业)', '0', '1', null, null);
INSERT INTO `permission` VALUES ('15', '5', '施工装备信息', 'enterpriseEquip', '2', '施工企业装备', '0', '1', null, null);
INSERT INTO `permission` VALUES ('16', '5', '承载能力计算结果', 'bear', '2', '施工企业承载能力技术结果', '0', '1', null, null);
INSERT INTO `permission` VALUES ('17', '5', '不良行为影响', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('18', '17', '不良行为影响修正系数', 'behavior', '2', '不良行为修正系数', '0', '1', null, null);
INSERT INTO `permission` VALUES ('19', '17', '不良行为影响修正结果', 'bearRevised', '2', '施工企业承载能力修正后结果', '0', '1', null, null);
INSERT INTO `permission` VALUES ('20', '5', '施工企业评估分类', 'enterpriseAssess', '2', '施工企业评估分类', '0', '1', null, null);
INSERT INTO `permission` VALUES ('21', '5', '评估情况与近三年承揽情况的比较', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('22', '21', '工程数量对比情况', 'bearContrastProNum', '2', '工程数量对比情况', '0', '1', null, null);
INSERT INTO `permission` VALUES ('23', '21', '产值对比情况', 'bearContrastProOutput', '2', '产值对比情况', '0', '1', null, null);
INSERT INTO `permission` VALUES ('24', '0', '评估结果应用', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('25', '24', '下一年度公司新开工项目情况', 'projectPlain', '2', '下一年度公司新开发工项目情况', '0', '1', null, null);
INSERT INTO `permission` VALUES ('26', '24', '各施工单位已承揽工程情况', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('27', '26', '在建工程情况', 'projectBuilding', '2', '在建工程情况', '0', '1', null, null);
INSERT INTO `permission` VALUES ('28', '26', '中标未开工情况', 'projectNoBuild', '2', '中标未开工情况', '0', '1', null, null);
INSERT INTO `permission` VALUES ('29', '24', '施工单位剩余承载能力', 'projectBuildBear', '2', '施工单位剩余承载能力', '0', '1', null, null);
INSERT INTO `permission` VALUES ('31', '2', '资质信息.', 'displayEnterprise', '2', '31资质信息(查看)     -- tabpanel id', '0', '1', null, null);
INSERT INTO `permission` VALUES ('32', '2', '人员信息.', 'displayEnterprisePer', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('33', '6', '企业资质对施工承载能力评估.', 'displayEnterpriseApt', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('34', '6', '企业自身主要人员评估标准.', 'displayEnterprisePerSta', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('35', '6', '机具设备对工程承载力的评估.', 'displayEquipmentBear', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('36', '6', '施工项目团队工程施工产值.', 'displayAnnualOutput', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('37', '6', '施工企业不良行文分类标准.', 'displayBehaviorSta', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('38', '12', '线路专业人员.', 'displayEnterprisePerManLine', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('39', '12', '变电专业人员.', 'displayEnterprisePerManPower', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('40', '5', '施工装备信息.', 'displayEnterpriseEquip', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('41', '5', '承载能力计算结果.', 'bear', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('42', '44', '不良行为影响修正系数.', 'displayBehavior', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('43', '44', '不良行为影响修正结果.', 'bearRevised', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('44', '5', '不良行为影响.', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('45', '5', '施工企业评估分类.', 'displayEnterpriseAssess', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('46', '5', '评估情况与近三年承揽情况的比较.', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('47', '46', '工程数量对比情况.', 'bearContrastProNum', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('48', '46', '产值对比情况.', 'bearContrastProOutput', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('49', '24', '下一年度公司新开工项目情况.', 'displayProjectPlain', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('50', '24', '各施工单位已承揽工程情况.', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('51', '50', '在建工程情况.', 'displayProjectBuilding', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('52', '50', '中标未开工情况.', 'displayProjectNoBuild', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('53', '24', '施工单位剩余承载能力.', 'projectBuildBear', '2', '', '0', '1', null, null);

-- ----------------------------
-- Table structure for post_classify
-- ----------------------------
DROP TABLE IF EXISTS `post_classify`;
CREATE TABLE `post_classify` (
  `id` int(4) NOT NULL COMMENT '施工企业基本岗位表',
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
-- Table structure for project_build
-- ----------------------------
DROP TABLE IF EXISTS `project_build`;
CREATE TABLE `project_build` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '施工企业中标项目建设情况',
  `supervisorUnit` varchar(100) DEFAULT '' COMMENT '主管单位',
  `enterpriseId` int(11) DEFAULT NULL COMMENT '外键,所属施工企业',
  `year` int(11) DEFAULT '0' COMMENT '施工企业建设项目的年份',
  `classify` int(4) DEFAULT '1' COMMENT '施工企业中标项目的建设状态  1 中标未开工项目 2 中标已开工项目',
  `line110kv` int(4) DEFAULT '0' COMMENT '线路工程    110kv 项目数(个)',
  `line220kv` int(4) DEFAULT '0' COMMENT '线路工程    220kv 项目数(个)',
  `line500kv` int(4) DEFAULT '0' COMMENT '线路工程   500kv 项目数(个)',
  `power110kv` int(4) DEFAULT '0' COMMENT '变电工程    110kv 项目数(个)',
  `power220kv` int(4) DEFAULT '0' COMMENT '变电工程    220kv 项目数(个)',
  `power500kv` int(4) DEFAULT '0' COMMENT '变电工程    500kv 项目数(个)',
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `proejct_build_enterpriseId_fk` (`enterpriseId`,`year`,`classify`) USING BTREE,
  CONSTRAINT `proejct_build_enterpriseId_fk` FOREIGN KEY (`enterpriseId`) REFERENCES `enterprise` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_build
-- ----------------------------
INSERT INTO `project_build` VALUES ('1', '四川公司', '78', '2016', '2', '0', '2', '9', '1', '3', '2', '2016-01-04 09:20:45', '2016-01-04 09:37:54');
INSERT INTO `project_build` VALUES ('2', '科锐得', '79', '2016', '2', '0', '3', '3', '1', '5', '2', '2016-01-04 09:20:59', '2016-01-04 09:21:52');
INSERT INTO `project_build` VALUES ('3', '成都', '80', '2016', '2', '6', '8', '0', '6', '2', '0', '2016-01-04 09:22:37', '');
INSERT INTO `project_build` VALUES ('4', '四川公司', '78', '2015', '2', '0', '2', '9', '1', '3', '2', '2016-01-04 09:23:33', '');
INSERT INTO `project_build` VALUES ('5', '科锐得', '79', '2015', '2', '0', '3', '3', '1', '5', '2', '2016-01-04 09:23:44', '');
INSERT INTO `project_build` VALUES ('7', '成都', '81', '2016', '2', '0', '0', '0', '0', '0', '0', '2016-01-04 09:27:54', '');
INSERT INTO `project_build` VALUES ('8', '成都', '82', '2016', '2', '1', '0', '0', '2', '2', '0', '2016-01-04 09:28:29', '');
INSERT INTO `project_build` VALUES ('9', '乐山', '83', '2016', '2', '3', '2', '0', '4', '2', '0', '2016-01-04 09:28:45', '');
INSERT INTO `project_build` VALUES ('10', '攀枝花', '84', '2016', '2', '0', '1', '0', '2', '0', '0', '2016-01-04 09:29:04', '');
INSERT INTO `project_build` VALUES ('11', '德阳', '85', '2016', '2', '4', '2', '0', '1', '0', '0', '2016-01-04 09:29:24', '');
INSERT INTO `project_build` VALUES ('12', '眉山', '86', '2016', '2', '1', '0', '0', '1', '1', '0', '2016-01-04 09:29:43', '');
INSERT INTO `project_build` VALUES ('13', '雅安', '87', '2016', '2', '2', '0', '0', '8', '0', '0', '2016-01-04 09:30:04', '');
INSERT INTO `project_build` VALUES ('14', '达州', '88', '2016', '2', '2', '1', '0', '3', '1', '0', '2016-01-04 09:30:18', '');
INSERT INTO `project_build` VALUES ('15', '绵阳', '89', '2016', '2', '0', '0', '0', '0', '0', '0', '2016-01-04 09:30:31', '');
INSERT INTO `project_build` VALUES ('16', '宜宾', '90', '2016', '2', '1', '2', '0', '1', '0', '0', '2016-01-04 09:30:48', '');
INSERT INTO `project_build` VALUES ('17', '凉山', '91', '2016', '2', '2', '0', '0', '1', '0', '0', '2016-01-04 09:31:29', '');
INSERT INTO `project_build` VALUES ('18', '内江', '92', '2016', '2', '4', '3', '0', '2', '3', '0', '2016-01-04 09:31:54', '2016-01-04 09:38:50');
INSERT INTO `project_build` VALUES ('19', '广元', '93', '2016', '2', '6', '0', '0', '0', '0', '0', '2016-01-04 09:32:18', '');
INSERT INTO `project_build` VALUES ('21', '广元', '94', '2016', '2', '0', '0', '0', '0', '0', '0', '2016-01-04 09:33:06', '');
INSERT INTO `project_build` VALUES ('22', '泸州', '95', '2016', '2', '0', '0', '0', '1', '1', '0', '2016-01-04 09:33:29', '');
INSERT INTO `project_build` VALUES ('23', '南充', '96', '2016', '2', '5', '0', '0', '0', '0', '0', '2016-01-04 09:33:54', '');
INSERT INTO `project_build` VALUES ('24', '自贡', '97', '2016', '2', '1', '1', '0', '2', '1', '0', '2016-01-04 09:34:24', '');
INSERT INTO `project_build` VALUES ('25', '广安', '98', '2016', '2', '5', '0', '0', '2', '0', '0', '2016-01-04 09:34:49', '');
INSERT INTO `project_build` VALUES ('26', '资阳', '99', '2016', '2', '2', '1', '0', '1', '0', '0', '2016-01-04 09:35:19', '2016-01-04 09:35:30');
INSERT INTO `project_build` VALUES ('27', '遂宁', '100', '2016', '2', '2', '0', '0', '0', '0', '0', '2016-01-04 09:35:55', '');
INSERT INTO `project_build` VALUES ('28', '巴中', '101', '2016', '2', '1', '0', '0', '0', '1', '0', '2016-01-04 09:36:26', '');
INSERT INTO `project_build` VALUES ('29', '甘孜', '102', '2016', '2', '0', '0', '0', '0', '0', '0', '2016-01-04 09:36:38', '');
INSERT INTO `project_build` VALUES ('30', '格瑞德', '103', '2016', '2', '1', '1', '0', '0', '0', '0', '2016-01-04 09:37:02', '');
INSERT INTO `project_build` VALUES ('31', '四川公司', '78', '2016', '1', '0', '0', '0', '0', '0', '0', '2016-01-04 09:39:45', '');
INSERT INTO `project_build` VALUES ('32', '科锐得', '79', '2016', '1', '0', '2', '0', '0', '1', '0', '2016-01-04 09:39:56', '');
INSERT INTO `project_build` VALUES ('33', '成都', '80', '2016', '1', '7', '8', '0', '0', '0', '0', '2016-01-04 09:40:45', '');
INSERT INTO `project_build` VALUES ('34', '成都', '81', '2016', '1', '2', '1', '0', '2', '0', '0', '2016-01-04 09:41:05', '2016-01-04 09:48:35');
INSERT INTO `project_build` VALUES ('35', '成都', '82', '2016', '1', '2', '0', '0', '1', '0', '0', '2016-01-04 09:41:17', '');
INSERT INTO `project_build` VALUES ('36', '乐山', '83', '2016', '1', '1', '0', '0', '1', '0', '0', '2016-01-04 09:41:29', '');
INSERT INTO `project_build` VALUES ('37', '攀枝花', '84', '2016', '1', '1', '2', '0', '1', '0', '0', '2016-01-04 09:41:43', '');
INSERT INTO `project_build` VALUES ('38', '德阳', '85', '2016', '1', '0', '0', '0', '2', '0', '0', '2016-01-04 09:41:53', '');
INSERT INTO `project_build` VALUES ('39', '眉山', '86', '2016', '1', '1', '0', '0', '1', '0', '0', '2016-01-04 09:42:08', '');
INSERT INTO `project_build` VALUES ('40', '雅安', '87', '2016', '1', '0', '0', '0', '0', '0', '0', '2016-01-04 09:42:23', '2016-01-04 09:49:37');
INSERT INTO `project_build` VALUES ('41', '达州', '88', '2016', '1', '0', '2', '0', '1', '0', '0', '2016-01-04 09:42:32', '2016-01-04 09:48:51');
INSERT INTO `project_build` VALUES ('42', '绵阳', '89', '2016', '1', '0', '0', '0', '0', '0', '0', '2016-01-04 09:42:41', '');
INSERT INTO `project_build` VALUES ('43', '宜宾', '90', '2016', '1', '1', '0', '0', '0', '0', '0', '2016-01-04 09:42:52', '');
INSERT INTO `project_build` VALUES ('44', '凉山', '91', '2016', '1', '1', '0', '0', '1', '1', '0', '2016-01-04 09:43:18', '');
INSERT INTO `project_build` VALUES ('45', '内江', '92', '2016', '1', '0', '0', '0', '0', '0', '0', '2016-01-04 09:43:37', '');
INSERT INTO `project_build` VALUES ('46', '广元', '93', '2016', '1', '0', '0', '0', '0', '0', '0', '2016-01-04 09:43:50', '');
INSERT INTO `project_build` VALUES ('47', '广元', '94', '2016', '1', '0', '0', '0', '0', '0', '0', '2016-01-04 09:44:01', '');
INSERT INTO `project_build` VALUES ('48', '泸州', '95', '2016', '1', '0', '1', '0', '0', '0', '0', '2016-01-04 09:44:14', '');
INSERT INTO `project_build` VALUES ('49', '南充', '96', '2016', '1', '0', '1', '0', '0', '0', '0', '2016-01-04 09:44:32', '');
INSERT INTO `project_build` VALUES ('50', '自贡', '97', '2016', '1', '0', '1', '0', '0', '1', '0', '2016-01-04 09:44:58', '');
INSERT INTO `project_build` VALUES ('51', '广安', '98', '2016', '1', '0', '0', '0', '1', '0', '0', '2016-01-04 09:45:18', '');
INSERT INTO `project_build` VALUES ('52', '资阳', '99', '2016', '1', '0', '0', '0', '0', '0', '0', '2016-01-04 09:45:38', '');
INSERT INTO `project_build` VALUES ('53', '遂宁', '100', '2016', '1', '2', '0', '0', '0', '0', '0', '2016-01-04 09:45:55', '');
INSERT INTO `project_build` VALUES ('54', '巴中', '101', '2016', '1', '0', '0', '0', '2', '0', '0', '2016-01-04 09:46:55', '');
INSERT INTO `project_build` VALUES ('55', '甘孜', '102', '2016', '1', '0', '0', '0', '0', '0', '0', '2016-01-04 09:47:31', '');
INSERT INTO `project_build` VALUES ('56', '格瑞德', '103', '2016', '1', '0', '0', '0', '0', '0', '0', '2016-01-04 09:47:45', '');

-- ----------------------------
-- Table structure for project_plain
-- ----------------------------
DROP TABLE IF EXISTS `project_plain`;
CREATE TABLE `project_plain` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '下一年新开工项目情况',
  `voltageRankClassifyId` int(11) DEFAULT NULL COMMENT '外键  电压等级分类',
  `year` int(8) DEFAULT '0' COMMENT '新开工项目对应的年份',
  `projectNum` int(11) DEFAULT '0' COMMENT '项目个数',
  `lineProject` int(11) DEFAULT '0' COMMENT '新开工的线路工程数',
  `powerProject` int(11) DEFAULT '0' COMMENT '新开工的变电工程数',
  `assessLineProject` int(11) DEFAULT '0' COMMENT '评估对应年份可承揽线路工程数',
  `assessPowerProject` int(11) DEFAULT '0' COMMENT '评估可以承载变成工程数',
  `lineLength` int(11) DEFAULT '0' COMMENT '线路长度(公里)',
  `volume` int(11) DEFAULT '0' COMMENT '变电容量(万千伏特)',
  `investment` decimal(10,2) DEFAULT '0.00' COMMENT '总投资  (亿元)',
  `createTime` varchar(20) DEFAULT NULL,
  `updateTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `project_new_voltageRankClassifyId_fk` (`voltageRankClassifyId`,`year`) USING BTREE,
  CONSTRAINT `project_new_voltageRankClassifyId_fk` FOREIGN KEY (`voltageRankClassifyId`) REFERENCES `voltage_rank_classify` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_plain
-- ----------------------------
INSERT INTO `project_plain` VALUES ('1', '2', '2016', '5', '6', '3', '16', '13', '822', '325', '40.90', '2015-12-17 16:25:38', '2015-12-28 10:33:16');
INSERT INTO `project_plain` VALUES ('4', '3', '2016', '18', '13', '12', '38', '46', '1237', '450', '36.90', '2015-12-17 16:29:50', '2015-12-28 10:33:53');
INSERT INTO `project_plain` VALUES ('8', '4', '2016', '47', '30', '22', '39', '9', '1187', '270', '24.80', '2015-12-18 10:26:52', '2015-12-28 10:34:43');
INSERT INTO `project_plain` VALUES ('9', '1', '2015', '1', '2', '3', '4', '0', '0', '0', '0.00', '2016-01-05 14:26:14', '2016-01-05 14:48:52');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '0', 'admin', '1', '', '');
INSERT INTO `role` VALUES ('2', '0', 'user', '1', '', '');

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
INSERT INTO `role_permission_link` VALUES ('1', '1', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '2', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '3', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '5', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '6', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '7', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '8', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '9', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '10', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '11', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '12', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '13', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '14', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '15', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '16', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '17', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '18', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '19', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '20', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '21', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '22', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '23', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '24', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '25', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '26', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '27', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '28', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('1', '29', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '2', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '5', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '6', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '12', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '24', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '31', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '32', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '33', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '34', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '35', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '36', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '37', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '38', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '39', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '40', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '41', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '42', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '43', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '44', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '45', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '46', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '47', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '48', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '49', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '50', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '51', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '52', '1', '', '');
INSERT INTO `role_permission_link` VALUES ('2', '53', '1', '', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '', '', '', '', '1', '', '');
INSERT INTO `user` VALUES ('2', 'user', 'user', null, null, null, null, '1', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=684 DEFAULT CHARSET=utf8 COMMENT='用户日志表';

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
INSERT INTO `user_log` VALUES ('292', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 15:07:40', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('293', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 15:43:28', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('294', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 15:58:14', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('295', '1', '会话超时，用户退出.', '2015-12-10 16:12:54', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('296', '1', '会话超时，用户退出.', '2015-12-10 16:27:55', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('297', '1', '操作模块:会话管理,用户登陆.', '2015-12-10 17:13:45', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('298', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 09:10:56', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('299', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 09:17:51', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('300', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 09:43:12', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('301', '1', '会话超时，用户退出.', '2015-12-11 09:47:50', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('302', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 09:48:00', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('303', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 09:55:28', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('304', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 10:01:08', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('305', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 10:13:09', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('306', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 10:27:28', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('307', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 10:28:15', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('308', '1', '会话超时，用户退出.', '2015-12-11 10:58:03', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('309', '1', '会话超时，用户退出.', '2015-12-11 12:02:04', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('310', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 13:41:31', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('311', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 14:13:16', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('312', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 14:26:15', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('313', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 14:31:14', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('314', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 14:34:53', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('315', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 15:05:07', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('316', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 15:27:44', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('317', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 16:21:29', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('318', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 16:25:31', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('319', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 16:35:33', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('320', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 16:39:22', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('321', '1', '操作模块:会话管理,用户登陆.', '2015-12-11 16:44:27', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('322', '1', '操作模块:会话管理,用户登陆.', '2015-12-14 09:16:29', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('323', '1', '操作模块:会话管理,用户登陆.', '2015-12-14 09:58:29', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('324', '1', '操作模块:会话管理,用户登陆.', '2015-12-14 10:56:45', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('325', '1', '操作模块:会话管理,用户登陆.', '2015-12-14 11:00:43', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('326', '1', '操作模块:会话管理,用户登陆.', '2015-12-14 11:08:21', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('327', '1', '操作模块:会话管理,用户登陆.', '2015-12-14 11:10:39', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('328', '1', '操作模块:会话管理,用户登陆.', '2015-12-14 11:21:05', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('329', '1', '操作模块:会话管理,用户登陆.', '2015-12-14 12:50:13', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('330', '1', '操作模块:会话管理,用户登陆.', '2015-12-14 13:02:07', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('331', '1', '操作模块:会话管理,用户登陆.', '2015-12-14 13:05:38', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('332', '1', '操作模块:会话管理,用户登陆.', '2015-12-14 13:38:58', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('333', '1', '操作模块:会话管理,用户登陆.', '2015-12-14 13:46:48', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('334', '1', '操作模块:会话管理,用户登陆.', '2015-12-14 15:18:46', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('335', '1', '会话超时，用户退出.', '2015-12-14 16:00:34', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('336', '1', '操作模块:会话管理,用户登陆.', '2015-12-15 10:29:44', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('337', '1', '操作模块:会话管理,用户登陆.', '2015-12-15 10:33:42', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('338', '1', '会话超时，用户退出.', '2015-12-15 11:03:11', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('339', '1', '会话超时，用户退出.', '2015-12-15 11:12:11', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('340', '1', '操作模块:会话管理,用户登陆.', '2015-12-15 15:17:05', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('341', '1', '操作模块:会话管理,用户登陆.', '2015-12-15 15:58:58', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('342', '1', '会话超时，用户退出.', '2015-12-15 17:06:47', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('343', '1', '操作模块:会话管理,用户登陆.', '2015-12-16 09:44:16', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('344', '1', '操作模块:会话管理,用户登陆.', '2015-12-16 10:03:47', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('345', '1', '操作模块:会话管理,用户登陆.', '2015-12-16 10:11:40', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('346', '1', '操作模块:会话管理,用户登陆.', '2015-12-16 10:38:39', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('347', '1', '操作模块:会话管理,用户登陆.', '2015-12-16 10:42:33', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('348', '1', '操作模块:会话管理,用户登陆.', '2015-12-16 10:49:15', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('349', '1', '操作模块:会话管理,用户登陆.', '2015-12-16 11:23:49', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('350', '1', '会话超时，用户退出.', '2015-12-16 12:00:22', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('351', '1', '操作模块:会话管理,用户登陆.', '2015-12-16 12:57:43', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('352', '1', '操作模块:会话管理,用户登陆.', '2015-12-16 13:23:22', '127.0.0.1', '');
INSERT INTO `user_log` VALUES ('353', '1', '操作模块:会话管理,用户登陆.', '2015-12-16 14:12:58', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('354', '1', '操作模块:会话管理,用户登陆.', '2015-12-16 14:28:43', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('355', '1', '操作模块:会话管理,用户登陆.', '2015-12-16 14:44:50', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('356', '1', '操作模块:会话管理,用户登陆.', '2015-12-16 15:27:49', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('357', '1', '操作模块:会话管理,用户登陆.', '2015-12-16 16:12:46', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('358', '1', '操作模块:会话管理,用户登陆.', '2015-12-16 17:14:36', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('359', '1', '操作模块:会话管理,用户登陆.', '2015-12-17 10:22:38', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('360', '1', '操作模块:会话管理,用户注销.', '2015-12-17 10:22:46', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('361', '1', '操作模块:会话管理,用户登陆.', '2015-12-17 10:23:19', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('362', '1', '操作模块:会话管理,用户登陆.', '2015-12-17 10:24:03', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('363', '1', '操作模块:会话管理,用户注销.', '2015-12-17 10:27:26', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('364', '1', '操作模块:会话管理,用户登陆.', '2015-12-17 10:27:36', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('365', '1', '会话超时，用户退出.', '2015-12-17 10:53:32', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('366', '1', '会话超时，用户退出.', '2015-12-17 11:00:32', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('367', '1', '操作模块:会话管理,用户登陆.', '2015-12-17 11:23:39', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('368', '1', '会话超时，用户退出.', '2015-12-17 12:09:03', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('369', '1', '操作模块:会话管理,用户登陆.', '2015-12-17 12:22:07', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('370', '1', '操作模块:会话管理,用户登陆.', '2015-12-17 12:34:25', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('371', '1', '会话超时，用户退出.', '2015-12-17 13:07:35', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('372', '1', '操作模块:会话管理,用户登陆.', '2015-12-17 14:20:16', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('373', '1', '会话超时，用户退出.', '2015-12-17 15:14:34', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('374', '1', '操作模块:会话管理,用户登陆.', '2015-12-17 16:03:22', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('375', '1', '操作模块:会话管理,用户登陆.', '2015-12-17 16:04:25', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('376', '1', '操作模块:会话管理,用户登陆.', '2015-12-17 16:25:14', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('377', '1', '操作模块:会话管理,用户登陆.', '2015-12-17 16:32:08', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('378', '1', '操作模块:会话管理,用户登陆.', '2015-12-17 17:05:14', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('379', '1', '操作模块:会话管理,用户登陆.', '2015-12-18 09:17:07', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('380', '1', '操作模块:会话管理,用户登陆.', '2015-12-18 09:28:19', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('381', '1', '会话超时，用户退出.', '2015-12-18 09:57:33', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('382', '1', '操作模块:会话管理,用户登陆.', '2015-12-18 10:16:53', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('383', '1', '操作模块:会话管理,用户登陆.', '2015-12-18 10:23:02', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('384', '1', '操作模块:会话管理,用户登陆.', '2015-12-18 14:31:37', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('385', '1', '操作模块:会话管理,用户登陆.', '2015-12-18 14:34:58', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('386', '1', '会话超时，用户退出.', '2015-12-18 15:05:44', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('387', '1', '操作模块:会话管理,用户登陆.', '2015-12-18 15:07:32', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('388', '1', '操作模块:会话管理,用户登陆.', '2015-12-18 15:34:48', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('389', '1', '会话超时，用户退出.', '2015-12-18 16:18:44', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('390', '1', '操作模块:会话管理,用户登陆.', '2015-12-18 16:52:38', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('391', '1', '操作模块:会话管理,用户登陆.', '2015-12-18 16:56:47', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('392', '1', '操作模块:会话管理,用户登陆.', '2015-12-18 17:19:05', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('393', '1', '操作模块:会话管理,用户登陆.', '2015-12-21 09:01:22', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('394', '1', '操作模块:会话管理,用户登陆.', '2015-12-21 09:50:53', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('395', '1', '操作模块:会话管理,用户登陆.', '2015-12-21 10:06:43', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('396', '1', '操作模块:会话管理,用户登陆.', '2015-12-21 10:11:44', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('397', '1', '操作模块:会话管理,用户登陆.', '2015-12-21 10:26:41', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('398', '1', '操作模块:会话管理,用户登陆.', '2015-12-21 11:04:24', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('399', '1', '操作模块:会话管理,用户注销.', '2015-12-21 11:04:46', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('400', '1', '操作模块:会话管理,用户登陆.', '2015-12-21 11:04:53', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('401', '1', '操作模块:会话管理,用户登陆.', '2015-12-21 11:05:12', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('402', '1', '操作模块:会话管理,用户登陆.', '2015-12-21 11:16:01', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('403', '1', '操作模块:会话管理,用户登陆.', '2015-12-21 11:19:07', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('404', '1', '操作模块:会话管理,用户登陆.', '2015-12-21 11:23:48', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('405', '1', '操作模块:会话管理,用户登陆.', '2015-12-21 11:27:37', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('406', '1', '操作模块:会话管理,用户登陆.', '2015-12-21 13:08:57', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('407', '1', '操作模块:会话管理,用户登陆.', '2015-12-21 13:35:57', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('408', '1', '操作模块:会话管理,用户登陆.', '2015-12-21 13:42:49', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('409', '1', '操作模块:会话管理,用户登陆.', '2015-12-21 14:04:15', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('410', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 09:17:04', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('411', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 10:12:54', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('412', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 10:41:28', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('413', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 10:46:50', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('414', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 11:08:08', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('415', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 13:28:00', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('416', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 13:39:43', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('417', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 13:59:13', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('418', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 13:59:35', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('419', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 14:00:37', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('420', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 14:25:48', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('421', '1', '操作模块:会话管理,用户注销.', '2015-12-22 14:31:09', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('422', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 14:31:17', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('423', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 14:31:20', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('424', '1', '操作模块:会话管理,用户注销.', '2015-12-22 14:33:00', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('425', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 14:33:14', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('426', '1', '操作模块:会话管理,用户注销.', '2015-12-22 14:33:27', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('427', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 14:33:38', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('428', '1', '操作模块:会话管理,用户注销.', '2015-12-22 14:34:00', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('429', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 14:34:06', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('430', '1', '操作模块:会话管理,用户注销.', '2015-12-22 14:34:12', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('431', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 14:34:20', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('432', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 14:43:45', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('433', '1', '会话超时，用户退出.', '2015-12-22 15:10:27', '192.168.1.230', '');
INSERT INTO `user_log` VALUES ('434', '1', '会话超时，用户退出.', '2015-12-22 15:13:57', '192.168.1.230', '');
INSERT INTO `user_log` VALUES ('435', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 15:18:10', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('436', '1', '操作模块:会话管理,用户登陆.', '2015-12-22 15:22:47', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('437', '1', '会话超时，用户退出.', '2015-12-22 15:51:27', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('438', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 10:12:50', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('439', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 10:27:28', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('440', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 12:15:50', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('441', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 12:17:29', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('442', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 12:19:55', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('443', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 12:22:14', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('444', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 12:26:57', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('445', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 12:46:26', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('446', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 13:21:08', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('447', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 13:23:35', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('448', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 13:37:25', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('449', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 14:11:07', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('450', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 14:19:54', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('451', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 14:36:04', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('452', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 14:54:17', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('453', '1', '会话超时，用户退出.', '2015-12-23 15:30:44', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('454', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 16:39:48', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('455', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 16:45:28', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('456', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 16:52:43', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('457', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 17:02:53', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('458', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 17:05:41', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('459', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 17:17:18', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('460', '1', '操作模块:会话管理,用户登陆.', '2015-12-23 17:22:40', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('461', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 10:19:41', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('462', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 10:40:41', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('463', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 11:07:27', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('464', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 11:27:37', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('465', '1', '会话超时，用户退出.', '2015-12-24 12:00:41', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('466', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 13:26:03', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('467', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 13:55:48', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('468', '1', '操作模块:会话管理,用户注销.', '2015-12-24 13:57:41', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('469', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 13:57:47', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('470', '1', '操作模块:会话管理,用户注销.', '2015-12-24 14:00:18', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('471', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 14:00:24', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('472', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 14:06:08', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('473', '1', '操作模块:会话管理,用户注销.', '2015-12-24 14:13:27', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('474', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 14:13:33', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('475', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 14:15:46', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('476', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 14:21:27', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('477', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 14:33:59', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('478', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 15:00:40', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('479', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 15:07:00', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('480', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 15:13:37', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('481', '1', '操作模块:会话管理,用户注销.', '2015-12-24 15:16:35', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('482', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 15:23:50', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('483', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 15:29:04', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('484', '1', '会话超时，用户退出.', '2015-12-24 16:08:57', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('485', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 16:54:11', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('486', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 17:10:31', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('487', '1', '操作模块:会话管理,用户登陆.', '2015-12-24 17:28:05', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('488', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 09:22:34', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('489', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 09:35:29', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('490', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 09:45:31', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('491', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 10:01:44', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('492', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 10:13:10', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('493', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 10:22:37', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('494', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 10:30:11', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('495', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 10:36:32', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('496', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 10:49:11', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('497', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 11:02:44', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('498', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 11:08:34', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('499', '1', '会话超时，用户退出.', '2015-12-25 11:47:41', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('500', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 13:13:30', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('501', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 13:36:27', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('502', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 13:40:22', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('503', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 13:45:28', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('504', '1', '会话超时，用户退出.', '2015-12-25 14:41:34', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('505', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 16:30:54', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('506', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 16:36:38', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('507', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 16:40:48', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('508', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 16:53:26', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('509', '1', '操作模块:会话管理,用户登陆.', '2015-12-25 17:13:59', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('510', '1', '操作模块:会话管理,用户登陆.', '2015-12-28 09:28:30', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('511', '1', '操作模块:会话管理,用户登陆.', '2015-12-28 09:58:17', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('512', '1', '操作模块:会话管理,用户登陆.', '2015-12-28 10:00:14', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('513', '1', '操作模块:会话管理,用户登陆.', '2015-12-28 10:04:12', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('514', '1', '操作模块:会话管理,用户登陆.', '2015-12-28 10:17:04', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('515', '1', '操作模块:会话管理,用户登陆.', '2015-12-28 10:32:18', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('516', '1', '操作模块:会话管理,用户登陆.', '2015-12-28 10:51:50', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('517', '1', '操作模块:会话管理,用户登陆.', '2015-12-28 12:55:13', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('518', '1', '操作模块:会话管理,用户登陆.', '2015-12-28 13:17:21', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('519', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 09:11:22', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('520', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 10:14:11', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('521', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 10:20:14', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('522', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 10:28:12', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('523', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 10:32:05', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('524', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 10:34:30', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('525', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 10:38:38', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('526', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 10:44:07', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('527', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 10:49:36', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('528', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 10:51:32', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('529', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 10:53:09', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('530', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 10:54:37', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('531', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 10:56:07', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('532', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 10:58:42', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('533', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 11:01:30', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('534', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 11:09:18', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('535', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 11:15:41', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('536', '1', '会话超时，用户退出.', '2015-12-29 11:59:15', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('537', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 12:04:18', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('538', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 12:05:45', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('539', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 12:10:49', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('540', '1', '会话超时，用户退出.', '2015-12-29 12:42:50', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('541', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 13:19:05', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('542', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 15:05:19', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('543', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 15:10:37', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('544', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 15:15:05', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('545', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 15:21:36', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('546', '2', '操作模块:会话管理,用户登陆.', '2015-12-29 15:22:42', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('547', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 15:24:08', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('548', '2', '操作模块:会话管理,用户登陆.', '2015-12-29 15:24:19', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('549', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 15:25:13', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('550', '2', '操作模块:会话管理,用户登陆.', '2015-12-29 15:25:34', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('551', '1', '操作模块:会话管理,用户登陆.', '2015-12-29 15:33:39', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('552', '1', '会话超时，用户退出.', '2015-12-29 17:13:12', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('553', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 10:10:50', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('554', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 11:18:54', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('555', '1', '会话超时，用户退出.', '2015-12-30 11:48:33', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('556', '1', '会话超时，用户退出.', '2015-12-30 11:58:33', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('557', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 12:05:24', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('558', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 12:10:38', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('559', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 12:51:52', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('560', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 13:47:33', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('561', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 14:00:19', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('562', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 14:40:26', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('563', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 15:34:53', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('564', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 15:37:31', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('565', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 16:23:23', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('566', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 16:34:34', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('567', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 16:48:14', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('568', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 16:48:44', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('569', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 17:00:49', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('570', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 17:11:05', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('571', '1', '操作模块:会话管理,用户登陆.', '2015-12-30 17:15:04', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('572', '1', '操作模块:会话管理,用户登陆.', '2015-12-31 10:20:32', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('573', '1', '操作模块:会话管理,用户登陆.', '2015-12-31 10:23:44', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('574', '1', '操作模块:会话管理,用户登陆.', '2015-12-31 10:31:28', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('575', '1', '操作模块:会话管理,用户登陆.', '2015-12-31 10:35:38', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('576', '1', '操作模块:会话管理,用户登陆.', '2015-12-31 10:48:38', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('577', '1', '会话超时，用户退出.', '2015-12-31 11:01:03', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('578', '1', '操作模块:会话管理,用户登陆.', '2015-12-31 11:34:34', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('579', '1', '会话超时，用户退出.', '2015-12-31 12:10:03', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('580', '1', '操作模块:会话管理,用户登陆.', '2015-12-31 12:11:00', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('581', '1', '操作模块:会话管理,用户登陆.', '2015-12-31 12:16:33', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('582', '1', '操作模块:会话管理,用户登陆.', '2015-12-31 12:22:50', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('583', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 09:12:51', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('584', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 11:02:22', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('585', '1', '会话超时，用户退出.', '2016-01-04 12:09:42', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('586', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 13:57:38', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('587', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 13:59:50', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('588', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 14:12:37', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('589', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 14:12:48', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('590', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 14:18:18', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('591', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 14:22:12', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('592', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 14:22:27', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('593', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 14:24:43', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('594', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 14:24:55', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('595', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 14:33:32', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('596', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 14:42:24', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('597', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 14:44:34', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('598', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 14:46:48', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('599', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 14:49:38', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('600', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 14:54:08', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('601', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 14:54:31', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('602', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 14:59:04', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('603', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 15:06:21', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('604', '2', '会话超时，用户退出.', '2016-01-04 15:28:01', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('605', '1', '会话超时，用户退出.', '2016-01-04 15:38:31', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('606', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 15:44:56', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('607', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 15:46:04', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('608', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 15:48:54', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('609', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 15:49:42', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('610', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 15:50:50', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('611', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 15:51:28', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('612', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 15:52:11', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('613', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 15:57:16', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('614', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 15:57:44', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('615', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 16:02:51', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('616', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 16:08:04', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('617', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 16:09:24', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('618', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 16:10:41', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('619', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 16:14:05', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('620', '2', '会话超时，用户退出.', '2016-01-04 16:20:01', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('621', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 16:28:02', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('622', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 16:28:14', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('623', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 16:29:32', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('624', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 16:35:05', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('625', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 16:41:30', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('626', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 16:48:33', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('627', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 16:56:30', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('628', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 17:09:31', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('629', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 17:10:10', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('630', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 17:11:43', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('631', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 17:12:08', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('632', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 17:12:25', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('633', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 17:12:50', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('634', '1', '操作模块:会话管理,用户登陆.', '2016-01-04 17:19:59', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('635', '2', '操作模块:会话管理,用户登陆.', '2016-01-04 17:20:27', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('636', '1', '操作模块:会话管理,用户登陆.', '2016-01-05 09:46:56', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('637', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 09:56:42', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('638', '1', '操作模块:会话管理,用户登陆.', '2016-01-05 10:05:36', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('639', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 10:09:20', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('640', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 10:09:41', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('641', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 10:10:35', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('642', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 10:11:24', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('643', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 10:13:54', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('644', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 10:15:46', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('645', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 10:25:22', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('646', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 10:26:13', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('647', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 10:30:19', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('648', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 10:36:57', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('649', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 10:40:28', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('650', '2', '会话超时，用户退出.', '2016-01-05 10:40:58', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('651', '1', '操作模块:会话管理,用户登陆.', '2016-01-05 10:49:29', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('652', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 10:49:40', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('653', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 10:56:08', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('654', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 11:11:20', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('655', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 11:26:33', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('656', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 11:28:17', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('657', '1', '会话超时，用户退出.', '2016-01-05 11:30:28', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('658', '2', '会话超时，用户退出.', '2016-01-05 11:58:58', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('659', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 13:23:13', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('660', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 13:29:55', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('661', '1', '操作模块:会话管理,用户登陆.', '2016-01-05 13:30:11', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('662', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 13:32:46', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('663', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 13:35:22', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('664', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 13:38:39', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('665', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 13:40:09', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('666', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 13:42:57', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('667', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 13:48:30', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('668', '1', '操作模块:会话管理,用户登陆.', '2016-01-05 13:56:49', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('669', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 13:57:33', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('670', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 14:07:40', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('671', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 14:17:08', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('672', '1', '操作模块:会话管理,用户登陆.', '2016-01-05 14:25:38', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('673', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 14:26:30', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('674', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 14:31:07', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('675', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 14:36:13', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('676', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 14:40:52', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('677', '1', '会话超时，用户退出.', '2016-01-05 14:46:58', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('678', '1', '操作模块:会话管理,用户登陆.', '2016-01-05 14:47:53', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('679', '2', '操作模块:会话管理,用户登陆.', '2016-01-05 14:49:22', '0:0:0:0:0:0:0:1', '');
INSERT INTO `user_log` VALUES ('680', '2', '会话超时，用户退出.', '2016-01-05 14:54:58', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('681', '2', '会话超时，用户退出.', '2016-01-05 15:01:28', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('682', '2', '会话超时，用户退出.', '2016-01-05 15:42:28', '192.168.1.240', '');
INSERT INTO `user_log` VALUES ('683', '2', '操作模块:会话管理,用户登陆.', '2016-01-06 13:48:33', '127.0.0.1', '');

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
INSERT INTO `user_role_link` VALUES ('1', '1', '1', '', '');
INSERT INTO `user_role_link` VALUES ('2', '2', '1', '', '');

-- ----------------------------
-- Table structure for voltage_rank_classify
-- ----------------------------
DROP TABLE IF EXISTS `voltage_rank_classify`;
CREATE TABLE `voltage_rank_classify` (
  `id` int(4) NOT NULL COMMENT '电压等级分类表',
  `name` varchar(20) DEFAULT '' COMMENT '电压等级名称',
  `value` int(8) DEFAULT '0' COMMENT '对应的电压  对应单位 kv',
  `bigEquipment` int(4) DEFAULT '1' COMMENT '施工是否必须具备大张牵设备 1 需要 , 2  不需要',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of voltage_rank_classify
-- ----------------------------
INSERT INTO `voltage_rank_classify` VALUES ('1', '500kV以上', '1000', '1');
INSERT INTO `voltage_rank_classify` VALUES ('2', '500kV', '500', '1');
INSERT INTO `voltage_rank_classify` VALUES ('3', '220kV', '220', '1');
INSERT INTO `voltage_rank_classify` VALUES ('4', '110kV', '110', '0');
