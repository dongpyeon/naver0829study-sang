create table simpleboard (
num smallint auto_increment primary key,
writer varchar(20),
subject varchar(1000),
content varchar(1000),
photo varchar(30),
readcount smallint default 0,
writeday datetime
);

select * from simpleboard;

-- 댓글 db
create table answersboard (
	idx smallint auto_increment primary key,
    num smallint,
    nickname varchar(20),
    content varchar(1000),
    writeday datetime,
    constraint answer_fk_num foreign key(num) references simpleboard(num) on delete cascade
);

select * from answersboard;


				INSERT INTO answersboard 
				 VALUES(null, 
				 		"2",
				 		"혼자야",
				 		"아니솔로인데",
				 		now());