package org.scala.learning
package org.scala.learning.beginner.basics

object Functions extends App {

  /*
  Exercises
  */

  // 1. A greeting function (name, age) => 'Hello, name and age'
  private def greeting(name: String, age: Int): String = {
    "Hello, my name is " + name + " and I am " + age + " years old"
  }
  println(greeting("Tommaso", 23))

  // 2. Factorial function (product of all number up to given number)
  private def factorial(limit: Int): Int = {
    if(limit <= 0) 1
    else limit * factorial(limit - 1)
  }
  println(factorial(3))

  // 3. Fibonacci function (f(1) = 1; f(2) = 1; f(n) = f(n-1)+f(n-2)
  private def fibonacci(limit: Int): Int = {
    if(limit < 1) 0
    else if(limit <= 2) 1
    else fibonacci(limit - 1) + fibonacci(limit - 2)
  }
  println(fibonacci(8))

  // 4. Returns true if it's prime number
  private def isPrime(target: Int): Boolean = {
    def isPrimeUntil(limit: Int): Boolean = {
      if(limit <= 1) true
      else
        target % limit != 0 && isPrimeUntil(limit - 1)
    }
    isPrimeUntil(target / 2)
  }
  println(isPrime(3))
  println(isPrime(2003))
  println(isPrime(37 * 17))
}
