# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: poo_grupo3.mysql.dbaas.com.br (MySQL 5.6.35-81.0-log)
# Database: poo_grupo3
# Generation Time: 2018-06-14 22:25:29 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table aluguel
# ------------------------------------------------------------

DROP TABLE IF EXISTS `aluguel`;

CREATE TABLE `aluguel` (
  `Id_Aluguel` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Id_atendente` int(11) unsigned DEFAULT NULL,
  `Id_exemplar` int(11) unsigned DEFAULT NULL,
  `Id_Usuario` int(11) unsigned DEFAULT NULL,
  `Valor` double(10,2) NOT NULL,
  PRIMARY KEY (`Id_Aluguel`),
  KEY `fk_id_atendente` (`Id_atendente`),
  KEY `fk_id_exemplar` (`Id_exemplar`),
  KEY `fk_id_usuario` (`Id_Usuario`),
  CONSTRAINT `fk_id_exemplar` FOREIGN KEY (`Id_exemplar`) REFERENCES `exemplar` (`Id_exemplar`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_usuario` FOREIGN KEY (`Id_Usuario`) REFERENCES `Usuario` (`Id_Usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_atendente` FOREIGN KEY (`Id_atendente`) REFERENCES `Usuario` (`Id_Usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Autor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Autor`;

CREATE TABLE `Autor` (
  `Id_Autor` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Nome` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id_Autor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Autor` WRITE;
/*!40000 ALTER TABLE `Autor` DISABLE KEYS */;

INSERT INTO `Autor` (`Id_Autor`, `Nome`)
VALUES
	(107,'bob'),
	(109,'valter'),
	(112,'julius');

/*!40000 ALTER TABLE `Autor` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Categoria
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Categoria`;

CREATE TABLE `Categoria` (
  `Id_Categoria` int(11) NOT NULL AUTO_INCREMENT,
  `Nome_Categoria` varchar(50) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`Id_Categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

LOCK TABLES `Categoria` WRITE;
/*!40000 ALTER TABLE `Categoria` DISABLE KEYS */;

INSERT INTO `Categoria` (`Id_Categoria`, `Nome_Categoria`)
VALUES
	(2,'Suspense'),
	(3,'Aventura'),
	(4,'Historia'),
	(5,'Geografia'),
	(7,'Geografia'),
	(8,'Geografia'),
	(9,'apo'),
	(10,'Geografia'),
	(11,'Math'),
	(12,'Artes'),
	(13,'mat'),
	(14,'matmat'),
	(15,'teste'),
	(16,'matematicafin'),
	(17,'algebra'),
	(18,'programação');

/*!40000 ALTER TABLE `Categoria` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table exemplar
# ------------------------------------------------------------

DROP TABLE IF EXISTS `exemplar`;

CREATE TABLE `exemplar` (
  `Id_exemplar` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Id_livro` int(11) unsigned DEFAULT NULL,
  `Id_Categoria` int(11) DEFAULT NULL,
  `Id_Autor` int(11) unsigned NOT NULL,
  `disponibilidade` int(11) DEFAULT '1',
  PRIMARY KEY (`Id_exemplar`),
  KEY `fk_id_livro` (`Id_livro`),
  KEY `fk_Id_Categoria` (`Id_Categoria`),
  KEY `fk_id_autorf` (`Id_Autor`),
  CONSTRAINT `fk_Id_Categoria` FOREIGN KEY (`Id_Categoria`) REFERENCES `Categoria` (`Id_Categoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_autorf` FOREIGN KEY (`Id_Autor`) REFERENCES `Autor` (`Id_Autor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_livro` FOREIGN KEY (`Id_livro`) REFERENCES `Livro` (`Id_livro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `exemplar` WRITE;
/*!40000 ALTER TABLE `exemplar` DISABLE KEYS */;

INSERT INTO `exemplar` (`Id_exemplar`, `Id_livro`, `Id_Categoria`, `Id_Autor`, `disponibilidade`)
VALUES
	(5,8,2,107,1),
	(6,12,2,109,1),
	(9,8,2,109,1),
	(10,13,18,112,1),
	(11,14,18,107,1);

/*!40000 ALTER TABLE `exemplar` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Livro
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Livro`;

CREATE TABLE `Livro` (
  `Id_livro` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Nome_livro` varchar(50) NOT NULL DEFAULT '',
  `Id_Categoria` int(11) DEFAULT NULL,
  `Id_Autor` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`Id_livro`),
  KEY `fk_id_autor` (`Id_Autor`),
  KEY `fk_categoria` (`Id_Categoria`),
  CONSTRAINT `fk_categoria` FOREIGN KEY (`Id_Categoria`) REFERENCES `Categoria` (`Id_Categoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_autor` FOREIGN KEY (`Id_Autor`) REFERENCES `Autor` (`Id_Autor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Livro` WRITE;
/*!40000 ALTER TABLE `Livro` DISABLE KEYS */;

INSERT INTO `Livro` (`Id_livro`, `Nome_livro`, `Id_Categoria`, `Id_Autor`)
VALUES
	(8,'Bitcoin',4,107),
	(12,'Programaçã Orientetada a Objetos',4,109),
	(13,'SQL Server 2017',4,109),
	(14,'Redes de Computadores',4,109);

/*!40000 ALTER TABLE `Livro` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Usuario
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Usuario`;

CREATE TABLE `Usuario` (
  `Id_Usuario` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Cpf` varchar(11) COLLATE latin1_general_ci DEFAULT NULL,
  `Nome` varchar(60) COLLATE latin1_general_ci DEFAULT NULL,
  `Senha` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  `Tipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;

INSERT INTO `Usuario` (`Id_Usuario`, `Cpf`, `Nome`, `Senha`, `Tipo`)
VALUES
	(20,'11834644445','Meirinaldo Junior','202cb962ac59075b964b07152d234b70',1),
	(21,'09743828419','Hugo Felipe','202cb962ac59075b964b07152d234b70',1),
	(23,'07255679455','Valter Apolinário','202cb962ac59075b964b07152d234b70',1),
	(24,'26394435007','Aluno','202cb962ac59075b964b07152d234b70',0),
	(25,'79111073004','Aluno 2','202cb962ac59075b964b07152d234b70',0);

/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Usuario_tipo
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Usuario_tipo`;

CREATE TABLE `Usuario_tipo` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `tipo_usuario` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

LOCK TABLES `Usuario_tipo` WRITE;
/*!40000 ALTER TABLE `Usuario_tipo` DISABLE KEYS */;

INSERT INTO `Usuario_tipo` (`id`, `tipo_usuario`)
VALUES
	(0,'Aluno'),
	(1,'Atendente');

/*!40000 ALTER TABLE `Usuario_tipo` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
