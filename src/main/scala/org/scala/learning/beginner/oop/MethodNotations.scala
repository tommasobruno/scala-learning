package org.scala.learning
package org.scala.learning.beginner.oop

import scala.language.postfixOps

object MethodNotations extends App {

  /*
  Exercises
   */
  private class Person(val name: String, val age: Int = 0, favMovie: String = "") {
    def +(nickName: String): Person = new Person(s"${this.name} ($nickName)")

    def unary_+ : Person = new Person(name = this.name, age = this.age + 1)

    private def learns(s: String): String = s"$name learns $s"
    def learnsScala: String = this.learns("Scala")

    def apply(times: Int): String = s"$name watched $favMovie $times times"
  }

  private val tommy = new Person("Tommy", 23, "Sherlock Holmes")
  println((tommy + "random").name)
  println((+tommy).age)
  println(tommy learnsScala)
  println(tommy(3))

}