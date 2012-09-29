package com.blogspot.marcinderylo.kata

import org.scalatest.FunSuite

class KataTest extends FunSuite {
  test("prime factors of 1") {
    assert(PrimeFactors(1) === Nil)
  }
  test("prime factors of 2") {
    assert(PrimeFactors(2) === List(2))
  }
  test("prime factors of 3") {
    assert(PrimeFactors(3) === List(3))
  }
  test("prime factors of 4") {
    assert(PrimeFactors(4) === List(2, 2))
  }
  test("prime factors of 5") {
    assert(PrimeFactors(5) === List(5))
  }
  test("prime factors of 6") {
    assert(PrimeFactors(6) === List(2, 3))
  }
  test("prime factors of 8") {
    assert(PrimeFactors(8) === List(2, 2, 2))
  }
}
