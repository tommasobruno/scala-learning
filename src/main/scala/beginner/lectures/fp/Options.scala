package org.scala.learning
package beginner.lectures.fp

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  // WORK WITH Unsafe API
  def unsafeMethod(): String = null
  val result = Some(unsafeMethod()) // WRONG -> You can get Some(null)
  val safeResult = Option(unsafeMethod())
  println(safeResult)

  // Chained methods
  def backupMethod(): String = "A valid result"
  val chained = Option(unsafeMethod()).orElse(Option(backupMethod))

  // DESIGN UNSAFE API
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")

  val chainedBetter = betterUnsafeMethod().orElse(betterBackupMethod())

  // Functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(_ % 2 != 0))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // For comprehensions
  
}
