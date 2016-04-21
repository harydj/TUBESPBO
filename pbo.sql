-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 21, 2016 at 09:04 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `pbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE IF NOT EXISTS `dokter` (
  `id` varchar(10) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `spesialisasi` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`id`, `nama`, `spesialisasi`) VALUES
('1', 'Dr.Niko', 'Umum'),
('2', 'Dr. Ariana', 'Kronis');

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE IF NOT EXISTS `pasien` (
  `id` int(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `keluhan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pasieninap`
--

CREATE TABLE IF NOT EXISTS `pasieninap` (
  `id` int(10) NOT NULL,
  `dokter` int(11) NOT NULL,
  `diagnosa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE IF NOT EXISTS `ruangan` (
  `noruang` int(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `pasieninap` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dokter`
--
ALTER TABLE `dokter`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pasieninap`
--
ALTER TABLE `pasieninap`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ruangan`
--
ALTER TABLE `ruangan`
 ADD PRIMARY KEY (`noruang`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
