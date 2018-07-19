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
-- Table structure for table `scoreboard`
--

DROP TABLE IF EXISTS `scoreboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scoreboard` (
  `id` int(11) default NULL,
  `cid` int(11) default NULL,
  `pid` int(11) default NULL,
  `score` int(11) default NULL,
  `sid` int(11) NOT NULL auto_increment,
  `questionnaireid` int(11) default NULL,
  `qid` int(11) default NULL,
  PRIMARY KEY  (`sid`),
  KEY `pid_idx` (`pid`),
  KEY `cid_idx` (`cid`),
  KEY `id_idx` (`id`),
  KEY `cid_idx1` (`cid`,`id`),
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pid` FOREIGN KEY (`pid`) REFERENCES `problems` (`pid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scoreboard`
--

LOCK TABLES `scoreboard` WRITE;
/*!40000 ALTER TABLE `scoreboard` DISABLE KEYS */;
INSERT INTO `scoreboard` VALUES (2,1,1,80,1,NULL,NULL),(1,1,1,75,2,NULL,NULL),(29,2,1,70,3,NULL,NULL),(2,1,2,40,4,NULL,NULL),(1,1,2,50,5,NULL,NULL),(2,2,3,60,6,NULL,NULL),(1,2,3,90,7,NULL,NULL),(2,3,4,50,8,NULL,NULL),(29,7,7,67,15,NULL,NULL),(29,7,6,12,16,NULL,NULL),(4,7,6,45,17,NULL,NULL),(2,7,5,56,18,NULL,NULL),(29,3,4,25,20,NULL,NULL),(1,NULL,NULL,5,24,5,35),(1,NULL,NULL,5,25,5,36),(1,NULL,NULL,5,26,5,37),(27,NULL,NULL,5,53,5,35),(27,NULL,NULL,5,54,5,36),(27,NULL,NULL,0,55,5,37),(27,2,1,18,56,NULL,NULL),(32,NULL,NULL,0,57,8,45),(29,1,3,50,58,NULL,NULL),(27,NULL,NULL,NULL,59,14,63),(27,NULL,NULL,0,60,15,64),(27,NULL,NULL,NULL,61,16,67),(27,NULL,NULL,5,62,18,68),(27,NULL,NULL,10,63,19,70),(27,NULL,NULL,20,64,19,71);
/*!40000 ALTER TABLE `scoreboard` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-15 15:16:23
