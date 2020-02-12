package com.imooc.scala.advanced.course05

//提取器下的模式匹配
object Extractor_Advanced_03 extends App {
  (1 to 9).toList match { case _ :> 9 => println("Hadoop") }
  (1 to 9).toList match { case x :> 8 :> 9 => println("Spark"+":"+ x) }
  (1 to 9).toList match { case :>(:>(_,8),9) => println("Flink")}
}

object :> {
  def unapply[A](list:List[A])={
    Some((list.init, list.last))
  }
}