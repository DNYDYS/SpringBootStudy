/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 01/11/2021 23:20:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oc_current_day_revenue
-- ----------------------------
DROP TABLE IF EXISTS `oc_current_day_revenue`;
CREATE TABLE `oc_current_day_revenue`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` float(10, 3) NULL DEFAULT NULL,
  `polylineId` int(11) NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL COMMENT '当日支出',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `IDX_POLYLINE_CONN`(`polylineId`) USING BTREE,
  CONSTRAINT `IDX_POLYLINE_CONN` FOREIGN KEY (`polylineId`) REFERENCES `oc_polylinedata` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oc_current_day_revenue
-- ----------------------------
INSERT INTO `oc_current_day_revenue` VALUES (33, 123.000, 14, '2021-08-31');
INSERT INTO `oc_current_day_revenue` VALUES (34, 200.000, 14, '2021-08-30');
INSERT INTO `oc_current_day_revenue` VALUES (35, 100.000, 14, '2021-08-29');
INSERT INTO `oc_current_day_revenue` VALUES (36, 300.000, 15, '2021-08-31');
INSERT INTO `oc_current_day_revenue` VALUES (37, 324.000, 15, '2021-08-30');
INSERT INTO `oc_current_day_revenue` VALUES (38, 234.000, 15, '2021-08-29');
INSERT INTO `oc_current_day_revenue` VALUES (39, 400.000, 16, '2021-08-31');
INSERT INTO `oc_current_day_revenue` VALUES (40, 500.000, 16, '2021-08-30');
INSERT INTO `oc_current_day_revenue` VALUES (41, 300.000, 16, '2021-08-29');
INSERT INTO `oc_current_day_revenue` VALUES (42, 400.000, 17, '2021-08-31');
INSERT INTO `oc_current_day_revenue` VALUES (43, 500.000, 17, '2021-08-30');
INSERT INTO `oc_current_day_revenue` VALUES (44, 199.000, 17, '2021-08-29');
INSERT INTO `oc_current_day_revenue` VALUES (45, 0.000, 18, '2021-08-31');
INSERT INTO `oc_current_day_revenue` VALUES (46, 999.000, 18, '2021-08-30');
INSERT INTO `oc_current_day_revenue` VALUES (47, 0.000, 18, '2021-08-29');
INSERT INTO `oc_current_day_revenue` VALUES (48, 999.000, 19, '2021-08-31');
INSERT INTO `oc_current_day_revenue` VALUES (49, 0.000, 19, '2021-08-30');
INSERT INTO `oc_current_day_revenue` VALUES (50, 0.000, 19, '2021-08-29');
INSERT INTO `oc_current_day_revenue` VALUES (51, 1888.000, 14, '2021-10-30');
INSERT INTO `oc_current_day_revenue` VALUES (52, 0.000, 15, '2021-10-30');
INSERT INTO `oc_current_day_revenue` VALUES (53, 0.000, 16, '2021-10-30');
INSERT INTO `oc_current_day_revenue` VALUES (54, 0.000, 17, '2021-10-30');
INSERT INTO `oc_current_day_revenue` VALUES (55, 0.000, 18, '2021-10-30');
INSERT INTO `oc_current_day_revenue` VALUES (56, 999.000, 19, '2021-10-30');
INSERT INTO `oc_current_day_revenue` VALUES (59, 888.000, 14, '2021-10-31');
INSERT INTO `oc_current_day_revenue` VALUES (60, 0.000, 15, '2021-10-31');
INSERT INTO `oc_current_day_revenue` VALUES (61, 0.000, 16, '2021-10-31');
INSERT INTO `oc_current_day_revenue` VALUES (62, 0.000, 17, '2021-10-31');
INSERT INTO `oc_current_day_revenue` VALUES (63, 0.000, 18, '2021-10-31');
INSERT INTO `oc_current_day_revenue` VALUES (64, 0.000, 19, '2021-10-31');

-- ----------------------------
-- Table structure for oc_polylinedata
-- ----------------------------
DROP TABLE IF EXISTS `oc_polylinedata`;
CREATE TABLE `oc_polylinedata`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `polylineName` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '折线名称',
  `polylineType` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '折线类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oc_polylinedata
-- ----------------------------
INSERT INTO `oc_polylinedata` VALUES (14, '米西安', 'line');
INSERT INTO `oc_polylinedata` VALUES (15, '肉价莫', 'line');
INSERT INTO `oc_polylinedata` VALUES (16, '酸辣分', 'bar');
INSERT INTO `oc_polylinedata` VALUES (17, '凉皮', 'scatter');
INSERT INTO `oc_polylinedata` VALUES (18, '雷子', 'line');
INSERT INTO `oc_polylinedata` VALUES (19, '123123', 'bar');

-- ----------------------------
-- Table structure for oc_users
-- ----------------------------
DROP TABLE IF EXISTS `oc_users`;
CREATE TABLE `oc_users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oc_users
-- ----------------------------
INSERT INTO `oc_users` VALUES (1, 'admin', 'admin2003');

SET FOREIGN_KEY_CHECKS = 1;
