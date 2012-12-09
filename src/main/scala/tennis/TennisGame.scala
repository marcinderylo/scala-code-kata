package tennis

trait TennisGame {
  def playerOneScores: TennisGame

  def playerTwoScores: TennisGame

  def score: String
}

object TennisGame {
  def apply(playerOne: String, playerTwo: String):TennisGame = new RegularGame(playerOne, playerTwo, 0, 0)

  private class RegularGame(val player1: String, val player2: String, val player1Score: Int, val player2Score: Int) extends TennisGame {

    def playerOneScores: TennisGame = new RegularGame(player1, player2, player1Score + 1, player2Score)

    def playerTwoScores: TennisGame = new RegularGame(player1, player2, player1Score, player2Score + 1)

    def score: String =
      if (isDeuce()) "Deuce"
      else if (player1Wins()) player1 + " wins"
      else if (player2Wins()) player2 + " wins"
      else if (player1Advantage()) "Advantage " + player1
      else if (player2Advantage()) "Advantage " + player2
      else if (player1Score == player2Score) describe(player1Score) + " all"
      else describe(player1Score) + ":" + describe(player2Score)

    private def isDeuce(): Boolean = (player1Score == player2Score && player1Score >= 3)

    private def player1Wins() = player1Score > 3 && (player1Score - player2Score) > 1

    private def player2Wins() = player2Score > 3 && (player2Score - player1Score) > 1

    private def player1Advantage() = player1Score > 3
    private def player2Advantage() = player2Score > 3

    private def describe(score: Int) = score match {
      case 0 => "Love"
      case 1 => "Fifteen"
      case 2 => "Thirty"
      case 3 => "Forty"
    }
  }

}
