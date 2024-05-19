create table persons
(
    person_id  bigint auto_increment primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    birth_date date         not null,
    country    varchar(3)   not null,
    version    bigint
);