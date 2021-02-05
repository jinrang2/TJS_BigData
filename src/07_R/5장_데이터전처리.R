################################
# 5장. 데이터 전처리
################################

# 1. 파일 입추력

# 1.1 시스템 인코딩 조회
Sys.getlocale()

# 1.2 write, table ; 데이터를 파일에 저장장

iris
class(iris)


#getwd()
#setwd('E:/gon/TJS_BigData/src/07_R')
#getwd()

write.table(iris, file="outData/iris.csv", sep="," , row.names=FALSE)


InsectSprays

levels(InsectSprays)

write.table(InsectSprays, file="outData/InsectSprays.csv", sep="," , row.names=FALSE)

#1.3 read.table ; 파일을 읽어 데이터 프레임 형태로 저장장
irisData <- read.table('outData/iris.csv', sep=',', header=TRUE, encoding='utf-8')

head(irisData)
tail(irisData)
str(irisData)

irisData$Species <- as.factor(irisData$Species)
irisData$Species <- factor(irisData$Species, levels = c("setosa","versicolor","virginica")
                
                           
irisData$Species           
                           


levels(irisData$Species)

nrow(iris)
summary(iris)


iris
# 1.4 write.csv
write.csv(iris, file = 'outData/iris1.csv', sep =',')

?write.csv

# 1.5 read.csv
newData <- read.csv('outData/iris1.csv',header=TRUE, stringsAsFactors =T)
str(newData)
head(newData)
summary(newData)


# 1.6 cat ; 분석 결과 등을 저장 할떄
irisSummary <- summary(newData)
irisSummary[1,]

?cat

cat('iris 요약 : ', '\n', file='outData/irisSummary.txt', Encoding('utf-8'))
for(idx in 1:nrow(irisSummary)){
  cat(irisSummary[idx,],'\n', file='outData/irisSummary.txt', append=T)  
}



cat('iris요약:','\n', irisSummary, file='outData/irisSummary.txt', append= TRUE, Encoding=utf-8);


# 2. apply 계열 함수 적용

# 2.1 apply :
# iris 데이터의 (열별,행별) (평균,합계,중앙값,표준편차,최소값,최대값)
# apply (데이터 , 1또는2, 함수) 1응 행별 함수 수행, 2은 열별 함수 수행
iris2 <- iris[,1:4]

head(iris2)

apply(iris[,1:4], 1, mean)

apply(iris2, 2, mean)

levels(iris$Species)

apply(subset(iris, iris$Species=='setosa', select= -5),2,mean)
apply(subset(iris, iris$Species=='versicolor', select= -5),2,mean)
apply(subset(iris, iris$Species=='virginica', select= -5),2,mean)


apply(iris[,-5],2,FUN=mean)        #열별 평균
apply(iris[,-5],2,FUN=sd)          #열별 표준편차
apply(iris[,-5],2,FUN=sum)         #열별 합계
apply(iris[,-5],2,FUN=median)      #열별 중앙값
apply(iris[,-5],2,FUN=min)         #열별 최소값
apply(iris[,-5],2,FUN=max)         #열별 최대값


name <- c('김','홍','박','이','윤')
kor <- c(90,50,70,60,100)
eng <- c(100,40,50,60,70)
mat <- c(90,91,50,64,80)


student <- data.frame(name, kor, eng, mat)
student

#학생별 평균, 과목별 평균
apply(student[,-1],1,FUN=mean)
apply(student[,-1],2,FUN=mean)


exp(-3,3)

# 2.2 lapply : list apply (결과도 list)
x <- list(a=1:10, beta=exp(-3,3),logic=c(T,F,F,T))

# e의 -3승부터 e의 3승까지 출력되는 지수함수
x <- list(a=1:10, beta=exp(-3:3), logic=c(T,F,F,T))

lapply(x, mean)
lapply(x, quantile)
lapply(x, quantile, 1:3/4)

# 2.3 sapply : lapply와 유사하나 결과가 행렬이나 벡터로 변환
sapply(x, mean)
sapply(x, quanttile)
sapply(x, quantile, 1:3/4)

fivenum(0:100)

i39 <- sapply(c(3:9), seq)

i39

sapply(i39, fivenum)
lapply(i39, fivenum)


# 문 iris데이터를 lapply와 sapply를 이용하여 sepal.length ~ petal.width의 평균을 구하여라

irisList <- as.list(iris[,1:4])
irisList

lapply(irisList, mean)
sapply(irisList, mean)

# 2.4 vapply:sapply : FUN의 모든 값이 특별 Value타입과 호환되는지 확인
vapply(irisList,mean, numeric(1))

vapply(i39, fivenum, FUN.VALUE=c(numeric(1), numeric(1), numeric(1), numeric(1), numeric(1)))



citis <- c('Seoul','Busan','New York','Tokyo')
nchar(citis[1])
sapply(citis, nchar)
lapply(citis, nchar)
vapply(citis, nchar, FUN.VALUE = numeric(1))



# 2.5 mapply : apply 같으나 여러개의 인자를 함수에 전달
rep(c(1,2,3),3)
x <- c(1,2,3,4)
mean(x)

mapply(rep, x=1:4, times=4:1)

job <- c(3,3,5,2,2,3,5,3,4,4,6,3)
income <-c(4879,6509,4183,0,3894,0,3611,6454,4975,8780,0,4362)
cust <- data.frame(job, income)
cust
income.avg <- c(900,0,3500,3600,3700,3800,3900,4000)
income.avg
names(income.avg) <- 0:7
income.avg

zero2mean <- function(job, income) {
  #return (ifelse(incomm==0, income.avg[as.character(job)],income))
  if(income==0) {
    return (income.avg[as.character(job)])
  } else {
    return (income)
  }
}

str(income)

#for문으로 zero2mean (cust[1, 'job'], cust[1, 'income'])을 하지 않고
cust$income2 <- mapply(zero2mean, cust$job, cust$income)

cust

# 3. 데이터 그룹화 함수 적용
# 3.1 tapply : 그룹화 처리를 위한 apply
tapply(iris$Sepal.Length, iris$Species, mean);
tapply(iris$Sepal.Length, iris$Species, sd);


irisData$Species <- as.factor(irisData$Species)

cust$job <- as.factor(cust$job, levels = 0:7)
cust$job <- factor(cust$job, levels = 0:7)

levels(cust$job)


tapply(cust$income2, cust$job, mean)
tapply(cust$income2, cust$job, FUN=mean)
tapply(cust$income2, cust$job, FUN=mean, default=-1)

datasets::InsectSprays


head(InsectSprays)
str(InsectSprays)



tapply(InsectSprays$count, InsectSprays$spray, FUN=sum, default=-1)
tapply(InsectSprays$count, InsectSprays$spray, FUN=mean, default=-1) 

boxplot(InsectSprays$count ~  InsectSprays$spray)


# 3.2 by ; 그룹화 처리를 위한 apply (함수를 2개 이상 가능)
# tapply 단점
#tapply(InsectSprays$count, InsectSprays$spray, FUN=c(mean,sd), default=-1) 함수를 2개 이상 적용이 안됨
#tapply(iris[,1:2], iris[,5],mean)   여러열의 계산이 안됨

by(head(iris[,1:2]), head(iris[,5]), sum)
by(iris[,1:2], iris[,5], summary)
by(iris[,1:5], iris[,5], summary)

by(iris[,1:5],  summary)

by(cust[,c('income','income2')], cust[,'job'],summary)

head(iris[,1:2])

head(iris[,5])


#3.3 do by패키지
install.packages("doBy")
library("doBy")

summaryBy(Sepal.Length + Sepal.Width ~ Species, iris)
summaryBy(Sepal.Length + Sepal.Width+Petal.Length+Petal.Width ~ Species, iris, FUN=sd)

summaryBy(Sepal.Length + Sepal.Width+Petal.Length+Petal.Width ~ Species, iris, FUN=c(mean,sd))


# 문 emp csv 파일의 데이터를 받아 부서별 급여, 상여금을 비교하시오
emps <- read.csv('inData/emp.csv',header=TRUE, stringsAsFactors =F)
emps

zero2meanemp <- function(deptno, comm) {
  if(comm==0) {
    return (comm.avg[as.character(deptno)])
  } else {
    return (comm)
  }
}

zero2meanemp(30,0)

emps$comm2 <- mapply(zero2meanemp, emps$deptno, emps$comm)


summaryBy(sal + comm ~ deptno, emps, na.rm=T, fun=c(mean, sd))

# (2) orderBy: 정렬

# 오름차순 정렬
orderBy(~Sepal.Length, data=iris)

# 오름차순 정렬
orderBy(~-Sepal.Length, data=iris)

orderBy(~Species-Sepal.Length, data=iris)

orderBy(~Species+Sepal.Length, data=iris)[,c(1,2,5)]
orderBy(~Species+Sepal.Length, data=iris)[,c(-3,-4)]




# 문1. emp 데이터 셋에서 월급이 적은 순으로 ename, sal을 추출
orderBy(~sal, data=emps)[,c(2,6)]
# 문2. 월급이 적은 순 5명만 ename, sal 
head(orderBy(~sal, data=emps)[,c(2,6)],5)


# (3) sampleBy
sampleBy(~Species, data=iris, frac=0.2)
sampleBy(~Species, data=iris, frac=0.1, replace=T) #복원 추출
sampleBy(~Species, data=iris, frac=0.1, systematic=T) #비복원 추출

# 벡터 샘플링
idx <- sample(1:150,10)
idx
iris[idx,]


# 4.Formula
## lm() 선형회귀식 도출 함수(독립변수, 종속변수)
x <- c(1,2,3,4,5)  #공부량(독립변수)
y <- c(20,41,59,81,99)  #점수(종속변수) ; lm()함수 이용
y1 <- c('F','F','F','P','P') #당락여부(종속변수) - 로지스틱회귀;glm()

fit  <- lm(y ~ x)
fit

warnings()

plot(x,y, col='blue')

lines(x,x*19.8+0.6, col='red')

abline(fit,lty='dashed')

#독립변수가 2개인 경우

x1 <- c(1,2,3,4,5)   #공부시간

x2 <- c(10,20,3,4,5) #r기출문제 푼 갯수

y <-  c(50,70,63,84,95)  #종속변수

fit <- lm(y~ x1+x2)

fit


#cars
cars



fit <- lm (cars$dist ~ cars$speed)
fit <- lm (dist~speed, data=cars)
fit
plot (cars$dist , cars$speed)
plot (cars)
lines(cars$speed , cars$speed*3.932-17.579)

levels(iris$Species)


# 5. 데이터 분리
# 5.1 split
#iris.se <- subset(iris, (iris$Species=='setosa'))
#iris.vc <- subset(iris, (iris$Species=='versicolor'))
#iris.vn <- subset(iris, (iris$Species=='virginica'))


iris.species <- split (iris, iris$Species) # list형태
iris.species

iris.species['virginica']


iris.sepal <- split(iris, iris$Sepal.Length>5)

iris.sepal['FALSE']
iris.sepal$'FALSE'
head(iris.sepal$'FALSE')


levels(iris$Species)
# 5.2 subset
# 문. setosa중 Sepal.Length, Petal.Length 열 출력

subset(iris[c(1,3)],iris$Species=='setosa')


# 문. setosa중 Sepal.Length, Sepal.Width, Petal.Length, Petal.Width 열 출력
subset(iris[,-5],iris$Species=='setosa')
# 문. setosa중 Sepal.Length가 4이상인 데이터
subset(iris,(iris$Species=='setosa' && iris$Sepal.Length>=5))

# 6.데이터 합치기
# 컬럼 합치기 cbind()
# 행 합치기  rbind()
# 병합하기 merge()
student.a <- data.frame(name=c('yi','kim'), score=c(100,90))
student.a
student.b <- data.frame(id=c(100,101), gender=c('여','남'))
student.b

(student <- cbind(student.a, student.b))

student

#6.2 rbind()
student.a <- data.frame(name=c('yi','kim'), score=c(100,90))

student.b <- data.frame(name=c('park','yun'), score=c(99,91))

(student <- rbind(student.a, student.b))


# 6.3 merge()
student.a <- data.frame(name=c('yi','kim'), kor=c(100,90))

student.b <- data.frame(name=c('yi','kim'), eng=c(99,91), mat=c(99,88))

(student <- merge(student.a, student.b, all=T))

student

#7 데이터 정렬
# sort() 정렬된 데이터 반환 / order() 정렬된 데이터의 index 반환
data <- c (10,30,100,1,3)
sort(data)
sort(data, decreasing= TRUE)
sort(iris$Sepal.Length)

data <- c(10,30,100,1,3)
names(data) <- c('1st','2nd','3rd','4th','5th')
data
sort(data)
data
order(data)
data[order(data)]

#iris 데이터를 sepal.Length를 기준으로 내림차순 정렬
sort(iris$Sepal.Length, decreasing=T)
sort(iris$Sepal.Length)
order(iris$Sepal.Length, decreasing = T)
order(iris$Sepal.Length)
iris[order(-iris$Sepal.Length),]

# iris 데이터를 Sepal.Length(내림차순), Sepal.width(오름차순)
order(-iris$Sepal.Length, iris$Sepal.Width)

iris[order(-iris$Sepal.Length, iris$Sepal.Width),c(1,2,5)]

emps
#emp 데이터셋에서 월급이 많은 순으로 ename, sal을 추출
emps[order(emps$sal),c('ename','sal')]

#emp 데이터셋에서 월급이 많은 top5명으로 ename, sal을 추출
head(emps[order(emps$sal),c('ename','sal')],5)

#emp 데이터셋에서 월급이 적은 top5명으로 ename, sal을 추출
tail(emps[order(emps$sal),c('ename','sal')],5)


# 8. 데이터 프레임 이름 생략하기
#8.1. with절 , within 절
iris.temp <- iris
iris.temp[c(1,3),1]<-NA
head(iris.temp, 3)

iris.temp[c(1,3),1]

iris.temp

#종별 중앙값
mps <- tapply(iris.temp$Sepal.Length, iris.temp$Species, median, na.rm=T)
mps
mps['setosa']
split(iris.temp$Sepal.Length, iris.temp$Species)

iris.temp$Sepal.Length2 <- ifelse(is.na(iris.temp$Sepal.Length),
                                  mps[iris.temp$Species],
                                  iris.temp$Sepal.Length)


iris.temp


#with절은 sepal.Length의 결측치가 대치된 결과값을 반환
#within절은 sepal.Length의 결측치가 대치된 데이터 프레임 셋이 반환
iris.temp <- within(iris.temp,{
  mps <- tapply(Sepal.Length, Species, median, na.rm=T)
  Sepal.Length <- ifelse(is.na(Sepal.Length), mps[Species], Sepal.Length)
})
iris.with

head(iris.temp)

#8.2 attach().detach()
attach(iris)
summary(Species)
Sepal.Length
tapply(Petal.Length, Species, mean)
detach(iris)


#9. 데이터 집계
#9.1 table
table(iris$Species)
emp = read.csv('inData/emp.csv', header=T)
table(emp$ename)

table(InsectSprays$spray)


#emp 데이터 셋에서 deptno별 집계
table(emp$deptno)
emp$deptno <- factor(emp$deptno, levels=seq(10,40,10))

levels(emp$deptno)


#9.2 aggredate : 데이터를 하위 집합으로 분할하고 요약 통계 계산
aggregate(iris[,1:4],by=list(iris[,5]), mean)


# 보험회사의 고객들이 보험금을 청구하는 데이터에서 고객별 입원일 조회하려
cust_id <- c(5936, 5936, 5936, 1043, 8545,
             4734, 9416,20267, 2778, 9019,
             9019, 9019, 6989, 3372, 1274,
            21906, 3362, 3362,16781,  294)
hos_day <- c( 2, 2, 2, 6, 0,
               4, 0,23,29,13,
              13,13,13, 0, 0,
              13, 0,12,23, 0)

length(cust_id)
length(hos_day)
data <- data.frame(cust_id, hos_day)

# 대상열이 하나이상 가능
day_per_cust <- aggregate(data$hos_day, by=list(data$cust_id), sum)
day_per_cust
# 대상열이 하나만 가능
day_per_cust <- tapply(data$hos_day, data$cust_id, sum)
day_per_cust
library(doBy)
SummaryBy(hos_day~cust_id, data=data, FUN=c(sum,mean))
day_per_cust


names(day_per_cust) <- c('cust_id','hos_day')
day_per_cust
day_per_cust[order(-day_per_cust$hos_day),]


# 10. 조건으로 색인찾기
subset(iris, iris$Species=='setosa') #조건으로 데이터 추출
which(iris$Species=='setosa')  # 조건으로 색인 추출
iris[which(iris$Species=='setosa'),]   # 조건을 이용해서 데이터 출력

which.max(iris$Sepal.Length)
iris[which.max(iris$Sepal.Length),]  #Sepal.Length가 제일 큰 row를 춫력

