#################################
# 12장. 텍스트 마이닝
#################################

# 문자로 된 비정형 데이터로부터 가치 있는 정보를 얻어내는 분석:
# 1. 형태소 분석

install.packages("rJava")
install.packages("memoise")
install.packages("KoNLP")

# google에서 KoNLP검색


#우측의 packages->install도구를 이용해서 install하기 위해
install.packages("devtools")

# KoNLP가 의존하는 package 미리 install
install.packages("hash")
install.packages("tau")
install.packages("Sejong")

#package -> install 도구를 이용하여 KoNLP 패키지를 install
library(KoNLP)


Sys.getenv("JAVA_HOME")

useNIADic() #사전 설정하기

extractNoun('대한민국의 영토는 한반도와 그 부속 도서로 한다')
extractNoun('의미있는 하루 하루, 알차고 환희찬 하루 감사해요')

# 1. 힙합 가사 텍스트 마이닝
txt <- readLines('inData/hiphop.txt')
txt
head(txt)

# 1.2 특수문자 추출
# gsub(oldStr, newStr, string)
# str_replace_all(string, oldStr, newStr)
library(stringr)
temp <- gsub('\\W',' ',txt)
txt <- str_replace_all(txt,'\\W',' ')

table(temp==txt)
# 1.3 명사 추출
nouns <- extractNoun(txt)

nouns

class(nouns)
head(unlist(nouns))

wordcount <- table(unlist(nouns)) # 단어 빈도

class(wordcount)
sort(wordcount)

df_word <- as.data.frame(wordcount, stringsAsFactors = F)

head(df_word,20)
str(df_word)
library(dplyr)
df_word <- rename(df_word, word=Var1, freq=Freq)
str(df_word)
head(df_word)
table(df_word)
nrow(df_word)

df_word <- filter(df_word, nchar(word)>=2) # nchar 문자수 반환
head(df_word)

top20 <- df_word[order(-df_word$freq),][1:20,]

top20$word                 
                 
top20 <- df_word %>% 
  arrange(desc(freq)) %>% 
  head(20)

# 자주 사용되는 단어 top20 그래프 그리기
library(ggplot2)

ggplot(top20, aes(x=freq, y=reorder(word, freq))) + 
  geom_col() +
  geom_text(aes(label=freq), hjust=-0.5, col='red')


library(RColorBrewer)

#워드 클라우드
# 1. 비정형 text 데이터 확보
# 2.패키지 설치 및 로드(KoNLP, wordcloud)
# 3.확보된 데이터 읽어오기
# 4. 명사 추출
# 5. 필요없는 데이터 삭제(특수문자, zz.ㅋㅋ. ㅎㅎ, 숫자등...)
# 6. 워드 카운트생성
# 7. wordcloud 함수 이용해서 워드 클라우드 생성성
  

# 2. 국정원 트윗 텍스트 마이닝

install.packages("wordcloud")

library(wordcloud)


set.seed(1234) #난수 생성 결과를 일치시키려고

round(runif(6, min=1, max=45 )) # 확인

display.brewer.all()

pal <- brewer.pal(8,"Dark2")  

set.seed(1234)                   # 난수 고정

wordcloud(words = df_word$word,  # 단어
          freq = df_word$freq,   # 빈도
          min.freq = 2, #최소 단어 빈도
          max.words = 200, #표현될 최대 단어수
          random.order =F, # 최빈 단어를 중앙 배치
          rot.per =0.1,  # 회전 단어 비율
          scale=c(4,0.3),
          colors = pal)# 단어 크기 범위

pal <- brewer.pal(8,"Blues")[5:9]

wordcloud(words = df_word$word,  # 단어
          freq = df_word$freq,   # 빈도
          min.freq = 2, #최소 단어 빈도
          max.words = 200, #표현될 최대 단어수
          random.order =F, # 최빈 단어를 중앙 배치
          rot.per =0.1,  # 회전 단어 비율
          scale=c(4,0.3),
          colors = pal)# 단어 크기 범위


# 2. 국정원 트윗 데이터 텍스트 마이닝닝
rm(list=ls())
twitter <- read.csv('inData/twitter.csv')

head(twitter)
View(twitter)


twitter <- rename(twitter, no=번호, id=계정이름, date=작성일, tw=내용)



#필요없는 문자 ,단어 삭제하기
twitter$tw <- str_replace_all(twitter$tw, '\\W',' ')
twitter$tw <- str_replace_all(twitter$tw, '[ㄱ-ㅎ]',' ')

nouns <-extractNoun(twitter$tw)


wordcount <- table(unlist(nouns))

df_word <- as.data.frame(wordcount, stringsAsFactors = FALSE)  
str(df_word)


df_word <-rename (df_word, word=Var1, freq=Freq)
head(df_word)
str(df_word)

# 출현 단어중 2글자 이상만 분석
df_word <- filter(df_word, nchar(word)>1)
head(df_word)

top20 <- df_word[order(-df_word$freq),][1:20,]

top20$word                 

top20 <- df_word %>% 
  arrange(desc(freq)) %>% 
  head(20)


ggplot(top20, aes(x=freq, y=reorder(word, freq))) + 
  geom_col() +
  geom_text(aes(label=freq), hjust=-0.2, col='red')

# 워드 클라우드 그리기

set.seed(1234)

pal <- brewer.pal(9,'Blues')[5:9]

wordcloud(words = df_word$word,
          freq = df_word$freq,
          min.freq =5,
          max.words =200,
          random.order=F,
          rot.per = 0.1,
          scale = c(4,0.3),
          colors = pal)
          

# 글 게시수가 150회 이상 트윗한 게시물에 대해 최빈 top20개 단어를
#출력 시각화 하고 워드 클라우드를 완성하시


temp <- twitter %>% 
  group_by(id) %>% 
  summarise(n=n())

temp %>% 
  filter(n<150) %>% 
  ggplot(aes(x=id,y=n)) +
  geom_col()

temp2 <- temp %>% 
  filter(n<150) 

temp3 <- twitter %>% 
  filter(id %in% temp2$id)

#필요없는 문자 ,단어 삭제하기
temp3$tw <- str_replace_all(temp3$tw, '\\W',' ')
temp3$tw <- str_replace_all(temp3$tw, '[ㄱ-ㅎ]',' ')

nouns <-extractNoun(temp3$tw)


wordcount <- table(unlist(nouns))

df_word <- as.data.frame(wordcount, stringsAsFactors = FALSE)  
str(df_word)


df_word <-rename (df_word, word=Var1, freq=Freq)
head(df_word)
str(df_word)

# 출현 단어중 2글자 이상만 분석
df_word <- filter(df_word, nchar(word)>1)
head(df_word)

top20 <- df_word[order(-df_word$freq),][1:20,]

ggplot(top20, aes(x=freq, y=reorder(word, freq))) + 
  geom_col() +
  geom_text(aes(label=freq), hjust=-0.2, col='red')

set.seed(12341)

display.brewer.all()

pal <- brewer.pal(9,'Blues')[5:9]

wordcloud(words = df_word$word,
          freq = df_word$freq,
          min.freq =5,
          max.words =200,
          random.order=F,
          rot.per = 0.1,
          scale = c(4,0.3),
          colors = pal)





