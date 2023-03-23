package org.scala.learning
package beginner.lectures.oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // Creates class that extends Animal with the override method and instance of funnyAnimal
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("AHAHAHA")
  }

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name")
  }

  val person = new Person(name = "Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim")
  }

  person.sayHi
}
