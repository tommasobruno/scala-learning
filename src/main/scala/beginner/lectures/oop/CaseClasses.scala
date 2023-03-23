package org.scala.learning
package beginner.lectures.oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. class params promoted to fields
  val jim = new Person("JIM", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim.toString)

  // 3. equals and hashcode implemented out of the box
  val person = new Person("JIM", 34)
  println(person == jim)

  // 4. copy method
  val newPerson = jim.copy(age = 45)
  println(newPerson)

  // 5. case classes have companion object
  val thePerson = Person
  val mary = Person("Mary", 20)

  // 6. serializable (possible to send through network)

  // 7. extractor patters => PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK"
  }


}
