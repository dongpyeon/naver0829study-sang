create table gaspard(
num smallint auto_increment primary key, 
gname varchar(30),
photo varchar(70),
gender varchar(15), 
phone varchar(50), 
addr varchar(200), 
registerday datetime
);

select * from gaspard;

delete from gaspard where num=1;

					UPDATE gaspard
					 SET
					 gname="박팔봉",
					 gender="남자",
					 phone="010-5555-5555",
					 addr="부자시 부자구 부자동부자아파트 1층 104",
					 photo="5.png"
					WHERE num =4
