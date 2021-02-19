#################################
# 13장. 웹 데이터 수집
#################################
# 1. 정적 웹크롤링
install.packages("rvest")
library(rvest)


url <- 'https://movie.naver.com/movie/point/af/list.nhn'

# 영화제목 ; .movie
nodes <- html_nodes(text, '.movie')
title <- html_text(nodes)
title


# 해당 영화 페이지
movieInfo <- html_attr(nodes, 'href')
movieInfo <- paste0(url, movieInfo)
movieInfo

# 평점 ; .list_netizen_score em
nodes <- html_nodes(text, ".list_netizen_score em")
nodes
point <- html_text(nodes)
point
# 영화 리뷰 ; .title
nodes <- html_nodes(text,'.title')
nodes

review <- html_text(nodes,trim=TRUE)
review

review <- gsub('\t','',review)
review <- gsub('\n','',review)
review <- gsub('신고','',review)

review

review_content <- unlist(strsplit(review,' - 총 10점 중[0-9]{1,2}'))
review_content

split(review, is.na(' - 총 10점 중[0-9]{1,2}'))

split(review, ' - 총 10점 중[0-9]{1,2}')


review_content <- unlist(strsplit(review,' - 총 10점 중[0-9]{1,2}'))[seq(2,20,2)]
review_content

table(is.na(review_content))

idx <- regexpr('중[0-9]{1,2}',review)

idxend <- unlist(attributes(idx))

substr(review, idx+1, idxend)

point <- substr(review, idx+1, (idx+idxend-1))

page <- cbind(title, movieInfo)
page <- cbind(page, point)
page <- cbind(page, review_content)
View(page)

write.csv(page,"outData/movie_review.csv")



# 전체 페이지
home <- 'https://movie.naver.com/movie/point/af/list.nhn'
site <- 'https://movie.naver.com/movie/point/af/list.nhn?page='

movie.review <- NULL

for(i in 1:2){
  url <- paste0(site,i);
  text <- read_html(url, encoding = 'CP949')
  
  nodes <- html_nodes(text, '.movie')
  title <- html_text(nodes)
  title
  
  # 해당 영화 페이지
  movieInfo <- html_attr(nodes, 'href')
  movieInfo <- paste0(url, movieInfo)
  movieInfo
  
  # 평점 ; .list_netizen_score em
  nodes <- html_nodes(text, ".list_netizen_score em")
  nodes
  point <- html_text(nodes)
  point
  # 영화 리뷰 ; .title
  nodes <- html_nodes(text,'.title')
  nodes
  
  review <- html_text(nodes,trim=TRUE)
  review
  
  review <- gsub('\t','',review)
  review <- gsub('\n','',review)
  review <- gsub('신고','',review)
  review
  
  review_content <- unlist(strsplit(review,'중[0-9]{1,2}'))[seq(2,20,2)]
  
  
  review_content[is.na(review_content)] <- '리뷰없음'
  
  unlist(strsplit(review,'중[0-9]{1,2}'))
  
  review_content
  
  idx <- regexpr('중[0-9]{1,2}',review)
  
  idxend <- unlist(attributes(idx))
  
  substr(review, idx+1, idxend)
  
  point <- substr(review, idx+1, (idx+idxend-1))
  
  page <- cbind(title, movieInfo)
  print(movieInfo)
  page <- cbind(page, point)
  print(point)
  page <- cbind(page, review_content)
  print(review_content)
  
  
  movie.review <- rbind(movie.review, page)
}

write.csv(movie.review,"outData/movie_review100.csv")


# 필요한 패키지 다운로드와 로드
install.packages("RSelenium")
library(httr)
library(rvest)
library(RSelenium)

# 셀레니움 동적 웹 크롤링 준비
remDr <- remoteDriver(port=4445L, # 포트번호 
                      browserName='chrome') # 사용할 브라우저
remDr$open()
remDr$navigate('https://www.youtube.com')

welElem <- remDr$findElement(using='css',
                             '#search')
welElem$sendKeysToElement(list('과학 다큐 비욘드', key='enter'))

# 현재 페이지의 html 소스 가져오기
html <- remDr$getPageSource()[[1]] 
html <- read_html(html)

# '#video-title' css 안의 text 가져오기
youtube_title <- html %>%  html_nodes('#video-title') %>% html_text()
youtube_title[1:5]

# 필요없는 문자들 정리
youtube_title <- gsub('\n', '', youtube_title)
youtube_title <- trimws(youtube_title)
youtube_title[1:5]

youtube_title_url <- html %>% html_nodes('#video-title') %>% html_attr('href')
youtube_title_url[1:10]

youtube_title_url <-
  ifelse(is.na(youtube_title_url), '',
         paste0('https://www.youtube.com', youtube_title_url))

# youtube_title만 text파일로 out
write.table(youtube_title,
            file='outData/과학다큐결과.txt',
            sep=',',
            row.names=FALSE,
            quote=FALSE)

write.csv(result, file='outData/과학다큐결과.csv',
          row.names=F)

# 예제1. 몇번 마우스 스크롤 다운한 후 크롤링(댓글)

remD <- remoteDriver(port=4445L, # 포트번호 
                      browserName='chrome') # 사용할 브라우저
remD$open()
remD$navigate('https://youtu.be/tZooW6PritE')

btn <- remD$findElement(using='css selector',
                        value='.html5-main-video')

btn$clickElement()

#마우스 스크롤 다운
remD$executeScript('window.scrollTo(0,500)')
remD$executeScript('window.scrollTo(500,1000)')
remD$executeScript('window.scrollTo(1000,1500)')
remD$executeScript('window.scrollTo(1000,2000)')
remD$executeScript('window.scrollTo(1000,2500)')
remD$executeScript('window.scrollTo(1000,3000)')


#현재 페이지의 html 소스 가져오기
html <- remD$getPageSource()[[1]]
html <- read_html(html)

comments <- html %>%  html_nodes('#content-text') %>%  html_text()
comments

write.table(comments,
            file='outData/댓글.txt',
            sep=',',
            row.names=FALSE,
            quote=FALSE)



