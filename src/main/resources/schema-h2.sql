--drop table test;
-- create table test(id bigint auto_increment, name varchar(255));
-- insert into test(name) values('hello');
-- insert into test(name) values('world');
-- select * from test;

--     @Column(name = "USER_ID")
--     @GeneratedValue(strategy= GenerationType.AUTO)
--     private Long userId;
--
--     @Column(name = "FIRST_NAME")
--     private String firstName;
--
--     @Column(name =  "LAST_NAME")
--     private String lastName;
--
--     @Column(name = "BIRTH_DATE")
--     private Date birthDay;
--
--     @Column(name="GENDER")
--     private String gender;
drop table users

create table users (
USER_ID bigint auto_increment,
FIRST_NAME varchar(255),
LAST_NAME varchar(255),
BIRTH_DATE date,
GENDER varchar(255)
);

insert into users(FIRST_NAME, LAST_NAME, BIRTH_DATE,GENDER)
values('Bill', 'Gates','28-OCT-1955','MEN');

insert into users(FIRST_NAME, LAST_NAME, BIRTH_DATE,GENDER)
values('Larry', 'Elison','01-NOV-1952','MEN');

insert into users(FIRST_NAME, LAST_NAME, BIRTH_DATE,GENDER)
values('Big', 'Boss','01-JUN-1971','MEN');

commit;
