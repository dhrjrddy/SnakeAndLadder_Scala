package com.snakesandladders

import scala.collection.immutable.HashMap
import scala.collection.immutable.List

class RepositoryImp extends Repository {
  // This list contains list of all the game results.
  private var gameResults = List[GameResult]()

  // This map contains all the players and there positions for all games.
  private var gameResultDetails = new HashMap[String, HashMap[Integer, Player]]()

  def save(playerList: HashMap[Integer, Player]) {
    val gameId = "Game" + (gameResults.size + 1) // Generating a gameId for every game.
    gameResultDetails = gameResultDetails + (gameId -> playerList)
    for (key <- playerList.keySet if playerList.get(key).get.position == 100) {
      // Check the winner and then register the game results.
      gameResults = (new GameResult(gameId, CurrentDate.getDate, playerList.get(key).get.name)) :: gameResults
    }
  }

  def delete(gameId: String) {
    gameResultDetails = gameResultDetails - gameId
    for (game <- gameResults if game.gameId.equals(gameId)) {
      gameResults = gameResults diff List(game)
    }
  }

  def allGameResults(): List[GameResult] = gameResults

  def gameResultDetails(gameId: String): List[Player] = {
    var gameDetailsList = List[Player]()
    if (gameResultDetails.get(gameId) != None) {
      for (player <- gameResultDetails.get(gameId).get.values) {
        gameDetailsList = player :: gameDetailsList
      }
    }
    gameDetailsList
  }
}