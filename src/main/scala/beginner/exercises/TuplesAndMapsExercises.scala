package org.scala.learning
package beginner.exercises

object TuplesAndMapsExercises extends App {

  /*
  Exercises
   */

  // 1. What happens if I had to original entries "Jim" -> 555 and "JIM" -> 999
  /* 2. Overly simplified social network with maps
        Person is a string
        - Add a person
        - Remove a person
        - Friend
        - Unfriend

        - number of friends of person
        - person with most friends
        - how many people have no friends
        - if there is social connection between to people (direct or not)
   */
  type Person = String
  case class SocialNetwork(net: Map[String, Set[Person]]) {
    def addPerson(person: Person): SocialNetwork = {
      val tuplePerson = (person, Set.empty[Person])
      SocialNetwork(net + tuplePerson)
    }

    def removePerson(person: Person): SocialNetwork = {
      SocialNetwork(net.view.filterKeys(!_.equals(person)).toMap)
    }

    def unfriend(from: Person, to: Person): SocialNetwork = {
      if (!net.contains(from) || !net.contains(to)) {
        SocialNetwork(net)
      } else {
        val newFriends: Set[Person] = net(from) - to
        val toFriends: Set[Person] = net(to) - from
        SocialNetwork(net + (from -> newFriends) + (to -> toFriends))
      }
    }

    def addFriend(from: Person, to: Person): SocialNetwork = {
      if (!net.contains(from) || !net.contains(to)) {
        SocialNetwork(net)
      } else {
        val newFriends: Set[Person] = net(from) + to
        val toFriends: Set[Person] = net(to) + from
        SocialNetwork(net + (from -> newFriends) + (to -> toFriends))

      }
    }

    // STATS

    def friendsOf(person: Person): Int = {
      if (!net.contains(person)) 0
      else net(person).size
    }

    def personWithMostFriends(): Person = {
      net.maxBy(_._2.size)._1
    }

    def peopleWithNoFriends(): Int = {
      net.filter(pair => pair._2.isEmpty).size
    }

    def isThereSocialConnection(from: Person, to: Person): Boolean = {
      if (!net.contains(from) || !net.contains(to)) false
      else if (net(from).contains(to)) true

      else {
        val filter = net(from).find(_.contains(to))
        filter match {
          case Some(_) => true
          case _ => false
        }
      }
    }
  }
  private object SocialNetwork {
    def apply(): SocialNetwork = SocialNetwork(Map())
  }

  val social = SocialNetwork()

  // Adding social persons
  val withFriend = social
    .addPerson("Jim")
    .addPerson("Tommy")
    .addPerson("Mary")
    .addPerson("NoFriend")
    .addPerson("ToRemove")
    .removePerson("ToRemove")

  println(withFriend)
  val friendly = withFriend.addFriend("Jim", "Tommy").addFriend("Tommy", "Mary")
  println(friendly)

  // Friends
  println(friendly.friendsOf("Jim"))
  println(friendly.unfriend("Jim", "Tommy").friendsOf("Jim"))

  // Stats
  println(friendly.personWithMostFriends())
  println(friendly.peopleWithNoFriends())
  println(friendly.isThereSocialConnection("Jim", "Tommy"))
  println(friendly.isThereSocialConnection("Jim", "NoFriend"))
}
