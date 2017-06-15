/*
Navicat MySQL Data Transfer

Source Server         : projects
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : day37

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-06-15 17:12:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_dept`
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `id` int(11) DEFAULT NULL,
  `deptName` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES ('1', '何宇彤');
INSERT INTO `t_dept` VALUES ('2', 'xz');
INSERT INTO `t_dept` VALUES ('3', '人事部');
