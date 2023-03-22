package org.scala.learning
package beginner.exercises

object BasicExercises extends App {

  private def writerNovelClass() = {
    class Writer(val firstName: String, val surname: String, val year: Int) {

      def fullName(): String = s"$firstName $surname"
    }

    class Novel(name: String, val yearOfRelease: Int, author: Writer) {

      def authorAge(): Int = yearOfRelease - author.year

      def isWrittenBy(author: Writer): Boolean =
        this.author.firstName == author.firstName &&
          this.author.surname == author.surname

      def copy(newYear: Int): Novel = new Novel(name, newYear, author)
    }

    val writerInstance = new Writer("Tommaso", "Bruno", 1999)
    val novelInstance = new Novel("Sherlock Holmes", 2020, writerInstance)

    val newNovel = novelInstance.copy(2004)
    println(newNovel.yearOfRelease)
    println(novelInstance.authorAge())
    println(novelInstance.isWrittenBy(writerInstance))
  }

  private def counterClass() = {

    class Counter(value: Int) {
      def getCurrent(): Int = this.value

      def increment(): Counter = new Counter(this.value + 1)

      def increment(value: Int) = new Counter(this.value + value)

      def decrement(): Counter = new Counter(this.value - 1)

      def decrement(value: Int) = new Counter(this.value - value)
    }

    val counter = new Counter(1)
    println(counter.getCurrent())
    println("Increment")
    println(counter.increment().getCurrent())
    println(counter.increment(3).getCurrent())
    println("Decrement")
    println(counter.decrement().getCurrent())
    println(counter.decrement(3).getCurrent())
  }

  counterClass()
  writerNovelClass()
}
