package com.blogspot.marcinderylo.kata

import org.scalatest.FunSuite
import com.blogspot.marcinderylo.kata.Exercises._

class KataTest extends FunSuite {
  val One = Succ(Zero)
  val Two = Succ(One)
  val Three = Succ(Two)
  val Four = Succ(Three)
  val Five = Succ(Four)
  val Six = Succ(Five)
  val OneTwoThree = Cons(One, Cons(Two, Cons(Three, Empty))) 
  test("add") {
    assert(add(Zero, Zero) === Zero)
    assert(add(Three, Zero) === Three)
    assert(add(Zero, Two) === Two)
    assert(add(Two, Four) === Six)
  }
  test("sum") {
    assert(sum(Empty) === Zero)
    assert(sum(OneTwoThree) === Six)
  }
  test("length") {
    assert(length(Empty) === Zero)
    assert(length(Cons(One, Empty)) === One)
    assert(length(OneTwoThree) === Three)
  }

}
