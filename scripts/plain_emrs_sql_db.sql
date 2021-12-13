-- MySQL Script generated by MySQL Workbench
-- Mo 13 Dez 2021 17:30:02
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
  `patient_provider` VARCHAR(100) NOT NULL,
  `patient_provider_id` INT NOT NULL,
  `patient_room` VARCHAR(10) NULL,
  `patient_gender` VARCHAR(10) NOT NULL,
  `patient_type` VARCHAR(20) NOT NULL DEFAULT 'outpatient',
  `patient_race` VARCHAR(25) NOT NULL,
  `patient_ethnicity` VARCHAR(45) NOT NULL,
  `patient_language_preference` VARCHAR(45) NULL,
  `patient_given_name` VARCHAR(50) NOT NULL,
  `patient_middle_name` VARCHAR(50) NOT NULL,
  `patient_last_name` VARCHAR(50) NOT NULL,
  `patient_street_address` VARCHAR(100) NOT NULL,
  `patient_city` VARCHAR(45) NOT NULL,
  `patient_state` VARCHAR(50) NOT NULL,
  `patient_country` VARCHAR(55) NOT NULL,
  `patient_phone_number` VARCHAR(15) NOT NULL,
  `patient_date_of_birth` DATE NOT NULL,
  `patient_email_address` VARCHAR(254) NULL,
  `patient_facility_id` VARCHAR(75) NULL,
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
  `medical_record_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `patient_id` VARCHAR(60) NOT NULL,
  `condition` VARCHAR(40) NULL,
  `medical_record_created_on` DATETIME NULL,
  PRIMARY KEY (`medical_record_id`, `patient_id`),
  UNIQUE INDEX `record_id_UNIQUE` (`medical_record_id` ASC) VISIBLE,
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
  `medical_record_id` INT UNSIGNED NOT NULL,
  `diagnosis_date` DATETIME NULL,
  `diagnosis_description` BLOB NULL,
  PRIMARY KEY (`medical_record_id`),
  CONSTRAINT `fk_diagnoses_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
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
  `medical_record_id` INT UNSIGNED NOT NULL,
  `appointment_id` INT NOT NULL AUTO_INCREMENT,
  `appointment_title` VARCHAR(75) NULL,
  `appointment_date` DATETIME NULL,
  `appointment_description` BLOB NULL,
  `nonpatient_id` INT NULL,
  PRIMARY KEY (`medical_record_id`),
  CONSTRAINT `fk_appointments_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
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
  `medical_record_id` INT UNSIGNED NOT NULL,
  `medication_name` VARCHAR(150) NULL,
  `medication_is_current` TINYINT NULL,
  PRIMARY KEY (`medical_record_id`),
  CONSTRAINT `fk_medication_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
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
  `medical_record_id` INT UNSIGNED NOT NULL,
  `allergy_name` VARCHAR(75) NULL,
  PRIMARY KEY (`medical_record_id`),
  CONSTRAINT `fk_allergies_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
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
  `medical_record_id` INT UNSIGNED NOT NULL,
  `visit_id` INT NOT NULL AUTO_INCREMENT,
  `visit_title` VARCHAR(75) NULL,
  `visit_date` DATETIME NOT NULL,
  `visit_description` BLOB NULL,
  PRIMARY KEY (`medical_record_id`),
  CONSTRAINT `fk_visits_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
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
  `medical_record_id` INT UNSIGNED NOT NULL,
  `vital_date_taken` DATETIME NULL,
  `vital_height` INT NULL,
  `vital_weight` INT NULL,
  `vital_calculated_bmi` INT NULL,
  `vital_temperature` FLOAT NULL,
  `vital_pulse` INT NULL,
  `vital_respiratory_rate` INT NULL,
  `vital_blood_pressure_systolic` INT NULL,
  `vital_blood_pressure_diastolic` INT NULL,
  `vital_arterial_blood_oxygen_saturation` INT NULL,
  PRIMARY KEY (`medical_record_id`),
  CONSTRAINT `fk_vitals_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
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
  `user_name` VARCHAR(75) NOT NULL,
  `user_password` CHAR(68) NOT NULL,
  `user_email_address` VARCHAR(254) NULL,
  `user_enabled` TINYINT NOT NULL DEFAULT 1,
  `user_created_on` DATETIME NOT NULL,
  `patient_id` VARCHAR(60) NULL,
  `nonpatient_id` VARCHAR(60) NULL,
  PRIMARY KEY (`user_name`),
  UNIQUE INDEX `username_UNIQUE` (`user_name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`user_access_logs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`user_access_logs` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`user_access_logs` (
  `user_name` VARCHAR(75) NOT NULL,
  `user_date_time_of_visit` DATETIME NULL,
  PRIMARY KEY (`user_name`),
  CONSTRAINT `fk_user_access_logs_users1`
    FOREIGN KEY (`user_name`)
    REFERENCES `plain_emrs`.`users` (`user_name`)
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
  `medical_record_id` INT UNSIGNED NOT NULL,
  `related_patient_id` INT NULL,
  `relation_description` BLOB NULL,
  PRIMARY KEY (`medical_record_id`),
  CONSTRAINT `fk_family_relations_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
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
  `user_name` VARCHAR(75) NOT NULL,
  `authority` VARCHAR(50) NOT NULL,
  INDEX `fk_authorities_users1_idx` (`user_name` ASC) VISIBLE,
  CONSTRAINT `fk_authorities_users1`
    FOREIGN KEY (`user_name`)
    REFERENCES `plain_emrs`.`users` (`user_name`)
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
  `emergency_contact_given_name` VARCHAR(50) NOT NULL,
  `emergency_contact_middle_name` VARCHAR(50) NULL,
  `emergency_contact_last_name` VARCHAR(50) NOT NULL,
  `emergency_contact_phone_number` VARCHAR(15) NOT NULL,
  `emergency_contact_email_address` VARCHAR(254) NULL,
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
  `patient_emergency_contact_id` VARCHAR(45) NOT NULL,
  `patient_id` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`patient_emergency_contact_id`, `patient_id`),
  INDEX `fk_table1_emergency_contact1_idx` (`patient_emergency_contact_id` ASC) VISIBLE,
  INDEX `fk_patient_emergency_contacts_patients1_idx` (`patient_id` ASC) VISIBLE,
  CONSTRAINT `fk_table1_emergency_contact1`
    FOREIGN KEY (`patient_emergency_contact_id`)
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
  `facility_name` VARCHAR(150) NOT NULL,
  `facility_street_address` VARCHAR(100) NOT NULL,
  `facility_city` VARCHAR(45) NOT NULL,
  `facility_state` VARCHAR(50) NOT NULL,
  `facility_country` VARCHAR(55) NOT NULL,
  `facility_zip_code` VARCHAR(35) NOT NULL,
  `facility_number_of_beds` INT NULL,
  `facility_description` BLOB NULL,
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
  `specialty_name` VARCHAR(45) NOT NULL,
  `specialty_description` BLOB NULL,
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
  `ward_name` VARCHAR(45) NOT NULL,
  `ward_location` VARCHAR(45) NULL,
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
  `staff_position_name` VARCHAR(45) NOT NULL,
  `staff_position_description` BLOB NULL,
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
  `nonpatient_given_name` VARCHAR(50) NOT NULL,
  `nonpatient_middle_name` VARCHAR(50) NOT NULL,
  `nonpatient_last_name` VARCHAR(50) NOT NULL,
  `nonpatient_organization` VARCHAR(200) NOT NULL,
  `nonpatient_date_of_birth` DATE NOT NULL,
  `nonpatient_description` BLOB NULL,
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
  `medical_record_id` INT UNSIGNED NOT NULL,
  `nurse_note_id` INT NOT NULL AUTO_INCREMENT,
  `nurse_note_date_posted` DATETIME NOT NULL,
  `nurse_note_focus` BLOB NOT NULL,
  `nurse_note_text` BLOB NOT NULL,
  `nonpatient_id` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`medical_record_id`),
  CONSTRAINT `fk_nurse_notes_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `plain_emrs`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`roles` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`roles` (
  `role_id` VARCHAR(75) NOT NULL,
  `role_name` VARCHAR(60) NOT NULL,
  `role_group` VARCHAR(60) NULL,
  `role_description` BLOB NULL,
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
INSERT INTO `plain_emrs`.`users` (`user_name`, `user_password`, `user_email_address`, `user_enabled`, `user_created_on`, `patient_id`, `nonpatient_id`) VALUES ('the_admin', '123', 'the_admin@gmail.com', true, '2021-08-05 21:57:01', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `plain_emrs`.`authorities`
-- -----------------------------------------------------
START TRANSACTION;
USE `plain_emrs`;
INSERT INTO `plain_emrs`.`authorities` (`user_name`, `authority`) VALUES ('the_admin', 'ROLE_ADMIN');
INSERT INTO `plain_emrs`.`authorities` (`user_name`, `authority`) VALUES ('the_admin', 'ROLE_AUTHORIZED');

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
