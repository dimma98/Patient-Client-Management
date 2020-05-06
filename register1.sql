-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2020 at 06:05 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `health`
--

-- --------------------------------------------------------

--
-- Table structure for table `register1`
--

CREATE TABLE `register1` (
  `pID` int(11) NOT NULL,
  `pName` varchar(45) NOT NULL,
  `pAddress` varchar(45) NOT NULL,
  `pEmail` varchar(30) NOT NULL,
  `pDate` varchar(15) NOT NULL,
  `nic` varchar(15) NOT NULL,
  `pno` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register1`
--

INSERT INTO `register1` (`pID`, `pName`, `pAddress`, `pEmail`, `pDate`, `nic`, `pno`) VALUES
(3, 'thimira', 'Colombo', 'thima', '2020-05-10', '957812341v', '0754812365'),
(39, 'nisal', 'kandy', 'thisal@gmail.com', '2020-05-14', '9285252311v', '0774561289'),
(41, 'Thisal', 'Colombo', 'thisal@gmail.com', '2020-05-07', '9852521v', '0774561289'),
(42, 'Janith', 'Galle', 'janith@gmail.com', '2020-05-01', '93152545314v', '0774561289');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `register1`
--
ALTER TABLE `register1`
  ADD PRIMARY KEY (`pID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `register1`
--
ALTER TABLE `register1`
  MODIFY `pID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
