-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.26 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 reward 的数据库结构
CREATE DATABASE IF NOT EXISTS `reward` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `reward`;

-- 导出  表 reward.admin 结构
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  reward.admin 的数据：~0 rows (大约)
DELETE FROM `admin`;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id`, `username`, `password`) VALUES
	(1, 'admin', 'adminadmin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- 导出  表 reward.contest 结构
CREATE TABLE IF NOT EXISTS `contest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  `content` text COLLATE utf8_bin,
  `type` varchar(50) COLLATE utf8_bin NOT NULL,
  `weight` int(11) NOT NULL,
  `time` date NOT NULL,
  `oj` varchar(50) COLLATE utf8_bin NOT NULL,
  `url` varchar(300) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  reward.contest 的数据：~0 rows (大约)
DELETE FROM `contest`;
/*!40000 ALTER TABLE `contest` DISABLE KEYS */;
INSERT INTO `contest` (`id`, `name`, `content`, `type`, `weight`, `time`, `oj`, `url`) VALUES
	(1, '2018 蓝桥杯省赛 B 组模拟赛（一）', '无', '训练赛', 1, '2018-01-29', '计蒜客', 'https://www.jisuanke.com/contest/990');
/*!40000 ALTER TABLE `contest` ENABLE KEYS */;

-- 导出  表 reward.record 结构
CREATE TABLE IF NOT EXISTS `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teamer` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `contest` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `ac` int(11) NOT NULL DEFAULT '0',
  `rank` int(11) NOT NULL DEFAULT '0',
  `onlyAC` int(11) NOT NULL DEFAULT '0',
  `fb` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `key` (`teamer`,`contest`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  reward.record 的数据：~0 rows (大约)
DELETE FROM `record`;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` (`id`, `teamer`, `contest`, `ac`, `rank`, `onlyAC`, `fb`) VALUES
	(1, '杨苗', '2018 蓝桥杯省赛 B 组模拟赛（一）', 10, 1, 10, 10);
/*!40000 ALTER TABLE `record` ENABLE KEYS */;

-- 导出  表 reward.teamer 结构
CREATE TABLE IF NOT EXISTS `teamer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `grade` int(11) NOT NULL DEFAULT '0',
  `sicnuoj` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `cf` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `atcoder` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `point` double NOT NULL DEFAULT '0',
  UNIQUE KEY `name` (`name`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  reward.teamer 的数据：~6 rows (大约)
DELETE FROM `teamer`;
/*!40000 ALTER TABLE `teamer` DISABLE KEYS */;
INSERT INTO `teamer` (`id`, `name`, `grade`, `sicnuoj`, `cf`, `atcoder`, `point`) VALUES
	(1, '何壁承', 2015, 'heb1c', 'heb1c__', 'heb1c', 95.3),
	(3, '史茜茜', 2016, 'sissiall', 'sissiall', '--', 94.2),
	(4, '康润', 2016, 'kangrrrr', 'kangrrrr', '--', 91.2),
	(6, '张唯', 2016, '啊啊啊啊啊', 'Afra', '--', 88),
	(5, '杨苗', 2016, 'YmMm~`', 'YmMm', '--', 87),
	(2, '邵博超', 2016, 'Dexter0ion', 'ShaoBochao', '--', 91);
/*!40000 ALTER TABLE `teamer` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
