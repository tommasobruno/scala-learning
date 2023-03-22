package org.scala.learning
package beginner.lectures.oop

object InheritancePartOne extends App {

  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal

  val cat = new Cat()
  cat.eat

  // Constructors
  sealed class Person(name: String, age: Int) {
    final def talk: Unit = println("Hello")
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // Overriding
  class Dog extends Animal {
    override val creatureType: String = "domestic"
    override def eat: Unit = {
      super.eat
      println("dog eats")
    }
  }



  val dog = new Dog()
  dog.eat
  println(dog.creatureType)

  // Type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog()
  unknownAnimal.eat

  // Preventing overrides
  // 1 - use keyword FINAL on method
  // 2 - use keyword FINAL on class to prevent extends
  // 3 - seal the class -> extends class in this file, but prevents other file extension
  val adult = new Adult("Tommaso", 23, "123123")
  adult.talk
}
