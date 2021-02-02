#############################################
# 3장. R데이터 종류 및 구조
#############################################

# 1. 데이터 종류 : 기본데이터 타입(문자,숫자, logical)=스칼라타입
# 팩터, 벡터, 리스트, 행렬, 배열, 데이터 프레임, 날짜, 특별한값(결측치...)

# 2. 기본 데이터 타입: character, numeric, logical
a <- "Hello"
b <- "Hello\nHello"

cat(a)
cat(b)
cat('a 값은',a)


class(a)
b <- 10.1
b <- 10
strB <- as.character(b)
class(b)
c<-TRUE;
strB


class(strB)
c
methods(is)
is.logical(c)


#3. 특별한 값(Null, NA;결측치, NaN, inf)
result <- 0

add <- function(a,)b {
  result <<- a*5+b
  return (result)
}

(temp<- add(1,2))

(temp<- add(a=1,b=2))

(temp<- add(b=10,a=5))



d <- c(2,4,NA,6,NaN,10/0)


print(d)



is.na(d[3])

is.na(d)

na.omit(d)

?is.na

mean(d)

?mean

mean(d, na.rm=TRUE)


d <- c(2,3,4,5,NA,12)

mean(d, na.rm=TRUE)


# 4. 팩터(Factor) : 범주형데이터, 명명식, 순서식
gender1 <- c('남','남','여')

gender1[3]

class(gender1)

gender1[4] <- '중성'

gender <- factor(c('남','남','여'),levels=c('남','여'))

                 
gender[3]


gender                 


str(gender)

level <- factor(c('좋음','보통','보통'),levels=c('싫음','보통','좋음'), ordered=T)
level2 <- ordered(c('좋음','보통','보통'),levels=c('싫음','보통','좋음'))

level

level2

level2[4] <- '몰라'

nlevels(level)    # level 변수의 범주 갯수

nlevels(gender)

gender1 <- as.factor(gender1)

gender1



# 5. 구조형 변수와 복합형 변수; 변수 하나에 여러 값을 가져야함
#(1)구조형변수: 동일 자료형 ex) 벡터, 행렬(회귀식 용이), 배열
#(2)복합형변수: 서로 다른 자료형을 가질 수 있음
#               ex. 리스트, 데이터프레임 csv

#6. 벡터 : 동일 자료형의 집합 문자 , 숫자, 로지컬 순으로 변환한다
data <- c(11,22,33,'TEST') # 숫자, 문자 ->문자
print(data)
data <- c(11,22,33, TRUE) #숫자, logical ->숫자 (트루1 펄스0)
print(data)
data <- c('TRUE', TRUE) #문자, logical ->문자 (트루1 펄스0)
print(data)

data <- c(1,2,3)   # 1 index부터 시작
print(data)
data[4] <- 40
print(data)

# 행과 열 정보 조회
NROW(data)
length(data)

data <- c(1:4)
data

names(data) <- c('A열','B열','C열','D열')
data

data[1]   #첫번쨰 값 반환

#특정한 값 조회
data['A열']
data[c(1,2)] # 첫번째 ,두번째 값 변환환
data[c(1,3)] # 첫번째, 세번째 값 변환환
data[c(1:2)] # 1~2번쨰 값 반환환
data[c('A열','B열')] # 1~2번쨰 값 반환환
data[-2]
data[c(-1,-3)] # 첫번째, 세번째 값 변환환

data[data>2]

data[c(TRUE,FALSE,FALSE,TRUE)]

2 %in% data 


#q1. 시험점수 변수들 만들고 출력하고 전체 평균을 구한 후 출력
#80,60,70,50,90,미응시

names(data) <- c('yi','kim','yun','lim','lee','park')

data <- c(80,60,70,50,90,NA)

print(data)
cat(data)
mean(data,na.rm=TRUE)

help(mean)

data[data>=60]

class(data)

is.vector(data)

# 6.1 character()
charArr <- character()
is.vector(charArr)
length(charArr)
charArr <- character(5)
length(charArr)
charArr
is.vector(charArr)
charArr[1] <- '안녕'; charArr[2]='R'; charArr[3]='수업중'
charArr[7] <- '테스트'
charArr

# 6.2 numeric()
intArr <- numeric()
class(intArr)
is.vector(intArr)
intArr[1] <- 1
intArr[3] <- 3
intArr
# 6.3 logical()
logicArr <- logical(2)
logicArr[1] <- TRUE
logicArr[2] <- FALSE
logicArr[3] <- T
logicArr[5] <- T
logicArr

# 6.4 seq()

ls()

a = seq(1,10,2)
a <- 1:10
is.vector(a)
seq(10,-10,-2)
seq(0.1,0.1)
seq(1,9,by=pi)

#6.5 rep() : 반복객체를 만드는 함수수
rep(1:4,each=2)       # 1 1 2 2 3 3 4 4 
rep(1:4,c(1,2,3,4))   # 1 22 333 4444
rep(1:4,each=2, len=6) # 11 22 33
rep(1:4,each=2, len=10) # 11 22 33 44 11
rep(1:4,each=2, times=3) # 11 22 33 44 를 3번 반복

#6.6 벡터의 연산 (+,-,*,/ 결합,교집합, 합집합, 차집합, 비교연산)
a <- c(1,2,3)
b <- c(10,20,30)

a+b
a-b
a^b
a*b
a%%b  # 나머지 연산자

c(a,b)

a<-c(1,2,3)
b<-c('Hell','R')
c<-c(TRUE, FALSE)
(z<-c(a,b,c))     #벡터 결합시 타입이 바뀜 
z
a<- append(a, c(4,5,6))
a<- append(a, 7)
a[8] <- 8


#벡터의 집합 연산: 합집합, 교집한, 차집합, 비교교
a<-c(1,2,3,4,5,6)
b<-c(2,4,6,8,10,12)

union(a,b)      #합집합1,2,3,4,5,6,8,10,12
intersect(a,b)  #교집합2 4 6
setdiff(a,b)    #차집함1 3 5 
setequal(a,b)

setequal(a,c(intersect(a,b),setdiff(a,b)))

# 7. 리스트
student <- list(name='홍길동', age=25)

student$name

studentVector <- unlist(student)
studentVector

s<- c('홍길동',25)
names(s) <- c('name','age')

student <- list(s)
student

student <- as.list(s) #리스트 형으로 형변환환

student['name']
student$name
student[1]   # $name [1] 홍길동동
student[[1]]

student$age <- NULL

student

NROW(student)
length(student)



# 8. 행렬
colMatrix <- matrix(1:15, nrow=5, ncol=3) # 디폴트 열 행렬
colMatrix

colMatrix2 <- matrix(1:15, nrow=5, ncol=3, byrow=FALSE) # 열행렬 직접지정
colMatrix2

rowMatrix <- matrix(1:15, nrow=5, ncol=3, byrow=TRUE,
                    dimnames = list(c("R1","R2","R3","R4","R5"),c('C1','C2','C3'))) #행 행렬로 지정


rowMatrix
dim(rowMatrix)  #행과 열의 수
nrow(rowMatrix) #행 수
NROW(rowMatrix)
ncol(rowMatrix) # 열 수
NCOL(rowMatrix)

rowMatrix

dim(rowMatrix) <- c(5,3)  ## 바꿨는데 규칙이 뭔지 

dimnames(rowMatrix)
rownames(rowMatrix) #행이름
colnames(rowMatrix) #열이름

#행이름과 열이름 수정
dimnames(rowMatrix) <- list(c('1월','2월','3월','4월','5월'),c('kim','lee','choi'))


dimnames(rowMatrix)

rowMatrix


#행렬의 곱을 이용하여 선형회귀식 도출(단별량)

x <- c(2,4)

y <- c(40,60)

X <- matrix(c(x,rep(1,NROW(x))),nrow=2,ncol=2,byrow=FALSE)

X

Y = matrix(y, ncol=1)
            
T

# x%*%ab=Y
# solve(X) %*% X %*% ab = solve(X) %*% Y (solve(X) %*% X 소거)
# ab = solve(X) %*% Y
ab <- solve(X) %*% y

ab
ab[1]  # x의 기울기
ab[2]  # 절편
?plot
plot(x, y)
lines(x, x*ab[1]+ab[2])


x <- c(32,64,96,118,126,144,152.5,158)
y <- c(18,24,61.5,49,52,105,130.3,125)
plot(x,y,col=2,pch=19,ylim=c(0,150))

X <- matrix(c(x,rep(1,NROW(x))), ncol=2)
X
Y <- matrix (y,ncol=1)
Y

ab <- solve(t(X)%*%X) %*% t(X) %*% Y
ab

lines(x,x*ab[1]+ab[2])

#1feet = 30.48cm
#다변량 회귀분석
x1 <- c(60, 65, 55)
x2 <- c(5.5, 5.0, 6.0)
x3 <- c(1,0,1)
y <- c(66,74,78)


X <- matrix(c(x1,x2,x3),ncol=3)
X
Y <- matrix(y, ncol=1)
Y

# X %*% ab = Y
# solve(X) %*% x %*% ab =solve(x) %*% Y
# ab = solve(X) %*% Y
ab = solve(X) %*% Y
ab

#80kg, 6.5ft , 금연수명
80*ab[1] + 6.5*ab[2] + 0*ab[3]

plot(x, y)



#행렬 연산 (+,* - / %%, ... , %*%)

a<-matrix(1:4,nrow=2,ncol=2)
a
b<-matrix(seq(10,40,10),nrow=2,ncol=2)
b

a+b
a*b
a^b
a%%b 

## 행렬 연산중 행렬 곱(%*%)
payMatrix <- matrix(c(12000,26000,18000),ncol=3)
payMatrix
dimnames(payMatrix) <- list(c('시간당수당'),c('철수','영희','말자'))
workerMatrix <- matrix(c(c(5,4,9),c(7,3,2)),ncol=2)
workerMatrix
dimnames(workerMatrix) <- list(c('철수','영희','말자'),c('1월','2월'))
workerMatrix

cost <- payMatrix %*% workerMatrix #1x3 %*% 3x2 => 1x2
cost
rownames(cost)<-c('인건비')
cost


#9.배열
dataArray <- array(1:24, dim=c(3,4,2))
dataArray

dim(dataArray)    # 차원의 크기 조회
nrow(dataArray)   # 행 수 조회
NROW(dataArray)
ncol(dataArray)   # 열수 조회
NCOL(dataArray)
length(dataArray)  # 요소의 갯수
dimnames(dataArray) <- list(c('1행','2행','3행'),c('1열','2열','3열','4열'),c('x면','y면'))

dataArray
dim(dataArray) <- c(3,8)
dataArray
dim(dataArray) <- c(8,3)
dataArray



# 10. 데이터 프레임
#(1) 데이터 프레임 생성
student_id <- c('20211','20212','20213','20214')
student_name <- c('Jin','Eric','Den','Kei')
student_eng <- c(60,85,90,95)
student_kor <- c(100,95,95,80)
student_gender <- c('남','여','남','여')

student_data <- data.frame(student_id, student_name,student_eng,student_kor, student_gender)

student_data
# 데이터 프레임에 열 추가 및 삭제
student_data$mat <- c(100,100,99,98)
class(student_data)
student_data$student_id <- NULL
#열의 형변환
student_data$student_gender <- as.factor(student_data$student_gender)
class(student_data$student_gender)
str(student_data)
summary(student_data)
# (4)열이름 변경
student_data

install.packages("rename")

require("reshape")

student

student <- rename(student_data, c("student_name"="name"))

student <- rename(student_data, c("student_eng"="eng"))

#student <- rename(student_data, c("student_kor"="kor"))

#student <- rename(student_data, c("student_gender"="gender"))

names(student_data) <- c("name","eng","kor","gender","mat")
student_data

# (5)데이터 프레임 합치기 
# 행으로 합치기 
newStudent <- rbind(student_data, student)
newStudent

student
id = data.frame(student_id)
id
student <- cbind(id,student)
student
names(student) <- c("id","name","eng","kor","gender","mat")
student



#부분 데이터 조회
student <- NULL
student <- rbind(student, newStudent)
nrow(student)
student[1,1] # 1행 1열
student[1,'id'] #1행 'id'열
student[1,]  #1행 데이터
student[,1]  #1열 데이터
student[c(1:3)] #1행부터 3행 데이터 
student[, c(2,3,4,6)] #2,3,4,5열 데이터터
student[c(-2,-4,-6),] #2,4,6행 외의 모든 데이터터
student[,c(-1,-5)] #1열과 5열외 모든 데이터
student[c(1:3), c(-1,-5)] #1행부터 3행까지 1열과 5열 제외한 데이터터
#국어 점수가 90점 이상인 데이터
subset(student, subset=(student$kor==100))
subset(student, student$mat>99)
subset(student, select=c(1,4))  #1열과 4열 데이터 
subset(student, select=c(-1,-4)) #1열과 4열 외의 데이터터
subset(student, select=c('name','kor','mat')) #name, kor, mat열만

# 수학 점수가 99점 이상인 여학생만
subset(student, subset=(student$mat>=99 % student$gender='여'))

#처음 5행만
student[c(1:5),]
head(student)
#처음 3행만
head(student,3)

edit(student)


emp <- read.csv(file.choose())
emp

edit(emp)
head(emp)
class(emp)

#1. 직원 이름만 출력
subset(emp, select=c('ename'))
emp[,'ename']
emp[,2,drop=FALSE] #데이터 프레임 형태로 반환

#2. 직원이름, job, sal
emp[c('ename','job','sal')]
subset(emp, select=c('ename','job','sal'))
subset(emp[c('ename','job','sal')], )

#3. 이름이 KING인 직원의 empno, job, hiredate, sal
subset(emp[c('empno','job','hiredate','sal')], emp$ename=='KING')
subset(emp[c('empno','job','hiredate','sal')], subset=(emp$ename=='KING'))

#4. sal이 2000이상 직원의 empno, ename, sal
subset(emp[c('empno','ename','sal')], emp$sal>=2000)

#5. sal이 2000부터 3000사이인 직원의 ename, sal
subset(emp[c('ename','sal')], subset=(emp$sal>=2000 & emp$sal<=3000))


# 11.타입 판별 및 타입 변환

tail(emp,6)

tail(emp,14)
class(emp)  #emp의 타입
str(emp)
emp$deptno <- as.factor(emp$deptno)
str(emp)

class(iris)
iris
str(iris)
iris$Species <-as.character((iris$Species))
str(iris)
iris$Species <-as.factor((iris$Species))
str(iris)
levels(iris$Species)

#타입판별
class(iris$Species)
is.factor(iris$Species)


#12. 문자열과 날짜
name <- "Eric"

length(name) #요소 갯수
nchar(name)

names <- c("Eric","Larray","Curly")
length(names) #요소 갯수
nchar(names)

#하위 문자열 추출하기 : substr
?substr


substr('ABCDEF',1,4)   #1-4번쨰 문자 추출
substr('ABCDEF',4,10)  #4~10번쨰 문자추출, 없는 번쨰 문자는 ""(빈문자)로 처리
substr(names,1,2)     #names 안에 각각의 문자 1~2번째 추출출


# names안에 각각의 이름의 맨 마지막 자리 앞글자, 맨 마지막글자
# 결과 :"ic","ay","ly"
substr(names, nchar(names)-1, nchar(names))

#문자열 연결하기 :paste, paste0
names <- c("Eric","Larray","Curly")
paste(names,'loves', 'starts')
paste(names,'loves', 'starts', sep='_')
paste(names,'loves', 'starts', sep='_', collapse = ', and ')
paste0(names,'loves', 'starts')


# 문.
names <- c("Yun","Lim","Lee"); hobby<-c("swim","sleep",'eat')
# 결과 yun의 취미는 swim이고, lim의 취미는 sleep이고, Lee의 취미는 eat
cat(paste(name,hobby, sep = '의 취미는 ', collapse='이고, '))

#문자열 분할(구분자 분할하기)
path <- 'home/hadoop/data/speech.csv'
strsplit(path,'/')    
customerInfo <- 'jin@gmail.com,010-9999-8888,seoul Korea'
strsplit(customerInfo,',')    
customersInfo <- c('jin@gmail.com,010-9999-8888,seoul Korea',
                   'yun@naver.com,02-716-1006,pusan korea',
                   'yun@naver.com,011-716-1006,pusan korea')
