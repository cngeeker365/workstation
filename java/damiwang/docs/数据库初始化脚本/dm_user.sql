/*
Navicat MySQL Data Transfer

Source Server         : 151
Source Server Version : 50638
Source Host           : 192.168.9.151:3306
Source Database       : dm_user

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2018-10-26 11:43:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dm_link_user
-- ----------------------------
DROP TABLE IF EXISTS `dm_link_user`;
CREATE TABLE `dm_link_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL COMMENT '对应用户表的主键',
  `name` varchar(255) DEFAULT NULL COMMENT '联系人姓名',
  `idCard` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `cardType` int(1) DEFAULT NULL COMMENT '证件类型(0:身份证 1:护照)',
  `createdTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatedTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8 COMMENT='常用联系人表\r\n';

-- ----------------------------
-- Records of dm_link_user
-- ----------------------------
INSERT INTO `dm_link_user` VALUES ('1', '3', '常用联系人1', '370983111111111111', '1', '2018-05-30 11:26:53', '2018-05-30 11:26:53');
INSERT INTO `dm_link_user` VALUES ('4', '5', null, '7654321', null, '2018-05-30 19:33:31', null);
INSERT INTO `dm_link_user` VALUES ('5', '5', 'laodong', '123', '1', '2018-05-30 19:34:00', null);
INSERT INTO `dm_link_user` VALUES ('6', '7', 'laodong1', '8675432', '1', '2018-05-31 10:09:22', null);
INSERT INTO `dm_link_user` VALUES ('7', '7', 'laodong888', '123111', '1', '2018-05-31 10:10:00', null);
INSERT INTO `dm_link_user` VALUES ('8', '7', 'laodong888', '3535346', '1', '2018-05-31 10:10:22', null);
INSERT INTO `dm_link_user` VALUES ('61', '9', '武侏', '320721197406230655', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('62', '10', '裘鲭', '130922199806125767', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('63', '11', '周成功', '15092219590411811X', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('64', '12', '利倔妯', '140400196609267128', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('65', '13', '时崔', '469005195902111155', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('66', '14', '时陷', '370112196910256024', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('67', '15', '时益', '530900197207019273', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('68', '16', '王槠', '341004195310242038', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('69', '17', '王鹧', '522629199210116053', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('70', '18', '王超', '542122197911036999', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('71', '9', '董钥耻', '120221195909131444', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('72', '10', '董聪聪', '542129196703027756', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('73', '11', '刘明', '130432196210064977', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('74', '12', '孙红来', '410803195909214214', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('75', '13', '甲兵', '350304199010163990', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('76', '14', '李亮', '210200200010184920', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('77', '15', '蒙蒙', '513222197009099363', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('78', '16', '农葫', '150524199102287287', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('79', '17', '农随', '421121198212243390', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('80', '18', '窦贝贝', '51013119520515412X', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('81', '9', '窦海亮', '410928196204224348', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('82', '10', '刘强', '220402198209308252', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('83', '11', '马士兵', '64000019860916524X', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('84', '12', '卞夏', '440303195706277360', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('85', '13', '吴勇', '654301198209142565', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('86', '14', '吴成', '230707195408165094', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('87', '15', '马亮', '360430199904017925', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('88', '16', '马云', '522634195304289695', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('89', '17', '陆左', '500235197404049814', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('90', '18', '陈国', '230833197409289125', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('91', '9', '张国立', '210104200204038630', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('92', '10', '楚芊', '62042319791205222X', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('93', '11', '楚阶', '230200195305127480', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('94', '12', '楚好', '622923195105188112', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('95', '13', '陈红', '230703196906301051', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('96', '14', '陈道明', '371702197912023852', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('97', '15', '成龙', '371402195104070911', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('98', '16', '李元嘉', '532822197802120012', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('99', '17', '孙媛媛', '621025200702134979', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('100', '18', '马大哈', '150923196712292122', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('101', '9', '孙大成', '610424196408073654', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('102', '10', '陈星', '620602199410096335', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('103', '11', '陈杰', '371322197501062471', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('104', '12', '王强', '513326198711100462', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('105', '13', '王艳', '150121196309247229', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('106', '14', '周鸨辨', '340700195112147584', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('107', '15', '苍帘', '320724198206051912', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('108', '16', '赵华', '11011719790324236X', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('109', '17', '苍萍', '532623198002032583', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('110', '18', '郑叶秋', '130107198211137927', '1', '2018-06-01 05:52:09', '2018-06-01 05:52:09');
INSERT INTO `dm_link_user` VALUES ('120', '3', '董海测试2', '388888888888888', '0', '2018-06-28 10:27:12', null);
INSERT INTO `dm_link_user` VALUES ('121', '3', '董海测试3', '388888888888881', '0', '2018-06-28 10:27:51', null);
INSERT INTO `dm_link_user` VALUES ('122', '3', '董海1', '111111111111111111', '0', '2018-06-28 10:29:13', null);
INSERT INTO `dm_link_user` VALUES ('123', '3', '董海测试4', '888888888888888', '0', '2018-07-02 03:34:05', null);
INSERT INTO `dm_link_user` VALUES ('124', '20', '董海常用购票人1', '6666666666666666', '0', '2018-07-02 05:54:29', null);
INSERT INTO `dm_link_user` VALUES ('126', '20', '董海常用购票人2', '1111111111111111111', '0', '2018-07-02 07:09:11', null);
INSERT INTO `dm_link_user` VALUES ('127', '20', null, '111111111111111', '0', '2018-07-02 07:09:44', null);
INSERT INTO `dm_link_user` VALUES ('129', '9', '', '123123123123', '0', '2018-07-09 03:15:24', null);
INSERT INTO `dm_link_user` VALUES ('130', '3', '测试', '1111111111111111', '0', '2018-07-10 08:46:29', null);
INSERT INTO `dm_link_user` VALUES ('131', '3', '数据侧', ' 1212121212121212', '0', '2018-07-10 08:48:39', null);
INSERT INTO `dm_link_user` VALUES ('132', '63', '董海测试1的常用购票人1', '11111111111111111111', '0', '2018-07-11 03:24:14', null);
INSERT INTO `dm_link_user` VALUES ('133', '63', '董海测试1的常用购票人2', '222222222222222222', '0', '2018-07-11 03:24:30', null);

-- ----------------------------
-- Table structure for dm_user
-- ----------------------------
DROP TABLE IF EXISTS `dm_user`;
CREATE TABLE `dm_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `wxUserId` varchar(100) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `nickName` varchar(255) DEFAULT NULL COMMENT '昵称',
  `sex` int(1) DEFAULT NULL COMMENT '性别(0:男,1:女)',
  `hobby` varchar(255) DEFAULT NULL COMMENT '兴趣爱好',
  `idCard` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `birthday` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '生日',
  `createdTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatedTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of dm_user
-- ----------------------------
INSERT INTO `dm_user` VALUES ('3', 'zhzbin@163.com', 'e10adc3949ba59abbe56e057f20f883e', null, '胖成球', '胖成球1132', '1', '测bugasdasdasdasdasd水电费水电费爽肤水3测试数据的asdasd', '8888888888888', '2018-10-09 06:27:44', '2018-05-24 11:30:49', '2018-10-09 06:27:44');
INSERT INTO `dm_user` VALUES ('4', 'test1235@test.com', 'e10adc3949ba59abbe56e057f20f883e', null, '11', '8888888888', '1', '字符串兴趣爱好1111', '888888888', '2018-10-09 06:29:05', '2018-05-24 11:30:49', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('5', 'test555@test.com', 'e10adc3949ba59abbe56e057f20f883e', null, '嘻嘻', '呵呵列', null, '字符串兴趣爱好', '5555555', '2018-10-09 06:29:05', '2018-05-31 08:15:33', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('6', 'test1@test.com', 'e10adc3949ba59abbe56e057f20f883e', null, '11', '8888888888', '1', '字符串兴趣爱好1111', '888888888', '2018-10-09 06:29:05', '2018-05-24 11:30:49', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('7', 'test12@test.com', 'e10adc3949ba59abbe56e057f20f883e', null, '11', '8888888888', '1', '字符串兴趣爱好1111', '888888888', '2018-10-09 06:29:05', '2018-05-24 11:30:49', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('8', 'test1234@test.com', 'e10adc3949ba59abbe56e057f20f883e', null, '11', '8888888888', null, '字符串兴趣爱好1111', '888888888', '2018-10-09 06:29:05', '2018-05-31 08:15:33', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('9', '772602194@qq.com', 'e10adc3949ba59abbe56e057f20f883e', null, '丰碧琴', '子爱', '2', '看书，打球，看小说\n看电影', '340102199003076236', '2018-10-09 06:29:05', '2018-05-24 11:30:49', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('10', '491675128@163.com', 'e10adc3949ba59abbe56e057f20f883e', null, '迟骞信', '友易', '0', '游泳，跑步', '350102199103131433', '2018-10-09 06:29:05', '2018-05-24 11:30:49', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('11', '538015624@126.com', 'e10adc3949ba59abbe56e057f20f883e', null, '谏鸿禧', '方方', '0', '旅游，散步', '210102191007072616', '2018-10-09 06:29:05', '2018-05-31 08:15:33', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('12', '151902456@qq.com', 'e10adc3949ba59abbe56e057f20f883e', null, '窦彤云', '开朗', '1', '打篮球，打扑克，下象棋', '11010120100807189X', '2018-10-09 06:29:05', '2018-05-24 11:30:49', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('13', '893297013@qq.com', 'e10adc3949ba59abbe56e057f20f883e', null, '肇琰琬', '安静', '1', '游泳，健身，散步，购物', '320102199308189174', '2018-10-09 06:29:05', '2018-05-24 11:30:49', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('14', 'wullove_12@126.com', 'e10adc3949ba59abbe56e057f20f883e', null, '贾思枫', '旺旺', '0', '跑酷，玩电脑游戏，看小说，看电影', '410102199506200516', '2018-10-09 06:29:05', '2018-05-31 08:15:33', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('15', '320538281@qq.com', 'e10adc3949ba59abbe56e057f20f883e', null, '由樱花', '游客', '1', '看小说，看电影，散步', '330102199110072239', '2018-10-09 06:29:05', '2018-05-31 08:15:33', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('16', '236392829@qq.com', 'e10adc3949ba59abbe56e057f20f883e', null, '乌海蓝', '随风', '0', '看书，学习，直播', '230102199409044570', '2018-10-09 06:29:05', '2018-05-24 11:30:49', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('17', '164319313@qq.com', 'e10adc3949ba59abbe56e057f20f883e', null, '赵恨瑶', '流年', '1', '学习，游玩，散步，购物', '360102199609126393', '2018-10-09 06:29:05', '2018-05-24 11:30:49', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('18', 'cj88sdj@163.com', 'e10adc3949ba59abbe56e057f20f883e', null, '黄芳洁1', '同桌的你', '1', '运动，洗衣服', '310101199010184591', '2018-10-09 06:29:05', '2018-05-31 08:15:33', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('19', 'zhzbin12@163.com', 'e10adc3949ba59abbe56e057f20f883e', null, 'Test', '胖成球', '0', '运动，洗衣服', '310101199010184591', '2018-10-09 06:29:05', '2018-05-31 08:15:33', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('20', 'sdodh366@163.com', 'e10adc3949ba59abbe56e057f20f883e', null, '董海', '董海测试1', '1', '董海的爱好1', '888888888888888', '2018-10-09 06:29:05', '2018-07-02 03:22:03', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('62', 'test@163.com', 'e10adc3949ba59abbe56e057f20f883e', 'oPxiwwqVIwYqkoRKmHeoDM3cDato', null, '好心人', '1', '董海的爱好1', null, '2018-10-09 06:29:05', '2018-07-03 17:09:11', '2018-10-09 06:29:05');
INSERT INTO `dm_user` VALUES ('63', 'sdodj366@163.com', 'e10adc3949ba59abbe56e057f20f883e', null, '董海', '董海测试1', '1', '谢谢小星星', '111111111111111111', '2018-10-09 06:29:05', '2018-07-11 03:11:42', '2018-10-09 06:29:05');
