package com.imooc.scala.advanced.course02

object PathDependenceApp extends App {
  val outer = new Outer
  val inner1 = new outer.Inner
  val inner2 : outer.Inner = inner1

  val o1 = new Outer
  val o2 = new Outer
//  val i:o2.Inner = new o1.Inner
  val i1:o2.Inner = new o2.Inner   //路径依赖，o2.Inner类型与o1.Inner是不同的

  val i2 : Outer#Inner = new o1.Inner   //type projection 类型投影
  val i3 : Outer#Inner = new o2.Inner   //type projection 类型投影

  print(i2.getClass == i3.getClass)
}

class Outer{
  private val x = 10
  class Inner{
    //内部类能够访问外部类的私有变量，因为内部类会有外部类的实例，但外部类不能访问内部类的私有变量
    private val y = x+20
  }
}

