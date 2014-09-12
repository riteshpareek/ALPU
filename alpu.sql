-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.5.37 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for alpu
CREATE DATABASE IF NOT EXISTS `alpu` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `alpu`;


-- Dumping structure for table alpu.alpu_raw_logs
CREATE TABLE IF NOT EXISTS `alpu_raw_logs` (
  `id` bigint(20) unsigned NOT NULL,
  `log_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `log_type` varchar(50) NOT NULL,
  `log_level` varchar(50) NOT NULL,
  `log_message` varchar(8000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table alpu.alpu_raw_logs: ~0 rows (approximately)
/*!40000 ALTER TABLE `alpu_raw_logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `alpu_raw_logs` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
