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
-- Table structure for table `problems`
--

DROP TABLE IF EXISTS `problems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `problems` (
  `pid` int(11) NOT NULL auto_increment,
  `cid` int(11) default NULL,
  `probname` text,
  `probdetails` text,
  `owner` text,
  PRIMARY KEY  (`pid`),
  KEY `cid_idx` (`cid`),
  CONSTRAINT `cid` FOREIGN KEY (`cid`) REFERENCES `challenges` (`cid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problems`
--

LOCK TABLES `problems` WRITE;
/*!40000 ALTER TABLE `problems` DISABLE KEYS */;
INSERT INTO `problems` VALUES (1,2,'Grading Students','HackerLand University has the following grading policy:\n\nEvery student receives a  in the inclusive range from  to .\nAny  less than  is a failing grade.\nSam is a professor at the university and likes to round each students  according to these rules:\n\nIf the difference between the  and the next multiple of  is less than , round  up to the next multiple of .\nIf the value of  is less than , no rounding occurs as the result will still be a failing grade.\nFor example,  will be rounded to  but  will not be rounded because the rounding would result in a number that is less than .\n\nGiven the initial value of  for each of Sams  students, write code to automate the rounding process. Complete the function solve that takes an integer array of all grades, and return an integer array consisting of the rounded grades. For each , round it according to the rules above and print the result on a new line.\n\nInput Format\n\nThe first line contains a single integer denoting  (the number of students). \nEach line  of the  subsequent lines contains aproblemsproblems single integer, , denoting students grade.\n\nConstraints\n\nOutput Format\n\nFor each  of the  grades, print the rounded grade on a new line.','Anshika'),(2,2,'Time Conversion','Given a time in -hour AM/PM format, convert it to military (24-hour) time.\n\nNote: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.\n\nInput Format\n\nA single string  containing a time in -hour clock format (i.e.:  or ), where  and .\n\nOutput Format\n\nConvert and print the given time in -hour format, where .','rahul'),(3,1,'Array Sum','Calculate and print the sum of the elements in an array, keeping in mind that some of those integers may be quite large.\n\nInput Format\n\nThe first line of the input consists of an integer . \nThe next line contains  space-separated integers contained in the array.\n\nOutput Format\n\nPrint the integer sum of the elements in the array.\n\nConstraints \n \n\nSample Input','Anshu'),(4,3,'Compare the triplets','Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges, awarding points on a scale from  to  for three categories: problem clarity, originality, and difficulty.\n\nWe define the rating for Alices challenge to be the triplet , and the rating for Bobs challenge to be the triplet .\n\nYour task is to find their comparison points by comparing  with ,  with , and  with .\n\nIf , then Alice is awarded  point.\nIf , then Bob is awarded  point.\nIf , then neither person receives a point.\nComparison points is the total points a person earned.\n\nGiven  and , can you compare the two challenges and print their respective comparison points?\n\nInput Format\n\nThe first line contains  space-separated integers, , , and , describing the respective values in triplet . \nThe second line contains  space-separated integers, , , and , describing the respective values in triplet .','ranju'),(5,7,'Test-1 ','',''),(6,7,'Test -2','<p>HackerLand University has the following grading policy:</p><ul><li>Every student receives a&nbsp;&nbsp;in the inclusive range from&nbsp;&nbsp;to&nbsp;.</li><li>Any&nbsp;&nbsp;less than&nbsp;&nbsp;is a failing grade.</li></ul><p>Sam is a professor at the university and likes to round each student\'s&nbsp;&nbsp;according to these rules:</p><ul><li>If the difference between the&nbsp;&nbsp;and the next multiple of&nbsp;&nbsp;is less than&nbsp;, round&nbsp;&nbsp;up to the next multiple of&nbsp;.</li><li>If the value of&nbsp;&nbsp;is less than&nbsp;, no rounding occurs as the result will still be a failing grade.</li></ul><p>For example,&nbsp;&nbsp;will be rounded to&nbsp;&nbsp;but&nbsp;&nbsp;will not be rounded because the rounding would result in a number that is less than&nbsp;.</p><p>Given the initial value of&nbsp;&nbsp;for each of Sam\'s&nbsp;&nbsp;students, write code to automate the rounding process. Complete the function&nbsp;<code style=\"background-color: rgb(248, 248, 248); color: rgb(69, 76, 95);\">solve</code>&nbsp;that takes an integer array of all grades, and return an integer array consisting of the rounded grades. For each&nbsp;, round it according to the rules above and print the result on a new line.</p><p><strong style=\"color: rgb(14, 20, 30);\">Input Format</strong></p><p>The first line contains a single integer denoting&nbsp;&nbsp;(the number of students).&nbsp;</p><p>Each line&nbsp;&nbsp;of the&nbsp;&nbsp;subsequent lines contains a single integer,&nbsp;, denoting student&nbsp;\'s grade.</p><p><strong style=\"color: rgb(14, 20, 30);\">Constraints</strong></p><ul><li><br></li><li><br></li></ul><p><strong style=\"color: rgb(14, 20, 30);\">Output Format</strong></p><p>For each&nbsp;&nbsp;of the&nbsp;&nbsp;grades, print the rounded grade on a new line.</p>',''),(7,7,'Test -3','<p>HackerLand University has the following grading policy:</p><ul><li>Every student receives a&nbsp;&nbsp;in the inclusive range from&nbsp;&nbsp;to&nbsp;.</li><li>Any&nbsp;&nbsp;less than&nbsp;&nbsp;is a failing grade.</li></ul><p>Sam is a professor at the university and likes to round each student\'s&nbsp;&nbsp;according to these rules:</p><ul><li>If the difference between the&nbsp;&nbsp;and the next multiple of&nbsp;&nbsp;is less than&nbsp;, round&nbsp;&nbsp;up to the next multiple of&nbsp;.</li><li>If the value of&nbsp;&nbsp;is less than&nbsp;, no rounding occurs as the result will still be a failing grade.</li></ul><p>For example,&nbsp;&nbsp;will be rounded to&nbsp;&nbsp;but&nbsp;&nbsp;will not be rounded because the rounding would result in a number that is less than&nbsp;.</p><p>Given the initial value of&nbsp;&nbsp;for each of Sam\'s&nbsp;&nbsp;students, write code to automate the rounding process. Complete the function&nbsp;<code style=\"background-color: rgb(248, 248, 248); color: rgb(69, 76, 95);\">solve</code>&nbsp;that takes an integer array of all grades, and return an integer array consisting of the rounded grades. For each&nbsp;, round it according to the rules above and print the result on a new line.</p><p><strong style=\"color: rgb(14, 20, 30);\">Input Format</strong></p><p>The first line contains a single integer denoting&nbsp;&nbsp;(the number of students).&nbsp;</p><p>Each line&nbsp;&nbsp;of the&nbsp;&nbsp;subsequent lines contains a single integer,&nbsp;, denoting student&nbsp;\'s grade.</p><p><strong style=\"color: rgb(14, 20, 30);\">Constraints</strong></p><ul><li><br></li><li><br></li></ul><p><strong style=\"color: rgb(14, 20, 30);\">Output Format</strong></p><p>For each&nbsp;&nbsp;of the&nbsp;&nbsp;grades, print the rounded grade on a new line.</p>',''),(8,8,'Test Problem','<p>Test Description</p>',''),(9,8,'Testing','<p>Test</p>','');
/*!40000 ALTER TABLE `problems` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-15 15:16:22
