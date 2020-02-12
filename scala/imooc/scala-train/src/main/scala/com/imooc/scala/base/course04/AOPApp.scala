package com.imooc.scala.base.course04

object AOPApp extends App {
  val work = new Work with TBeforeAfter
  work.doAction
}

trait Action{
  def doAction
}

trait TBeforeAfter extends Action{
  abstract override def doAction: Unit = {
    println("Initialization")
    super.doAction
    println("Destoryed")
  }
}

class Work extends Action{
  override def doAction: Unit = println("Working...")
}