package com.imooc.scala.base.course04

//Case Class 通常用在模式匹配
object CaseClassApp {
  def main(args: Array[String]): Unit = {
    val dog = Dog("wangcai")
    println(dog.name)

    val dog2 = dog.copy("goudan")
    val dog3 = dog.copy()

    println(dog2.name)
    println(dog3.name)

    println(dog2==dog) //false
    println(dog3==dog) //true
  }
}
//case class 不用new
case class Dog(name:String)