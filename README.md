


## 数据库表设计
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES (1, '人事部', '综合楼');
INSERT INTO `department` VALUES (2, '外交部', '北京');
COMMIT;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `opr_time` datetime NOT NULL,
  `type` varchar(10) NOT NULL,
  `operator` varchar(20) NOT NULL,
  `moudle` varchar(20) NOT NULL,
  `operation` varchar(20) NOT NULL,
  `result` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
BEGIN;
INSERT INTO `log` VALUES ('2018-09-19 23:13:15', 'login', 'geek', 'SelfController', 'login', '成功');
INSERT INTO `log` VALUES ('2018-09-19 23:13:19', 'operation', 'geek', 'LogController', 'systemLog', '成功');
INSERT INTO `log` VALUES ('2018-09-19 23:13:20', 'operation', 'geek', 'LogController', 'loginLog', '成功');
INSERT INTO `log` VALUES ('2018-09-19 23:13:24', 'operation', 'geek', 'StaffController', 'list', '成功');
INSERT INTO `log` VALUES ('2018-09-19 23:13:33', 'operation', 'geek', 'StaffController', 'edit', '成功');
INSERT INTO `log` VALUES ('2018-09-19 23:13:33', 'operation', 'geek', 'StaffController', 'list', '成功');
INSERT INTO `log` VALUES ('2018-09-19 23:13:35', 'operation', 'geek', 'LogController', 'operationLog', '成功');
INSERT INTO `log` VALUES ('2018-09-19 23:13:45', 'operation', 'geek', 'LogController', 'loginLog', '成功');
INSERT INTO `log` VALUES ('2018-09-19 23:13:47', 'operation', 'geek', 'LogController', 'systemLog', '成功');
INSERT INTO `log` VALUES ('2018-09-19 23:13:48', 'operation', 'geek', 'LogController', 'operationLog', '成功');
INSERT INTO `log` VALUES ('2018-09-19 23:13:50', 'operation', 'geek', 'DepartmentController', 'list', '成功');
INSERT INTO `log` VALUES ('2018-09-19 23:13:51', 'operation', 'geek', 'StaffController', 'list', '成功');
INSERT INTO `log` VALUES ('2018-09-19 23:13:55', 'operation', 'geek', 'LogController', 'operationLog', '成功');
INSERT INTO `log` VALUES ('2018-09-19 23:14:02', 'operation', 'geek', 'StaffController', 'list', '成功');
INSERT INTO `log` VALUES ('2018-09-19 23:14:03', 'operation', 'geek', 'DepartmentController', 'list', '成功');
INSERT INTO `log` VALUES ('2018-09-19 23:14:06', 'operation', 'geek', 'LogController', 'operationLog', '成功');
INSERT INTO `log` VALUES ('2018-09-20 15:45:17', 'login', 'geek', 'SelfController', 'login', '成功');
INSERT INTO `log` VALUES ('2018-09-20 15:45:38', 'operation', 'geek', 'StaffController', 'list', '成功');
INSERT INTO `log` VALUES ('2018-09-20 15:46:27', 'operation', 'geek', 'DepartmentController', 'list', '成功');
INSERT INTO `log` VALUES ('2018-09-20 15:46:42', 'operation', 'geek', 'LogController', 'operationLog', '成功');
INSERT INTO `log` VALUES ('2018-09-20 15:47:01', 'operation', 'geek', 'LogController', 'loginLog', '成功');
INSERT INTO `log` VALUES ('2018-09-20 15:47:15', 'operation', 'geek', 'LogController', 'systemLog', '成功');
COMMIT;

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL,
  `did` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `id_number` char(18) DEFAULT NULL,
  `work_time` datetime DEFAULT NULL,
  `leave_time` datetime DEFAULT NULL,
  `born_date` date DEFAULT NULL,
  `info` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
BEGIN;
INSERT INTO `staff` VALUES (1, 'geek', '111111', '1', 1, 'geekerstar', '男', '38424923482', '2018-09-19 22:48:46', '2018-09-19 22:48:51', '2018-09-12', NULL);
INSERT INTO `staff` VALUES (2, 'hehe', '123456', '正常', 1, '哈哈', '男', '3242343534534', '2018-09-19 22:50:15', NULL, '2010-04-02', '213231');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;





## 图片展示
![Image text](https://github.com/geekerstar/sm/blob/master/pic/1.jpg)
![Image text](https://github.com/geekerstar/sm/blob/master/pic/2.jpg)
![Image text](https://github.com/geekerstar/sm/blob/master/pic/3.jpg)
![Image text](https://github.com/geekerstar/sm/blob/master/pic/4.jpg)
![Image text](https://github.com/geekerstar/sm/blob/master/pic/5.jpg)
![Image text](https://github.com/geekerstar/sm/blob/master/pic/6.jpg)
![Image text](https://github.com/geekerstar/sm/blob/master/pic/7.jpg)
![Image text](https://github.com/geekerstar/sm/blob/master/pic/8.jpg)

