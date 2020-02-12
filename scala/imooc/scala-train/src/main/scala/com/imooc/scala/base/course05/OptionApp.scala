package com.imooc.scala.base.course05

/**
 * sealed abstract class Option[A+] extends Production with Serializable  //sealed 要求Option下的case class和case object都必须在一个文件中
 */
object OptionApp extends App {
  val scores = Map("Alice"->99, "Spark"->100)

  scores.get("Alice") match { //scores.get("Alice") 返回Option
    case Some(score) => println(score)
    case None => println("No score")
  }
}
