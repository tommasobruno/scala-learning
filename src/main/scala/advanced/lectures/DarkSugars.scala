package org.scala.learning
package advanced.lectures

import scala.util.Try

object DarkSugars extends App {

  // 1. Methods with single param
  def singleArgMethod(arg: Int): String = s"$arg ducks"

  val description = singleArgMethod {
    // write some code
    42
  }

  val aTryInstance = Try { // similar to java try {...}
    throw new RuntimeException()
  }

  List(1, 2, 3).map { x =>
    x + 1
  }

  // 2. Single abstract method pattern
  trait Action {
    def act(x: Int): Int
  }

  val anInstance: Action = (x: Int) => x + 1 // Compiler find act method and convert

  // Example: Runnable
  val aThread = new Thread(() => println("Hello Scala"))

  abstract class AnAbstractType {
    def implemented: Int = 23
    def f(a: Int): Unit
  }

  val anInstanceClass: AnAbstractType = (a: Int) => println(a)

  // 3. The :: and #:: methods
  val prependedList = 2 :: List(3, 4) // 2.::(List(3, 4)) Wrong
  // Last character decided associativity -> :: right associative -> is able to reverse the arguments.


  class MyStream[T] {
    def -->:(value: T): MyStream[T] = this
  }

  val myStream = 1 -->: 2 -->: 3 -->: new MyStream[Int]

  // 4. Multi word method naming
  class TeenGirl(name: String) {
    def `and then said`(gossip: String) = println(s"$name said $gossip")
  }

  val lily = new TeenGirl("Lily")
  lily `and then said` "Scala is sweet"

  // 5. Infix types
  class Composite[A, B]
  val composite: Int Composite String = ???

  class -->[A, B]
  val towards: Int --> String = ???

  // 6. Update() is very special, much like apply()
  val anArray = Array(1, 2, 3)
  anArray(2) = 7 // Re-written as anArray.update(2, 7)
  // Used in mutable collection

  // 7. Setter for mutable collection
  class Mutable {
    private var internalMember: Int = 0 // OO encapsulation
    def member = internalMember // Getter
    def member_=(value: Int): Unit = internalMember = value // Setter
  }

  val container = new Mutable()
  container.member = 42 // Re written as container.member_=(42)
}
