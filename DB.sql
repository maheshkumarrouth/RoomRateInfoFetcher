-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.47-0ubuntu0.14.04.1 - (Ubuntu)
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             9.0.0.4865
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for cultagent4
CREATE DATABASE IF NOT EXISTS `cultagent4` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cultagent4`;


-- Dumping structure for table cultagent4.Channel_X_Communication_X_Details
CREATE TABLE IF NOT EXISTS `Channel_X_Communication_X_Details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `distributorId` int(11) NOT NULL,
  `key` mediumint(9) NOT NULL,
  `value` varchar(200) NOT NULL,
  `lastupdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `distributorId_key` (`distributorId`,`key`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table cultagent4.Channel_X_Communication_X_Details: ~2 rows (approximately)
DELETE FROM `Channel_X_Communication_X_Details`;
/*!40000 ALTER TABLE `Channel_X_Communication_X_Details` DISABLE KEYS */;
INSERT INTO `Channel_X_Communication_X_Details` (`id`, `distributorId`, `key`, `value`, `lastupdate`) VALUES
	(1, 123456, 1, 'http://extranet.bestday.com/gateway1/RateGateway.asmx/Gateway1', '2018-02-23 15:41:42'),
	(2, 123456, 4, 'C-XXX', '2018-02-23 15:41:46');
/*!40000 ALTER TABLE `Channel_X_Communication_X_Details` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
