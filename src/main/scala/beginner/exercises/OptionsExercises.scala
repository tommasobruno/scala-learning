package org.scala.learning
package beginner.exercises

import scala.util.Random


object OptionsExercises extends App {

  val config: Map[String, String] = Map(
    // Fetched from somewhere else
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {

    // Connect to some server
    def connect: String = "Connected"

  }
  private object Connection {
    private val random = new Random(System.nanoTime())
    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else None
    }
  }

  // Try to establish connection, if you can -> print connect method
  val result = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield println(connection.connect)
}
