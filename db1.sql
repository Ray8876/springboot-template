/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : db1

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 01/06/2020 16:54:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cloth
-- ----------------------------
DROP TABLE IF EXISTS `cloth`;
CREATE TABLE `cloth` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `cloth_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '布匹名称',
  `cloth_weight` int DEFAULT NULL COMMENT '布匹重量',
  `cloth_length` int DEFAULT NULL COMMENT '布匹长度（米）',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='布匹商品表';

-- ----------------------------
-- Records of cloth
-- ----------------------------
BEGIN;
INSERT INTO `cloth` VALUES (1, '黄布', 123, 112, 100.00);
INSERT INTO `cloth` VALUES (2, '紫布', NULL, 1500, 110.00);
INSERT INTO `cloth` VALUES (3, '蓝布', NULL, 2000, 120.00);
INSERT INTO `cloth` VALUES (4, '白布', NULL, 1600, 180.00);
COMMIT;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `customer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '客户名',
  `customer_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '客户地址',
  `customer_moblie` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '客户电话',
  `customer_message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '客户留言',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客户表';

-- ----------------------------
-- Records of customer
-- ----------------------------
BEGIN;
INSERT INTO `customer` VALUES (1, '甲公司', '上海', '123456789', '非常好');
INSERT INTO `customer` VALUES (2, '乙公司', '北京', '987654321', '一笔吊遭');
INSERT INTO `customer` VALUES (3, '丙公司', '杭州', '456123789', '什么');
INSERT INTO `customer` VALUES (4, '丁公司', '苏州', '321987654', '就这？');
INSERT INTO `customer` VALUES (5, '啦啦啦', '45', '123', '12');
INSERT INTO `customer` VALUES (6, '12', '', '', '');
INSERT INTO `customer` VALUES (8, '12', '', '', '');
INSERT INTO `customer` VALUES (9, '', '', '', '');
INSERT INTO `customer` VALUES (10, '1111', '', '', '');
INSERT INTO `customer` VALUES (11, '12', '', '', '');
INSERT INTO `customer` VALUES (12, '', '', '', '');
INSERT INTO `customer` VALUES (13, '123', '123', '123', '123');
COMMIT;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `supplier_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '进货商名',
  `supplier_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '进货商地址',
  `supplier_moblie` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '进货商电话',
  `supplier_message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='进货商表';

-- ----------------------------
-- Records of supplier
-- ----------------------------
BEGIN;
INSERT INTO `supplier` VALUES (13, '123', '099999', '124', '24311');
COMMIT;

-- ----------------------------
-- Table structure for transactions
-- ----------------------------
DROP TABLE IF EXISTS `transactions`;
CREATE TABLE `transactions` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `customer_id` int DEFAULT NULL COMMENT '客户id',
  `cloth_id` int DEFAULT NULL COMMENT '布匹id',
  `length` int DEFAULT NULL COMMENT '交易长度（米）',
  `state` int DEFAULT NULL COMMENT '交易状态 -1为出库 1位入库',
  `total_price` decimal(10,2) DEFAULT NULL COMMENT '交易价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='出库入库表';

-- ----------------------------
-- Records of transactions
-- ----------------------------
BEGIN;
INSERT INTO `transactions` VALUES (1, 2, 3, 500, -1, 60000.00);
INSERT INTO `transactions` VALUES (2, 2, 3, 120, 1, 14400.00);
INSERT INTO `transactions` VALUES (4, 1, 1, 5, -1, 500.00);
INSERT INTO `transactions` VALUES (5, 5, 1, 54, 1, 5400.00);
INSERT INTO `transactions` VALUES (6, 3, 2, 45645, -1, 5020950.00);
INSERT INTO `transactions` VALUES (7, 4, 1, 564, 1, 56400.00);
INSERT INTO `transactions` VALUES (8, 3, 1, 888, -1, 88800.00);
INSERT INTO `transactions` VALUES (9, 2, 1, 888, -1, 88800.00);
INSERT INTO `transactions` VALUES (10, 1, 1, 888, -1, 88800.00);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码',
  `gender` int DEFAULT '0' COMMENT '性别 0为男 1为女',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'root', '123456', 0);
INSERT INTO `user` VALUES (2, 'asdf', '123', 0);
INSERT INTO `user` VALUES (3, 'qwer123', '12345', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
