-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-06-2020 a las 06:23:15
-- Versión del servidor: 10.1.40-MariaDB
-- Versión de PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cimontain`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `Cantidad_C` int(11) DEFAULT NULL,
  `Gasto_C` int(11) DEFAULT NULL,
  `Fecha_C` date DEFAULT NULL,
  `Clave_P` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`Cantidad_C`, `Gasto_C`, `Fecha_C`, `Clave_P`) VALUES
(12, 120, '2019-11-27', '12'),
(2, 12, '2019-11-27', '123'),
(13, 15, '2019-11-27', '12'),
(5, 50, '2019-11-27', '12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra_ex`
--

CREATE TABLE `compra_ex` (
  `Cantidad_C` int(11) DEFAULT NULL,
  `Gasto_C` int(11) DEFAULT NULL,
  `Fecha_C` date DEFAULT NULL,
  `Descripcion` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `Clave_P` varchar(8) NOT NULL,
  `Nombre_P` varchar(25) DEFAULT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  `Tipo_P` varchar(20) DEFAULT NULL,
  `Sector_P` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`Clave_P`, `Nombre_P`, `Cantidad`, `Tipo_P`, `Sector_P`) VALUES
('12', 'coca', 35, 'Servicio', 'Cafeteria'),
('123', 'ha', 6, 'Servicio', 'Ciber');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `User` varchar(15) DEFAULT NULL,
  `Nombre` varchar(10) DEFAULT NULL,
  `Contraseña` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precios`
--

CREATE TABLE `precios` (
  `Clave_Pr` varchar(10) NOT NULL,
  `Precio_Pr` int(11) DEFAULT NULL,
  `Cantidad_Pr` int(11) DEFAULT NULL,
  `Cantidad_D_Pr` int(11) DEFAULT NULL,
  `Precio_D_Pr` int(11) DEFAULT NULL,
  `Clave_P` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `precios`
--

INSERT INTO `precios` (`Clave_Pr`, `Precio_Pr`, `Cantidad_Pr`, `Cantidad_D_Pr`, `Precio_D_Pr`, `Clave_P`) VALUES
('12', 20, 1, 6, 18, '12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tcompra`
--

CREATE TABLE `tcompra` (
  `Cantidad_C` int(11) DEFAULT NULL,
  `Gasto_C` int(11) DEFAULT NULL,
  `Fecha_C` date DEFAULT NULL,
  `Clave_P` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tcompra`
--

INSERT INTO `tcompra` (`Cantidad_C`, `Gasto_C`, `Fecha_C`, `Clave_P`) VALUES
(12, 120, '2019-11-27', '12'),
(2, 12, '2019-11-27', '123'),
(13, 15, '2019-11-27', '12'),
(5, 50, '2019-11-27', '12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tcompra_ex`
--

CREATE TABLE `tcompra_ex` (
  `Cantidad_C` int(11) DEFAULT NULL,
  `Gasto_C` int(11) DEFAULT NULL,
  `Fecha_C` date DEFAULT NULL,
  `Descripcion` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tventa`
--

CREATE TABLE `tventa` (
  `Cantidad_V` int(11) DEFAULT NULL,
  `Cobro_Total_V` int(11) DEFAULT NULL,
  `Descuento_V` int(11) DEFAULT NULL,
  `Fecha_V` date DEFAULT NULL,
  `Clave_P` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `Cantidad_V` int(11) DEFAULT NULL,
  `Cobro_Total_V` int(11) DEFAULT NULL,
  `Descuento_V` int(11) DEFAULT NULL,
  `Fecha_V` date DEFAULT NULL,
  `Clave_P` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD KEY `Clave_P` (`Clave_P`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`Clave_P`);

--
-- Indices de la tabla `precios`
--
ALTER TABLE `precios`
  ADD PRIMARY KEY (`Clave_Pr`),
  ADD KEY `Clave_P` (`Clave_P`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD KEY `Clave_P` (`Clave_P`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`Clave_P`) REFERENCES `inventario` (`Clave_P`);

--
-- Filtros para la tabla `precios`
--
ALTER TABLE `precios`
  ADD CONSTRAINT `precios_ibfk_1` FOREIGN KEY (`Clave_P`) REFERENCES `inventario` (`Clave_P`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`Clave_P`) REFERENCES `inventario` (`Clave_P`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
