package com.snakesandladders

import scala.collection.mutable.HashMap

object DisplayResult {

  /**
   * This method displays all the games and its winners.
   *
   * @param gameResultsList
   */
  def showAllGamesResults(gameResultsList: List[GameResult]) {
    gameResultsList.foreach { game =>
      print("Game Name: " + game.gameId)
      print("   Game Played on " + game.date)
      println("   Winner is: " + game.winnerName)
    }
  }

  /**
   * This Method displays all the players and respective positions in a game.
   *
   * @param gameDetailsList
   */
  def showGameDetails(gameDetailsList: List[Player]) {
    gameDetailsList.foreach { player =>
      print("Player Name = " + player.name)
      println("   Player position = " + player.position)
    }
  }

  /**
   * This Method displays winner of the game.
   *
   * @param playerList
   */
  def showWinner(playerList: HashMap[Integer, Player]) {
    if (playerList != None) {
      for (key <- playerList.keySet if playerList.get(key).get.position == 100) {
        println(playerList.get(key).get.name + " is the Winner.")
      }
    }
  }
}