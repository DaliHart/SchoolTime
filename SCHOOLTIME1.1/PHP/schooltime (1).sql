-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 30, 2020 at 04:59 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `schooltime`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblevento`
--

CREATE TABLE `tblevento` (
  `id_evento` int(11) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `descripcion` text NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `codigo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblevento`
--

INSERT INTO `tblevento` (`id_evento`, `titulo`, `tipo`, `descripcion`, `fecha`, `hora`, `codigo`) VALUES
(20, 'Examen final', 'Cambio', 'Se realizará el examen a primera hora\r\n¡Muchos éxitos!', '2020-03-26', '12:30:00', 'BMW234'),
(21, 'Media Técnica', 'Cambio', 'Hoy jueves no tienen clase, nos vemos el lunes a las 7:00AM', '2020-03-30', '07:00:00', 'BMW234'),
(22, 'Salida pedagógica', 'Celebracion', 'Llevar coca y ropa de baño', '2020-03-27', '70:00:00', 'Lm987'),
(23, 'Entrega de notas', 'Reunion', 'Deben asistir con el estudiante de lo conrario no se le entregarán las caificaciones ', '2020-03-31', '15:30:00', 'JYT6VB'),
(24, 'Cremonia de grados bachilleres técnicos y académic', 'Celebracion', 'Todos los docentes favor llegar dos horas antes del evento para organizar protocolo', '2020-03-28', '12:21:21', 'Fg76QH'),
(25, 'Entrega de notas estudiates que ganaron el año', 'Reunion', 'Todos deben presentrase con el estudiante de lo contrario las notas no serán entregadas', '2020-03-31', '00:13:00', 'Fg76QH');

-- --------------------------------------------------------

--
-- Table structure for table `tblregistroacudiente`
--

CREATE TABLE `tblregistroacudiente` (
  `id_acudiente` int(11) NOT NULL,
  `nombreAcudiente` varchar(40) NOT NULL,
  `apellidoAcudiente` varchar(20) NOT NULL,
  `cedulaAcudiente` varchar(10) NOT NULL,
  `codigoAcudiente` varchar(10) NOT NULL,
  `correoAcudiente` varchar(50) NOT NULL,
  `contrasenaAcudiente` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tblregistrodocente`
--

CREATE TABLE `tblregistrodocente` (
  `id_docente` int(11) NOT NULL,
  `nombreDocente` varchar(40) NOT NULL,
  `apellidoDocente` varchar(20) NOT NULL,
  `cedulaDocente` varchar(10) NOT NULL,
  `codigoDocente` varchar(10) NOT NULL,
  `correoDocente` varchar(50) NOT NULL,
  `contrasenaDocente` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblregistrodocente`
--

INSERT INTO `tblregistrodocente` (`id_docente`, `nombreDocente`, `apellidoDocente`, `cedulaDocente`, `codigoDocente`, `correoDocente`, `contrasenaDocente`) VALUES
(46, 'Eliana', 'Sanchez ', '39176975', 'Hw3Ab23', 'eliana@gmail.com', '2'),
(47, 'Edison', 'Montoya ', '1000194305', 'Fg76QH', 'edison@gmail.com', '2');

-- --------------------------------------------------------

--
-- Table structure for table `tblregistroestudiante`
--

CREATE TABLE `tblregistroestudiante` (
  `id_estudiante` int(11) NOT NULL,
  `nombreEstudiante` varchar(40) NOT NULL,
  `apellidoEstudiante` varchar(20) NOT NULL,
  `identificacionEstudiante` varchar(10) NOT NULL,
  `matriculaEstudiante` varchar(10) NOT NULL,
  `codigoGrupo` varchar(10) NOT NULL,
  `correoEstudiante` varchar(50) NOT NULL,
  `contrasenaEstudiante` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblevento`
--
ALTER TABLE `tblevento`
  ADD PRIMARY KEY (`id_evento`);

--
-- Indexes for table `tblregistroacudiente`
--
ALTER TABLE `tblregistroacudiente`
  ADD PRIMARY KEY (`id_acudiente`);

--
-- Indexes for table `tblregistrodocente`
--
ALTER TABLE `tblregistrodocente`
  ADD PRIMARY KEY (`id_docente`);

--
-- Indexes for table `tblregistroestudiante`
--
ALTER TABLE `tblregistroestudiante`
  ADD PRIMARY KEY (`id_estudiante`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tblevento`
--
ALTER TABLE `tblevento`
  MODIFY `id_evento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `tblregistroacudiente`
--
ALTER TABLE `tblregistroacudiente`
  MODIFY `id_acudiente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tblregistrodocente`
--
ALTER TABLE `tblregistrodocente`
  MODIFY `id_docente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT for table `tblregistroestudiante`
--
ALTER TABLE `tblregistroestudiante`
  MODIFY `id_estudiante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
