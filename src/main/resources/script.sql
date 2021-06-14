-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dbd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbd` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema db_disney
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_disney
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_disney` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `dbd` ;

-- -----------------------------------------------------
-- Table `dbd`.`characters`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbd`.`characters` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NULL,
  `image` VARCHAR(45) NULL,
  `age` INT NULL,
  `weight` FLOAT NULL,
  `strory` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbd`.`genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbd`.`genre` (
  `id` BIGINT(10) NOT NULL,
  `name` VARCHAR(45) NULL,
  `image` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '								';


-- -----------------------------------------------------
-- Table `dbd`.`movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbd`.`movies` (
  `id` BIGINT NOT NULL,
  `image` VARCHAR(45) NULL,
  `title` VARCHAR(45) NULL,
  `creation_date` DATE NULL,
  `quialification` INT NULL,
  `genre_id` BIGINT(10) NOT NULL,
  PRIMARY KEY (`id`, `genre_id`),
  INDEX `fk_movies_genre1_idx` (`genre_id` ASC) VISIBLE,
  CONSTRAINT `fk_movies_genre1`
    FOREIGN KEY (`genre_id`)
    REFERENCES `dbd`.`genre` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '					';


-- -----------------------------------------------------
-- Table `dbd`.`actuations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbd`.`actuations` (
  `movies_id` BIGINT NOT NULL,
  `characters_id` BIGINT NOT NULL,
  PRIMARY KEY (`movies_id`, `characters_id`),
  INDEX `fk_movies_has_characters_characters1_idx` (`characters_id` ASC) VISIBLE,
  INDEX `fk_movies_has_characters_movies_idx` (`movies_id` ASC) VISIBLE,
  CONSTRAINT `fk_movies_has_characters_movies`
    FOREIGN KEY (`movies_id`)
    REFERENCES `dbd`.`movies` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movies_has_characters_characters1`
    FOREIGN KEY (`characters_id`)
    REFERENCES `dbd`.`characters` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `db_disney` ;

-- -----------------------------------------------------
-- Table `db_disney`.`characters`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_disney`.`characters` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `age` INT NOT NULL,
  `image` LONGTEXT NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `story` VARCHAR(255) NULL DEFAULT NULL,
  `weight` FLOAT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_disney`.`genres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_disney`.`genres` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `image` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_disney`.`movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_disney`.`movies` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `creation_date` DATE NOT NULL,
  `image` LONGTEXT NULL DEFAULT NULL,
  `qualification` INT NOT NULL,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  `id_genre` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKaf3s5e8chst68d339v89625ts` (`id_genre` ASC) VISIBLE,
  CONSTRAINT `FKaf3s5e8chst68d339v89625ts`
    FOREIGN KEY (`id_genre`)
    REFERENCES `db_disney`.`genres` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_disney`.`actuations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_disney`.`actuations` (
  `id_character` BIGINT NOT NULL,
  `id_movie` BIGINT NOT NULL,
  PRIMARY KEY (`id_character`, `id_movie`),
  INDEX `FK9sxkn2jw0lbb7ixd0kl54ql3x` (`id_movie` ASC) VISIBLE,
  CONSTRAINT `FK9sxkn2jw0lbb7ixd0kl54ql3x`
    FOREIGN KEY (`id_movie`)
    REFERENCES `db_disney`.`characters` (`id`),
  CONSTRAINT `FKa1b2wwbxddjauo4r4r4l98a53`
    FOREIGN KEY (`id_character`)
    REFERENCES `db_disney`.`movies` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_disney`.`genres_associated_movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_disney`.`genres_associated_movies` (
  `genre_id` BIGINT NOT NULL,
  `associated_movies_id` BIGINT NOT NULL,
  PRIMARY KEY (`genre_id`, `associated_movies_id`),
  UNIQUE INDEX `UK_rgyoiivyhreruutgo7m6wjgw2` (`associated_movies_id` ASC) VISIBLE,
  CONSTRAINT `FK2gnr1805qd1308kkyg993lwhq`
    FOREIGN KEY (`associated_movies_id`)
    REFERENCES `db_disney`.`movies` (`id`),
  CONSTRAINT `FKnsw71063f2uuiks81rcy1dhl5`
    FOREIGN KEY (`genre_id`)
    REFERENCES `db_disney`.`genres` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
