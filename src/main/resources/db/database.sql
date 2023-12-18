CREATE DATABASE IF NOT EXISTS `hr-app` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `hr-app`;


CREATE USER 'hrapp'@'localhost' IDENTIFIED BY 'hrappPassword';

GRANT ALL PRIVILEGES ON hr_app.* TO 'hrapp'@'localhost';
FLUSH PRIVILEGES;

DROP TABLE IF EXISTS `EMPLOYEE`;
DROP TABLE IF EXISTS `LEAVE_TYPE`;
DROP TABLE IF EXISTS `LEAVE_REQUEST`;

CREATE TABLE EMPLOYEE
(
    `ID`                 VARCHAR(36)                  NOT NULL PRIMARY KEY,
    `USERNAME`           VARCHAR(50)                  NOT NULL UNIQUE,
    `PASSWORD`           VARCHAR(150)                 NOT NULL,
    `FIRST_NAME`         VARCHAR(50)                  NOT NULL,
    `LAST_NAME`          VARCHAR(50)                  NOT NULL,
    `EMAIL`              VARCHAR(100)                 NOT NULL UNIQUE,
    `BIRTHDAY`           DATE,
    `START_WORKING_DATE` DATE                         NOT NULL,
    `ROLE`               ENUM ('MANAGER', 'EMPLOYEE') NOT NULL,
    `GENDER`             ENUM ('MALE', 'FEMALE')      NOT NULL,
    `CREATOR`            VARCHAR(50)                  NOT NULL,
    `CREATION_TIME`      DATETIME                     NOT NULL
);

INSERT INTO EMPLOYEE
VALUES ('c2bb5d0a-9674-11ee-94d3-fc3497dcdce8',
        'violet',
        '1234',
        'Menekse',
        'Yuncu',
        'violet@mail.com',
        '2010-01-01',
        '2020-01-01',
        'MANAGER',
        'FEMALE',
        'violet',
        NOW());

CREATE TABLE LEAVE_TYPE
(
    `ID`            VARCHAR(36) NOT NULL PRIMARY KEY,
    `NAME`          VARCHAR(50) NOT NULL,
    `MAX_DAYS`      INT,
    `CREATOR`       VARCHAR(50) NOT NULL,
    `CREATION_TIME` DATETIME    NOT NULL
);

INSERT INTO LEAVE_TYPE
VALUES ('c2cd7234-9674-11ee-94d3-fc3497dcdce8',
        'Annual Leave',
        12,
        'violet',
        NOW());

CREATE TABLE LEAVE_REQUEST
(
    `ID`            VARCHAR(36) NOT NULL PRIMARY KEY,
    `EMPLOYEE_ID`   VARCHAR(36) NOT NULL,
    `START_DATE`    DATE        NOT NULL,
    `END_DATE`      DATE        NOT NULL,
    `LEAVE_TYPE_ID` VARCHAR(36) NOT NULL,
    `STATE`         ENUM ('PENDING', 'APPROVED', 'REJECTED'),
    `CREATOR`       VARCHAR(50) NOT NULL,
    `CREATION_TIME` DATETIME    NOT NULL,

    FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `EMPLOYEE` (`ID`),
    FOREIGN KEY (`LEAVE_TYPE_ID`) REFERENCES `LEAVE_TYPE` (`ID`)
);

INSERT INTO LEAVE_REQUEST
VALUES (UUID(),
        'c2bb5d0a-9674-11ee-94d3-fc3497dcdce8',
        '2020-01-01',
        '2020-01-02',
        'c2cd7234-9674-11ee-94d3-fc3497dcdce8',
        'APPROVED',
        'violet',
        NOW());

