CREATE TABLE physiotherapy_bd.user (
user_id BIGINT PRIMARY KEY,
user_type_id VARCHAR(2) NOT NULL,
user_first_name VARCHAR(50) NOT NULL,
user_second_name VARCHAR(50),
user_last_name VARCHAR(50) NOT NULL,
user_second_last_name VARCHAR(50),
user_birthdate DATE NOT NULL,
user_phone_number VARCHAR(15) NOT NULL,
user_address VARCHAR(40),
insurance_entity VARCHAR(50) )

CREATE TABLE physiotherapy_bd.employee (
employee_id BIGINT PRIMARY KEY,
employee_type_id VARCHAR(2) NOT NULL,
employee_first_name VARCHAR(50) NOT NULL,
employee_second_name VARCHAR(50),
employee_last_name VARCHAR(50) NOT NULL,
employee_second_last_name VARCHAR(50),
employee_birthdate DATE NOT NULL,
employee_phone_number VARCHAR(15) NOT NULL,
employee_address VARCHAR(40) )

CREATE TABLE physiotherapy_bd.package (
package_code VARCHAR (10) PRIMARY KEY,
package_name VARCHAR(60),
session_duration TIME,
session_price DECIMAL,
number_of_sessions SMALLINT )

CREATE TABLE physiotherapy_bd.appointment (
appointment_code VARCHAR(10) PRIMARY KEY,
appointment_type VARCHAR(20),
appointment_duration TIME,
appointment_price DECIMAL )

CREATE TABLE physiotherapy_bd.user_employee (
user_id BIGINT,
employee_id BIGINT,
PRIMARY KEY (user_id, employee_id),
FOREIGN KEY (user_id) REFERENCES user(user_id),
FOREIGN KEY (employee_id) REFERENCES employee(employee_id))

CREATE TABLE physiotherapy_bd.user_package (
user_id BIGINT,
package_code VARCHAR (10),
PRIMARY KEY (user_id, package_code),
FOREIGN KEY (user_id) REFERENCES user(user_id),
FOREIGN KEY (package_code) REFERENCES package(package_code))

CREATE TABLE physiotherapy_bd.iser_appointment (
user_id BIGINT,
appointment_code VARCHAR(10),
PRIMARY KEY (user_id, appointment_code),
FOREIGN KEY (user_id) REFERENCES user(user_id),
FOREIGN KEY (appointment_code) REFERENCES appointment(appointment_code))

CREATE TABLE physiotherapy_bd.employee_package (
employee_id BIGINT,
package_code VARCHAR (10),
PRIMARY KEY (employee_id, package_code),
FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
FOREIGN KEY (package_code) REFERENCES package(package_code))

CREATE TABLE physiotherapy_bd.employee_appointment (
employee_id BIGINT,
appointment_code VARCHAR(10),
PRIMARY KEY (employee_id, appointment_code),
FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
FOREIGN KEY (appointment_code) REFERENCES appointment(appointment_code))

ALTER TABLE iser_appointment RENAME TO user_appointment;