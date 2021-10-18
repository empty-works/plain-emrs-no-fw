-- MySQL Script generated by MySQL Workbench
-- Mo 18 Okt 2021 21:21:46
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema plain_emrs
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `plain_emrs` ;

-- -----------------------------------------------------
-- Schema plain_emrs
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `plain_emrs` ;
USE `plain_emrs` ;

-- -----------------------------------------------------
-- Table `plain_emrs`.`patients`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`patients` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`patients` (
  `patient_id` VARCHAR(60) NOT NULL,
  `provider` VARCHAR(100) NOT NULL,
  `provider_id` INT NOT NULL,
  `room` VARCHAR(10) NULL,
  `gender` VARCHAR(10) NOT NULL,
  `type` VARCHAR(20) NOT NULL DEFAULT 'outpatient',
  `race` VARCHAR(25) NOT NULL,
  `ethnicity` VARCHAR(45) NOT NULL,
  `language_preference` VARCHAR(45) NULL,
  `given_name` VARCHAR(50) NOT NULL,
  `middle_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `street_address` VARCHAR(100) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(50) NOT NULL,
  `country` VARCHAR(55) NOT NULL,
  `phone_number` VARCHAR(15) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `email_address` VARCHAR(254) NULL,
  `facility_id` VARCHAR(75) NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE INDEX `patient_id_UNIQUE` (`patient_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`medical_records`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`medical_records` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`medical_records` (
  `record_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `patient_id` VARCHAR(60) NOT NULL,
  `condition` VARCHAR(40) NULL,
  `created_on` DATETIME NULL,
  PRIMARY KEY (`record_id`, `patient_id`),
  UNIQUE INDEX `record_id_UNIQUE` (`record_id` ASC) VISIBLE,
  INDEX `fk_medical_records_patients1_idx` (`patient_id` ASC) VISIBLE,
  CONSTRAINT `fk_medical_records_patients1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `plain_emrs`.`patients` (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`diagnoses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`diagnoses` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`diagnoses` (
  `record_id` INT UNSIGNED NOT NULL,
  `date` DATETIME NULL,
  `diagnosis` BLOB NULL,
  PRIMARY KEY (`record_id`),
  CONSTRAINT `fk_diagnoses_medical_records1`
    FOREIGN KEY (`record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`appointments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`appointments` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`appointments` (
  `record_id` INT UNSIGNED NOT NULL,
  `date` DATETIME NULL,
  `person_staff_id` INT NULL,
  PRIMARY KEY (`record_id`),
  CONSTRAINT `fk_appointments_medical_records1`
    FOREIGN KEY (`record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`medication`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`medication` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`medication` (
  `record_id` INT UNSIGNED NOT NULL,
  `medication` VARCHAR(150) NULL,
  `is_current` TINYINT NULL,
  PRIMARY KEY (`record_id`),
  CONSTRAINT `fk_medication_medical_records1`
    FOREIGN KEY (`record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`allergies`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`allergies` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`allergies` (
  `record_id` INT UNSIGNED NOT NULL,
  `allergy` VARCHAR(75) NULL,
  PRIMARY KEY (`record_id`),
  CONSTRAINT `fk_allergies_medical_records1`
    FOREIGN KEY (`record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`visits`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`visits` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`visits` (
  `record_id` INT UNSIGNED NOT NULL,
  `visit_date` DATETIME NULL,
  PRIMARY KEY (`record_id`),
  CONSTRAINT `fk_visits_medical_records1`
    FOREIGN KEY (`record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`vitals`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`vitals` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`vitals` (
  `record_id` INT UNSIGNED NOT NULL,
  `date_taken` DATETIME NULL,
  `height` INT NULL,
  `weight` INT NULL,
  `calculated_bmi` INT NULL,
  `temperature` FLOAT NULL,
  `pulse` INT NULL,
  `respiratory_rate` INT NULL,
  `blood_pressure_systolic` INT NULL,
  `blood_pressure_diastolic` INT NULL,
  `arterial_blood_oxygen_saturation` INT NULL,
  PRIMARY KEY (`record_id`),
  CONSTRAINT `fk_vitals_medical_records1`
    FOREIGN KEY (`record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`users` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`users` (
  `username` VARCHAR(75) NOT NULL,
  `password` CHAR(68) NOT NULL,
  `email_address` VARCHAR(254) NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  `created_on` DATETIME NOT NULL,
  `patient_id` VARCHAR(60) NULL,
  `nonpatient_id` VARCHAR(60) NULL,
  PRIMARY KEY (`username`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `patient_id_UNIQUE` (`patient_id` ASC) VISIBLE,
  UNIQUE INDEX `nonpatient_id_UNIQUE` (`nonpatient_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`user_access_logs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`user_access_logs` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`user_access_logs` (
  `username` VARCHAR(75) NOT NULL,
  `date_time_of_visit` DATETIME NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `fk_user_access_logs_users1`
    FOREIGN KEY (`username`)
    REFERENCES `plain_emrs`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`family_relations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`family_relations` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`family_relations` (
  `record_id` INT UNSIGNED NOT NULL,
  `related_patient_id` INT NULL,
  `relation` VARCHAR(25) NULL,
  PRIMARY KEY (`record_id`),
  CONSTRAINT `fk_family_relations_medical_records1`
    FOREIGN KEY (`record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`authorities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`authorities` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`authorities` (
  `username` VARCHAR(75) NOT NULL,
  `authority` VARCHAR(50) NOT NULL,
  INDEX `fk_authorities_users1_idx` (`username` ASC) VISIBLE,
  CONSTRAINT `fk_authorities_users1`
    FOREIGN KEY (`username`)
    REFERENCES `plain_emrs`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`emergency_contacts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`emergency_contacts` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`emergency_contacts` (
  `emergency_contact_id` VARCHAR(45) NOT NULL,
  `given_name` VARCHAR(50) NOT NULL,
  `middle_name` VARCHAR(50) NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `phone_number` VARCHAR(15) NOT NULL,
  `email_address` VARCHAR(254) NULL,
  PRIMARY KEY (`emergency_contact_id`),
  UNIQUE INDEX `emergency_contact_id_UNIQUE` (`emergency_contact_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`patient_emergency_contacts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`patient_emergency_contacts` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`patient_emergency_contacts` (
  `emergency_contact_id` VARCHAR(45) NOT NULL,
  `patient_id` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`emergency_contact_id`, `patient_id`),
  INDEX `fk_table1_emergency_contact1_idx` (`emergency_contact_id` ASC) VISIBLE,
  INDEX `fk_patient_emergency_contacts_patients1_idx` (`patient_id` ASC) VISIBLE,
  CONSTRAINT `fk_table1_emergency_contact1`
    FOREIGN KEY (`emergency_contact_id`)
    REFERENCES `plain_emrs`.`emergency_contacts` (`emergency_contact_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_patient_emergency_contacts_patients1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `plain_emrs`.`patients` (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`facilities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`facilities` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`facilities` (
  `facility_id` VARCHAR(75) NOT NULL,
  `name` VARCHAR(150) NOT NULL,
  `street_address` VARCHAR(100) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(50) NOT NULL,
  `country` VARCHAR(55) NOT NULL,
  `zip_code` VARCHAR(35) NOT NULL,
  PRIMARY KEY (`facility_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`staff_specialties`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`staff_specialties` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`staff_specialties` (
  `specialty_id` VARCHAR(45) NOT NULL,
  `facility_id` VARCHAR(75) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(150) NULL,
  PRIMARY KEY (`specialty_id`, `facility_id`),
  INDEX `fk_staff_specialties_facilities1_idx` (`facility_id` ASC) VISIBLE,
  CONSTRAINT `fk_staff_specialties_facilities1`
    FOREIGN KEY (`facility_id`)
    REFERENCES `plain_emrs`.`facilities` (`facility_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`wards`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`wards` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`wards` (
  `ward_id` VARCHAR(45) NOT NULL,
  `facility_id` VARCHAR(75) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NULL,
  PRIMARY KEY (`ward_id`, `facility_id`),
  UNIQUE INDEX `ward_id_UNIQUE` (`ward_id` ASC) VISIBLE,
  INDEX `fk_wards_facilities1_idx` (`facility_id` ASC) VISIBLE,
  CONSTRAINT `fk_wards_facilities1`
    FOREIGN KEY (`facility_id`)
    REFERENCES `plain_emrs`.`facilities` (`facility_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`staff_positions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`staff_positions` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`staff_positions` (
  `staff_position_id` VARCHAR(45) NOT NULL,
  `facility_id` VARCHAR(75) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(150) NULL,
  PRIMARY KEY (`staff_position_id`, `facility_id`),
  UNIQUE INDEX `staff_position_id_UNIQUE` (`staff_position_id` ASC) VISIBLE,
  INDEX `fk_staff_positions_facilities1_idx` (`facility_id` ASC) VISIBLE,
  CONSTRAINT `fk_staff_positions_facilities1`
    FOREIGN KEY (`facility_id`)
    REFERENCES `plain_emrs`.`facilities` (`facility_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`nonpatients`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`nonpatients` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`nonpatients` (
  `nonpatient_id` VARCHAR(60) NOT NULL,
  `given_name` VARCHAR(50) NOT NULL,
  `middle_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `organization` VARCHAR(200) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `description` VARCHAR(45) NULL,
  `ward_id` VARCHAR(45) NULL,
  `staff_position_id` VARCHAR(45) NULL,
  `specialty_id` VARCHAR(45) NULL,
  `facility_id` VARCHAR(45) NULL,
  PRIMARY KEY (`nonpatient_id`),
  UNIQUE INDEX `nonpatient_id_UNIQUE` (`nonpatient_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `plain_emrs`.`nurse_notes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`nurse_notes` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`nurse_notes` (
  `record_id` INT UNSIGNED NOT NULL,
  `date_posted` DATETIME NOT NULL,
  `focus` BLOB NOT NULL,
  `note` BLOB NOT NULL,
  `nonpatient_id` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`record_id`),
  CONSTRAINT `fk_nurse_notes_medical_records1`
    FOREIGN KEY (`record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `plain_emrs`.`facility_types`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`facility_types` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`facility_types` (
  `facility_type_id` VARCHAR(45) NOT NULL,
  `facility_id` VARCHAR(75) NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`facility_type_id`, `facility_id`),
  INDEX `fk_hospital_types_facilities1_idx` (`facility_id` ASC) VISIBLE,
  CONSTRAINT `fk_hospital_types_facilities1`
    FOREIGN KEY (`facility_id`)
    REFERENCES `plain_emrs`.`facilities` (`facility_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`roles` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`roles` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `group` VARCHAR(60) NULL,
  `description` VARCHAR(150) NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE INDEX `role_id_UNIQUE` (`role_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Data for table `plain_emrs`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `plain_emrs`;
INSERT INTO `plain_emrs`.`users` (`username`, `password`, `email_address`, `enabled`, `created_on`, `patient_id`, `nonpatient_id`) VALUES ('the_admin', '123', 'the_admin@gmail.com', true, '2021-08-05 21:57:01', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `plain_emrs`.`authorities`
-- -----------------------------------------------------
START TRANSACTION;
USE `plain_emrs`;
INSERT INTO `plain_emrs`.`authorities` (`username`, `authority`) VALUES ('the_admin', 'ROLE_ADMIN');
INSERT INTO `plain_emrs`.`authorities` (`username`, `authority`) VALUES ('the_admin', 'ROLE_AUTHORIZED');

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
