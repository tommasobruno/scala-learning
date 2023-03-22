package org.scala.learning
package beginner.exercises

abstract class MyList {
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(el: Int): MyList
  def printElements: String
  override def toString: String = s"[ ${printElements} ]"
}

private object Empty extends MyList {
  override def head: Int = throw new NoSuchElementException
  override def tail: MyList = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add(el: Int): MyList = new Cons(el, Empty)
  override def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  override def head: Int = h
  override def tail: MyList = t
  override def isEmpty: Boolean = false
  override def add(el: Int): MyList = new Cons(el, this)
  override def printElements: String = {
    if (tail.isEmpty) "" + h
    else s"$h ${tail.printElements}"
  }
}

object InheritanceExercises extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)
  println(list.add(4).toString)
}
