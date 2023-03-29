package org.scala.learning
package beginner.lectures.patternMatching

object PatternsEverywhere extends App {

  // 1. Catches are matches
  try {
    val x = 0
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "null"
    case _ => "Something else"
  }

  // Generators are based on pattern matching
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0 // Guard
  } yield x * 10

  val tuples = List((1, 2), (3, 4))
  val filteredTuples = for {
    (first, second) <- tuples
  } yield first * second
  println(filteredTuples)
}
