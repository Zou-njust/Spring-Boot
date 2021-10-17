-- MySQL dump 10.13  Distrib 5.7.34, for Win64 (x86_64)
--
-- Host: localhost    Database: intention
-- ------------------------------------------------------
-- Server version	5.7.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `field_mean`
--

DROP TABLE IF EXISTS `field_mean`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `field_mean` (
  `ID` int(11) DEFAULT NULL,
  `FIELD` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `mean` varchar(20) DEFAULT NULL,
  `TABLE_NAME` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `field_mean`
--

LOCK TABLES `field_mean` WRITE;
/*!40000 ALTER TABLE `field_mean` DISABLE KEYS */;
INSERT INTO `field_mean` VALUES (82,'ID','编号','LABEL_USER_FOCUS'),(83,'LABEL_INFO_ID','标签编号','LABEL_USER_FOCUS'),(71,'ID','编号','RELATION_INFO'),(72,'RELATION','关系','RELATION_INFO'),(78,'ID','ID','FIELD_MEAN'),(79,'FIELD','FIELD','FIELD_MEAN'),(80,'MEAN','MEAN','FIELD_MEAN'),(81,'TABLE_NAME','表名','FIELD_MEAN'),(84,'ID','ID','BUILD_RELATION'),(85,'CREATE_DATE','创建日期','BUILD_RELATION'),(86,'RELATION','RELATION','BUILD_RELATION'),(87,'TABLE_HEAD','TABLE_HEAD','BUILD_RELATION'),(88,'TABLE_TAIL','TABLE_TAIL','BUILD_RELATION'),(89,'UUID','UUID','BUILD_RELATION'),(90,'ID','ID','DATA_BASE'),(91,'NAME','名字','DATA_BASE'),(73,'ID','编号','LABEL_INFO'),(74,'COLOR','标签颜色','LABEL_INFO'),(75,'NATURE','词性','LABEL_INFO'),(76,'NATURE_NAME','词性名称','LABEL_INFO'),(77,'TYPE','类型','LABEL_INFO');
/*!40000 ALTER TABLE `field_mean` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_gl_trackline`
--

DROP TABLE IF EXISTS `t_gl_trackline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_gl_trackline` (
  `id` varchar(20) NOT NULL DEFAULT '11' COMMENT '标识',
  `target_id` varchar(200) DEFAULT NULL COMMENT '目标标识',
  `target_sort` varchar(50) DEFAULT NULL COMMENT '目标类别',
  `name` varchar(40) DEFAULT NULL COMMENT '航线名称',
  `takeoff_airport_id` varchar(40) DEFAULT NULL COMMENT '起飞机场',
  `landing_airport_id` varchar(40) DEFAULT NULL COMMENT '降落机场',
  `task_action_area_id` varchar(40) DEFAULT NULL COMMENT 'RW活动区域编号',
  `save_path` varchar(200) DEFAULT NULL COMMENT '活动规律存储路径',
  `import_time` varchar(100) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_gl_trackline`
--

LOCK TABLES `t_gl_trackline` WRITE;
/*!40000 ALTER TABLE `t_gl_trackline` DISABLE KEYS */;
INSERT INTO `t_gl_trackline` VALUES ('1','2','41','A57','62','44','55','/model/save','2021-09-17 16:56:24');
/*!40000 ALTER TABLE `t_gl_trackline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_yp_target_recog`
--

DROP TABLE IF EXISTS `t_yp_target_recog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_yp_target_recog` (
  `id` varchar(20) NOT NULL DEFAULT '11' COMMENT '研判结果id',
  `target_id` varchar(20) DEFAULT NULL COMMENT '目标批号',
  `target_type` tinyint(4) DEFAULT NULL COMMENT '目标类别\r\n（0：ZC机\r\n1：Z斗机\r\n2：HZ机\r\n3：预警机\r\n4：民航\r\n255:其他）\r\n',
  `point_id` varchar(20) DEFAULT NULL COMMENT '当前航点号',
  `aircraft_id` varchar(20) DEFAULT NULL COMMENT '目标编号',
  `target_name` varchar(50) DEFAULT NULL COMMENT '目标名称',
  `judge_means` tinyint(4) DEFAULT NULL COMMENT '研判手段（0：属性研判\r\n1：活动规律研判\r\n2：Z术Z法研判\r\n3：DC特征研判\r\n4：综合研判\r\n5：人工判证\r\n255：其他）\r\n',
  `probability` tinyint(4) DEFAULT NULL COMMENT '研判概率',
  `import_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_yp_target_recog`
--

LOCK TABLES `t_yp_target_recog` WRITE;
/*!40000 ALTER TABLE `t_yp_target_recog` DISABLE KEYS */;
INSERT INTO `t_yp_target_recog` VALUES ('1','2',33,'42','44','A-57',1,1,'2021-09-17 20:14:42'),('11',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `t_yp_target_recog` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-05 22:36:39
