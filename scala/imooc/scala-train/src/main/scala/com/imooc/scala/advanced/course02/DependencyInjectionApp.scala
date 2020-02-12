package com.imooc.scala.advanced.course02

object DependencyInjectionApp extends App {
  DI.act("I hope you will like it...")
}

trait Logger{
  def log(msg:String)
}
trait Auth{
  auth:Logger =>
  def act(msg:String)=log(msg)
}
object DI extends Auth with Logger {
  override def log(msg: String): Unit = println(msg)
}