# 1-1) 
dim(iris)
names(iris)
str(iris)

#1-2)
summary(iris)
nrow(iris)
ncol(iris)
head(iris$Sepal.Length,10)
iris[c(1:10),'Sepal.Length']
iris[c(1:10),'Sepal.Length',drop=FALSE]

#1-3)
subset(iris, iris$Species=='virginica')

subset(iris, iris$Species=='setosa')

#1-4)
rbind(subset(iris, iris$Species=='virginica'), subset(iris, iris$Species=='setosa'))


#2) 
subset(iris[1:2],iris$Species=='setosa')

#3)
x <- c(12000,26000,18000)
y <- c(5,4,9)
z <- c(7,3,2)

a <- x %*% y
cat(a)
b <- x %*% z
cat(b)


iris
