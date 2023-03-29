package org.scala.learning
package beginner.lectures.patternMatching

import beginner.exercises.InheritanceExercises.{Empty, MyList, Cons}

object AllThePatterns extends App {

  // 1 - Constants + wildcard
  val x: Any = "String is scala"
  val constants = x match {
    case 1 => "A number"
    case "String is scala" => "THE SCALA"
    case true => "The truth"
    case AllThePatterns => "A singleton object"
    case _ => "Something else"
  }
  println(constants)

  // 2. Variables
  val variable = x match {
    case something => s"Found $something"
  }
  println(variable)

  // 3. Tuples
  val aTuple = 1 -> 2
  val matchATuple = aTuple match {
    case (1, 2) => "Found"
    case (key, 2) => s"Found $key"
  }
  println(matchATuple)

  val nestedTuple = (1, (2, 3))
  val matchNested = nestedTuple match {
    case (_, (2, v)) => s"Matched nested $v"
  }
  println(matchNested)

  // 4. Case classes - constructor pattern
  // PM can be nested with case classes
  val aList: MyList = Cons(1, Cons(1, Empty))
  val matchAList = aList match {
    case Empty => "List is empty"
    case Cons(head, Cons(subhead, subTail)) => ""
  }

  // 5. List patterns
  val aStandardList = List(1, 2, 3, 42)
  val aStandardListMatch = aStandardList match {
    case List(1, _, _, _) => // Extractor for lists
    case List(1, _*) => // list of arbitrary length
    case 1 :: List(_) => // infix pattern
    case List(1, 2, 3) :+ 42 => // more infix pattern
  }

  // 6. Type specifier
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // Explicit type specifier
    case _ => ""
  }

  // 7. Name binding
  val nameBindingMatch = aList match {
    case notEmpty @ Cons(_, _) => // Name binding -> use the pattern name here
    case Cons(1, rest @ _) => // Rest is now the tail
    case _ => ""
  }

  // 8. Multi patterns
  val multiPattern = aList match {
    case Empty | Cons(0, _) => // Compound pattern
  }

  // 9. Guards
  val secondElementMatch = aList match {
    case Cons(_, Cons(special, _)) if special % 2 == 0 => "Only if second element is pair"
  }
}
