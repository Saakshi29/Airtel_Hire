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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment,
  `uname` varchar(100) default NULL,
  `password` varchar(100) default NULL,
  `emailid` varchar(100) default NULL,
  `phone_number` varchar(100) default NULL,
  `resume` varchar(100) default NULL,
  `collegename` varchar(100) default NULL,
  `degree` varchar(100) default NULL,
  `year` varchar(100) default NULL,
  `specialization` varchar(255) default NULL,
  `type` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'rahul',NULL,NULL,'89889809','C:\\resumeupload\\resume-1','DTU',NULL,NULL,NULL,'generic'),(2,'anshika','12345678','anshika@gmail.com','908878788','C:\\resumeupload\\resume-2','IGDTU','BTECH','2015','Machine Learning','generic'),(3,'angular123',NULL,NULL,NULL,'C:\\resumeupload\\resume-3','\n{\n	\"collegename\":\"djkjkd\"\n}',NULL,NULL,NULL,'generic'),(4,'jangular123',NULL,NULL,NULL,'C:\\resumeupload\\resume-4',NULL,NULL,NULL,NULL,'generic'),(5,'jangularkk123',NULL,NULL,'987878989','C:\\resumeupload\\resume-5',NULL,NULL,NULL,NULL,'generic'),(6,'aa',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'generic'),(9,'anshul123','','','',NULL,NULL,NULL,NULL,NULL,'generic'),(10,'alia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'generic'),(11,'tanya',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'generic'),(12,'tanya',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'tanya',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'iop',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'anshul','','','',NULL,NULL,NULL,NULL,NULL,NULL),(16,'anshul123','','','',NULL,NULL,NULL,NULL,NULL,NULL),(17,'anshul123111','','','',NULL,NULL,NULL,NULL,NULL,'generic'),(27,'Anshul','anshul123','anshul.mk97@gmail.com','9717953260','C:\\resumeupload\\resume-27','Thapar University','BE','2019','ECE','questionnaire'),(28,'qwerty','hjkl','lkjhg','789654',NULL,NULL,NULL,NULL,NULL,'generic'),(29,'a','a','a','9',NULL,NULL,NULL,NULL,NULL,'generic'),(30,'Mohd Sohaib','sohaib','sohaib.mohd@gmail.com','9560579494',NULL,NULL,NULL,NULL,NULL,'generic'),(32,'Surabhi','ivyrpgnv','anshul.mk97@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,'questionnaire'),(33,'Anshul','eanrlhtf','anshul.mk97@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,'questionnaire');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-15 15:16:18
