-- Application  database
create database persons;
CREATE USER 'persons'@'%' IDENTIFIED BY 'persons';
GRANT ALL PRIVILEGES ON persons.* TO 'persons'@'%';

create database test_persons;
CREATE USER 'test_persons'@'%' IDENTIFIED BY 'test_persons';
GRANT ALL PRIVILEGES ON test_persons.* TO 'test_persons'@'%';

