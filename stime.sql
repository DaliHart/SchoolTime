-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-06-2020 a las 12:45:08
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

--
-- Volcado de datos para la tabla `tbl_acudiente`
--

INSERT INTO `tbl_acudiente` (`id_acudiente`, `nombre_acu`, `apellido_acu`, `correo_acu`, `contrasena_acu`, `codigo_g`) VALUES
('809332', 'Laura', 'Gómez', 'laug@email.com', '123', 'aSEWD.Y/6');

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
('9678567', 'Administrador', 'Administrador', 'deyli11', '123', 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_adminxevento`
--

CREATE TABLE `tbl_adminxevento` (
  `id_administrador` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `id_evento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tbl_adminxevento`
--

INSERT INTO `tbl_adminxevento` (`id_administrador`, `id_evento`) VALUES
('9678567', 76),
('9678567', 81);

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
('10932039', 'Felipe', 'Salas', 'fsalas@email.com', '123456', 'FSNDF8/,3'),
('1818181818', 'deyli', 'marín', 'marindeyli@gmail.com', '123', '34'),
('82309423', 'Serena', 'Durango', 'serena@email.com', '123', 'DOCENTES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_estudiante`
--

CREATE TABLE `tbl_estudiante` (
  `id_estudiante` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre_e` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `apellido_e` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `matricula_e` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `correo_e` varchar(60) COLLATE utf8_spanish2_ci NOT NULL,
  `contrasena_e` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `codigo_g` varchar(10) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tbl_estudiante`
--

INSERT INTO `tbl_estudiante` (`id_estudiante`, `nombre_e`, `apellido_e`, `matricula_e`, `correo_e`, `contrasena_e`, `codigo_g`) VALUES
('84908940', 'Sandra', 'Rodriguez', '1234433', 'sandra@email.com', '123', 'ASBCUWE$3.');

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
  `fecha_creacion_evento` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tbl_evento`
--

INSERT INTO `tbl_evento` (`id_evento`, `titulo_e`, `descripcion_e`, `estado_e`, `id_tipo`, `id_fecha`, `id_horas`, `fecha_creacion_evento`) VALUES
(76, 'Reunión de Acudientes', 'Reunión acerca del rendimiento académico de los estudiantes', 'CUMPLIDO', '00C', '0062ded3-b492-11ea-ae41-dcf50590531a', '0069f79f-b492-11ea-ae41-dcf50590531a', '2020-06-22 09:09:35'),
(77, 'Ceremonia de Graduación', 'Generación 50.\r\n\r\nCelebración en el auditorio.', 'CUMPLIDO', '00A', '9a9ec6f5-b492-11ea-ae41-dcf50590531a', '9ab6331c-b492-11ea-ae41-dcf50590531a', '2020-06-22 09:13:54'),
(78, 'Reunión de Docentes', 'Preparación de plan de contingencia.', 'CUMPLIDO', '00C', '24aa4589-b493-11ea-ae41-dcf50590531a', '24b0801c-b493-11ea-ae41-dcf50590531a', '2020-06-22 09:17:45'),
(79, 'Reunión de Docentes', 'Preparación de plan de contingencia.', 'CUMPLIDO', '00C', '3a164321-b493-11ea-ae41-dcf50590531a', '3a256980-b493-11ea-ae41-dcf50590531a', '2020-06-22 09:18:21'),
(80, 'Reunión de Docentes', 'Preparación de plan de contingencia.', 'CUMPLIDO', '00C', '4be55c86-b493-11ea-ae41-dcf50590531a', '4beee007-b493-11ea-ae41-dcf50590531a', '2020-06-22 09:18:51'),
(81, 'Reunión de...', 'Reunión de Docentes', 'PROGRAMADO', '00C', 'adadf7a7-b4ec-11ea-a959-dcf50590531a', 'adb514b1-b4ec-11ea-a959-dcf50590531a', '2020-06-22 19:58:40');

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
(76, '34', 0, 1, 0),
(76, 'ASBCUWE$3.', 0, 1, 0),
(76, 'EWEFG34', 0, 1, 0),
(76, 'AQW3ED%GT', 0, 1, 0),
(76, 'aSEWD.Y/6', 0, 1, 0),
(76, 'FSNDF8/,3', 0, 1, 0),
(76, 'sDWE23/ht', 0, 1, 0),
(77, 'sDWE23/ht', 1, 0, 0),
(78, 'ASBCUWE$3.', 0, 0, 1),
(78, 'EWEFG34', 0, 0, 1),
(78, 'AQW3ED%GT', 0, 0, 1),
(78, 'aSEWD.Y/6', 0, 0, 1),
(78, 'FSNDF8/,3', 0, 0, 1),
(78, 'sDWE23/ht', 0, 0, 1),
(79, 'ASBCUWE$3.', 0, 0, 1),
(79, 'EWEFG34', 0, 0, 1),
(79, 'AQW3ED%GT', 0, 0, 1),
(79, 'aSEWD.Y/6', 0, 0, 1),
(79, 'FSNDF8/,3', 0, 0, 1),
(79, 'sDWE23/ht', 0, 0, 1),
(80, 'ASBCUWE$3.', 0, 0, 1),
(80, 'EWEFG34', 0, 0, 1),
(80, 'AQW3ED%GT', 0, 0, 1),
(80, 'aSEWD.Y/6', 0, 0, 1),
(80, 'FSNDF8/,3', 0, 0, 1),
(80, 'sDWE23/ht', 0, 0, 1),
(81, '34', 0, 0, 1);

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
('0062ded3-b492-11ea-ae41-dcf50590531a', '2020-06-22', '2020-06-22', '2020-06-23', '2020-06-22 09:09:35'),
('24aa4589-b493-11ea-ae41-dcf50590531a', '2020-06-22', '2020-06-22', '2020-06-23', '2020-06-22 09:17:45'),
('3a164321-b493-11ea-ae41-dcf50590531a', '2020-06-22', '2020-06-22', '2020-06-23', '2020-06-22 09:18:21'),
('4be55c86-b493-11ea-ae41-dcf50590531a', '2020-06-22', '2020-06-22', '2020-06-23', '2020-06-22 09:18:51'),
('9a9ec6f5-b492-11ea-ae41-dcf50590531a', '2020-06-22', '2020-06-22', '2020-06-23', '2020-06-22 09:13:54'),
('adadf7a7-b4ec-11ea-a959-dcf50590531a', '2020-06-22', '2020-06-23', '2020-06-24', '2020-06-22 19:58:40');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_grupo`
--

CREATE TABLE `tbl_grupo` (
  `codigo_g` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `grado_g` int(11) NOT NULL,
  `grupo_g` varchar(3) COLLATE utf8_spanish2_ci NOT NULL,
  `id_jornada` varchar(3) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tbl_grupo`
--

INSERT INTO `tbl_grupo` (`codigo_g`, `grado_g`, `grupo_g`, `id_jornada`) VALUES
('34', 0, '3', 'J2'),
('AQW3ED%GT', 9, '3', 'J2'),
('ASBCUWE$3.', 7, '8', 'J2'),
('aSEWD.Y/6', 10, '2', 'J1'),
('DOCENTES', 0, '0', NULL),
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
('0069f79f-b492-11ea-ae41-dcf50590531a', '09:09:35', '10:10:00', '00:00:00', '2020-06-22 09:09:35'),
('24b0801c-b493-11ea-ae41-dcf50590531a', '09:17:45', '10:20:00', '00:00:00', '2020-06-22 09:17:45'),
('3a256980-b493-11ea-ae41-dcf50590531a', '09:18:21', '10:20:00', '00:00:00', '2020-06-22 09:18:21'),
('4beee007-b493-11ea-ae41-dcf50590531a', '09:18:51', '10:20:00', '00:00:00', '2020-06-22 09:18:51'),
('9ab6331c-b492-11ea-ae41-dcf50590531a', '09:13:54', '10:15:00', '00:00:00', '2020-06-22 09:13:54'),
('adb514b1-b4ec-11ea-a959-dcf50590531a', '19:58:40', '08:00:00', '00:00:00', '2020-06-22 19:58:40');

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
('4c4fd7e3-b', 'Cristian Alejandro', 'Restrepo', 'cristian', '123', 'Diseñador & Dev');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_modxevento`
--

CREATE TABLE `tbl_modxevento` (
  `id_moderador` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `id_evento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tbl_modxevento`
--

INSERT INTO `tbl_modxevento` (`id_moderador`, `id_evento`) VALUES
('4c4fd7e3-b', 77),
('4c4fd7e3-b', 78),
('4c4fd7e3-b', 79),
('4c4fd7e3-b', 80);

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
-- Indices de la tabla `tbl_adminxevento`
--
ALTER TABLE `tbl_adminxevento`
  ADD KEY `id_administrador` (`id_administrador`),
  ADD KEY `id_evento` (`id_evento`);

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
  ADD KEY `id_horas` (`id_horas`);

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
-- Indices de la tabla `tbl_modxevento`
--
ALTER TABLE `tbl_modxevento`
  ADD KEY `id_moderador` (`id_moderador`),
  ADD KEY `id_evento` (`id_evento`);

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
  MODIFY `id_evento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_acudiente`
--
ALTER TABLE `tbl_acudiente`
  ADD CONSTRAINT `tbl_acudiente_ibfk_1` FOREIGN KEY (`codigo_g`) REFERENCES `tbl_grupo` (`codigo_g`);

--
-- Filtros para la tabla `tbl_adminxevento`
--
ALTER TABLE `tbl_adminxevento`
  ADD CONSTRAINT `tbl_adminxevento_ibfk_1` FOREIGN KEY (`id_administrador`) REFERENCES `tbl_administrador` (`id_administrador`),
  ADD CONSTRAINT `tbl_adminxevento_ibfk_2` FOREIGN KEY (`id_evento`) REFERENCES `tbl_evento` (`id_evento`);

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
  ADD CONSTRAINT `tbl_evento_ibfk_3` FOREIGN KEY (`id_horas`) REFERENCES `tbl_hora_evento` (`id_horas`);

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

--
-- Filtros para la tabla `tbl_modxevento`
--
ALTER TABLE `tbl_modxevento`
  ADD CONSTRAINT `tbl_modxevento_ibfk_1` FOREIGN KEY (`id_moderador`) REFERENCES `tbl_moderador` (`id_moderador`),
  ADD CONSTRAINT `tbl_modxevento_ibfk_2` FOREIGN KEY (`id_evento`) REFERENCES `tbl_evento` (`id_evento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
