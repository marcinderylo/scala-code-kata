package com.blogspot.marcinderylo.kata

class BowlingGame {
        private val rolls = new Array[Int](21)
        private var currentRoll = 0

        def roll(pins:Int) { 
                rolls(currentRoll) = pins
                currentRoll += 1 
        }

        def score = {
                var pts:Int = 0     
                var rollIndex:Int = 0

                def sumOfBallsInFrame = rolls(rollIndex) + rolls(rollIndex + 1)                
                def isStrike = rolls(rollIndex) == 10
                def strikeBonus = rolls(rollIndex + 1) + rolls(rollIndex + 2)
                def isSpare = sumOfBallsInFrame == 10
                def spareBonus = rolls(rollIndex + 2)
                
                (1 to 10) foreach (_ => {
                        if ( isStrike ) {
                                pts += 10 + strikeBonus
                                rollIndex += 1
                        } else if ( isSpare ) {
                                pts += 10 + spareBonus
                                rollIndex += 2
                        } else {
                                pts += sumOfBallsInFrame
                                rollIndex += 2
                        }                        
                })
                pts
        }

}
