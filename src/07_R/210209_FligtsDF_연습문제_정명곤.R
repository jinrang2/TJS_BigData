library(data.table)

fs <- fread("inData/flights14.csv")
flights <- fread("inData/flights14.csv")

class(flights)

fs

# 1. origin이 JFK이고 month가 5월인 모든 행을 resul에 얻는다
resul <- subset(fs, fs$origin=='JFK' & fs$month==5)

# 2. 처음 두 행을 resul에 얻는다
resul <- head(fs,2)

# 3. origin으로 오름차순, desc로 내림차순으로 정렬하여 출력
fs[order(fs$origin),]

fs[order(desc(fs$origin)),]


# 4. arr_delay열만 출력
fs$arr_delay

# 5. year열부터 dep_time열까지 출력
fs[,1:4]


# 6. year열과 dep_time열 출력
fs[,c('year','dep_time')]


# 7. arr_delay열과 dep_delay열을 출력하되 열이름을 delay_arr과 delay_dep로 변경

library(dplyr)
fs$arr_delay

fs <- rename(fs, c(delay_arr=arr_delay,delay_dep=dep_delay))

flights[, .(delay_arr=arr_delay, delay_dep=dep_delay)]


# 8. 지연시간(arr_delay, dep_delay모두 0미만인 비행이 몇 번인지 출력
nrow(subset(fs, arr_delay <0 & dep_delay<0))

flights[arr_delay<0 & dep_delay<0, .(.N)]
flights[arr_delay<0 & dep_delay<0, .(cnt=.N)]

# 9. 6월에 출발 공항이 JFK인 모든 항공편의 도착지연 및 출발지연 시간의 평균을 계산
str(fs)

fs9 <- apply(subset(fs, origin=='JFK' & month==6)[,c('dep_delay','arr_delay')],2,mean)
fs9

flights[origin=='JFK' & month==6, .(mean(arr_delay), mean(dep_delay))]

# 10. 9번의 결과에 title에 mean_arr, mean_dep로 출력

names(fs9) <-  c('mean_arr','mean_dep')

fs9


flights[origin=='JFK' & month==6, .(mean_arr=mean(arr_delay), mean_dep=mean(dep_delay))]

# 11. JFK 공항의 6월 운항 횟수
fs11 <- subset(fs, origin=='JFK' & month==6)
nrow(fs11)

flights[origin=='JFK'&month==6 , .(.N)]

# 12. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 출력
fs11[,c(5,7)]

flights[origin=='JFK'&month==6 , c(arr_delay, dep_delay)]

# 13. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 제외한 모든 열 출력
fs11[,c(-5,-7)]

flights[origin=='JFK'&month==6 , -c("arr_delay", "dep_delay")]  # df

# 14. 출발 공항(origin)별 비행 수 출력 (JFK 81483 LGA 84433 EWR 87400)
# dplyr 안쓰고 합을 위해 count 변수 하나 추가함
fs$count <- 1 
table(fs$origin)
tapply(fs$count, fs$origin , sum)

flights[, .(.N), by=.(origin)]


# 15. 항공사코드(carrier)가 AA에 대해 출발공항별 비행횟수 계산
table(subset(fs, fs$carrier=='AA')$origin)


fs16 <- subset(fs, fs$carrier=='AA')

tapply(fs16$count, fs16$origin, sum)

flights[carrier=='AA', .(.N), by=.(origin)]

flights[carrier=='AA', .(.N), keyby=.(origin)]

# 16. origin, dest별로 비행횟수 출력

library(doBy)

summaryBy(count ~ origin+dest, fs, FUN=sum)


flights[, .(.N), by=.(origin, dest)]

# 17. 항공사코드(carrier)가 AA에 대해 origin, dest별로 비행횟수 출력
fs17temp <- subset(fs, fs$carrier=='AA')

summaryBy(count ~ origin+dest, fs17temp, FUN=sum)

flights[carrier=='AA', .(.N), by=.(origin, dest)]
# 18. 항공사 코드가 AA에 대해, origin, dest, 월별 평균arr_delay, 평균 dep_delay 출력

summaryBy(arr_delay+dep_delay ~ origin+dest+month, subset(fs,carrier=='AA'), FUN=mean)

flights[carrier=='AA', .(mean_arr_delay=mean(arr_delay), mean_dep_delay=mean(dep_delay)), by=.(origin, dest, month)]



# 19. dep_delay>0가 참이거나 거짓, arr_delay>0가 참이거나 거짓인 각각의 비행횟수
fs$dep_delay_yn <- ifelse(fs$dep_delay >0 , TRUE, FALSE)
fs$arr_delay_yn <- ifelse(fs$arr_delay >0 , TRUE, FALSE)

summaryBy(count ~ dep_delay_yn + arr_delay_yn, fs, FUN=sum)

table(fs$dep_delay >0, fs$arr_delay >0)

flights[, .(.N), .(fs$dep_delay >0, fs$arr_delay >0)]
# 20. Origin==“JFK”에 대해 월별 최대 출발 지연 시간 출력(month로 정렬
fs_JKF <- subset(fs, fs$origin=='JFK')

tapply(fs_JKF$dep_delay , -fs_JKF$month, max)

flights[origin=='JFK', .(max(dep_delay)), keyby=.(month)]


?data.table


