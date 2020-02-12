package com.imooc.scala.advanced.course05

object Assignment_Internals_02 extends App {
  val a@b = 1000
  println("a="+a+", b="+b)

  val (c, d) = (1000,2000)
//  val (e, F) = (1000,2000)  //  F会自动被认为是常量，需提前定义

  val Array(g,h) = Array(1000, 2000)

  object Test1{val 1 = 1} //传入内容是否为1
//  object Test2{val 1 = 2} //传入不成立，运行报错

  println(Test1)
//  println(Test2)
}
