package com.blogspot.marcinderylo.kata

class BowlingGame private (rolls:List[Int] = Nil) {

        def roll(pins:Int) = new BowlingGame(pins :: rolls)

        def score = {
		def scoreFrames(frameNo:Int, rollsToScore:List[Int]): Int = if ( frameNo > 10 ) 0 else
			( rollsToScore: @unchecked ) match {
				case 10 :: r1 :: r2 :: rest => 
					10 + r1 + r2 + scoreFrames(frameNo + 1, r1 :: r2 :: rest)
				case r1 :: r2 :: r3 :: rest if r1 + r2 == 10 => 
					10 + r3 + scoreFrames(frameNo + 1, r3 :: rest)
				case r1 :: r2 :: rest => 
					r1 + r2 + scoreFrames(frameNo + 1, rest)
				case roll :: Nil => roll
				case Nil => 0
			}	 

		scoreFrames(1, rolls.reverse)
	}

	
}

object BowlingGame {
	def apply() = new BowlingGame
}
