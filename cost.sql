/*
Navicat MySQL Data Transfer

Source Server         : xiangping
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : cost

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2018-11-17 14:02:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_audit_recnd
-- ----------------------------
DROP TABLE IF EXISTS `t_audit_recnd`;
CREATE TABLE `t_audit_recnd` (
  `auditId` int(11) NOT NULL AUTO_INCREMENT,
  `expemseId` int(11) DEFAULT NULL,
  `usersId` int(11) DEFAULT NULL,
  `auditState` varchar(15) DEFAULT NULL,
  `auditSugg` varchar(150) DEFAULT NULL,
  `auditDate` datetime DEFAULT NULL,
  PRIMARY KEY (`auditId`),
  KEY `FK_Relationship_4` (`usersId`),
  KEY `FK_Relationship_5` (`expemseId`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`usersId`) REFERENCES `t_users` (`usersId`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`expemseId`) REFERENCES `t_expemse` (`expemseId`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_audit_recnd
-- ----------------------------
INSERT INTO `t_audit_recnd` VALUES ('62', '12', '1', '3', '阿凡达', '2018-11-04 23:51:58');
INSERT INTO `t_audit_recnd` VALUES ('63', '12', '1', '3', '发送到', '2018-11-04 23:52:43');
INSERT INTO `t_audit_recnd` VALUES ('64', '12', '1', '3', '建行卡', '2018-11-04 23:54:15');
INSERT INTO `t_audit_recnd` VALUES ('65', '13', '1', '3', '儿童', '2018-11-05 00:04:36');
INSERT INTO `t_audit_recnd` VALUES ('66', '13', '1', '3', '多少', '2018-11-05 00:04:42');
INSERT INTO `t_audit_recnd` VALUES ('67', '13', '1', '4', '三个', '2018-11-05 00:04:47');
INSERT INTO `t_audit_recnd` VALUES ('68', '13', '1', '4', '打发', '2018-11-05 11:58:17');
INSERT INTO `t_audit_recnd` VALUES ('69', '13', '1', '1', '阿斯顿发', '2018-11-05 12:02:41');
INSERT INTO `t_audit_recnd` VALUES ('70', '13', '1', '1', '阿萨法', '2018-11-05 12:03:32');
INSERT INTO `t_audit_recnd` VALUES ('71', '13', '1', '1', '大师傅', '2018-11-05 12:06:30');
INSERT INTO `t_audit_recnd` VALUES ('72', '13', '1', '2', '好的', '2018-11-05 12:06:42');
INSERT INTO `t_audit_recnd` VALUES ('73', '12', '1', '3', 'buxing\r\n', '2018-11-07 11:13:12');
INSERT INTO `t_audit_recnd` VALUES ('74', '14', '1', '4', 'keyi', '2018-11-07 11:13:45');
INSERT INTO `t_audit_recnd` VALUES ('75', '15', '1', '3', '不清楚', '2018-11-08 20:13:41');
INSERT INTO `t_audit_recnd` VALUES ('76', '14', '1', '2', '可以', '2018-11-08 20:13:57');
INSERT INTO `t_audit_recnd` VALUES ('77', '15', '7', '4', '可以', '2018-11-08 20:16:12');
INSERT INTO `t_audit_recnd` VALUES ('78', '12', '7', '4', '行', '2018-11-08 20:16:22');
INSERT INTO `t_audit_recnd` VALUES ('79', '16', '4', '4', '可以报销', '2018-11-17 13:56:38');
INSERT INTO `t_audit_recnd` VALUES ('80', '12', '5', '2', '可以', '2018-11-17 13:57:54');

-- ----------------------------
-- Table structure for t_cost
-- ----------------------------
DROP TABLE IF EXISTS `t_cost`;
CREATE TABLE `t_cost` (
  `costId` int(11) NOT NULL AUTO_INCREMENT,
  `costName` varchar(25) DEFAULT NULL,
  `costIdDesc` varchar(150) DEFAULT NULL,
  `costIdMark` varchar(3) DEFAULT '0',
  PRIMARY KEY (`costId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cost
-- ----------------------------
INSERT INTO `t_cost` VALUES ('1', '吃饭', '陪客户1', '0');
INSERT INTO `t_cost` VALUES ('2', 'KTV', '陪客户', '0');
INSERT INTO `t_cost` VALUES ('3', '坐车', '出差\r\n', '0');
INSERT INTO `t_cost` VALUES ('4', '火车票', '出差', '0');
INSERT INTO `t_cost` VALUES ('5', '坐出租车', '陪客户', '0');
INSERT INTO `t_cost` VALUES ('6', '吃饭', '0陪客户', '1');

-- ----------------------------
-- Table structure for t_expemse
-- ----------------------------
DROP TABLE IF EXISTS `t_expemse`;
CREATE TABLE `t_expemse` (
  `expemseId` int(11) NOT NULL AUTO_INCREMENT,
  `usersId` int(11) DEFAULT NULL,
  `expemseName` varchar(25) DEFAULT NULL,
  `expemseDesc` varchar(150) DEFAULT NULL,
  `expemseToltel` float DEFAULT NULL,
  `expemseDate` datetime DEFAULT NULL,
  `expemseState` varchar(3) DEFAULT NULL,
  `expemseMark` varchar(3) DEFAULT '0',
  PRIMARY KEY (`expemseId`),
  KEY `FK_Relationship_1` (`usersId`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`usersId`) REFERENCES `t_users` (`usersId`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_expemse
-- ----------------------------
INSERT INTO `t_expemse` VALUES ('12', '5', '出差', '出差出差', '470', '2018-11-01 22:58:50', '1', '2');
INSERT INTO `t_expemse` VALUES ('13', '3', '出行', '出行出行出行出行', '278', '2018-11-03 10:05:32', '1', '2');
INSERT INTO `t_expemse` VALUES ('14', '1', '工作', '采购', '391', '2018-11-04 21:47:42', '1', '2');
INSERT INTO `t_expemse` VALUES ('15', '1', '打客服', '发电房', '567', '2018-11-04 21:53:00', '1', '4');
INSERT INTO `t_expemse` VALUES ('16', '1', '出差', '出处', '468', '2018-11-08 20:13:01', '1', '4');
INSERT INTO `t_expemse` VALUES ('17', '1', '出', '吃饭', '135', '2018-11-17 12:46:31', '1', '0');
INSERT INTO `t_expemse` VALUES ('30', '3', '出差', '出差', '123', '2018-11-17 13:47:53', '1', '0');
INSERT INTO `t_expemse` VALUES ('31', '3', '出差', '出差出差', '234', '2018-11-17 13:51:16', '0', '0');
INSERT INTO `t_expemse` VALUES ('32', '3', '坐车', '坐车', '123', '2018-11-17 13:54:51', '0', '0');
INSERT INTO `t_expemse` VALUES ('33', '3', '吃饭', '吃饭', '234', '2018-11-17 13:55:11', '1', '0');

-- ----------------------------
-- Table structure for t_expemse_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_expemse_detail`;
CREATE TABLE `t_expemse_detail` (
  `detailId` int(11) NOT NULL AUTO_INCREMENT,
  `expemseId` int(11) DEFAULT NULL,
  `costId` int(11) DEFAULT NULL,
  `detailDesc` varchar(150) DEFAULT NULL,
  `detailMoney` float DEFAULT NULL,
  `detailMark` varchar(3) DEFAULT '0',
  PRIMARY KEY (`detailId`),
  KEY `FK_Relationship_2` (`expemseId`),
  KEY `FK_Relationship_3` (`costId`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`expemseId`) REFERENCES `t_expemse` (`expemseId`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`costId`) REFERENCES `t_cost` (`costId`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_expemse_detail
-- ----------------------------
INSERT INTO `t_expemse_detail` VALUES ('16', '13', '1', '阿萨德发的是', '123', '0');
INSERT INTO `t_expemse_detail` VALUES ('17', '13', '2', '阿士大夫撒', '123', '0');
INSERT INTO `t_expemse_detail` VALUES ('18', '13', '3', '阿第三方', '32', '0');
INSERT INTO `t_expemse_detail` VALUES ('19', '12', '1', '出差出差', '123', '0');
INSERT INTO `t_expemse_detail` VALUES ('20', '12', '2', '出差出差', '324', '0');
INSERT INTO `t_expemse_detail` VALUES ('21', '12', '3', '安抚', '23', '0');
INSERT INTO `t_expemse_detail` VALUES ('25', '15', '1', '沙发阿斯顿发', '321', '0');
INSERT INTO `t_expemse_detail` VALUES ('26', '15', '2', '发斯蒂芬', '123', '0');
INSERT INTO `t_expemse_detail` VALUES ('27', '15', '3', '阿道夫', '123', '0');
INSERT INTO `t_expemse_detail` VALUES ('38', '14', '1', 'dggfh', '134', '0');
INSERT INTO `t_expemse_detail` VALUES ('39', '14', '2', '傻大个', '234', '0');
INSERT INTO `t_expemse_detail` VALUES ('40', '14', '5', '规定', '23', '0');
INSERT INTO `t_expemse_detail` VALUES ('44', '16', '1', '大事发生', '123', '0');
INSERT INTO `t_expemse_detail` VALUES ('45', '16', '3', '陪客户', '345', '0');
INSERT INTO `t_expemse_detail` VALUES ('48', '17', '1', '大事发生', '123', '0');
INSERT INTO `t_expemse_detail` VALUES ('49', '17', '2', '大厦法定', '12', '0');
INSERT INTO `t_expemse_detail` VALUES ('55', '30', '3', '来回火车票', '123', '0');
INSERT INTO `t_expemse_detail` VALUES ('56', '31', '4', '安抚', '234', '0');
INSERT INTO `t_expemse_detail` VALUES ('57', '32', '5', '坐车', '123', '0');
INSERT INTO `t_expemse_detail` VALUES ('58', '33', '1', '吃饭', '234', '0');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(25) DEFAULT NULL,
  `pMenuId` int(11) DEFAULT NULL,
  `menuUrl` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '系统管理', '0', null);
INSERT INTO `t_menu` VALUES ('2', '报销管理', '0', null);
INSERT INTO `t_menu` VALUES ('3', '财务管理', '0', null);
INSERT INTO `t_menu` VALUES ('4', '用户管理', '1', 'system/queryUsers');
INSERT INTO `t_menu` VALUES ('5', '费用管理', '1', 'system/queryCosts');
INSERT INTO `t_menu` VALUES ('6', '个人信息', '1', 'system/updateMyUser');
INSERT INTO `t_menu` VALUES ('7', '我的薪资', '1', 'finance/MyQuerySalarys');
INSERT INTO `t_menu` VALUES ('8', '报销单', '2', 'expense/addExpense');
INSERT INTO `t_menu` VALUES ('9', '经理审批', '2', 'expense/managerExpenses');
INSERT INTO `t_menu` VALUES ('10', '报销查询', '2', 'expense/queryExpenses');
INSERT INTO `t_menu` VALUES ('11', '我的报销', '2', 'expense/queryMyExpenses');
INSERT INTO `t_menu` VALUES ('12', '财务审批', '3', 'finance/financeExpenses');
INSERT INTO `t_menu` VALUES ('13', '薪资发放', '3', 'finance/addSalary');
INSERT INTO `t_menu` VALUES ('14', '薪资查询', '3', 'finance/querySalarys');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '普通员工');
INSERT INTO `t_role` VALUES ('2', '部门经理');
INSERT INTO `t_role` VALUES ('3', '财务人员');
INSERT INTO `t_role` VALUES ('4', '超级管理员');

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `roleId` int(11) NOT NULL,
  `menuId` int(11) NOT NULL,
  PRIMARY KEY (`roleId`,`menuId`),
  KEY `FK_t_role_menu2` (`menuId`),
  CONSTRAINT `FK_t_role_menu` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`roleId`),
  CONSTRAINT `FK_t_role_menu2` FOREIGN KEY (`menuId`) REFERENCES `t_menu` (`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES ('1', '1');
INSERT INTO `t_role_menu` VALUES ('2', '1');
INSERT INTO `t_role_menu` VALUES ('3', '1');
INSERT INTO `t_role_menu` VALUES ('4', '1');
INSERT INTO `t_role_menu` VALUES ('1', '2');
INSERT INTO `t_role_menu` VALUES ('2', '2');
INSERT INTO `t_role_menu` VALUES ('3', '2');
INSERT INTO `t_role_menu` VALUES ('4', '2');
INSERT INTO `t_role_menu` VALUES ('3', '3');
INSERT INTO `t_role_menu` VALUES ('4', '3');
INSERT INTO `t_role_menu` VALUES ('4', '4');
INSERT INTO `t_role_menu` VALUES ('3', '5');
INSERT INTO `t_role_menu` VALUES ('4', '5');
INSERT INTO `t_role_menu` VALUES ('1', '6');
INSERT INTO `t_role_menu` VALUES ('2', '6');
INSERT INTO `t_role_menu` VALUES ('3', '6');
INSERT INTO `t_role_menu` VALUES ('4', '6');
INSERT INTO `t_role_menu` VALUES ('1', '7');
INSERT INTO `t_role_menu` VALUES ('2', '7');
INSERT INTO `t_role_menu` VALUES ('3', '7');
INSERT INTO `t_role_menu` VALUES ('4', '7');
INSERT INTO `t_role_menu` VALUES ('1', '8');
INSERT INTO `t_role_menu` VALUES ('3', '8');
INSERT INTO `t_role_menu` VALUES ('4', '8');
INSERT INTO `t_role_menu` VALUES ('2', '9');
INSERT INTO `t_role_menu` VALUES ('4', '9');
INSERT INTO `t_role_menu` VALUES ('2', '10');
INSERT INTO `t_role_menu` VALUES ('4', '10');
INSERT INTO `t_role_menu` VALUES ('1', '11');
INSERT INTO `t_role_menu` VALUES ('2', '11');
INSERT INTO `t_role_menu` VALUES ('3', '11');
INSERT INTO `t_role_menu` VALUES ('4', '11');
INSERT INTO `t_role_menu` VALUES ('3', '12');
INSERT INTO `t_role_menu` VALUES ('4', '12');
INSERT INTO `t_role_menu` VALUES ('3', '13');
INSERT INTO `t_role_menu` VALUES ('4', '13');
INSERT INTO `t_role_menu` VALUES ('3', '14');
INSERT INTO `t_role_menu` VALUES ('4', '14');

-- ----------------------------
-- Table structure for t_salary_recond
-- ----------------------------
DROP TABLE IF EXISTS `t_salary_recond`;
CREATE TABLE `t_salary_recond` (
  `salaryId` int(11) NOT NULL AUTO_INCREMENT,
  `usersId` int(11) DEFAULT NULL,
  `salaryMonth` datetime DEFAULT NULL,
  `salaryDate` datetime DEFAULT NULL,
  `salaryBasic` float DEFAULT NULL,
  `salaryComm` float DEFAULT NULL,
  PRIMARY KEY (`salaryId`),
  KEY `FK_Relationship_6` (`usersId`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`usersId`) REFERENCES `t_users` (`usersId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_salary_recond
-- ----------------------------
INSERT INTO `t_salary_recond` VALUES ('1', '1', '2018-09-01 00:00:00', '2018-11-06 20:39:02', '9000', '12222');
INSERT INTO `t_salary_recond` VALUES ('2', '2', '2018-09-01 00:00:00', '2018-11-06 20:42:39', '12154', '1230');
INSERT INTO `t_salary_recond` VALUES ('3', '4', '2018-10-01 00:00:00', '2018-11-06 20:42:49', '255', '10000');
INSERT INTO `t_salary_recond` VALUES ('4', '1', '2018-11-01 00:00:00', '2018-11-06 23:34:41', '9000', '1231');
INSERT INTO `t_salary_recond` VALUES ('5', '1', '2018-12-01 00:00:00', '2018-11-06 23:34:50', '9000', '214');
INSERT INTO `t_salary_recond` VALUES ('6', '4', '2018-09-01 00:00:00', '2018-11-07 11:23:56', '255', '1223');
INSERT INTO `t_salary_recond` VALUES ('7', '7', '2018-10-01 00:00:00', '2018-11-08 20:14:41', '5000', '1231');
INSERT INTO `t_salary_recond` VALUES ('8', '3', '2018-09-01 00:00:00', '2018-11-17 13:58:23', '12154', '1000');

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `usersId` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) DEFAULT NULL,
  `usersName` varchar(15) DEFAULT NULL,
  `usersSex` varchar(3) DEFAULT NULL,
  `usersAge` int(11) DEFAULT NULL,
  `usersPhone` varchar(11) DEFAULT NULL,
  `usersAccount` varchar(20) DEFAULT NULL,
  `usersPwd` varchar(32) DEFAULT NULL,
  `usersSalsy` float DEFAULT NULL,
  `usersMark` varchar(3) DEFAULT '0',
  PRIMARY KEY (`usersId`),
  KEY `FK_Relationship_7` (`roleId`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('1', '4', '风痕', '男', '23', '1574394647', 'xiangping', '12312312', '9000', '0');
INSERT INTO `t_users` VALUES ('2', '1', 'abc', '女', '30', '1254642', 'abc', 'abcd', '3000', '0');
INSERT INTO `t_users` VALUES ('3', '1', 'ab', '男', '25', '2546424', 'ab', 'ab', '12154', '0');
INSERT INTO `t_users` VALUES ('4', '2', 'xp', '男', '15', '2545658', 'xp', 'xp', '255', '0');
INSERT INTO `t_users` VALUES ('5', '3', 'ad', '女', '22', '2541452', 'ad', 'ad', '14444', '0');
INSERT INTO `t_users` VALUES ('6', '3', 'xiaohong12', '男', '23', '125465885', 'xiaohong', 'xiaohong', '5000', '1');
INSERT INTO `t_users` VALUES ('7', '2', '小明', '男', '23', '12546854875', 'xiaoming', 'xiaoming', '5000', '0');
