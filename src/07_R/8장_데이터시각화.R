########################################
# 8장. 데이터 시각화
########################################
# 1. 시각화 개요 : 원본 데이터, 분석된 결과를 보여줌

# R의 그래픽 시스템

# (1) base graphics system - 전통적인 함수 이용, 
#그래프 종류별 함수가 각기 달라 정교한 그래프 이용시 노력 필요

# (2) grid graphics system - base graphics system
# 한계 극복을 위해 탄생한 패키지 ggplot2
# 유연한 그래프 환경 제공


library(ggplot2)

ggplot(data=mtcars, aes(x=wt, y=mpg)) + 
        labs(title="그래프 첫 예제") 


ggplot(data=mtcars, aes(x=wt, y=mpg)) + 
      geom_point() + 
      labs(title="그래프 첫 예제") + 
      geom_smooth()

# 1.2 basic 그래프 함수의 종류들
# 고수준 그래프 함수 :plot, barplot, boxplot, hist,pie, ....
# 그래프 함수를 호출 할 떄 마다 , 그래프 영역에 새로운 그래프를 시작

#저 수준 그래프 함수 : lines, abline(회귀라인),  point, text, ...
# 새로운 그래프를 생성하지 않음, 이미 그려진 그래프 위에 점, 라인 , 글씨..

# 1.3 그래프 파라미터  : bty(박스유형), 

#1 par() : 선 굵기 , 종류, 글꼴, 그래프를 조정하거나 특성을 지정

?cars # 차 속도와 제동거리리

plot(cars)
oldpar <- par(bty=']')
oldpar
par(oldpar)
plot(cars)
plot(iris)
#fit <- lm(cars$dist ~ cars$speed)
fit <- lm(dist ~ speed, data=cars)
plot(fit)
abline(fit, col=2 )



# par함수에 다른 파라미터 사용 예
x <- 1:100

y1 <- rnorm(100)      #평균이 0이고 표준편차가 1인 수 100개 추출
  
y2 <- rnorm(100)+100  #평균이 100이고 표준편차가 1인 수 100개 추출(정규 분포)

y1
  
oldpar <- par(mar=c(5,5,5,5))
oldpar

?par

plot(x,y1, pch='▲', type="b", col='salmon', ylim=c(-8,2), bty='C')  
#pch  : 0:네모, 1:원, 2:세모, 3:십자, 4:x 5:다이아몬드 문자:해당문자
#type : p:점, L:선, b:점선동시, o:점선 겹치면서 동시, h:히스토 그램, s:계단모양, n:좌표찍지 않음음
#col  : 1:black 2:red 3:green 4:blue 5:cyan 6:purple 7:yellow 8:gray
# ylim, xlim ; y눈금, x눈금 조정
# yaxt : y축 눈금 없애기
# bty : 그래프 박스 타입 (o,L, 7, U, C, n)

axis(side=3, at=c(-100,0,100)) #눈금
#side:1하 2좌 3위 4우
# 그릴 방위, 방위들에서 그려지는 x: line    y:at 거리 이동범위
mtext("red line(y1)", side=2, line=3, at=1, col=2) 
colors()
par(new=TRUE)

plot(x,y2, pch='1', type="b", col='blue', yaxt='n',, ylim=c(98,108), ylab="", bty="n")
mtext("blue line(y2)", side=2, line=3, at=-1, col=2) 

par(oldpar) #그래프 영역 설정 원상 복구

