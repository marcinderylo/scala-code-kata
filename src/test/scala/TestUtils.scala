package com.blogspot.marcinderylo.kata

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

abstract class BaseSuite extends FunSuite with BeforeAndAfter {
        implicit def intTimes(i: Int) = new {
                def times(fn: => Unit) = (1 to i) foreach (_ => fn)
        }

}

