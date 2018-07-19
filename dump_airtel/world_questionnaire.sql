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
-- Table structure for table `questionnaire`
--

DROP TABLE IF EXISTS `questionnaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionnaire` (
  `questionnaireid` int(11) default NULL,
  `qid` int(11) NOT NULL auto_increment,
  `type` text,
  `qstatement` text,
  `options` text,
  `marks` int(11) default NULL,
  `answer` text,
  `qname` varchar(255) default NULL,
  PRIMARY KEY  (`qid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionnaire`
--

LOCK TABLES `questionnaire` WRITE;
/*!40000 ALTER TABLE `questionnaire` DISABLE KEYS */;
INSERT INTO `questionnaire` VALUES (1,24,'abc','jk',NULL,NULL,NULL,NULL),(1,25,'123abc','jk','',NULL,NULL,NULL),(1,26,'subjective','skcjskljclsjclksjlcks','',NULL,NULL,NULL),(2,27,'subjective','Anshul Mehta','',5,NULL,'Questionnaire3'),(2,28,'mcq','Anshul Mehta','Option 1,,Option 2',5,NULL,'Questionnaire3'),(2,29,'truefalse','Its a boolean','',5,NULL,'Questionnaire3'),(2,30,'mcq','One more mcq','A,,B,,C',5,NULL,'Questionnaire3'),(1,31,'123abc','jk','ast,,dd',NULL,NULL,'Questionnaire1'),(5,35,'mcq','abcd','1,,2,,3,,4',5,'1','Questionnaire5'),(5,36,'truefalse','efgh','',5,'true','Questionnaire5'),(5,37,'subjective','ghij','',5,'','Questionnaire5'),(6,38,'mcq','Hey','1,,2,,3',5,'2','Airtel Questionnaire'),(6,39,'subjective','Hey SUbjective','',10,'','Airtel Questionnaire'),(7,43,'subjective','232323LKLK','',5,'','TEST'),(7,44,'mcq','Testing123','rwedd',1,'4','Hello'),(8,45,'subjective','Test','',12,'','Test1234'),(9,46,'subjective','Test','',1,'','<h1>Hello</h1>'),(7,47,'','','',NULL,'',''),(8,48,'','','',NULL,'',''),(9,49,'','','',NULL,'',''),(10,50,'','khj','',56,'',''),(11,51,'','sasasa','',45,'',''),(7,52,'subjective','hey','',12,'',''),(7,53,'truefalse','Hey','',12,'1','aaa'),(7,54,'truefalse','Hey','',12,'1','Hey'),(7,55,'subjective','hey','',100,'1','10'),(8,56,'','','',NULL,'',''),(9,57,'','','',NULL,'',''),(10,58,'','','',NULL,'',''),(11,59,'','','',NULL,'',''),(12,60,'','','',NULL,'',''),(13,61,'','','',NULL,'',''),(14,63,'subjective','HEY','',12,'','test subjective'),(15,64,'mcq','TEST MCQ STATEMENT','Option 1,,2,,3',5,'3','TEST MCQ'),(7,65,'subjective','testabc','',5,'','Test123456'),(8,66,'subjective','ABC','',23,'','Unique'),(16,67,'subjective','Hey','',12,'','Test Latest'),(18,68,'subjective','test','',12,'','test latest dobara se'),(18,69,'subjective','HEY !@#','',12,'','TEST LATEST NEQW'),(19,70,'subjective','Subjective test','',10,'','Test Naya'),(19,71,'mcq','Test MCQ','1,,2',20,'1','Test Naya'),(4,72,NULL,'hiii','abs,,ada,,dssd',50,'2','newQuestion');
/*!40000 ALTER TABLE `questionnaire` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-15 15:16:25
