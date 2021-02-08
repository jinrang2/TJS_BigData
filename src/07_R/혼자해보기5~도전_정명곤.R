#5 혼자해보기
#Q1
fuel <- data.frame(fl=c('c','d','e','p','r'),
                   price_fl=c(2.35,2.38,2.11,2.76,2.22)
)

fuel

mpg2 <- left_join(mpg,fuel,by='fl')

mpg2




#Q2
head(mpg2[c('model','fl','price_fl')],5)

#분석도전

#문제1 
# adult per total -> apt(성년 인구 백분율)
mw <- data.frame(ggplot2::midwest)
mw$apt <- round(mw$popadults / mw$poptotal * 100,2) 
head(mw[,c('popadults', 'poptotal', 'apt' )])


# 문제2 (a)
# 100 - apt -> 미성년 인구 백분율
100 - head(mw[order(mw$apt),'apt'])

#문제3
# kid_Ratio_Grade -> krg

mw$krg <- ifelse( 100-mw$apt>=40,'large',ifelse( 100-mw$apt<30,'small','middle' ))

mw[,c('popadults', 'poptotal', 'apt', 'krg' )]

#문제4
# asian per total -> aspt
mw$aspt <- round(mw$popasian / mw$poptotal * 100,2) 
head(mw[order(mw$aspt),c('state','county','aspt')],10)





??iris

library(help='dplyr')

methods('as')

args(as.data.frame)
  
