package org.scala.learning
package beginner.exercises

object GenericsExercises extends App {

  abstract class MyList[+A] {
    def head: A
    def tail: MyList[A]
    def isEmpty: Boolean
    def add[B >: A](el: B): MyList[B]
    def printElements: String
    override def toString: String = s"[ ${printElements} ]"
  }

  object Empty extends MyList[Nothing] {
    override def head: Nothing = throw new NoSuchElementException()
    override def tail: MyList[Nothing] = throw new NoSuchElementException()
    override def isEmpty: Boolean = true
    override def add[B >: Nothing](el: B): MyList[B] = new InterList(el, Empty)
    override def printElements: String = ""
  }

  class InterList[+A](h: A, t: MyList[A]) extends MyList[A] {
    override def head: A = h
    override def tail: MyList[A] = t
    override def isEmpty: Boolean = false
    override def add[B >: A](el: B): MyList[B] = new InterList(el, this)
    override def printElements: String = {
      if(tail.isEmpty) s"$h"
      else s"$head ${tail.printElements}"
    }
  }

  val listInteger: InterList[Int] = new InterList(2, new InterList(2, new InterList(3, Empty)))
  val listString: InterList[String] = new InterList("hello", Empty)

  println(listInteger.toString)
  println(listString.toString)
}
