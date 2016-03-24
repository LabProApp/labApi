/usr/local/Cellar/mysql/5.7.11

mysqladmin -uroot -ppassword create LABDBD

use LABDB;
DROP TABLE CUSTOMER;
DROP TABLE ADDRESS;
CREATE TABLE CUSTOMER(CUST_ID INT(16) AUTO_INCREMENT PRIMARY KEY,CUST_NAME  VARCHAR(100),AGE INTEGER,GENDER   VARCHAR(10),STATUS   VARCHAR(25),customerAddress_ADDRESS_ID INT(16),PRIM_MOBILE   VARCHAR(16),SECOND_MOBILE   VARCHAR(16),EMAIL_ID VARCHAR(100));


CREATE TABLE ADDRESS(ADDRESS_ID INT(16) AUTO_INCREMENT PRIMARY KEY,ADD_LINE1  VARCHAR(100),ADD_LINE2   VARCHAR(100),ADD_LINE3   VARCHAR(100),CITY VARCHAR(100),STATE   VARCHAR(32),ZIP  VARCHAR(12),COUNTRY VARCHAR(32));

CREATE TABLE DOCTOR(DOC_ID INT(16) AUTO_INCREMENT PRIMARY KEY,DOC_NAME  VARCHAR(100),DOC_BRANCH_CD INT(16),STATUS VARCHAR(25),HOSP_NAME VARCHAR(100),DOC_DEGREE VARCHAR(256),DOC_SPEC VARCHAR(256),DOC_EXP VARCHAR(512),docAddress_ADDRESS_ID INT(16),PRIM_MOBILE   VARCHAR(16),SECOND_MOBILE   VARCHAR(16),EMAIL_ID VARCHAR(100));