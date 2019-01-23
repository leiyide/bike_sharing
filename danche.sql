/*
SQLyog Ultimate v8.32 
MySQL - 5.6.19 : Database - bikeshare
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bikeshare` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bikeshare`;

/*Table structure for table `t_bike` */

DROP TABLE IF EXISTS `t_bike`;

CREATE TABLE `t_bike` (
  `bike_id` int(20) NOT NULL AUTO_INCREMENT,
  `bike_generationNum` int(10) DEFAULT NULL,
  `bike_password` int(10) DEFAULT NULL,
  `bike_useNum` int(20) DEFAULT NULL,
  `bike_isUsing` int(5) DEFAULT NULL,
  `bike_area` varchar(20) DEFAULT NULL,
  `bike_isUse` int(5) DEFAULT NULL,
  PRIMARY KEY (`bike_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `t_bike` */

insert  into `t_bike`(`bike_id`,`bike_generationNum`,`bike_password`,`bike_useNum`,`bike_isUsing`,`bike_area`,`bike_isUse`) values (1,1,1421,NULL,0,'南昌',1),(2,1,1524,NULL,0,'南昌',1),(3,1,2456,NULL,0,'南昌',1),(4,1,2564,NULL,0,'南昌',1),(5,1,2568,NULL,0,'南昌',1),(6,1,5689,NULL,0,'南昌',1),(7,1,5692,NULL,0,'南昌',1),(8,1,5698,NULL,0,'南昌',1),(9,1,8595,NULL,0,'南昌',1),(10,1,5210,NULL,0,'南昌',1),(11,1,2563,NULL,0,'南昌',1),(12,1,2562,NULL,0,'南昌',1),(13,1,2565,NULL,0,'南昌',1),(14,2,5692,NULL,0,'南昌',1),(15,2,9630,NULL,0,'南昌',1),(16,2,1010,NULL,0,'南昌',1),(17,2,1012,NULL,0,'南昌',1),(18,2,1013,NULL,0,'南昌',1),(19,2,2563,NULL,0,'南昌',1),(20,2,5693,NULL,0,'南昌',1),(21,2,8695,NULL,0,'南昌',1),(22,2,8520,NULL,0,'南昌',1),(23,2,8521,NULL,0,'南昌',1),(24,3,8520,NULL,0,'南昌',1),(25,3,5410,NULL,0,'南昌',1),(26,3,3012,NULL,0,'南昌',1),(27,3,7412,NULL,0,'南昌',1),(28,3,8547,NULL,0,'南昌',1),(29,3,8563,NULL,0,'南昌',1),(30,3,6541,NULL,0,'南昌',1),(31,3,6935,NULL,0,'南昌',1),(32,3,3210,NULL,0,'南昌',1),(33,3,8541,NULL,0,'南昌',1),(34,3,1234,NULL,0,'南昌',1),(35,3,1456,NULL,0,'南昌',1);

/*Table structure for table `t_column` */

DROP TABLE IF EXISTS `t_column`;

CREATE TABLE `t_column` (
  `column_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '栏目权限id',
  `column_name` varchar(30) DEFAULT NULL COMMENT '权限的名称',
  `column_firstId` int(5) DEFAULT NULL COMMENT '一级栏目1',
  `column_url` varchar(20) DEFAULT NULL COMMENT 'url',
  `column_permissionId` int(5) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `t_column` */

insert  into `t_column`(`column_id`,`column_name`,`column_firstId`,`column_url`,`column_permissionId`) values (1,'位置',1,'map.jsp',1),(2,'骑行',1,NULL,2),(3,'选车',2,'selectbike.jsp',2),(4,'还车',2,NULL,2),(5,'查看',1,NULL,5),(6,'查看余额',2,NULL,5),(7,'查看订单',2,NULL,5),(8,'反馈',1,NULL,8),(9,'投诉',2,NULL,8),(10,'评论',2,NULL,8),(11,'报修',2,NULL,8),(12,'内容管理',1,NULL,12),(13,'新增单车',2,NULL,12),(14,'单车管理',2,NULL,12),(15,'查看',1,NULL,15),(16,'查看统计',2,NULL,15),(17,'维修管理',1,NULL,17),(18,'查看维修订单',2,NULL,17),(19,'处理维修订单',2,NULL,17),(20,'客服管理',1,NULL,20),(21,'查看投诉订单',2,NULL,20),(22,'处理投诉订单',2,NULL,20),(23,'当前位置',2,'map.jsp',1);

/*Table structure for table `t_complain` */

DROP TABLE IF EXISTS `t_complain`;

CREATE TABLE `t_complain` (
  `complain_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '客服处理订单id',
  `complain_ user_id` int(20) NOT NULL COMMENT '用户id',
  `complain_bike_id` int(20) NOT NULL COMMENT '单车id',
  `complain_bike _area` varchar(20) NOT NULL COMMENT '单车的区域',
  `complain_ info` varchar(20) NOT NULL COMMENT '投诉理由',
  PRIMARY KEY (`complain_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_complain` */

/*Table structure for table `t_employee` */

DROP TABLE IF EXISTS `t_employee`;

CREATE TABLE `t_employee` (
  `employee_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `employee_rank` int(5) DEFAULT NULL COMMENT '员工职务级别',
  `employee_name` varchar(20) DEFAULT NULL COMMENT '员工职务名称',
  `employee_sysName` varchar(20) DEFAULT NULL COMMENT '系统名称',
  `employee_phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `employee_email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `employee_idCard` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  `employee_password` varchar(20) DEFAULT NULL COMMENT '系统登录密码',
  `employee_isJob` int(5) DEFAULT NULL COMMENT '是否在职',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_employee` */

insert  into `t_employee`(`employee_id`,`employee_rank`,`employee_name`,`employee_sysName`,`employee_phone`,`employee_email`,`employee_idCard`,`employee_password`,`employee_isJob`) values (1,1,'root',NULL,'13207001362','1026938865@qq.com','123456789123456789','123456',1),(2,2,'service',NULL,'12345678912','123@qq.com','147852369789456123','123456',1),(3,3,'complain',NULL,'14785965232','159@qq.com','123789456963852741','123456',1);

/*Table structure for table `t_limite_role` */

DROP TABLE IF EXISTS `t_limite_role`;

CREATE TABLE `t_limite_role` (
  `limite_role_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '权限角色id',
  `column_id` int(20) DEFAULT NULL COMMENT '栏目id',
  `employee_rank` int(5) DEFAULT NULL COMMENT '员工职务级别',
  `user_rank` int(5) DEFAULT NULL COMMENT '用户标识',
  PRIMARY KEY (`limite_role_id`),
  KEY `FK_t_limite_role` (`user_rank`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_limite_role` */

insert  into `t_limite_role`(`limite_role_id`,`column_id`,`employee_rank`,`user_rank`) values (1,1,NULL,0),(2,2,NULL,0),(3,5,NULL,0),(4,8,NULL,0),(5,12,1,NULL),(6,15,1,NULL),(7,17,2,NULL),(8,20,3,NULL);

/*Table structure for table `t_record` */

DROP TABLE IF EXISTS `t_record`;

CREATE TABLE `t_record` (
  `record_id` int(20) DEFAULT NULL,
  `user_id` int(20) DEFAULT NULL,
  `bike_id` int(20) DEFAULT NULL,
  `start_date` varchar(20) DEFAULT NULL,
  `return_date` varchar(20) DEFAULT NULL,
  `payment` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_record` */

/*Table structure for table `t_service` */

DROP TABLE IF EXISTS `t_service`;

CREATE TABLE `t_service` (
  `service_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '维修id',
  `service _user_id` int(20) NOT NULL COMMENT '用户id',
  `service _bike_id` int(20) NOT NULL COMMENT '单车id',
  `service _bike _area` varchar(20) NOT NULL COMMENT '单车区域',
  `service_info` varchar(50) DEFAULT NULL COMMENT '单车故障信息',
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_service` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(20) DEFAULT NULL COMMENT '用户密码',
  `user_phoneNum` varchar(20) DEFAULT NULL COMMENT '用户手机号码',
  `user_email` varchar(20) DEFAULT NULL COMMENT '用户邮箱',
  `user_idCard` varchar(20) DEFAULT NULL COMMENT '用户身份证号码',
  `user_balance` int(10) DEFAULT NULL COMMENT '账户余额',
  `user_deposit` int(10) DEFAULT NULL COMMENT '押金',
  `user_comment` varchar(20) DEFAULT NULL COMMENT '备注',
  `user_rank` int(5) DEFAULT NULL COMMENT '员工级别（固定为0）',
  KEY `NewIndex1` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`user_id`,`user_name`,`user_password`,`user_phoneNum`,`user_email`,`user_idCard`,`user_balance`,`user_deposit`,`user_comment`,`user_rank`) values (1,'admin','123456','123456','admin@qq.com','123456789123456789',NULL,NULL,NULL,0),(2,'lantian','123456','123456','lantian@qq.com','147852369987456123',NULL,NULL,NULL,0),(37,'花花','123','13207001362','123456@qq.com','123456789741852963',NULL,NULL,NULL,0),(39,'伟大','123','123456','11@qq.com','123456789741258369',NULL,NULL,NULL,0),(40,'晓天','123','123456','123456@qq.com','147852963123456789',NULL,NULL,NULL,0),(41,'新春','123','123456','123456@qq.com','123456789789456123',NULL,NULL,NULL,0),(42,'梦想','111','123456','11@qq.com','145632987741258963',NULL,NULL,NULL,0),(43,'力量','111','123456','11@qq.com','111111111111111111',NULL,NULL,NULL,0),(44,'奋斗','111','123456','123456@qq.com','147852369741258963',NULL,NULL,NULL,0),(45,'你好啊 ','111','123456','123456789@qq.com','123456789789456123',NULL,NULL,NULL,0),(48,'原子','123','13207001362','123456@qq.com','123456789785412369',NULL,NULL,NULL,0),(49,'分子','123','123456','123456@qq.com','147852369789456123',NULL,NULL,NULL,0),(54,'天空','111','123456','1026938865@qq.com','123456789789789789',NULL,NULL,NULL,0),(55,'小米','111','123456','123456@qq.com','123456789789789789',NULL,NULL,NULL,0),(56,'爱好','123','123456','123456@qq.com','123456789741852963',NULL,NULL,NULL,0),(57,'中学','1','11','123456789@qq.com','147852369123456788',NULL,NULL,NULL,0),(60,'中心','123','123456','11@qq.com','147852369123456788',NULL,NULL,NULL,0),(61,'梦想','111111','123456','123456@qq.com','123456789456456456',NULL,NULL,NULL,0),(62,'膜拜','111','13207001362','11@qq.com','222222222222222222',NULL,NULL,NULL,0),(63,'小蓝','11','123456','123456@qq.com','111111111123456789',NULL,NULL,NULL,0),(84,'天蓝蓝','111111','13207001362','123456@qq.com','123456789789456789',NULL,NULL,NULL,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
