package com.blogspot.marcinderylo.kata

import org.scalatest.FunSuite

class KataTest extends FunSuite {
        test("prime factors of 1") {
                assert(PrimeFactors(1) === Nil)
        }
}
