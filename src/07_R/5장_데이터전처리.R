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
