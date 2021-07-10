/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.100.1-mysql
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : cinema

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 10/07/2021 14:30:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int NOT NULL,
  `admin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123');

-- ----------------------------
-- Table structure for film
-- ----------------------------
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film`  (
  `Fid` int NOT NULL AUTO_INCREMENT,
  `Fname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Ftype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Fregion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Fduration` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Fdate` date NULL DEFAULT NULL,
  `Fprice` double(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`Fid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11121 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of film
-- ----------------------------
INSERT INTO `film` VALUES (11101, '金刚川', '战争', '中国大陆', '135分钟', '2021-07-01', 60.00);
INSERT INTO `film` VALUES (11102, '战狼2', '军事', '中国大陆', '145分钟', '2021-06-01', 50.00);
INSERT INTO `film` VALUES (11103, '美国队长', '科幻', '美国', '120分钟', '2021-07-02', 30.00);
INSERT INTO `film` VALUES (11104, '芳华', '爱情', '中国大陆', '130分钟', '2021-07-01', 50.00);
INSERT INTO `film` VALUES (11105, '《1921》', '战争', '中国大陆', '100分钟', '2021-07-01', 50.00);
INSERT INTO `film` VALUES (11107, '速度与激情7', '科幻', '美国', '170分钟', '2020-04-20', 60.00);
INSERT INTO `film` VALUES (11110, '战狼', '军事', '中国大陆', '120分钟', '2021-06-10', 80.00);
INSERT INTO `film` VALUES (11111, '我不是药神', '故事', '中国大陆', '110分钟', '2021-06-02', 40.00);
INSERT INTO `film` VALUES (11112, '杀破狼', '武打', '中国香港', '110分钟', '2021-05-19', 40.00);
INSERT INTO `film` VALUES (11113, '我爱中华', '爱国', '中国台湾', '200分钟', '2021-08-01', 50.00);
INSERT INTO `film` VALUES (11114, '爱我中华', '爱国', '中国台湾', '180分钟', '2021-08-02', 50.00);
INSERT INTO `film` VALUES (11115, '我和我的祖国', '爱国', '中国大陆', '170分钟', '2021-07-09', 40.00);
INSERT INTO `film` VALUES (11116, '我的祖国母亲', '爱国', '中国台湾', '220分钟', '2021-09-01', 40.00);
INSERT INTO `film` VALUES (11117, '无间道', '武打', '中国台湾', '120分钟', '2021-05-05', 70.00);
INSERT INTO `film` VALUES (11118, '澳门风云', '赌博', '中国澳门', '110分钟', '2021-03-01', 60.00);
INSERT INTO `film` VALUES (11119, '你好，李焕英', '煽情', '中国大陆', '110分钟', '2019-01-07', 30.00);
INSERT INTO `film` VALUES (11120, '建军大业', '战争', '中国大陆', '110分钟', '2021-07-07', 40.00);
INSERT INTO `film` VALUES (11121, '中国医生', '剧情', '中国大陆', '150分钟', '2021-08-01', 40.00);
INSERT INTO `film` VALUES (11122, '《1937》', '战争', '中国大陆', '150分钟', '2021-07-10', 30.00);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `schedul_id` int NULL DEFAULT NULL,
  `buying_time` datetime NULL DEFAULT NULL COMMENT '购买时间',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `schedul_id`(`schedul_id`) USING BTREE,
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`Uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`schedul_id`) REFERENCES `schedule` (`sid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10011 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (10005, 5004, 6004, '2021-07-02 19:46:01');
INSERT INTO `order` VALUES (10007, 5008, 6001, '2021-07-05 17:13:01');
INSERT INTO `order` VALUES (10010, 5010, 6004, '2021-07-10 09:05:36');
INSERT INTO `order` VALUES (10011, 5011, 6013, '2021-07-10 11:21:30');
INSERT INTO `order` VALUES (10012, 5012, 6011, '2021-07-10 13:21:00');
INSERT INTO `order` VALUES (10013, 5001, 6006, '2021-07-10 13:21:20');

-- ----------------------------
-- Table structure for return_order
-- ----------------------------
DROP TABLE IF EXISTS `return_order`;
CREATE TABLE `return_order`  (
  `r_order_id` int NOT NULL,
  `user_id` int NULL DEFAULT NULL,
  `schedul_id` int NULL DEFAULT NULL,
  `r_order_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`r_order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `schedul_id`(`schedul_id`) USING BTREE,
  CONSTRAINT `return_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`Uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `return_order_ibfk_2` FOREIGN KEY (`schedul_id`) REFERENCES `schedule` (`sid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of return_order
-- ----------------------------
INSERT INTO `return_order` VALUES (10001, 5001, 6001, '2021-07-05 16:18:59');
INSERT INTO `return_order` VALUES (10002, 5002, 6001, '2021-07-10 13:13:27');
INSERT INTO `return_order` VALUES (10004, 5002, 6003, '2021-07-10 13:20:33');
INSERT INTO `return_order` VALUES (10008, 5008, 6001, '2021-07-10 13:12:12');
INSERT INTO `return_order` VALUES (10009, 5008, 6001, '2021-07-05 17:25:30');

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule`  (
  `sid` int NOT NULL AUTO_INCREMENT COMMENT '场次号',
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '影厅名',
  `fid` int NULL DEFAULT NULL COMMENT '电影id',
  `stime` datetime NULL DEFAULT NULL COMMENT '电影播放时间',
  `sstock` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '该场次电影余票',
  PRIMARY KEY (`sid`) USING BTREE,
  INDEX `fid`(`fid`) USING BTREE,
  CONSTRAINT `fid` FOREIGN KEY (`fid`) REFERENCES `film` (`Fid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6009 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES (6001, 'IMAX3D-5号厅', 11101, '2021-07-04 15:36:00', '47');
INSERT INTO `schedule` VALUES (6002, '2D-3号厅', 11102, '2021-07-23 18:39:00', '30');
INSERT INTO `schedule` VALUES (6003, 'IMAX4D-6号厅', 11103, '2021-07-04 18:56:00', '50');
INSERT INTO `schedule` VALUES (6004, '杜比声音效巨幕2号厅', 11105, '2021-07-02 19:44:00', '59');
INSERT INTO `schedule` VALUES (6006, 'IMAX3D-1号厅', 11107, '2021-07-05 16:54:05', '59');
INSERT INTO `schedule` VALUES (6011, '图书馆2号报告厅', 11120, '2021-07-22 10:35:23', '149');
INSERT INTO `schedule` VALUES (6012, '图书馆1号报告厅', 11115, '2021-07-10 10:35:49', '150');
INSERT INTO `schedule` VALUES (6013, '图书馆1号报告厅', 11121, '2021-09-01 11:20:27', '299');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `Uid` int NOT NULL AUTO_INCREMENT,
  `Uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Uphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5011 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (5001, '华晨宇', '18888888888');
INSERT INTO `user` VALUES (5002, '李易峰', '15555555555');
INSERT INTO `user` VALUES (5003, '吴亦凡', '16666666666');
INSERT INTO `user` VALUES (5004, '易烊千玺', '17777777777');
INSERT INTO `user` VALUES (5005, '刘德华', '11111111111');
INSERT INTO `user` VALUES (5006, '吴奇隆', '17655524577');
INSERT INTO `user` VALUES (5008, '张三', '17633505913');
INSERT INTO `user` VALUES (5010, '花花', '12222222222');
INSERT INTO `user` VALUES (5011, '太阳', '13333333333');
INSERT INTO `user` VALUES (5012, '杨幂', '14444444444');

-- ----------------------------
-- View structure for order_infor
-- ----------------------------
DROP VIEW IF EXISTS `order_infor`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `order_infor` AS select `order`.`order_id` AS `oid`,`user`.`Uname` AS `uname`,`film`.`Fname` AS `fname`,`schedule`.`sname` AS `sname`,`schedule`.`stime` AS `stime`,`order`.`buying_time` AS `btime` from (((`user` join `order`) join `schedule`) join `film`) where ((`schedule`.`fid` = `film`.`Fid`) and (`order`.`user_id` = `user`.`Uid`) and (`order`.`schedul_id` = `schedule`.`sid`));

-- ----------------------------
-- View structure for retrunprice
-- ----------------------------
DROP VIEW IF EXISTS `retrunprice`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `retrunprice` AS select `order`.`order_id` AS `oid`,`user`.`Uname` AS `uname`,`film`.`Fname` AS `fname`,`schedule`.`sname` AS `sname`,`order`.`buying_time` AS `btime`,`film`.`Fprice` AS `retrun_price` from (((`user` join `order`) join `schedule`) join `film`) where ((`schedule`.`fid` = `film`.`Fid`) and (`order`.`user_id` = `user`.`Uid`) and (`order`.`schedul_id` = `schedule`.`sid`));

-- ----------------------------
-- View structure for return_order_infor
-- ----------------------------
DROP VIEW IF EXISTS `return_order_infor`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `return_order_infor` AS select `return_order`.`r_order_id` AS `oid`,`user`.`Uname` AS `uname`,`film`.`Fname` AS `fname`,`schedule`.`sname` AS `sname`,`schedule`.`stime` AS `stime`,`return_order`.`r_order_time` AS `wtime` from (((`user` join `return_order`) join `schedule`) join `film`) where ((`schedule`.`fid` = `film`.`Fid`) and (`return_order`.`user_id` = `user`.`Uid`) and (`return_order`.`schedul_id` = `schedule`.`sid`));

-- ----------------------------
-- View structure for schedul_infor
-- ----------------------------
DROP VIEW IF EXISTS `schedul_infor`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `schedul_infor` AS select `schedule`.`sid` AS `sid`,`schedule`.`sname` AS `sname`,`film`.`Fname` AS `Fname`,`film`.`Ftype` AS `Ftype`,`film`.`Fduration` AS `Fduration`,`schedule`.`stime` AS `stime`,`schedule`.`sstock` AS `sstock` from (`schedule` join `film`) where (`schedule`.`fid` = `film`.`Fid`);

SET FOREIGN_KEY_CHECKS = 1;
