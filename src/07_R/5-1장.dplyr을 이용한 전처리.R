####################################
# 5-1. dplyr 패키지를 이용한 전처리 
####################################
# 1. 외부 파일 read / write
# 1.1 엑셀 파일 읽어오기 - readx1 패키지 이용

library(readlx)
install.packages("readxl")
library('readxl')
getwd()
exam <- read_excel("inData/exam.xlsx")
exam
head(exam)

exam[21,] <- data.frame(id=1, class=1, math=90, english=90, science=99)


tail (exam)

#파생변수 추가
exam$tot <- exam$math + exam$english + exam$science

exam$grade <- ifelse(exam$tot>mean(exam$tot),'상','하')


apply(exam[,3:6],1,mean)

#데이터 파일에 컬럼명이 없는 경우
data <- read_excel('inData/data_ex.xls', col_names= FALSE)

data 
colnames(data) <- c('id','gender','age','area')



# 1.2 데이터 쓰기(파일(csv)로 쓰기 vs 변수만 쓰기)
write.csv(exam, 'outData/exam.csv', row.names = TRUE) #파일로 쓰기

save(exam, file='outData/exam.rda')
rm(list=ls(all.names = TRUE))
exam
load('outData/exam.rda')

# 2 데이터 파악하기

mpg <- as.data.frame(ggplot2::mpg)

mpg

head(mpg)
str(mpg)
levels(mpg)

#head()앞부분 tail() 뒷부분 view()= edit()뷰창에서 데이터 확인용
#dim() 차원 str() 구조 summary()요약
# 3 파악한 데이터를 dplyr 패키지를 이용하여 전처리 및 분석하기

head(mpg)
tail(mpg)
edit(mpg)
View(mpg)
dim(mpg)
summary(mpg) #최소값 14분위수 중위수 3사분위수 최대값

# 변수명 바꾸기 (Cty-> city, hwy-> highway)

install.packages('dplyr')

library('dplyr')
mpg <- as.data.frame(ggplot2::mpg)
mpg <- rename(mpg, c(city=cty,highway=hwy))


str(mpg)

mpg$total = (mpg$cty + mpg$hwy)/2

mpg$test <- ifelse(mpg$totla>= mean(mpg$total),"pass","fail")

table (mpg$test)

library(ggplot2)
?qplot
hist(mpg$total)



qplot(mpg$test, color=mpg$test)


# 부르기
midwest <- as.data.frame(ggplot2::midwest)


str(midwest)
summary(midwest)
head(midwest)

#2) 이름 변경
midwest <- rename(midwest, total=poptotal )

midwest <- rename(midwest, asian=popasian)


#3) 인구대비 아시아인 백분율 파생변수
midwest$ratioasian <- midwest$asian / midwest$total * 100
midwest[,c('total','asian','ratioasian')]

hist(midwest$asian)

#4) 'large','msal'
boxplot(midwest$asian)
boxplot(midwest$total)
install.packages("vioplot")
library(vioplot)

par(mfrow=c(1,1))


boxplot(midwest$ratioasian)
mean(midwest$ratioasian)
midwest$group <- ifelse(midwest$ratioasian>= mean(midwest$ratioasian),"large","small")

hmw <- head(midwest[,c('total','asian','ratioasian','group')])
mw <- midwest

table(midwest$group)
nrow(mw)
dim(midwest)

#3. 파악한 데이터를 dplyr 패키지를 이용하여 전처리 및 분석하기기
# 3.1 조건에 맞는 데이터 추출하기 : filter()
# filter()    행 추출
# select()    열(변수) 추출
# arrange()   정렬
# mutate()    변수 추가(새필드)
# summarise() 통계치 산출
# group_by()  집단별로 나누기
# left_join() 데이터 합치기(열)
# bind_rows() 데이터 합치기(행)

exam <- read.csv('inData/exam.csv',header=T)
exam

library(dplyr)  

#dplyr 패키지는 %>% 기호를 이용해서 함수들을 나열하는 방식 코딩
exam %>% filter(class==1 |  class==2 | class==3)    

exam %>% filter (class %in% c(1,2,3))


#3.2 필요한 변수 추출하기 : select()
exam %>% select(class, english, math) #추출하고자 하는 변수만 select 함수안에 
exam %>% select(-math)  # math변수만 제외하고 다 출력

exam

# class가 1과 2의 행중에서 국어,영어, 수학 데이터 만 출력 
exam %>%
  filter(class %in% c(1,2)), %>%
  select(english, math)

# class가 1,2,3행에서 영,수 데이터만 앞 5개 추출
exam %>% 
  filter(class %in% c(1,2,3)) %>%
  select(class, english,math) %>%
  head(5)


# 3.3 정렬하기: arrange()
exam %>% arrange(math)                # 오름차순 정렬
exam %>% arrange(desc(math))          # 내림차순 정렬
exam %>% arrange(-math)               # 내림차순 정렬
exam %>% arrange(class, desc(math))   # class오름차순, math 내림차순
exam %>% arrange(class, -math)

#id가 1부터 10인 학생의 영어, 수학성적을 영어 성적 기준으로 오름차순 정렬하고 top 6만
exam %>% 
  filter(id %in% 1:10) %>% 
  select(english, math) %>%
  arrange(english) %>%
  head(6)


exam %>% 
  filter(id %in% 1:10) %>% 
  select(english, math) %>%
  arrange(english) %>%
  head(6)


## 파생변수 추가 : mutate(뷰같은 느낌)
exam %>% 
  mutate(total = math + english + science)
  filter(total>=150)

exam %>% 
  mutate(total = math + english + science, avg=round(total/3,2)) %>% 
  select(-id) %>% 
  arrange(desc(total))

# 3.5 요약하기 : summarise()
# summarise 안에 들어갈수 있는 요약함수들 min max avg sum median sd n
exam %>% 
  summarise(mean_math=mean(math))

exam %>% 
  summarise(mean_math = mean(math),mean_eng  = mean(english),
            sd_math = sd(math), sd_eng=sd(english))


# 3.6 집단별로 요약하기 groupby + summarise
exam %>%
  group_by(class) %>% 
  summarise(mean_math = mean(math), n=n(), max_eng=max(english)) %>% 
  arrange (mean_math)

exam

#클래스별 수학, 영어, 과학의 평균을
exam %>%
  group_by(class) %>% 
  summarise(mean_math = mean(math), mean_eng = mean(english), mean_sci = mean(science))



# mpg 회사별로 suv 자동차의 도시 및 고속도로 통합 연비 평균을 구해 내림차순으로 정렬하고 1~5위까지 출력하기

mpg %>% 
  filter(class =='suv')  %>%
  group_by(manufacturer) %>%
  mutate(mpstot = city+highway) %>%
  summarise(tot_mean = mean(mpstot)) %>%
  arrange(-tot_mean)       %>%
  head(5)
    
# mpg 데이터를 이용해 분석 문제를 해결해 보세요.

#혼자1 q1




library('dplyr')
library('doBy')

mpg <- as.data.frame(ggplot2::mpg)
mpg <- rename(mpg, c(city=cty,highway=hwy))

mpg$displ_div <- as.factor(mpg$displ_div)

levels(mpg$displ_div)

# 파생변수
mpg$displ_div <- ifelse(mpg$displ<=4,'low', ifelse(mpg$displ>=5,'high','etc'))

# 이렇게도 된다
mpg$displ_div <- 'etc'
mpg$displ_div[mpg$displ<=4] <- 'low'
mpg$displ_div[mpg$displ>=5] <- 'high'


mpg %>% 
  group_by(displ_div) %>% 
  summarise(mean_highway = mean(highway), mean_city = mean(city))


str(mpg)

tapply(mpg$highway,mpg$displ_div,mean)
## mean은 두열에 대해서는 mean이 안된다
by(mpg[,9], mpg$displ_div, mean)
## 근데 이렇게 하면 되네????
by(mpg[,9]+mpg[,8], mpg$displ_div, mean)

data <- summaryBy(highway + city ~ displ_div +  trans, mpg)

data

?orderBy


#한줄일때
orderBy(~-highway.mean, data=summaryBy(highway + city ~ displ_div +  trans, mpg))
orderBy(~-city.mean, data=summaryBy(highway + city ~ displ_div +  trans, mpg))


# 여러줄일때 필요한열 쓰고, 리스트면 그냥, 데이터 프레임 정렬이면 order함수 뒤에 컴마 추가
data[order(-data$city.mean,-data$highway.mean),]

?sort


sort(-data$city.mean)



order(aggregate(mpg[,c('city','highway')],by=list(mpg$displ_div), mean))


aggregate(mpg[,c('city','highway')],by=list(mpg$displ_div), mean)



data <- c(10,30,100,1,3)

names(data) <- c('1st','2nd','3rd','4th','5th')

tapply(mpg$highway,mpg$displ_div,mean)

sort(tapply(mpg$highway,mpg$displ_div,mean))

data
order(data)
data[order(data)]



# 혼자1 Q2
mpg %>% 
  filter(manufacturer %in% c('audi','toyota')) %>% 
  group_by (manufacturer) %>% 
  summarise(mean_city = mean(city))




# 혼자1 Q3    
mpg %>% 
  filter(manufacturer %in% c("chevrolet", "ford", "honda")) %>% 
  group_by(manufacturer) %>%  
  summarise(mean_highway = mean(highway))




#혼자2 Q1
mpg %>% 
  select(class, city)

#혼자2 Q2
mpg %>% 
  select(class, city) %>%
  filter(class %in% c("suv", "compact")) %>% 
  group_by(class) %>%  
  summarise(mean_city = mean(city))

#혼자2 Q3
mpg %>% 
  filter(manufacturer=="audi") %>% 
  group_by(model) %>% 
  summarise(mean_highway = mean(highway))
  head(5)

#혼자3 1
mpg2 <- mpg %>% 
  mutate(totmps = city+highway)

#혼자3 2
mpg2 <- mpg %>% 
  mutate(totmps = city+highway, avgmps = round(totmps/2,2)  )


head(mpg2)

#혼자3 3
mpg2 %>% 
  arrange(-avgmps) %>% 
  head(3)


#혼자3 4
mpg %>% 
  mutate(totmps = city+highway, avgmps = round(totmps/2,2)  ) %>% 
  arrange(-avgmps) %>% 
  head(3)
  
#혼자4 1
mpg %>% 
  select(class, city) %>%
  filter(class %in% c("suv", "compact")) %>% 
  group_by(class) %>%  
  summarise(mean_city = mean(city))

#혼자4 2
mpg %>% 
  select(class, city) %>%
  filter(class %in% c("suv", "compact")) %>% 
  group_by(class) %>%  
  summarise(mean_city = mean(city))
  arrange(-mean_city)
  
#혼자4 3
  mpg %>% 
    group_by(manufacturer) %>%  
    summarise(mean_highway = mean(highway)) %>% 
  arrange(-mean_highway) %>% 
  head(3)
  
#혼자4 4
mpg %>% 
  filter(class == "compact") %>% 
  group_by(manufacturer) %>% 
  summarise(n_count = n()) %>% 
  arrange(-n_count)


#4. 데이터 합치기
 #열 합치기 : cbind, left_join
 #행 합치기 : rbind, bind_rows
 #cf. merge

#4.1 열 합치기(가로 합치기)
test1 <- data.frame(id=c(1,2,3,4,5),
                    midterm =  c(79,80,90,95,99))

test2 <- data.frame(id=c(1,2,3,4,5), 
                    finalterm =c(90,80,70,60,99),
                    teacherid=c(1,1,2,2,3))
                    )

teacher <- data.frame(teacherid=c(1,2,3),
                      teachername=c('Kim','Park','Ryu'))


cbind(test1, test2)
merge(test1, test2)
left_join(test1, test2, by='id')
#cbind(test2, teacher)
left_join(test2, teacher, by='teacherid')
merge(test2, teacher, by='teacherid')



test2 <- data.frame(id=c(1,2,3,4,5), 
                    finalterm =c(90,80,70,60,99),
                    teacherid=c(1,1,2,2,4))
)

teacher <- data.frame(teacherid=c(1,2,3),
                      teachername=c('Kim','Park','Ryu'))


left_join(test2, teacher, by='teacherid')

merge(test2, teacher, by='teacherid')


#4.2 행 합치기(세로 합치기)
group_a <- data.frame(id=c(1,2,3,4,5),
                      test=c(60,70,80,90,95))

group_b <- data.frame(id=c(6,7,8,9,10),
                      test=c(90,95,94,93,92))


rbind(group_a, group_b)
bind_rows(group_a, group_b)


group_a <- data.frame(id=c(1,2,3,4,5),
                      test1=c(60,70,80,90,95))

group_b <- data.frame(id=c(6,7,8,9,10),
                      test2=c(90,95,94,93,92))


# 두 데이터의 프레임의 변수가 일부 같지 않은 경우
rbind(group_a, group_b)

bind_rows(group_a, group_b)

df <- dafa.frame(name=c('kim','Yi','yun','Ma','Mark'),
                 gender=c('M','F','NA,'M','f'),
                 score=c(5,4,3,4,NA),
                 income=c(2000,c(3000,4000,5000))
                 
                 
na.omit(df)
                          '))
tapply(df$score, df$gender, mean, na.rm=T)

x <- c(1,1,2,2,3,3,3,4,4,5,5,100)

mean(x)
median(x)

exam <- read.csv("inData/exam.csv",header=T)



table(is.na(exam))
colnames(exam)
exam[c(3,8,15),'math'] <- NA
exam[1:2,'english'] <- NA

table(is.na(exam))
apply(exam[3:5],2,mean, na.rm=T)


tapply(exam[,3],exam$class, mean)

#결측치들을 중앙값 대체
exam


exam %>% 
  summarise(math=mean(math,na.rm=T),
            english=mean(english,na.rm=T),
            science=mean(science,na.rm=T),
            )

exam$math

exam$math <- ifelse(is.na(exam$math), median(exam$math,na.rm=T), exam$math)

exam$math <- ifelse(is.na(exam$math), round(mean(exam$math,na.rm=T)), exam$math)

exam$math[3] <- ifelse(is.na(exam$math[3]), median(exam$math[3],ma.rm=T), exam$math[3])





exam$english

exam$english <- ifelse(is.na(exam$english), median(exam$english, na.rm=T), exam$english)


exam$english


table(is.na(exam))
colSums(is.na(exam))




#결측치 대체 방법1
exam <- within(exam,{
math <-    ifelse(is.na(math)   , median['math']   ,math)
english <- ifelse(is.na(english), median['english'],english)
science <- ifelse(is.na(science), median['science'],science )
})


median['math'];
median['english'];


exam %>% 
  mutate(
    math <-    ifelse(is.na(math)   , median['math']   ,math,
    english <- ifelse(is.na(english), median['english'],english,
    science <- ifelse(is.na(science), median['science'],science 
)







#5.2 이상치 정제
# 극단적인 이상치

outlier <- data.frame(gender=c(1,2,1,3,2),score=c(90,95,100,99,101))

table(outlier$gender)

outlier$gender <- ifelse(outlier$gender==3, NA, outlier$gender)





mpg <- as.data.frame(ggplot2::mpg)

mpg$hwy

mean(mpg$hwy)+3*sd(mpg$hwy)
mean(mpg$hwy)-3*sd(mpg$hwy)

result <- boxplot(mpg$hwy)$stats

result[1]; result[5]

ifelse(mpg$hwy >  mean(mpg$hwy)+3*sd(mpg$hwy),mpg$hwy,'정상')

subset(mpg, mpg$hwy==44)

mpg$hwy <- ifelse(mpg$hwy>result[5] | mpg$hwy<result[1], NA, mpg$hwy)

boxplot(mpg$hwy)

table(is.na(mpg$hwy))

mpg


fuel <- data.frame(fl=c('c','d','e','p','r'),
                   price=c(2.35,2.38,2.11,2.76,2.22)
)

fuel

mpg2 <- left_join(mpg,fuel,by='fl')

#6.  혼자해보기

table(mpg$drv)
