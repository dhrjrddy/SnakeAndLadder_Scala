package com.snakesandladders

import org.scalatest.FunSuite

class SnakesAndLaddersSuite extends FunSuite {

  test("check snake positions") {
    assert(Snake.snakePosition(37) === 17)
    assert(Snake.snakePosition(92) === 35)
    assert(Snake.snakePosition(22) === 22)
    assert(Snake.snakePosition(57) === 57)
  }

  test("check ladder positions") {
    assert(Ladder.ladderPosition(10) === 29)
    assert(Ladder.ladderPosition(44) === 95)
    assert(Ladder.ladderPosition(8) === 8)
    assert(Ladder.ladderPosition(63) === 63)
  }
}