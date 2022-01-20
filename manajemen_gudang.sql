-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 20, 2022 at 05:52 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `manajemen_gudang`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblbrgmasuk`
--

CREATE TABLE `tblbrgmasuk` (
  `nonota` varchar(10) NOT NULL,
  `tglmasuk` varchar(30) DEFAULT NULL,
  `iddistributor` varchar(6) DEFAULT NULL,
  `idpetugas` varchar(6) DEFAULT NULL,
  `total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblbrgmasuk`
--

INSERT INTO `tblbrgmasuk` (`nonota`, `tglmasuk`, `iddistributor`, `idpetugas`, `total`) VALUES
('N003', '17-Jan-2022', 'Pilih', 'Pilih', 0),
('N004', '17-Jan-2022', 'Pilih', 'Pilih', 0),
('N005', '18-Jan-2022', 'Pilih', 'Pilih', 0),
('N006', '18-Jan-2022', 'Pilih', 'Pilih', 0),
('N007', '18-Jan-2022', 'Pilih', 'Pilih', 0),
('N009', '18-Jan-2022', 'Pilih', 'Pilih', 0),
('N012', '19-Jan-2022', 'Pilih', 'Pilih', 0),
('N020', '20-Jan-2022', 'Pilih', 'Pilih', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbldata_brg`
--

CREATE TABLE `tbldata_brg` (
  `kodebarang` varchar(10) NOT NULL,
  `nama_brg` varchar(20) DEFAULT NULL,
  `kode_jenis` varchar(10) DEFAULT NULL,
  `jenis_brg` varchar(11) NOT NULL,
  `Harga_net` varchar(20) DEFAULT NULL,
  `Harga_jual` varchar(20) DEFAULT NULL,
  `Stock` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbldata_brg`
--

INSERT INTO `tbldata_brg` (`kodebarang`, `nama_brg`, `kode_jenis`, `jenis_brg`, `Harga_net`, `Harga_jual`, `Stock`) VALUES
('B001', 'TV', 'J001', 'Elektronik', '1500000', '1750000', '5'),
('B002', 'Laptop Asus', 'J001', 'Elektronik', '1200000', '1400000', '8'),
('B004', 'Xiaomi', 'J001', 'Elektronik', '1420000', '1500000', '14');

-- --------------------------------------------------------

--
-- Table structure for table `tbldetailbrgmasuk`
--

CREATE TABLE `tbldetailbrgmasuk` (
  `nonota` char(10) NOT NULL,
  `kodebarang` char(4) NOT NULL,
  `jumlah` smallint(4) DEFAULT NULL,
  `subtotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbldetailbrgmasuk`
--

INSERT INTO `tbldetailbrgmasuk` (`nonota`, `kodebarang`, `jumlah`, `subtotal`) VALUES
('N001', 'B002', 1, 12121),
('N002', 'B002', 1, 12121),
('N003', 'B002', 1, 12121),
('N004', 'B002', 1, 12121),
('N005', 'B002', 22, 266662),
('N006', 'B002', 11, 133331),
('N007', 'B002', 1, 12121),
('N009', 'B002', 2, 2600000),
('N012', 'B002', 2, 2600000),
('N020', 'B004', 2, 2840000);

-- --------------------------------------------------------

--
-- Table structure for table `tbldistributor`
--

CREATE TABLE `tbldistributor` (
  `iddistributor` char(6) NOT NULL,
  `namadistributor` varchar(80) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `kotaasal` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `telepon` char(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbldistributor`
--

INSERT INTO `tbldistributor` (`iddistributor`, `namadistributor`, `alamat`, `kotaasal`, `email`, `telepon`) VALUES
('D001', 'Unilever', 'Margahayu', 'Bandung', '@gmail.com', '088218609745'),
('D002', 'Xiaomi', 'Margahayu', 'Bandung', '@gmail.com', '08777648'),
('D003', 'Wings', 'Jl Sudirman', 'Jakarta', 'wings@gmail.com', '08723232323');

-- --------------------------------------------------------

--
-- Table structure for table `tbljenis`
--

CREATE TABLE `tbljenis` (
  `kode_jenis` char(4) NOT NULL,
  `Jenis` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbljenis`
--

INSERT INTO `tbljenis` (`kode_jenis`, `Jenis`) VALUES
('J001', 'Elektronik'),
('J002', 'Sabunn'),
('J003', 'Minuman');

-- --------------------------------------------------------

--
-- Table structure for table `tblpetugas`
--

CREATE TABLE `tblpetugas` (
  `idpetugas` varchar(6) NOT NULL,
  `namapetugas` varchar(80) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `email` varchar(80) NOT NULL,
  `telepon` int(15) NOT NULL,
  `password` varchar(100) NOT NULL,
  `hakakses` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblpetugas`
--

INSERT INTO `tblpetugas` (`idpetugas`, `namapetugas`, `alamat`, `email`, `telepon`, `password`, `hakakses`) VALUES
('P001', 'Farel', 'Jl Bunga', 'farell@gmai.com', 899585, '1234', 'Admin'),
('P002', 'Keanu', 'Jl Margahayu', 'Keanu@gmail.com', 877748744, '1234', 'Admin'),
('P003', 'Adi', 'Jl Mawar', 'aditamaputra3@gmail.com', 89994857, '1234', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblbrgmasuk`
--
ALTER TABLE `tblbrgmasuk`
  ADD PRIMARY KEY (`nonota`);

--
-- Indexes for table `tbldata_brg`
--
ALTER TABLE `tbldata_brg`
  ADD PRIMARY KEY (`kodebarang`);

--
-- Indexes for table `tbldetailbrgmasuk`
--
ALTER TABLE `tbldetailbrgmasuk`
  ADD PRIMARY KEY (`nonota`);

--
-- Indexes for table `tbldistributor`
--
ALTER TABLE `tbldistributor`
  ADD PRIMARY KEY (`iddistributor`);

--
-- Indexes for table `tbljenis`
--
ALTER TABLE `tbljenis`
  ADD PRIMARY KEY (`kode_jenis`);

--
-- Indexes for table `tblpetugas`
--
ALTER TABLE `tblpetugas`
  ADD PRIMARY KEY (`idpetugas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
