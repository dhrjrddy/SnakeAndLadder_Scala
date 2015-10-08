package com.snakesandladders

import org.scalatest.junit.JUnitSuite
import _root_.org.junit.Test
import org.junit.Assert._

class DiceSuite extends JUnitSuite {

  @Test def diceTest {
    assertNotNull(Dice.roll())
    assertNotNull(Dice.roll())
    assertNotNull(Dice.roll())
    assertNotNull(Dice.roll())
    assertTrue(Dice.roll() >= 1 && Dice.roll() <= 6)
    assertTrue(Dice.roll() >= 1 && Dice.roll() <= 6)
    assertTrue(Dice.roll() >= 1 && Dice.roll() <= 6)
    assertTrue(Dice.roll() >= 1 && Dice.roll() <= 6)
  }

}