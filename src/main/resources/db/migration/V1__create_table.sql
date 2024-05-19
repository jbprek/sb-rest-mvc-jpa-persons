CREATE SEQUENCE person_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE persons
(
    person_id  NUMBER(19, 0) NOT NULL,
    first_name VARCHAR2(255),
    last_name  VARCHAR2(255),
    birth_date date,
    country    VARCHAR2(255),
    version    NUMBER(38, 0),
    CONSTRAINT pk_persons PRIMARY KEY (person_id),
    CONSTRAINT uk_persons UNIQUE (first_name,last_name,birth_date,country)

);
