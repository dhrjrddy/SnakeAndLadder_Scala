package com.snakesandladders

import com.zaxxer.hikari.HikariDataSource
import java.util.Properties

object ConnectionProvider {
  private val FILE_NAME = "dbproperties.CONFIG";
  private val DRIVER_CLASS = "db_driver";
  private val USER = "db_user";
  private val PASSWORD = "db_password";
  private val URL = "db_url";
  private val input = getClass().getClassLoader().getResourceAsStream(FILE_NAME);

  private val connectionPool = {
    val dataSource = new HikariDataSource()
    val prop = new Properties()
    prop.load(input)
    dataSource.setDriverClassName(prop.getProperty(DRIVER_CLASS))
    dataSource.setJdbcUrl(prop.getProperty(URL));
    dataSource.setUsername(prop.getProperty(USER));
    dataSource.setPassword(prop.getProperty(PASSWORD));
    dataSource
  }

  def getConnection = connectionPool.getConnection()
}


