package com.blogspot.marcinderylo.kata

// Those are Scala exercises (for beginners) from Tony Morriss' blog post:
// http://blog.tmorris.net/scala-exercises-for-beginners/

// You are not permitted to use these List methods:
// * length
// * map
// * filter
// * ::: (and variations such as ++)
// * flatten
// * flatMap
// * reverse (and variations i.e. reverseMap, reverse_:::)
// This also means you are not permitted to use for-comprehensions on Lists.
// You are permitted to use the functions you write yourself. For example, 
// Exercise 2 may use Exercise 1 or Exercise 3. Using permitted existing 
// methods where appropriate will attract marks for elegance.
 
// TOTAL marks:    /66

object Exercises {

  def succ(n: Int) = n + 1
  def pred(n: Int) = n - 1
 
  // Assume x and y are 0 or positive. Do not use + or - on Int. Only permitted to use succ/pred (above)
  // Exercise 1
  // Relative Difficulty: 1
  // Correctness: 2.0 marks
  // Performance: 0.5 mark
  // Elegance: 0.5 marks
  // Total: 3
  def add(x: Int, y: Int): Int = if (y == 0) x else succ(add(x, pred(y)))
 
  // Exercise 2
  // Relative Difficulty: 2
  // Correctness: 2.5 marks
  // Performance: 1 mark
  // Elegance: 0.5 marks
  // Total: 4
  def sum(x: List[Int]): Int = x.fold(0)(add)
 
  // Exercise 3
  // Relative Difficulty: 2
  // Correctness: 2.5 marks
  // Performance: 1 mark
  // Elegance: 0.5 marks
  // Total: 4
  def length[A](x: List[A]): Int = x match {
    case Nil => 0
    case head :: tail => succ(length(tail))
  }
 
  // Exercise 4
  // Relative Difficulty: 5
  // Correctness: 4.5 marks
  // Performance: 1.0 mark
  // Elegance: 1.5 marks
  // Total: 7
  def map[A, B](x: List[A], f: A => B): List[B] = x match {
    case Nil => Nil
    case head :: tail => f(head) :: map(tail, f)
  }
 
  // Exercise 5
  // Relative Difficulty: 5
  // Correctness: 4.5 marks
  // Performance: 1.5 marks
  // Elegance: 1 mark
  // Total: 7
  def filter[A](x: List[A], f: A => Boolean): List[A] = x match {
    case Nil => Nil
    case head :: tail if f(head) => head :: filter(tail, f)
    case _ :: tail => filter(tail, f)
  }
 
  // Exercise 6
  // Relative Difficulty: 5
  // Correctness: 4.5 marks
  // Performance: 1.5 marks
  // Elegance: 1 mark
  // Total: 7
  def append[A](x: List[A], y: List[A]): List[A] = x match {
      case Nil => y
      case head :: tail => head :: append(tail, y)
  }
 
  // Exercise 7
  // Relative Difficulty: 5
  // Correctness: 4.5 marks
  // Performance: 1.5 marks
  // Elegance: 1 mark
  // Total: 7
  def concat[A](x: List[List[A]]): List[A] = x match {
    case Nil => Nil
    case single :: Nil => single
    case first :: second :: tail => concat(append(first, second) :: tail) 
  }
 
  // Exercise 8
  // Relative Difficulty: 7
  // Correctness: 5.0 marks
  // Performance: 1.5 marks
  // Elegance: 1.5 mark
  // Total: 8
  def concatMap[A, B](x: List[A], f: A => List[B]): List[B] = concat(map(x, f))
 
  // Exercise 9
  // Relative Difficulty: 8
  // Correctness: 3.5 marks
  // Performance: 3.0 marks
  // Elegance: 2.5 marks
  // Total: 9
  def maximum(x: List[Int]): Int = x match {
    case Nil => throw new Exception("maximum(Nil)")
    case int :: Nil => int
    case head :: tail => 
      val maxTail = maximum(tail)
      if (head > maxTail) head else maxTail
    
  }
 
  // Exercise 10
  // Relative Difficulty: 10
  // Correctness: 5.0 marks
  // Performance: 2.5 marks
  // Elegance: 2.5 marks
  // Total: 10
  def reverse[A](x: List[A]): List[A] = {
    def reverse0(x: List[A], acc:List[A]): List[A] = x match {
      case Nil => acc
      case head :: tail => reverse0(tail, head :: acc) 
    }
    reverse0(x, Nil)
  }
}
