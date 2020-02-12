package com.imooc.scala.advanced.course02

//链式调用：this.type
object ChainableApp extends App {
  val cat = new Cat
  cat.breathe.eat
}

class Animal {
  def breathe: this.type = this
}

class Cat extends Animal{
  def eat: this.type = this
}
