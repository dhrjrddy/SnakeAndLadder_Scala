package com.snakesandladders

import java.sql._
import scala.collection.immutable.HashMap
import scala.collection.immutable.List
import org.apache.log4j.Logger

class DbRepositoryImp extends Repository {
  private val SAVE_GAME_RESULTS = "insert into game_results (game_id,date,winner) values(?,?,?)"

  private val SAVE_GAME_DETAILS = "insert into game_details (game_id,player_name,position) values(?,?,?)"

  private val DELETE_GAME = "delete from game_results where game_id=?"

  private val GAME_COUNT = "select count(*) as row_count from game_results"

  private val GAME_RESULTS = "select * from game_results"

  private val GAME_RESULT_DETAILS = "select player_name,position from game_details where game_id=?"

  private val ROW_COUNT = "row_count"

  private val GAME_ID = "game_id"

  private val DATE = "date"

  private val WINNER = "winner"

  private val PLAYER_NAME = "player_name"

  private val POSITION = "position"

  private var log: Logger = Logger.getLogger(classOf[DbRepositoryImp])

  def save(playerList: HashMap[Integer, Player]) {
    var connection: Connection = null
    var gameId: String = null
    try {
      connection = ConnectionProvider.getConnection
      connection.setAutoCommit(false)
      val statement = connection.prepareStatement(GAME_COUNT)
      val resultSet = statement.executeQuery()
      resultSet.next()
      gameId = "Game" + (resultSet.getInt(ROW_COUNT) + 1)
      val gameResultsStatement = connection.prepareStatement(SAVE_GAME_RESULTS)
      val date = CurrentDate.getDate()
      gameResultsStatement.setString(1, gameId)
      gameResultsStatement.setString(2, date)
      val gameDetailsStatement = connection.prepareStatement(SAVE_GAME_DETAILS)
      for (key <- playerList.keySet) {
        if (playerList.get(key).get.position == 100) {
          gameResultsStatement.setString(3, playerList.get(key).get.name)
        }
        gameDetailsStatement.setString(1, gameId)
        gameDetailsStatement.setString(2, playerList.get(key).get.name)
        gameDetailsStatement.setInt(3, playerList.get(key).get.position)
        gameDetailsStatement.addBatch()
      }
      gameResultsStatement.execute()
      gameDetailsStatement.executeBatch()
      connection.commit()
      connection.setAutoCommit(true)
      log.info("Saved " + gameId + " results Succeded")
    } catch {
      case e: SQLException => {
        log.error("Saving " + gameId + " results failed: " + e)
        throw new MyRuntimeException("Saving " + gameId + " results failed: " + e)
      }
    } finally {
      closeConnection(connection)
    }
  }

  def delete(gameId: String) {
    var connection: Connection = null
    try {
      connection = ConnectionProvider.getConnection
      val statement = connection.prepareStatement(DELETE_GAME)
      statement.setString(1, gameId)
      statement.execute()
      log.info("Deleted " + gameId + " results Successfully")
    } catch {
      case e: SQLException => {
        log.error("Deleting " + gameId + " failed: " + e)
        throw new MyRuntimeException("Deleting " + gameId + " failed: " + e)
      }
    } finally {
      closeConnection(connection)
    }
  }

  def allGameResults(): List[GameResult] = {
    var gameResultsList = List[GameResult]()
    var connection: Connection = null
    try {
      connection = ConnectionProvider.getConnection
      val statement = connection.prepareStatement(GAME_RESULTS)
      val result = statement.executeQuery()
      while (result.next()) {
        gameResultsList = (new GameResult(result.getString(GAME_ID), result.getString(DATE), result.getString(WINNER))) :: gameResultsList
      }
      log.info("Returned list of games played Successfully")
    } catch {
      case e: SQLException => {
        log.error("Returning list of games failed: " + e)
        throw new MyRuntimeException("Returning list of games failed: " + e)
      }
    } finally {
      closeConnection(connection)
    }
    gameResultsList
  }

  def gameResultDetails(gameId: String): List[Player] = {
    var gameDetailsList = List[Player]()
    var connection: Connection = null
    try {
      connection = ConnectionProvider.getConnection
      val statement = connection.prepareStatement(GAME_RESULT_DETAILS)
      statement.setString(1, gameId)
      val result = statement.executeQuery()
      while (result.next()) {
        gameDetailsList = (new Player(result.getInt(POSITION), result.getString(PLAYER_NAME))) :: gameDetailsList
      }
      log.info("Returned " + gameId + " results Successfully")
    } catch {
      case e: SQLException => {
        log.error("Returning " + gameId + " results failed: " + e)
        throw new MyRuntimeException("Returning " + gameId + " results failed: " + e)
      }
    } finally {
      closeConnection(connection)
    }
    gameDetailsList
  }

  private def closeConnection(connection: Connection) {
    if (connection != null) {
      try {
        connection.close()
      } catch {
        case e: SQLException => {
          log.error("Cannot close connection" + e)
          throw new MyRuntimeException("Cannot close connection" + e)
        }
      }
    }
  }
}
   