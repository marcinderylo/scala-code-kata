package tennis

trait TennisGame {
  def playerOneScores: TennisGame

  def playerTwoScores: TennisGame

  def score: String
}

object TennisGame {
  def apply(player1: String, player2: String): TennisGame = {

    case class Deuce() extends TennisGame {
      def playerOneScores: TennisGame = new Advantage(player1)

      def playerTwoScores: TennisGame = new Advantage(player2)

      def score: String = "Deuce"
    }

    case class GameOver(winner: String) extends TennisGame {
      def playerOneScores: TennisGame = throw new UnsupportedOperationException("hey, game is already over!")

      def playerTwoScores: TennisGame = throw new UnsupportedOperationException("hey, game is already over!")

      def score: String = winner + " wins"
    }

    case class Advantage(winningPlayer: String) extends TennisGame {
      def playerOneScores: TennisGame = if (winningPlayer == player1) GameOver(player1) else Deuce()

      def playerTwoScores: TennisGame = if (winningPlayer == player2) GameOver(player2) else Deuce()

      def score: String = "Advantage " + winningPlayer
    }

    case class RegularGame(player1Score: Int, player2Score: Int) extends TennisGame {

      def firstWon(s1: Int, s2: Int): Boolean = s1 > 3 && (s1 - s2) > 1

      def deuce(s1: Int, s2: Int): Boolean = s1 == s2 && s1 >= 3

      def playerOneScores: TennisGame = nextStateForScores(player1Score + 1, player2Score)

      def playerTwoScores: TennisGame = nextStateForScores(player1Score, player2Score + 1)

      def nextStateForScores(s1: Int, s2: Int) =
        if (firstWon(s1, s2)) GameOver(player1)
        else if (firstWon(s2, s1)) GameOver(player2)
        else if (deuce(s1, s2)) Deuce()
        else RegularGame(s1, s2)

      def score: String =
        if (player1Score == player2Score) describe(player1Score) + " all"
        else describe(player1Score) + ":" + describe(player2Score)

      private def describe(score: Int) = score match {
        case 0 => "Love"
        case 1 => "Fifteen"
        case 2 => "Thirty"
        case 3 => "Forty"
      }
    }
    new RegularGame(0, 0)
  }

}
