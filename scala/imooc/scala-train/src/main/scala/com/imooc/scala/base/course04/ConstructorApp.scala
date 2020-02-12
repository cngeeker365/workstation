package com.imooc.scala.base.course04

object ConstructorApp {
  def main(args: Array[String]): Unit = {
//    val p1 = new Person("lisi", 30)
//    println(p1.name+" : "+p1.age+" : "+ p1.school)
//
//    val p2 = new Person("PK", 18, "M")
//    println(p2.name+" : "+p2.age+" : "+p2.gender)

    val s1 = new Student("pk", 18, "math")
    println(s1.name+" : "+s1.age+" : "+s1.major+" : "+s1.school)
    println(s1)
  }
}

//主构造器，new调用的, 若去掉val则外面无法访问
class Person(val name:String, val age:Int) {
  println("Person Constructor enter...")
  val school = "ustc"
  var gender:String = _
  //附属构造器
  def this(name:String, age:Int, gender:String){
    this(name, age) //附属构造器的第一行代码必须要调用主构造器或者其他附属构造器
    this.gender = gender
  }

  println("Person Constructor leave...")
}

class Student(name:String, age:Int, var major:String) extends Person(name,age){
  println("Student Constructor enter...")
  //重写
  override val school: String = "peking"
  override def toString: String = "override def toString"

  println("Student Constructor leave...")
}