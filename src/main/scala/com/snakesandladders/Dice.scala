package com.snakesandladders

object Dice {
  private val MIN = 1
  private val MAX = 6

  /**
   * This method gets random method from random method and
   *
   * @return random dice score
   */
  def roll() = random(MIN, MAX)

  /**
   * This method generates random number between 1 and 6. Next it returns the
   * value to roll method.
   *
   * @param min
   *            dice score.
   * @param max
   *            dice score.
   * @return random result of the dice.
   */
  def random(min: Int, max: Int) = (min + Math.floor((max - min) * Math.random())).toInt

}