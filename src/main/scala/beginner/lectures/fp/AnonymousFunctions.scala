package org.scala.learning
package beginner.lectures.fp

object AnonymousFunctions extends App {

  // Problem: always need to override apply -> very oop style

  // Anonymous function or LAMBDA
  val doubler: Int => Int = x => x * 2

  // Multiple params rules
  val adder: (Int, Int) => Int = (a, b) => a + b

  // No params
  val doSomething: () => Int = () => 3

  // Careful
  println(doSomething) // Function itself
  println(doSomething()) // Function calls

  // Curly braces
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR
  val niceIncrementer: Int => Int = _ + 1 // a => a + 1
  val niceAdder: (Int, Int) => Int = _ + _ // (a, b) => a + b


}
