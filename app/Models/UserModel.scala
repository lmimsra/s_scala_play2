package Models

/**
  * Created by mmr on 2017/04/15.
  */
case class User(id:Long,user_id:String,email:String,name:String,isAdmin:Boolean)
case class Password(id:Long,user_id:Long,password:String)