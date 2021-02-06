-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 30, 2020 at 01:56 PM
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
  `id` int(5) NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone` bigint(50) NOT NULL,
  `carno` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `bookingdate` datetime NOT NULL,
  `bookeddate` datetime NOT NULL,
  `status` varchar(5) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Yes',
  `leavingdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `recordcar`
--

INSERT INTO `recordcar` (`id`, `email`, `phone`, `carno`, `bookingdate`, `bookeddate`, `status`, `leavingdate`) VALUES
(5, 'tirthadeepb1999@gmail.com', 8910196347, 'WB 34D 6578', '2020-12-30 19:13:40', '2020-12-31 20:10:00', 'No', '2020-12-30 19:16:07');

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
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
