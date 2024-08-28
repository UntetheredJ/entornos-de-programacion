-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.3.7-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para bd_clientes
CREATE DATABASE IF NOT EXISTS `bd_clientesF1` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bd_clientesF1`;

-- Volcando estructura para tabla bd_clientes.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idcliente` int(15) NOT NULL AUTO_INCREMENT,
  `documento` varchar(10) DEFAULT NULL,
  `tipdoc` varchar(2) DEFAULT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `direccion` text DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bd_clientes.cliente: ~34 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`idcliente`, `documento`, `tipdoc`, `nombres`, `apellidos`, `direccion`, `email`) VALUES
	(1, '736074826', 'CC', 'Sindy Nathalia', 'Chapeta Gamboa', 'Carrrera 12 # 10 - 23', 'Chapeta@gmail.com.co'),
	(2, '712152752', 'CC', 'Gaston Eduardo', 'Rojas Segura', 'Carrrera 32 # 100 - 124', 'GRojas@hotmail.com.co'),
	(3, '738628555', 'CC', 'Brayan', 'Davila', 'Carrrera 22 # 101- 25', 'Davila@gmail.com.co'),
	(8, '712767626', 'CC', 'Nicklass', 'Garcia Gomez', 'Carrrera 121 # 10 - 30', 'GarciaGNicklass@hotmail.com.co'),
	(12, '710120943', 'CC', 'Andres Felipe', 'Gomez Guevara', 'Carrrera 12 # 10 - 34', 'GomezG@hotmail.com.co'),
	(13, '726740383', 'CC', 'Juan Esteban', 'Gomez Hernandez', 'Carrrera 12 # 10 - 35', 'GomezH@gmail.com.co'),
	(14, '733836618', 'CC', 'Walter Alfredo', 'Gomez Torres', 'Carrrera 12 # 10 - 36', 'GomezT@hotmail.com.co'),
	(15, '721047819', 'CC', 'Marco Aurelio', 'Guerrero Lopez', 'Carrrera 12 # 10 - 37', 'GuerreroL@gmail.com.co'),
	(16, '738712686', 'CC', 'Francis Elena', 'Hernandez Sarmiento ', 'Carrrera 12 # 10 - 38', 'Hernandez@hotmail.com.co'),
	(17, '732033175', 'CC', 'Jhyna Paola', 'Lemus Martinez', 'Carrrera 12 # 10 - 39', 'Lemus@gmail.com.co'),
	(18, '710578153', 'CC', 'Luz Angela', 'Leon Guerra', 'Carrrera 12 # 10 - 40', 'Leon@hotmail.com.co'),
	(19, '730480641', 'CC', 'Franklin', 'Leyton Burgos', 'Carrrera 12 # 10 - 41', 'Leyton@gmail.com.co'),
	(20, '734469971', 'CC', 'Nidia Briyith', 'Mancera Esparza', 'Carrrera 112 # 10 - 42', 'ManceraNidia@hotmail.com.co'),
	(21, '728808800', 'CC', 'Juan Sebastian', 'Manrique Moreno ', 'Carrrera 12 # 10 - 43', 'Manrique@gmail.com.co'),
	(22, '723618790', 'CC', 'JOSEPH DUVAN', 'MARTINEZ DUARTE ', 'Carrrera 12 # 10 - 44', 'MartinezD@hotmail.com.co'),
	(23, '743840141', 'CC', 'Juan Diego', 'Martinez Perez ', 'Carrrera 12 # 10 - 45', 'MartinezP@gmail.com.co'),
	(24, '702775998', 'CC', 'Diego Alejandro', 'Mejia Guerrero ', 'Carrrera 12 # 10 - 46', 'Majia@hotmail.com.co'),
	(25, '711675554', 'CC', 'Alejandro', 'Meneses Roldan ', 'Carrrera 12 # 10 - 47', 'Meneses@gmail.com.co'),
	(26, '710235910', 'CC', 'Samuel', 'Montealegre Toro ', 'Carrrera 12 # 10 - 48', 'Montealegre@hotmail.com.co'),
	(27, '707015701', 'CC', 'Yeyffer Arbey', 'Montes Fonseca ', 'Carrrera 12 # 10 - 49', 'Montes@gmail.com.co'),
	(28, '718655622', 'CC', 'Adriana Esperanza', 'Mora Acevedo ', 'Carrrera 12 # 10 - 50', 'Mora@hotmail.com.co'),
	(29, '721669411', 'CC', 'Ivonne Soraya', 'Morales Rozo John', 'Carrrera 12 # 10 - 51', 'Morales@gmail.com.co'),
	(30, '692440124', 'CC', '', 'Moreno Cardenas', 'Carrrera 12 # 10 - 52', 'Moreno@hotmail.com.co'),
	(31, '721346397', 'CC', 'Cristian Camilo', 'Munoz Carvajalino ', 'Carrrera 12 # 10 - 53', 'Munoz@gmail.com.co'),
	(32, '748298021', 'CC', 'Homrai', 'Munoz Lasprilla', 'Carrrera 12 # 10 - 54', 'MunozL@hotmail.com.co'),
	(33, '726648219', 'CC', 'Alfredo', 'Nivia Bohorquez ', 'Carrrera 12 # 10 - 55', 'Nivia@gmail.com.co'),
	(34, '706000999', 'CC', 'Nelson Enrique', 'Nunez David', 'Carrrera 12 # 10 - 56', 'Nunez@hotmail.com.co'),
	(35, '715240412', 'CC', '', 'Ortega Diaz ', 'Carrrera 12 # 10 - 57', 'Ortega@gmail.com.co'),
	(36, '738951439', 'CC', 'Jhon Jairo', 'Ortiz Furnieles ', 'Carrrera 12 # 10 - 58', 'Ortiz@hotmail.com.co'),
	(37, '745475159', 'CC', 'Juan Camilo', 'Osorio Rodriguez ', 'Carrrera 12 # 10 - 59', 'Osorio@gmail.com.co'),
	(38, '726083427', 'CC', 'Mateo', 'Paloma  Quila ', 'Carrrera 12 # 10 - 60', 'Paloma@hotmail.com.co'),
	(39, '706336394', 'CC', 'Daniel Orlando', 'Parra Avila ', 'Carrrera 12 # 10 - 61', 'Parra@gmail.com.co'),
	(40, '737784253', 'CC', 'Brayan Camilo', 'Perez Son ', 'Carrrera 12 # 10 - 62', 'Perez@hotmail.com.co'),
	(42, '732804588', 'CC', 'Gustavo Antonio', 'Restrepo Sastoque ', 'Carrrera 12 # 10 - 64', 'Restrepo@hotmail.com.co');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
