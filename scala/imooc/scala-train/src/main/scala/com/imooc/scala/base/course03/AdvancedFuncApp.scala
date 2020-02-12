package com.imooc.scala.base.course03
import scala.math._
object AdvancedFuncApp extends App {
  (1 to 9).map("*"*_).foreach(println)
  (1 to 9).filter(_%2==0).foreach(println)
  println((1 to 9).reduceLeft(_*_))

  "Spark is the most exciting thing".split(" ").sortWith(_.length<_.length).foreach(println)

  val fun = ceil _
  Array(3.14,1.42,2.1).map(fun).foreach(println)

  val triple = (x:Double)=>3*x
  Array(3.14,1.42,2.1).map((x:Double)=>3*x).foreach(println)

  def high_order_func(f:(Double)=>Double) = f(0.25)
  println(high_order_func(ceil _))
  println(high_order_func(sqrt _))
  println(high_order_func(x=>3*x))
  println(high_order_func(3*_))

  val fun2 = 3*(_:Double)
  val fun3: Double => Double = 3*_

  println(fun3(13.0))
}
