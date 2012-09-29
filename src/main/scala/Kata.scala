package com.blogspot.marcinderylo.kata

object PrimeFactors {

  def apply(n:Int) : List[Int] = 
    if (n == 1) 
      Nil 
    else
      if(n % 2 == 0) 
        2 :: apply(n / 2) 
      else if (n % 3 == 0)
        3 :: apply(n / 3)
      else
        List(n)
}
