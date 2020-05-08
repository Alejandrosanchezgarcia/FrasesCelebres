-- MySQL dump 10.13  Distrib 5.5.44, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: frases_celebres
-- ------------------------------------------------------
-- Server version	5.5.44-0ubuntu0.14.04.1

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
-- Current Database: `frases_celebres`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `frases_celebres` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `frases_celebres`;

--
-- Table structure for table `autores`
--

DROP TABLE IF EXISTS `autores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autores` (
  `id_autor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(50) DEFAULT NULL,
  `fecha_nac` date DEFAULT NULL,
  PRIMARY KEY (`id_autor`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autores`
--

LOCK TABLES `autores` WRITE;
/*!40000 ALTER TABLE `autores` DISABLE KEYS */;
INSERT INTO `autores` VALUES (1,'Albert Einstein','1920-06-20'),(2,'Rubén Darío','1930-09-12'),(3,'Steve Jobs','1964-02-19'),(4,'Ludwig van Beethoven','1770-12-16'),(5,'Napoleón Bonaparte','1830-11-05'),(6,'Oscar Wilde','1854-10-16'),(7,'Jacinto Benavente','1866-08-12');
/*!40000 ALTER TABLE `autores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frases`
--

DROP TABLE IF EXISTS `frases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frases` (
  `id_frase` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` text,
  `categoria` varchar(20) DEFAULT NULL,
  `id_autor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_frase`),
  KEY `id_autor` (`id_autor`),
  CONSTRAINT `frases_ibfk_1` FOREIGN KEY (`id_autor`) REFERENCES `autores` (`id_autor`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frases`
--

LOCK TABLES `frases` WRITE;
/*!40000 ALTER TABLE `frases` DISABLE KEYS */;
INSERT INTO `frases` VALUES (1,'Estoy convencido de que la mitad de lo que separa a los emprendedores exitosos de los que no triunfan es la perseverancia.','perseverancia',3),(2,'Ser el hombre más rico en el cementerio no me importa… Ir a la cama por la noche diciendo que hemos hecho algo maravilloso… Eso es lo que me importa.','ilusiones',3),(3,'Generalmente, los hombres risueños son sanos de corazón. La risa es la sal de la vida; la risa de un niño es como la loca música de la infancia.','risas',2),(4,'No dejes apagar el entusiasmo, virtud tan valiosa como necesaria; trabaja, aspira, tiende siempre hacia la altura.','entusiasmo',2),(5,'El que no posee el don de maravillarse ni de entusiasmarse más le valdría estar muerto, porque sus ojos están cerrados.','entusiasmo',1),(6,'Tendremos el destino que nos hayamos merecido.','destino',1),(7,'La marca esencial que distingue a un hombre digno de llamarse así, es la perseverancia en las situaciones adversas y dificiles','perseverancia',4),(8,'A veces hay que retroceder dos pasos para avanzar uno','perseverancia',5),(10,'La risa no es un mal comienzo para la amistad. Y está lejos de ser un mal final','risas',6),(11,'Perdona siempre a tu enemigo. No hay nada que le enfurezca más.','perdonar',6),(12,'Me apoderaré del destino agarrándolo por el cuello. No me dominará','destino',4),(13,'El único símbolo de superioridad que conozco es la bondad','bondad',4),(14,'El tormento de las preocupaciones a menudo excede los peligros que han de ser evitados. Por tanto, a veces es mejor abandonarse al destino','destino',5),(15,'El sufrimiento es el medio por el cual existimos, porque es el único gracias al cual tenemos conciencia de existir','sufrimiento',6),(16,'El mundo sufre mucho. No por causa de la violencia de las malas personas, sino por el silencio de las buenas personas','sufrimiento',5),(17,'La muerte es de la vida la inseparable hermana. La muerte es la victoria de la progenie humana','muerte',2),(18,'Para aquellos que estamos atados a la vejez, la muerte llega como una liberación','muerte',1),(19,'La muerte es la mejor invención de la vida','muerte',3),(20,'Nada prende tan pronto de unas almas en otras como esta simpatía de la risa','risas',7),(21,'A perdonar sólo se aprende en la vida cuando a nuestra vez hemos necesitado que nos perdonen mucho','perdonar',7);
/*!40000 ALTER TABLE `frases` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-16  7:38:17
