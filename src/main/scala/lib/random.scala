package lib

import scala.util.Random

object random {
  def listElement(A: List[List[String]]): List[String] = {
    val rand = new Random(System.currentTimeMillis())
    val random_index = rand.nextInt(A.length)
    A(random_index)
  }
}