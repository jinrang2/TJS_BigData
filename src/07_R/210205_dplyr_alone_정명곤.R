# mpg 데이터를 이용해 분석 문제를 해결해 보세요.

#혼자1 q1

mpg$displ_div <- ifelse(mpg$displ<=4,'low','')
mpg$displ_div2 <- ifelse(mpg$displ>=5,'high','')

head(mpg)

mpg %>% 
  group_by(displ_div, displ_div2) %>% 
  summarise(mean_highway = mean(highway))


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
mpg$count <- 1
  
mpg %>% 
  filter(class == "compact") %>% 
  group_by(manufacturer) %>% 
  summarise(n_count = sum(count)) %>% 
  arrange(-n_count)
    

