package com.blogspot.marcinderylo.kata

import org.scalatest.FunSuite
import com.blogspot.marcinderylo.kata.Exercises._

class KataTest extends FunSuite {
  test("succ") {
    assert(1 === succ(0))
    assert(4 === succ(3))
    assert(-5 === succ(-6))
  }
  test("pred") {
    assert(0 === pred(1))
    assert(-7 === pred(-6))  
  }
  test("add") {
    assert(0 === add(0, 0))
    assert(2 === add(2, 0))
    assert(3 === add(2, 1))
    assert(1001 === add(600,401))
  }
  test("sum") {
    assert(0 === sum(Nil))
    assert(1 === sum(List(1)))
    assert(8 === sum(List(1,2,5)))
  }
  test("length") {
    assert(0 === length(Nil))
    assert(1 === length(List(1)))
    assert(3 === length(List(2,3,5)))
  }
  test("map") {
    def f (x : Int) = x * 2
    assert(map(Nil, f) === Nil)
    assert(map(List(2,4,7), f) === List(4, 8, 14))
  }
  test("filter") {
    def odd(x : Int) = x % 2 == 0
    assert(filter(Nil, odd) === Nil)
    assert(filter(List(1,3,5), odd) === Nil)
    assert(filter(List(1,2,3,4,5), odd) === List(2,4))
  }
  test("append") {
    assert(append(Nil, Nil) === Nil)
    assert(append(Nil, List(2)) === List(2))
    assert(append(List(3), Nil) === List(3))
    assert(append(List(4,5), List(6, 7)) === List(4,5,6,7))
  }
  test("concat") {
    assert(concat(Nil) === Nil)
    assert(concat(List(List(1))) === List(1))
    assert(concat(List(List(2,3),List(4,5),List(7))) === List(2,3,4,5,7))
  }
  test("concatMap") {
    def f(x : Int) = List("1", pred(x).toString)
    assert(concatMap(Nil, f) === Nil)
    assert(concatMap(List(4), f) === List("1","3"))
    assert(concatMap(List(2, 6), f) === List("1","1","1","5"))
  }
  test("maximum") {
    assert(maximum(List(1)) === 1)
    assert(maximum(List(2,7,4)) === 7)
  }
  test("reverse") {
    assert(reverse(Nil) === Nil)
    assert(reverse(List(6)) === List(6))
    assert(reverse(List(1,3,6)) === List(6,3,1))
  }  
}
