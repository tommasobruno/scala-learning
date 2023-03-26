package org.scala.learning
package beginner.lectures.fp

import scala.util.Random

object Sequences extends App {

  // Seq
  val aSequence = Seq(1, 3, 4, 2)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(7, 5, 6))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to  10
  //aRange.foreach(println)

  // Lists
  val aList = List(1, 2, 3)
  val prepended = 42 +: aList :+ 89
  println(prepended)
  val apples5 = List.fill(5)("Apple")
  println(apples5.mkString("-"))

  // Arrays
  val numbers = Array(1, 2, 3, 4)
  val givenDim = Array.ofDim[Int](3)
  givenDim.foreach(println)

  // Mutations
  numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))

  // Arrays and Sequences
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq)

  // Vectors
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  // Vectors vs Lists
  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      _ <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val list = (1 to maxCapacity).toList
  val vec = (1 to maxCapacity).toVector

  // keeps reference to tail, but updating element in middle takes long
  println(getWriteTime(list))
  // depth of the tree is small, but needs to replace entire 32 elements chunk
  println(getWriteTime(vec))
}
