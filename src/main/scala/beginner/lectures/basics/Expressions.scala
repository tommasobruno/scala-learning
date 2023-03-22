package org.scala.learning
package beginner.lectures.basics

object Expressions extends App {

  /*
  Exercises
   */

  // 1. Difference between "hello world" vs println("hello world")
  /*
  Hello world is a string value, println is an side effect that
  returns unit
   */

  // 2. What's value of
  private val someValue = {
    2 < 3
  } // -> true

  private val someOtherValue = {
    if (someValue) 239 else 986
  } // -> 239

  println(someValue)
  println(someOtherValue)
}
