package com.blogspot.marcinderylo.kata

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
object PrimeFactors {

  def apply(n:Int) : List[Int] = {
    @tailrec
    def startWithCandidate(primeFactorsSoFar:ListBuffer[Int], candidate:Int, n : Int) : ListBuffer[Int] = {
      if (n == 1)
        primeFactorsSoFar
      else
        if (n % candidate == 0)
          startWithCandidate(primeFactorsSoFar += candidate, candidate, n / candidate)
        else
          startWithCandidate(primeFactorsSoFar, candidate + 1, n)
    }  
    startWithCandidate(ListBuffer.empty, 2, n).toList
    }
}
