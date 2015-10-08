package com.snakesandladders

import org.scalatest.junit.JUnitSuite
import scala.collection.mutable.HashMap
import org.junit.Assert._
import _root_.org.junit.Test

class GameSuite extends JUnitSuite {

  @Test def gameTest {
    val player1 = new Player(0, "name1")
    val player2 = new Player(0, "name2")
    val player3 = new Player(0, "name3")
    val playerList = new HashMap[Integer, Player]()
    playerList.put(1, player1)
    playerList.put(2, player2)
    playerList.put(3, player3)
    val game = new Game()
    game.board(playerList)
    assert(playerList.size === 3)
    assertTrue(playerList.get(1).get.position == 100 || playerList.get(2).get.position == 100 ||
      playerList.get(3).get.position == 100)
    assertFalse(playerList.get(1).get.position == 100 && playerList.get(2).get.position == 100 &&
      playerList.get(3).get.position == 100)
    assertFalse(playerList.get(1).get.position == 100 && playerList.get(2).get.position == 100)
    assertFalse(playerList.get(1).get.position == 100 && playerList.get(3).get.position == 100)
    assertFalse(playerList.get(2).get.position == 100 && playerList.get(3).get.position == 100)
  }
}