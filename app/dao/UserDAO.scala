package dao

import javax.inject.Inject

import Models.{Password, User}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.driver.JdbcProfile
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by mmr on 2017/04/15.
  */

class UserDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider) extends HasDatabaseConfigProvider[JdbcProfile] {

  import driver.api._
  private val Users = TableQuery[UserTable]
  private val Passwords = TableQuery[PasswordTable]

  //Userテーブル定義
  private class UserTable(tag: Tag) extends Table[User](tag, "User") {
    def id = column[Long]("id", O.AutoInc, O.PrimaryKey)
    def user_id = column[String]("user_id")
    def email = column[String]("email")
    def name = column[String]("name")
    def isAdmin = column[Boolean]("isAdmin")
    def * = (id,user_id,email,name,isAdmin)<>(User.tupled,User.unapply _)
  }

  //Passwordテーブル定義
  private class PasswordTable(tag: Tag)extends Table[Password](tag,"Password"){
    def id =column[Long]("id",O.PrimaryKey,O.AutoInc)
    def user_id = column[String]("user_id")
    def password = column[String]("password")
    def * = (id,user_id,password)<>(Password.tupled,Password.unapply _)
  }

//  def all():Future[Seq[Book]] = db.run(Books.result)
//
//  def insert(book: Book):Future[Unit] = db.run(Books += book).map{ _ => () }


}
