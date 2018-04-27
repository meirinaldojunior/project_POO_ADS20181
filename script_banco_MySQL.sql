
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
  `Cpf` int(11) unsigned DEFAULT NULL,
  `Valor` double(10,2) NOT NULL,
  PRIMARY KEY (`Id_Aluguel`),
  KEY `fk_id_atendente` (`Id_atendente`),
  KEY `fk_id_exemplar` (`Id_exemplar`),
  KEY `fk_cpf` (`Cpf`),
  CONSTRAINT `fk_cpf` FOREIGN KEY (`Cpf`) REFERENCES `Usuario` (`Cpf`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_atendente` FOREIGN KEY (`Id_atendente`) REFERENCES `Atendente` (`Id_atendente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_exemplar` FOREIGN KEY (`Id_exemplar`) REFERENCES `exemplar` (`Id_exemplar`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Livro
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Livro`;

CREATE TABLE `Livro` (
  `Id_livro` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Nome_livro` varchar(50) NOT NULL DEFAULT '',
  `Nome_categoria` varchar(50) DEFAULT '',
  `Id_Autor` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`Id_livro`),
  KEY `fk_id_autor` (`Id_Autor`),
  KEY `fk_categoria` (`Nome_categoria`),
  CONSTRAINT `fk_categoria` FOREIGN KEY (`Nome_categoria`) REFERENCES `Categoria` (`Nome_categoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_autor` FOREIGN KEY (`Id_Autor`) REFERENCES `Autor` (`Id_Autor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Atendente
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Atendente`;

CREATE TABLE `Atendente` (
  `Id_atendente` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Nome` varchar(30) NOT NULL DEFAULT '',
  `Cpf` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Id_atendente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Autor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Autor`;

CREATE TABLE `Autor` (
  `Id_Autor` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Nome` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id_Autor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Categoria
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Categoria`;

CREATE TABLE `Categoria` (
  `Nome_categoria` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`Nome_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table exemplar
# ------------------------------------------------------------

DROP TABLE IF EXISTS `exemplar`;

CREATE TABLE `exemplar` (
  `Id_exemplar` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Id_livro` int(11) unsigned DEFAULT NULL,
  `Nome_categoria` varchar(50) DEFAULT NULL,
  `Id_Autor` int(11) unsigned NOT NULL,
  PRIMARY KEY (`Id_exemplar`),
  KEY `fk_id_livro` (`Id_livro`),
  KEY `fk_nome_categoria` (`Nome_categoria`),
  KEY `fk_id_autorf` (`Id_Autor`),
  CONSTRAINT `fk_id_autorf` FOREIGN KEY (`Id_Autor`) REFERENCES `Autor` (`Id_Autor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_livro` FOREIGN KEY (`Id_livro`) REFERENCES `Livro` (`Id_livro`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_nome_categoria` FOREIGN KEY (`Nome_categoria`) REFERENCES `Categoria` (`Nome_categoria`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Usuario
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Usuario`;

CREATE TABLE `Usuario` (
  `Cpf` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Nome` varchar(60) NOT NULL DEFAULT '',
  PRIMARY KEY (`Cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
