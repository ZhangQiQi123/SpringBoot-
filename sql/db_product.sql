/*
Navicat MySQL Data Transfer

Source Server         : springboot微服务
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : db_product

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2019-03-21 22:42:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(200) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('3', 'JAVA??????', '??', '100', '2019-03-20 15:58:39');
INSERT INTO `products` VALUES ('4', 'C#从入门到精通', '书籍', '100', '2019-03-20 16:00:45');
INSERT INTO `products` VALUES ('6', 'html css', '书籍', '1000', '2019-03-20 18:10:06');
INSERT INTO `products` VALUES ('7', '华为Mate10', '手机', '100', '2019-03-20 17:52:10');
INSERT INTO `products` VALUES ('8', 'ExtJS', '书籍', '1000', '2019-03-20 21:09:19');

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) NOT NULL,
  `product_price` double NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_product
-- ----------------------------
INSERT INTO `tb_product` VALUES ('1', 'JAVA从入门到精通', '79', '2019-03-11 16:50:56');
INSERT INTO `tb_product` VALUES ('6', 'C#', '99', '2019-03-11 17:39:40');
INSERT INTO `tb_product` VALUES ('8', 'C语言', '100', '2019-03-11 15:27:18');
INSERT INTO `tb_product` VALUES ('9', '大米手机', '5000', '2019-03-11 14:23:44');
INSERT INTO `tb_product` VALUES ('10', '小米手机', '5000', '2019-03-11 16:50:30');
