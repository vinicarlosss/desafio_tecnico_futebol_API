-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema futebol_data
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema futebol_data
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `futebol_data` DEFAULT CHARACTER SET utf8 ;
USE `futebol_data` ;

-- -----------------------------------------------------
-- Table `futebol_data`.`Team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `futebol_data`.`Team` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `team_name` VARCHAR(100) NOT NULL,
  `matches_played` INT NOT NULL,
  `win` INT NOT NULL,
  `draw` INT NOT NULL,
  `loss` INT NOT NULL,
  `goals_for` INT NOT NULL,
  `goals_against` INT NOT NULL,
  `goals_difference` INT NOT NULL,
  `points` INT NOT NULL,
  `position` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `futebol_data`.`Player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `futebol_data`.`Player` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `player_name` VARCHAR(100) NOT NULL,
  `Team_id` BIGINT NOT NULL,
  `country` VARCHAR(100) NOT NULL,
  `position` VARCHAR(25) NOT NULL,
  `age` INT NOT NULL,
  `matches_played` INT NOT NULL,
  `started` INT NOT NULL,
  `minutes` INT NULL,
  `goals` INT NOT NULL,
  `assist` INT NOT NULL,
  `penaltys_made` INT NOT NULL,
  `penaltys_attempted` INT NOT NULL,
  `yellow_card` INT NOT NULL,
  `red_card` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Player_Team_idx` (`Team_id` ASC) VISIBLE,
  CONSTRAINT `fk_Player_Team`
    FOREIGN KEY (`Team_id`)
    REFERENCES `futebol_data`.`Team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `futebol_data`.`Matches`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `futebol_data`.`Matches` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `Team_id` BIGINT NOT NULL,
  `Opponent_team_id` BIGINT NOT NULL,
  `captain_id` BIGINT NULL,
  `date` TIMESTAMP NOT NULL,
  `round` VARCHAR(100) NOT NULL,
  `week_day` VARCHAR(45) NOT NULL,
  `goals_for` INT NULL,
  `goals_against` INT NULL,
  `poss` INT NULL,
  `formation` VARCHAR(45) NULL,
  `opponent_formation` VARCHAR(45) NULL,
  `venue` VARCHAR(50) NOT NULL,
  `result` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Matches_Team1_idx` (`Team_id` ASC) VISIBLE,
  INDEX `fk_Matches_Team2_idx` (`Opponent_team_id` ASC) VISIBLE,
  INDEX `fk_Matches_Player1_idx` (`captain_id` ASC) VISIBLE,
  CONSTRAINT `fk_Matches_Team1`
    FOREIGN KEY (`Team_id`)
    REFERENCES `futebol_data`.`Team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Matches_Team2`
    FOREIGN KEY (`Opponent_team_id`)
    REFERENCES `futebol_data`.`Team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Matches_Player1`
    FOREIGN KEY (`captain_id`)
    REFERENCES `futebol_data`.`Player` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
