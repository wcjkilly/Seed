/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50552
Source Host           : localhost:3306
Source Database       : public

Target Server Type    : MYSQL
Target Server Version : 50552
File Encoding         : 65001

Date: 2017-03-02 17:03:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `attendance`
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `situation` varchar(32) NOT NULL,
  `comment` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES ('1', 'xiaozhang', '2017-01-11 08:05:31', '正常', '100');
INSERT INTO `attendance` VALUES ('2', 'xiaozhang', '2017-01-20 10:06:23', '正常', '100');
INSERT INTO `attendance` VALUES ('3', 'xiaowang', '2017-03-01 22:40:03', '正常', '99');
INSERT INTO `attendance` VALUES ('4', 'xiaowang', '2017-03-06 22:40:14', '正常', '100');
INSERT INTO `attendance` VALUES ('5', 'xiaoming', '2017-03-01 22:40:33', '正常', '100');
INSERT INTO `attendance` VALUES ('6', 'xiaoming', '2017-03-14 22:40:54', '缺席', '60');

-- ----------------------------
-- Table structure for `classfare`
-- ----------------------------
DROP TABLE IF EXISTS `classfare`;
CREATE TABLE `classfare` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classid` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `activity` varchar(32) NOT NULL,
  `expend` int(11) DEFAULT NULL,
  `income` int(11) DEFAULT NULL,
  `comment` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classfare
-- ----------------------------
INSERT INTO `classfare` VALUES ('1', '1', '2017-03-01 14:29:25', '团队建设', '2000', '0', '无');
INSERT INTO `classfare` VALUES ('2', '1', '2017-03-02 14:30:13', '班级聚餐', '1000', '0', '无');
INSERT INTO `classfare` VALUES ('3', '1', '2017-03-08 14:30:16', '优秀班级奖励', '0', '3000', '无');
INSERT INTO `classfare` VALUES ('4', '2', '2017-03-01 14:30:40', '班级旅游', '3000', '0', '无');
INSERT INTO `classfare` VALUES ('5', '2', '2017-03-14 14:31:06', '文化墙布置', '300', '0', '无');
INSERT INTO `classfare` VALUES ('6', '1', '2017-03-31 00:00:00', '班级旅游', '2400', '0', '食宿等');
INSERT INTO `classfare` VALUES ('7', '2', '2017-03-18 00:00:00', '春游', '1200', '0', '车费+午饭');

-- ----------------------------
-- Table structure for `classgroup`
-- ----------------------------
DROP TABLE IF EXISTS `classgroup`;
CREATE TABLE `classgroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classid` int(11) NOT NULL,
  `type` varchar(32) NOT NULL,
  `manager` varchar(32) NOT NULL,
  `members` varchar(128) NOT NULL,
  `setuptime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `comment` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classgroup
-- ----------------------------
INSERT INTO `classgroup` VALUES ('1', '2', '班会', '小王', '小李，小张，小江', '2017-03-28 09:40:50', '无');
INSERT INTO `classgroup` VALUES ('2', '2', '校庆活动', '小李', '小张，小王', '2017-03-14 09:41:36', '无');
INSERT INTO `classgroup` VALUES ('3', '1', '舞会', '小月', '小李，小琴，小娇', '2017-03-14 09:42:22', '无');
INSERT INTO `classgroup` VALUES ('4', '1', '联谊', '小琴', '小月，小梦，李四', '2017-03-13 09:43:02', '无');
INSERT INTO `classgroup` VALUES ('5', '2', '班会2', '李四', '王五，张三，赵六', '2017-03-03 00:00:00', '带钱');
INSERT INTO `classgroup` VALUES ('6', '1', '班会', '张三', '王五，张三，赵六', '2017-03-01 00:00:00', '投票竞选班干');

-- ----------------------------
-- Table structure for `classinfo`
-- ----------------------------
DROP TABLE IF EXISTS `classinfo`;
CREATE TABLE `classinfo` (
  `class_` varchar(64) DEFAULT '',
  `classqq` varchar(64) DEFAULT '',
  `classflag` varchar(64) DEFAULT '',
  `school` varchar(64) DEFAULT '',
  `fteacher` varchar(64) DEFAULT '',
  `tel` varchar(64) DEFAULT '',
  `talktime` timestamp NULL DEFAULT NULL,
  `evaluate` int(11) NOT NULL,
  `classid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classinfo
-- ----------------------------
INSERT INTO `classinfo` VALUES ('2013级数学13班', '12345678', '你会写笛卡尔的心形函数么？', '西安交大', '汪哈哈', '66666636', '2017-01-02 00:00:00', '12', '1');
INSERT INTO `classinfo` VALUES ('2013级英语1班', '12348765', 'say hello to world!', '北京大学', 'Mr.Li', '66666656', '2017-02-07 10:09:47', '12', '2');

-- ----------------------------
-- Table structure for `document`
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `documentsub` varchar(64) NOT NULL,
  `documenttype` varchar(64) NOT NULL,
  `documentname` varchar(64) NOT NULL,
  `uploadtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `path` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of document
-- ----------------------------

-- ----------------------------
-- Table structure for `documentsub`
-- ----------------------------
DROP TABLE IF EXISTS `documentsub`;
CREATE TABLE `documentsub` (
  `major` varchar(64) NOT NULL,
  `documentsub` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of documentsub
-- ----------------------------
INSERT INTO `documentsub` VALUES ('英语', '英语（一）');
INSERT INTO `documentsub` VALUES ('英语', '英语（二）');
INSERT INTO `documentsub` VALUES ('英语', '英语（三）');
INSERT INTO `documentsub` VALUES ('英语', '英语（四）');
INSERT INTO `documentsub` VALUES ('英语', '英语（五）');
INSERT INTO `documentsub` VALUES ('英语', '英语（六）');
INSERT INTO `documentsub` VALUES ('数学', '高等数学');
INSERT INTO `documentsub` VALUES ('法律', '房地产法');
INSERT INTO `documentsub` VALUES ('法律', '行政法学');
INSERT INTO `documentsub` VALUES ('法律', '劳动法');
INSERT INTO `documentsub` VALUES ('法律', '企业与公司法学');
INSERT INTO `documentsub` VALUES ('法律', '税法原理');
INSERT INTO `documentsub` VALUES ('法律', '金融法概论');
INSERT INTO `documentsub` VALUES ('法律', '行政诉讼法');
INSERT INTO `documentsub` VALUES ('法律', '经济法学原理');
INSERT INTO `documentsub` VALUES ('法律', '环境法学');
INSERT INTO `documentsub` VALUES ('法律', '经济法毕业论文');
INSERT INTO `documentsub` VALUES ('文学', '中国近现代史纲要');
INSERT INTO `documentsub` VALUES ('文学', '马克思主义基本原理概论');

-- ----------------------------
-- Table structure for `documenttype`
-- ----------------------------
DROP TABLE IF EXISTS `documenttype`;
CREATE TABLE `documenttype` (
  `documenttype` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of documenttype
-- ----------------------------
INSERT INTO `documenttype` VALUES ('复习资料');
INSERT INTO `documenttype` VALUES ('练习题');
INSERT INTO `documenttype` VALUES ('内部资料');
INSERT INTO `documenttype` VALUES ('真题');
INSERT INTO `documenttype` VALUES ('错题集');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `username` varchar(64) DEFAULT '',
  `subid` int(11) NOT NULL,
  `score` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('xiaoming', '23', '90');
INSERT INTO `score` VALUES ('xiaowang', '24', '98');
INSERT INTO `score` VALUES ('xiaoming', '22', '88');
INSERT INTO `score` VALUES ('xiaoming', '24', '79');
INSERT INTO `score` VALUES ('xiaowang', '22', '90');
INSERT INTO `score` VALUES ('xiaozhang', '22', '89');
INSERT INTO `score` VALUES ('xiaozhang', '23', '91');
INSERT INTO `score` VALUES ('xiaozhang', '24', '97');

-- ----------------------------
-- Table structure for `subinfo`
-- ----------------------------
DROP TABLE IF EXISTS `subinfo`;
CREATE TABLE `subinfo` (
  `subid` int(11) NOT NULL,
  `sub` varchar(64) DEFAULT '',
  `starttime` timestamp NULL DEFAULT NULL,
  `subscore` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subinfo
-- ----------------------------
INSERT INTO `subinfo` VALUES ('23', '数学', '2015-09-01 08:00:58', '3');
INSERT INTO `subinfo` VALUES ('24', '英语', '2016-10-01 08:00:17', '4');
INSERT INTO `subinfo` VALUES ('22', '大学物理', '2016-09-01 15:15:17', '5');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `username` varchar(64) DEFAULT '',
  `password` varchar(64) DEFAULT '',
  `cardid` varchar(64) DEFAULT '',
  `class_` varchar(64) DEFAULT '',
  `address` varchar(64) DEFAULT '',
  `major` varchar(64) DEFAULT '',
  `sex` varchar(64) DEFAULT '',
  `qq` varchar(64) DEFAULT '',
  `position` varchar(64) DEFAULT '',
  `timeToSch` timestamp NULL DEFAULT NULL,
  `tel` varchar(64) DEFAULT '',
  `sid` varchar(64) DEFAULT '',
  `classid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('xiaoming', '123', '666666123456789012', '2013级数学13班', '贵阳', '数学', '男', '36763676', '班长', '2017-01-02 00:00:00', '12344566', '544333', '1');
INSERT INTO `userinfo` VALUES ('xiaowang', '123', '66666666', '2013级英语1班', '成都', '英语', '女', '66666666', '文艺委员', '2013-09-01 08:00:00', '12366666', '333666', '2');
INSERT INTO `userinfo` VALUES ('xiaozhang', '123', '66666678', '2013级数学13班', '上海', '数学', '男', '66666678', '副班长', '2016-12-01 09:01:05', '66666678', '544334', '1');
