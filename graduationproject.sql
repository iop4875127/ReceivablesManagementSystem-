/*
Navicat MySQL Data Transfer

Source Server         : connroot
Source Server Version : 50552
Source Host           : localhost:3306
Source Database       : graduationproject

Target Server Type    : MYSQL
Target Server Version : 50552
File Encoding         : 65001

Date: 2017-11-30 17:46:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for aa
-- ----------------------------
DROP TABLE IF EXISTS `aa`;
CREATE TABLE `aa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `state` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aa
-- ----------------------------
INSERT INTO `aa` VALUES ('1', 'afsdf', '1');
INSERT INTO `aa` VALUES ('2', 'wangwu', '1');
INSERT INTO `aa` VALUES ('3', 'wangwu', '1');
INSERT INTO `aa` VALUES ('4', 'wangwu', '1');
INSERT INTO `aa` VALUES ('5', 'wangwu', '1');
INSERT INTO `aa` VALUES ('6', 'wangwu', '1');
INSERT INTO `aa` VALUES ('7', 'wangwu', null);
INSERT INTO `aa` VALUES ('8', 'wangwu', null);
INSERT INTO `aa` VALUES ('9', 'wangwu', null);
INSERT INTO `aa` VALUES ('10', 'wangwu', null);

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `aid` int(5) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `follow` int(11) DEFAULT NULL,
  `fans` int(11) DEFAULT NULL,
  `weibo` int(11) DEFAULT NULL,
  `pic` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  UNIQUE KEY `acccount_email_unique` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'zhangsan@163.com', '张三', '123456', '2', '3', '7', '1.jpg');
INSERT INTO `account` VALUES ('2', 'lisi@163.com', '李四', '123456', '0', '0', '1', '2.jpg');
INSERT INTO `account` VALUES ('3', 'wangwu@163.com', '王五', '123456', '0', '0', '2', '3.jpg');
INSERT INTO `account` VALUES ('4', 'maliu@gmail.com', '马六', '123456', '0', '0', '0', '4.jpg');
INSERT INTO `account` VALUES ('5', 'zhangsa', null, '123456', null, null, null, null);

-- ----------------------------
-- Table structure for bm_contract
-- ----------------------------
DROP TABLE IF EXISTS `bm_contract`;
CREATE TABLE `bm_contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contract_no` varchar(50) DEFAULT NULL,
  `signing_date` date DEFAULT NULL,
  `contract_cost` decimal(15,4) DEFAULT NULL,
  `privilege` int(11) DEFAULT NULL,
  `contract_violate` varchar(50) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `customs_no` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bm_contract
-- ----------------------------
INSERT INTO `bm_contract` VALUES ('1', '100001', '2018-05-09', '2720000.0000', '3', '不按时完成任务扣除本提成的60%', null, '1', '1');
INSERT INTO `bm_contract` VALUES ('2', '100002', '2017-09-30', '1700000.0000', '3', '不按时完成任务扣除本提成的60%', null, '1', '2');
INSERT INTO `bm_contract` VALUES ('3', '100003', '2017-05-03', '60000000.0000', '5', '不按时完成任务扣除本提成的60%', null, '1', '3');
INSERT INTO `bm_contract` VALUES ('4', '100004', '2018-02-03', '75000000.0000', '5', '不按时完成任务扣除本提成的60%', null, '1', '4');
INSERT INTO `bm_contract` VALUES ('5', '100005', '2017-01-03', '45000000.0000', '5', '不按时完成任务扣除本提成的60%', null, '1', '5');
INSERT INTO `bm_contract` VALUES ('10', '6', '2017-05-03', '123.0000', null, '123', '123', '1', '6');

-- ----------------------------
-- Table structure for bm_deposit
-- ----------------------------
DROP TABLE IF EXISTS `bm_deposit`;
CREATE TABLE `bm_deposit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `should_deposit` decimal(18,4) DEFAULT NULL,
  `area` int(18) unsigned zerofill DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `reality_deposit` decimal(18,4) DEFAULT NULL,
  `privileges` int(11) DEFAULT NULL,
  `customer_no` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bm_deposit
-- ----------------------------
INSERT INTO `bm_deposit` VALUES ('1', '272000.0000', '000000000000200000', '武当比武场', '1', '272000.0000', '3', '1');
INSERT INTO `bm_deposit` VALUES ('2', '170000.0000', '000000000000160000', '峨眉客栈', '1', '170000.0000', '3', '2');
INSERT INTO `bm_deposit` VALUES ('3', '6000000.0000', '000000000040000000', '大明皇宫', '1', '6000000.0000', '5', '3');
INSERT INTO `bm_deposit` VALUES ('4', '7500000.0000', '000000000050000000', '元大都', '1', '75000000.0000', '5', '4');
INSERT INTO `bm_deposit` VALUES ('5', '4500000.0000', '000000000060000000', '长安古城', '1', '4500000.0000', '5', '5');
INSERT INTO `bm_deposit` VALUES ('10', '1234.0000', null, null, '1', null, null, '6');

-- ----------------------------
-- Table structure for bm_period
-- ----------------------------
DROP TABLE IF EXISTS `bm_period`;
CREATE TABLE `bm_period` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `period_lot_no` int(11) DEFAULT NULL,
  `should_finish_the_task` varchar(50) DEFAULT NULL,
  `period_homeworlk_date` date DEFAULT NULL,
  `period_money` decimal(18,4) DEFAULT NULL,
  `period_payable_date` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `reality_finish_the_task` varchar(50) DEFAULT NULL,
  `period_pay_reality_date` date DEFAULT NULL,
  `contract_no` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bm_period
-- ----------------------------
INSERT INTO `bm_period` VALUES ('1', '1', '建造比武场的围栏，地面', '2018-08-09', '800000.0000', '2018-08-09', '1', '完成任务', '2018-08-09', '100001');
INSERT INTO `bm_period` VALUES ('2', '2', '建造比武场的期初设施', '2018-12-12', '1200000.0000', '2018-12-12', '1', '完成任务', '2018-12-12', '100001');
INSERT INTO `bm_period` VALUES ('3', '3', '建造比武场擂台', '2019-06-06', '1200000.0000', '2019-06-06', '1', '完成任务', '2019-06-04', '100001');
INSERT INTO `bm_period` VALUES ('4', '1', '建造地基', '2017-12-30', '320000.0000', '2017-12-30', '1', '完成任务', '2017-12-22', '100002');
INSERT INTO `bm_period` VALUES ('5', '2', '建造房梁', '2018-03-04', '480000.0000', '2018-03-04', '1', '完成任务', '2018-03-01', '100002');
INSERT INTO `bm_period` VALUES ('6', '3', '配置窗床', '2018-11-13', '480000.0000', '2018-11-13', '1', '完成任务', '2018-11-02', '100002');
INSERT INTO `bm_period` VALUES ('7', '4', '最后装修', '2019-01-01', '320000.0000', '2019-01-01', '1', '完成任务', '2019-01-01', '100002');
INSERT INTO `bm_period` VALUES ('8', '1', '大明皇宫的地基建设', '2017-08-03', '80000000.0000', '2017-08-03', '1', '完成任务', '2017-08-01', '100003');
INSERT INTO `bm_period` VALUES ('9', '2', '大明皇宫的房梁建设', '2018-04-05', '80000000.0000', '2018-04-05', '1', '完成任务', '0018-04-04', '100003');
INSERT INTO `bm_period` VALUES ('10', '3', '大明皇宫的墙体绘画', '2018-02-03', '80000000.0000', '2018-02-03', '1', '完成任务', '2018-02-03', '100003');
INSERT INTO `bm_period` VALUES ('11', '4', '大明皇宫的窗床建设', '2019-09-03', '80000000.0000', '2019-09-03', '1', '完成任务', '2019-09-01', '100003');
INSERT INTO `bm_period` VALUES ('12', '5', '大明皇宫的装修建设', '2019-12-12', '80000000.0000', '2019-12-12', '1', '按成任务', '2019-12-12', '100003');
INSERT INTO `bm_period` VALUES ('13', '1', '元大都的地址建设', '2018-07-03', '100000000.0000', '2018-07-03', '1', '完成任务', '2018-07-03', '100004');
INSERT INTO `bm_period` VALUES ('14', '2', '元大都的房梁建设', '2018-12-12', '150000000.0000', '2018-12-12', '1', '完成任务', '2018-12-12', '100004');
INSERT INTO `bm_period` VALUES ('15', '3', '元大都的窗床建设', '2019-04-06', '150000000.0000', '2019-04-06', '1', '完成任务', '2019-04-02', '100004');
INSERT INTO `bm_period` VALUES ('16', '4', '元大都的装修建设', '2019-11-03', '100000000.0000', '2019-11-03', '1', '完成任务', '2019-11-01', '100004');
INSERT INTO `bm_period` VALUES ('18', '2', '长安古城的房梁建设', '2018-04-03', '180000000.0000', '2018-04-03', '1', '未完成任务', '2018-05-03', '100005');
INSERT INTO `bm_period` VALUES ('19', '3', '长安古城的窗床建设', '2018-12-12', '180000000.0000', '2018-12-12', '1', '完成任务', '2018-12-11', '100005');
INSERT INTO `bm_period` VALUES ('20', '4', '长安古城的装修建设', '2019-05-23', '120000000.0000', '2019-05-23', '1', '完成任务', '2019-05-05', '100005');
INSERT INTO `bm_period` VALUES ('24', '1231', null, '2017-05-03', '123.0000', null, '1', null, null, '231');
INSERT INTO `bm_period` VALUES ('25', '1234', null, '2017-05-03', '234.0000', null, '1', null, null, '123');
INSERT INTO `bm_period` VALUES ('26', '1231', null, '2017-05-03', '123.0000', null, '1', null, null, '21');

-- ----------------------------
-- Table structure for cm_customer
-- ----------------------------
DROP TABLE IF EXISTS `cm_customer`;
CREATE TABLE `cm_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(50) DEFAULT '',
  `sex` int(11) DEFAULT NULL,
  `contact` int(15) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `area` varchar(50) DEFAULT NULL,
  `home_type` int(11) DEFAULT NULL,
  `project_no` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `customer_no` int(11) DEFAULT NULL,
  `privileges` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cm_customer
-- ----------------------------
INSERT INTO `cm_customer` VALUES ('1', '张三丰', '1', '1234567891', '武当比武场', '200000', '2', '1', '1', '1', '3');
INSERT INTO `cm_customer` VALUES ('2', '灭绝师太', '0', '1234456789', '峨眉客栈', '160000', '2', '2', '1', '2', '3');
INSERT INTO `cm_customer` VALUES ('3', '刘病已', '1', '1234567890', '大明皇宫', '40000000', '1', '3', '1', '3', '5');
INSERT INTO `cm_customer` VALUES ('4', '赵敏', '2', '1111111111', '元大都', '50000000', '1', '4', '1', '4', '5');
INSERT INTO `cm_customer` VALUES ('5', '李星云', '1', '1234567890', '长安皇城', '60000000', '1', '5', '1', '5', '5');
INSERT INTO `cm_customer` VALUES ('10', '鼓风机', null, '123', '1234', '123', '1234', null, '1', '6', '0');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `cid` int(5) NOT NULL AUTO_INCREMENT,
  `aid` int(5) DEFAULT NULL,
  `wid` int(5) DEFAULT NULL,
  `ccontent` varchar(140) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FK_account_comment` (`aid`),
  KEY `FK_weibo_comment` (`wid`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `account` (`aid`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`wid`) REFERENCES `weibo` (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '4', '3', '新修改的评论2', '2016-10-15 14:44:42');
INSERT INTO `comment` VALUES ('2', '4', '3', '新修改的评论343434', '2016-10-15 15:04:11');
INSERT INTO `comment` VALUES ('3', '4', '3', '新修改的评论343434', '2016-10-15 15:04:57');

-- ----------------------------
-- Table structure for fm_check_money
-- ----------------------------
DROP TABLE IF EXISTS `fm_check_money`;
CREATE TABLE `fm_check_money` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contract_no` varchar(50) DEFAULT NULL,
  `check_state` int(11) DEFAULT NULL,
  `check_date` date DEFAULT NULL,
  `check_name` varchar(50) DEFAULT NULL,
  `check_emp_no` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `pay` decimal(18,4) DEFAULT NULL,
  `receipt` decimal(18,4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fm_check_money
-- ----------------------------

-- ----------------------------
-- Table structure for fm_costing_detail
-- ----------------------------
DROP TABLE IF EXISTS `fm_costing_detail`;
CREATE TABLE `fm_costing_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contract_no` varchar(50) DEFAULT NULL,
  `material_cost` decimal(18,4) DEFAULT NULL,
  `construct_cost` decimal(18,4) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `project_no` varchar(50) DEFAULT NULL,
  `contract_period` int(11) DEFAULT NULL,
  `project_manager` varchar(50) DEFAULT NULL,
  `operator_no` int(11) DEFAULT NULL,
  `operator_date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fm_costing_detail
-- ----------------------------
INSERT INTO `fm_costing_detail` VALUES ('1', '100001', '272000.0000', '2720000.0000', '1', ' ', null, null, null, null);
INSERT INTO `fm_costing_detail` VALUES ('2', '100002', '170000.0000', '1700000.0000', '1', null, null, null, null, null);
INSERT INTO `fm_costing_detail` VALUES ('3', '100003', '6000000.0000', '60000000.0000', '1', null, null, null, null, null);
INSERT INTO `fm_costing_detail` VALUES ('4', '100004', '7500000.0000', '75000000.0000', '1', null, null, null, null, null);
INSERT INTO `fm_costing_detail` VALUES ('5', '100005', '4500000.0000', '45000000.0000', '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for fm_receipt_detail
-- ----------------------------
DROP TABLE IF EXISTS `fm_receipt_detail`;
CREATE TABLE `fm_receipt_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_no` varchar(50) DEFAULT NULL,
  `pay_name` varchar(50) DEFAULT NULL,
  `pay_contact` varchar(50) DEFAULT NULL,
  `receipt_no` varchar(50) DEFAULT NULL,
  `receipt_name` varchar(50) DEFAULT NULL,
  `receipt_way` varchar(50) DEFAULT NULL,
  `in_fact_money` decimal(18,4) DEFAULT NULL,
  `payable_money` decimal(18,4) DEFAULT NULL,
  `receipt_date` date DEFAULT NULL,
  `number_of_periods` int(11) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  `state` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fm_receipt_detail
-- ----------------------------
INSERT INTO `fm_receipt_detail` VALUES ('1', '1', '张三丰', '12345678912@qq.com', '17', '零零发', '1', '720000.0000', '720000.0000', '2018-08-09', '1', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('2', '2', '张三丰', '12345678912@qq.com', '17', '零零发', '1', '1444000.0000', '1444000.0000', '2018-12-12', '2', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('3', '3', '张三丰', '12345678912@qq.com', '17', '零零发', '2', '1249960.0000', '1249960.0000', '2019-06-06', '3', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('4', '4', '灭绝师太', '12345678912@qq.com', '17', '零零发', '2', '882500.0000', '882500.0000', '2017-12-30', '1', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('5', '5', '灭绝师太', '12345678912@qq.com', '17', '零零发', '2', '935000.0000', '935000.0000', '2018-03-04', '2', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('6', '6', '灭绝师太', '12345678912@qq.com', '17', '零零发', '1', '821000.0000', '821000.0000', '2018-11-13', '3', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('7', '7', '灭绝师太', '12345678912@qq.com', '17', '零零发', '1', '432000.0000', '432000.0000', '2019-01-01', '4', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('8', '8', '刘病已', '12345678912@qq.com', '17', '零零发', '3', '16000000.0000', '16000000.0000', '2017-08-03', '1', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('9', '9', '刘病已', '12345678912@qq.com', '17', '零零发', '1', '16020000.0000', '16020000.0000', '2018-04-05', '2', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('10', '10', '刘病已', '12345678912@qq.com', '17', '零零发', '2', '16016000.0000', '16016000.0000', '2018-02-03', '3', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('11', '11', '刘病已', '12345678912@qq.com', '17', '零零发', '1', '16020000.0000', '16020000.0000', '2019-09-03', '4', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('12', '12', '刘病已', '12345678912@qq.com', '17', '零零发', '3', '16020000.0000', '16020000.0000', '2019-12-12', '5', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('13', '13', '赵敏', '12345678912@qq.com', '17', '零零发', '2', '20030000.0000', '20030000.0000', '2018-07-03', '1', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('14', '14', '赵敏', '12345678912@qq.com', '17', '零零发', '2', '40016000.0000', '40016000.0000', '2018-12-12', '2', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('15', '15', '赵敏', '12345678912@qq.com', '17', '零零发', '3', '40020000.0000', '40020000.0000', '2019-04-06', '3', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('16', '16', '张无忌', '12345678912@qq.com', '17', '零零发', '3', '20002000.0000', '20002000.0000', '2019-11-03', '4', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('17', '17', '李星云', '12345678912@qq.com', '17', '零零发', '3', '12020000.0000', '12020000.0000', '2017-04-03', '1', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('18', '18', '李星云', '12345678912@qq.com', '17', '零零发', '3', '18024000.0000', '18024000.0000', '2018-04-03', '2', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('19', '19', '李星云', '12345678912@qq.com', '17', '零零发', '3', '18030000.0000', '18030000.0000', '2018-12-12', '3', null, '1');
INSERT INTO `fm_receipt_detail` VALUES ('20', '20', '李星云', '12345678912@qq.com', '17', '零零发', '3', '12040000.0000', '12040000.0000', '2019-05-23', '4', null, '1');

-- ----------------------------
-- Table structure for fm_salary
-- ----------------------------
DROP TABLE IF EXISTS `fm_salary`;
CREATE TABLE `fm_salary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_no` varchar(50) DEFAULT NULL,
  `basic_salary` decimal(18,4) DEFAULT NULL,
  `push_money` decimal(18,4) DEFAULT NULL,
  `cut_money` decimal(18,4) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fm_salary
-- ----------------------------
INSERT INTO `fm_salary` VALUES ('1', '1', '6000.0000', '1200.0000', '200.0000', '1');
INSERT INTO `fm_salary` VALUES ('2', '2', '6000.0000', '900.0000', '200.0000', '1');
INSERT INTO `fm_salary` VALUES ('3', '3', '12000.0000', '1200.0000', '200.0000', '1');
INSERT INTO `fm_salary` VALUES ('4', '4', '6000.0000', '900.0000', '200.0000', '1');
INSERT INTO `fm_salary` VALUES ('5', '5', '12000.0000', '1200.0000', '200.0000', '1');
INSERT INTO `fm_salary` VALUES ('6', '6', '5000.0000', '800.0000', '200.0000', '1');
INSERT INTO `fm_salary` VALUES ('7', '7', '20000.0000', '5000.0000', '200.0000', '1');
INSERT INTO `fm_salary` VALUES ('8', '8', '12000.0000', '1200.0000', '200.0000', '1');
INSERT INTO `fm_salary` VALUES ('9', '9', '12000.0000', '1200.0000', '200.0000', '1');
INSERT INTO `fm_salary` VALUES ('10', '10', '12000.0000', '1200.0000', '200.0000', '1');
INSERT INTO `fm_salary` VALUES ('11', '11', '12000.0000', '1200.0000', '200.0000', '1');
INSERT INTO `fm_salary` VALUES ('12', '12', '12000.0000', '1200.0000', '200.0000', '1');
INSERT INTO `fm_salary` VALUES ('13', '13', '12000.0000', '1200.0000', '200.0000', '1');
INSERT INTO `fm_salary` VALUES ('14', '14', '12000.0000', '1200.0000', '200.0000', '1');
INSERT INTO `fm_salary` VALUES ('15', '15', '12000.0000', '1200.0000', '200.0000', '1');
INSERT INTO `fm_salary` VALUES ('16', '16', '6000.0000', '900.0000', '200.0000', '1');

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `fid` int(5) NOT NULL AUTO_INCREMENT,
  `aid` int(5) DEFAULT NULL,
  `follow_aid` int(11) DEFAULT NULL,
  `ftime` datetime DEFAULT NULL,
  `mutual_concern` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `FK_account_follow` (`aid`),
  CONSTRAINT `follow_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `account` (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of follow
-- ----------------------------
INSERT INTO `follow` VALUES ('1', '1', '2', '2016-07-29 15:36:42', null);
INSERT INTO `follow` VALUES ('2', '1', '3', '2016-07-29 15:36:51', null);
INSERT INTO `follow` VALUES ('3', '2', '1', '2016-07-29 15:37:02', null);
INSERT INTO `follow` VALUES ('4', '2', '4', '2016-07-29 15:37:11', null);
INSERT INTO `follow` VALUES ('5', '3', '1', '2016-07-29 15:37:31', null);
INSERT INTO `follow` VALUES ('6', '4', '1', '2016-07-29 15:58:13', null);
INSERT INTO `follow` VALUES ('7', '4', '2', '2016-07-29 15:58:20', null);
INSERT INTO `follow` VALUES ('8', '4', '3', '2016-07-29 15:58:28', null);

-- ----------------------------
-- Table structure for hrm_employee
-- ----------------------------
DROP TABLE IF EXISTS `hrm_employee`;
CREATE TABLE `hrm_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_no` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `nation` varchar(50) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL,
  `id_card` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hrm_employee
-- ----------------------------
INSERT INTO `hrm_employee` VALUES ('1', '0001', '张三', '1', '28', '汉族', '12345678907', '利民家具公寓', '策划部', '设计师三级', '142311198903087875', '1');
INSERT INTO `hrm_employee` VALUES ('2', '0002', '李四', '0', '25', '汉族', '234567876543', '利民家修公寓', '策划部', '设计师三级', '142733199208093477', '1');
INSERT INTO `hrm_employee` VALUES ('3', '0003', '王五', '1', '38', '汉族', '123423242313', '利民家修公寓', '策划部', '设计总监', '143322198203084844', '1');
INSERT INTO `hrm_employee` VALUES ('4', '0004', '刘二', '1', '29', '汉族', '123456765456', '利民家修公寓', '工程部', '工程师三级', '143534198703057423', '1');
INSERT INTO `hrm_employee` VALUES ('5', '0005', '上官柳儿', '0', '18', '藏族', '12345555554', '利民家修公寓', '工程部', '工程总监', '145322199604069899', '1');
INSERT INTO `hrm_employee` VALUES ('6', '0006', '赵八', '1', '45', '蛮族', '12345433455', '瓦岗寨', '决策团', '副总二级', '143523197304027363', '0');
INSERT INTO `hrm_employee` VALUES ('7', '0007', '上官凌霄', '1', '27', '汉族', '12345432344', '利民家修别墅', '决策团', '总经理', '142121199004034235', '1');
INSERT INTO `hrm_employee` VALUES ('8', '0008', '上官伤', '1', '29', '汉族', '12344323434', '利民别墅', '工程部', '工程总监', '142033190103042341', '1');
INSERT INTO `hrm_employee` VALUES ('9', '0009', '上官峰', '1', '24', '汉族', '12343234345', '利民别墅', '工程部', '工程总监', '142033190103042341', '1');
INSERT INTO `hrm_employee` VALUES ('10', '0010', '上官云雀', '1', '38', '汉族', '12313143234', '利民别墅', '工程部', '工程总监', '142033190103042341', '1');
INSERT INTO `hrm_employee` VALUES ('11', '0011', '上官福禄', '1', '23', '汉族', '12341432213', '利民别墅', '工程部', '功臣总监', '142033190103042341', '1');
INSERT INTO `hrm_employee` VALUES ('12', '0012', '上官克', '1', '23', '汉族', '12312312321', '利民别墅', '工程部', '工程总监', '142033190103042341', '1');
INSERT INTO `hrm_employee` VALUES ('13', '0013', '上官领', '0', '24', '汉族', '22343241235', '利民别墅', '工程部', '工程总监', '142033190103042341', '1');
INSERT INTO `hrm_employee` VALUES ('14', '0014', '上官服', '1', '24', '汉族', '12334943994', '利民别墅', '工程部', '工程总监', '142033190103042341', '1');
INSERT INTO `hrm_employee` VALUES ('15', '0015', '上官廖', '1', '22', '汉族', '53449u92455', '利民别墅', '工程部', '工程总监', '142033190103042341', '1');
INSERT INTO `hrm_employee` VALUES ('16', '0016', '麻七', '1', '28', '汉族', '12324324343', '利民公寓', '工程部', '城市建设者二级', '142033190103042341', '1');
INSERT INTO `hrm_employee` VALUES ('17', '0017', '零零发', '1', '22', '汉族', '12312442324', '利民公寓', '工程部', '财务部会计二级', '142033190103042341', '1');

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `pic` varchar(25) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `detail` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES ('1', '奶粉', '96.8', null, '2016-10-04', '三鹿的奶粉暴利');
INSERT INTO `items` VALUES ('2', '玩具', '186.8', '2.jpg', '2016-10-03', '有变形精钢了');
INSERT INTO `items` VALUES ('5', '123123123', '555', null, null, '');
INSERT INTO `items` VALUES ('6', 'jhui', '52.8', null, null, '5');
INSERT INTO `items` VALUES ('14', '11111111', null, null, null, null);
INSERT INTO `items` VALUES ('15', 'fffffffff', '2.3', null, null, 's');
INSERT INTO `items` VALUES ('16', 'vvvvvvvvvvv', '3.6', null, null, '2.3');

-- ----------------------------
-- Table structure for liked
-- ----------------------------
DROP TABLE IF EXISTS `liked`;
CREATE TABLE `liked` (
  `aid` int(5) NOT NULL,
  `wid` int(5) NOT NULL,
  `ltime` datetime DEFAULT NULL,
  PRIMARY KEY (`aid`,`wid`),
  KEY `FK_weibo_liked` (`wid`),
  CONSTRAINT `liked_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `account` (`aid`),
  CONSTRAINT `liked_ibfk_2` FOREIGN KEY (`wid`) REFERENCES `weibo` (`wid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of liked
-- ----------------------------
INSERT INTO `liked` VALUES ('1', '1', '2016-08-02 12:10:49');
INSERT INTO `liked` VALUES ('1', '5', '2016-08-02 15:25:23');
INSERT INTO `liked` VALUES ('1', '6', '2016-08-02 15:25:22');
INSERT INTO `liked` VALUES ('1', '8', '2016-08-02 16:09:44');
INSERT INTO `liked` VALUES ('1', '10', '2016-08-05 16:01:48');
INSERT INTO `liked` VALUES ('1', '50214', '2016-08-05 16:01:21');
INSERT INTO `liked` VALUES ('1', '50215', '2016-08-05 16:24:17');
INSERT INTO `liked` VALUES ('2', '2', '2016-08-02 16:44:45');
INSERT INTO `liked` VALUES ('2', '4', '2016-08-02 16:44:44');
INSERT INTO `liked` VALUES ('2', '5', '2016-08-02 15:25:25');
INSERT INTO `liked` VALUES ('2', '6', '2016-08-05 15:49:31');
INSERT INTO `liked` VALUES ('2', '7', '2016-08-02 16:44:42');
INSERT INTO `liked` VALUES ('2', '8', '2016-08-05 16:02:30');
INSERT INTO `liked` VALUES ('2', '9', '2016-08-02 16:44:40');
INSERT INTO `liked` VALUES ('2', '10', '2016-08-02 16:44:37');
INSERT INTO `liked` VALUES ('2', '11', '2016-08-02 16:44:38');
INSERT INTO `liked` VALUES ('2', '13', '2016-08-05 15:49:24');
INSERT INTO `liked` VALUES ('2', '15', '2016-08-05 15:49:21');
INSERT INTO `liked` VALUES ('2', '50214', '2016-08-05 16:02:34');
INSERT INTO `liked` VALUES ('2', '50215', '2016-08-05 16:02:32');
INSERT INTO `liked` VALUES ('3', '1', '2016-08-05 15:49:53');
INSERT INTO `liked` VALUES ('3', '2', '2016-07-29 15:36:16');
INSERT INTO `liked` VALUES ('3', '3', '2016-08-05 15:50:06');
INSERT INTO `liked` VALUES ('3', '5', '2016-08-05 15:50:06');
INSERT INTO `liked` VALUES ('3', '6', '2016-08-05 15:49:58');
INSERT INTO `liked` VALUES ('3', '7', '2016-08-05 15:49:59');
INSERT INTO `liked` VALUES ('3', '8', '2016-08-05 15:49:56');
INSERT INTO `liked` VALUES ('3', '10', '2016-08-05 15:50:02');
INSERT INTO `liked` VALUES ('3', '12', '2016-08-05 15:50:03');
INSERT INTO `liked` VALUES ('3', '14', '2016-08-05 15:50:04');
INSERT INTO `liked` VALUES ('3', '50215', '2016-08-05 16:02:48');
INSERT INTO `liked` VALUES ('4', '10', '2016-08-05 16:04:46');
INSERT INTO `liked` VALUES ('4', '50214', '2016-08-05 16:04:42');
INSERT INTO `liked` VALUES ('4', '50215', '2016-08-05 16:03:18');

-- ----------------------------
-- Table structure for mm_store_house
-- ----------------------------
DROP TABLE IF EXISTS `mm_store_house`;
CREATE TABLE `mm_store_house` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `material_name` varchar(50) DEFAULT NULL,
  `material_no` varchar(50) DEFAULT NULL,
  `material_price` decimal(18,4) DEFAULT NULL,
  `material_params` varchar(50) DEFAULT NULL,
  `state` int(11) NOT NULL,
  `material_parts` varchar(50) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mm_store_house
-- ----------------------------
INSERT INTO `mm_store_house` VALUES ('1', '房梁', '1', '8000.0000', '长20米直径35厘米', '1', '两端塑料壳2个', '3');
INSERT INTO `mm_store_house` VALUES ('2', '木床', '2', '1888.1234', '长2.5米宽2米', '1', '床脚4个', '4');
INSERT INTO `mm_store_house` VALUES ('3', '石凳', '3', '58.0000', '质量为20公斤', '1', null, '5');
INSERT INTO `mm_store_house` VALUES ('4', '蜡烛', '4', '38.0000', '红色烛台', '1', '烛台一个', '5');
INSERT INTO `mm_store_house` VALUES ('5', '窗帘', '5', '288.0000', '幻粉长8米高4米', '1', '帘扣28个', '2');
INSERT INTO `mm_store_house` VALUES ('6', '龙椅', '6', '8888888.8888', '长1.8米高1.3米', '1', '龙头四个', '1');
INSERT INTO `mm_store_house` VALUES ('7', '窗', '7', '500.0000', '长一米二，高两米', '1', '玻璃一块', '3');
INSERT INTO `mm_store_house` VALUES ('8', '挖土机', '8', '10000.0000', '工程需要', '1', null, '1');
INSERT INTO `mm_store_house` VALUES ('9', '水泥', '9', '200.0000', '按袋计算', '1', null, '1');
INSERT INTO `mm_store_house` VALUES ('10', '木匠', '10', '5000.0000', '按月计算', '1', null, '1');
INSERT INTO `mm_store_house` VALUES ('11', '铁匠', '11', '5000.0000', '按月计算', '1', null, '1');

-- ----------------------------
-- Table structure for pm_plus_or_minus
-- ----------------------------
DROP TABLE IF EXISTS `pm_plus_or_minus`;
CREATE TABLE `pm_plus_or_minus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_no` varchar(50) DEFAULT NULL,
  `contract_no` varchar(50) DEFAULT NULL,
  `contract_period` int(11) DEFAULT NULL,
  `plus_or_minus_content` varchar(50) DEFAULT NULL,
  `plus_or_minus_money` decimal(18,4) DEFAULT NULL,
  `plus_or_minus_date` date DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pm_plus_or_minus
-- ----------------------------
INSERT INTO `pm_plus_or_minus` VALUES ('1', '1', '100001', '1', '增加挖土机两台', '20000.0000', '2018-06-05', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('2', '1', '100001', '1', '增加客运车两台', '10000.0000', '2018-06-02', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('3', '1', '100001', '1', '增加水泥N吨', '2000.0000', '2018-03-03', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('4', '1', '100001', '1', '增加水车两量', '8000.0000', '2018-08-01', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('5', '2', '100001', '2', '增加房梁10条', '80000.0000', '2018-11-03', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('6', '2', '100001', '2', '增加木材N吨', '200000.0000', '2018-11-30', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('7', '2', '100001', '2', '返回房梁2条', '-16000.0000', '2018-12-11', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('8', '2', '100001', '2', '增加房梁20条', '160000.0000', '2018-10-05', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('9', '3', '100001', '3', '增加兵器百样', '200000.0000', '2019-04-03', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('10', '3', '100001', '3', '增加枪100条', '30000.0000', '2019-04-09', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('11', '3', '100001', '3', '增加弓箭100对', '2000.0000', '2019-04-06', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('12', '3', '100001', '3', '增加剑50丙', '1000.0000', '2019-06-05', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('13', '3', '100001', '3', '返回剑2丙', '-40.0000', '2019-06-01', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('14', '4', '100002', '1', '增加挖土机亮亮', '20000.0000', '2017-11-30', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('15', '4', '100002', '1', '增加铁锹50把', '2500.0000', '2017-11-23', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('16', '4', '100002', '1', '增加炸药20份', '30000.0000', '2017-10-25', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('17', '4', '100002', '1', '增加铜矿2000吨', '400000.0000', '2017-11-29', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('18', '4', '100002', '1', '增加开销打通关系', '30000.0000', '2017-10-11', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('19', '5', '100002', '2', '增加增加房梁10条', '80000.0000', '2018-01-01', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('20', '5', '100002', '2', '增加领10根', '30000.0000', '2018-01-24', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('21', '5', '100002', '2', '增加木匠2名', '10000.0000', '2018-01-24', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('22', '5', '100002', '2', '增加铁匠3名', '15000.0000', '2018-02-24', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('23', '6', '100002', '3', '增加床位2位', '20000.0000', '2018-11-03', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('24', '6', '100002', '3', '增加窗户2个', '1000.0000', '2018-10-03', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('25', '7', '100002', '4', '增加丝绸20匹', '20000.0000', '2018-12-01', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('26', '7', '100002', '4', '增加被褥10套', '10000.0000', '2018-12-03', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('27', '7', '100002', '4', '增加镜子10个', '2000.0000', '2018-12-03', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('28', '8', '100003', '1', '增加挖土机2台', '20000.0000', '2017-06-03', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('29', '9', '100003', '2', '增加房梁2条', '16000.0000', '2018-04-01', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('30', '10', '100003', '3', '增加彩绘', '20000.0000', '2018-01-03', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('31', '11', '100003', '4', '增加床两张', '20000.0000', '2019-08-03', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('32', '12', '100003', '5', '增加绸缎10匹', '30000.0000', '2019-11-12', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('33', '13', '100004', '1', '增加两台挖土机', '20000.0000', '2018-06-03', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('34', '14', '100004', '2', '增加房梁2根', '16000.0000', '2018-11-12', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('35', '15', '100004', '3', '增加床两张', '20000.0000', '2019-03-02', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('36', '16', '100004', '4', '增加绸缎2匹', '2000.0000', '2019-10-01', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('37', '17', '100005', '1', '增加两台挖掘机', '20000.0000', '2017-03-03', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('38', '18', '100005', '2', '增加房梁3条', '24000.0000', '2018-04-03', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('39', '19', '100005', '3', '增加大床3张', '30000.0000', '2018-12-12', '1');
INSERT INTO `pm_plus_or_minus` VALUES ('40', '20', '100005', '4', '增加绸缎20匹', '40000.0000', '2019-04-23', '1');

-- ----------------------------
-- Table structure for pm_project
-- ----------------------------
DROP TABLE IF EXISTS `pm_project`;
CREATE TABLE `pm_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_no` varchar(50) DEFAULT NULL,
  `project_manager` varchar(50) DEFAULT NULL,
  `project_department` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `complete_date` date DEFAULT NULL,
  `completion_date` date DEFAULT NULL,
  `contract_no` varchar(50) DEFAULT NULL,
  `commission` varchar(50) DEFAULT NULL,
  `project_address` varchar(50) DEFAULT NULL,
  `contract_period` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pm_project
-- ----------------------------
INSERT INTO `pm_project` VALUES ('1', '1', '上官伤', '工程部', '1', '2018-08-09', '2018-08-08', '100001', '20%', '武当比武场', '1');
INSERT INTO `pm_project` VALUES ('2', '2', '上官伤', '工程部', '1', '2018-12-12', '2018-12-11', '100001', '20%', '武当比武场', '2');
INSERT INTO `pm_project` VALUES ('3', '3', '上官伤', '工程部', '1', '2019-06-06', '2019-06-04', '100001', '20%', '武当比武场', '3');
INSERT INTO `pm_project` VALUES ('4', '4', '上官柳儿', '工程部', '1', '2017-12-30', '2017-12-22', '100002', '20%', '峨眉客栈', '1');
INSERT INTO `pm_project` VALUES ('5', '5', '上官柳儿', '工程部', '1', '2018-03-04', '2018-03-01', '100002', '20%', '峨眉客栈', '2');
INSERT INTO `pm_project` VALUES ('6', '6', '上官柳儿', '工程部', '1', '2018-11-13', '2018-11-02', '100002', '20%', '峨眉客栈', '3');
INSERT INTO `pm_project` VALUES ('7', '7', '上官柳儿', '工程部', '1', '2019-01-01', '2019-01-01', '100002', '20%', '峨眉客栈', '4');
INSERT INTO `pm_project` VALUES ('8', '8', '上官峰', '工程部', '1', '2017-08-03', '2017-08-01', '100003', '20%', '大明皇宫', '1');
INSERT INTO `pm_project` VALUES ('9', '9', '上官峰', '工程部', '1', '2018-04-05', '2018-04-04', '100003', '20%·', '大明皇宫', '2');
INSERT INTO `pm_project` VALUES ('10', '10', '上官云雀', '工程部', '1', '2018-02-03', '2018-02-03', '100003', '205', '大明皇宫', '3');
INSERT INTO `pm_project` VALUES ('11', '11', '上官云雀', '工程部', '1', '2019-09-03', '2019-09-01', '100003', '20%', '大明皇宫', '4');
INSERT INTO `pm_project` VALUES ('12', '12', '上官峰', '工程部', '1', '2019-12-12', '2019-12-12', '100003', '20%', '大明皇宫', '5');
INSERT INTO `pm_project` VALUES ('13', '13', '上官伤', '工程部', '1', '2018-07-03', '2018-07-03', '100004', '20%', '元大都', '1');
INSERT INTO `pm_project` VALUES ('14', '14', '上官克', '工程部', '1', '2018-12-12', '2018-12-12', '100004', '20%', '元大都', '2');
INSERT INTO `pm_project` VALUES ('15', '15', '上官克', '工程部', '1', '2019-04-06', '2019-04-02', '100004', '20%', '元大都', '3');
INSERT INTO `pm_project` VALUES ('16', '16', '上官克', '工程部', '1', '2019-11-03', '2019-11-01', '100004', '20%', '元大都', '4');
INSERT INTO `pm_project` VALUES ('17', '17', '上官福禄', '工程部', '1', '2017-04-03', '2017-12-03', '100005', '20%', '长安皇城', '1');
INSERT INTO `pm_project` VALUES ('18', '18', '上官服', '工程部', '1', '2018-04-03', '2018-05-03', '100005', '20%', '长安皇城', '2');
INSERT INTO `pm_project` VALUES ('19', '19', '上官廖', '工程部', '1', '2018-12-12', '2018-12-11', '100005', '20%', '长安皇城', '3');
INSERT INTO `pm_project` VALUES ('20', '20', '上官服', '工程部', '1', '2019-05-23', '2019-05-05', '100005', '20%', '长安皇城', '4');

-- ----------------------------
-- Table structure for weibo
-- ----------------------------
DROP TABLE IF EXISTS `weibo`;
CREATE TABLE `weibo` (
  `wid` int(5) NOT NULL AUTO_INCREMENT,
  `aid` int(5) DEFAULT NULL,
  `wcontent` varchar(140) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `service` varchar(100) DEFAULT NULL,
  `liked` int(11) DEFAULT NULL,
  `comment` int(11) DEFAULT NULL,
  PRIMARY KEY (`wid`),
  KEY `FK_account_weibo` (`aid`),
  CONSTRAINT `weibo_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `account` (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=50216 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weibo
-- ----------------------------
INSERT INTO `weibo` VALUES ('1', '1', '大王叫我来巡山', '2016-07-29 15:32:10', 'iPhone 6s', '2', '0');
INSERT INTO `weibo` VALUES ('2', '2', '我是来揍张三的', '2016-07-29 15:32:59', 'weibo 网页', '2', '0');
INSERT INTO `weibo` VALUES ('3', '3', '天王盖地虎', '2016-07-29 15:33:56', '华为 P9', '1', '1');
INSERT INTO `weibo` VALUES ('4', '4', '我是马六，刚开通微博', '2016-07-29 15:49:03', 'weibo 网页', '1', '0');
INSERT INTO `weibo` VALUES ('5', '1', 'test', '2016-08-02 10:50:24', 'weibo 网页', '3', '0');
INSERT INTO `weibo` VALUES ('6', '1', 'test2', '2016-08-02 08:53:47', 'weibo 网页', '3', '0');
INSERT INTO `weibo` VALUES ('7', '1', '测试set修改', '2016-08-02 16:06:55', 'iPhone 7 Plus', '2', '0');
INSERT INTO `weibo` VALUES ('8', '1', 'aad', '2016-08-02 16:08:05', 'weibo网页', '3', '0');
INSERT INTO `weibo` VALUES ('9', '1', '张三发微博', '2016-08-02 16:09:16', 'weibo网页', '1', '0');
INSERT INTO `weibo` VALUES ('10', '1', '张三发微博2', '2016-08-02 16:10:21', 'weibo网页', '4', '0');
INSERT INTO `weibo` VALUES ('11', '2', '李四发一条', '2016-08-02 16:12:26', 'weibo网页', '1', '0');
INSERT INTO `weibo` VALUES ('12', '1', 'VAOXHUGAOFMHVUUAVHTPKVBDSGKYXODDUUMGXKRFU GFRVWU', '2016-08-05 13:38:01', 'ZYIFWTCYUJKNSQRTYRMN', '1', '0');
INSERT INTO `weibo` VALUES ('13', '2', 'RVVHSXPSUERATJLHTUNTFSLCIBQNWPLPQ', '2016-08-05 13:38:01', 'YBOIBUTIDPGFS', '1', '0');
INSERT INTO `weibo` VALUES ('14', '3', 'TPFJDDHMYXRYEBWYKIWYRMLUIKJCPFPMPLOOPQNDCHXNZ NHN QM', '2016-08-05 13:38:01', 'ITXPHFQXSSWYCAYWQBK', '1', '0');
INSERT INTO `weibo` VALUES ('15', '4', 'XYJXAGJJOPAZ', '2016-08-05 13:38:01', 'MMSLNLGQXJAGHLATQW', '1', '0');
INSERT INTO `weibo` VALUES ('50212', '3', 's', '2016-08-05 15:50:52', 'weibo网页', '0', '0');
INSERT INTO `weibo` VALUES ('50213', '3', 'gfgfg', '2016-08-05 15:53:53', 'weibo网页', '0', '0');
INSERT INTO `weibo` VALUES ('50214', '1', 'sdf', '2016-08-05 15:57:47', 'weibo网页', '3', '0');
INSERT INTO `weibo` VALUES ('50215', '1', 'sdfsdfd', '2016-08-05 16:00:50', 'weibo网页', '4', '0');
