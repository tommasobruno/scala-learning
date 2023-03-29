package org.scala.learning
package beginner.lectures.patternMatching

import scala.util.Random

object PatternMatching extends App {

  // Switch on steroids
  val random = new Random()
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "The one"
    case 2 => "Double or nothing"
    case 3 => "Third time is the charm"
    case _ => "Something else" // WILDCARD -> matches anything
  }

  println(x)
  println(description)


  // 1. Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  // Cases are matched in order, FCFS. No case? scala.MatchError exception
  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi my name is $n and I cannot drink" // Guard
    case Person(n, a) => s"Hi my name is $n and I am $a years old"
    case _ => "I don't know who I am"
  }

  println(greeting)

  // Pattern matching on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Pomeranian")
  animal match {
    case Dog(br) => println(s"Dog matched ($br)")
  }

  // Match everything
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  } // Overkill, do not do that!


}
