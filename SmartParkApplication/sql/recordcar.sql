-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 06, 2021 at 02:44 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id15675975_record`
--

-- --------------------------------------------------------

--
-- Table structure for table `recordcar`
--

CREATE TABLE `recordcar` (
  `id` int(7) NOT NULL,
  `cid` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone` bigint(15) NOT NULL,
  `bookeddate` datetime NOT NULL,
  `bookingdate` datetime NOT NULL,
  `carno` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Yes',
  `leavingdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `recordcar`
--

INSERT INTO `recordcar` (`id`, `cid`, `email`, `phone`, `bookeddate`, `bookingdate`, `carno`, `status`, `leavingdate`) VALUES
(1, 'Robert200', 'robertw@gmail.com', 9874561230, '2021-02-06 13:00:00', '2021-02-05 20:50:57', 'WB 15T 5963', 'No', '2021-02-05 20:52:24');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `recordcar`
--
ALTER TABLE `recordcar`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `recordcar`
--
ALTER TABLE `recordcar`
  MODIFY `id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
