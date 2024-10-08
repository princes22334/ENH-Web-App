-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: enh_webapp
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `compay_name` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `employee_number` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `active` varchar(255) DEFAULT NULL,
  `company_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKfopic1oh5oln2khj8eat6ino0` (`email`),
  UNIQUE KEY `UKhafqwjqe2e9bcpgyj6evm52ap` (`name`),
  KEY `FK18unkc07agjyg32xcdnbd0mc2` (`company_id`),
  CONSTRAINT `FK18unkc07agjyg32xcdnbd0mc2` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'ENHisecure-New York','Marketing','jane.smith@example.com','E012','Jane','Smith','Jane Smith','555-6789','Active',3),(2,'ENHisecure-Hyderabad','R&D','jack.anderson@example.com','E010','Jack','Anderson','Jack Anderson','555-0987','Inactive',1),(3,'ENHisecure-Hyderabad','HR','alice.johnson@example.com','E001','Alice','Johnson','Alice Johnson','555-1234','Active',1),(4,'ENHisecure-Hyderabad','Finance','bob.smith@example.com','E002','Bob','Smith','Bob Smith','555-5678','Active',1),(6,'ENHisecure-Hyderabad','Marketing','david.brown@example.com','E004','David','Brown','David Brown','555-4321','Inactive',1),(7,'ENHisecure-Hyderabad','Sales','eve.davis@example.com','E005','Eve','Davis','Eve Davis','555-6789','Active',1),(8,'ENHisecure-Hyderabad','Support','frank.miller@example.com','E006','Frank','Miller','Frank Miller','555-9876','Inactive',1),(9,'ENHisecure-Hyderabad','IT','grace.wilson@example.com','E007','Grace','Wilson','Grace Wilson','555-3456','Active',1),(10,'ENHisecure-Hyderabad','Legal','henry.moore@example.com','E008','Henry','Moore','Henry Moore','555-6543','Inactive',1),(11,'ENHisecure-Hyderabad','Operations','ivy.taylor@example.com','E009','Ivy','Taylor','Ivy Taylor','555-7890','Active',1),(12,'ENHisecure-Banglore','HR','alice.smith@example.com','E001','Alice','Smith','Alice Smith','555-1234','Active',2),(13,'ENHisecure-Banglore','Finance','bob.johnson@example.com','E002','Bob','Johnson','Bob Johnson','555-5678','Inactive',2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-08 11:45:14
