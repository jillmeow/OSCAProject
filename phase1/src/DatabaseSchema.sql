drop table children;
drop table members;
drop table partner;
drop table sibling;
drop table payments;

create table children(
ID integer not null,
FirstName varchar(20) not null,
lastName varchar(20) not null,
address varchar not null,
phoneNumber varchar(13) not null,
email varchar not null,
catagories varchar,
status varchar(1) not null,
eligibility varchar(5) not null,
constraint pk_children primary key (ID)

);

create table partner(
ID integer not null,
FirstName varchar(20) not null,
lastName varchar(20) not null,
address varchar not null,
phoneNumber varchar(13) not null,
email varchar not null,
catagories varchar,
status varchar(1) not null,
eligibility varchar(5) not null,
constraint pk_partner primary key (ID)

);
create table sibling(
ID integer not null,
FirstName varchar(20) not null,
lastName varchar(20) not null,
address varchar not null,
phoneNumber varchar(13) not null,
email varchar not null,
catagories varchar,
status varchar(1) not null,
eligibility varchar(5) not null,
constraint pk_sibling primary key (ID)

);

create table members(
ID integer not null,
FirstName varchar(20) not null,
lastName varchar(20) not null,
address varchar not null,
phoneNumber varchar(13) not null,
email varchar not null,
partnersname varchar(30),
siblingsname varchar(200),
catagories varchar,
subscription varchar not null,
child varchar(200),
status varchar(1) not null,
eligibility varchar(5) not null,
constraint pk_member primary key (ID)

);

create table payments(
payment_ID integer not null, 
ID integer not null,
Amount number(12,2) not null,
Description varchar not null,
Date_Payed varchar not null,
Date_Recorded varchar not null,
constraint pk_payments primary key(payment_ID), 
constraint fk_payments foreign key(ID) references members(ID)
); 


create table admins(
username varchar not null,
password varchar not null,
constraint pk_admins primary key(username)
 );

SELECT * FROM MEMBERS WHERE CATAGORIES LIKE '%Basketball%';
SELECT * FROM MEMBERS WHERE CATAGORIES LIKE '%Chinese School%';
SELECT * FROM MEMBERS WHERE CATAGORIES LIKE '%Social%';
SELECT * FROM MEMBERS WHERE CATAGORIES LIKE '%Fundraising%';
SELECT * FROM MEMBERS WHERE CATAGORIES LIKE '%Newsletter%';
SELECT * FROM MEMBERS WHERE CATAGORIES LIKE '%Cultural%';