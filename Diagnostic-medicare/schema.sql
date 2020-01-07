SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
-- -----------------------------------------------------
-- Schema MEDICARE
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `medicare` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `medicare` ;

-- -----------------------------------------------------
-- Table `medicare`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`patient` (
  `pa_id` INT(10) NOT NULL AUTO_INCREMENT,
  `pa_user_name` VARCHAR(50) NOT NULL,
  `pa_first_name` VARCHAR(50) NOT NULL,
  `pa_last_name` VARCHAR(50) NOT NULL,
  `pa_age` INT(2) NOT NULL,
  `pa_gender` VARCHAR(100) NOT NULL,
  `pa_dob` VARCHAR(10) NULL,
  `pa_contact` BIGINT(10) NOT NULL,
  `pa_alt_contact` BIGINT(10) NULL,
  `pa_email` VARCHAR(50) NOT NULL,
  `pa_password` VARCHAR(500) NOT NULL,
  `pa_security_question` TINYBLOB NOT NULL,
  `pa_security_answer` VARCHAR(500) NOT NULL,
  `pa_address_line_1` VARCHAR(100) NOT NULL,
  `pa_address_line_2` VARCHAR(100) NOT NULL,
  `pa_city` VARCHAR(50) NOT NULL,
  `pa_state` VARCHAR(50) NOT NULL,
  `pa_zip_code` BIGINT(10) NOT NULL,
  `us_id` INT(10) NULL,
  PRIMARY KEY (`pa_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medicare`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`doctor` (
  `do_id` INT(10) NOT NULL AUTO_INCREMENT,
  `do_user_name` VARCHAR(50) NOT NULL,
  `do_first_name` VARCHAR(50) NOT NULL,
  `do_last_name` VARCHAR(50) NOT NULL,
  `do_age` INT(2) NOT NULL,
  `do_gender` VARCHAR(100) NOT NULL,
  `do_dob` VARCHAR(10) NULL,
  `do_contact` BIGINT(10) NOT NULL,
  `do_alt_contact` BIGINT(10) NULL,
  `do_email` VARCHAR(50) NOT NULL,
  `do_password` VARCHAR(500) NOT NULL,
  `do_security_question` TINYBLOB NOT NULL,
  `do_security_answer` VARCHAR(500) NOT NULL,
  `do_address_line_1` VARCHAR(100) NOT NULL,
  `do_address_line_2` VARCHAR(100) NOT NULL,
  `do_city` VARCHAR(50) NOT NULL,
  `do_state` VARCHAR(50) NOT NULL,
  `do_zip_code` BIGINT(10) NOT NULL,
  `do_degree` VARCHAR(50) NOT NULL,
  `do_speciality` VARCHAR(50) NOT NULL,
  `do_work_hours` INT(50) NOT NULL,
  `do_hospital_name` VARCHAR(100) NOT NULL,
 `us_id` INT(10) NULL,
  PRIMARY KEY (`do_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `medicare`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`admin_table` (
  `ad_id` INT(10) NOT NULL AUTO_INCREMENT,
  `ad_user_name` VARCHAR(50) NOT NULL,
  `ad_first_name` VARCHAR(50) NOT NULL,
  `ad_last_name` VARCHAR(50) NOT NULL,
  `ad_age` INT(2) NOT NULL,
  `ad_gender` VARCHAR(100) NULL,
  `ad_dob` VARCHAR(10) NOT NULL,
  `ad_contact` BIGINT(10) NOT NULL,
  `ad_alt_contact` BIGINT(10) NULL,
  `ad_email` VARCHAR(50) NOT NULL,
  `ad_password` VARCHAR(500) NOT NULL,
  `us_id` INT(10) NULL,
  PRIMARY KEY (`ad_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `medicare`.`agent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`agent` (
  `ag_id` INT(10) NOT NULL AUTO_INCREMENT,
  `ag_user_name` VARCHAR(50) NOT NULL,
  `ag_first_name` VARCHAR(50) NOT NULL,
  `ag_last_name` VARCHAR(50) NOT NULL,
  `ag_age` INT(2) NOT NULL,
  `ag_gender` VARCHAR(100) NOT NULL,
  `ag_dob` VARCHAR(10) NULL,
  `ag_contact` BIGINT(10) NOT NULL,
  `ag_alt_contact` BIGINT(10) NULL,
  `ag_email` VARCHAR(50) NOT NULL,
  `ag_password` VARCHAR(500) NOT NULL,
  `ag_security_question` TINYBLOB NOT NULL,
  `ag_security_answer` VARCHAR(500) NOT NULL,
  `ag_address_line_1` VARCHAR(100) NOT NULL,
  `ag_address_line_2` VARCHAR(100) NOT NULL,
  `ag_city` VARCHAR(50) NOT NULL,
  `ag_state` VARCHAR(50) NOT NULL,
  `ag_zip_code` BIGINT(10) NOT NULL,
  `us_id` INT(10) NULL,
  PRIMARY KEY (`ag_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `medicare`.`medicare_services`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`medicare_services` (
  `ms_id` INT(10) NOT NULL AUTO_INCREMENT,
  `ms_medicare_service` VARCHAR(100) NOT NULL,
  `ms_service_description` VARCHAR(200) NOT NULL,
  `ms_agent_commission` INT NOT NULL,
  `ms_amount` INT(10) NOT NULL,
  `ms_tn_test_name` VARCHAR(100) NULL,
  PRIMARY KEY (`ms_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `medicare`.`doctor_service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`doctor_medicare` (
  `dm_id` INT NOT NULL AUTO_INCREMENT,
  `dm_do_id` INT NULL,
  `dm_ms_id` INT NULL,
  PRIMARY KEY (`dm_id`),
  INDEX `dm_do_fk_idx` (`dm_do_id` ASC),
  INDEX `dm_ms_fk_idx` (`dm_ms_id` ASC),
  CONSTRAINT `dm_do_fk`
    FOREIGN KEY (`dm_do_id`)
    REFERENCES `medicare`.`doctor` (`do_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `dm_ms_fk`
    FOREIGN KEY (`dm_ms_id`)
    REFERENCES `medicare`.`medicare_services` (`ms_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `medicare`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `medicare`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(60) NULL,
  `us_password` VARCHAR(60) NULL,
  `ro_id` INT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `medicare`.`role` (
  `ro_id` INT NOT NULL AUTO_INCREMENT,
  `ro_name` VARCHAR(45) NULL,
  PRIMARY KEY (`ro_id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `medicare`.`request` (
  `re_id` INT NOT NULL AUTO_INCREMENT,
  `re_pa_id` INT NULL,
  `re_do_id` INT NULL,
  `re_date` DATE NOT NULL,
  `re_ms_id` INT NULL,
  `re_active` VARCHAR(100) NULL,
  PRIMARY KEY (`re_id`),
  INDEX `re_pa_fk_idx` (`re_pa_id` ASC),
  INDEX `re_ms_fk_idx` (`re_ms_id` ASC),
  CONSTRAINT `re_pa_fk`
    FOREIGN KEY (`re_pa_id`)
    REFERENCES `medicare`.`patient` (`pa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `re_ms_fk`
    FOREIGN KEY (`re_ms_id`)
    REFERENCES `medicare`.`medicare_services` (`ms_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `medicare`.`test_result` (
  `tr_id` INT NOT NULL AUTO_INCREMENT,
  `tr_pa_id` INT NOT NULL,
  `tr_do_id` INT NOT NULL,
  `tr_ms_id` INT NOT NULL,
  `tr_ag_id` INT NOT NULL,
  `tr_test_name` VARCHAR(100) NOT NULL,
  `tr_normal_range` INT NOT NULL,
  `tr_actual_range` INT NOT NULL,
  PRIMARY KEY (`tr_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `medicare`.`test_result_name` (
  `tn_id` INT NOT NULL AUTO_INCREMENT,
  `tn_normal_range` INT NOT NULL,
  `tn_test_name` VARCHAR(100) NOT NULL,
  `ms_id` INT(10) NULL,
  PRIMARY KEY (`tn_id`))
ENGINE = InnoDB;

