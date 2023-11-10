CREATE DATABASE IF NOT EXISTS `hr-app` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `hr-app`;

DROP TABLE IF EXISTS `employee`;
DROP TABLE IF EXISTS `leave_type`;


CREATE TABLE employee
(
    id                 VARCHAR(50)                  NOT NULL UNIQUE KEY,
    username           VARCHAR(50)                  NOT NULL,
    password           VARCHAR(150)                 NOT NULL,
    first_name         VARCHAR(50),
    last_name          VARCHAR(50),
    email              VARCHAR(100),
    birthday           DATE,
    start_working_date DATE                         NOT NULL,
    role               ENUM ('MANAGER', 'EMPLOYEE') NOT NULL,
    gender             ENUM ('MALE', 'FEMALE')      NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO employee
VALUES (UUID(),
        'violet',
        '1234',
        'Menekse',
        'Yuncu',
        'violet@mail.com',
        '2010-01-01',
        '2020-01-01',
        'MANAGER',
        'FEMALE');

CREATE TABLE leave_type
(
    id       INT         NOT NULL PRIMARY KEY UNIQUE KEY,
    name     VARCHAR(50) NOT NULL,
    max_days INT,
    gender   ENUM ('MALE', 'FEMALE')
);




