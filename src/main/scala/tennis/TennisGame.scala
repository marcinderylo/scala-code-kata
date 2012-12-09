package tennis

class TennisGame private(val player1: String, val player2: String, val player1Score: Int, val player2Score: Int) {

  def playerOneScores: TennisGame = new TennisGame(player1, player2, inc(player1Score), player2Score)

  def playerTwoScores: TennisGame = new TennisGame(player1, player2, player1Score, inc(player2Score))

  def score: String =
    if (isDeuce()) "Deuce"
    else if (player1Wins()) player1 + " wins"
    else if (player2Wins()) player2 + " wins"
    else if (player1Advantage()) "Advantage " + player1
    else if (player2Advantage()) "Advantage " + player2
    else if (player1Score == player2Score) describe(player1Score) + " all"
    else describe(player1Score) + ":" + describe(player2Score)

  private def isDeuce(): Boolean = (player1Score == player2Score && player1Score >= 40)

  private def player1Wins() = player1Score > 40 && (player1Score - player2Score) > 15

  private def player2Wins() = player2Score > 40 && (player2Score - player1Score) > 15

  private def player1Advantage() = player1Score > 40
  private def player2Advantage() = player2Score > 40

  private def inc(score: Int): Int = score match {
    case 30 => 40
    case other => other + 15
  }

  private def describe(score: Int) = score match {
    case 0 => "Love"
    case 15 => "Fifteen"
    case 30 => "Thirty"
    case 40 => "Forty"
  }
}

object TennisGame {
  def apply(playerOne: String, playerTwo: String) = new TennisGame(playerOne, playerTwo, 0, 0)
}
