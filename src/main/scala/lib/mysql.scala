package lib

import java.sql.{Connection, DriverManager, ResultSet}
import scala.collection.JavaConversions._
import custom._

object mysql {

  def connect(user: String, pass: String, db: String): Connection = {
    val connectionString = s"jdbc:mysql://localhost:3306/$db?user=$user&password=$pass"

    DriverManager.getConnection(connectionString)
  }

  def execute(conn: Connection, stmt: String): List[List[String]] = {
    val statement = conn.createStatement()
    val resultSet = statement.executeQuery(stmt)

    resultSetToList(resultSet)
  }

  def resultSetToList(resultSet: ResultSet): List[List[String]] = {
    val results = ResultConverter.convert(resultSet).map(x => x.toList)
    results.toList
  }

  def close(conn: Connection) = conn.close()

}