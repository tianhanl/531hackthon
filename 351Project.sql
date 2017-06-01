DROP DATABASE if EXISTS 531Project;
CREATE DATABASE 531Project;

USE 531Project;

CREATE TABLE UserLogin(
	username VARCHAR(30) primary key NOT NULL,
    password VARCHAR(40) NOT NULL,
	nickname VARCHAR(30) NOT NULL
);

CREATE TABLE UserInfo(
	username VARCHAR(30),
    card_name VARCHAR(30),
    card_position int (11) NOT NULL
);

INSERT INTO UserLogin(username, password, nickname)
	VALUES ('tester', 'test', 'Test-Nickname')
