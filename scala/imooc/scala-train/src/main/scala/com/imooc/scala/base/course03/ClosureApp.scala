package com.imooc.scala.base.course03

object ClosureApp extends App {
  val data = List(1,2,3,4,5,6,7,8,9)
  var sum = 0
  data.foreach(sum+=_)

  def add(more:Int) = (x:Int)=>x+more  //必报
  println(add(1)(2))

  val a = add(1)
  val b = add(100)
  println(a(10))
  println(b(10))
}
