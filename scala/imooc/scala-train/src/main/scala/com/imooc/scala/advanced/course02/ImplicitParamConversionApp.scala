package com.imooc.scala.advanced.course02

object ImplicitParamConversionApp extends App {
  // ordered:T => Ordered[T] 即 输入T，输出Ordered[T]的隐式转换函数
  def bigger[T](a:T, b:T)(implicit ordered:T => Ordered[T])
    = if (a > b) a else b

  println(bigger(4,3))
  println(bigger("Spark","Hadoop"))
}
