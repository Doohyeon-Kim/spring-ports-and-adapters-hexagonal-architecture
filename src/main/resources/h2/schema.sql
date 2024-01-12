DROP TABLE IF EXISTS USER;
CREATE TABLE USER
(
    id int NOT NULL,
    name varchar(10) NOT NULL,
    age int,
    PRIMARY KEY(id)
);

DROP TABLE IF ACCOUNT;
CREATE TABLE ACCOUNT
(
    account_number varchar(10) NOT NULL,
    balance BIGINT(50),
    name varchar(10),
    PRIMARY KEY account_number
);

DROP TABLE IF TRANSACTION;
CREATE TABLE TRANSACTION
(
    id int NOT NULL AUTO_INCREMENT,
    source_account_number varchar(10) NOT NULL,
    target_account_number varchar(10),
    money BIGINT(50),
    datetime datetime,
    PRIMARY KEY id,
);