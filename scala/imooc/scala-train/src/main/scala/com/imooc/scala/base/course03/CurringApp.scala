package com.imooc.scala.base.course03

object CurringApp extends App {
  def multiple(x:Int,y:Int) = x*y
  def multipleOne(x:Int)=(y:Int)=>x*y
  println(multipleOne(6)(7))

  def curring(x:Int)(y:Int)=x*y
  println(curring(6)(7))

  val a = Array("Hello","Spark")
  val b = Array("hello","spark")
  println(a.corresponds(b)(_.equalsIgnoreCase(_)))
}
