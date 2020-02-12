/*
Navicat MySQL Data Transfer

Source Server         : 151
Source Server Version : 50638
Source Host           : 192.168.9.151:3306
Source Database       : dm_base

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2018-10-26 11:40:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dm_area
-- ----------------------------
DROP TABLE IF EXISTS `dm_area`;
CREATE TABLE `dm_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '区域名称',
  `parent` varchar(255) DEFAULT NULL COMMENT '父级区域',
  `level` int(1) DEFAULT NULL COMMENT '分类级别;select;(0:全国,1:1级,2:2级)',
  `isHot` int(1) DEFAULT NULL COMMENT '是否是热门城市(0:不是,1:是)',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatedTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='区域表';

-- ----------------------------
-- Records of dm_area
-- ----------------------------
INSERT INTO `dm_area` VALUES ('1', '北京市', '0', '1', '1', '2018-05-24 11:19:57', null);
INSERT INTO `dm_area` VALUES ('2', '上海市', '0', '1', '1', '2018-05-24 11:20:13', null);

-- ----------------------------
-- Table structure for dm_image
-- ----------------------------
DROP TABLE IF EXISTS `dm_image`;
CREATE TABLE `dm_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `imgUrl` varchar(255) DEFAULT NULL COMMENT '图片URL',
  `targetId` int(2) DEFAULT NULL COMMENT '关联表ID',
  `sort` int(2) DEFAULT NULL COMMENT '顺序',
  `type` int(2) DEFAULT NULL COMMENT '图片类型（0:无类型 1:轮播图 2:海报图）',
  `category` int(2) DEFAULT NULL COMMENT '图片分类（0：用户头像 1：商品图片）',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatedTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='图片表';

-- ----------------------------
-- Records of dm_image
-- ----------------------------
INSERT INTO `dm_image` VALUES ('1', null, '1', '1', '1', '1', '2018-05-24 10:50:14', null);
INSERT INTO `dm_image` VALUES ('2', null, '2', '1', '1', '1', '2018-05-24 10:50:14', null);
INSERT INTO `dm_image` VALUES ('3', null, '3', '1', '1', '1', '2018-05-24 10:50:14', null);
INSERT INTO `dm_image` VALUES ('4', null, '4', '1', '1', '0', '2018-05-24 10:50:14', '2018-05-31 12:15:48');
INSERT INTO `dm_image` VALUES ('5', null, '5', '1', '1', '1', '2018-05-24 10:50:14', null);
INSERT INTO `dm_image` VALUES ('6', null, '6', '1', '1', '1', '2018-05-24 10:50:14', null);
INSERT INTO `dm_image` VALUES ('7', null, '7', '1', '1', '1', '2018-05-24 10:50:14', null);
INSERT INTO `dm_image` VALUES ('8', null, '8', '1', '1', '1', '2018-05-24 10:50:14', null);
INSERT INTO `dm_image` VALUES ('9', '', '9', '1', '1', '1', '2018-05-24 10:50:14', null);
INSERT INTO `dm_image` VALUES ('26', null, '5', '1', '0', '0', '2018-05-31 18:36:23', '2018-05-31 20:04:38');
INSERT INTO `dm_image` VALUES ('27', null, '6', null, '0', '1', '2018-05-31 19:49:04', '2018-05-31 20:06:29');
INSERT INTO `dm_image` VALUES ('29', null, '7', null, '0', '0', '2018-05-31 20:06:48', null);
INSERT INTO `dm_image` VALUES ('30', null, '8', null, '0', '0', '2018-05-31 12:37:18', '2018-05-31 14:32:22');
INSERT INTO `dm_image` VALUES ('31', 'http://192.168.9.151:8888/531261283064877056.png', '3', null, '0', '0', '2018-05-31 12:55:25', '2018-07-02 07:37:35');
INSERT INTO `dm_image` VALUES ('33', 'http://192.168.9.151:8888/533731322628149248.jpg', '9', null, '0', '0', '2018-05-31 13:00:09', '2018-07-09 03:12:39');
INSERT INTO `dm_image` VALUES ('34', null, '10', null, '0', '0', '2018-05-31 13:00:09', null);
INSERT INTO `dm_image` VALUES ('35', null, '11', null, '0', '0', '2018-05-31 13:00:09', null);
INSERT INTO `dm_image` VALUES ('36', null, '12', null, '0', '0', '2018-05-31 13:00:09', null);
INSERT INTO `dm_image` VALUES ('37', null, '13', null, '0', '0', '2018-05-31 13:00:09', null);
INSERT INTO `dm_image` VALUES ('38', null, '14', null, '0', '0', '2018-05-31 13:00:09', null);
INSERT INTO `dm_image` VALUES ('39', null, '15', null, '0', '0', '2018-05-31 13:00:09', null);
INSERT INTO `dm_image` VALUES ('40', null, '16', null, '0', '0', '2018-05-31 13:00:09', null);
INSERT INTO `dm_image` VALUES ('41', null, '17', null, '0', '0', '2018-05-31 13:00:09', null);
INSERT INTO `dm_image` VALUES ('44', null, '6', null, '0', '0', '2018-05-31 19:17:52', '2018-06-01 03:19:21');
INSERT INTO `dm_image` VALUES ('46', 'test3_user.jpg', '18', null, '0', '0', '2018-06-25 19:14:16', null);
INSERT INTO `dm_image` VALUES ('47', 'http://192.168.9.151:8888/531231595735027712.jpg', '20', null, '0', '0', '2018-07-02 03:23:42', '2018-07-02 05:54:07');
INSERT INTO `dm_image` VALUES ('48', 'http://192.168.9.151:8888/531650660966338560.jpg', '62', null, '0', '0', '2018-07-03 09:24:50', '2018-07-03 09:27:06');

-- ----------------------------
-- Table structure for dm_keyword_sort
-- ----------------------------
DROP TABLE IF EXISTS `dm_keyword_sort`;
CREATE TABLE `dm_keyword_sort` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `keyword` varchar(255) DEFAULT NULL COMMENT '搜索关键词',
  `count` int(11) DEFAULT NULL COMMENT '搜索数目',
  `createdTime` datetime DEFAULT NULL,
  `updatedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='热门关键词排序表';

-- ----------------------------
-- Records of dm_keyword_sort
-- ----------------------------
