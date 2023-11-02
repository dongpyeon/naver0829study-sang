create table gaspardboard(
num smallint auto_increment primary key, 
writer varchar(30),
subject varchar(1000),
content varchar(1000), 
photo varchar(30), 
readcount smallint default 0,
writeday timestamp
);

select * from gaspardboard;

create table gaspardreply (
	idx smallint auto_increment primary key,
    num smallint,
    nickname varchar(20),
    content varchar(1000),
    writeday datetime,
    constraint reply_fk_num foreign key(num) references gaspardboard(num) on delete cascade
);