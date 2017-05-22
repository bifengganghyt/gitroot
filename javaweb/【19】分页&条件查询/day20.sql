/*
Navicat MySQL Data Transfer

Source Server         : projects
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : day20

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-05-22 13:03:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `deptName` varchar(20) DEFAULT NULL,
  `principal` varchar(20) DEFAULT NULL,
  `functional` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('测试部', '2', '测试');
INSERT INTO `department` VALUES ('开发部', '2', '开发');
INSERT INTO `department` VALUES ('竞标组', '2', '竞标');
INSERT INTO `department` VALUES ('市场组', '3', '卖产品');
INSERT INTO `department` VALUES ('售后部', '3', '售后服务');
