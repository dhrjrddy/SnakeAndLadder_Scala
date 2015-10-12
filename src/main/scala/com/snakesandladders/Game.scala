package com.snakesandladders

import scala.collection.mutable.HashMap

object Game {

  private val TOTAL_BOARD_SIZE = 100 // Declaring total board size to 100.
}

class Game {

  def board(playerList: HashMap[Integer, Player]): Unit = {

    var playerTurn = 1 // First player starts the game.
    while (true) {
      val rollDieScore = Dice.roll()
      val player = playerList.get(playerTurn)
      var totalScore = player.get.position + rollDieScore
      if (totalScore == Game.TOTAL_BOARD_SIZE) {
        // Checks if player reached maximum board size.
        val updatedPlayerPosition = player.get.copy(position = totalScore)
        playerList.put(playerTurn, updatedPlayerPosition)
        return
      } else if (totalScore < Game.TOTAL_BOARD_SIZE) {
        // Checks if player's location if greater than 100.
        // Updating the player's position if its less than 100.
        totalScore = Ladder.ladderPosition(totalScore)
        totalScore = Snake.snakePosition(totalScore)
        val updatedPlayerPosition = player.get.copy(position = totalScore)
        playerList.put(playerTurn, updatedPlayerPosition)
      }
      playerTurn += 1
      if (playerTurn == playerList.size + 1) {
        playerTurn = 1
      }
    }
  }
}