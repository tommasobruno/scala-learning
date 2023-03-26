package org.scala.learning
package beginner.lectures.fp

object MapFlatMapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list.head)
  println(list.tail)

  // Map
  println(list.map(_ + 1))
  println(list.map(_ + "Random"))

  // Filter
  println(list.filter(_ % 2 == 0))

  // FlatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // print all combination between to lists
  val numbers = List(1, 2, 3, 4)
  val characters = List("a", "b", "c", "d")
  val result = for {
    num <- numbers if num % 2 == 0
    char <- characters
  } yield num + char
  println(result)

  // foreach
  list.foreach(println)
}
