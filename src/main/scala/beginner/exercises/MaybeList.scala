package org.scala.learning
package beginner.exercises

object MaybeList extends App {

  abstract class MaybeList[+T] {
    def map[B](f: T => B): MaybeList[B]
    def flatMap[B](f: T => MaybeList[B]): MaybeList[B]
    def filter(f: T => Boolean): MaybeList[T]
  }

  private case object MaybeNot extends MaybeList[Nothing] {
    override def map[B](f: Nothing => B): MaybeList[B] = MaybeNot
    override def flatMap[B](f: Nothing => MaybeList[B]): MaybeList[B] = MaybeNot
    override def filter(f: Nothing => Boolean): MaybeList[Nothing] = MaybeNot
  }

  case class Just[+T](value: T) extends MaybeList[T] {
    override def map[B](f: T => B): MaybeList[B] = Just(f(value))
    override def flatMap[B](f: T => MaybeList[B]): MaybeList[B] = f(value)
    override def filter(f: T => Boolean): MaybeList[T] = {
      if (f(value)) Just(value)
      MaybeNot
    }
  }

  val justThree = Just(3)
  println(justThree.map(_ * 2))
  println(justThree.flatMap(x => Just(s"$x is a value")))
  println(justThree.filter(_ % 2 == 0))
}
