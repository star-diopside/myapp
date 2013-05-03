
/* Drop Tables */

DROP TABLE AUTHORITIES;
DROP TABLE T_ADDRESS;
DROP TABLE USER_ATTRIBUTE;
DROP TABLE USERS;




/* Create Tables */

CREATE TABLE AUTHORITIES
(
	USER_ID VARCHAR(16) NOT NULL,
	AUTHORITY VARCHAR(50) NOT NULL,
	REGISTER_DATETIME TIMESTAMP NOT NULL,
	REGISTER_USER_ID VARCHAR(16) NOT NULL,
	UPDATED_DATETIME TIMESTAMP NOT NULL,
	UPDATED_USER_ID VARCHAR(16) NOT NULL,
	VERSION INTEGER NOT NULL,
	PRIMARY KEY (USER_ID, AUTHORITY)
);


CREATE TABLE T_ADDRESS
(
	USER_ID VARCHAR(16) NOT NULL,
	MAIL_ADDRESS VARCHAR(128) NOT NULL,
	MAIL_SENDER_NAME VARCHAR(128),
	SMTP_SERVER_NAME VARCHAR(32) NOT NULL,
	SMTP_PORT INTEGER,
	SMTP_AUTH_USER_NAME VARCHAR(32),
	SMTP_AUTH_PASSWORD VARCHAR(32),
	REGISTER_DATETIME TIMESTAMP NOT NULL,
	REGISTER_USER_ID VARCHAR(16) NOT NULL,
	UPDATED_DATETIME TIMESTAMP NOT NULL,
	UPDATED_USER_ID VARCHAR(16) NOT NULL,
	VERSION INTEGER NOT NULL,
	PRIMARY KEY (USER_ID)
);


CREATE TABLE USERS
(
	USER_ID VARCHAR(16) NOT NULL,
	USERNAME VARCHAR(16) NOT NULL,
	PASSWORD CHAR(64) NOT NULL,
	PASSWORD_UPDATED_DATETIME TIMESTAMP NOT NULL,
	ENABLED BOOLEAN NOT NULL,
	PROVISIONAL_REGISTRATION BOOLEAN NOT NULL,
	LOGIN_ERROR_COUNT INTEGER NOT NULL,
	LAST_LOGIN_DATETIME TIMESTAMP,
	LOGOUT_DATETIME TIMESTAMP,
	REGISTER_DATETIME TIMESTAMP NOT NULL,
	REGISTER_USER_ID VARCHAR(16) NOT NULL,
	UPDATED_DATETIME TIMESTAMP NOT NULL,
	UPDATED_USER_ID VARCHAR(16) NOT NULL,
	VERSION INTEGER NOT NULL,
	PRIMARY KEY (USER_ID)
);


CREATE TABLE USER_ATTRIBUTE
(
	USER_ID VARCHAR(16) NOT NULL,
	ATTRIBUTE XML,
	REGISTER_DATETIME TIMESTAMP NOT NULL,
	REGISTER_USER_ID VARCHAR(16) NOT NULL,
	UPDATED_DATETIME TIMESTAMP NOT NULL,
	UPDATED_USER_ID VARCHAR(16) NOT NULL,
	VERSION INTEGER NOT NULL,
	PRIMARY KEY (USER_ID)
);



/* Create Foreign Keys */

ALTER TABLE AUTHORITIES
	ADD FOREIGN KEY (USER_ID)
	REFERENCES USERS (USER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE T_ADDRESS
	ADD FOREIGN KEY (USER_ID)
	REFERENCES USERS (USER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE USER_ATTRIBUTE
	ADD FOREIGN KEY (USER_ID)
	REFERENCES USERS (USER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



