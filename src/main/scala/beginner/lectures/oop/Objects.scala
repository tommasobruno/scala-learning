package org.scala.learning
package beginner.lectures.oop

object Objects extends App {

  class Config(name: String, lastName: String) {
    def showConfiguration(): Unit = println(s"config: $name $lastName")
  }
  private object Config {
    def apply(name: String, lastName: String): Config = new Config(name, lastName)
  }

  private val config = Config("Tommy", "Bruno")
  config.showConfiguration()
}
