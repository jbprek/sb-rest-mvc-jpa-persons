-- Check and create user and schema 'persons'
alter session set container=XEPDB1;
BEGIN
    EXECUTE IMMEDIATE 'CREATE USER persons IDENTIFIED BY persons';
    EXECUTE IMMEDIATE 'GRANT CONNECT, RESOURCE, DBA, CREATE SESSION  TO persons';
    EXECUTE IMMEDIATE 'CREATE USER test_persons IDENTIFIED BY test_persons';
    EXECUTE IMMEDIATE 'GRANT CONNECT, RESOURCE, DBA, CREATE SESSION  TO test_persons';

EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -01920 AND  SQLCODE != -01921 THEN -- ORA-01920: user name conflicts with another user or role name
            RAISE;
        END IF;
END;
/
