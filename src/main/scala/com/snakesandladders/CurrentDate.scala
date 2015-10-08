package com.snakesandladders

import java.text.SimpleDateFormat
import java.util.Calendar

object CurrentDate {
  /**
   * This method returns date in String format.
   *
   * @return current date and time
   */

  def getDate() = {
    val dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
    val date = Calendar.getInstance().getTime()
    dateFormat.format(date)
  }
}
