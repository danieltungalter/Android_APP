-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- 主機: 127.0.0.1
-- 產生時間： 2018 年 11 月 16 日 10:54
-- 伺服器版本: 10.1.31-MariaDB
-- PHP 版本： 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `recycling_info`
--

-- --------------------------------------------------------

--
-- 資料表結構 `category`
--

CREATE TABLE `category` (
  `cate_id` char(4) NOT NULL,
  `type` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 資料表的匯出資料 `category`
--

INSERT INTO `category` (`cate_id`, `type`) VALUES
('T001', 'Paper'),
('T002', 'Metal'),
('T003', 'Plastic'),
('T004', 'Battery'),
('T005', 'Glass');

-- --------------------------------------------------------

--
-- 資料表結構 `cust_info`
--

CREATE TABLE `cust_info` (
  `cust_id` char(8) NOT NULL,
  `company` varchar(80) NOT NULL,
  `contact_person` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `tel_no` int(8) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `description` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 資料表的匯出資料 `cust_info`
--

INSERT INTO `cust_info` (`cust_id`, `company`, `contact_person`, `address`, `tel_no`, `email`, `description`) VALUES
('C00001', '3R Hong Kong International Eco-Action Limited', 'Mr. Ng', 'Room C, 2/F, Kwong On Bank Building, 728-730 Nathan Road, Mong Kok, Kln.', 82038508, 'hk8880888@gmail.com', 'Plastics also including : Silicone, Nylon, CA, TPR, PC, Disk, EPS, X-Ray Film Sheet'),
('C00002', 'Acm Waste Disposal Company', 'Mr. Wong', 'Room 526, Lok Shan House, Cheung Shan Estate, Tsuen Wan, N.T.', 34282601, 'info@acmwd.com', ''),
('C00003', 'Allied Waste Disposal Co. Limited', 'Mr. Ho', 'Rm 504, 5/F, Blk B, Hoplite Industrial Centre, 3-5 Wang Tai Road, Kowloon Bay, Kln.', 25225328, 'info@awd.com.hk', ''),
('C00004', 'Asia Environment Protection (International) Recycle Company', 'Ms. Lam', 'Unit 1404, Blk B1, Hang Wai Industrial Centre, 6 Kin Tai Street, Tuen Mun, N.T.', 24556690, 'recycleic@yahoo.com.hk', ''),
('C00005', 'Asia Pacific Environment Technology Company Limited', 'Eric Lee', 'Unit 16, 19/F, Grand Tech Centre, 8 On Ping Street, Sha Tin, N.T.', 36890885, 'ivan.tang@apet.hk', ''),
('C00006', 'ATATLY Development Limited', 'Mr. Yip / Mr. Leung', 'Flat 15, Blk B, 7/F., Tontex Industrial Building, 2-4 Sheung Hei Street, San Po Kong, Kowloon', 63000915, 'info@atatly.com.hk', '');

-- --------------------------------------------------------

--
-- 資料表結構 `price`
--

CREATE TABLE `price` (
  `cust_id` char(8) NOT NULL,
  `cate_id` char(4) NOT NULL,
  `weight` varchar(10) NOT NULL,
  `price` double(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 資料表的匯出資料 `price`
--

INSERT INTO `price` (`cust_id`, `cate_id`, `weight`, `price`) VALUES
('C00001', 'T001', '1kg', 3.00),
('C00001', 'T002', '1kg', 5.00),
('C00001', 'T003', '1kg', 3.50),
('C00001', 'T004', '1kg', 4.20),
('C00001', 'T005', '1kg', 3.70),
('C00002', 'T001', '1kg', 3.30),
('C00002', 'T002', '1kg', 7.00),
('C00002', 'T003', '1kg', 4.00),
('C00002', 'T004', '1kg', 2.00),
('C00002', 'T005', '1kg', 6.00),
('C00003', 'T001', '10kg', 42.00),
('C00003', 'T002', '10kg', 28.00),
('C00003', 'T003', '10kg', 35.00),
('C00003', 'T004', '10kg', 80.00),
('C00003', 'T005', '10kg', 66.00),
('C00004', 'T001', '1kg', 0.00),
('C00004', 'T002', '1kg', 0.00),
('C00004', 'T003', '1kg', 0.00),
('C00004', 'T004', '1kg', 0.00),
('C00004', 'T005', '1kg', 0.00),
('C00005', 'T001', '1kg', 6.70),
('C00005', 'T002', '1kg', 8.00),
('C00005', 'T003', '1kg', 4.50),
('C00005', 'T004', '1kg', 4.00),
('C00005', 'T005', '1kg', 7.80),
('C00006', 'T001', '', 13.00),
('C00006', 'T002', '', 15.00),
('C00006', 'T003', '', 10.00),
('C00006', 'T004', '', 18.00),
('C00006', 'T005', '', 15.00);

--
-- 已匯出資料表的索引
--

--
-- 資料表索引 `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cate_id`);

--
-- 資料表索引 `cust_info`
--
ALTER TABLE `cust_info`
  ADD PRIMARY KEY (`cust_id`);

--
-- 資料表索引 `price`
--
ALTER TABLE `price`
  ADD PRIMARY KEY (`cust_id`,`cate_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
