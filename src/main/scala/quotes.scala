import lib._

object quotes extends App {
  val user = "motd"
  val db = "motd"
  val pass = "motd"
  val conn = mysql.connect(user, pass, db)

  val results = mysql.execute(conn, "select * from quotes")

  val quote: List[String] = random.listElement(results)

  println(quote(1))
  println("-- " + quote(2))

  mysql.close(conn)
}