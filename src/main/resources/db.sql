DROP DATABASE IF EXISTS coder_applications_riwi;

CREATE DATABASE coder_applications_riwi;

USE coder_applications_riwi;

CREATE TABLE coders(
  id INT PRIMARY KEY AUTO_INCREMENT,
  dni VARCHAR(15) NOT NULL UNIQUE,
  name VARCHAR(100) NOT NULL,
  lastnames VARCHAR(150) NOT NULL,
  cohort VARCHAR(50) NOT NULL,
  tech_profile ENUM('next_js', 'nest_js', 'java', 'dotnet')
);

CREATE TABLE companies(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    location VARCHAR(150) NOT NULL
);


CREATE TABLE vacancies(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(150) NOT NULL,
    description TEXT NOT NULL,
    post_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    salary DECIMAL(12, 2),
    status ENUM('active', 'inactive'),
    companies_id INT NOT NULL,
    CONSTRAINT fk_companies_id FOREIGN KEY (companies_id) REFERENCES companies(id)
);

CREATE TABLE applications(
    id INT PRIMARY KEY AUTO_INCREMENT,
    status ENUM('active', 'inactive'),
    date DATETIME DEFAULT CURRENT_TIMESTAMP,
    vacancies_id INT NOT NULL,
    coders_id INT NOT NULL,
    CONSTRAINT fk_vacancies_id
        FOREIGN KEY (vacancies_id) REFERENCES vacancies(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_coders_id FOREIGN KEY (coders_id) REFERENCES coders(id)
);


ALTER TABLE coders ADD COLUMN clan VARCHAR(50) NOT NULL;
ALTER TABLE vacancies ADD COLUMN technology ENUM('next_js', 'nest_js', 'java', 'dotnet') NOT NULL;

INSERT INTO companies(name, location)
VALUES('Bancolombia', 'Medellin'),
('Softek', 'Bogota'),
('Sofka', 'Medellin'),
('Sistecredito', 'Medellin');