-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema campo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema campo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `campo` DEFAULT CHARACTER SET utf8 ;
USE `campo` ;

-- -----------------------------------------------------
-- Table `campo`.`estadoCampo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `campo`.`estadoCampo` ;

CREATE TABLE IF NOT EXISTS `campo`.`estadoCampo` (
  `idEstadoCampo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEstadoCampo`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `campo`.`campo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `campo`.`campo` ;

CREATE TABLE IF NOT EXISTS `campo`.`campo` (
  `idCampo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `superficie` INT NOT NULL,
  `IdEstadoCampo` INT NOT NULL,
  PRIMARY KEY (`idCampo`),
  INDEX `FK_ESTADOCAMPO_CAMPO_idx` (`IdEstadoCampo` ASC),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC),
  CONSTRAINT `FK_ESTADOCAMPO_CAMPO`
    FOREIGN KEY (`IdEstadoCampo`)
    REFERENCES `campo`.`estadoCampo` (`idEstadoCampo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `campo`.`tipoSuelo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `campo`.`tipoSuelo` ;

CREATE TABLE IF NOT EXISTS `campo`.`tipoSuelo` (
  `idTipoSuelo` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoSuelo`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `campo`.`lote`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `campo`.`lote` ;

CREATE TABLE IF NOT EXISTS `campo`.`lote` (
  `idLote` INT NOT NULL,
  `superficie` INT NOT NULL,
  `idTipoSuelo` INT NOT NULL,
  `idCampo` INT NOT NULL,
  PRIMARY KEY (`idLote`, `idCampo`),
  INDEX `FK_CAMPO_LOTE_idx` (`idCampo` ASC),
  INDEX `FK_TIPOSUELO_LOTE_idx` (`idTipoSuelo` ASC),
  CONSTRAINT `FK_CAMPO_LOTE`
    FOREIGN KEY (`idCampo`)
    REFERENCES `campo`.`campo` (`idCampo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_TIPOSUELO_LOTE`
    FOREIGN KEY (`idTipoSuelo`)
    REFERENCES `campo`.`tipoSuelo` (`idTipoSuelo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `campo`.`estadoCampo`
-- -----------------------------------------------------
START TRANSACTION;
USE `campo`;
INSERT INTO `campo`.`estadoCampo` (`idEstadoCampo`, `nombre`) VALUES (DEFAULT, 'Creado');
INSERT INTO `campo`.`estadoCampo` (`idEstadoCampo`, `nombre`) VALUES (DEFAULT, 'Parcialmente trabajado');
INSERT INTO `campo`.`estadoCampo` (`idEstadoCampo`, `nombre`) VALUES (DEFAULT, 'Completamente trabajado');
INSERT INTO `campo`.`estadoCampo` (`idEstadoCampo`, `nombre`) VALUES (DEFAULT, 'En desuso');
INSERT INTO `campo`.`estadoCampo` (`idEstadoCampo`, `nombre`) VALUES (DEFAULT, 'Final del campo');

COMMIT;


-- -----------------------------------------------------
-- Data for table `campo`.`tipoSuelo`
-- -----------------------------------------------------
START TRANSACTION;
USE `campo`;
INSERT INTO `campo`.`tipoSuelo` (`idTipoSuelo`, `nombre`) VALUES (1, 'I');
INSERT INTO `campo`.`tipoSuelo` (`idTipoSuelo`, `nombre`) VALUES (2, 'II');
INSERT INTO `campo`.`tipoSuelo` (`idTipoSuelo`, `nombre`) VALUES (3, 'III');
INSERT INTO `campo`.`tipoSuelo` (`idTipoSuelo`, `nombre`) VALUES (4, 'IV');
INSERT INTO `campo`.`tipoSuelo` (`idTipoSuelo`, `nombre`) VALUES (5, 'V');

COMMIT;

