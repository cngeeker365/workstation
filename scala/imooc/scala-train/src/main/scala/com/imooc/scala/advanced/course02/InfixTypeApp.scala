package com.imooc.scala.advanced.course02

//中职类型
object InfixTypeApp extends App {
  object Log {
    def >>:(data:String):Log.type = {println(data); Log}
  }
  "Hadoop" >>: "Spark" >>: Log //右结合

  val list = List()
  val newList = "A"::"B"::list  //右结合
  println(newList)

  class Infix_Type[A,B]
  val infix1: Int Infix_Type String = null
  val infix2: Infix_Type[Int,String] = null

  case class Cons(first:String, second:String)
  val case_class = Cons("One", "Two")
  case_class match {
    case "One" Cons "Two" => println("Spark!!!") //unapply
  }
}
