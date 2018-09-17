create table Users (
USER_ID SERIAL PRIMARY KEY,
FIRST_NAME varchar(255),
LAST_NAME varchar(255),
BIRTH_DATE date,
GENDER varchar(255)
);

insert into users(FIRST_NAME, LAST_NAME, BIRTH_DATE,GENDER)
values('Bill', 'Gates','28-OCT-1955','MEN');
commit;

select * from users;