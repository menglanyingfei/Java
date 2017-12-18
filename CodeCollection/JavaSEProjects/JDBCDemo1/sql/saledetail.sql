/*
Navicat MySQL Data Transfer

Source Server         : MySQL Server
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : sale

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-12-18 13:00:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for saledetail
-- ----------------------------
DROP TABLE IF EXISTS `saledetail`;
CREATE TABLE `saledetail` (
  `number` varchar(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `unitPrice` decimal(10,2) DEFAULT NULL,
  `sum` int(11) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `saleman` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
