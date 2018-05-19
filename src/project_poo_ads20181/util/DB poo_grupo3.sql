USE `poo_grupo3`;
CREATE TABLE `Categoria` ( 	Id_Categoria INT PRIMARY KEY AUTO_INCREMENT,
							Nome_Categoria VARCHAR(50) NOT NULL);

-- Copiando estrutura para tabela poo_grupo3.aluguel
CREATE TABLE IF NOT EXISTS `aluguel` (
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

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela poo_grupo3.Atendente
CREATE TABLE IF NOT EXISTS `Atendente` (
  `Id_atendente` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Nome` varchar(30) NOT NULL DEFAULT '',
  `Cpf` varchar(11) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id_atendente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela poo_grupo3.Autor
CREATE TABLE IF NOT EXISTS `Autor` (
  `Id_Autor` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Nome` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id_Autor`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela poo_grupo3.exemplar
CREATE TABLE IF NOT EXISTS `exemplar` (
  `Id_exemplar` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Id_livro` int(11) unsigned DEFAULT NULL,
  `Id_Categoria` INT,
  `Id_Autor` int(11) unsigned NOT NULL,
  PRIMARY KEY (`Id_exemplar`),
  KEY `fk_id_livro` (`Id_livro`),
  KEY `fk_Id_Categoria` (`Id_Categoria`),
  KEY `fk_id_autorf` (`Id_Autor`),
  CONSTRAINT `fk_id_autorf` FOREIGN KEY (`Id_Autor`) REFERENCES `Autor` (`Id_Autor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_livro` FOREIGN KEY (`Id_livro`) REFERENCES `Livro` (`Id_livro`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Id_Categoria` FOREIGN KEY (`Id_Categoria`) REFERENCES `Categoria` (`Id_Categoria`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela poo_grupo3.Livro
CREATE TABLE IF NOT EXISTS `Livro` (
  `Id_livro` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Nome_livro` varchar(50) NOT NULL DEFAULT '',
  `Id_Categoria` INT,
  `Id_Autor` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`Id_livro`),
  KEY `fk_id_autor` (`Id_Autor`),
  KEY `fk_categoria` (`Id_Categoria`),
  CONSTRAINT `fk_categoria` FOREIGN KEY (`Id_Categoria`) REFERENCES `Categoria` (`Id_Categoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_autor` FOREIGN KEY (`Id_Autor`) REFERENCES `Autor` (`Id_Autor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela poo_grupo3.Usuario
CREATE TABLE IF NOT EXISTS `Usuario` (
  `Cpf` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Nome` varchar(60) NOT NULL DEFAULT '',
  `Id_tipo_usuario` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`Cpf`),
  KEY `fk_tipo_usuario` (`Id_tipo_usuario`),
  CONSTRAINT `fk_tipo_usuario` FOREIGN KEY (`Id_tipo_usuario`) REFERENCES `Usuario_tipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela poo_grupo3.Usuario_tipo
CREATE TABLE IF NOT EXISTS `Usuario_tipo` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `tipo_usuario` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;