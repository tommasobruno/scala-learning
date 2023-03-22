package org.scala.learning
package beginner.lectures.oop

object Generics extends App {

  class MyList[+A] {

    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Dog = Animal

     */
  }
  class MyMap[K, V]

  val listInt = new MyList[Int]

  // Generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListInt = MyList.empty[Int]

  // Variance problem
  class Animal
  class Dog extends Animal
  class Cat extends Animal

  // 1. YES - List[Cat] extends List[Animal] = covariance
  class CovariantList[+A]
  val animal: Animal = new Cat()
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // adding new Dog would turn in a generic list (Animal)

  // 2. NO - invariance
  class InvariantList[A]
  val invariantAnimal = new InvariantList[Animal]

  // 3. Contravariance
  class Trainer[-A]
  val trainerList: Trainer[Cat] = new Trainer[Animal]

  // Bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
  // val cageCar = new Cage(new Car) Can't be ran


}
