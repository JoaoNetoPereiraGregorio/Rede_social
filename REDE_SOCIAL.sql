-- MariaDB dump 10.19  Distrib 10.4.28-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: rede_social
-- ------------------------------------------------------
-- Server version	10.4.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `amizade`
--

DROP TABLE IF EXISTS `amizade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `amizade` (
  `id_amizade` int(10) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(10) DEFAULT NULL,
  `id_usuario_amigo` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_amizade`),
  KEY `fk_usuario_amizade` (`id_usuario`),
  KEY `fk_usuario_amigo` (`id_usuario_amigo`),
  CONSTRAINT `fk_usuario_amigo` FOREIGN KEY (`id_usuario_amigo`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `fk_usuario_amizade` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amizade`
--

LOCK TABLES `amizade` WRITE;
/*!40000 ALTER TABLE `amizade` DISABLE KEYS */;
INSERT INTO `amizade` VALUES (8,2,1),(9,3,1),(16,2,1),(17,1,4),(18,4,1),(19,1,3),(20,3,1),(21,1,2),(22,2,1),(24,1,42),(28,47,42),(29,42,3),(30,3,42),(31,42,45),(32,45,42),(33,42,40),(34,40,42),(35,42,44),(36,44,42),(37,1,40),(38,40,1),(40,44,1),(41,1,44),(42,44,1),(43,1,45),(44,45,1),(45,1,48),(46,48,1),(48,1,49),(49,50,1),(50,1,50),(51,50,44),(52,44,50),(54,47,50),(55,50,45),(56,45,50);
/*!40000 ALTER TABLE `amizade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postagem`
--

DROP TABLE IF EXISTS `postagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postagem` (
  `id_postagem` int(10) NOT NULL AUTO_INCREMENT,
  `conteudo` varchar(6000) DEFAULT NULL,
  `id_usuario` int(10) DEFAULT NULL,
  PRIMARY KEY (`id_postagem`),
  KEY `fk_usuario_postagem` (`id_usuario`),
  CONSTRAINT `fk_usuario_postagem` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postagem`
--

LOCK TABLES `postagem` WRITE;
/*!40000 ALTER TABLE `postagem` DISABLE KEYS */;
INSERT INTO `postagem` VALUES (1,'Hoje estou programando um banco de dados!',1),(20,'Testando somente novamente !',3),(27,'kk',2),(28,'deu certo',1),(29,'oii',1),(30,'oiii',1),(35,'oi 4',1),(36,'oii 5',1),(37,'oii 6 ',1),(38,'oi 7',1),(39,'oi 8',1),(40,'oi 9',1),(41,'oi 10',1),(42,'oi',1),(43,'iu',1),(44,'u',1),(45,'u',1),(46,'u',1),(51,'aa',1);
/*!40000 ALTER TABLE `postagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(10) NOT NULL AUTO_INCREMENT,
  `nome_completo` varchar(100) DEFAULT NULL,
  `nome_usuario` varchar(50) DEFAULT NULL,
  `senha` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Jo├úo Neto Pereira Gregorio','jnpg','123456'),(2,'Mateus Gomes','MG','654321'),(3,'Juliane Martins','JuM','234567'),(4,'Matheus Cunha','MC','22222'),(40,'a','a','a'),(41,'a','a','a'),(42,'a','a','a'),(43,'b','b','b'),(44,'c','c','c'),(45,'d','d','d'),(46,'e','e','e'),(47,'ee','ee','ee'),(48,'oi','oi','oi'),(49,'Viviane Roberta','VR','123'),(50,'engenharia de software','EG','1234');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-12 19:23:48
