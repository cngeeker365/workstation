package com.imooc.scala.advanced.course05
import scala.reflect.runtime.universe._

//Type 与 Class 实战
object Type_Advanced_04 extends App {
  println( typeOf[Spark] )
  println( classOf[Spark] ) //获得具体的类
  println()

  val spark = new Spark
  println(spark.getClass) //getClass获得具体类的子类，Class[_ <: Spark]
  println()

  println(classOf[Hadoop])
  println(typeOf[Hadoop])
  println()

  println(Flink.getClass) //Flink没有具体类，尽管后台会生成一个Flink$类，所以不能用 classOf[Flink]
  println()

  val java1 = new Java
  val java2 = new Java
  val scala1 = new java1.Scala
  val scala2 = new java2.Scala
  println(scala1.getClass)
  println(scala2.getClass)
  println(typeOf[java1.Scala] == typeOf[java2.Scala])
  println(typeOf[java1.Scala])
  println(typeOf[java2.Scala])
  println()

  println(classOf[List[Int]] == classOf[List[String]])
  println(classOf[List[Int]])
  println(classOf[List[String]])
  println(typeOf[List[Int]] == typeOf[List[String]])
  println(typeOf[List[Int]])
  println(typeOf[List[String]])
}

class Spark
trait Hadoop
object Flink
class Java{
  class Scala
}