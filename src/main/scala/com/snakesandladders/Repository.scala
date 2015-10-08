package com.snakesandladders
import scala.collection.immutable.HashMap
trait Repository {

  /**
   * This method saves the game results into a list and details of each player
   * positions in hash map.
   *
   * @param playerList
   */
  def save(playerList: HashMap[Integer, Player]): Unit

  /**
   * This method takes gameId as input and delete the game details.
   *
   * @param gameId
   */
  def delete(gameId: String): Unit

  /**
   * This method returns all the game Results. this returns gameId and date
   * when the game is played and winner of game.
   *
   * @return all games and their results.
   */
  def allGameResults(): List[GameResult]

  /**
   * This method takes gameId as input and results the results of that game.
   *
   * @param gameId
   * @return gameId detailed results.
   */
  def gameResultDetails(gameId: String): List[Player]

}