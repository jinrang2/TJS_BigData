#########################################
# 10장. t-test분석 VS ANOVA분석
#########################################
# 그룹간 평균의 차이가 통계적으로 유의한지 검증:t-test분석
# 세그룹 이상 집단의 평균 차이가 유의한지 검증: anova분석(분사분석)


# 1. 두 그룹간의 평균의 차이가 유의한지 분석
ToothGrowth <

str(ToothGrowth)

table(ToothGrowth$supp)

# 1) 도표로 차이의 유의성을 표현(tapply, by, summaryBy, aggreate. 평균 분산)
# 2) 그래프로 시각화된 유의성 표현(바이올린 도표, 산점도, 상자도표)
# 3) 통계적으로 유의한지 검증
ToothGrowth <- rbind(ToothGrowth, ToothGrowth)

### 비타민의 종류가 기니피그 치아 성장에 영향을 미치는지?
1)
library(doBy)

summaryBy(len~supp, data=ToothGrowth, FUN=c(mean,sd) )

library(dplyr)


ToothGrowth %>% 
  group_by(supp) %>% 
  summarise(len.mean = mean(len)) %>% 
  ggplot(aes(x=supp, y=len.mean)) +
  geom_col(aes(fill=supp),width=0.7)
            
ggplot(data=ToothGrowth, aes(x=supp, y=len)) +
  geom_violin() +
  geom_point(position = 'jitter', alpha=0.5) +
  geom_boxplot(aes(fill=supp), notch=T)

# (3) 통계적인 분석
# 일원표본 t-test 
table(ToothGrowth$supp, useNA='ifany')

table(ToothGrowth$supp, exclude=NULL)


a<- ToothGrowth[ToothGrowth$supp=='OJ','len']

b<- ToothGrowth[ToothGrowth$supp=='VC','len']

t.test(a-b, dat)

var.test(len~supp, data=ToothGrowth)

t.test(len-supp, data=ToothGrowth, var.equal=F)


# dataset
sleep <- rbind(sleep, sleep)

nrow(sleep)
head(sleep)
str(sleep)
table(sleep$group, useNA = "ifany")

sleep

#1) 도표로 평균의 차이 나타내기

summaryBy(extra~group+ID, data=sleep, FUN=c(mean,sd) )

sleep %>% 
  group_by(group) %>% 
  summarise(mean_extra = mean(extra), sd_extra = sd(extra)) %>% 
  ggplot(aes(x=group, y=mean_extra)) +
  geom_col(aes(fill=group))

#2) 평균 표본의 차이를 시각화 하기
ggplot(sleep, aes(x=group, y=extra)) +
  geom_violin() +
  geom_point(position = 'jitter', alpha=0.5) +
  geom_boxplot(aes(fill=group), notch=T)


#3) 통계적으로 유의미한 차이를 분석하기
var.test (extra~group, data=sleep)
#p-value 0.05 보다 큼 -> 차이가 있다

t.test (extra~group, data=sleep)
#p-value 작아 두 그룹 사이의 평균이 같다는 귀무가설을 기각한다.


#2 3개 이상의 집단간 평균의 차이를 비교할때는 분산 분석(ANOVA)

# 1) aov()
#iris 데이터 셋에서 종에 따라 Sepal.Length의 평균의 다른지

ggplot(iris, aes(y=Sepal.Length))+
  geom_boxplot(aes(fill=Species), notch=T)

result <- aov(Sepal.Length ~ Species, data=iris )

result

summary(result)
# 귀무가설 : 종에 따라 길이가 같지 않다.
# F값이 0.05 보다 작으면 귀무가설을 기각
# F값이 0.05 보다 크면 귀무가설을 기각할 수 없다

# 2) anova()

#ggplot2:mpg 데이터 셋에서 cyl에 따라 mpg의 평균이 다른지
str(mpg$cyl)

str(mpg)

table(mpg$cyl, useNA = 'ifany') # cyl의 가지수와 결측치 확인


# cyl 에 따른 그룹이 4개 그룹이고 cyl변수 연속형 변수여서

fit <- lm(mpg ~ cyl , data=mtcars)
fit
anova(fit)



### 예제 : datasets::Orange ; 오렌지 나무의 종류, 연령, 둘레
# 오렌지 나무의 연령에 따른 둘레의 평균이 상이한지 분석하시오.

Orange

result <- aov(circumference ~ age, data=Orange)
result


fit <- lm(circumference ~ age, data=Orange)
fit
anova(fit)
