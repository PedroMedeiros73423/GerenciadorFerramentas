# Gerenciador de empréstimos de ferramentas

Projeto A3 da UC: Programação de soluções computacionais.

Este programa utiliza a linguagem Java com o banco de dados MYSQL para formar um software de gerenciamento de empréstimos de ferramentas.

O programa funciona com interface gráfica.

O banco de dados deve estar localizado na mesma máquina onde o programa será rodado.

Script para criação do banco de dados:
<pre>
DROP DATABASE  IF EXISTS `ferramentas`;
CREATE DATABASE  IF NOT EXISTS `ferramentas`;
USE `ferramentas`;


DROP TABLE IF EXISTS `amigos`;
CREATE TABLE `amigos` (
  `amigoId` int NOT NULL AUTO_INCREMENT,
  `amigoNome` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `amigoEmail` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `amigoEndereco` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `amigoTelefone` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`amigoId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `ferramentas`;
CREATE TABLE `ferramentas` (
  `ferramentaId` int NOT NULL AUTO_INCREMENT,
  `ferramentaNome` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `ferramentaMarca` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `ferramentaValor` double NOT NULL,
  PRIMARY KEY (`ferramentaId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `negocios`;
CREATE TABLE `negocios` (
  `negocioId` int NOT NULL AUTO_INCREMENT,
  `negocioFerramentaId` int NOT NULL,
  `negocioAmigoId` int NOT NULL,
  `negocioInicio` datetime NOT NULL,
  `negocioFim` datetime NOT NULL,
  `negocioFinal` datetime DEFAULT NULL,
  PRIMARY KEY (`negocioId`),
  KEY `ferramenta` (`negocioFerramentaId`) USING BTREE,
  KEY `amigo` (`negocioAmigoId`) USING BTREE,
  CONSTRAINT `negocios_ibfk_1` FOREIGN KEY (`negocioFerramentaId`) REFERENCES `ferramentas` (`ferramentaId`),
  CONSTRAINT `negocios_ibfk_2` FOREIGN KEY (`negocioAmigoId`) REFERENCES `amigos` (`amigoId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
</pre>
