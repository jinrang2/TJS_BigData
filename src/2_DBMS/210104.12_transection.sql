commit;


select * from dept01;

drop table dept01;

create table dept01 as select * from dept;


DELETE FROM DEPT01 WHERE DEPTNO=50;

SELECT * FROM DEPT01;
-- 4Q번 부서 삭제

DELETE FROM DEPT01 WHERE DEPTNO=40;

SELECT * FROM DEPT01;

COMMIT;

DELETE FROM DEPT01 WHERE DEPTNO=30;

SAVEPOINT C1;

DELETE FROM DEPT01 WHERE DEPTNO=20;

SAVEPOINT C2;

DELETE FROM DEPT01 WHERE DEPTNO=10;

SAVEPOINT C3;

ROLLBACK C3;

SELECT * FROM DEPT01;

