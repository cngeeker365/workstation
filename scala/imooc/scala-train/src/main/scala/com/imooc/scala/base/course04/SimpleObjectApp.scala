package com.imooc.scala.base.course04

object SimpleObjectApp {
  def main(args: Array[String]): Unit = {
    val person = new People
    person.name="Messi"
    println(person.name+".."+person.age)

    println("invoke eat method:"+person.eat)
    person.watchFootball("Barcelona")

    person.printInfo()
//    println(person.gender) //此处无法直接访问gender，有private [this]修饰
  }
}

class People {
  //定义属性, _为占位符，默认值：Double 0.0，Int 0, String null
  var name:String = _ //默认 var 变量 是private[this]，自动生成def age：int的取值方法（getter）和def age_=(x$1:Int):Unit的赋值方法（setter）
  val age:Int = 10    //默认 val 变量 是private[this]，自动生成getter方法，但没有setter方法

  //private [this] 修饰，只能在class内部使用, this指本对象（不写this效果一样），也可以使用上级包名，如scala或course04，在指定包内使用
  private [this] val gender = "male"

  def printInfo(): Unit ={
    println("gender: "+gender)
  }

  def eat():String ={
    name + "eat..."
  }

  def watchFootball(teamName:String): Unit ={
    println(name + "is watching match of "+teamName)
  }
}