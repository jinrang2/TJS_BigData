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

install.packages(ggplot2)

library(ggplot2)

ggplot(data=iris, aes(x=Petal.Length, y=Petal.Width)) + geom_point(aes(color=Species)) +
scale_color_manual(values = c('black','red','orange')) +
labs(title="iris 데이터의 산점도",x="꽃잎 길이",y="꽃잎 너비") +
coord_cartesian(ylim=c(0,2.5)) +
geom_smooth()


mtcars$cyl <- factor(mtcars$cyl, levels= c(4,6,8), labels=c('4 cylinders','6 cylinders','8 cylinders'))

str(mtcars$cyl)


ggplot(data=mtcars, aes(x=mpg)) + geom_histogram() +
  facet_grid(cyl~.) +
  labs(title='cyl에 따른 연비 히스토그램', x='연비', y='횟수')


# ggplot2::mpg 데이터 셋에서 displ의 도수푼포표

str(mpg$displ)

library(ggplot2)

# 배기량에 따른
ggplot(data=mpg, aes(x=displ)) +
geom_histogram(aes(fill=class)) +
theme(axis.text.x = element_text(color='red', size=15),
      axis.line = element_line(color='black', size=2),
      axis.text.y = element_blank(),
      panel.background = element_rect(fill='lightblue')
      )


ggplot(mpg, aes(x=displ)) +
  geom_histogram(aes(fill=class) , binwidth = 0.1) +
labs(title='Histogram with Auto Binding', subtitle = "(Engine Displacemetn acrooss Wechicle Classes)")+
  theme(legend.position = 'bottom')


ggplot(mpg, aes(x=displ)) +
  geom_histogram(aes(fill=class) , bins = 5, col='gray') 

# 4.3

boxplot(iris$Sepal.Length)$stat

ggplot(iris, aes(y=Sepal.Length)) +
geom_boxplot()

#종별 Sepal.Length의 차이가 있는지를 보고 싶을때
tapply(iris$Sepal.Length, iris$Species, mean)


ggplot(iris, aes(y=Sepal.Length, x=Species)) + geom_boxplot(aes(fill=Species), col="dimgray") +
  scale_fill_manual(values=c('#ff0000','yellow','green'))


library(RColorBrewer)
display.brewer.all()

pal <- brewer.pal(8, 'Set2')


ggplot(iris, aes(y=Sepal.Length, x=Species)) +
  geom_boxplot(aes(fill=Species), col='dimgray') +
  scale_fill_manual(values=pal)


install.packages("gapminder")
library(gapminder)

table(gapminder$country)
dim(gapminder)

head(gapminder)

subset(gapminder, gapminder$country=='Afghanistan')

tapply(gapminder$pop, gapminder$continent, sum)


ggplot(gapminder, aes(x=continent, y=gdpPercap)) +
  geom_boxplot() +
  coord_cartesian(ylim=c(0,30000))

install.packages("car")
library(car)

#교수의 직급별(조교수, 부교수, 정교수) 연봉이 상이한지
# notch=T : 중위수에 대해서 95% 신뢰구간 표현, 신뢰구간이 겹치는지 파악
# position = 'jitter' : 산점도를 분산해서
# geom_rug : 관측값의 밀도 상태 표현
# 데이터가 많은곳은 빽뺵하게, 데이터가 적은 곳은 하얗게게
ggplot(Salaries, aes(x=rank, y=salary)) + geom_boxplot(aes(col=rank), fill='lightyellow', notch=T) +
geom_point(position = 'jitter', col='brown', alpha=0.2, pch=6) +
  geom_rug(col='dimgray', sides="l")


# mtcars 데이터 cyl개수에 따른 연비 mpg의 95% 중우쉬 신뢰구간을 표현 상자도표를 시각회하시오
head(mtcars)
?mtcars
str(mtcars$cyl)


ggplot(mtcars, aes(x=cyl, y=mpg)) +
  geom_boxplot(norch=T)

# 4.4 바이올린 도표 ; boxplot과 밀도도표를 합쳐
# 합창부 단원의 키와 성악부 part의 관계계

library(lattice)


ggplot(singer, aes(x=voice.part, y=height)) +
  geom_point(position = 'jitter', col='brown', alpha=0.2, pch=6) +
  geom_boxplot(notch=T)

ggplot(singer, aes(x=voice.part, y=height)) +
  geom_violin(fill='honeydew2') +
  geom_boxplot(fill='green', width=0.3) 

# 4.5 밀도도표
head(mtchars,1)


ggplot(data=mtcars, aes(x=mpg, fill=cyl)) + geom_density() +
labs(title='밀도도표', x="Miles per Gallon") +
  theme(legend.position = c(0.6,0.8))


# 4.6 추세선 (시계열에서 데이터의 흐름 표현)
economics
colnames(economics)

#시간(date)에 따른 실업률(unemploy)
ggplot(data=economics, aes(x=date, y=unemploy)) +
  geom_line() + #추세선
  geom_smooth(method='lm') # 적합도선

# 4.7 막대도표 (geom_bar함수, geom_col함수)
# 도수분포표: 막대 도표, 히스토 그램 모두
# 히스토 그램: 연속형 자료를 계급으로 나누어 계급별 도수를 나타냄
# geom_histogram()함수

# 막대도표 : 범주형 자료의 빈도를 나타냄
#geom_bar(), geom_col() 함수

#mpg 데이터 셋에서 제조회사 별로 빈도표
str(mpg$manufacturer)

str(mpg)

ggplot(mpg, aes(x=manufacturer)) +
geom_bar(stat='count')

ggplot(mpg, aes(x=manufacturer, fill=class)) +
  geom_bar(stat='count') +
  theme(legend.position = 'top',
        axis.text.x = element_text(angle=60, vjust=0.5)) +
  scale_fill_manual(values=topo.colors(7))
labs(title='제조사 별 class 빈도표')



ggplot(mpg, aes(x=manufacturer, fill=model)) +
  geom_bar(stat='count') +
  theme(legend.position = 'top',
        axis.text.x = element_text(angle=60, vjust=0.5)) 

# 다이아 몬드 품질별 데이터
head(diamonds)
str(diamonds)
dim(diamonds)
# 다이아몬드 품질(cut)별 빈도수 시각화
ggplot(diamonds, aes(x=cut, fill=cut, full=cut)) + geom_bar(stat='count') +
  scale_fill_manual(values=topo.colors(5)) + 
  scale_color_manual(values=rainbow(5))

table(diamonds$cut, diamonds$color)

library(dplyr)

diamonds %>% 
  group_by (cut, color) %>% 
  summarise(n=n() ) %>% 
  ggplot(aes(x=cut, fill=color,y=n )) +
  geom_bar(stat='identity', position='dodge')

?geom_bar


diamonds %>% 
  group_by (cut, color) %>% 
  summarise(n=n() ) %>% 
  ggplot(aes(x=cut, fill=color,y=n )) +
  geom_bar(stat='identity')

#다이아몬드도 품질(cut)별 table의 종류와 갯수
diamonds %>% 
  group_by (cut, table) %>% 
  summarise(n=n() ) %>% 
  ggplot(aes(x=cut, fill=table, y=n )) +
  geom_col(stat='dodge')



diamonds %>% 
  group_by (cut, table) %>% 
  summarise(n=n() ) %>% 
  ggplot(aes(x=table, y=n )) +
  geom_bar(stat='identity') +
  facet_wrap(~cut) +
  coord_cartesian(ylim=c(0,3000), xlim=c(50,80))


diamonds %>% 
  group_by (cut, table) %>% 
  summarise(n=n()) %>% 
  group_by (cut) %>% 
  summarise(n=n())


diamonds %>% 
  group_by (cut) %>% 
  summarise(n=n_distinct(table)) 


diamonds %>% 
  group_by (cut) %>% 
  summarise(n=n()) 

# 4.8 그래프를 파일에 저장
jpeg('iris2.jpg')

boxplot(iris$Sepal.Length)
dev.off()

png('iris.png', width=300, height=150)

ggplot(iris, aes(x=Sepal.Length, y=Sepal.Width)) +
  geom_point() +
  facet_wrap(~Species)


dev.off()


ggplot(iris, aes(x=Petal.Width, y=Petal.Length, col=Species)) +
  geom_point(aes(size=Petal.Width),pch=2, alpha=0.5) +
ggsave('outData/iris.jpg')


# 4.9 차트 분할 출력
install.packages("gridExtra")
library(gridExtra)


g1 <- ggplot(iris, aes(x=Petal.Width, y=Petal.Length)) + geom_point()

g1

g2 <- ggplot(iris, aes(x=Sepal.Width, y=Sepal.Length)) + geom_point()

g2


grid.arrange(g1, g2, ncol=2)


plot(iris[-5])

pairs(iris[-5], panel=panel.smooth)



qplot(data=mpg, x=drv, fill=drv)

# 연습문제 1

