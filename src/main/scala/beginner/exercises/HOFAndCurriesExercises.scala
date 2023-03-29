package org.scala.learning
package beginner.exercises

object HOFAndCurriesExercises extends App {

  abstract class MyList[+A] {
    def head: A
    def tail: MyList[A]
    def isEmpty: Boolean
    def add[B >: A](el: B): MyList[B]
    def printElements: String
    def forEach[B >: A](x: B => Unit): Unit
    def sort[B >: A](f: (B, B) => Int): MyList[B]
    override def toString: String = s"[ ${printElements} ]"
  }

  object Empty extends MyList[Nothing] {
    override def head: Nothing = throw new NoSuchElementException()
    override def tail: MyList[Nothing] = throw new NoSuchElementException()
    override def isEmpty: Boolean = true
    override def add[B >: Nothing](el: B): MyList[B] = new InterList(el, Empty)
    override def printElements: String = ""
    override def forEach[B >: Nothing](f: B => Unit) = println()
    override def sort[B >: Nothing](f: (B, B) => Int): MyList[B] = this
  }

  class InterList[+A](h: A, t: MyList[A]) extends MyList[A] {
    override def head: A = h
    override def tail: MyList[A] = t
    override def isEmpty: Boolean = false
    override def add[B >: A](el: B): MyList[B] = new InterList(el, this)
    override def forEach[B >: A](f: B => Unit) = {
      f(h)
      tail.forEach(f)
    }
    override def sort[B >: A](f: (B, B) => Int): MyList[B] = {

      def insert(x: B, sortedTail: MyList[B]): MyList[B] = {
        if (sortedTail.isEmpty) new InterList[B](x, Empty)
        else if (f(x, sortedTail.head) <= 0) new InterList[B](x, sortedTail)
        else new InterList[B](sortedTail.head, insert(x, sortedTail.tail))
      }

      val sortedTail = tail.sort(f)
      insert(head, sortedTail)
    }

    override def printElements: String = {
      if (tail.isEmpty) s"$h"
      else s"$head ${tail.printElements}"
    }
  }

  val listInteger: InterList[Int] = new InterList(4, new InterList(2, new InterList(1, Empty)))
  println(listInteger.printElements)
  listInteger.forEach(print)
  val list = listInteger.sort((x, y) => x - y)
  println(list.printElements)
}
