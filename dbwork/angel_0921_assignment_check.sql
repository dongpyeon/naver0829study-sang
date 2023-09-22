--����
--���̺� ���� (student) : num ����(5),name ���ڿ�(10),height ����(5,1),
--  java ����(3) �⺻�� 10,spring ����(3) �⺻�� 10, ban ���ڿ�(20)

create table student(
    num number(5),
    name varchar2(10),
    height number(5,1),
    java number(3) default 10,
    spring number(3) default 10,
    ban varchar2(20));




--������ ����  seq_stu  �⺻(1���� 1������), nocache �߰�
create sequence seq_stu start with 1 increment by 1 nocache;

--�������ǵ� �߰�
--num  �� primary key �߰�(student_pk_nu)
alter table student add constraint student_pk_num primary key(num);

--java,spring �� 1~100 �� �����ϵ��� check �������� �߰�
alter table student add constraint student_ck_java check(java>=1 and java<=100);
alter table student add constraint student_ck_spring check(spring>=1 and spring<=100);


--ban �� '�޴Թ�','�޴Թ�','���Թ�' �� �߰��Ҽ� �ֵ��� check �߰�
alter table student add constraint student_ck_ban check(ban in('�޴Թ�','�޴Թ�','���Թ�'));

--5�� ������ ����Ÿ�� �߰��غ���
insert into student values (seq_stu.nextval,'��ȣ��',178,60,80,'�޴Թ�');
insert into student (num, name, height, java, ban)values (seq_stu.nextval,'���缮',173,80,'���Թ�');
insert into student (num,name, height, spring, ban) values (seq_stu.nextval,'������',162,80,'�޴Թ�');
insert into student values (seq_stu.nextval,'Ȳ����',178,50,90,'�޴Թ�');
insert into student values (seq_stu.nextval,'����ȣ',175,70,60,'���Թ�');


--Ŀ���ϱ�
commit;



--num>=4 �̻� ��� ����
delete from student where num>=4;



-- num �� 3�� ����� java������ 99�� ,ban�� '�޴Թ�' ���� ����
update student set java=99, ban='�޴Թ�' where num=3; 



--num=2 �λ���� Ű�� 188.9 �� ����
update student set height=188.9 where num=2; 



--num=2 �� ����Ÿ ����
delete from student where num =2;

--����Ÿ 3������ �� �߰�
insert into student (num, name, height, java, ban)values (seq_stu.nextval,'������',171,80,'�޴Թ�');
insert into student (num, name, height, spring, ban)values (seq_stu.nextval,'������',165,80,'���Թ�');
insert into student (num, name, height, java, spring, ban)values (seq_stu.nextval,'������',170,87,80,'�޴Թ�');

--��ȸ : �̸�  �� �ڹ�  ������  ����  ��� -������ ���� ������� ���
SELECT
    name �̸�,
    ban ��,
    java �ڹ�,
    spring ������,
    (java + spring) ����,
    (java + spring) / 2  ���
FROM
    student
ORDER BY
    ���� DESC;
    
drop table student;
drop sequence seq_stu;

alter table student modify column num number(5);