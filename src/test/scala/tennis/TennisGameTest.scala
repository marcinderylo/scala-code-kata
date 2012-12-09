package tennis

import org.scalatest.FunSuite

class TennisGameTest extends FunSuite {

  test("starting with: Love all") {
    assert(newGame.score === "Love all")
  }

  test("Fifteen:Love") {
    val game = newGame.playerOneScores
    assert(game.score === "Fifteen:Love")
  }

  test("Love:Fifteen") {
    val game = newGame.playerTwoScores
    assert(game.score === "Love:Fifteen")
  }

  test("Fifteen all") {
    val game = newGame.playerOneScores.playerTwoScores
    assert(game.score === "Fifteen all")
  }

  test("Thirty:Love") {
    val game = newGame.playerOneScores.playerOneScores
    assert(game.score === "Thirty:Love")
  }

  test("Fifteen:Thirty") {
    val game = newGame.playerTwoScores.playerOneScores.playerTwoScores
    assert(game.score === "Fifteen:Thirty")
  }

  test("Love:Forty") {
    val game = newGame.playerTwoScores.playerTwoScores.playerTwoScores
    assert(game.score === "Love:Forty")
  }

  test("Deuce") {
    val game = newGame.
      playerTwoScores.playerTwoScores.playerTwoScores.
      playerOneScores.playerOneScores.playerOneScores
    assert(game.score === "Deuce")
  }

  test("Player 2 wins") {
    val game = newGame.playerTwoScores.playerTwoScores.playerTwoScores.playerTwoScores
    assert(game.score === "Bjørn Borg wins")
  }

  test("Player 1 wins") {
    val game = newGame.playerOneScores.playerOneScores.playerOneScores.playerOneScores
    assert(game.score === "Boris Becker wins")
  }

  test("Deuce 4") {
    val game = newGame.playerOneScores.playerOneScores.playerOneScores.
      playerTwoScores.playerTwoScores.playerTwoScores.
      playerOneScores.
      playerTwoScores
    assert(game.score === "Deuce")
  }

  test("Advantage player 1") {
    val game = newGame.playerOneScores.playerOneScores.playerOneScores.
      playerTwoScores.playerTwoScores.playerTwoScores.
      playerOneScores
    assert(game.score === "Advantage Boris Becker")
  }

  test("Advantage player 2") {
    val game = newGame.playerOneScores.playerOneScores.playerOneScores.
      playerTwoScores.playerTwoScores.playerTwoScores.playerTwoScores
    assert(game.score === "Advantage Bjørn Borg")
  }

  test("Player 1 wins after advantage") {
    val game = newGame.playerOneScores.playerOneScores.playerOneScores.
      playerTwoScores.playerTwoScores.playerTwoScores.
      playerOneScores.playerOneScores
    assert(game.score === "Boris Becker wins")
  }

  def newGame: TennisGame = {
    TennisGame("Boris Becker", "Bjørn Borg")
  }
}
