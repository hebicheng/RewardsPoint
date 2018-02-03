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
  `type` int(11) NOT NULL COMMENT '0：训练赛，1：个人赛',
  `weight` int(11) NOT NULL,
  `time` date NOT NULL,
  `oj` varchar(50) COLLATE utf8_bin NOT NULL,
  `url` varchar(300) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  reward.contest 的数据：~2 rows (大约)
DELETE FROM `contest`;
/*!40000 ALTER TABLE `contest` DISABLE KEYS */;
INSERT INTO `contest` (`id`, `name`, `content`, `type`, `weight`, `time`, `oj`, `url`) VALUES
	(2, 'test', 'test', 0, 1, '2018-02-03', 'test', 'test'),
	(5, 'codeforces#2018.1', 'codeforces#2018.1', 1, 1, '2018-02-03', 'codeforces', 'http://codeforces.com/');
/*!40000 ALTER TABLE `contest` ENABLE KEYS */;

-- 导出  表 reward.partition_point 结构
CREATE TABLE IF NOT EXISTS `partition_point` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `trainContest` double NOT NULL DEFAULT '0' COMMENT '训练赛比赛',
  `personContest` double NOT NULL DEFAULT '0' COMMENT '个人赛',
  `solveProblem` double NOT NULL DEFAULT '0' COMMENT '刷题',
  `attendance` double NOT NULL DEFAULT '0' COMMENT '考勤',
  PRIMARY KEY (`id`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  reward.partition_point 的数据：~1 rows (大约)
DELETE FROM `partition_point`;
/*!40000 ALTER TABLE `partition_point` DISABLE KEYS */;
/*!40000 ALTER TABLE `partition_point` ENABLE KEYS */;

-- 导出  表 reward.record 结构
CREATE TABLE IF NOT EXISTS `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `contest` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '0:训练赛 1:cf 2:atcoder',
  `ac` int(11) NOT NULL DEFAULT '0',
  `rank` int(11) NOT NULL DEFAULT '0',
  `onlyAC` int(11) NOT NULL DEFAULT '0',
  `fb` int(11) NOT NULL DEFAULT '0',
  `rating` int(11) NOT NULL DEFAULT '0',
  `updateTime` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `key` (`username`,`contest`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  reward.record 的数据：~3 rows (大约)
DELETE FROM `record`;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
/*!40000 ALTER TABLE `record` ENABLE KEYS */;

-- 导出  表 reward.teamer 结构
CREATE TABLE IF NOT EXISTS `teamer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(50) COLLATE utf8_bin NOT NULL,
  `name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `grade` int(11) NOT NULL DEFAULT '0',
  `sicnuoj` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `cf` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `atcoder` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `point` double NOT NULL DEFAULT '0',
  UNIQUE KEY `sno` (`username`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  reward.teamer 的数据：~2 rows (大约)
DELETE FROM `teamer`;
/*!40000 ALTER TABLE `teamer` DISABLE KEYS */;
INSERT INTO `teamer` (`id`, `username`, `password`, `name`, `grade`, `sicnuoj`, `cf`, `atcoder`, `point`) VALUES
	(1, '2015110416', '25d55ad283aa400af464c76d713c07ad', '何壁承', 2015, 'heb1c', 'heb1c__', 'heb1c', 8.56),
	(2, '2015110435', '25d55ad283aa400af464c76d713c07ad', '任力', 2015, '0', '0', '0', 4.44);
/*!40000 ALTER TABLE `teamer` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
