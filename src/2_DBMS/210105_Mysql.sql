

create user user01 identified by 'password';

grant all on *.* to user01;
grant all privileges on *.* to user01;

flush privileges;

revoke all on *.* from user01;


revoke all privileges on *.* from user01;
drop user user01;

show databases;

create database kimdb;

use kimdb;

show tables;

create table emp(
	empno		numeric(4)		primary key,
    ename	 	varchar(20)		not null,
	nickname	varchar(20)		unique,
	sal			numeric(7,2)	check( sal > 0),
	hiredate	datetime		default now(),
    comm		numeric(7,2)	default 0    
);

drop table if exists emp;

create table emp(
	empno		numeric(4),
    ename	 	varchar(20)		not null,
	nickname	varchar(20),
	sal			numeric(7,2),
	hiredate	datetime		default now(),
    comm		numeric(7,2)	default 0,
    primary key (empno),
    unique(nickname),
    check(sal>0)
);

insert into emp (empno, ename, nickname, sal) values(1111,'홍','천사',9000);

select * from emp;

create table major(
	mCode int primary key auto_increment,
    mName varchar(20),
    mOffice varchar(30)
);

drop table student;

create table student(
	sNo int,
    sName varchar(20),
    mCode int,
    primary key(sNo),
    foreign key(mCode) references major(mCode)
);

insert into major (mName, mOffice) values ('컴공','704호');
insert into major (mName, mOffice) values ('경영','702호');
insert into major (mName, mOffice) values ('빅데이터','701호');
insert into major (mName, mOffice) values ('기계','705호');

select * from major;

select * from student;

insert into student values (1111,'홍',1);

insert into student values (1112,'김',2);

insert into student values (1113,'박',2);

insert into student values (1114,'이',5);

select *
from student s right outer join major m
on s.mCode = m.mCode;

-- 자바 (JDBC) 수업시간에 쓸 테이블
drop table if exists personal;

drop table if exists division;

create table division(
	dno	int primary key, -- 부서번호
    dname varchar(20),
    phone varchar(20),
    position varchar(20)
);



create table personal(
	pno int,
	pname varchar(20) not null,
    job	  varchar(20) not null,
    manager int,
    startdate date,	
    pay	int,
    bouns int,
    dno int,
    primary key (pno),
    foreign key (dno) references division(dno)
);

alter table personal change bouns bonus int;

desc division;

delete from division where 1=1;

insert into division values(10,'finance','02-000-0000','신촌');
insert into division values(20,'research','02-000-0001','신촌');
insert into division values(30,'sales','02-000-0002','이대');
insert into division values(40,'marketing','02-000-0003','신촌');

commit;

select * from personal;

insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);

desc personal;

-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay
from personal;

-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select *
from personal
where pay >=2000 && pay <= 5000;

-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select * from personal where dno = 10 || dno =20;

-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay 
  from personal 
 where bouns is null;

-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno, pname, dno, pay, dno
from personal
order by 4 desc;

-- 6. 사번, 이름, 부서명
select pno, pname, dname
from personal p, division d
where p.dno = d.dno;
-- 7. 사번, 이름, 상사이름
select p1.pno, p1.pname, p2.pname
from personal p1, personal p2
where p1.manager = p2.pno;
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)

select p1.pno, p1.pname, if(p2.pname is null,'없당',p2.pname) pname
from personal p1 left outer join personal p2
on p1.manager = p2.pno;

-- 9. 이름이 s로 시작하는 사원 이름
select pname
from personal
where pname like ('s%');

-- 10. 사번, 이름, 급여, 부서명, 상사이름
select p1.pno, p1.pname, p1.pay, dname, p2.pname
from personal p1 left outer join personal p2 
on p1.manager = p2.pno
inner join division d
on p1.dno = d.dno;

-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay), max(pay)
from personal
group by dno;

-- 12. 부서명, 급여평균, 인원수
select dname, avg(pay), count(*)
from personal p, division d
where p.dno = d.dno
group by dname;

-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select dno, sum(pay), count(*)
from personal p
group by dno
having count(*) >= 4;

-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select dno, pname, pay
from personal
where pay = (select max(pay) from personal);

-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname, pay, dno
from personal p
where pay > (select avg(pay) from personal);

-- 16. 14번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
select dno, pname, pay, (select dname from division where dno=p.dno) 
from personal p
where pay = (select max(pay) from personal)
order by 4, pay desc;

-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균
select pname, pay, dno, round(avg(pay))
from personal p
where pay > (select avg(pay) from personal where dno = p.dno)
group by pname, pay, dno;

-- select dno, avg(pay) from personal group by dno

-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
select pname, pay , dname
from personal p , division d
where p.dno = d.dno
  && startdate = (select min(startdate) from personal);
   
  desc personal;

-- 19. 이름, 급여, 해당부서평균
select pname, pay, (select avg(pay) from personal where dno = p.dno) davg
from personal p;

-- 20. 이름, 급여, 부서명, 해당부서평균
select pname, pay, (select dname from division where dno = p.dno) dnames,
		(select round(avg(pay)) from personal where dno = p.dno) davg
from personal p;
-- oracle 에서의 단일 행수와 my sql 컬럼함수의  다른 부분
select concat(pname, pay) from personal;

select year(startdate) from personal;

select dayname(startdate) from personal;

-- date_format
-- %y 21년도 2자리 %Y 2021 4자리 년도
-- %M 월이름(January, ....) %m (01월, ...)
-- %b 짧은 월이름(Jan.. ) %c(1,2,..)
-- %e 일(1,2,...)    %d(01,02,03,04)
-- %H 24시간 %h 12시간 %p(오전 , 오후)

select date_format(now(), '%y년%c월%d일 %p %h %i분') as ex;

select date_format(now(), '%Y%m%d %H%i%s') as ex;

select pname , date_format(startdate, '%Y년 %c월 %e일') from personal;

select now(), sysdate() ;

select format(pay,) from personal;

select pname, pay, if(pay>=3000,'3000천이상','미만')
from personal;

    
-- topn구문 다른점
select pname, pay 
from personal 
order by pay limit 5;

-- union all
select pname, pay 
from personal 
order by pay limit 2,4;

select pname, pay from personal order by pay desc limit 0,3;

select pname, pay from personal order by pay desc limit 3;

select pno, pname, rpad(job,10,' '), manager, startdate, pay, bonus, dno from personal;

