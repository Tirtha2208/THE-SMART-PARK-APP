-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 30, 2020 at 01:57 PM
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
-- Table structure for table `recordbike`
--

CREATE TABLE `recordbike` (
  `id` int(5) NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone` bigint(50) NOT NULL,
  `bookingdate` datetime NOT NULL,
  `bookeddate` datetime NOT NULL,
  `bikeno` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(6) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Yes',
  `leavingdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `recordbike`
--

INSERT INTO `recordbike` (`id`, `email`, `phone`, `bookingdate`, `bookeddate`, `bikeno`, `status`, `leavingdate`) VALUES
(6, 'tirthadeepb1999@msn.com', 9748196335, '2020-12-30 12:35:53', '2020-12-30 12:40:00', 'WB 54C 5329', 'No', '2020-12-30 12:47:09'),
(7, 'tb@hotmail.com', 1234567890, '2020-12-30 12:48:20', '2020-12-30 12:50:00', 'WB 23N 6478', 'No', '2020-12-30 12:50:21'),
(8, 'swarnenduojha057@gmail.com', 6297295912, '2020-12-30 19:23:23', '2020-12-31 17:28:00', 'WB54T6024', 'No', '2020-12-30 19:24:26');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `recordbike`
--
ALTER TABLE `recordbike`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `recordbike`
--
ALTER TABLE `recordbike`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
