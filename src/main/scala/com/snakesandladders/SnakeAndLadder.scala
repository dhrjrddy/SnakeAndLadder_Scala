package com.snakesandladders

/**
 * Snakes and Ladders Game
 * @Description
 * The game has multiple players where players take turns to roll dice.
 * If a player's token lands on the bottom of a ladder, the token moves to the top of the ladder (always greater than the current position).
 * Conversely, if the player's token lands on snake's mouth, then token moves to the tail of the snake (always less that the current position).
 * Whoever gets to the last number or 100 wins.
 *
 * To Start the game we need to call startGame method by passing no of players.
 * @param number of players
 */

import scala.collection.mutable.HashMap

object SnakeAndLadder {

  private var playerList: HashMap[Integer, Player] = null // Contains all players and their positions.
  private val gameResults = new DbRepositoryImp()

  /**
   * @return list of game results
   */
  private def allGamesResults() = gameResults.allGameResults()

  /**
   * @param gameId
   * @return list of input gameId details with player name and position.
   */
  private def gameDetails(gameId: String) = gameResults.gameResultDetails(gameId)

  /**
   * This method auto generate the player names and initialize their position
   * and store them in player list.
   *
   * @param totalPlayers
   */
  private def createMultiplePlayers(totalPlayers: Int) = {
    playerList = new HashMap[Integer, Player]
    val startPosition = 0
    for (playerNum <- 1 to totalPlayers) {
      // initializing player position to 0.

      val player = new Player(startPosition, "Player" + (playerNum))
      playerList.put(playerNum, player)
    }
  }

  /**
   * This method is responsible for starting the game and setting the total
   * players list. It will also call the game board and send the final results
   * to database.
   *
   */
  private def startGame(totalPlayers: Int) = {
    if (totalPlayers < 2) { // Check if total players is less than 2.
      System.out.println("Please enter more than 1 player.")
    } else {
      createMultiplePlayers(totalPlayers)
      val game = new Game()
      game.board(playerList)
      gameResults.save(collection.immutable.HashMap(playerList.toSeq: _*))
    }
  }

  def main(args: Array[String]) {
    var userChoice = 0
    do {
      System.out.println("Select the option:")
      System.out.println("1. Play new game.")
      System.out.println("2. Display all game results.")
      System.out.println("3. Display game details.")
      userChoice = io.StdIn.readInt
      userChoice match {
        case 1 =>
          System.out.println("Enter player count...")
          val totalPlayers = io.StdIn.readInt
          startGame(totalPlayers)
          DisplayResult.showWinner(playerList)
        case 2 =>
          DisplayResult.showAllGamesResults(allGamesResults())
        case 3 =>
          System.out.println("Enter game id...")
          val gameId = io.StdIn.readLine()
          DisplayResult.showGameDetails(gameDetails(gameId))
        case _ =>
      }
    } while (userChoice == 1 || userChoice == 2 || userChoice == 3)

  }
}