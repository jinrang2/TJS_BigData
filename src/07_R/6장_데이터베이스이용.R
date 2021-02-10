######################################
# 6장 데이터 베이스 이용
######################################

# SQL문으로 데이터 프레임과 DB 테이블 이용
rm(list=ls(all.names=T))


install.packages("sqldf")
# sqldf()함수를 통해 데이터 프레임을 DB의 테이블처럼 사용가능
library(sqldf)

#중복행 제거하여 한번만 출력(iris의 종을 출력)
sqldf("select distinct Species from iris")

names(table(iris$Species))

levels(iris$Species)

library(dplyr)

iris

iris %>% 
  group_by(Species) %>% 
  summarise()

# 행 제한 조건 설정 
sqldf("select * from iris where Species=='virginica'")

sqldf("select * from iris where species='virginica'")

iris[iris$Species=='virginica',]

iris %>% 
  filter(Species=='virginica')


# 컬럼에 .이 내포한 경우:
# virginica종이면서 Sepal.Length가 7.5 초과하는 데이터 출력
sqldf("select * from iris where Species=='virginica' and Sepal.Length>7.5")

sqldf("select * from iris where Species=='virginica' and `Sepal.Length`>7.5")

iris[iris$Species=='virginica' & iris$Sepal.Length>7.5,]

iris %>% 
   filter(Species=='virginica' & Sepal.Length>7.5)

#종별 sepal.Length의 합을 출력
sqldf("select Species, sum(`Sepal.Length`) from iris group by Species")

tapply(iris$Sepal.Length, iris$Species, sum)
by(iris$Sepal.Length, iris$Species, sum)
library(doBy)
summaryBy(Sepal.Length~Species,iris,FUN=sum)
aggregate(iris$Sepal.Length, by=list(iris$Species), sum)

iris %>% 
  group_by(Species) %>% 
  summarise(sum_Sepal.Length = sum(Sepal.Length))

#정렬 (Sepal.length가 1~5등 , 6~10등)
sqldf("select *  from iris order by `Sepal.Length` limit 5") # 1~5등

sqldf("select *  from iris order by `Sepal.Length` limit 5 5") # 5등~10등

#sql함수(mysql함수) 사용: Petal.Length의 평균과 표준편차
sqldf("select avg(`Petal.Length`) , avg(`Petal.Width`),  stdev(`Petal.Length`), stdev(`Petal.Width`) from iris ")
apply(iris[,c(3:4)],2,mean)
apply(iris[,c(3:4)],2,sd)

#sql함수(mysql함수) 사용: 종에 따른 Petal.Length, Petal.Width의 평균과 표준편차
sqldf("select Species, avg(`Petal.Length`) , avg(`Petal.Width`),  stdev(`Petal.Length`), stdev(`Petal.Width`) from iris group by Species")

summaryBy(Petal.Length +  Petal.Width ~ Species, iris, FUN=c(mean,sd))

sqldf("select round(avg(`Petal.Length`),2) from iris")

#조인
getwd()

emp <- read.csv('inData/emp.csv',header=T)
emp
dept <- read.csv('inData/dept.csv',header=T)

dept

# 사번 , 이름 ,직책, 월급, 부서번호, 부서이름
sqldf("select empno, ename, job, sal, e.deptno , dname from emp e join dept d on e.deptno = d.deptno")

# 2. 오라클 데이터 베이스 연결

#String driver = "oracle.jdbc.driver.OracleDriver";
#String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
#Connection conn = null ;

# 연결 전 작업
#전작업 : 자바설치, java_home 설정, 작업디렉토리에 odbc6.jar
install.packages("RJDBC")
library("RJDBC")
# 드라이버 클래스 로드

drv <- JDBC("oracle.jdbc.driver.OracleDriver",classPath='ojdbc6.jar')
drv

con <- dbConnect(drv, 'jdbc:oracle:thin:@127.0.0.1:1521:xe','scott','tiger')
con

emp <- dbGetQuery(con,"select * from emp")

emp
class(emp)
summary(emp)
tail(emp)
emp[1:2,'EMPNO']

#테이블 전체 데이터 조회
dept <- dbReadTable(con,"dept")
dept


#sql전송(update, insert, delete - DB데이터수정)
dbSendUpdate(con, "insert into dept values (50,'it','seoul')")

dbSendUpdate(con, "UPDATE SCOTT.DEPT SET LOC='INCHEON' WHERE DEPTNO=50")

dbDisconnect(Con)

# 드라이버 언로드:
dbDisconnect(con)

dbUnloadDriver(drv)

detach("package:RJDBC", unload=TRUE)

# 3. mysql 데이터 베이스 연결결
#alter user 'root'@'localhost' identified with mysql_native_password by 'mysql'

#String driver = "oracle.jdbc.driver.OracleDriver";
#String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
#Connection conn = null ;

# 연결 전 작업
#전작업 : 자바설치, java_home 설정, 작업디렉토리에 odbc6.jar
install.packages("RMySQL")
library("RMySQL")

drv <- dbDriver("MySQL")

con <- dbConnect(drv,host="127.0.0.1", dbname="kimdb", user="root",password="mysql")

rs <- dbSendQuery(con,"select * from personal")

personal <- fetch(rs,n=-1)

personal
class(personal)

dbDisconnect(con)

dbUnloadDriver(drv)
