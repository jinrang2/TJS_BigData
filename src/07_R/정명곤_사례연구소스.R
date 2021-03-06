############################################
# 빅데이터 분석 결과 시각화 사례 연구 소스
############################################

#1 koweps hpc10 2015_beta5.sav로드하여 변수명 변경
getwd()


# read.spss()함수 사용 목적
install.packages("foreign")

library(foreign)
library(dplyr)
library(ggplot2)


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
  ggplot(aes(x=gender, y=income)) +
  geom_point(position = 'jitter') +
  geom_violin() +
  geom_boxplot(notch=T) +
  coord_cartesian(ylim=c(0,1000))

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
# F가 0.05보다 작은 2.2e-16 이므로 성별에 따라 차이가 있다.


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
# f가 0.05보다 작으므로 나이에 연관이 없다 라는 가설을 기각한다

#문 4-1
data$agegrade <-ifelse(data$age<=30,'young',ifelse(data$age>=61,'old','middle'))

data$agegrade <- factor(data$agegrade, levels=c('young','middle','old'))

#문 4-2

data %>% 
  group_by(agegrade) %>% 
  summarise(mean_income=mean(income, na.rm = TRUE)) %>% 
  ggplot(aes(x=agegrade, y=mean_income, fill=agegrade))+
  geom_col()

#문4-3

data %>% 
  filter(is.na(income)==FALSE) %>% 
  ggplot(aes(x=agegrade, y=income, fill=agegrade))+
  geom_point() +
  geom_violin() +
  geom_boxplot(notch=T) +
  coord_cartesian(ylim=c(0,1000))

#문 4-4
result <- aov(income ~ agegrade, data=data , na.rm = TRUE)

result

#0.05보다 크므로 영향이 있다.


#문 5-1
colSums(is.na(data))

#문 5-2
data %>% 
  filter(is.na(income)==FALSE) %>% 
  group_by(agegrade, gender) %>% 
  summarise(mean_income = mean(income), sd_income = sd(income), n=n())
  

#문5-3
data %>% 
  filter(is.na(income)==FALSE) %>% 
  group_by(agegrade, gender) %>% 
  summarise(mean_income = mean(income), sd_income = sd(income), n=n()) %>% 
  ggplot(aes(x=agegrade, y=mean_income,fill=gender)) +
  geom_col(position = "dodge")


#문6-1
data %>% 
  filter(is.na(income)==FALSE) %>% 
  group_by(age, gender) %>% 
  summarise(mean_income   = mean(income), 
            sd_income     = sd(income), 
            median_income = median(income), 
            max_income    = max(income), 
            min_income    = min(income), 
            n=n()) 

#문6-2

data %>% 
  filter(is.na(income)==FALSE) %>% 
  group_by(gender, age) %>% 
  summarise(mean_income   = mean(income)) %>% 
  ggplot(aes(x=age, y=mean_income, fill=gender)) +
  geom_line(aes(color=gender),stat = 'identity') +
  geom_point(aes(color=gender),stat = 'identity') +
  scale_color_manual(values = c('red','blue'))  +
  theme(legend.position = "bottom")

ggsave('ex6-2.png')
  
#문7-1

library('readxl')
getwd()

codejob <- read_excel("inData/Koweps/Koweps_Codebook.xlsx")

data2 <-right_join(data,codejob,by='code_job')

data2 %>% 
  filter(is.na(income)==FALSE) %>% 
  group_by(job) %>% 
  summarise(mean_income   = mean(income), 
            sd_income     = sd(income), 
            n=n()) %>% 
  arrange(desc(mean_income))


#문7-2
data2 %>% 
  filter(is.na(income)==FALSE | is.na(job)==FALSE) %>% 
  group_by(job) %>% 
  summarise(mean_income   = mean(income), 
            sd_income     = sd(income), 
            n=n()) %>% 
  arrange(desc(mean_income)) %>% 
  head(10) %>% 
  ggplot(aes(x=mean_income, y=reorder(job,mean_income)))+
  geom_col()

ggsave('top10.png')

#문7-3
data2 %>% 
  filter(is.na(income)==FALSE | is.na(job)==FALSE) %>% 
  group_by(job) %>% 
  summarise(mean_income   = mean(income), 
            sd_income     = sd(income), 
            n=n()) %>% 
  arrange(mean_income) %>% 
  head(10) %>% 
  ggplot(aes(x=mean_income, y=reorder(job,-mean_income)))+
  geom_col()


ggsave('bot10.png')

#문 8-1
data2 %>% 
  filter(is.na(job)==FALSE) %>% 
  group_by(job) %>% 
  summarise(n=n()) %>% 
  arrange(n) %>% 
  head(10)


#문 8-2
data2 %>% 
  filter(is.na(job)==FALSE) %>% 
  group_by(job) %>% 
  summarise(n=n()) %>% 
  arrange(-n) %>% 
  head(10)


#문 9-1
table(data$religion)


table(is.na(data$religion))

#문 9-2
data$religion <-ifelse(data$religion=='1','종교-유',ifelse(data$religion=='2','종교-무',data$religion))

table(data$religion)

data$religion <- as.factor(data$religion)

#문 9-3

table(data$marriage)




data$marriage_group <- ifelse(data$marriage == '1','기혼',ifelse(data$marriage=='3','미혼',NA))

table(data$marriage_group)

table(is.na(data$marriage_group))

#문 9-4

data %>% 
  group_by(religion, marriage_group) %>% 
  summarise(n=n()) %>%
  
#문 9-5
data %>% 
  group_by(religion, marriage_group) %>% 
  summarise(n=n()) %>%
  ggplot(aes(x=religion, y=n, fill=marriage_group)) +
  geom_col()

#문 10-1
table(data$code_region)

table(is.na(data$code_region))

#문 10-2
data$region <- ifelse(data$code_region == '1','서울',
       ifelse(data$code_region=='2','수도권(인천/경기)',
              ifelse(data$code_region=='3','부산/경남/울산',
                     ifelse(data$code_region=='4','대구/경북',
                            ifelse(data$code_region=='5','대전/충남',
                                   ifelse(data$code_region=='6','강원/충북',
                                          ifelse(data$code_region=='7','광주/전남/전북/제주도',NA)))))))



table(data$region)

table(is.na(data$region))

#문 10-3
data %>% 
  group_by(region, agegrade) %>% 
  summarise(n=n()) %>% 
  ggplot(aes(x=region, y=n, fill=agegrade)) +
  geom_col(position='dodge')


#문 10-4
data %>%
  filter(agegrade=='old') %>% 
  group_by(region, agegrade) %>% 
  summarise(n=n()) %>% 
  ggplot(aes(x=region, y=n, fill=agegrade)) +
  geom_col(position='dodge')



