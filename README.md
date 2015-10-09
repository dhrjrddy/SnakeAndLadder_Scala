##Snakes And Ladders

Simple Snakes and Ladders Game Implemented in Scala and Maven and perforemd Junit testing.


##Snakes and Ladders Game - Rules

* Two or more players can play the game.
* Typical board size is 10 x10, but user can specify different board size.
* Game takes the number of the players and auto generates the players names.

##Technologies

* JDK1.7

* Scala 2.11.7 - A hybrid functional object-oriented language.

* MySQL - A relational Database

* sbt-0.13.9


##Getting started

Run the initdb.sql file present in the src/main/resources/ folder before running the application and tests. This file creates a database schema snakesandladders and 3 tables game_results, game_details and logs.

The database configuration details are present in dbproperties.CONFIG file in src/main/resources/ folder. Change the driver, username, password and url if required.
``` javascript
db_driver=
db_user=
db_password=
db_url=jdbc:
```
Logs are created to record events and are stored in the database. The database configuration details for log4j are present in log4j.PROPERTIES file in src/main/resources/ folder. Change the driver, username, password and url if required.
``` javascript
log4j.appender.sql.URL=
log4j.appender.sql.driver=
log4j.appender.sql.user=
log4j.appender.sql.password=
```

Compile Test and Run the the code in sbt.
