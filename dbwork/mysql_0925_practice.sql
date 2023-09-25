create table practice(
	num smallint auto_increment,
    name varchar(20),
    eng int,
    kor int,
    blood Varchar(20),
    phone varchar(20),
    addr varchar(40),
    wrtieday date,
    constraint pr_pk_num primary key(num),
    constraint pr_ck_blood check(blood in ('A','B','O','AB'))
);

drop table practice;

alter table practice CHANGE COLUMN wrtieday writeday date;
