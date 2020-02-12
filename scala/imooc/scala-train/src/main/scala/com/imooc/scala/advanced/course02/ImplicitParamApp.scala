package com.imooc.scala.advanced.course02

//隐士参数
object ImplicitParamApp extends App {
  Param.print("Spark")("Scala")

  import Context_Implicits._      //引入，后续编译器自动找相应值作为隐士参数
  Param.print("Hadoop")
}

object Context_Implicits{
  implicit val default : String = "Java"
}
object Param{
  def print(content:String)(implicit language:String): Unit ={
    println(language+":"+content)
  }
}