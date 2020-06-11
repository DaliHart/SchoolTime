-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-06-2020 a las 16:49:39
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `stime`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_acudiente`
--

CREATE TABLE `tbl_acudiente` (
  `id_acudiente` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre_acu` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `apellido_acu` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `correo_acu` varchar(60) COLLATE utf8_spanish2_ci NOT NULL,
  `contrasena_acu` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `codigo_g` varchar(10) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_administrador`
--

CREATE TABLE `tbl_administrador` (
  `id_administrador` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre_adm` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `apellido_adm` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `usuario_adm` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `contrasena_adm` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `cargo_adm` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tbl_administrador`
--

INSERT INTO `tbl_administrador` (`id_administrador`, `nombre_adm`, `apellido_adm`, `usuario_adm`, `contrasena_adm`, `cargo_adm`) VALUES
('968796', 'Deyli Johana', 'Marin Corrales', 'deyli11', '123', 'Disenadora & Dev');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_docente`
--

CREATE TABLE `tbl_docente` (
  `id_docente` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre_doc` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `apellido_doc` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `correo_doc` varchar(60) COLLATE utf8_spanish2_ci NOT NULL,
  `contrasena_doc` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `codigo_g` varchar(10) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tbl_docente`
--

INSERT INTO `tbl_docente` (`id_docente`, `nombre_doc`, `apellido_doc`, `correo_doc`, `contrasena_doc`, `codigo_g`) VALUES
('2fd279a3-6', 'Andrea', 'Gallo', 'marindeyli@gmail.com', '123', 'ASBCUWE$3.'),
('3b75e141-6', 'Andrea', 'Gallo', 'itsartdraw@gmail.com', '123', 'ASBCUWE$3.'),
('45935336-6', 'Andrea', 'Gallo', 'shcooltimee@gmail.com', '123', 'ASBCUWE$3.'),
('5714e956-6', 'Andrea', 'Gallo', '', '123', 'ASBCUWE$3.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_estudiante`
--

CREATE TABLE `tbl_estudiante` (
  `id_estudiante` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre_e` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `apellido_e` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `matricula_e` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `contrasena_e` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `codigo_g` varchar(10) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tbl_estudiante`
--

INSERT INTO `tbl_estudiante` (`id_estudiante`, `nombre_e`, `apellido_e`, `matricula_e`, `contrasena_e`, `codigo_g`) VALUES
('1025874596', 'Hazel', 'Leeds', '2131516', '123', 'FSNDF8/,3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_evento`
--

CREATE TABLE `tbl_evento` (
  `id_evento` int(11) NOT NULL,
  `titulo_e` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion_e` text COLLATE utf8_spanish2_ci NOT NULL,
  `estado_e` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `id_tipo` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `id_fecha` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `id_horas` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `id_administrador` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `id_moderador` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `fecha_creacion_evento` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tbl_evento`
--

INSERT INTO `tbl_evento` (`id_evento`, `titulo_e`, `descripcion_e`, `estado_e`, `id_tipo`, `id_fecha`, `id_horas`, `id_administrador`, `id_moderador`, `fecha_creacion_evento`) VALUES
(28, 'Día de Amor y Amistad', 'Todos los estudiantes deberán participar en la actividad preparada.', '', '00A', '6e1205f1-6be2-11ea-bb59-dcf50590531a', '6e27293f-6be2-11ea-bb59-dcf50590531a', '968796', '589796', '2020-03-21 21:11:24'),
(31, 'Reunión de Docentes', 'Reunión de fin de periodo.', '', '00C', '93d8a1d4-6c59-11ea-b739-dcf50590531a', '93dec22c-6c59-11ea-b739-dcf50590531a', '968796', '589796', '2020-03-22 11:24:17'),
(35, 'Reunión de Docentes', 'Reunión para evaluación del desempeño de los estudiantes', '', '00C', '110db4c0-6cc9-11ea-b739-dcf50590531a', '1115a8e9-6cc9-11ea-b739-dcf50590531a', '968796', '589796', '2020-03-23 00:42:08'),
(36, 'No hay clase', 'Por cuestiones fuera de nuestro alcance no habrán clases', '', '00B', '9a0e88b4-6cc9-11ea-b739-dcf50590531a', '9a1636db-6cc9-11ea-b739-dcf50590531a', '968796', '589796', '2020-03-23 00:45:58'),
(37, 'Reunión de Docentes', 'Preparación de plan de contingencia', '', '00C', '3612e830-6cca-11ea-b739-dcf50590531a', '3625709c-6cca-11ea-b739-dcf50590531a', '968796', '589796', '2020-03-23 00:50:20'),
(39, 'Reunión de Acudientes', 'Reunión', '', '00C', '18780dc3-6ccc-11ea-b739-dcf50590531a', '187ea7cd-6ccc-11ea-b739-dcf50590531a', '968796', '589796', '2020-03-23 01:03:49'),
(40, 'Reunión de Docentes', 'Reunión', '', '00C', '5ce224fe-6ccc-11ea-b739-dcf50590531a', '5ceb8b64-6ccc-11ea-b739-dcf50590531a', '968796', '589796', '2020-03-23 01:05:44'),
(41, 'Reunión de Directores de Grupo', 'Última revisión de...', '', '00C', '44b4922d-6ccd-11ea-b739-dcf50590531a', '44bd3398-6ccd-11ea-b739-dcf50590531a', '968796', '589796', '2020-03-23 01:12:13'),
(43, 'Cambio en el horario', 'La clase de matematicas, cambia por ingles', '', '00B', '44957f17-6d14-11ea-b946-dcf50590531a', '449fb44a-6d14-11ea-b946-dcf50590531a', '968796', '589796', '2020-03-23 09:40:38'),
(44, 'No hay clase', 'Por..', '', '00B', 'fa0e74fa-6d14-11ea-b946-dcf50590531a', 'fa170641-6d14-11ea-b946-dcf50590531a', '968796', '589796', '2020-03-23 09:45:43'),
(45, 'Reunión de Acudientes', 'Reunión de Acudientes', 'CANCELADO', '00C', '359f810a-8af0-11ea-9833-dcf50590531a', '35a6e50f-8af0-11ea-9833-dcf50590531a', '968796', '589796', '2020-04-30 09:38:08'),
(46, 'Cambio en el horario', 'H', 'PROGRAMADO', '00B', '2ab93b97-8af1-11ea-9833-dcf50590531a', '2abf4652-8af1-11ea-9833-dcf50590531a', '968796', '589796', '2020-04-30 09:44:59'),
(47, 'No hay clase', 'H', 'CANCELADO', '00B', '46442198-8af1-11ea-9833-dcf50590531a', '464e720d-8af1-11ea-9833-dcf50590531a', '968796', '589796', '2020-04-30 09:45:45'),
(48, 'Reunión de Acudientes', 'd', 'PROGRAMADO', '00B', '56c41037-8afd-11ea-9833-dcf50590531a', '56d920a2-8afd-11ea-9833-dcf50590531a', '968796', '589796', '2020-04-30 11:12:07'),
(49, 'S', 'S', 'PROGRAMADO', '00C', '61c4b29d-8afd-11ea-9833-dcf50590531a', '61cb0334-8afd-11ea-9833-dcf50590531a', '968796', '589796', '2020-04-30 11:12:25'),
(50, 'SS', 'h', 'PROGRAMADO', '00C', '81b9abba-8afd-11ea-9833-dcf50590531a', '81cd5d05-8afd-11ea-9833-dcf50590531a', '968796', '589796', '2020-04-30 11:13:19'),
(51, 'Reunión de Acudientes', 'Reunión acerca de el rendimiento académico de los estudiantes.', 'PROGRAMADO', '00C', 'a8a4b529-ab3f-11ea-bc3b-dcf50590531a', 'a8ae3316-ab3f-11ea-bc3b-dcf50590531a', '968796', '589796', '2020-06-10 12:27:28'),
(52, 'Ceremonia de Graduación', 'Estudiantes y Docentes llegar a las 12:00 p.m.\r\n\r\nAcudientes a las 4:00 p.m.\r\nRecuerden llevar su invitación.', 'PROGRAMADO', '00A', '869c9e54-ab45-11ea-bc3b-dcf50590531a', '86a6ff01-ab45-11ea-bc3b-dcf50590531a', '968796', '589796', '2020-06-10 13:09:28');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_eventoxgrupo`
--

CREATE TABLE `tbl_eventoxgrupo` (
  `id_evento` int(11) NOT NULL,
  `codigo_g` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `estudiante` int(11) NOT NULL,
  `acudiente` int(11) NOT NULL,
  `docente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tbl_eventoxgrupo`
--

INSERT INTO `tbl_eventoxgrupo` (`id_evento`, `codigo_g`, `estudiante`, `acudiente`, `docente`) VALUES
(28, 'EWEFG34', 1, 0, 0),
(28, 'AQW3ED%GT', 1, 0, 0),
(28, 'aSEWD.Y/6', 1, 0, 0),
(28, 'FSNDF8/,3', 1, 0, 0),
(31, 'EWEFG34', 0, 0, 1),
(35, 'ASBCUWE$3.', 0, 0, 1),
(36, 'ASBCUWE$3.', 0, 0, 1),
(37, 'ASBCUWE$3.', 0, 0, 1),
(39, 'ASBCUWE$3.', 0, 0, 1),
(40, 'ASBCUWE$3.', 0, 0, 1),
(43, 'FSNDF8/,3', 1, 0, 0),
(44, 'FSNDF8/,3', 1, 0, 0),
(41, 'aSEWD.Y/6', 0, 0, 1),
(45, 'ASBCUWE$3.', 0, 1, 0),
(45, 'EWEFG34', 0, 1, 0),
(45, 'AQW3ED%GT', 0, 1, 0),
(45, 'aSEWD.Y/6', 0, 1, 0),
(45, 'FSNDF8/,3', 0, 1, 0),
(46, 'FSNDF8/,3', 1, 1, 0),
(47, 'FSNDF8/,3', 1, 1, 0),
(48, 'ASBCUWE$3.', 1, 0, 0),
(49, 'ASBCUWE$3.', 1, 0, 0),
(49, 'EWEFG34', 1, 0, 0),
(49, 'AQW3ED%GT', 1, 0, 0),
(49, 'aSEWD.Y/6', 1, 0, 0),
(49, 'FSNDF8/,3', 1, 0, 0),
(50, 'ASBCUWE$3.', 1, 0, 0),
(51, '34', 0, 1, 0),
(51, 'ASBCUWE$3.', 0, 1, 0),
(51, 'EWEFG34', 0, 1, 0),
(51, 'AQW3ED%GT', 0, 1, 0),
(51, 'aSEWD.Y/6', 0, 1, 0),
(51, 'FSNDF8/,3', 0, 1, 0),
(52, 'sDWE23/ht', 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_fecha_evento`
--

CREATE TABLE `tbl_fecha_evento` (
  `id_fecha` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `fecha_publicacion` date NOT NULL,
  `fecha_evento` date NOT NULL,
  `fecha_eliminacion` date NOT NULL,
  `fecha_creacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tbl_fecha_evento`
--

INSERT INTO `tbl_fecha_evento` (`id_fecha`, `fecha_publicacion`, `fecha_evento`, `fecha_eliminacion`, `fecha_creacion`) VALUES
('040b5cff-6cce-11ea-b739-dcf50590531a', '2020-03-23', '2020-03-24', '2020-03-25', '2020-03-23 01:17:34'),
('0dacac70-6641-11ea-a1d2-dcf50590531a', '2020-03-14', '2020-03-23', '2020-03-24', '2020-03-14 17:13:37'),
('110db4c0-6cc9-11ea-b739-dcf50590531a', '2020-03-23', '2020-03-24', '2020-03-25', '2020-03-23 00:42:08'),
('12139247-6cc7-11ea-b739-dcf50590531a', '2020-03-23', '2020-03-30', '2020-03-31', '2020-03-23 00:27:51'),
('18780dc3-6ccc-11ea-b739-dcf50590531a', '2020-03-23', '2020-03-30', '2020-03-31', '2020-03-23 01:03:49'),
('21f340a8-67d0-11ea-93fa-dcf50590531a', '2020-03-16', '2020-03-17', '2020-03-18', '2020-03-16 16:50:20'),
('2ab93b97-8af1-11ea-9833-dcf50590531a', '2020-04-30', '2020-05-01', '2020-05-02', '2020-04-30 09:44:59'),
('2c17fcec-663f-11ea-a1d2-dcf50590531a', '2020-03-14', '2020-03-16', '2020-03-17', '2020-03-14 17:00:09'),
('351059f5-6be3-11ea-bb59-dcf50590531a', '2020-03-21', '2020-03-30', '2020-03-31', '2020-03-21 21:16:58'),
('359f810a-8af0-11ea-9833-dcf50590531a', '2020-04-30', '2020-04-30', '2020-05-01', '2020-04-30 09:38:08'),
('3612e830-6cca-11ea-b739-dcf50590531a', '2020-03-23', '2020-03-24', '2020-03-25', '2020-03-23 00:50:20'),
('3d9118f4-6a48-11ea-a537-dcf50590531a', '2020-03-19', '2020-03-23', '2020-03-24', '2020-03-19 20:15:08'),
('44957f17-6d14-11ea-b946-dcf50590531a', '2020-03-23', '2020-03-30', '2020-03-31', '2020-03-23 09:40:38'),
('44b4922d-6ccd-11ea-b739-dcf50590531a', '2020-03-23', '2020-03-30', '2020-03-31', '2020-03-23 01:12:13'),
('46442198-8af1-11ea-9833-dcf50590531a', '2020-04-30', '2020-05-01', '2020-05-02', '2020-04-30 09:45:45'),
('4ff396e0-6737-11ea-89db-dcf50590531a', '2020-03-15', '2020-03-15', '2020-03-16', '2020-03-15 22:36:25'),
('522c87eb-6990-11ea-aa55-dcf50590531a', '2020-03-18', '2020-03-24', '2020-03-25', '2020-03-18 22:18:36'),
('53746e10-6669-11ea-9d98-dcf50590531a', '2020-03-14', '2020-04-05', '2020-04-06', '2020-03-14 22:01:54'),
('56c41037-8afd-11ea-9833-dcf50590531a', '2020-04-30', '2021-05-31', '2021-06-01', '2020-04-30 11:12:07'),
('596b1970-67fd-11ea-93fa-dcf50590531a', '2020-03-16', '2020-03-17', '2020-03-18', '2020-03-16 22:14:01'),
('5ce224fe-6ccc-11ea-b739-dcf50590531a', '2020-03-23', '2020-03-30', '2020-03-31', '2020-03-23 01:05:44'),
('61c4b29d-8afd-11ea-9833-dcf50590531a', '2020-04-30', '2021-05-31', '2021-06-01', '2020-04-30 11:12:25'),
('69f7e91b-666a-11ea-9d98-dcf50590531a', '2020-03-14', '2020-05-05', '2020-05-06', '2020-03-14 22:09:41'),
('6e1205f1-6be2-11ea-bb59-dcf50590531a', '2020-03-21', '2020-03-23', '2020-03-24', '2020-03-21 21:11:24'),
('7fdd7bfd-6a50-11ea-a537-dcf50590531a', '2020-03-19', '2020-03-23', '2020-03-24', '2020-03-19 21:14:16'),
('81b9abba-8afd-11ea-9833-dcf50590531a', '2020-04-30', '2021-05-31', '2021-06-01', '2020-04-30 11:13:19'),
('869c9e54-ab45-11ea-bc3b-dcf50590531a', '2020-06-10', '2018-11-23', '2018-11-24', '2020-06-10 13:09:28'),
('905ad401-671b-11ea-89db-dcf50590531a', '2020-03-15', '2020-03-16', '2020-03-17', '2020-03-15 19:17:47'),
('93d8a1d4-6c59-11ea-b739-dcf50590531a', '2020-03-22', '2020-03-23', '2020-03-24', '2020-03-22 11:24:17'),
('959a1ae7-6638-11ea-a1d2-dcf50590531a', '2020-03-14', '2020-03-12', '2020-03-13', '2020-03-14 16:13:00'),
('9a0e88b4-6cc9-11ea-b739-dcf50590531a', '2020-03-23', '2020-03-30', '2020-03-31', '2020-03-23 00:45:58'),
('9abcff29-6a13-11ea-b95d-dcf50590531a', '2020-03-19', '2020-03-23', '2020-03-24', '2020-03-19 13:58:22'),
('9ae8b8d9-6ccb-11ea-b739-dcf50590531a', '2020-03-23', '2020-03-30', '2020-03-31', '2020-03-23 01:00:19'),
('9d943e77-698c-11ea-aa55-dcf50590531a', '2020-03-18', '2020-03-23', '2020-03-24', '2020-03-18 21:52:04'),
('9f061680-6cc6-11ea-b739-dcf50590531a', '2020-03-23', '2020-03-24', '2020-03-25', '2020-03-23 00:24:38'),
('9f40c3ec-6638-11ea-a1d2-dcf50590531a', '2020-03-14', '2020-04-18', '2020-04-19', '2020-03-14 16:13:16'),
('a36b7132-6990-11ea-aa55-dcf50590531a', '2020-03-18', '2020-03-20', '2020-03-21', '2020-03-18 22:20:52'),
('a8a4b529-ab3f-11ea-bc3b-dcf50590531a', '2020-06-10', '2020-06-11', '2020-06-12', '2020-06-10 12:27:28'),
('a9ef328f-6638-11ea-a1d2-dcf50590531a', '2020-03-14', '2020-05-20', '2020-05-21', '2020-03-14 16:13:34'),
('cae62ab2-6a13-11ea-b95d-dcf50590531a', '2020-03-19', '2020-03-16', '2020-03-17', '2020-03-19 13:59:42'),
('ccfac75c-6a50-11ea-a537-dcf50590531a', '2020-03-19', '2020-03-23', '2020-03-24', '2020-03-19 21:16:25'),
('d163a886-671a-11ea-89db-dcf50590531a', '2020-03-15', '2020-02-17', '2020-02-18', '2020-03-15 19:12:26'),
('d3b623ea-6be2-11ea-bb59-dcf50590531a', '2020-03-21', '2020-03-23', '2020-03-24', '2020-03-21 21:14:14'),
('d3f77512-6669-11ea-9d98-dcf50590531a', '2020-03-14', '2020-03-30', '2020-03-31', '2020-03-14 22:05:30'),
('dc358ca8-671b-11ea-89db-dcf50590531a', '2020-03-15', '2020-03-19', '2020-03-20', '2020-03-15 19:19:54'),
('dd38864f-6a13-11ea-b95d-dcf50590531a', '2020-03-19', '2020-03-23', '2020-03-24', '2020-03-19 14:00:13'),
('e4d2e1c7-6718-11ea-89db-dcf50590531a', '2020-03-15', '2020-03-23', '2020-03-24', '2020-03-15 18:58:40'),
('f08cd5dd-6ae7-11ea-8d86-dcf50590531a', '2020-03-20', '2020-03-23', '2020-03-24', '2020-03-20 15:18:19'),
('f5e8d05f-6cc6-11ea-b739-dcf50590531a', '2020-03-23', '2020-03-24', '2020-03-25', '2020-03-23 00:27:04'),
('f8dc3907-6a12-11ea-b95d-dcf50590531a', '2020-03-19', '2020-03-20', '2020-03-21', '2020-03-19 13:53:50'),
('fa0e74fa-6d14-11ea-b946-dcf50590531a', '2020-03-23', '2020-03-24', '2020-03-25', '2020-03-23 09:45:43');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_grupo`
--

CREATE TABLE `tbl_grupo` (
  `codigo_g` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `grado_g` int(11) NOT NULL,
  `grupo_g` varchar(3) COLLATE utf8_spanish2_ci NOT NULL,
  `id_jornada` varchar(3) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tbl_grupo`
--

INSERT INTO `tbl_grupo` (`codigo_g`, `grado_g`, `grupo_g`, `id_jornada`) VALUES
('34', 0, '3', 'J2'),
('AQW3ED%GT', 9, '3', 'J2'),
('ASBCUWE$3.', 7, '8', 'J2'),
('aSEWD.Y/6', 10, '2', 'J1'),
('EWEFG34', 8, '3', 'J2'),
('FSNDF8/,3', 10, '4', 'J1'),
('sDWE23/ht', 11, '1', 'J1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_hora_evento`
--

CREATE TABLE `tbl_hora_evento` (
  `id_horas` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `hora_publicacion` time NOT NULL,
  `hora_evento` time NOT NULL,
  `hora_eliminacion` time NOT NULL,
  `fecha_creacion_hora` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tbl_hora_evento`
--

INSERT INTO `tbl_hora_evento` (`id_horas`, `hora_publicacion`, `hora_evento`, `hora_eliminacion`, `fecha_creacion_hora`) VALUES
('041ff863-6cce-11ea-b739-dcf50590531a', '01:17:34', '01:17:00', '00:00:00', '2020-03-23 01:17:34'),
('0dc2b512-6641-11ea-a1d2-dcf50590531a', '17:13:37', '12:00:00', '00:00:00', '2020-03-14 17:13:37'),
('1115a8e9-6cc9-11ea-b739-dcf50590531a', '00:42:08', '03:00:00', '00:00:00', '2020-03-23 00:42:08'),
('1221aaf9-6cc7-11ea-b739-dcf50590531a', '00:27:51', '01:28:00', '00:00:00', '2020-03-23 00:27:51'),
('187ea7cd-6ccc-11ea-b739-dcf50590531a', '01:03:49', '01:03:00', '00:00:00', '2020-03-23 01:03:49'),
('220ccd33-67d0-11ea-93fa-dcf50590531a', '16:50:21', '16:44:00', '00:00:00', '2020-03-16 16:50:21'),
('2abf4652-8af1-11ea-9833-dcf50590531a', '09:44:59', '08:43:00', '00:00:00', '2020-04-30 09:44:59'),
('2c3a7d2b-663f-11ea-a1d2-dcf50590531a', '17:00:09', '12:00:00', '00:00:00', '2020-03-14 17:00:09'),
('3524e32e-6be3-11ea-bb59-dcf50590531a', '21:16:58', '12:17:00', '00:00:00', '2020-03-21 21:16:58'),
('35a6e50f-8af0-11ea-9833-dcf50590531a', '09:38:08', '14:00:00', '00:00:00', '2020-04-30 09:38:08'),
('3625709c-6cca-11ea-b739-dcf50590531a', '00:50:20', '01:50:00', '00:00:00', '2020-03-23 00:50:20'),
('3e03cd34-6a48-11ea-a537-dcf50590531a', '20:15:09', '14:30:00', '00:00:00', '2020-03-19 20:15:09'),
('449fb44a-6d14-11ea-b946-dcf50590531a', '09:40:38', '15:30:00', '00:00:00', '2020-03-23 09:40:38'),
('44bd3398-6ccd-11ea-b739-dcf50590531a', '01:12:13', '01:13:00', '00:00:00', '2020-03-23 01:12:13'),
('464e720d-8af1-11ea-9833-dcf50590531a', '09:45:45', '10:46:00', '00:00:00', '2020-04-30 09:45:45'),
('50098298-6737-11ea-89db-dcf50590531a', '22:36:25', '22:35:00', '00:00:00', '2020-03-15 22:36:25'),
('5246d9c5-6990-11ea-aa55-dcf50590531a', '22:18:36', '12:30:00', '00:00:00', '2020-03-18 22:18:36'),
('5386b151-6669-11ea-9d98-dcf50590531a', '22:01:54', '05:05:00', '00:00:00', '2020-03-14 22:01:54'),
('56d920a2-8afd-11ea-9833-dcf50590531a', '11:12:07', '00:12:00', '00:00:00', '2020-04-30 11:12:07'),
('597c3e65-67fd-11ea-93fa-dcf50590531a', '22:14:01', '16:56:00', '00:00:00', '2020-03-16 22:14:01'),
('5ceb8b64-6ccc-11ea-b739-dcf50590531a', '01:05:44', '01:06:00', '00:00:00', '2020-03-23 01:05:44'),
('61cb0334-8afd-11ea-9833-dcf50590531a', '11:12:25', '00:13:00', '00:00:00', '2020-04-30 11:12:25'),
('6a0274c5-666a-11ea-9d98-dcf50590531a', '22:09:41', '05:05:00', '00:00:00', '2020-03-14 22:09:41'),
('6e27293f-6be2-11ea-bb59-dcf50590531a', '21:11:24', '12:00:00', '00:00:00', '2020-03-21 21:11:24'),
('7fe5d24d-6a50-11ea-a537-dcf50590531a', '21:14:16', '22:15:00', '00:00:00', '2020-03-19 21:14:16'),
('81cd5d05-8afd-11ea-9833-dcf50590531a', '11:13:19', '00:14:00', '00:00:00', '2020-04-30 11:13:19'),
('86a6ff01-ab45-11ea-bc3b-dcf50590531a', '13:09:28', '16:00:00', '00:00:00', '2020-06-10 13:09:28'),
('9068231a-671b-11ea-89db-dcf50590531a', '19:17:47', '12:00:00', '00:00:00', '2020-03-15 19:17:47'),
('93dec22c-6c59-11ea-b739-dcf50590531a', '11:24:17', '10:00:00', '00:00:00', '2020-03-22 11:24:17'),
('9a1636db-6cc9-11ea-b739-dcf50590531a', '00:45:58', '01:46:00', '00:00:00', '2020-03-23 00:45:58'),
('9ac778d6-6a13-11ea-b95d-dcf50590531a', '13:58:22', '12:00:00', '00:00:00', '2020-03-19 13:58:22'),
('9afe20ce-6ccb-11ea-b739-dcf50590531a', '01:00:19', '01:00:00', '00:00:00', '2020-03-23 01:00:19'),
('9d9d7148-698c-11ea-aa55-dcf50590531a', '21:52:04', '14:00:00', '00:00:00', '2020-03-18 21:52:04'),
('9f124666-6cc6-11ea-b739-dcf50590531a', '00:24:38', '12:00:00', '00:00:00', '2020-03-23 00:24:38'),
('a38ec97d-6990-11ea-aa55-dcf50590531a', '22:20:52', '11:00:00', '00:00:00', '2020-03-18 22:20:52'),
('a8ae3316-ab3f-11ea-bc3b-dcf50590531a', '12:27:28', '14:00:00', '00:00:00', '2020-06-10 12:27:28'),
('cb0e81ff-6a13-11ea-b95d-dcf50590531a', '13:59:43', '12:00:00', '00:00:00', '2020-03-19 13:59:43'),
('cd2ba053-6a50-11ea-a537-dcf50590531a', '21:16:25', '22:17:00', '00:00:00', '2020-03-19 21:16:25'),
('d1924f10-671a-11ea-89db-dcf50590531a', '19:12:27', '00:00:00', '00:00:00', '2020-03-15 19:12:27'),
('d3bc8a27-6be2-11ea-bb59-dcf50590531a', '21:14:14', '22:14:00', '00:00:00', '2020-03-21 21:14:14'),
('d41066bd-6669-11ea-9d98-dcf50590531a', '22:05:30', '05:05:00', '00:00:00', '2020-03-14 22:05:30'),
('dc4eecdc-671b-11ea-89db-dcf50590531a', '19:19:54', '11:45:00', '00:00:00', '2020-03-15 19:19:54'),
('dd4ddba0-6a13-11ea-b95d-dcf50590531a', '14:00:13', '13:00:00', '00:00:00', '2020-03-19 14:00:13'),
('e4dcd200-6718-11ea-89db-dcf50590531a', '18:58:40', '04:44:00', '00:00:00', '2020-03-15 18:58:40'),
('f0931b8d-6ae7-11ea-8d86-dcf50590531a', '15:18:19', '16:19:00', '00:00:00', '2020-03-20 15:18:19'),
('f60aa94c-6cc6-11ea-b739-dcf50590531a', '00:27:04', '01:27:00', '00:00:00', '2020-03-23 00:27:04'),
('f8e1c0e2-6a12-11ea-b95d-dcf50590531a', '13:53:50', '16:00:00', '00:00:00', '2020-03-19 13:53:50'),
('fa170641-6d14-11ea-b946-dcf50590531a', '09:45:43', '10:46:00', '00:00:00', '2020-03-23 09:45:43');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_jornada`
--

CREATE TABLE `tbl_jornada` (
  `id_jornada` varchar(3) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion_j` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tbl_jornada`
--

INSERT INTO `tbl_jornada` (`id_jornada`, `descripcion_j`) VALUES
('J1', 'Jornada Mañana'),
('J2', 'Jornada Tarde');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_moderador`
--

CREATE TABLE `tbl_moderador` (
  `id_moderador` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre_mod` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `apellido_mod` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `usuario_mod` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `contrasena_mod` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `cargo_mod` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tbl_moderador`
--

INSERT INTO `tbl_moderador` (`id_moderador`, `nombre_mod`, `apellido_mod`, `usuario_mod`, `contrasena_mod`, `cargo_mod`) VALUES
('589796', 'Cristian Alejandro', 'Restrepo Yepes', 'alejo12', '123', 'Disenador & Dev'),
('cfa22b71-6', 'Deyli', 'Marin', 'dey123', '123', 'Programadora'),
('d61ea800-8', 'Janus', 'Parias', 'janus75', '123', 'Reciclador'),
('de945193-8', 'Janus', 'Alvarez', 'janus75', '123', 'Vago');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_tipo_evento`
--

CREATE TABLE `tbl_tipo_evento` (
  `id_tipo` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `celebracion` int(11) NOT NULL,
  `cambio_horario` int(11) NOT NULL,
  `reunion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tbl_tipo_evento`
--

INSERT INTO `tbl_tipo_evento` (`id_tipo`, `celebracion`, `cambio_horario`, `reunion`) VALUES
('00A', 1, 0, 0),
('00B', 0, 1, 0),
('00C', 0, 0, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_acudiente`
--
ALTER TABLE `tbl_acudiente`
  ADD PRIMARY KEY (`id_acudiente`),
  ADD KEY `codigo_g` (`codigo_g`);

--
-- Indices de la tabla `tbl_administrador`
--
ALTER TABLE `tbl_administrador`
  ADD PRIMARY KEY (`id_administrador`);

--
-- Indices de la tabla `tbl_docente`
--
ALTER TABLE `tbl_docente`
  ADD PRIMARY KEY (`id_docente`),
  ADD KEY `codigo_g` (`codigo_g`);

--
-- Indices de la tabla `tbl_estudiante`
--
ALTER TABLE `tbl_estudiante`
  ADD PRIMARY KEY (`id_estudiante`),
  ADD KEY `codigo_g` (`codigo_g`);

--
-- Indices de la tabla `tbl_evento`
--
ALTER TABLE `tbl_evento`
  ADD PRIMARY KEY (`id_evento`),
  ADD KEY `id_tipo` (`id_tipo`),
  ADD KEY `id_fecha` (`id_fecha`),
  ADD KEY `id_horas` (`id_horas`),
  ADD KEY `id_administrador` (`id_administrador`),
  ADD KEY `id_moderador` (`id_moderador`);

--
-- Indices de la tabla `tbl_eventoxgrupo`
--
ALTER TABLE `tbl_eventoxgrupo`
  ADD KEY `id_evento` (`id_evento`),
  ADD KEY `codigo_g` (`codigo_g`);

--
-- Indices de la tabla `tbl_fecha_evento`
--
ALTER TABLE `tbl_fecha_evento`
  ADD PRIMARY KEY (`id_fecha`);

--
-- Indices de la tabla `tbl_grupo`
--
ALTER TABLE `tbl_grupo`
  ADD PRIMARY KEY (`codigo_g`),
  ADD KEY `id_jornada` (`id_jornada`);

--
-- Indices de la tabla `tbl_hora_evento`
--
ALTER TABLE `tbl_hora_evento`
  ADD PRIMARY KEY (`id_horas`);

--
-- Indices de la tabla `tbl_jornada`
--
ALTER TABLE `tbl_jornada`
  ADD PRIMARY KEY (`id_jornada`);

--
-- Indices de la tabla `tbl_moderador`
--
ALTER TABLE `tbl_moderador`
  ADD PRIMARY KEY (`id_moderador`);

--
-- Indices de la tabla `tbl_tipo_evento`
--
ALTER TABLE `tbl_tipo_evento`
  ADD PRIMARY KEY (`id_tipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_evento`
--
ALTER TABLE `tbl_evento`
  MODIFY `id_evento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_acudiente`
--
ALTER TABLE `tbl_acudiente`
  ADD CONSTRAINT `tbl_acudiente_ibfk_1` FOREIGN KEY (`codigo_g`) REFERENCES `tbl_grupo` (`codigo_g`);

--
-- Filtros para la tabla `tbl_docente`
--
ALTER TABLE `tbl_docente`
  ADD CONSTRAINT `tbl_docente_ibfk_1` FOREIGN KEY (`codigo_g`) REFERENCES `tbl_grupo` (`codigo_g`);

--
-- Filtros para la tabla `tbl_estudiante`
--
ALTER TABLE `tbl_estudiante`
  ADD CONSTRAINT `tbl_estudiante_ibfk_1` FOREIGN KEY (`codigo_g`) REFERENCES `tbl_grupo` (`codigo_g`);

--
-- Filtros para la tabla `tbl_evento`
--
ALTER TABLE `tbl_evento`
  ADD CONSTRAINT `tbl_evento_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tbl_tipo_evento` (`id_tipo`),
  ADD CONSTRAINT `tbl_evento_ibfk_2` FOREIGN KEY (`id_fecha`) REFERENCES `tbl_fecha_evento` (`id_fecha`),
  ADD CONSTRAINT `tbl_evento_ibfk_3` FOREIGN KEY (`id_horas`) REFERENCES `tbl_hora_evento` (`id_horas`),
  ADD CONSTRAINT `tbl_evento_ibfk_4` FOREIGN KEY (`id_administrador`) REFERENCES `tbl_administrador` (`id_administrador`),
  ADD CONSTRAINT `tbl_evento_ibfk_5` FOREIGN KEY (`id_moderador`) REFERENCES `tbl_moderador` (`id_moderador`);

--
-- Filtros para la tabla `tbl_eventoxgrupo`
--
ALTER TABLE `tbl_eventoxgrupo`
  ADD CONSTRAINT `tbl_eventoxgrupo_ibfk_1` FOREIGN KEY (`id_evento`) REFERENCES `tbl_evento` (`id_evento`),
  ADD CONSTRAINT `tbl_eventoxgrupo_ibfk_2` FOREIGN KEY (`codigo_g`) REFERENCES `tbl_grupo` (`codigo_g`);

--
-- Filtros para la tabla `tbl_grupo`
--
ALTER TABLE `tbl_grupo`
  ADD CONSTRAINT `tbl_grupo_ibfk_1` FOREIGN KEY (`id_jornada`) REFERENCES `tbl_jornada` (`id_jornada`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
