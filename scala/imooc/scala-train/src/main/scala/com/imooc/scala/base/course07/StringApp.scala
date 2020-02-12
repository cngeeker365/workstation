package com.imooc.scala.base.course07

object StringApp extends App {
  val s = "Hello:"
  val name = "PK"
  println(s+name)

  //插值
  println(s"Hello:$name")
  val ac = "AC Milan"
  println(s"Hello:$ac")

  val b=
    """
      |这是一个多行字符串
      |Hello
      |World
      |PK
      |""".stripMargin
  println(b)
}
