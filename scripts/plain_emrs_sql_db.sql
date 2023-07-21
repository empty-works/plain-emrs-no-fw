-- MySQL Script generated by MySQL Workbench
-- Fr 21 Jul 2023 16:50:09
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
  `user_date_of_death` VARCHAR(45) NULL,
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
  `patient_license_number` VARCHAR(45) NULL DEFAULT 'None',
  `patient_vehicle_serial_number` VARCHAR(45) NULL DEFAULT 'None',
  `patient_vehicle_plate_number` VARCHAR(45) NULL DEFAULT 'None',
  `patient_url` VARCHAR(45) NULL DEFAULT 'None',
  `patient_device_serial_number` VARCHAR(45) NULL DEFAULT 'None',
  `patient_ip_address` VARCHAR(45) NULL DEFAULT 'None',
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
-- Table `plain_emrs`.`chief_complaints`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`chief_complaints` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`chief_complaints` (
  `chief_complaint_id` VARCHAR(85) NOT NULL,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `admissions_id` INT NULL,
  `statement` BLOB NOT NULL,
  `chief_complaint_date` DATETIME NOT NULL,
  PRIMARY KEY (`chief_complaint_id`, `medical_record_id`),
  INDEX `fk_chief_complaints_medical_records1_idx` (`medical_record_id` ASC) VISIBLE,
  CONSTRAINT `fk_chief_complaints_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
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
  `chief_complaint_id` VARCHAR(85) NOT NULL,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `diagnosis_title` VARCHAR(45) NOT NULL,
  `diagnosis_date` DATETIME NOT NULL,
  `diagnosis_description` BLOB NOT NULL,
  PRIMARY KEY (`diagnosis_id`, `chief_complaint_id`, `medical_record_id`),
  INDEX `fk_diagnoses_chief_complaints1_idx` (`chief_complaint_id` ASC, `medical_record_id` ASC) VISIBLE,
  CONSTRAINT `fk_diagnoses_chief_complaints1`
    FOREIGN KEY (`chief_complaint_id` , `medical_record_id`)
    REFERENCES `plain_emrs`.`chief_complaints` (`chief_complaint_id` , `medical_record_id`)
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
  INDEX `fk_appointments_medical_records1_idx` (`medical_record_id` ASC) VISIBLE,
  PRIMARY KEY (`appointment_id`),
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
  `medication_id` INT NOT NULL AUTO_INCREMENT,
  `chief_complaint_id` VARCHAR(85) NOT NULL,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `medication_name` VARCHAR(150) NOT NULL,
  `medication_is_current` TINYINT NOT NULL,
  `medication_description` BLOB NULL,
  PRIMARY KEY (`medication_id`),
  INDEX `fk_medication_chief_complaints1_idx` (`chief_complaint_id` ASC, `medical_record_id` ASC) VISIBLE,
  CONSTRAINT `fk_medication_chief_complaints1`
    FOREIGN KEY (`chief_complaint_id` , `medical_record_id`)
    REFERENCES `plain_emrs`.`chief_complaints` (`chief_complaint_id` , `medical_record_id`)
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
  `allergy_id` INT NOT NULL AUTO_INCREMENT,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `allergy_name` VARCHAR(75) NOT NULL DEFAULT 'none',
  `allergy_severity` VARCHAR(75) NULL,
  `additional_information` BLOB NULL,
  PRIMARY KEY (`allergy_id`),
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
  `visits_title` VARCHAR(75) NOT NULL,
  `visits_date` DATETIME NOT NULL,
  `visits_description` BLOB NOT NULL,
  INDEX `fk_visits_medical_records1_idx` (`medical_record_id` ASC) VISIBLE,
  PRIMARY KEY (`visit_id`),
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
  `vitals_id` INT NOT NULL AUTO_INCREMENT,
  `chief_complaint_id` VARCHAR(85) NOT NULL,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `vitals_date_taken` DATETIME NULL,
  `vitals_height` FLOAT NULL,
  `vitals_weight` FLOAT NULL,
  `vitals_calculated_bmi` FLOAT NULL,
  `vitals_temperature` FLOAT NULL,
  `vitals_pulse` FLOAT NULL,
  `vitals_respiratory_rate` FLOAT NULL,
  `vitals_blood_pressure_systolic` FLOAT NULL,
  `vitals_blood_pressure_diastolic` FLOAT NULL,
  `vitals_arterial_blood_oxygen_saturation` FLOAT NULL,
  PRIMARY KEY (`vitals_id`, `chief_complaint_id`, `medical_record_id`),
  INDEX `fk_vitals_chief_complaints1_idx` (`chief_complaint_id` ASC, `medical_record_id` ASC) VISIBLE,
  CONSTRAINT `fk_vitals_chief_complaints1`
    FOREIGN KEY (`chief_complaint_id` , `medical_record_id`)
    REFERENCES `plain_emrs`.`chief_complaints` (`chief_complaint_id` , `medical_record_id`)
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
  `user_login_logs_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(75) NOT NULL,
  `user_date_time_of_visit` DATETIME NOT NULL,
  PRIMARY KEY (`user_login_logs_id`),
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
  `authorities_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(75) NOT NULL,
  `authority` VARCHAR(50) NOT NULL,
  INDEX `fk_authorities_users1_idx` (`user_id` ASC) VISIBLE,
  PRIMARY KEY (`authorities_id`),
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
  `emergency_contact_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(75) NOT NULL,
  `emergency_contact_given_name` VARCHAR(50) NOT NULL,
  `emergency_contact_middle_initial` VARCHAR(50) NULL,
  `emergency_contact_last_name` VARCHAR(50) NOT NULL,
  `emergency_contact_phone_number` VARCHAR(15) NOT NULL,
  `emergency_contact_email_address` VARCHAR(254) NULL,
  PRIMARY KEY (`emergency_contact_id`),
  INDEX `fk_emergency_contacts_patients1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_emergency_contacts_patients1`
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
  PRIMARY KEY (`specialty_id`),
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
  PRIMARY KEY (`ward_id`),
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
  PRIMARY KEY (`staff_position_id`),
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
  INDEX `fk_nurse_notes_medical_records1_idx` (`medical_record_id` ASC) VISIBLE,
  PRIMARY KEY (`nurse_note_id`),
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
-- Table `plain_emrs`.`user_activity_logs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`user_activity_logs` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`user_activity_logs` (
  `user_activity_logs_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(75) NOT NULL,
  `user_date_time_of_activity` DATETIME NOT NULL,
  `activity_description` TINYBLOB NOT NULL,
  PRIMARY KEY (`user_activity_logs_id`),
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
  PRIMARY KEY (`facilities_roles_id`, `role_id`),
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
  `user_authorized_facilities_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(75) NOT NULL,
  `facility_id` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`user_authorized_facilities_id`),
  CONSTRAINT `fk_user_authorized_facilities_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `plain_emrs`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`immunizations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`immunizations` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`immunizations` (
  `immunization_id` INT NOT NULL AUTO_INCREMENT,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `immunization` VARCHAR(85) NOT NULL DEFAULT 'unknown',
  `disease` VARCHAR(85) NOT NULL,
  `disease_id` VARCHAR(65) NOT NULL,
  PRIMARY KEY (`immunization_id`),
  INDEX `fk_diseases_medical_records1_idx` (`medical_record_id` ASC) VISIBLE,
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
  `surgical_related_id` INT NOT NULL AUTO_INCREMENT,
  `surgical_related_problem` VARCHAR(75) NOT NULL,
  `problem_area` VARCHAR(45) NOT NULL,
  `surgical_procedure` VARCHAR(75) NULL DEFAULT 'none',
  `surgical_procedure_year` VARCHAR(45) NULL DEFAULT 'none',
  `chief_complaint_id` VARCHAR(85) NOT NULL,
  `medical_record_id` VARCHAR(85) NOT NULL,
  PRIMARY KEY (`surgical_related_id`),
  INDEX `fk_surgical_related_problems_chief_complaints1_idx` (`chief_complaint_id` ASC, `medical_record_id` ASC) VISIBLE,
  CONSTRAINT `fk_surgical_related_problems_chief_complaints1`
    FOREIGN KEY (`chief_complaint_id` , `medical_record_id`)
    REFERENCES `plain_emrs`.`chief_complaints` (`chief_complaint_id` , `medical_record_id`)
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
  `blood_relatives_id` INT NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY (`blood_relatives_id`),
  INDEX `fk_blood_relatives_medical_records1_idx` (`medical_record_id` ASC) VISIBLE,
  CONSTRAINT `fk_blood_relatives_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`family_illnesses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`family_illnesses` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`family_illnesses` (
  `illness_id` INT NOT NULL AUTO_INCREMENT,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `illness` VARCHAR(75) NOT NULL,
  `father` TINYINT NULL,
  `mother` TINYINT NULL,
  `brothers` TINYINT NULL,
  `sisters` TINYINT NULL,
  `sons` TINYINT NULL,
  `daughters` TINYINT NULL,
  `grandparents` TINYINT NULL,
  PRIMARY KEY (`illness_id`),
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
  `patient_race_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(75) NOT NULL,
  `patient_race` VARCHAR(254) NOT NULL,
  PRIMARY KEY (`patient_race_id`),
  CONSTRAINT `fk_patient_races_patients1`
    FOREIGN KEY (`user_id`)
    REFERENCES `plain_emrs`.`patients` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`admissions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`admissions` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`admissions` (
  `admission_id` INT NOT NULL AUTO_INCREMENT,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `date_of_admission` DATETIME NOT NULL,
  `description` BLOB NOT NULL,
  PRIMARY KEY (`admission_id`, `medical_record_id`),
  INDEX `fk_admissions_medical_records1_idx` (`medical_record_id` ASC) VISIBLE,
  CONSTRAINT `fk_admissions_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`histories_present_illness`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`histories_present_illness` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`histories_present_illness` (
  `history_present_illness_id` INT NOT NULL AUTO_INCREMENT,
  `chief_complaint_id` VARCHAR(85) NOT NULL,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `location` BLOB NULL,
  `character` BLOB NULL,
  `duration` BLOB NULL,
  `onset` BLOB NULL,
  `modifying_factors` BLOB NULL,
  `radiation` BLOB NULL,
  `temporal_pattern` BLOB NULL,
  `severity` BLOB NULL,
  PRIMARY KEY (`history_present_illness_id`, `chief_complaint_id`, `medical_record_id`),
  INDEX `fk_histories_present_illness_chief_complaints1_idx` (`chief_complaint_id` ASC, `medical_record_id` ASC) VISIBLE,
  CONSTRAINT `fk_histories_present_illness_chief_complaints1`
    FOREIGN KEY (`chief_complaint_id` , `medical_record_id`)
    REFERENCES `plain_emrs`.`chief_complaints` (`chief_complaint_id` , `medical_record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`reviews_of_systems`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`reviews_of_systems` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`reviews_of_systems` (
  `review_of_systems_id` INT NOT NULL AUTO_INCREMENT,
  `chief_complaint_id` VARCHAR(85) NOT NULL,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `constitutional_symptoms` BLOB NULL,
  `eyes` BLOB NULL,
  `ears_nose_throat` BLOB NULL,
  `cardiovascular` BLOB NULL,
  `respiratory` BLOB NULL,
  `gastrointestinal` BLOB NULL,
  `genitournary` BLOB NULL,
  `musculoskeletal` BLOB NULL,
  `integumentary` BLOB NULL,
  `neurological` BLOB NULL,
  `psychiatric` BLOB NULL,
  `endocrine` BLOB NULL,
  `hematologic_lymphatic` BLOB NULL,
  `allergic_immunologic` BLOB NULL,
  `reviews_of_systems_date` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`review_of_systems_id`, `chief_complaint_id`, `medical_record_id`),
  INDEX `fk_review_of_systems_chief_complaints1_idx` (`chief_complaint_id` ASC, `medical_record_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_of_systems_chief_complaints1`
    FOREIGN KEY (`chief_complaint_id` , `medical_record_id`)
    REFERENCES `plain_emrs`.`chief_complaints` (`chief_complaint_id` , `medical_record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`physical_exams`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`physical_exams` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`physical_exams` (
  `physical_exam_id` INT NOT NULL AUTO_INCREMENT,
  `chief_complaint_id` VARCHAR(85) NOT NULL,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `heent` BLOB NULL,
  `respiratory` BLOB NULL,
  `cardiovascular` BLOB NULL,
  `abdominal` BLOB NULL,
  `limbs` BLOB NULL,
  `neurological` BLOB NULL,
  `physical_exam_date` DATETIME NOT NULL,
  PRIMARY KEY (`physical_exam_id`, `chief_complaint_id`, `medical_record_id`),
  INDEX `fk_physical_exams_chief_complaints1_idx` (`chief_complaint_id` ASC, `medical_record_id` ASC) VISIBLE,
  CONSTRAINT `fk_physical_exams_chief_complaints1`
    FOREIGN KEY (`chief_complaint_id` , `medical_record_id`)
    REFERENCES `plain_emrs`.`chief_complaints` (`chief_complaint_id` , `medical_record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`assessments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`assessments` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`assessments` (
  `assessment_id` INT NOT NULL AUTO_INCREMENT,
  `chief_complaint_id` VARCHAR(85) NOT NULL,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `summation` BLOB NOT NULL,
  PRIMARY KEY (`assessment_id`, `chief_complaint_id`, `medical_record_id`),
  INDEX `fk_assessments_and_plans_chief_complaints1_idx` (`chief_complaint_id` ASC, `medical_record_id` ASC) VISIBLE,
  CONSTRAINT `fk_assessments_and_plans_chief_complaints1`
    FOREIGN KEY (`chief_complaint_id` , `medical_record_id`)
    REFERENCES `plain_emrs`.`chief_complaints` (`chief_complaint_id` , `medical_record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`plans`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`plans` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`plans` (
  `plan_id` INT NOT NULL AUTO_INCREMENT,
  `chief_complaint_id` VARCHAR(85) NOT NULL,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `summation` BLOB NOT NULL,
  PRIMARY KEY (`plan_id`, `chief_complaint_id`, `medical_record_id`),
  INDEX `fk_plans_chief_complaints1_idx` (`chief_complaint_id` ASC, `medical_record_id` ASC) VISIBLE,
  CONSTRAINT `fk_plans_chief_complaints1`
    FOREIGN KEY (`chief_complaint_id` , `medical_record_id`)
    REFERENCES `plain_emrs`.`chief_complaints` (`chief_complaint_id` , `medical_record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`social_histories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`social_histories` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`social_histories` (
  `social_history_id` INT NOT NULL AUTO_INCREMENT,
  `medical_record_id` VARCHAR(85) NOT NULL,
  `substances` BLOB NULL,
  `occupation` BLOB NULL,
  `sexual_behavior` BLOB NULL,
  `prison` BLOB NULL,
  `travel` BLOB NULL,
  `exercise` BLOB NULL,
  `diet` BLOB NULL,
  `firearms_in_household` BLOB NULL,
  PRIMARY KEY (`social_history_id`, `medical_record_id`),
  INDEX `fk_social_histories_medical_records1_idx` (`medical_record_id` ASC) VISIBLE,
  CONSTRAINT `fk_social_histories_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`users_medical_records_updates`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`users_medical_records_updates` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`users_medical_records_updates` (
  `medical_record_id` VARCHAR(85) NOT NULL,
  `caregiver_user_id` VARCHAR(75) NOT NULL,
  `record_related_id` INT NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`medical_record_id`),
  CONSTRAINT `fk_users_medical_records_updates_medical_records1`
    FOREIGN KEY (`medical_record_id`)
    REFERENCES `plain_emrs`.`medical_records` (`medical_record_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `plain_emrs`.`assigned_patients`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plain_emrs`.`assigned_patients` ;

CREATE TABLE IF NOT EXISTS `plain_emrs`.`assigned_patients` (
  `staff_user_id` VARCHAR(75) NOT NULL,
  `patient_user_id` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`staff_user_id`),
  UNIQUE INDEX `patient_user_id_UNIQUE` (`patient_user_id` ASC) VISIBLE,
  UNIQUE INDEX `staff_user_id_UNIQUE` (`staff_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_assigned_patients_users1`
    FOREIGN KEY (`staff_user_id`)
    REFERENCES `plain_emrs`.`users` (`user_id`)
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
INSERT INTO `plain_emrs`.`users` (`user_id`, `user_password`, `user_email_address`, `user_enabled`, `user_created_on`, `current_facility_id`, `user_first_name`, `user_middle_initial`, `user_last_name`, `user_date_of_birth`, `user_date_of_death`) VALUES ('the_admin', '123', 'the_admin@gmail.com', true, '2021-08-05 21:57:01', NULL, 'Unknown', NULL, 'Unknown', '1999-01-01', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `plain_emrs`.`authorities`
-- -----------------------------------------------------
START TRANSACTION;
USE `plain_emrs`;
INSERT INTO `plain_emrs`.`authorities` (`authorities_id`, `user_id`, `authority`) VALUES (DEFAULT, 'the_admin', 'ROLE_ADMIN');
INSERT INTO `plain_emrs`.`authorities` (`authorities_id`, `user_id`, `authority`) VALUES (DEFAULT, 'the_admin', 'ROLE_AUTHORIZED');

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
