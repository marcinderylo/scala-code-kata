package com.blogspot.marcinderylo.kata

class KataTest extends BaseSuite {

        var game:BowlingGame = _       

        before {
                game = new BowlingGame
        }

        test("gutter game") {
                20 times { game roll 0 }
                assert( game.score === 0)
        }

        test("all ones") {
                20 times { game roll 1 }
                assert( game.score === 20)
        }

        test("one spare") {
                rollSpare
                game roll 7
                17 times { game roll 0 }
                assert( game.score === 24)
        }
        
        test("one strike") {
                rollStrike
                game roll 4
                game roll 5
                16 times { game roll 0}
                assert( game.score === 28 )
        }

        test("perfect game") {
                12 times rollStrike        
                assert( game.score === 300 )
        }

        private def rollSpare {
                game roll 6
                game roll 4
        }

        private def rollStrike {
                game roll 10
        }
}

