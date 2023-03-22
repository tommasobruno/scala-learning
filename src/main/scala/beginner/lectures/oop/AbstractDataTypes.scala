package org.scala.learning
package beginner.lectures.oop

object AbstractDataTypes extends App {

  // Abstract
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "K9"
    override def eat: Unit = println("crunch crunch")
  }

  // Trait
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"
    override def eat: Unit = println("nomnomnom")
    override def eat(animal: Animal): Unit = println(s"Eating ${animal.creatureType}")
  }

  val dog = new Dog()
  val croc = new Crocodile()
  croc.eat(dog)

  // Trait vs Abstract Classes
  // 1 - traits do not have constructor parameters
  // 2 - can extends multiple traits, but only a single abstract class
  // 3 - traits = behavior, abstract class = type of thing
}
