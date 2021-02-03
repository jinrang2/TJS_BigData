############################################
# 4. R프로그래밍; 제어문,연산자, function
############################################

# 1. 제어문
# 1.1 조건문
# (1) if문
num <- 9

if((num%%2==0)){
  cat (num,"은 짝수")
} else{
  cat (num,"은 홀수")
}

# (2) ifelse()함수
ifelse(num%%2==0, "짝","홀")

nums <- c(1,2,3,4,5)

oddevens <- ifelse(nums%%2==0, "짝","홀")

oddevens

m <- matrix(c(nums,oddevens), ncol=5, byrow = TRUE,
            dimnames = list(c('수','홀짝'),
            c('1회','2회','3회','4회','5회')))

m


# (3) switch()함수
switch(2, "red","green","blue") #"green"

x <- switch(4, "red","green","blue")
x

# 사용자
?readline

colorValue <- readline(prompt = "컬러값은? (red:1, green:2 blue:3)")
colorValue
color <- switch(colorValue, "red","green","blue")
color

color <-readline(prompt = "컬러값은? (red:1, green:2 blue:3)")
colorValue <- switch(color, "red"=1,"green"=2,"blue"=3)
cat('선택한 색상',color,'의 색상값은',colorValue)


# 문. 점수(50~100)를 입력받아 학점을 계산하는 프로그램 구현해 보세요
# 100:perfect , 90점대:a~~~ 60점대:D 50점대F

score <- as.integer(readline(prompt = "점순는? (50~100)"))

grade <- switch(as.integer(score/10)-4, "F","E","D","C","B","A","Perpect")

grade


getGrade <- function(){
  
  score <- as.integer(readline(prompt = "점순는? (50~100)"))
  grade <- switch(as.integer(score/10)-4, "F","E","D","C","B","A","Perpect")
  cat('입력한 점수는',score, ', 학점은',grade)
}


# 1.2 반복문 : for, while, repeat
# (1) for문
1:10
seq(1,10)
set(10)

x <- c(-2,5,4,8)

val <- 0
count <- 0
for(val in x){
  if(val%%2==0){
    count = count+1
  }
}

print(count)

# 문. factorial 계산 함수를 작성하시오
# fact(3) # 결과 3!=6
# fact(-3) 결과 : 음수값을 위한 팩토리얼은 존재하지 않아요
# fact(0) 결과: 0! = 1


'''getFact <- function(num) {
  sum <- 1
  if(num < 0){
    cat("음수값을 위한 팩토리얼은 존재하지 않아요")
  } else{
    for (idx in 1:num){
      sum = sum * idx
    }
  }
  cat(sum)
}'''

rm(list=ls())

getwd()
setwd('E:/gon/TJS_BigData/src/07_R')
getwd()

source('fact.R', encoding = 'utf-8')

fact(0)
fact(0)
fact(-3)



i<-1
while (i<6){
  print(i) 
  i = i +1
}


# (3) repeat
i<-1
repeat {
  if(i>6) break
  print(i) 
  i = i +1
}

# (3) break, next(자바에서의 continue)
x <- 1
while(x<10){
  x <- x+1
  if(x==5) break;
  cat(x,'\t')
}




#2 연산자
x <- 1
x
2 -> x
x

# 논리연산자 &,&&,|,||
TRUE && TRUE
TRUE & TRUE
x <- c(T,T,F,F)
y <- c(T,F,T,F)

x & y # 모든 요소를 다 체크
x && y # 첫번쨰 요소만 체크
x | y # 모든 요소를 다 체크
x || y # 첫번쨰 요소만 체크

#1.2 중위 연산자

5+8
'+'(5,8)

'%add%' <- function(x,y){
  return (x+y)
}

'%add%'(5,8)
5 %add% 8


c<- c(10,23,30)

11 %in% c


strings <- c("Hello","World","R")
strings %in% 'R'


# %o% : 외적
# %*% : 내적(행렬의 곱)

a <- c(2,3,4)
b <- c(10,20,30)

a %o% b
a %*% b
aa <- matrix(a,nrow=1)
bb <- matrix(b,ncol=1)

aa
bb
aa %o% bb
aa %*% bb
bb %*% aa

c<-c('1','2','3')
d<-c('a','b','c')
outer(c,d,FUN=paste)

matrix.a <- matrix(1:6, nrow=3)
matrix.b <- matrix(1:6, nrow=3)
matrix.a %*% matrix.b
solve(matrix.a)


#재귀호출
ㄻㅊㅅ

# 3. 함수
pow <- function(x,y){
  return (x^y);
}


pow
pow(2,4)

#가변 인자 함수 total() total(1) total(2,3,4) 
total <- function(...){
  args <- list(...)
  sum <- 0
  for (val in args){
    sum <- sum+val
    cat(val, '의 합은 ', sum)
  }
  
  return (sum)
}

total()
total(1)


rm(list=ls())


#재귀 호출 : 함수내에서 자기 함수를 호출 하는 함수
fact <- function(num){
  if(num<0) {
    return()
  } else if(num==1) {
    return (1)
  } else {
    return (num * fact(num-1))
  }
}

#fact(3) -> 6 3
#fact(3) =3 * fact(2)
#        = 3 * 2 * fact(1)

fact(4)
fact(0)
fact(-4)


environment()
ls()

f <- function(f_x){
  g<- function(g_x){
    print('g함수 안') 
    print(environment())
    print(paste('g 함수 영역에서의 변수들',ls()))
  }
  
  g(5)
  print('f 함수 안')
  print(environment())
  print(paste('f함수 영역에서의 변수들'))
}


f(5)


num <- 6

prime <- function(num){
  state <- TRUE
  cat('num은 ', num)
  for(i in 3:num-1){
    cat('피제수',num,'제수',i,'\n')
    if(num == 1){
      next
    }
    
    #if( num%%i==0 ){
    #  cat('피제수',num,'제수',i,'\n')
    #  return (FALSE)
    #}
  }
  
  return (TRUE)
}

prime(num)
