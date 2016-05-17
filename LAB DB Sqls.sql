/usr/local/Cellar/mysql/5.7.11
mysql.server start
mysql.server stop
mysql.server restart
mysqladmin -uroot -ppassword create LABDBD

use LABDB;  

CREATE TABLE `USERS` (
  `ID` int(16) NOT NULL AUTO_INCREMENT,
  `EMAIL_ID` varchar(100) DEFAULT NULL,
  `MOBILE` varchar(16) DEFAULT NULL,
  `ENC_PASSWD` varchar(100) DEFAULT NULL,
  `STATUS` int(4) DEFAULT NULL,
  `USER_TYPE` varchar(12) DEFAULT NULL,
  `OTP_TIME` time DEFAULT NULL,
  `OTP` varchar(6) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE SCHEDULE(SCHDLE_ID INT(16) AUTO_INCREMENT PRIMARY KEY,DOC_ID INT(16),LAB_BRANCH_CD INT(16),LAB_REP_CD INT(16),WORKING_DAYS VARCHAR(40),
				MRNG_START TIME,MRNG_END TIME,MRNG_TKNS_TOTAL INT(4),
				AFTRN_START TIME,AFTRN_END TIME,AFTRN_TKNS_TOTAL INT(4),
				EVNG_START TIME,EVNG_END TIME,EVNG_TKNS_TOTAL INT(4),
				NIGHT_START TIME,NIGHT_END TIME,NIGHT_TKNS_TOTAL INT(4),
				STATUS INT(4));

CREATE TABLE APPOINTMENT(APPMNT_ID INT(16) AUTO_INCREMENT PRIMARY KEY,APPMNT_REF VARCHAR(10),SCHDLE_ID INT(16),DOC_ID INT(16),LAB_BRANCH_CD INT(16),LAB_REP_ID INT(16),PTNT_ID INT(16),
	HOME_PICK CHAR(1),SCHEDULE_DT DATE,START_TIME TIME,END_TIME TIME,
	SHIFT VARCHAR(10),TOKEN_NUM INT(4),
	REFF_BY_DOCID INT(16),DISEASE VARCHAR(512),PRESCRIPTION VARCHAR(512),
	TEST_IDs VARCHAR(512),TEST_RESULT_IDs VARCHAR(512),
	STATUS INT(4));
				

CREATE TABLE IMAGES(IMAGES_ID INT(16) AUTO_INCREMENT PRIMARY KEY,ENTITY_ID INT(16),ENTITY_TYP VARCHAR(12),IMG_NAME VARCHAR(512),S3_PATH VARCHAR(512),IMG_URL VARCHAR(512),IMG_TYPE VARCHAR(25),STATUS INT(4));

CREATE TABLE SPECIALITY(SPEC_ID INT(16) AUTO_INCREMENT PRIMARY KEY,SPEC_NAME VARCHAR(100),STATUS INT(4),SEARCH_TAGS VARCHAR(512));

CREATE TABLE PATIENT(PTNT_ID INT(16) AUTO_INCREMENT PRIMARY KEY,PTNT_NAME  VARCHAR(100),AGE INTEGER,GENDER   VARCHAR(10),STATUS   INT(4),patientAddress_ADDRESS_ID INT(16),PRIM_MOBILE   VARCHAR(16),SECOND_MOBILE   VARCHAR(16),EMAIL_ID VARCHAR(100));

CREATE TABLE ADDRESS(ADDRESS_ID INT(16) AUTO_INCREMENT PRIMARY KEY,ADD_LINE1  VARCHAR(100),ADD_LINE2   VARCHAR(100),ADD_LINE3   VARCHAR(100),CITY VARCHAR(100),ADD_TYPE VARCHAR(12),STATE   VARCHAR(32),ZIP  VARCHAR(12),COUNTRY VARCHAR(32));

CREATE TABLE DOCTOR(DOC_ID INT(16) AUTO_INCREMENT PRIMARY KEY,DOC_NAME  VARCHAR(100),DOC_BRANCH_CD INT(16),STATUS   INT(4),HOSP_NAME VARCHAR(100),DOC_DEGREE VARCHAR(256),DOC_SPEC VARCHAR(256),DOC_EXP VARCHAR(512),docAddress_ADDRESS_ID INT(16),PRIM_MOBILE   VARCHAR(16),SECOND_MOBILE   VARCHAR(16),EMAIL_ID VARCHAR(50));
ALTER TABLE DOCTOR ADD FEE INT(5);
ALTER TABLE DOCTOR ADD BOOK_FLAG INT(1);




CREATE TABLE IF NOT EXISTS `booking_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `booking_status` (`id`, `name`) VALUES
(1, 'Pending for Approval'),
(2, 'Approved & Booked'),
(3, 'Cancelled by User'),
(4, 'Visited'),
(5, 'User failed to Visit');




CREATE TABLE LAB_OFFICE(LAB_OFFICE_ID INT(16) AUTO_INCREMENT PRIMARY KEY,LAB_NAME  VARCHAR(100),STATUS   INT(4),labAddress_ADDRESS_ID INT(16),LAB_OWNER VARCHAR(100), PRIM_MOBILE   VARCHAR(16),SECOND_MOBILE   VARCHAR(16),EMAIL_ID VARCHAR(100));

CREATE TABLE LAB_BRANCH(LAB_OFFICE_ID INT(16),FOREIGN KEY(LAB_OFFICE_ID) REFERENCES LAB_OFFICE(LAB_OFFICE_ID), LAB_BRANCH_CD INT(16)  AUTO_INCREMENT PRIMARY KEY,LAB_NAME  VARCHAR(100),STATUS   INT(4),labAddress_ADDRESS_ID INT(16),LAB_BR_OWNER VARCHAR(100), PRIM_MOBILE   VARCHAR(16),EMAIL_ID VARCHAR(100));

CREATE TABLE LAB_BRANCH_REP(LAB_REP_ID INT(16)  AUTO_INCREMENT PRIMARY KEY,PRIM_MOBILE   VARCHAR(16),REP_NAME VARCHAR(100),LAB_BRANCH_CD INT(16), FOREIGN KEY(LAB_BRANCH_CD) REFERENCES LAB_BRANCH(LAB_BRANCH_CD),STATUS   INT(4));

CREATE TABLE TESTS(TEST_ID INT(16) AUTO_INCREMENT PRIMARY KEY,TEST_NAME  VARCHAR(100),SHORT_NAME VARCHAR(20),STATUS   INT(4),LOWER_VALUE VARCHAR(10),UPPER_VALUE VARCHAR(10),UNITS VARCHAR(10),TEST_TYPE VARCHAR(10),BODY_ORGAN VARCHAR(100),DESCRIPTION VARCHAR(512),TEST_STEPS VARCHAR(512));

CREATE TABLE SYS_CODE(SYS_TYPE VARCHAR (24),SYS_VALUE INT(4),DESCRIPTION VARCHAR(100));
		
CREATE TABLE REVIEWS(REVIEW_ID INT(16) AUTO_INCREMENT PRIMARY KEY,PTNT_ID INT(16),DOCTOR_ID INT(16),LAB_OFFICE_ID INT(16),LAB_BRANCH_CD INT(16),RATING INT(2),RATING_DT DATE,REVIEW VARCHAR(512));

CREATE TABLE TESTS_LAB(ID INT(16),LAB_OFFICE_ID INT(16),LAB_BRANCH_CD INT(16),TEST_ID INT(16),STATUS INT(4),HOME_PICK CHAR(1),FEE INT(5));


select * from CUSTOMER;
select * from ADDRESS;
select * from DOCTOR;
select * from LAB_OFFICE;
select * from LAB_BRANCH;
select * from LAB_BRANCH_REP;
