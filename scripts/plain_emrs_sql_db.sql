-- MySQL Script generated by MySQL Workbench
-- Fr 04 Nov 2022 16:32:03
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
-- Table `plain_emrs`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`users` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`users` (
  `user_id` VARCHAR(75) NOT NULL,
  `user_password` CHAR(68) NOT NULL,
  `user_email_address` VARCHAR(254) NULL,
  `user_enabled` TINYINT NOT NULL DEFAULT 1,
  `user_created_on` DATETIME NOT NULL,
  `current_facility_id` VARCHAR(75) NULL,
  `user_first_name` VARCHAR(50) NOT NULL,
  `user_middle_initial` VARCHAR(1) NULL,
  `user_last_name` VARCHAR(50) NOT NULL,
  `user_date_of_birth` DATE NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `username_UNIQUE` (`user_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`patients`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`patients` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`patients` (
  `user_id` VARCHAR(75) NOT NULL,
  `patient_provider` VARCHAR(100) NOT NULL DEFAULT 'None',
  `patient_provider_id` VARCHAR(60) NOT NULL DEFAULT 'N/A',
  `patient_room` VARCHAR(10) NULL,
  `patient_current_gender` VARCHAR(80) NOT NULL DEFAULT 'Choose not to disclose',
  `patient_type` VARCHAR(20) NOT NULL DEFAULT 'outpatient',
  `patient_language_preference` VARCHAR(45) NULL,
  `patient_street_address` VARCHAR(100) NULL DEFAULT 'N/A',
  `patient_city` VARCHAR(45) NULL DEFAULT 'N/A',
  `patient_state` VARCHAR(50) NULL DEFAULT 'N/A',
  `patient_country` VARCHAR(55) NULL DEFAULT 'N/A',
  `patient_phone_number` VARCHAR(15) NULL DEFAULT 'N/A',
  `patient_gender_at_birth` VARCHAR(40) NOT NULL DEFAULT 'Choose not to disclose',
  `patient_sexual_orientation` VARCHAR(75) NOT NULL DEFAULT 'Choose not to disclose',
  `patient_marital_status` VARCHAR(45) NOT NULL,
  `patient_living_arrangement` VARCHAR(45) NOT NULL,
  `patient_is_adopted` TINYINT NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_patients_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `plain_emrs`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`medical_records`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`medical_records` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`medical_records` (
  `medical_record_id` VARCHAR(85) NOT NULL,
  `user_id` VARCHAR(75) NOT NULL,
  `patient_condition` VARCHAR(75) NOT NULL,
  `medical_record_created_on` DATETIME NOT NULL,
  `is_active` TINYINT NOT NULL DEFAULT 1,
  `blood_transfusion_status` VARCHAR(45) NOT NULL DEFAULT 'Do not know',
  PRIMARY KEY (`medical_record_id`, `user_id`),
  UNIQUE INDEX `record_id_UNIQUE` (`medical_record_id` ASC) VISIBLE,
  INDEX `fk_medical_records_users1_idx` (`user_id` ASC) VISIBLE,
  UNIQUE INDEX `users_user_id_UNIQUE` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_medical_records_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `plain_emrs`.`users` (`user_id`)
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
  `diagnosis_id` INT NOT NULL AUTO_INCREMENT,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `diagnosis_title` VARCHAR(45) NOT NULL,
  `diagnosis_date` DATETIME NOT NULL,
  `diagnosis_description` BLOB NOT NULL,
  PRIMARY KEY (`diagnosis_id`, `medical_record_id`),
  INDEX `fk_diagnoses_medical_records1_idx` (`medical_record_id` ASC) VISIBLE,
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
  `appointment_id` INT NOT NULL AUTO_INCREMENT,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `appointment_title` VARCHAR(75) NOT NULL,
  `appointment_date` DATETIME NOT NULL,
  `appointment_description` BLOB NOT NULL,
  `nonpatient_id` INT NULL,
  PRIMARY KEY (`appointment_id`, `medical_record_id`),
  INDEX `fk_appointments_medical_records1_idx` (`medical_record_id` ASC) VISIBLE,
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
  `medication_id` INT NOT NULL,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `medication_name` VARCHAR(150) NOT NULL,
  `medication_is_current` TINYINT NOT NULL,
  `medication_description` BLOB NULL,
  PRIMARY KEY (`medical_record_id`),
  INDEX `fk_medication_medical_records1_idx` (`medical_record_id` ASC) VISIBLE,
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
  `medical_record_id` VARCHAR(85) NOT NULL,
  `allergy_id` VARCHAR(65) NOT NULL DEFAULT 'n/a',
  `allergy_name` VARCHAR(75) NOT NULL DEFAULT 'none',
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
  `visit_id` INT NOT NULL AUTO_INCREMENT,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `visit_title` VARCHAR(75) NOT NULL,
  `visit_date` DATETIME NOT NULL,
  `visit_description` BLOB NOT NULL,
  PRIMARY KEY (`visit_id`, `medical_record_id`),
  INDEX `fk_visits_medical_records1_idx` (`medical_record_id` ASC) VISIBLE,
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
  `vital_id` INT NOT NULL AUTO_INCREMENT,
  `medical_record_id` VARCHAR(85) NOT NULL,
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
  PRIMARY KEY (`vital_id`, `medical_record_id`),
  CONSTRAINT `fk_vitals_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`user_login_logs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`user_login_logs` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`user_login_logs` (
  `user_id` VARCHAR(75) NOT NULL,
  `user_date_time_of_visit` DATETIME NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `fk_user_access_logs_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `plain_emrs`.`users` (`user_id`)
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
  `user_id` VARCHAR(75) NOT NULL,
  `authority` VARCHAR(50) NOT NULL,
  INDEX `fk_authorities_users1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_authorities_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `plain_emrs`.`users` (`user_id`)
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
  `user_id` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`patient_emergency_contact_id`, `user_id`),
  INDEX `fk_table1_emergency_contact1_idx` (`patient_emergency_contact_id` ASC) VISIBLE,
  INDEX `fk_patient_emergency_contacts_patients1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_table1_emergency_contact1`
    FOREIGN KEY (`patient_emergency_contact_id`)
    REFERENCES `plain_emrs`.`emergency_contacts` (`emergency_contact_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_patient_emergency_contacts_patients1`
    FOREIGN KEY (`user_id`)
    REFERENCES `plain_emrs`.`patients` (`user_id`)
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
  `user_id` VARCHAR(75) NOT NULL,
  `nonpatient_organization` VARCHAR(200) NOT NULL,
  `nonpatient_description` BLOB NULL,
  `ward_id` VARCHAR(45) NULL,
  `staff_position_id` VARCHAR(45) NULL,
  `specialty_id` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`),
  INDEX `fk_nonpatients_users1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_nonpatients_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `plain_emrs`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`nurse_notes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`nurse_notes` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`nurse_notes` (
  `nurse_note_id` INT NOT NULL AUTO_INCREMENT,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `nurse_note_date_posted` DATETIME NOT NULL,
  `nurse_note_focus` BLOB NOT NULL,
  `nurse_note_text` BLOB NOT NULL,
  `nonpatient_id` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`nurse_note_id`, `medical_record_id`),
  INDEX `fk_nurse_notes_medical_records1_idx` (`medical_record_id` ASC) VISIBLE,
  CONSTRAINT `fk_nurse_notes_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
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
-- Table `plain_emrs`.`user_access_logs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`user_access_logs` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`user_access_logs` (
  `user_id` VARCHAR(75) NOT NULL,
  `user_date_time_of_access` DATETIME NOT NULL,
  `medical_record_id` VARCHAR(85) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `fk_user_access_logs_users2`
    FOREIGN KEY (`user_id`)
    REFERENCES `plain_emrs`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`user_activity_logs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`user_activity_logs` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`user_activity_logs` (
  `user_id` VARCHAR(75) NOT NULL,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `user_date_time_of_activity` DATETIME NOT NULL,
  `activity_description` TINYBLOB NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `fk_table1_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `plain_emrs`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`facilities_roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`facilities_roles` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`facilities_roles` (
  `facilities_roles_id` VARCHAR(75) NOT NULL,
  `role_id` VARCHAR(75) NOT NULL,
  `facility_id` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`facilities_roles_id`, `role_id`, `facility_id`),
  INDEX `fk_facilities_roles_facilities1_idx` (`facility_id` ASC) VISIBLE,
  UNIQUE INDEX `facilities_roles_id_UNIQUE` (`facilities_roles_id` ASC) VISIBLE,
  CONSTRAINT `fk_facilities_roles_roles1`
    FOREIGN KEY (`role_id`)
    REFERENCES `plain_emrs`.`roles` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facilities_roles_facilities1`
    FOREIGN KEY (`facility_id`)
    REFERENCES `plain_emrs`.`facilities` (`facility_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`user_authorized_facilities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`user_authorized_facilities` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`user_authorized_facilities` (
  `user_id` VARCHAR(75) NOT NULL,
  `facility_id` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `fk_user_authorized_facilities_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `plain_emrs`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`diseases`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`diseases` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`diseases` (
  `medical_record_id` VARCHAR(85) NOT NULL,
  `disease` VARCHAR(45) NOT NULL DEFAULT 'unknown',
  `contracted_disease` TINYINT NOT NULL DEFAULT 0,
  `received_immunization` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`medical_record_id`),
  CONSTRAINT `fk_diseases_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`surgical_related_problems`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`surgical_related_problems` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`surgical_related_problems` (
  `medical_record_id` VARCHAR(85) NOT NULL,
  `surgical_related_problem` VARCHAR(75) NOT NULL,
  `problem_area` VARCHAR(45) NOT NULL,
  `surgical_procedure` VARCHAR(75) NULL DEFAULT 'none',
  `surgical_procedure_year` VARCHAR(45) NULL DEFAULT 'none',
  PRIMARY KEY (`medical_record_id`),
  CONSTRAINT `fk_surgical_related_problems_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`blood_relatives`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`blood_relatives` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`blood_relatives` (
  `medical_record_id` VARCHAR(85) NOT NULL,
  `mother_status` VARCHAR(45) NOT NULL,
  `father_status` VARCHAR(45) NOT NULL,
  `mother_deceased_age` INT NULL,
  `father_deceased_age` INT NULL,
  `num_sisters_alive` INT NOT NULL,
  `num_brothers_alive` INT NOT NULL,
  `num_daughters_alive` INT NOT NULL,
  `num_sons_alive` INT NOT NULL,
  `mother_cause_of_death` BLOB NULL,
  `father_cause_of_death` BLOB NULL,
  PRIMARY KEY (`medical_record_id`),
  UNIQUE INDEX `medical_record_id_UNIQUE` (`medical_record_id` ASC) VISIBLE,
  CONSTRAINT `fk_blood_relatives_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`illnesses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`illnesses` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`illnesses` (
  `medical_record_id` VARCHAR(85) NOT NULL,
  `illness` VARCHAR(75) NOT NULL,
  `self` TINYINT NULL,
  `father` TINYINT NULL,
  `mother` TINYINT NULL,
  `brothers` TINYINT NULL,
  `sisters` TINYINT NULL,
  `sons` TINYINT NULL,
  `daughters` TINYINT NULL,
  `grandparents` TINYINT NULL,
  PRIMARY KEY (`medical_record_id`),
  CONSTRAINT `fk_illnesses_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`patient_races`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`patient_races` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`patient_races` (
  `patients_user_id` VARCHAR(75) NOT NULL,
  `patient_race` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`patients_user_id`),
  CONSTRAINT `fk_patient_races_patients1`
    FOREIGN KEY (`patients_user_id`)
    REFERENCES `plain_emrs`.`patients` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Data for table `plain_emrs`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `plain_emrs`;
INSERT INTO `plain_emrs`.`users` (`user_id`, `user_password`, `user_email_address`, `user_enabled`, `user_created_on`, `current_facility_id`, `user_first_name`, `user_middle_initial`, `user_last_name`, `user_date_of_birth`) VALUES ('the_admin', '123', 'the_admin@gmail.com', true, '2021-08-05 21:57:01', NULL, 'Unknown', NULL, 'Unknown', '1999-01-01');

COMMIT;


-- -----------------------------------------------------
-- Data for table `plain_emrs`.`authorities`
-- -----------------------------------------------------
START TRANSACTION;
USE `plain_emrs`;
INSERT INTO `plain_emrs`.`authorities` (`user_id`, `authority`) VALUES ('the_admin', 'ROLE_ADMIN');
INSERT INTO `plain_emrs`.`authorities` (`user_id`, `authority`) VALUES ('the_admin', 'ROLE_AUTHORIZED');

COMMIT;


-- -----------------------------------------------------
-- Data for table `plain_emrs`.`facilities`
-- -----------------------------------------------------
START TRANSACTION;
USE `plain_emrs`;
INSERT INTO `plain_emrs`.`facilities` (`facility_id`, `facility_name`, `facility_street_address`, `facility_city`, `facility_state`, `facility_country`, `facility_zip_code`, `facility_number_of_beds`, `facility_description`) VALUES ('0000', 'Default', 'Default', 'Default', 'Default', 'Default', '00000', 0, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `plain_emrs`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `plain_emrs`;
INSERT INTO `plain_emrs`.`roles` (`role_id`, `role_name`, `role_group`, `role_description`) VALUES ('0001', 'Admin', '', NULL);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
