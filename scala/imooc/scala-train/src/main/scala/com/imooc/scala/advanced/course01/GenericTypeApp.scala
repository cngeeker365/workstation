package com.imooc.scala.advanced.course01

object GenericTypeApp extends App {
  val triple = new Triple("Spark",3.14, 3)
  val bigData = new Triple[String, String, Char]("Spark","Hadoop","R")

  //泛型函数
  def getData[T](list:List[T]) = list(list.length/2)
  println(getData(List("Spark","Hadoop",'R')))

  val f = getData[Int] _
  println(f(List(1,2,3,4,5,6)))

}
//泛型类
class Triple[F,S,T](val first:F, val second:S, val third:F)
