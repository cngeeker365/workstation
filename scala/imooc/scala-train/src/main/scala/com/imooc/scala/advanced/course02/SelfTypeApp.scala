package com.imooc.scala.advanced.course02

object SelfTypeApp extends App {
  trait S1
  class S2 { this:S1 => } // this:S1 要求 继承或创建 S2时，必须混入S1
  class S3 extends S2 with S1
  object S4 extends S2 with S1

  val c = new S2 with S1
}

class Outer{ outer => //outer是this的别名
  val v1 = "Spark"
  class Inner {
    println(outer.v1)
  }
}

class Self{
  self =>     //self是this的别名
  val tmp = "Scala"
  def foo = self.tmp+this.tmp
}

