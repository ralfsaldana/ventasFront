CREATE DATABASE `bodega` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `bodega`.`producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `codigoProducto` VARCHAR(45) NOT NULL,
  `cantidadProducto` BIGINT(4) NOT NULL,
  `descripcionProducto` VARCHAR(200) NOT NULL,
  `precioProducto` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`idProducto`));

CREATE TABLE `bodega`.`cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nroDocumentoIdentidad` VARCHAR(45) NULL,
  `ruc` VARCHAR(45) NULL,
  `nombreRazonSocial` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  PRIMARY KEY (`idCliente`));

CREATE TABLE `bodega`.`venta` (
  `idVenta` INT NOT NULL AUTO_INCREMENT,
  `ruc` VARCHAR(45) NOT NULL,
  `nombreRazonSocial` VARCHAR(45) NOT NULL,
  `subtotal` DECIMAL(20,2) NOT NULL,
  `IGVCalculado` DECIMAL(20,2) NOT NULL,
  `total` DECIMAL(20,2) NOT NULL,
  `fechaVenta` DATETIME NOT NULL,
  PRIMARY KEY (`idVenta`));

CREATE TABLE `bodega`.`detalle_venta` (
  `idDetalleVenta` INT NOT NULL AUTO_INCREMENT,
  `idVenta` VARCHAR(45) NOT NULL,
  `codigoProducto` VARCHAR(45) NOT NULL,
  `descripcionProducto` VARCHAR(200) NOT NULL,
  `precioUnitario` DECIMAL(6,2) NOT NULL,
  `cantidad` BIGINT NOT NULL,
  `precioVenta` DECIMAL(10,2) NOT NULL,  
  PRIMARY KEY (`idDetalleVenta`));

