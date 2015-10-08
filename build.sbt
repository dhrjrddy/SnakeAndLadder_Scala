// Set the project name to the string 'My Project'
name := "SnakeAndLadder"

// The := method used in Name and Version is one of two fundamental methods.
// The other method is <<=
// All other initialization methods are implemented in terms of these.
version := "1.0"

scalaVersion := "2.11.7"

// Add a single dependency
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.1"

// add compile dependencies on some dispatch modules
libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.2.1",
  "com.zaxxer" % "HikariCP" % "1.4.0",
"org.slf4j" % "slf4j-simple" % "1.6.1",
 "log4j" % "log4j" % "1.2.17",
"junit" % "junit" % "4.12"
)

