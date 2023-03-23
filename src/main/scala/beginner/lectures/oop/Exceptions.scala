package org.scala.learning
package beginner.lectures.oop

object Exceptions extends App {

  val x: String = null
  //println(x.length)

  // 1. Throw exceptions
  // val exceptions = throw new NullPointerException
  // throwable classes extends the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. Catch exception
  private def getInt(withException: Boolean): Int = {
    if(withException) throw new RuntimeException("No int for you")
    else 42
  }

  try {
    val number = getInt(true)
    println(number)
  } catch {
    case e: RuntimeException => println(s"Caught a runtime problem: ${e.getMessage}")
  } finally {
    // code that will get executed no matter what
    // it is optional and it does influence return type of the expression
    println("Finally")
  }

  // 3. Define own exception
  class MyException extends Exception
  val exception = new MyException
  // throw exception
}
