// Part 1 about the 3n+1 conjecture
//=================================


//(1) Complete the collatz function below. It should
//    recursively calculate the number of steps needed 
//    until the collatz series reaches the number 1.
//    If needed, you can use an auxiliary function that
//    performs the recursion. The function should expect
//    arguments in the range of 1 to 1 Million.
def collatz_rec(n: (Long, Long)) : (Long,Long) = {
  if (n._1 <= 1){
    n
  }
  else if (n._1 % 2 == 0){
    collatz_rec(n._1/2, n._2 + 1)
  }
  else{
    collatz_rec(3*n._1 +1, n._2 + 1)
  }
}
def collatz(n: Long) : Long = {
  val pair = collatz_rec(n, 0)
  pair._2
}


//(2)  Complete the collatz_max function below. It should
//     calculate how many steps are needed for each number 
//     from 1 up to a bound and then calculate the maximum number of
//     steps and the corresponding number that needs that many 
//     steps. Again, you should expect bounds in the range of 1
//     up to 1 Million. The first component of the pair is
//     the maximum number of steps and the second is the 
//     corresponding number.

def collatz_max(bnd: Long) : (Long, Long) = { 
  val collatzList = for (n <- 1L to bnd) yield (collatz(n),n)
  collatzList.maxBy(_._1)
}

