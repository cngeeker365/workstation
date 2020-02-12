package com.imooc.scala.base.course04

object TraitApp extends App {
//  val logger = new ConcreteLogger
  val logger = new ConcreteLogger with TraitLogger
  logger.concreteLog
}

trait Logger{
//  def log(msg:String)
  def log(msg:String){}
}

class ConcreteLogger extends Logger with Cloneable{
  def concreteLog: Unit ={
    log("It's me!!!")
  }
}

trait TraitLogger extends Logger{
  override def log(msg: String): Unit = println("TraitLogger Log Content is : "+msg)
}
