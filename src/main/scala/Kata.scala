package com.blogspot.marcinderylo.kata

object PrimeFactors {

  def apply(n:Int) : List[Int] = {
    def startWithCandidate(candidate:Int, n : Int) : List[Int] = {
      if (n == 1)
        Nil
      else
        if (n % candidate == 0)
          candidate :: startWithCandidate(candidate, n / candidate)
        else
          startWithCandidate(candidate + 1, n)
    }  
    startWithCandidate(2, n)
    }
}
