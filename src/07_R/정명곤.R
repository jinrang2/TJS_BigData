# datasets::cars데이터 셋을 이용하여 속도에 대한 제동거리의 산점도와 적합도(신뢰구간
# 그래프)를 나타내시오(단, 속도가 5부터 20까지 제동거리 0부터 100까지만 그래프에 나타

library('ggplot2')
library(gapminder)
library(dplyr)

cars

ggplot(cars, aes(x=speed, y= dist)) +
  geom_point() +
  geom_smooth(method='loess') +
  coord_cartesian(ylim=c(0,100), xlim=c(5,20))
  

# 2. gapminder::gapminder 데이터 셋을 이용하여 1인당국내총생산에 대한 기대수명의 산점
# 도를 대륙별 다른 색으로 나타내시오.
str(gapminder)
head(gapminder)

ggplot(gapminder, aes(x=gdpPercap, y=lifeExp)) +
  geom_point(aes(color=continent))

# 3. gapminder::gapminder 데이터 셋을 이용하여 개대 수명이 70을 초과하는 데이터에 대해
# 대륙별 데이터 갯수
gapminder %>% 
  filter(lifeExp > 70) %>% 
  group_by(continent) %>% 
  summarise(n = n()) %>% 
  ggplot(aes(x=continent, fill=continent, y=n)) +
  geom_bar(stat='identity')

# 4. gapminder::gapminder 데이터 셋을 이용하여 기대수명이 70을 초과하는 데이터에 대해
# 대륙별 데이터 빈도 

gapminder %>% 
  filter(lifeExp > 70) %>% 
  group_by(continent) %>% 
  summarise(n = n_distinct(country)) %>% 
  ggplot(aes(x=continent, fill=continent, y=n)) +
  geom_bar(stat='identity')


# 5. gapminder::gapminder 데이터 셋을 이용하여 대륙별 기대수명의 사분위수를 시각화
ggplot(gapminder, aes(x=continent, col=continent, y=lifeExp)) +
  geom_boxplot()


# 6. gapminder::gapminder 데이터 셋을 이용하여 년도별로 gdp와 기대수명과의 관계를 
#산점도를 그리고 대륙별 점의 색상을 달리 시각화
#gapminder %>% 
  #group_by(year, continent) %>% 
#  summarise(mean_gdp=mean(gdpPercap), mean_lifeExp  = mean(lifeExp)) %>% 

  ggplot(gapminder, aes(x=gdpPercap, y=lifeExp)) +
  geom_point(aes(color=continent), stat='identity') +
  facet_wrap(~year) +
  coord_cartesian(xlim=c(0,40000))



# 7. gapminder::gapminder 데이터 셋에서 북한과 한국의 년도별 GDP 변화를 산점도로 시각
# 화하시오(북한:Korea, Dem. Rep. 한국:Korea, Rep. substr(str, start, end)함수 이용)
  
gapminder2 <- gapminder
  
gapminder2$country <- factor(gapminder2$country, levels = rev(levels(gapminder2$country)))
  
gapminder2 %>% 
  filter(country == 'Korea, Rep.' | country == 'Korea, Dem. Rep.') %>% 
  arrange(desc(country)) %>% 
  ggplot(aes(x=year, y=gdpPercap, shape=country)) +
  geom_point(aes(color=country), stat='identity') +
  scale_color_manual(values = c('red','blue'))  +
  scale_shape_manual(values=c(3, 19)) +
  theme(legend.position = c(0.2,0.9))

# 8. gapminder::gapminder 데이터 셋을 이용하여 한중일 4개국별 GDP 변화를 산점도와
#추세선으로 시각화 하시오.


gapminder %>% 
  filter(country == 'Korea, Rep.' | country == 'Korea, Dem. Rep.' | country == 'Japan' | country == 'China') %>% 
  arrange(desc(country)) %>% 
  ggplot(aes(x=year, y=gdpPercap)) +
  geom_point(aes(color=country), stat='identity', size=3)  +
  geom_line(aes(color=country), stat='identity', size=1.1 )

# 9. gapminder::gapminder 데이터 셋에서 한중일 4개국별 인구변화 변화를 산점도와 추세선
# 으로 시각화 하시오(scale_y_continuous(labels = scales::comma)추가시 우측처럼)
str(gapminder)


gapminder %>% 
  filter(country == 'Korea, Rep.' | country == 'Korea, Dem. Rep.' | country == 'Japan' | country == 'China') %>% 
  arrange(desc(country)) %>% 
  ggplot(aes(x=year, y=pop)) +
  geom_point(aes(color=country), stat='identity', size=3)  +
  geom_line(aes(color=country), stat='identity', size=1.1 ) +
  scale_y_continuous(labels = scales::comma)

# 10.Ggplot2::economic 데이터 셋의 개인 저축률(psavert)가 시간에 따라 어떻게 변해 왔는지
# 알아보려 한다. 시간에 따른 개인 저축률의 변화를 나타낸 시계열 그래프와 추세선을 
#시각# 화하시오
str(economics)

ggplot(economics, aes(x=date, y=psavert)) +
  geom_line(color='red', size=2) +
  geom_smooth(color='brown') +
  labs(title='개인저축률 시계열 그래프', x="date")


temp <- as.data.frame(economics)


ggplot(economics, aes(x=date) ) +
  geom_line(aes(y=psavert), color='red', size=2) +
  geom_line(aes(y=uempmed), color='blue', size=2) +
  geom_smooth(aes(y=psavert),color='brown') +
  labs(title='개인저축률 시계열 그래프', x="date")


ggplot(economics, aes(x=date) ) +
  geom_line(aes(y=psavert), color='red', size=2) +
  geom_line(aes(y=unemploy*0.001), color='blue', size=2) +
  geom_smooth(aes(y=psavert),color='yellow') +
  geom_smooth(aes(y=unemploy*0.001), color='green', size=2) +
  scale_y_continuous(sec.axis = sec_axis(~.*1000,name='unemploy'))
  labs(title='개인저축률 시계열 그래프', x="date")



