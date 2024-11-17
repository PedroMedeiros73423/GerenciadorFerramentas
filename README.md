# Gerenciador de empréstimos de ferramentas
<hr/>
Projeto A3 da UC: Programação de soluções computacionais do curso de Engenharia da Computação da universidade Unisul.

Este programa utiliza a linguagem Java com o banco de dados MYSQL para formar um software de gerenciamento de empréstimos de ferramentas.

<h3>Características</h3>
O programa funciona com interface gráfica. Foi desenvolvido e testado apenas em ambiente Windows rodando a versão 8 do Java JDK.<br>
O programa permite cadastrar ferramentas e amigos, assim como, registrar com precisão todos os empréstimos de ferramentas.<br>
O programa também é capaz de gerar alguns tipos de relatórios, como por exemplo:<br>
* Listar as ferramentas e o valor gasto para adquiri-las;<br>
* Listar quais ferramentas estão emprestadas e quais estão disponíveis.<br>
* Listar quais amigos tem ferramentas emprestadas, tanto os que devolvem as ferramentas dentro do prazo legal do empréstimo ou devolvem com atraso.<br>
* Listar os amigos que nunca devolveram as ferramentas que pediram emprestadas.<br>

<h3>Banco de dados</h3>
O banco de dados deve estar localizado na mesma máquina onde o programa será rodado.
O banco é formado por apenas 3 tableas: ferramentas, amigos e negócios.
Para não precisar modificar nada do código do programa em relação à conexão com o banco de dados, configure no SGBD as seguntes credenciais:<br>
Usuário: root<br>
Senha : unisul

<hr>
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

