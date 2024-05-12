-- Creates a new user in the database
DECLARE
    user_exists INTEGER;
BEGIN
    -- Check if the user already exists
    SELECT COUNT(*) INTO user_exists FROM dba_users WHERE username = 'persons';

    -- If the user does not exist, then create the user
    IF user_exists = 0 THEN
        EXECUTE IMMEDIATE 'CREATE USER persons IDENTIFIED BY persons';
        EXECUTE IMMEDIATE 'GRANT CONNECT, RESOURCE, CREATE SESSION, DBA TO persons';
        DBMS_OUTPUT.PUT_LINE('User persons created successfully.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('User persons already exists.');
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error creating user: ' || SQLERRM);
END;
/