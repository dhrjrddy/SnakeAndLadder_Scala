package com.snakesandladders

import org.scalatest.junit.JUnitSuite
import _root_.org.junit.Test
import org.junit.Assert._
import scala.collection.mutable.HashMap

class RepositoryImpSuite extends JUnitSuite {

  @Test def repositoryTest {
    val player1 = new Player(10, "name1")
    val player2 = new Player(40, "name2")
    val player3 = new Player(100, "name3")
    val playerList = new HashMap[Integer, Player]()
    playerList.put(1, player1)
    playerList.put(2, player2)
    playerList.put(3, player3)
    val repository = new RepositoryImp()
    repository.save(collection.immutable.HashMap(playerList.toSeq: _*))
    val player4 = new Player(40, "name1")
    val player5 = new Player(100, "name2")
    val player6 = new Player(80, "name3")
    val player7 = new Player(90, "name4")
    val playerList2 = new HashMap[Integer, Player]()
    playerList2.put(1, player4)
    playerList2.put(2, player5)
    playerList2.put(3, player6)
    playerList2.put(4, player7)
    repository.save(collection.immutable.HashMap(playerList2.toSeq: _*))
    assertEquals(repository.allGameResults().apply(1).winnerName, "name3")
    val game1 = List("name1", "name2", "name3")
    assertTrue(game1.contains(repository.gameResultDetails("Game1").apply(0).name))
    assertFalse(repository.gameResultDetails("Game1").apply(0).name
      == "name5")
    repository.delete("Game2")
    assertEquals(repository.allGameResults().size, 1)
  }
}