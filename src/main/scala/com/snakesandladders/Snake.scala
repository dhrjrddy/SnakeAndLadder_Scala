package com.snakesandladders

import scala.collection.immutable.HashMap

object Snake {

  /**
   * Initializes all the snake start and end positions.
   */
  val snakePositions: HashMap[Int, Int] = HashMap(31 -> 14, 37 -> 17, 73 -> 53, 78 -> 39, 92 -> 35, 70 -> 89, 99 -> 7)

  /**
   * Returns the end position of the snake if ladder
   * exist at that position else returns the input if snake is not present.
   *
   * @param startingPosition
   * @return ending position of ladder.
   */
  def snakePosition(startingPosition: Int) = snakePositions.get(startingPosition).getOrElse(startingPosition)

}