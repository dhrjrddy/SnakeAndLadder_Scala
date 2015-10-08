package com.snakesandladders

import scala.collection.immutable.HashMap

object Ladder {

  /**
   * Initializes all the ladder start and end positions.
   */
  private val ladderPositions: HashMap[Int, Int] = HashMap(5 -> 25, 10 -> 29, 22 -> 41, 28 -> 55, 44 -> 95, 70 -> 89, 79 -> 81)

  /**
   * Returns the end position of the ladder if ladder
   * exist at that position else returns the input if ladder is not present.
   *
   * @param startingPosition
   * @return ending position of ladder.
   */
  def ladderPosition(startingPosition: Int) = ladderPositions.get(startingPosition).getOrElse(startingPosition)

}