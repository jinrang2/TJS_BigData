#################################
# 14장. 지도 시각화
#################################
install.packages("ggiraphExtra")
library(ggiraphExtra)

install.packages("mapproj") # ggChoropleth 함수 사용을 위한 패키지지
library(mapproj)
install.packages('maps')
library(maps)
library(ggplot2)
library(ggiraphExtra)
library(tibble)

# 2 행이름을 변수로
head(USArrests,1)

crime <- rownames_to_column(USArrests, var='state')
class(crime)
head(crime,3)
# 미국 지도 주 정보 가져오기
state_map <- map_data('state')

View(map_data('state'))

ggChoropleth(data=crime,
             aes(fill=Assault, map_id=state),
             map=state_map,
             interactive=T
)

?map_data

install.packages('stringi')
install.packages('devtools')
devtools::install_github('cardiomoon/kormaps2014')

library(kormaps2014)
head(korpop1)

# korpop1 : 2015년 센서스 데이터 (시도별)
# korpop2 : 2015년 센서스 데이터 (시군구별)
# korpop3 : 2015년 센서스 데이터 (읍면동별)


str(changecode(korpop1)) # utf-8로 인코딩 된 데이터를 cp949로 변환후 출력

kormap1

head(kormap1)
changeCode(kormap1)
head(changeCode(kormap1))
korpop1

str(korpop1)

changeCode(korpop1[,c('name','pop','code')])

korpop1


korpop1


korpop1$name <- iconv(korpop1$name, 'UTF-8','CP949')

ggChoropleth(data = korpop1,       # 지도에 표현할 데이터
             aes(fill = pop,       # 색깔로 표현할 변수
                 map_id = code,    # 지역 기준 변수
                 tooltip = name),  # 지도 위에 표시할 지역명
             map = kormap1,        # 지도 데이터
             interactive = T)        

library(ggplot2)
library(ggiraphExtra)

library(kormaps2014)

head(changeCode(tbc))

changeCode(tbc)

tbc

tbc$name <- iconv(tbc$name, 'UTF-8','CP949')
tbc$name1 <- iconv(tbc$name1, 'UTF-8','CP949')

ggChoropleth(data = tbc,       # 지도에 표현할 데이터
             aes(fill = NewPts,       # 색깔로 표현할 변수
                 map_id = code,    # 지역 기준 변수
                 tooltip = name),  # 지도 위에 표시할 지역명
             map = kormap1,        # 지도 데이터
             interactive = T)        


kormap2

