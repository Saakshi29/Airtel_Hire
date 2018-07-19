-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: world
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt

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
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `submissions`
--

DROP TABLE IF EXISTS `submissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `submissions` (
  `subid` int(11) NOT NULL auto_increment,
  `id` int(11) default NULL,
  `pid` int(11) default NULL,
  `ftype` text,
  `filename` text,
  `answer` varchar(255) default NULL,
  `questionnaireid` int(11) default NULL,
  `qid` int(11) default NULL,
  `type` varchar(255) default NULL,
  PRIMARY KEY  (`subid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submissions`
--

LOCK TABLES `submissions` WRITE;
/*!40000 ALTER TABLE `submissions` DISABLE KEYS */;
INSERT INTO `submissions` VALUES (1,2,1,'docx','C:\\uploadsmapindex.docx',NULL,NULL,NULL,NULL),(2,2,3,'docx','C:\\uploads/mapindex.docx',NULL,NULL,NULL,NULL),(3,2,4,'docx','C:\\uploads\\mapindex.docx',NULL,NULL,NULL,NULL),(4,2,5,'jpg','C:\\uploads\\asr.jpg',NULL,NULL,NULL,NULL),(7,29,3,'txt','C:\\uploads\\AnshulMehta.txt',NULL,NULL,NULL,NULL),(8,29,4,'txt','C:\\uploads\\AnshulMehta.txt',NULL,NULL,NULL,NULL),(9,29,5,'txt','C:\\uploads\\AnshulMehta.txt',NULL,NULL,NULL,NULL),(10,29,6,'txt','C:\\uploads\\AnshulMehta.txt',NULL,NULL,NULL,NULL),(12,1,3,'jpg','C:\\uploads\\asr.jpg',NULL,NULL,NULL,NULL),(13,2,4,'jpg','C:\\uploads\\asr.jpg',NULL,NULL,NULL,NULL),(14,2,5,'jpg','C:\\uploads\\asr.jpg',NULL,NULL,NULL,NULL),(15,3,5,'jpg','C:\\uploads\\3_5',NULL,NULL,NULL,NULL),(16,4,5,'jpg','C:\\uploads\\4-5',NULL,NULL,NULL,NULL),(17,4,6,'txt','C:\\uploads\\4-6',NULL,NULL,NULL,NULL),(18,29,7,'txt','C:\\uploads\\29-7',NULL,NULL,NULL,NULL),(19,27,1,'txt','C:\\uploads\\27-1',NULL,NULL,NULL,NULL),(20,1,NULL,NULL,NULL,'djkjdk',5,NULL,NULL),(21,2,NULL,NULL,NULL,'abc',4,NULL,NULL),(68,27,NULL,NULL,NULL,'1',5,35,'questionnaire'),(69,27,NULL,NULL,NULL,'true',5,36,'questionnaire'),(70,27,NULL,NULL,NULL,'nm',5,37,'questionnaire'),(71,32,NULL,NULL,NULL,'sad',8,45,'questionnaire'),(72,27,NULL,NULL,NULL,'test subjectiv',14,63,'questionnaire'),(73,27,NULL,NULL,NULL,'1',15,64,'questionnaire'),(74,27,NULL,NULL,NULL,'Hey tes',16,67,'questionnaire'),(75,27,NULL,NULL,NULL,'he',18,68,'questionnaire'),(76,27,NULL,NULL,NULL,'HE',19,70,'questionnaire'),(77,27,NULL,NULL,NULL,'1',19,71,'questionnaire');
/*!40000 ALTER TABLE `submissions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-15 15:16:26
