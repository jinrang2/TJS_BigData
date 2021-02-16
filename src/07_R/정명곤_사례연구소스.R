############################################
# 빅데이터 분석 결과 시각화 사례 연구 소스
############################################

#1 koweps hpc10 2015_beta5.sav로드하여 변수명 변경
getwd()


# read.spss()함수 사용 목적
install.packages("foreign")

library(foreign)


raw_welfare <- read.spss(file='Koweps_hpc10_2015_beta1.sav', to.data.frame=T)

View(raw_welfare)


# raw_welfare$h10_g3
# raw_welfare$h10_g4
# raw_welfare$h10_g10
# raw_welfare$h10_g11
# raw_welfare$h10_eco9
# raw_welfare$p1002_8aq1
# raw_welfare$h10_reg7


library(reshape)

#1번
# 기준1, 기준2
data <- data.frame(raw_welfare$h10_g3,
                   raw_welfare$h10_g4,
                   raw_welfare$h10_g10,
                   raw_welfare$h10_g11,
                   raw_welfare$h10_eco9,
                   raw_welfare$p1002_8aq1,
                   raw_welfare$h10_reg7
)

#기준3
data <- rename(data, c('raw_welfare.h10_g3'='gender'))
data <- rename(data, c('raw_welfare.h10_g4'='birth'))
data <- rename(data, c('raw_welfare.h10_g10'='marriage'))
data <- rename(data, c('raw_welfare.h10_g11'='religion'))
data <- rename(data, c('raw_welfare.h10_eco9'='code_job'))
data <- rename(data, c('raw_welfare.p1002_8aq1'='income'))
data <- rename(data, c('raw_welfare.h10_reg7'='code_region'))

table(is.na(data))

colSums(is.na(data))

colSums(!is.na(data))

#2번

#기준1 
table(data$gender)
# 1 , 2를 제외한 값 없으므로 이상치 없음

#기준 2 ifany 사용해도 같으므로 결측치 없음
table(data$gender, useNA='ifany')

#기준 3

data$gender <- ifelse(data$gender=='1','male','female')

data$gender <- as.factor(data$gender)

table(data$gender)

# 기 준 4
data %>% 
  group_by(gender) %>% 
  summarise(n=n()) %>%  
  ggplot(aes(x=gender,y=n, fill=gender) ) +
  geom_bar(stat='identity')

# 기준 5
summary(data$income)

data %>% 
  filter(is.na(income)== FALSE ) %>% 
  ggplot(aes(y=income)) +
  geom_boxplot(notch=T)


# 기준 6
data$income <- ifelse(data$income==0,
                                  NA,
                                  data$income)

table(data$income)

data %>% 
  filter(is.na(income)== FALSE ) %>% 
  ggplot(aes(y=income)) +
  geom_boxplot(notch=T)

# 기준 7
data %>% 
  filter(is.na(income)== FALSE ) %>% 
  group_by(gender) %>% 
  summarise(mean_income=mean(income)) 

data %>% 
  filter(is.na(income)== FALSE ) %>% 
  group_by(gender) %>% 
  summarise(mean_income=mean(income)) %>% 
  ggplot(aes(x=gender, y=mean_income, fill=gender)) +
  geom_col()

a <- data[data$gender=='male','income']

b <- data[data$gender=='female','income']

var.test(income~gender, data=data)

t.test(income~gender, data=data, var.equal=F)
# F가 0.05보다큰 0.4 이므로 성별에 따라 차이가 있다.


#3번 

# 기준1
colSums(is.na(data))

summary(data$birth)

ggplot(data, aes(y=birth)) +
  geom_boxplot(notch=T) 

# 기준2

nowYear <- as.numeric(format(Sys.time(), "%Y"))  

data$age <- nowYear - data$birth


# 기준3
ggplot(data, aes(x=age, y=income)) +
  geom_smooth()


# 기준4
fit <- lm(income ~ age, data=data)
fit
anova(fit)
# f가 0.05보다 작으므로 연관이 없는것으로 나옴

#문 4
# 기준 1
data$agegrade <-ifelse(data$age<=30,'young',ifelse(data$age>=61,'old','middle'))

data$agegrade <- factor(data$agegrade, levels=c('young','middle','old'))

# 기준 2

data %>% 
  group_by(agegrade) %>% 
  summarise(mean_income=mean(income, na.rm = TRUE)) %>% 
  ggplot(aes(x=agegrade, y=mean_income, fill=agegrade))+
  geom_col()

#기준3

data %>% 
  filter(is.na(income)==FALSE) %>% 
  ggplot(aes(x=agegrade, y=income, fill=agegrade))+
  geom_point() +
  geom_boxplot() +
  geom_violin()

result <- aov(income ~ agegrade, data=data , na.rm = TRUE)

result

#0.05보다 크므로 영향이 있다.






  

  


