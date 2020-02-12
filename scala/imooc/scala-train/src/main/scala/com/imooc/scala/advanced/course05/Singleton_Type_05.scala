package com.imooc.scala.advanced.course05
import scala.reflect.runtime.universe._

object Singleton_Type_05 extends App {
  println(Scala.getClass)
  println(typeOf[Scala.type ])
  println()

  val java = new Java1
  val java2 = new Java1
  println(typeOf[java.type])
  println(typeOf[java2.type ])
  val content:java.type = java
  println()

  val jvm = new JVM_Language
  println(jvm.method1)
  println(jvm.method1.method2)
}

object Scala
class Java1
class JVM { def method1: this.type = this }
class JVM_Language extends JVM { def method2 : this.type = this }