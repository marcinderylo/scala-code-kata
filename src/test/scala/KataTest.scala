package com.blogspot.marcinderylo.kata

class KataTest extends BaseSuite {

        var game:BowlingGame = _       

        before {
                game = BowlingGame()
        }

        test("gutter game") {
                20 times { roll(0) }
                assert( game.score === 0)
        }

        test("all ones") {
                20 times { roll(1) }
                assert( game.score === 20)
        }

        test("one spare") {
                rollSpare
                roll(7)
                17 times { roll(0) }
                assert( game.score === 24)
        }
        
        test("one strike") {
                rollStrike
                roll(4)
                roll(5)
                16 times { roll(0) }
                assert( game.score === 28 )
        }

        test("perfect game") {
                12 times rollStrike        
                assert( game.score === 300 )
        }

	test("incomplete game") {
		19 times { roll(1) }
		assert( game.score === 19 )
	}

	private def roll(pins:Int) { game = game roll pins }

        private def rollSpare { roll(6); roll(4) }

        private def rollStrike { roll(10) }
}

