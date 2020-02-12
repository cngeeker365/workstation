package com.imooc.scala.advanced.course02

object ImplicitObjectApp extends App {

  implicit object StringAdd extends SubTemplate[String]{
    def add(x:String, y:String) = x concat y
    def unit:String = ""
  }
  implicit object IntAdd extends SubTemplate[Int]{
    def add(x:Int, y:Int) = x+y
    def unit:Int = 0
  }

  def sum[T](xs:List[T])(implicit m:SubTemplate[T]):T = {
    if(xs.isEmpty) m.unit
    else m.add(xs.head, sum(xs.tail)) //递归
  }

  println(sum(List(1,2,3,4,5,6)))   //找 隐式对象 IntAdd
  println(sum(List("Scala","Spark","Kafka"))) //找 隐式对象 StringAdd
}

abstract class Template[T]{
  def add(x:T, y:T):T
}
abstract class SubTemplate[T] extends Template[T]{
  def unit:T
}