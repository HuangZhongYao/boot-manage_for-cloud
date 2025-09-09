/*
 Navicat Premium Dump SQL

 Source Server         : Localhost-MySQL
 Source Server Type    : MySQL
 Source Server Version : 80043 (8.0.43)
 Source Host           : localhost:3306
 Source Schema         : bm

 Target Server Type    : MySQL
 Target Server Version : 80043 (8.0.43)
 File Encoding         : 65001

 Date: 09/09/2025 18:05:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_template
-- ----------------------------
DROP TABLE IF EXISTS `base_template`;
CREATE TABLE `base_template`  (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                                  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                  `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                                  `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '创建表基础模板' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of base_template
-- ----------------------------

-- ----------------------------
-- Table structure for bus_order
-- ----------------------------
DROP TABLE IF EXISTS `bus_order`;
CREATE TABLE `bus_order`  (
                              `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                              `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                              `updated_time` date NULL DEFAULT NULL COMMENT '更新时间',
                              `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                              `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
                              `order_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单号',
                              `commodity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品',
                              `order_time` datetime NULL DEFAULT NULL COMMENT '下单时间',
                              `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收货地址',
                              `consignee` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收货人',
                              `consignee_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收货人电话',
                              `pay_state` tinyint NULL DEFAULT NULL COMMENT '支付状态',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商城订单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bus_order
-- ----------------------------
INSERT INTO `bus_order` VALUES (6, '2024-07-28 12:00:12', '2024-07-28', NULL, NULL, '66666666666666663453477777777777777777777777777777777777', '笔记本电脑', '2024-08-01 11:56:06', '成都市', '成关系', '19985623214', 2);
INSERT INTO `bus_order` VALUES (7, '2024-07-28 12:10:15', '2024-07-28', NULL, NULL, '852363455555555555555555555555553477777777777777777777777', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (9, '2024-07-28 12:42:17', '2024-07-28', NULL, NULL, '8523622222222222', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (12, '2024-07-28 12:42:18', '2024-07-28', NULL, '1', '85236', '苹果000000000', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 1);
INSERT INTO `bus_order` VALUES (14, '2024-07-28 12:42:18', '2024-07-28', NULL, '1', '85236', '苹果7888', '2024-04-02 11:56:06', '北京朝阳区', 'liYao', '111111111111', 1);
INSERT INTO `bus_order` VALUES (15, '2024-07-28 12:42:18', '2024-07-28', NULL, '1', '888888888888888888', '苹果888888888888', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 1);
INSERT INTO `bus_order` VALUES (17, '2024-07-28 12:42:18', '2024-07-28', NULL, '1', '5455555555555', '苹果6666666666', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 1);
INSERT INTO `bus_order` VALUES (18, '2024-07-28 12:42:19', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (19, '2024-07-28 12:42:19', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (21, '2024-07-28 12:42:19', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (22, '2024-07-28 12:42:19', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (23, '2024-07-28 12:42:19', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (24, '2024-07-28 12:42:20', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (25, '2024-07-28 12:42:20', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (26, '2024-07-28 12:42:20', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (27, '2024-07-28 12:42:20', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (28, '2024-07-28 12:42:20', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (29, '2024-07-28 12:42:20', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (32, '2024-07-28 12:42:21', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (33, '2024-07-28 12:42:21', '2024-07-31', NULL, '22', '陈冠希', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 12);
INSERT INTO `bus_order` VALUES (34, '2024-07-28 12:42:21', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (35, '2024-07-28 12:42:21', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (36, '2024-07-28 12:42:22', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (37, '2024-07-28 12:42:22', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (38, '2024-07-28 12:42:22', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (39, '2024-07-28 12:42:22', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (40, '2024-07-28 12:42:22', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (41, '2024-07-28 12:42:22', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (42, '2024-07-28 12:42:22', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (43, '2024-07-28 12:42:23', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (44, '2024-07-28 12:42:23', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (45, '2024-07-28 12:42:23', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (46, '2024-07-28 12:42:23', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (47, '2024-07-28 12:42:23', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (48, '2024-07-28 12:42:23', '2024-07-28', NULL, NULL, '85236', '苹果', '2024-04-02 11:56:06', '北京', 'liYao', '111111111111', 0);
INSERT INTO `bus_order` VALUES (49, '2024-07-28 18:16:06', '2024-07-31', '1', '1', '2222222222', 'sdf3333333333', '2024-08-01 11:56:06', '534', 'dsfsd', 'sdf', 5);
INSERT INTO `bus_order` VALUES (51, '2024-07-28 18:37:43', '2024-07-28', '1', '1', '22222', '牛肉', '2024-04-02 11:56:06', '4545', '34534', '545', 23);
INSERT INTO `bus_order` VALUES (53, '2024-07-28 20:03:37', '2024-07-28', '1', '1', 'YR455454', '羊肉', '2024-04-02 11:56:06', '重庆市', '78', '878', 2);
INSERT INTO `bus_order` VALUES (54, '2024-07-28 22:12:45', '2024-07-28', '1', '1', 'GR36984554545', '狗肉', '2024-08-01 11:56:06', '云岩区', '王小李', '148563201545', 2);
INSERT INTO `bus_order` VALUES (55, '2024-07-31 00:45:52', '2024-07-31', '1', '1', 'UUUU89999', 'yuuu', '2024-04-02 11:56:06', '天机市', '黄中国农村', '34534534', 2);

-- ----------------------------
-- Table structure for bus_truck
-- ----------------------------
DROP TABLE IF EXISTS `bus_truck`;
CREATE TABLE `bus_truck`  (
                              `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                              `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                              `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                              `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                              `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
                              `plate_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '车牌号',
                              `model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '型号',
                              `vin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'VIN车辆识别代码',
                              `reg_date` datetime NULL DEFAULT NULL COMMENT '注册日期',
                              `issuers` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发证机关',
                              `owner` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '车辆所有人',
                              `brand` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '品牌',
                              `quality` int NULL DEFAULT NULL COMMENT '总质量kg',
                              `file_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文档编号',
                              `engine_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发动机编号',
                              `vehicle_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '车型',
                              `use_character` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '使用性质',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '车辆表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bus_truck
-- ----------------------------

-- ----------------------------
-- Table structure for dev_datasource
-- ----------------------------
DROP TABLE IF EXISTS `dev_datasource`;
CREATE TABLE `dev_datasource`  (
                                   `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                                   `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                   `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                   `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                                   `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
                                   `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据源名称',
                                   `url` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'jdbc url',
                                   `type` tinyint NULL DEFAULT NULL COMMENT '数据源类型',
                                   `driver_class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据库驱动类名',
                                   `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据库用户名',
                                   `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据库连接密码',
                                   `enable` tinyint NULL DEFAULT NULL COMMENT '是否启用',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1959157384936947713 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '数据源表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dev_datasource
-- ----------------------------
INSERT INTO `dev_datasource` VALUES (1959103277882671103, '2025-08-23 11:17:54', '2025-08-23 11:17:56', '1', '1', 'local', 'jdbc:mysql://127.0.0.1:3306/bm?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai', 1, 'com.mysql.cj.jdbc.Driver', 'root', 'root', 0);
INSERT INTO `dev_datasource` VALUES (1959103277882671104, '2025-08-23 11:59:54', '2025-08-23 11:59:54', '1', '1', 'test', NULL, 1, 'com.mysql.cj.jdbc.Driver', 'root', '123456', 1);
INSERT INTO `dev_datasource` VALUES (1959157384936947712, '2025-08-23 15:34:55', '2025-08-23 15:34:55', '1', '1', 'devPG数据源', NULL, 4, 'com.mysql.cj.jdbc.Driver', 'admin', 'admin', 1);

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                                  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                  `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                                  `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
                                  `dict_type_id` bigint NULL DEFAULT NULL COMMENT '字典数据类型id',
                                  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
                                  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码',
                                  `sort` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '排序值',
                                  `enable` tinyint NULL DEFAULT NULL COMMENT '启用状态',
                                  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1963512333384810497 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统字典数据表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (16, '2024-08-18 04:50:08', '2024-09-01 13:18:37', '1', '1', 8, '纯电', 'EV', '9', 1, '纯电消耗');
INSERT INTO `sys_dict_data` VALUES (17, '2024-08-18 04:50:08', '2025-08-23 16:51:39', '1', '1', 8, '汽油', 'OIL', '9', 1, '燃油');
INSERT INTO `sys_dict_data` VALUES (18, '2024-08-18 04:50:08', '2024-09-01 13:22:17', '1', '1', 8, '混动', 'PHEV', '9', 1, '混合');
INSERT INTO `sys_dict_data` VALUES (19, '2024-08-18 04:50:08', '2024-09-01 13:22:54', '1', '1', 8, '柴油', 'DIESEL', '9', 1, '');
INSERT INTO `sys_dict_data` VALUES (20, '2024-08-18 04:50:08', '2024-09-01 13:23:21', '1', '1', 8, '氢能源', 'HYDROGEN_ENERGY', '9', 1, '氢能源');
INSERT INTO `sys_dict_data` VALUES (21, '2024-09-01 12:13:45', '2024-09-01 12:45:46', '1', '1', 5, '彝', 'YIZU', '0', 1, '彝族');
INSERT INTO `sys_dict_data` VALUES (22, '2024-09-01 12:21:58', '2024-09-01 12:42:21', '1', '1', 5, '汉', 'HAN', '0', 1, '汉族');
INSERT INTO `sys_dict_data` VALUES (23, '2024-09-01 12:22:34', '2024-09-01 12:35:38', '1', '1', 5, '瑶族', 'YAOZU', '0', 1, '瑶族');
INSERT INTO `sys_dict_data` VALUES (25, '2024-09-18 14:19:55', '2024-09-18 14:19:55', '1', '1', 9, '红', 'PLATE_NO_COLOR_RED', '0', 1, NULL);
INSERT INTO `sys_dict_data` VALUES (1959146542208122880, '2025-08-23 14:51:50', '2025-08-23 14:51:50', '1', '1', 1959146355125387264, 'MySQL', 'MYSQL', '0', 1, NULL);
INSERT INTO `sys_dict_data` VALUES (1959146601981149184, '2025-08-23 14:52:04', '2025-08-23 15:28:31', '1', '1', 1959146355125387264, 'Oracle', 'ORACLE', '0', 0, NULL);
INSERT INTO `sys_dict_data` VALUES (1959146664753102848, '2025-08-23 14:52:19', '2025-08-23 14:52:19', '1', '1', 1959146355125387264, 'PostgreSQL', 'POSTGRESQL', '0', 1, NULL);
INSERT INTO `sys_dict_data` VALUES (1959146752271450112, '2025-08-23 14:52:40', '2025-08-23 14:52:40', '1', '1', 1959146355125387264, 'SQLServer', 'SQLSERVER', '0', 1, NULL);
INSERT INTO `sys_dict_data` VALUES (1959175841699069952, '2025-08-23 16:48:15', '2025-08-23 16:48:15', '1', '1', 1959175732345176064, 'MySQL', 'MYSQL', '0', 1, NULL);
INSERT INTO `sys_dict_data` VALUES (1959175886792032256, '2025-08-23 16:48:26', '2025-08-23 16:49:19', '1', '1', 1959175732345176064, 'Oracle', 'ORACLE', '0', 0, NULL);
INSERT INTO `sys_dict_data` VALUES (1959175931775942656, '2025-08-23 16:48:37', '2025-08-23 16:48:37', '1', '1', 1959175732345176064, 'SQLServer', 'SQLSERVER', '0', 1, NULL);
INSERT INTO `sys_dict_data` VALUES (1959176008997273600, '2025-08-23 16:48:55', '2025-08-23 16:48:55', '1', '1', 1959175732345176064, 'PostgreSQL', 'POSTGRESQL', '0', 1, NULL);
INSERT INTO `sys_dict_data` VALUES (1961491049293545472, '2025-08-30 02:08:04', '2025-08-30 02:08:04', '1', '1', 1961490437826936832, '草稿', '1', '0', 1, NULL);
INSERT INTO `sys_dict_data` VALUES (1961491157020049408, '2025-08-30 02:08:29', '2025-08-30 02:08:29', '1', '1', 1961490437826936832, '已发布', '2', '0', 1, NULL);
INSERT INTO `sys_dict_data` VALUES (1961491185943969792, '2025-08-30 02:08:36', '2025-08-30 02:08:36', '1', '1', 1961490437826936832, '已撤回', '3', '0', 1, NULL);
INSERT INTO `sys_dict_data` VALUES (1963512054480371712, '2025-09-04 15:58:49', '2025-09-04 15:58:49', '1', '1', 1963511727697952768, '系统通知', 'SYSTEM', '0', 1, NULL);
INSERT INTO `sys_dict_data` VALUES (1963512239579201536, '2025-09-04 15:59:33', '2025-09-04 15:59:33', '1', '1', 1963511847990591488, '低', 'ORDINARY', '0', 1, NULL);
INSERT INTO `sys_dict_data` VALUES (1963512281945866240, '2025-09-04 15:59:43', '2025-09-04 15:59:43', '1', '1', 1963511847990591488, '中', 'WARNING', '0', 1, NULL);
INSERT INTO `sys_dict_data` VALUES (1963512333384810496, '2025-09-04 15:59:55', '2025-09-04 15:59:55', '1', '1', 1963511847990591488, '高', 'HIGH', '0', 1, NULL);

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                                  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                  `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                                  `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
                                  `parent_id` bigint NULL DEFAULT NULL COMMENT '上级',
                                  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
                                  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码',
                                  `sort` int NULL DEFAULT NULL COMMENT '排序值',
                                  `enable` tinyint NULL DEFAULT NULL COMMENT '启用状态',
                                  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1963511847990591489 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统字典类型表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '2024-08-18 05:52:15', '2024-08-18 05:52:15', '1', '1', NULL, '系统管理', NULL, 0, 1, '系统相关相关参数');
INSERT INTO `sys_dict_type` VALUES (2, '2024-08-18 05:54:24', '2024-08-18 05:55:46', '1', '1', 1, '系统配置', NULL, 0, 1, '系统配置相关参数');
INSERT INTO `sys_dict_type` VALUES (5, '2024-08-18 11:46:35', '2024-08-18 11:46:35', '1', '1', 1, '民族', NULL, 1, 1, '');
INSERT INTO `sys_dict_type` VALUES (6, '2024-08-18 11:58:23', '2024-08-18 11:58:23', '1', '1', NULL, '车辆管理', NULL, 1, 1, '演示demo数据');
INSERT INTO `sys_dict_type` VALUES (8, '2024-08-18 11:58:51', '2024-08-18 11:58:51', '1', '1', 6, '能源类型', 'NYTYPE', 1, 1, '演示demo数据');
INSERT INTO `sys_dict_type` VALUES (9, '2024-08-18 11:59:07', '2024-08-18 11:59:07', '1', '1', 6, '车牌颜色', NULL, 1, 1, '演示demo数据');
INSERT INTO `sys_dict_type` VALUES (10, '2024-08-18 12:00:01', '2024-08-18 12:00:01', '1', '1', 6, '使用性质', NULL, 1, 1, '演示demo数据');
INSERT INTO `sys_dict_type` VALUES (15, '2024-09-01 00:18:47', '2024-09-01 13:08:50', '1', '1', 1, '性别', NULL, 1, 1, '车辆品牌11');
INSERT INTO `sys_dict_type` VALUES (1959175732345176064, '2025-08-23 16:47:49', '2025-08-23 16:47:49', '1', '1', NULL, '数据源类型', 'DATA_SOURCE_TYPE', 0, 1, '数据源类型');
INSERT INTO `sys_dict_type` VALUES (1961490437826936832, '2025-08-30 02:05:38', '2025-09-04 16:01:15', '1', '1', 1963511596957302784, '公告状态', 'NOTICE_STATE', 0, 1, '公告通知状态');
INSERT INTO `sys_dict_type` VALUES (1961701350643335168, '2025-08-30 16:03:43', '2025-08-30 16:03:43', '1', '1', NULL, '开发工具', 'DEV_TOOLS_CODE', 0, 1, '');
INSERT INTO `sys_dict_type` VALUES (1961701482558390272, '2025-08-30 16:04:15', '2025-08-30 16:04:15', '1', '1', 1961701350643335168, '报表设计', 'RDC_CODE', 0, 1, '');
INSERT INTO `sys_dict_type` VALUES (1961701584794550272, '2025-08-30 16:04:39', '2025-08-30 16:04:39', '1', '1', 1961701482558390272, '报表类型', 'RDC_TYPE', 0, 1, '');
INSERT INTO `sys_dict_type` VALUES (1961701723596652544, '2025-08-30 16:05:12', '2025-08-30 16:05:12', '1', '1', 1961701584794550272, '外部报表', 'EXP_RDC', 0, 1, '');
INSERT INTO `sys_dict_type` VALUES (1961701723596652545, '2025-08-30 16:05:12', '2025-08-30 16:05:12', '1', '1', 1961701584794550272, '外部报表1', 'EXP_RDC1', 0, 1, '');
INSERT INTO `sys_dict_type` VALUES (1961701723596652546, '2025-08-30 16:05:12', '2025-08-30 16:05:12', '1', '1', 1961701584794550272, '外部报表2', 'EXP_RDC2', 0, 1, '');
INSERT INTO `sys_dict_type` VALUES (1961701723596652547, '2025-08-30 16:05:12', '2025-08-30 16:05:12', '1', '1', 1961701584794550272, '外部报表3', 'EXP_RDC3', 0, 1, '');
INSERT INTO `sys_dict_type` VALUES (1961701723596652548, '2025-08-30 16:05:12', '2025-08-30 16:05:12', '1', '1', 1961701584794550272, '外部报表4', 'EXP_RDC4', 0, 1, '');
INSERT INTO `sys_dict_type` VALUES (1961701723596652549, '2025-08-30 16:05:12', '2025-08-30 16:05:12', '1', '1', 1961701584794550272, '外部报表5', 'EXP_RDC5', 0, 1, '');
INSERT INTO `sys_dict_type` VALUES (1961702241635139584, '2025-08-30 16:07:16', '2025-08-30 16:07:16', '1', '1', 1961701584794550272, '外部报表6', 'EXP_RDC6', 0, 1, '');
INSERT INTO `sys_dict_type` VALUES (1961702290117099520, '2025-08-30 16:07:27', '2025-08-30 16:07:27', '1', '1', 1961701584794550272, '外部报表7', 'EXP_RDC7', 0, 1, '');
INSERT INTO `sys_dict_type` VALUES (1961702337303019520, '2025-08-30 16:07:39', '2025-08-30 16:07:39', '1', '1', 1961701584794550272, '外部报表8', 'EXP_RDC8', 0, 1, '');
INSERT INTO `sys_dict_type` VALUES (1961800796983001088, '2025-08-30 22:38:53', '2025-08-30 22:38:53', '1', '1', 1961701584794550272, '外部报表9', '3243423', 0, 1, '');
INSERT INTO `sys_dict_type` VALUES (1963511596957302784, '2025-09-04 15:57:00', '2025-09-04 15:57:00', '1', '1', 1, '系统通知', 'SYS:TZ:CODE', 0, 1, '系统通知相关字典数据');
INSERT INTO `sys_dict_type` VALUES (1963511727697952768, '2025-09-04 15:57:31', '2025-09-04 15:57:31', '1', '1', 1963511596957302784, '通知类型', 'SYS:TZ:LX', 0, 1, '');
INSERT INTO `sys_dict_type` VALUES (1963511847990591488, '2025-09-04 15:58:00', '2025-09-04 15:58:00', '1', '1', 1963511596957302784, '通知级别', 'SYS:TZ:JB', 0, 1, '');

-- ----------------------------
-- Table structure for sys_notifications
-- ----------------------------
DROP TABLE IF EXISTS `sys_notifications`;
CREATE TABLE `sys_notifications`  (
                                      `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                                      `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                      `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                      `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                                      `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
                                      `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
                                      `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
                                      `state` tinyint NULL DEFAULT NULL COMMENT '状态',
                                      `publish_time` datetime NULL DEFAULT NULL COMMENT '发布时间',
                                      `revoke_time` datetime NULL DEFAULT NULL COMMENT '撤回时间',
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1963121422649786369 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统通知公告表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_notifications
-- ----------------------------
INSERT INTO `sys_notifications` VALUES (1961476084037844992, '2025-08-30 01:08:36', '2025-09-03 21:54:55', '1', '1', '但是发射点', '<h1 style=\"text-align: start;\">涉嫌严重违纪违法！吴卫民被查</h1><p>2025-09-03 14:45·鲁中晨报</p><p><br></p><p>皖北煤电集团有限责任公司销售公司原经理吴卫民涉嫌严重违纪违法，目前正接受皖北煤电集团纪委纪律审查；经安徽省监委指定管辖，接受淮南市监察委员会监察调查。（皖北煤电集团纪委、淮南市纪委监委）</p><p><img src=\"https://p3-sign.toutiaoimg.com/tos-cn-i-axegupay5k/c9c0f1c6ca144f9285bb4c772b9d4dd2~tplv-tt-origin-web:gif.jpeg?_iz=58558&from=article.pc_detail&lk3s=953192f4&x-expires=1757512482&x-signature=dRW4sCGSnl%2FKGHBquSkKaBPBeZA%3D\" alt=\"\" data-href=\"\" style=\"height: auto;\"/></p>', 2, '2025-09-03 11:59:19', NULL);
INSERT INTO `sys_notifications` VALUES (1963121422649786368, '2025-09-03 14:06:35', '2025-09-03 21:56:54', '1', '1', '纪念中国人民抗日战争', '<h1>纪念中国人民抗日战争暨世界反法西斯战争胜利80周年文艺晚会在京举行 习近平等出席观看</h1><p><img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAREAAAAqCAMAAACjgJ9mAAAAvVBMVEUAAAAAGWYAGmYAGWcAGWYAGWYAGWYAG2cAI2wAGWYAGWcAGmcAGmgAGmYAGmcAGWYAGmfrrn0AGmYAHmsAHWoAGWYAGWcAGWcAH2gAGmbsrn4AGmYAGWcAHHAAGmbtr37srn0AGmbsrn0AG2gAGmbsrn4AGWcAGmjtr30AH2sAG2cAGWYAGmYAKm3rrX7srX7trn/srn7srn7srn7vsILtrn38u4bsr33ur37wtIPtrn7tr3/troAAGWbrrX0PNpqGAAAAPXRSTlMA/EK1rnrZNw3kcKUxXlnzT93PHhKO7JggdfOTZgmHY+Ocaihqsr+AfhhKzMQGqKGX1s28J24IdDsVjFZJmA/2FQAABsFJREFUaN7t2WlX2kAUgOE72SCEkAhIGkQUg1hEigLuDv//ZzVzL2HIzuZpP/ie02NIKDQPycxI4aeffjquX3ciyK6NB6u46aZTYLvXVdgc0r1/vb6v36wS1gKo5AbpFB7mVKG4ShNrQEYqC/NB1maiX4Blvh+D7AIuGtPz0pmw3ZsQ6b7IHS/vy7fP37fX4e4rwDwedg7Ac6MTd/Wt7pg4MNC3S5/MpcNFGmQ0EkdiIvjcbxT5vBUtVqIFbs/g86y7ki32E9F4SQqkUvGAUyLSYWHKWqTORN8h8nuV7Bpu4jvev0ekWtl0QUcamx1BlgheSRsR/AGiobUJn80s2Ya/0e8PuMjr9/VjRV6/R+Se56eCyGKM4UMWNs4VsXh+NmDxJ3WOEjmb3Sz/gUj6pdYi1jl90oMjRNha5DKqt5vI0+3Hzdc7bJqGiTknIzcp4lxkpR0vIjtMhJqSCETZ8ZF1JbqdhV0jxMda5AV2rp4UMfCUbWwsZ9n/RIRBJNLXwlwpgr2sRG9i80ls3UC2SH8UNgRFTeVmi3gcG0ChCEt1mIipih7IE3NyRcyNCD5flyLUfBX2LG1yRDQaR3o8lZ4l0lbpINNko7QIg2Q1EklXLDJIzb5mTORXHcPhZ1QiMluFzWiZRhAk8jvqbS+R82aYem/yzJxms3KoSDXdjiKyidh5UShyNcfRozufz88QYn6bnH1v9hChApXn1ARsV5Gx0hO/OLTFdiurPUVatO5JiZTMNceK1C3GTyJyJ+4TF4BxU9WhwzPaU0TH49WTikzHNBhURYbYrE3jIpocwYb1dZUBO0BEx5en1bdxCpGxQy9+UhG45CIaDFCkB3ERk8vUOoh60T7m7yPSoJseVzvaKURo+rsvFnntUisRbj1FK7QnGmGePjNEHmiCKxShqSYA14geTQJIirST6VKkQhS45+4EIi5dqJqSLyJ7XIX9iZRQBOAKl/EASRFZjoihu82NycajU4Pt3NIVWpvuM4tGw5ouUulFdV/H9hGpbKZvf08RupO6h4o0vQreKZ3EvNuvwn4itAJxaMYMgBolvkrBJZ1c6mVsqhFIR84FhbPvNdZFBNxcwEe5SHMkSt41snFjkFiRdAZunKRRKkIWbUec2RQsVUQnaqjrgFPlr+UzXi5Cd0iyJ3gsECkfWSGwB3ggFRvplSlE9UrPgt7TpakmexzZWWSI24eKzHDKOUykribvlgmLPXwYAuWXi/TFtoe3yZEi8t0sjUkROoFykVtcuxaKMCxjHHHjt4rlXkJLNzLOlk7XUDILti4jvPv6JxOpQdu3K4YIpngGLrji0QioqzOMxhHcXMCCvl4tH1mLRUxPmQJV75spEYs++6IUHmWvRczwHByxZZok0thqxKOshkxJisju6QTagBXMNfgLzuxIEdOzG1vZAych8kCTZlEtHlVfiygG595QUFRSC7x7Ju/NABL53NGNpIjFMaVUZCX6KBTxdFEnU8QxeW6mFDFpVCssUmTVcpGAnjyhyagK8WrnbWgmROosU+TmLOyGRD7E9tWSvm8+bGQN7AD6PLfWr54P2Hh9NxRmhPMTjXqlIoFBV+Al/Rylb4WkyCXipURoGP0ikWe8Xb5WuKtQxFZce6jTrX2RmH0LRRILtAAKu9DHCp5nqUjDodulBQqjq7FSIjLV5HfhihE2AQrH1BcSecO5Bl1Wy2yRSnqpoR0kMsATgNJq9L6tQpGWxzGm4N+gbb1dJDJ+4FLE3frHLGmmJZGXFf6gBVq2iMJ3FDEgXiMh0qHPvjQ8V7PD2/kiihat5Ht0ZXHKGdTzRFp3Ds8Wod9zH6OR9QkxEOmbReh1dCguaETTdp6I78klIbNTF6mpXdgpEdsSWzKrr22J0AVx3SWR2SpqtrOI4wX6/iID+R/aufXxc8wWCSYkgmBU5x6ihlt/U02JaPIYi7akyDWuxsI/KPK5uP1DD67yRExjomqD87ua7SomzTV3PEOEGfHMmMiY4UwJhWk8X6TOkyLqGGRBcxcRD1IiNIxc30Qi8lu1ZY5ILEOK7DmyntP68XQiEwXi2WaZiOFCTKQDorfbsN9vJPIIojk57C9yubsIfeHpVHcUMTRdgSwRh0ScgQKppq7GCkSatWkC3QLZO4J0lyD6WHQJp1zEHoYFaxEDdhcJBiZ+hVoqwgzLVwiORGzfV+q+75OIBZZ1MaxPIbtLxfe0PkSpRpgNcK56tQCwtjdprvOqsYXr8/Pz1TtELb+W+ONZ7AbqfBKWeZmjCGvKma5Sy60qn9RvBlBcr0YY1NAP2wzFbfGoMYWffvppz/4CEPCdl1Be4EsAAAAASUVORK5CYII=\" alt=\"\" data-href=\"\" style=\"height: 14px;\"/></p><p><span style=\"color: rgb(153, 153, 153);\">2025-09-03 19:57:52</span></p><p>浏览量3454721</p><p><br></p><p>9月3日晚，纪念中国人民抗日战争暨世界反法西斯战争胜利80周年文艺晚会《正义必胜》在北京人民大会堂举行，习近平等出席观看。</p><p><br></p><p><span style=\"color: rgb(164, 172, 182);\">©2025中央广播电视总台版权所有。未经许可，请勿转载使用。</span></p><p>责任编辑：孟浩</p><p><img src=\"https://content-static.cctvnews.cctv.com/lib/cctv_logo.png\" alt=\"\" data-href=\"\" style=\"width: 32px;height: 32px;\"/></p><p>央视新闻</p><p>我用心你放心</p>', 2, '2025-09-03 14:17:29', NULL);

-- ----------------------------
-- Table structure for sys_notifications_record
-- ----------------------------
DROP TABLE IF EXISTS `sys_notifications_record`;
CREATE TABLE `sys_notifications_record`  (
                                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                                             `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                             `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                             `notifications_id` bigint NULL DEFAULT NULL COMMENT '主表通知公告表Id',
                                             `user_id` bigint NULL DEFAULT NULL COMMENT '用户id',
                                             `read_state` tinyint NULL DEFAULT NULL COMMENT '读取状态',
                                             `read_time` datetime NULL DEFAULT NULL COMMENT '阅读时间',
                                             `type` tinyint NULL DEFAULT NULL COMMENT '通知类型',
                                             `level` tinyint NULL DEFAULT NULL COMMENT '消息通知等级枚举',
                                             PRIMARY KEY (`id`) USING BTREE,
                                             INDEX `id_index`(`notifications_id` ASC, `user_id` ASC, `created_time` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1963124086565502977 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统通知通知记录表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_notifications_record
-- ----------------------------
INSERT INTO `sys_notifications_record` VALUES (20250904142207, '2025-09-04 14:22:07', '2025-09-04 14:22:07', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142211, '2025-09-04 14:22:11', '2025-09-04 14:22:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142213, '2025-09-04 14:22:13', '2025-09-04 14:22:13', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142214, '2025-09-04 14:22:14', '2025-09-04 14:22:14', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142215, '2025-09-04 14:22:15', '2025-09-04 14:22:15', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142220, '2025-09-04 14:22:20', '2025-09-04 14:22:20', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142221, '2025-09-04 14:22:21', '2025-09-04 14:22:21', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142222, '2025-09-04 14:22:22', '2025-09-04 14:22:22', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142223, '2025-09-04 14:22:23', '2025-09-04 14:22:23', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142224, '2025-09-04 14:22:24', '2025-09-04 14:22:24', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142225, '2025-09-04 14:22:25', '2025-09-04 14:22:25', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142226, '2025-09-04 14:22:26', '2025-09-04 14:22:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142241, '2025-09-04 14:22:41', '2025-09-04 14:22:41', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142242, '2025-09-04 14:22:42', '2025-09-04 14:22:42', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142243, '2025-09-04 14:22:43', '2025-09-04 14:22:43', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142244, '2025-09-04 14:22:44', '2025-09-04 14:22:44', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142312, '2025-09-04 14:23:12', '2025-09-04 14:23:12', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142314, '2025-09-04 14:23:14', '2025-09-04 14:23:14', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142315, '2025-09-04 14:23:15', '2025-09-04 14:23:15', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142316, '2025-09-04 14:23:16', '2025-09-04 14:23:16', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142317, '2025-09-04 14:23:17', '2025-09-04 14:23:17', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142318, '2025-09-04 14:23:18', '2025-09-04 14:23:18', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142343, '2025-09-04 14:23:43', '2025-09-04 14:23:43', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142610, '2025-09-04 14:26:09', '2025-09-04 14:26:09', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142621, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142626, '2025-09-04 14:26:05', '2025-09-04 14:26:05', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142628, '2025-09-04 14:26:27', '2025-09-04 14:26:27', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142637, '2025-09-04 14:26:26', '2025-09-04 14:26:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142642, '2025-09-04 14:26:09', '2025-09-04 14:26:09', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142651, '2025-09-04 14:26:11', '2025-09-04 14:26:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142654, '2025-09-04 14:26:09', '2025-09-04 14:26:09', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142655, '2025-09-04 14:26:27', '2025-09-04 14:26:27', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142664, '2025-09-04 14:26:12', '2025-09-04 14:26:12', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142665, '2025-09-04 14:26:11', '2025-09-04 14:26:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142667, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142679, '2025-09-04 14:26:12', '2025-09-04 14:26:12', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142690, '2025-09-04 14:26:31', '2025-09-04 14:26:31', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142706, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142709, '2025-09-04 14:26:33', '2025-09-04 14:26:33', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142710, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142717, '2025-09-04 14:26:11', '2025-09-04 14:26:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142718, '2025-09-04 14:26:32', '2025-09-04 14:26:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142725, '2025-09-04 14:26:33', '2025-09-04 14:26:33', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142727, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142731, '2025-09-04 14:26:30', '2025-09-04 14:26:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142737, '2025-09-04 14:26:12', '2025-09-04 14:26:12', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142740, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142747, '2025-09-04 14:26:27', '2025-09-04 14:26:27', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142756, '2025-09-04 14:26:30', '2025-09-04 14:26:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142758, '2025-09-04 14:26:32', '2025-09-04 14:26:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142770, '2025-09-04 14:26:31', '2025-09-04 14:26:31', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142773, '2025-09-04 14:26:33', '2025-09-04 14:26:33', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142775, '2025-09-04 14:26:26', '2025-09-04 14:26:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142779, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142782, '2025-09-04 14:26:31', '2025-09-04 14:26:31', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142783, '2025-09-04 14:26:11', '2025-09-04 14:26:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142786, '2025-09-04 14:26:33', '2025-09-04 14:26:33', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142794, '2025-09-04 14:26:25', '2025-09-04 14:26:25', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142798, '2025-09-04 14:26:09', '2025-09-04 14:26:09', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142801, '2025-09-04 14:26:27', '2025-09-04 14:26:27', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142817, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142819, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142830, '2025-09-04 14:26:09', '2025-09-04 14:26:09', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142833, '2025-09-04 14:26:27', '2025-09-04 14:26:27', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142835, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142839, '2025-09-04 14:26:27', '2025-09-04 14:26:27', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142843, '2025-09-04 14:26:31', '2025-09-04 14:26:31', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142844, '2025-09-04 14:26:31', '2025-09-04 14:26:31', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142846, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142847, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142860, '2025-09-04 14:26:09', '2025-09-04 14:26:09', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142862, '2025-09-04 14:26:27', '2025-09-04 14:26:27', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142864, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142865, '2025-09-04 14:26:34', '2025-09-04 14:26:34', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142877, '2025-09-04 14:26:30', '2025-09-04 14:26:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142880, '2025-09-04 14:26:12', '2025-09-04 14:26:12', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142882, '2025-09-04 14:26:27', '2025-09-04 14:26:27', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142887, '2025-09-04 14:26:26', '2025-09-04 14:26:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142894, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142900, '2025-09-04 14:26:07', '2025-09-04 14:26:07', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142907, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142909, '2025-09-04 14:26:32', '2025-09-04 14:26:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142917, '2025-09-04 14:26:32', '2025-09-04 14:26:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142920, '2025-09-04 14:26:09', '2025-09-04 14:26:09', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142921, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142929, '2025-09-04 14:26:09', '2025-09-04 14:26:09', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142932, '2025-09-04 14:26:33', '2025-09-04 14:26:33', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142940, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142941, '2025-09-04 14:26:30', '2025-09-04 14:26:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142943, '2025-09-04 14:26:33', '2025-09-04 14:26:33', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142946, '2025-09-04 14:26:07', '2025-09-04 14:26:07', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142948, '2025-09-04 14:26:26', '2025-09-04 14:26:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142952, '2025-09-04 14:26:33', '2025-09-04 14:26:33', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142958, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142960, '2025-09-04 14:26:26', '2025-09-04 14:26:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142978, '2025-09-04 14:26:33', '2025-09-04 14:26:33', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142988, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142992, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142997, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904142998, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143002, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143004, '2025-09-04 14:26:32', '2025-09-04 14:26:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143005, '2025-09-04 14:26:30', '2025-09-04 14:26:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143012, '2025-09-04 14:26:32', '2025-09-04 14:26:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143013, '2025-09-04 14:26:31', '2025-09-04 14:26:31', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143014, '2025-09-04 14:26:30', '2025-09-04 14:26:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143037, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143043, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143050, '2025-09-04 14:26:27', '2025-09-04 14:26:27', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143051, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143057, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143061, '2025-09-04 14:26:31', '2025-09-04 14:26:31', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143065, '2025-09-04 14:26:32', '2025-09-04 14:26:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143077, '2025-09-04 14:26:26', '2025-09-04 14:26:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143088, '2025-09-04 14:26:31', '2025-09-04 14:26:31', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143090, '2025-09-04 14:26:30', '2025-09-04 14:26:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143092, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143100, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143118, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143121, '2025-09-04 14:26:33', '2025-09-04 14:26:33', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143123, '2025-09-04 14:26:07', '2025-09-04 14:26:07', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143141, '2025-09-04 14:26:27', '2025-09-04 14:26:27', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143142, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143143, '2025-09-04 14:26:09', '2025-09-04 14:26:09', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143144, '2025-09-04 14:26:27', '2025-09-04 14:26:27', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143146, '2025-09-04 14:26:31', '2025-09-04 14:26:31', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143155, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143157, '2025-09-04 14:26:09', '2025-09-04 14:26:09', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143169, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143174, '2025-09-04 14:26:26', '2025-09-04 14:26:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143175, '2025-09-04 14:26:07', '2025-09-04 14:26:07', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143177, '2025-09-04 14:26:11', '2025-09-04 14:26:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143182, '2025-09-04 14:26:32', '2025-09-04 14:26:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143183, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143184, '2025-09-04 14:26:11', '2025-09-04 14:26:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143188, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143189, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143191, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143199, '2025-09-04 14:26:31', '2025-09-04 14:26:31', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143200, '2025-09-04 14:26:30', '2025-09-04 14:26:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143202, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143210, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143215, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143217, '2025-09-04 14:26:33', '2025-09-04 14:26:33', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143219, '2025-09-04 14:26:34', '2025-09-04 14:26:34', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143221, '2025-09-04 14:26:30', '2025-09-04 14:26:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143222, '2025-09-04 14:26:09', '2025-09-04 14:26:09', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143223, '2025-09-04 14:26:12', '2025-09-04 14:26:12', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143232, '2025-09-04 14:26:32', '2025-09-04 14:26:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143234, '2025-09-04 14:26:32', '2025-09-04 14:26:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143236, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143242, '2025-09-04 14:26:33', '2025-09-04 14:26:33', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143247, '2025-09-04 14:26:30', '2025-09-04 14:26:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143264, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143275, '2025-09-04 14:26:11', '2025-09-04 14:26:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143276, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143278, '2025-09-04 14:26:07', '2025-09-04 14:26:07', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143289, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143298, '2025-09-04 14:26:33', '2025-09-04 14:26:33', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143299, '2025-09-04 14:26:11', '2025-09-04 14:26:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143301, '2025-09-04 14:26:27', '2025-09-04 14:26:27', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143309, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143313, '2025-09-04 14:26:31', '2025-09-04 14:26:31', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143316, '2025-09-04 14:26:11', '2025-09-04 14:26:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143323, '2025-09-04 14:26:04', '2025-09-04 14:26:04', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143327, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143328, '2025-09-04 14:26:30', '2025-09-04 14:26:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143329, '2025-09-04 14:26:33', '2025-09-04 14:26:33', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143332, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143333, '2025-09-04 14:26:26', '2025-09-04 14:26:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143335, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143336, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143338, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143341, '2025-09-04 14:26:34', '2025-09-04 14:26:34', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143343, '2025-09-04 14:26:09', '2025-09-04 14:26:09', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143345, '2025-09-04 14:26:34', '2025-09-04 14:26:34', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143350, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143352, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143367, '2025-09-04 14:26:07', '2025-09-04 14:26:07', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143368, '2025-09-04 14:26:11', '2025-09-04 14:26:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143372, '2025-09-04 14:26:27', '2025-09-04 14:26:27', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143376, '2025-09-04 14:26:32', '2025-09-04 14:26:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143380, '2025-09-04 14:26:27', '2025-09-04 14:26:27', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143382, '2025-09-04 14:26:31', '2025-09-04 14:26:31', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143388, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143400, '2025-09-04 14:26:11', '2025-09-04 14:26:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143402, '2025-09-04 14:26:34', '2025-09-04 14:26:34', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143404, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143406, '2025-09-04 14:26:26', '2025-09-04 14:26:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143407, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143408, '2025-09-04 14:26:27', '2025-09-04 14:26:27', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143414, '2025-09-04 14:26:11', '2025-09-04 14:26:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143421, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143427, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143432, '2025-09-04 14:26:11', '2025-09-04 14:26:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143438, '2025-09-04 14:26:30', '2025-09-04 14:26:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143439, '2025-09-04 14:26:09', '2025-09-04 14:26:09', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143440, '2025-09-04 14:26:30', '2025-09-04 14:26:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143447, '2025-09-04 14:26:26', '2025-09-04 14:26:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143454, '2025-09-04 14:26:26', '2025-09-04 14:26:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143467, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143468, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143471, '2025-09-04 14:26:34', '2025-09-04 14:27:54', 1963121422649786368, 1, 1, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143482, '2025-09-04 14:26:33', '2025-09-04 14:26:33', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143490, '2025-09-04 14:26:30', '2025-09-04 14:26:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143496, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143504, '2025-09-04 14:26:32', '2025-09-04 14:26:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143506, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143509, '2025-09-04 14:26:31', '2025-09-04 14:26:31', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143512, '2025-09-04 14:26:10', '2025-09-04 14:26:10', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143513, '2025-09-04 14:26:32', '2025-09-04 14:26:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143514, '2025-09-04 14:26:11', '2025-09-04 14:26:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143516, '2025-09-04 14:26:09', '2025-09-04 14:26:09', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143517, '2025-09-04 14:26:26', '2025-09-04 14:26:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143522, '2025-09-04 14:26:32', '2025-09-04 14:26:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143531, '2025-09-04 14:26:07', '2025-09-04 14:26:07', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143532, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143537, '2025-09-04 14:26:11', '2025-09-04 14:26:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143538, '2025-09-04 14:26:29', '2025-09-04 14:26:29', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143544, '2025-09-04 14:26:26', '2025-09-04 14:26:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143552, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143553, '2025-09-04 14:26:06', '2025-09-04 14:26:06', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143556, '2025-09-04 14:26:09', '2025-09-04 14:26:09', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143562, '2025-09-04 14:26:30', '2025-09-04 14:26:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143563, '2025-09-04 14:26:34', '2025-09-04 14:27:34', 1963121422649786368, 1, 1, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143569, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143575, '2025-09-04 14:26:12', '2025-09-04 14:26:12', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143576, '2025-09-04 14:26:33', '2025-09-04 14:26:33', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143578, '2025-09-04 14:26:08', '2025-09-04 14:26:08', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143579, '2025-09-04 14:26:09', '2025-09-04 14:26:09', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143582, '2025-09-04 14:26:28', '2025-09-04 14:26:28', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143586, '2025-09-04 14:26:26', '2025-09-04 14:26:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143591, '2025-09-04 14:26:31', '2025-09-04 14:26:31', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143594, '2025-09-04 14:26:32', '2025-09-04 14:26:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143597, '2025-09-04 14:26:30', '2025-09-04 14:26:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143617, '2025-09-04 14:26:26', '2025-09-04 14:26:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (20250904143625, '2025-09-04 14:26:26', '2025-09-04 14:26:26', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (1963124083033899008, '2025-09-03 14:17:09', '2025-09-04 11:39:07', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (1963124083155533824, '2025-09-12 14:17:09', '2025-09-04 14:27:52', 1963121422649786368, 1, 1, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (1963124083428163584, '2025-09-18 14:17:09', '2025-09-04 14:27:44', 1963121422649786368, 1, 1, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (1963124083524632576, '2025-09-03 14:17:09', '2025-09-04 11:38:40', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (1963124083616907264, '2025-09-03 14:17:09', '2025-09-04 11:34:30', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (1963124083793068032, '2025-09-01 14:17:09', '2025-09-04 11:34:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (1963124083960840192, '2025-09-03 14:17:09', '2025-09-04 11:34:43', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (1963124084057309184, '2025-09-05 14:17:09', '2025-09-04 14:27:52', 1963121422649786368, 1, 1, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (1963124084279607296, '2025-09-03 14:17:09', '2025-09-04 11:30:11', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (1963124084418019328, '2025-09-03 13:17:10', '2025-09-04 11:30:15', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (1963124084975861760, '2025-09-03 11:16:07', '2025-09-04 11:30:19', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (1963124085676310528, '2025-09-03 14:17:12', '2025-09-04 11:29:44', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (1963124085751808000, '2025-09-03 14:17:14', '2025-09-04 10:10:41', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (1963124085865054208, '2025-09-03 14:17:15', '2025-09-04 11:41:32', 1963121422649786368, 1, 0, NULL, 1, 1);
INSERT INTO `sys_notifications_record` VALUES (1963124086565502976, '2025-09-03 14:17:16', '2025-09-04 11:53:27', 1963121422649786368, 1, 0, NULL, 1, 1);

-- ----------------------------
-- Table structure for sys_notifications_target
-- ----------------------------
DROP TABLE IF EXISTS `sys_notifications_target`;
CREATE TABLE `sys_notifications_target`  (
                                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                                             `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                             `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                             `notifications_id` bigint NULL DEFAULT NULL COMMENT '主表通知公告表Id',
                                             `target_type` tinyint NULL DEFAULT NULL COMMENT '通知目标类型',
                                             `target_id` bigint NULL DEFAULT NULL COMMENT '通知目标Id',
                                             `target_name` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '通知目标名称',
                                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1963239783144620033 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统通知公告通知对象表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_notifications_target
-- ----------------------------
INSERT INTO `sys_notifications_target` VALUES (1963239282558631936, '2025-09-03 21:54:55', '2025-09-03 21:54:55', 1961476084037844992, 1, 1, '宇宙无敌的高手555');
INSERT INTO `sys_notifications_target` VALUES (1963239282567020544, '2025-09-03 21:54:55', '2025-09-03 21:54:55', 1961476084037844992, 1, 6, '王老五');
INSERT INTO `sys_notifications_target` VALUES (1963239282571214848, '2025-09-03 21:54:55', '2025-09-03 21:54:55', 1961476084037844992, 1, 7, '李四');
INSERT INTO `sys_notifications_target` VALUES (1963239282579603456, '2025-09-03 21:54:55', '2025-09-03 21:54:55', 1961476084037844992, 3, 1961811379778224128, 'BM集团');
INSERT INTO `sys_notifications_target` VALUES (1963239783123648512, '2025-09-03 21:56:54', '2025-09-03 21:56:54', 1963121422649786368, 3, 1961811583873056768, '贵阳研发部分公司');
INSERT INTO `sys_notifications_target` VALUES (1963239783132037120, '2025-09-03 21:56:54', '2025-09-03 21:56:54', 1963121422649786368, 3, 1961818823791214592, '设计部');
INSERT INTO `sys_notifications_target` VALUES (1963239783140425728, '2025-09-03 21:56:54', '2025-09-03 21:56:54', 1963121422649786368, 1, 1, '宇宙无敌的高手555');
INSERT INTO `sys_notifications_target` VALUES (1963239783144620032, '2025-09-03 21:56:54', '2025-09-03 21:56:54', 1963121422649786368, 1, 8, 'java高手');

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization`  (
                                     `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                                     `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                     `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                     `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                                     `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
                                     `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组织名称',
                                     `sort` tinyint NULL DEFAULT NULL COMMENT '排序',
                                     `parent_id` bigint NULL DEFAULT NULL COMMENT '父级ID',
                                     `type` tinyint NULL DEFAULT NULL COMMENT '组织机构类型类型',
                                     `enable` tinyint NULL DEFAULT NULL COMMENT '是否启用',
                                     `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
                                     `leader` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '负责人id json 数组',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1961819924967981057 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统组织表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_organization
-- ----------------------------
INSERT INTO `sys_organization` VALUES (1961811379778224128, '2025-08-30 23:20:56', '2025-08-30 23:20:56', '1', '1', 'BM集团', 0, NULL, 1, 1, 'BM集团总公司', NULL);
INSERT INTO `sys_organization` VALUES (1961811583873056768, '2025-08-30 23:21:45', '2025-08-30 23:31:54', '1', '1', '贵阳研发部分公司', 0, 1961811379778224128, 1, 1, '贵阳研发部分公司', NULL);
INSERT INTO `sys_organization` VALUES (1961811773644341248, '2025-08-30 23:22:30', '2025-08-30 23:32:38', '1', '1', '成都研发部分公司', 0, 1961811379778224128, 1, 1, '成都研发部分公司', NULL);
INSERT INTO `sys_organization` VALUES (1961812017236934656, '2025-08-30 23:23:28', '2025-08-30 23:53:55', '1', '1', '法务部', 0, 1961811379778224128, 4, 1, '研发部', NULL);
INSERT INTO `sys_organization` VALUES (1961812605907501056, '2025-08-30 23:25:49', '2025-08-30 23:37:03', '1', '1', '运营部', 0, 1961811379778224128, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961816344705892352, '2025-08-30 23:40:40', '2025-08-30 23:46:47', '1', '1', '集团物业', 0, NULL, 3, 1, '贵州保利XX物业有限公司，集团物业公司外部单位', NULL);
INSERT INTO `sys_organization` VALUES (1961817042982010880, '2025-08-30 23:43:27', '2025-08-30 23:43:27', '1', '1', '集团食堂', 0, NULL, 3, 1, '外部单位贵州XX餐饮管理有限公司', NULL);
INSERT INTO `sys_organization` VALUES (1961817209734955008, '2025-08-30 23:44:06', '2025-08-30 23:44:06', '1', '1', '市场部', 0, 1961811379778224128, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961817452794871808, '2025-08-30 23:45:04', '2025-08-30 23:53:14', '1', '1', '领导班子', 0, 1961811379778224128, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961817664582057984, '2025-08-30 23:45:55', '2025-08-30 23:45:55', '1', '1', '采购部', 0, 1961817042982010880, 4, 1, '负责食材采购', NULL);
INSERT INTO `sys_organization` VALUES (1961817999107162112, '2025-08-30 23:47:14', '2025-08-30 23:48:29', '1', '1', '停车管理部', 0, 1961816344705892352, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961818275515990016, '2025-08-30 23:48:20', '2025-08-30 23:48:20', '1', '1', '设施维护部', 0, 1961816344705892352, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961818595369418752, '2025-08-30 23:49:37', '2025-08-30 23:49:37', '1', '1', '安全管理', 0, 1961816344705892352, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961818668522274816, '2025-08-30 23:49:54', '2025-08-30 23:49:54', '1', '1', '运输司机', 0, 1961817042982010880, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961818823791214592, '2025-08-30 23:50:31', '2025-08-30 23:50:31', '1', '1', '设计部', 0, 1961811583873056768, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961818852744495104, '2025-08-30 23:50:38', '2025-08-30 23:50:38', '1', '1', '测试部', 0, 1961811583873056768, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961818903319412736, '2025-08-30 23:50:50', '2025-08-30 23:50:50', '1', '1', '产品部', 0, 1961811583873056768, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961818974295425024, '2025-08-30 23:51:07', '2025-08-30 23:51:07', '1', '1', '运营部', 0, 1961811583873056768, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961818995388579840, '2025-08-30 23:51:12', '2025-08-30 23:51:12', '1', '1', '行政部', 0, 1961811583873056768, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961819027340787712, '2025-08-30 23:51:20', '2025-08-30 23:51:20', '1', '1', '人力部', 0, 1961811583873056768, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961819067719352320, '2025-08-30 23:51:29', '2025-08-30 23:51:29', '1', '1', '研发部', 0, 1961811583873056768, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961819449128386560, '2025-08-30 23:53:00', '2025-08-30 23:53:00', '1', '1', '财务管理中心', 0, 1961811379778224128, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961819745862811648, '2025-08-30 23:54:11', '2025-08-30 23:54:11', '1', '1', '设计部', 0, 1961811773644341248, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961819826523471872, '2025-08-30 23:54:30', '2025-08-30 23:54:30', '1', '1', '产品部', 0, 1961811773644341248, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961819848073805824, '2025-08-30 23:54:35', '2025-08-30 23:54:35', '1', '1', '研发部', 0, 1961811773644341248, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961819869754163200, '2025-08-30 23:54:40', '2025-08-30 23:54:40', '1', '1', '市场部', 0, 1961811773644341248, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961819891631652864, '2025-08-30 23:54:46', '2025-08-30 23:54:46', '1', '1', '运营部', 0, 1961811773644341248, 4, 1, '', NULL);
INSERT INTO `sys_organization` VALUES (1961819924967981056, '2025-08-30 23:54:54', '2025-08-30 23:55:58', '1', '1', '行政部', 0, 1961811773644341248, 4, 1, '', NULL);

-- ----------------------------
-- Table structure for sys_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_resources`;
CREATE TABLE `sys_resources`  (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                                  `parent_id` bigint NULL DEFAULT NULL COMMENT '上级资源id',
                                  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                  `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                                  `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
                                  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '资源编码',
                                  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源名称',
                                  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源类型',
                                  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路由地址',
                                  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组件路径',
                                  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
                                  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
                                  `layout` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '布局方式',
                                  `is_show` tinyint NULL DEFAULT NULL COMMENT '是否显示',
                                  `enable` tinyint NULL DEFAULT NULL COMMENT '是否启用',
                                  `keep_alive` tinyint NULL DEFAULT NULL COMMENT '是否启用组件之间切换时缓存它们的状态',
                                  `sort` int NULL DEFAULT NULL COMMENT '排序',
                                  PRIMARY KEY (`id`, `code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1965222813082058753 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统资源表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_resources
-- ----------------------------
INSERT INTO `sys_resources` VALUES (1, 2, '2024-07-15 14:54:40', '2025-08-30 13:47:36', '1', '1', 'ResourceMgt', '资源管理', '1', '/pms/resource', '/src/views/pms/resource/index.vue', '系统功能', 'i-fe:list', '', 1, 1, 1, 3);
INSERT INTO `sys_resources` VALUES (2, NULL, '2024-07-15 14:54:40', '2024-07-15 14:54:40', '1', '1', 'SysMgt', '系统管理', '1', NULL, NULL, '系统功能', 'i-fe:grid', '', 1, 1, NULL, 2);
INSERT INTO `sys_resources` VALUES (3, 2, '2024-07-15 14:54:40', '2025-08-30 13:47:21', '1', '1', 'RoleMgt', '角色管理', '1', '/pms/role', '/src/views/pms/role/index.vue', '系统功能', 'i-fe:user-check', '', 1, 1, 1, 2);
INSERT INTO `sys_resources` VALUES (4, 2, '2024-07-15 14:54:40', '2025-08-30 13:47:05', '1', '1', 'UserMgt', '用户管理', '1', '/pms/user', '/src/views/pms/user/index.vue', '系统功能', 'i-fe:user', '', 1, 1, 1, 1);
INSERT INTO `sys_resources` VALUES (6, NULL, '2024-07-15 14:54:40', '2024-07-15 14:54:40', '1', '1', 'Demo', '业务示例', '1', NULL, NULL, '系统功能', 'i-fe:grid', '', 1, 1, NULL, 1);
INSERT INTO `sys_resources` VALUES (7, 6, '2024-07-15 14:54:40', '2024-07-15 14:54:40', '1', '1', 'ImgUpload', '图片上传', '1', '/demo/upload', '/src/views/demo/upload/index.vue', '系统功能', 'i-fe:image', '', 1, 1, 1, 2);
INSERT INTO `sys_resources` VALUES (8, NULL, '2024-07-15 14:54:40', '2024-07-15 14:54:40', '1', '1', 'UserProfile', '个人资料', '1', '/profile', '/src/views/profile/index.vue', '系统功能', 'i-fe:user', '', 0, 1, 1, 99);
INSERT INTO `sys_resources` VALUES (9, NULL, '2024-07-15 14:54:39', '2024-07-15 14:54:39', '1', '1', 'Base', '基础功能', '1', '', NULL, '系统功能', 'i-fe:grid', '', 1, 1, NULL, 0);
INSERT INTO `sys_resources` VALUES (10, 9, '2024-07-15 14:54:40', '2024-07-15 14:54:40', '1', '1', 'BaseComponents', '基础组件', '1', '/base/components', '/src/views/base/index.vue', '系统功能', 'i-me:awesome', '', 1, 1, NULL, 1);
INSERT INTO `sys_resources` VALUES (11, 9, '2024-07-15 14:54:40', '2024-07-15 14:54:40', '1', '1', 'Unocss', 'Unocss', '1', '/base/unocss', '/src/views/base/unocss.vue', '系统功能', 'i-me:awesome', '', 1, 1, NULL, 2);
INSERT INTO `sys_resources` VALUES (12, 9, '2024-07-15 14:54:40', '2024-07-15 14:54:40', '1', '1', 'KeepAlive', 'KeepAlive', '1', '/base/keep-alive', '/src/views/base/keep-alive.vue', '系统功能', 'i-me:awesome', '', 1, 1, 1, 3);
INSERT INTO `sys_resources` VALUES (13, 4, '2024-07-15 14:54:40', '2024-07-25 23:11:23', '1', '1', 'AddUser', '创建用户', '3', NULL, NULL, '系统功能', 'i-me:btn', '', 1, 1, NULL, 1);
INSERT INTO `sys_resources` VALUES (14, 9, '2024-07-15 14:54:40', '2024-07-15 14:54:40', '1', '1', 'Icon', '图标 Icon', '1', '/base/icon', '/src/views/base/unocss-icon.vue', '系统功能', 'i-fe:feather', '', 1, 1, NULL, 0);
INSERT INTO `sys_resources` VALUES (24, 8, '2024-07-25 14:27:01', '2024-07-25 14:43:38', '1', '22', 'EditProfile', '修改资料', '3', NULL, NULL, '编辑个人信息按钮', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (25, 8, '2024-07-25 14:33:23', '2024-07-25 14:33:23', '1', '1', 'ChangePwd', '修改密码', '3', NULL, NULL, '修改密码按钮', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (26, 8, '2024-07-25 14:34:07', '2024-07-25 14:34:07', '1', '1', 'ChangeAvatar', '修改头像', '3', NULL, NULL, '修改头像按钮', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (27, 3, '2024-07-25 14:37:05', '2024-07-25 14:37:05', '1', '1', 'AddRole', '新增角色', '3', NULL, NULL, '新增角色按钮', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (28, 1, '2024-07-25 15:08:00', '2024-07-25 15:08:00', '1', '1', 'AddResources', '新增', '3', NULL, NULL, '资源管理新增按钮', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (29, 1, '2024-07-25 15:08:35', '2024-07-25 15:08:35', '1', '1', 'EditResources', '编辑', '3', NULL, NULL, '资源管理编辑按钮', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (30, 1, '2024-07-25 15:09:11', '2024-07-25 15:09:11', '1', '1', 'DelResources', '删除', '3', NULL, NULL, '资源管理删除按钮', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (31, 4, '2024-07-25 18:24:10', '2024-07-25 18:24:10', '1', '1', 'DelUser', '删除', '3', NULL, NULL, '删除用户按钮', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (32, 4, '2024-07-25 18:30:49', '2024-07-25 18:30:49', '1', '1', 'SetRole', '分配角色', '3', NULL, NULL, '用户管理页码分配角色按钮', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (33, 4, '2024-07-25 18:31:25', '2024-07-25 18:31:25', '1', '1', 'ResetPwd', '重置密码', '3', NULL, NULL, '用户管理页码重置密码', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (34, 4, '2024-07-25 18:34:25', '2024-07-25 18:34:25', '1', '1', 'Enable|DisableUser', '启用|禁用', '3', NULL, NULL, '用户管理页码 启用|禁用 用户按钮', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (35, 3, '2024-07-25 18:38:32', '2024-07-25 18:38:32', '1', '1', 'DelRole', '删除', '3', NULL, NULL, '删除角色', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (36, 3, '2024-07-25 18:42:58', '2024-07-25 18:42:58', '1', '1', 'EditRole', '编辑', '3', NULL, NULL, '角色管理页码编辑角色按钮', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (37, 3, '2024-07-25 18:43:45', '2024-07-25 18:43:45', '1', '1', 'SetUser', '分配用户', '3', NULL, NULL, '角色管理页码分配用户按钮', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (38, 3, '2024-07-25 18:45:25', '2024-07-25 18:45:25', '1', '1', 'Enable|DisableRole', '启用|停用', '3', NULL, NULL, '角色管理页码启用或停用角色按钮', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (39, 1, '2024-07-25 19:06:23', '2024-07-25 19:06:23', '1', '1', 'Enable|DisableResources', '启用|停用', '3', NULL, NULL, '资源管理页面启用或停用’按钮‘按钮', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (42, NULL, '2024-07-29 18:47:01', '2024-07-29 18:47:01', '1', '1', 'DevTool', '开发工具', '1', NULL, NULL, '开发管理、运维管理、代码生成', 'i-fe:tool', '', 1, 1, NULL, 10);
INSERT INTO `sys_resources` VALUES (43, 42, '2024-07-29 18:47:54', '2024-07-29 18:47:54', '1', '1', 'CodeGenerate', '代码生成', '1', '/dev/code', '/src/views/generate/index.vue', '代码生成页面', 'i-fe:code', '', 1, 1, 1, 1);
INSERT INTO `sys_resources` VALUES (68, 2, '2024-08-18 12:18:54', '2025-08-30 13:48:06', '1', '1', 'DictMgt', '字典管理', '1', '/pms/dict', '/src/views/pms/dict/index.vue', '系统字典管理', 'i-me:dict', '', 1, 1, 1, 4);
INSERT INTO `sys_resources` VALUES (69, 68, '2024-08-18 17:13:11', '2024-08-18 17:13:11', '1', '1', 'AddDict', '新增字典', '3', NULL, NULL, NULL, 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (70, 68, '2024-08-18 17:13:56', '2024-08-18 17:13:56', '1', '1', 'DelDict', '删除字典', '3', NULL, NULL, NULL, 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (71, 68, '2024-08-18 17:14:15', '2024-08-18 17:14:15', '1', '1', 'EditDict', '编辑字典', '3', NULL, NULL, '编辑字典', 'i-me:btn', '', 1, 1, NULL, NULL);
INSERT INTO `sys_resources` VALUES (72, 6, '2024-07-31 10:03:06', '2024-07-31 10:03:06', '1', '1', 'BusOrderMgt', '商城订单管理', '1', '/Demo/BusOrderMgt', '/src/views/demo/order/index.vue', '商城订单管理', 'i-fe:menu', '', 1, 1, 1, 0);
INSERT INTO `sys_resources` VALUES (73, 72, '2024-07-31 10:03:06', '2024-07-31 10:03:06', '1', '1', 'AddBusOrder', '创建按钮', '3', NULL, NULL, '创建商城订单按钮', 'i-me:btn', '', 1, 1, 0, 0);
INSERT INTO `sys_resources` VALUES (74, 72, '2024-07-31 10:03:06', '2024-07-31 10:03:06', '1', '1', 'EditBusOrder', '编辑按钮', '3', NULL, NULL, '编辑商城订单按钮', 'i-me:btn', '', 1, 1, 0, 0);
INSERT INTO `sys_resources` VALUES (75, 72, '2024-07-31 10:03:06', '2024-07-31 10:03:06', '1', '1', 'DelBusOrder', '删除按钮', '3', NULL, NULL, '删除商城订单按钮', 'i-me:btn', '', 1, 1, 0, 0);
INSERT INTO `sys_resources` VALUES (76, 6, '2024-07-31 10:03:46', '2024-07-31 10:03:46', '1', '1', 'BusTruckMgt', '车辆管理', '1', '/Demo/BusTruckMgt', '/src/views/demo/bustruck/index.vue', '车辆管理', 'i-fe:menu', '', 1, 1, 1, 0);
INSERT INTO `sys_resources` VALUES (77, 76, '2024-07-31 10:03:46', '2024-07-31 10:03:46', '1', '1', 'AddBusTruck', '创建按钮', '3', NULL, NULL, '创建车辆按钮', 'i-me:btn', '', 1, 1, 0, 0);
INSERT INTO `sys_resources` VALUES (78, 76, '2024-07-31 10:03:46', '2024-07-31 10:03:46', '1', '1', 'EditBusTruck', '编辑按钮', '3', NULL, NULL, '编辑车辆按钮', 'i-me:btn', '', 1, 1, 0, 0);
INSERT INTO `sys_resources` VALUES (79, 76, '2024-07-31 10:03:46', '2024-07-31 10:03:46', '1', '1', 'DelBusTruck', '删除按钮', '3', NULL, NULL, '删除车辆按钮', 'i-me:btn', '', 1, 1, 0, 0);
INSERT INTO `sys_resources` VALUES (1956935293160390656, 42, '2025-08-17 12:25:07', '2025-08-23 16:59:09', NULL, '1', 'ReprtD', '报表设计', '1', '/develop/report', '/src/views/develop/reportdesign/index.vue', NULL, 'i-fe:table', '', 1, 1, NULL, 1);
INSERT INTO `sys_resources` VALUES (1957304387617423360, 42, '2025-08-18 12:51:46', '2025-08-18 12:51:46', '1', '1', 'DataSourceMgt', '数据源管理', '1', '/dev/datasource', '/src/views/develop/datasource/index.vue', NULL, 'i-me:database', '', 1, 1, 1, 0);
INSERT INTO `sys_resources` VALUES (1961067429727567872, 2, '2025-08-28 22:04:45', '2025-08-28 22:04:45', '1', '1', 'NoticeMgt', '公告通知', '1', '/sys/notice', '/src/views/notice/index.vue', NULL, 'i-fe:message-circle', '', 1, 1, 1, -1);
INSERT INTO `sys_resources` VALUES (1961666674675417088, 2, '2025-08-30 13:45:56', '2025-08-30 13:46:51', '1', '1', 'organizationalMgt', '组织架构', '1', '/pms/organizational', '/src/views/pms/organizational/index.vue', NULL, 'i-me:company', '', 1, 1, 1, 0);
INSERT INTO `sys_resources` VALUES (1965222813082058752, 9, '2025-09-09 09:16:45', '2025-09-09 18:03:31', '1', '1', 'websocket', 'websocket', '1', '/base/socket', '/src/views/demo/websocket/index.vue', NULL, 'i-me:long-connection', '', 1, 1, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                             `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                             `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                             `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                             `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
                             `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名',
                             `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
                             `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
                             `enable` tinyint NULL DEFAULT NULL COMMENT '启用状态',
                             `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色编码',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '2024-07-15 22:28:58', '2024-07-23 01:40:10', NULL, NULL, '超级管理员', '超级管理员拥有所有权限', 'i-me:superadmin', 1, 'SUPER_ADMIN');
INSERT INTO `sys_role` VALUES (2, '2024-07-17 10:43:07', '2024-07-25 23:08:49', NULL, '1', '业务员', '测试实施', 'i-me:role', 1, 'TESt');
INSERT INTO `sys_role` VALUES (3, '2024-07-17 12:10:21', '2024-07-25 23:08:48', NULL, '1', '操作员', '设备操作员', 'i-fe:user', 1, 'ttt');
INSERT INTO `sys_role` VALUES (7, '2024-07-22 10:37:46', '2024-07-31 00:48:33', NULL, '1', '平台管理员', '普通管理员', 'i-me:superadmin', 1, 'PTADMIN');
INSERT INTO `sys_role` VALUES (8, '2024-07-22 16:08:12', '2024-07-23 01:07:39', NULL, NULL, '订单审核员', '进行订单审核的人员', 'i-me:role', 1, 'DDSHENHE');
INSERT INTO `sys_role` VALUES (9, '2024-07-23 01:42:20', '2024-07-25 23:07:43', NULL, '1', '系统功能测试员', '研发部测试人员0000', 'i-me:role', 1, 'TESTgcs');

-- ----------------------------
-- Table structure for sys_role_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resources`;
CREATE TABLE `sys_role_resources`  (
                                       `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                                       `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                       `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                       `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                                       `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
                                       `role_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色id',
                                       `resources_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源|权限 Id',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 414 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统角色权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_resources
-- ----------------------------
INSERT INTO `sys_role_resources` VALUES (66, '2024-07-23 01:07:39', '2024-07-23 01:07:39', NULL, NULL, '8', '2');
INSERT INTO `sys_role_resources` VALUES (67, '2024-07-23 01:07:39', '2024-07-23 01:07:39', NULL, NULL, '8', '1');
INSERT INTO `sys_role_resources` VALUES (68, '2024-07-23 01:07:39', '2024-07-23 01:07:39', NULL, NULL, '8', '4');
INSERT INTO `sys_role_resources` VALUES (69, '2024-07-23 01:07:39', '2024-07-23 01:07:39', NULL, NULL, '8', '13');
INSERT INTO `sys_role_resources` VALUES (97, '2024-07-24 10:49:06', '2024-07-24 10:49:06', '1', '1', '9', '2');
INSERT INTO `sys_role_resources` VALUES (98, '2024-07-24 14:43:07', '2024-07-24 14:43:07', '1', '1', '3', '13');
INSERT INTO `sys_role_resources` VALUES (99, '2024-07-24 14:43:07', '2024-07-24 14:43:07', '1', '1', '3', '9');
INSERT INTO `sys_role_resources` VALUES (100, '2024-07-24 14:43:07', '2024-07-24 14:43:07', '1', '1', '3', '8');
INSERT INTO `sys_role_resources` VALUES (101, '2024-07-24 14:43:07', '2024-07-24 14:43:07', '1', '1', '3', '3');
INSERT INTO `sys_role_resources` VALUES (102, '2024-07-24 14:43:07', '2024-07-24 14:43:07', '1', '1', '3', '1');
INSERT INTO `sys_role_resources` VALUES (388, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '6');
INSERT INTO `sys_role_resources` VALUES (389, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '32');
INSERT INTO `sys_role_resources` VALUES (390, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '13');
INSERT INTO `sys_role_resources` VALUES (391, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '26');
INSERT INTO `sys_role_resources` VALUES (392, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '25');
INSERT INTO `sys_role_resources` VALUES (393, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '24');
INSERT INTO `sys_role_resources` VALUES (394, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '8');
INSERT INTO `sys_role_resources` VALUES (395, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '29');
INSERT INTO `sys_role_resources` VALUES (396, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '39');
INSERT INTO `sys_role_resources` VALUES (397, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '2');
INSERT INTO `sys_role_resources` VALUES (398, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '37');
INSERT INTO `sys_role_resources` VALUES (399, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '38');
INSERT INTO `sys_role_resources` VALUES (400, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '36');
INSERT INTO `sys_role_resources` VALUES (401, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '35');
INSERT INTO `sys_role_resources` VALUES (402, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '27');
INSERT INTO `sys_role_resources` VALUES (403, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '3');
INSERT INTO `sys_role_resources` VALUES (404, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '1');
INSERT INTO `sys_role_resources` VALUES (405, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '30');
INSERT INTO `sys_role_resources` VALUES (406, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '28');
INSERT INTO `sys_role_resources` VALUES (407, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '4');
INSERT INTO `sys_role_resources` VALUES (408, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '31');
INSERT INTO `sys_role_resources` VALUES (409, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '33');
INSERT INTO `sys_role_resources` VALUES (410, '2024-07-31 00:48:33', '2024-07-31 00:48:33', '1', '1', '7', '34');

-- ----------------------------
-- Table structure for sys_setting
-- ----------------------------
DROP TABLE IF EXISTS `sys_setting`;
CREATE TABLE `sys_setting`  (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                                `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                                `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统设置表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_setting
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
                             `id` bigint NOT NULL COMMENT '自增主键',
                             `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                             `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                             `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                             `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
                             `organization_id` bigint NULL DEFAULT NULL COMMENT '所属组织id',
                             `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录账号',
                             `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             `gender` tinyint NULL DEFAULT NULL,
                             `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             `last_login_time` datetime NULL DEFAULT NULL,
                             `enable` tinyint NULL DEFAULT NULL,
                             PRIMARY KEY (`id`, `account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '2024-07-15 21:46:49', '2024-07-28 15:42:58', NULL, '1', 1961811583873056768, '宇宙无敌的高手555', 'admin', 'eb7bf5a85ac5de5de478ad57bda53bbd6f97233546e8c7e8f448e70cde94de54', '2ztkxntw', 1, '17685306042', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', '超级管理员拥有系统全部权限', '2024-07-16 16:44:05', 1);
INSERT INTO `sys_user` VALUES (6, '2024-07-22 10:23:30', '2024-07-25 23:05:24', NULL, '1', 1961811583873056768, '王老五', 'wlwu', 'eb7bf5a85ac5de5de478ad57bda53bbd6f97233546e8c7e8f448e70cde94de54', '2ztkxntw', 0, NULL, 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (7, '2024-07-22 10:24:00', '2024-07-25 23:05:40', NULL, '1', 1961811583873056768, '李四', '9她发给对方', 'eb7bf5a85ac5de5de478ad57bda53bbd6f97233546e8c7e8f448e70cde94de54', '2ztkxntw', 0, NULL, 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (8, '2024-07-22 10:24:36', '2024-07-25 23:06:01', NULL, '1', 1961811583873056768, 'java高手', 'jwgs12', 'eb7bf5a85ac5de5de478ad57bda53bbd6f97233546e8c7e8f448e70cde94de54', '2ztkxntw', 0, NULL, 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (9, '2024-07-22 10:25:03', '2024-07-25 23:06:02', NULL, '1', 1961811583873056768, '324', 'hy', 'eb7bf5a85ac5de5de478ad57bda53bbd6f97233546e8c7e8f448e70cde94de54', '2ztkxntw', 0, NULL, 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (10, '2024-07-22 10:32:13', '2024-07-25 23:06:04', NULL, '1', 1961811583873056768, 'HuangZy最帅', 'hyl8980', 'eb7bf5a85ac5de5de478ad57bda53bbd6f97233546e8c7e8f448e70cde94de54', '2ztkxntw', 0, NULL, 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (11, '2024-07-22 10:40:39', '2025-08-18 16:07:52', NULL, '1', 1961811583873056768, 'zy无敌帅', '23234230900', 'eb7bf5a85ac5de5de478ad57bda53bbd6f97233546e8c7e8f448e70cde94de54', '2ztkxntw', 1, NULL, 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (12, '2024-07-22 11:39:00', '2024-07-25 23:06:06', NULL, '1', 1961811583873056768, '韩信', 'hanxin', 'eb7bf5a85ac5de5de478ad57bda53bbd6f97233546e8c7e8f448e70cde94de54', '2ztkxntw', 0, NULL, 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (13, '2024-07-22 11:42:05', '2024-07-25 23:06:07', NULL, '1', 1961811583873056768, '赵云', 'zhaoyun', 'eb7bf5a85ac5de5de478ad57bda53bbd6f97233546e8c7e8f448e70cde94de54', '2ztkxntw', 1, NULL, 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (14, '2024-07-22 11:43:37', '2025-05-07 16:32:00', NULL, '1', 1961811583873056768, '赵信', 'zx121212', '3b35ea3514d460a379d837d9f22a800f990045faf0e7b88af48a8c5cd87435de', 'qiv9vc0b', 1, NULL, 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (15, '2024-07-22 14:56:42', '2024-07-25 23:06:17', NULL, '1', 1961819067719352320, '王二小', 'wex', 'eb7bf5a85ac5de5de478ad57bda53bbd6f97233546e8c7e8f448e70cde94de54', '2ztkxntw', 1, NULL, 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (16, '2024-07-23 19:13:25', '2024-07-25 23:06:15', NULL, '1', 1961819067719352320, '德莱厄斯', 'delaies', 'eb7bf5a85ac5de5de478ad57bda53bbd6f97233546e8c7e8f448e70cde94de54', '2ztkxntw', 0, NULL, 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (17, '2024-07-24 14:46:16', '2024-07-25 23:06:14', '1', '1', 1961819067719352320, '起重机操作员2号', 'hzy0318', 'd61488d9883af097dfb0313c95082f91dbad8deaa8d1c60be1fda9cb2a677d45', 'q0lf117d', 0, NULL, 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (18, '2024-07-25 11:01:24', '2024-07-25 23:06:13', '1', '1', 1961819067719352320, '花木兰', 'huamul', '0971779f8e00c4b59d81097df6eadadcdb08f05fc36efd8d62eab3676eb5a8ff', '5t2tv3zj', 0, NULL, 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (19, '2024-07-25 11:01:44', '2024-07-25 23:06:13', '1', '1', 1961819067719352320, '悟空', 'wukong', '0415561d60d9cd991dd9c6317f2a67ec53576cd3e01bd51e877882c8c8105628', 'mbbj6j84', 0, NULL, 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (20, '2024-07-25 11:05:25', '2024-07-25 11:10:42', '1', '1', 1961819067719352320, '钟馗', 'zhongkui', '708dbac3c15824031d7fe1cfd5d15bdea9c359ba6d056d62e603e3a74ce37b45', '0ssyh8y8', 0, NULL, 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (21, '2024-07-25 11:10:20', '2024-07-25 11:10:20', '1', '1', 1961819067719352320, '李白', 'libai', 'c9feb63af3a94086a7b7d5ccfa828968f805e54a0458b341627e66aa8ebb256e', 'yv6vz1sm', 0, NULL, 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (22, '2024-07-25 11:30:23', '2024-07-25 11:52:52', '1', '22', 1961819067719352320, '普通管理员', 'ptadmin', 'd18c63a0924c11224b9dab0c012ffd23ec49d6c40e0d6ff40e0a33dc39681d65', 'jt7pmvh1', 0, '16687590876', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', '业务管理员', NULL, 1);
INSERT INTO `sys_user` VALUES (23, '2025-07-30 23:06:55', '2025-07-30 23:06:55', NULL, NULL, 1961819067719352320, '7878', 'xxxxxxx45454', 'dfsdfsdfsdfsd', NULL, 1, '17685306043', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (24, '2025-07-30 23:08:40', '2025-07-30 23:08:40', NULL, NULL, 1961811583873056768, '7878', 'xxxxxxx45454', 'dfsdfsdfsdfsd', NULL, 1, '17685306043', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (1950580430986018816, '2025-07-30 23:33:16', '2025-07-30 23:33:16', NULL, NULL, 1961818974295425024, '7878', 'xxxxxxx45454', 'dfsdfsdfsdfsd', NULL, 1, '17685306043', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (1951299613977739264, '2025-08-01 23:11:03', '2025-08-01 23:11:03', NULL, NULL, 1961818974295425024, '7878', 'xxxxxxx45454', 'dfsdfsdfsdfsd', NULL, 1, '17685306043', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (1951300416163545088, '2025-08-01 23:14:07', '2025-08-01 23:14:07', NULL, NULL, 1961818974295425024, '7878', 'xxxxxxx45454', 'dfsdfsdfsdfsd', NULL, 1, '17685306043', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (1951301892227203072, '2025-08-01 23:19:59', '2025-08-01 23:19:59', NULL, NULL, 1961818974295425024, '7878', 'xxxxxxx45454', 'dfsdfsdfsdfsd', NULL, 1, '17685306043', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (1951311553856798720, '2025-08-01 23:58:23', '2025-08-01 23:58:23', NULL, NULL, 1961818974295425024, '7878', 'xxxxxxx45454', 'dfsdfsdfsdfsd', NULL, 1, '17685306043', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (1951311556855726080, '2025-08-01 23:58:23', '2025-08-01 23:58:23', NULL, NULL, 1961818974295425024, '7878', 'xxxxxxx45454', 'dfsdfsdfsdfsd', NULL, 1, '17685306043', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (1951311558462144512, '2025-08-01 23:58:24', '2025-08-01 23:58:24', NULL, NULL, 1961818974295425024, '7878', 'xxxxxxx45454', 'dfsdfsdfsdfsd', NULL, 1, '17685306043', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (1951311700531609600, '2025-08-01 23:58:58', '2025-08-01 23:58:58', NULL, NULL, 1961818974295425024, '7878', 'xxxxxxx45454', 'dfsdfsdfsdfsd', NULL, 1, '17685306043', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (1951311702918168576, '2025-08-01 23:58:58', '2025-08-01 23:58:58', NULL, NULL, 1961818974295425024, '7878', 'xxxxxxx45454', 'dfsdfsdfsdfsd', NULL, 1, '17685306043', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (1951311704486838272, '2025-08-01 23:58:59', '2025-08-01 23:58:59', NULL, NULL, 1961818974295425024, '7878', 'xxxxxxx45454', 'dfsdfsdfsdfsd', NULL, 1, '17685306043', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (1951311705631883264, '2025-08-01 23:58:59', '2025-08-01 23:58:59', NULL, NULL, 1961818974295425024, '7878', 'xxxxxxx45454', 'dfsdfsdfsdfsd', NULL, 1, '17685306043', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (1951311738074824704, '2025-08-01 23:59:07', '2025-08-01 23:59:07', NULL, NULL, 1961818974295425024, '7878', 'xxxxxxx45454', 'dfsdfsdfsdfsd', NULL, 1, '17685306043', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (1951312144884563968, '2025-08-02 00:00:44', '2025-08-02 00:00:44', NULL, NULL, 1961818974295425024, '7878', 'xxxxxxx45454', 'dfsdfsdfsdfsd', NULL, 1, '17685306043', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);
INSERT INTO `sys_user` VALUES (1951315654149668864, '2025-08-02 00:14:40', '2025-08-02 00:14:40', NULL, NULL, 1961818974295425024, '7878', 'xxxxxxx45454', 'dfsdfsdfsdfsd', NULL, 1, '17685306043', 'https://avatars.githubusercontent.com/u/46741470?v=4&size=256', NULL, NULL, 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                                  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                  `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                                  `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
                                  `role_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色id',
                                  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户id',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (14, '2024-07-22 10:32:13', '2024-07-22 10:32:13', NULL, NULL, '3', '10');
INSERT INTO `sys_user_role` VALUES (15, '2024-07-22 10:32:13', '2024-07-22 10:32:13', NULL, NULL, '2', '10');
INSERT INTO `sys_user_role` VALUES (19, '2024-07-22 11:43:37', '2024-07-22 11:43:37', NULL, NULL, '3', '14');
INSERT INTO `sys_user_role` VALUES (22, '2024-07-22 16:23:41', '2024-07-22 16:23:41', NULL, NULL, '8', '6');
INSERT INTO `sys_user_role` VALUES (24, '2024-07-22 16:28:39', '2024-07-22 16:28:39', NULL, NULL, '8', '8');
INSERT INTO `sys_user_role` VALUES (25, '2024-07-22 16:28:39', '2024-07-22 16:28:39', NULL, NULL, '8', '9');
INSERT INTO `sys_user_role` VALUES (26, '2024-07-22 16:28:39', '2024-07-22 16:28:39', NULL, NULL, '8', '10');
INSERT INTO `sys_user_role` VALUES (27, '2024-07-22 16:28:39', '2024-07-22 16:28:39', NULL, NULL, '8', '11');
INSERT INTO `sys_user_role` VALUES (28, '2024-07-22 16:28:39', '2024-07-22 16:28:39', NULL, NULL, '8', '12');
INSERT INTO `sys_user_role` VALUES (30, '2024-07-22 16:28:39', '2024-07-22 16:28:39', NULL, NULL, '8', '14');
INSERT INTO `sys_user_role` VALUES (31, '2024-07-22 16:28:39', '2024-07-22 16:28:39', NULL, NULL, '8', '15');
INSERT INTO `sys_user_role` VALUES (34, '2024-07-23 19:13:25', '2024-07-23 19:13:25', NULL, NULL, '9', '16');
INSERT INTO `sys_user_role` VALUES (36, '2024-07-24 14:40:35', '2024-07-24 14:40:35', '1', '1', '1', '1');
INSERT INTO `sys_user_role` VALUES (38, '2024-07-24 14:46:37', '2024-07-24 14:46:37', '1', '1', '2', '17');
INSERT INTO `sys_user_role` VALUES (39, '2024-07-25 11:01:24', '2024-07-25 11:01:24', '1', '1', '3', '18');
INSERT INTO `sys_user_role` VALUES (40, '2024-07-25 11:01:44', '2024-07-25 11:01:44', '1', '1', '8', '19');
INSERT INTO `sys_user_role` VALUES (41, '2024-07-25 11:05:25', '2024-07-25 11:05:25', '1', '1', '9', '20');
INSERT INTO `sys_user_role` VALUES (42, '2024-07-25 11:10:21', '2024-07-25 11:10:21', '1', '1', '3', '21');
INSERT INTO `sys_user_role` VALUES (43, '2024-07-25 11:30:23', '2024-07-25 11:30:23', '1', '1', '7', '22');
INSERT INTO `sys_user_role` VALUES (44, '2025-06-09 16:25:36', '2025-06-09 16:25:36', '1', '1', '8', '7');
INSERT INTO `sys_user_role` VALUES (45, '2025-06-09 16:25:36', '2025-06-09 16:25:36', '1', '1', '2', '7');

-- ----------------------------
-- Table structure for sys_user_setting
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_setting`;
CREATE TABLE `sys_user_setting`  (
                                     `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                                     `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                     `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                     `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                                     `layout_mode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '布局方式',
                                     `theme` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主题',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户个人设置表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_setting
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
