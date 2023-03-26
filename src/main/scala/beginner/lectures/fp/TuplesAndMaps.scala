package org.scala.learning
package beginner.lectures.fp

object TuplesAndMaps extends App {

  // Tuples -> Finite ordered lists
  val aTuple = (2, "Hello scala") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1, aTuple._2)
  println(aTuple.copy(_2 = "Goodbye Java"))

  // Maps - Keys to Values
  val aMap: Map[String, Int] = Map()

  val aPhoneBook = Map("Jim" -> 555, "Daniel" -> 222).withDefaultValue(-1)  // a -> b = (a, b)
  println(aPhoneBook)

  println(aPhoneBook("Jim"))
  println(aPhoneBook("Mary"))

  // Add pairing
  val newPair = "Jim" -> 76
  val newPhoneBook = aPhoneBook + newPair
  println(newPhoneBook)

  // Map, flatMap, filter
  println(aPhoneBook.map(pair => (pair._1.toLowerCase(), pair._2)))

  // filterKeys
  println(aPhoneBook.view.filterKeys(_.startsWith("J")).toMap)

  // mapValues
  println(aPhoneBook.view.mapValues(_ * 10).toMap)

  // Conversion to other collections
  println(aPhoneBook.toList)
  println(List("Daniel" -> 555, "Jim" -> 999).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(_.charAt(0)))
}