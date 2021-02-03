fact <- function(num) {
  sum <- 1
  if(num < 0){
    cat("음수값을 위한 팩토리얼은 존재하지 않아요")
  } else{
    for (idx in 1:num){
      sum = sum * idx
    }
  }
  cat(sum)
}
