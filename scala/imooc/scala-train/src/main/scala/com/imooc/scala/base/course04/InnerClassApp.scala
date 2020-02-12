package com.imooc.scala.base.course04

object InnerClassApp extends App {
  val outer1 = new Outer("Spark")
  val outer2 = new Outer("Hadoop")
  val inner1 = new outer1.Inner("Scala")
  val inner2 = new outer1.Inner("Java")
  inner1.foo(inner1)
  inner2.foo(inner2)
}

class Outer(val name:String) {outer=>
  class Inner(val name:String){
    def foo(b:Inner) = println("Outer: "+outer.name+", Inner: "+b.name)
  }
}
