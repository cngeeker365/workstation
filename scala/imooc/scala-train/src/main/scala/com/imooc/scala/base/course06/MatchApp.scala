package com.imooc.scala.base.course06

import scala.util.Random

object MatchApp extends App {
//  val names = Array("A1","A2","A3")
//  val name = names(Random.nextInt(names.length))
//
//  name match {
//    case "A1" => println("A1...")
//    case "A2" => println("A2...")
//    case _ => println("A3...")
//  }

//  def judgeGrade(grade:String)={
//    grade match{
//      case "A" => println("Excellent...")
//      case "B" => println("Good...")
//      case "C" => println("Just so so...")
//      case _ => println("work harder...")
//    }
//  }
//
//  judgeGrade("A")
//  judgeGrade("B")
//  judgeGrade("F")

//  def judgeGrade(name:String,grade:String)={
//        grade match{
//          case "A" => println("Excellent...")
//          case "B" => println("Good...")
//          case "C" => println("Just so so...")
//          case _ if(name=="lisi")=> println(name + "work harder...")
//          case _ => println("work harder...")
//        }
//      }
//
//      judgeGrade("zhangsan", "D")
//      judgeGrade("lisi", "D") //双重过滤

  //Array模式匹配
//  def greeting(array:Array[String]): Unit ={
//    array match {
//      case Array("zhangsan") => println("Hi:zhangsan")
//      case Array(x,y) => println("Hi:"+x+" , "+y)
//      case Array("zhangsan", _*) => println("Hi:zhangsan and other friends...")
//      case _ => println("Hi: everybody...")
//    }
//  }
//  greeting(Array("zhangsan"))
//  greeting(Array("zhangsan","lisi"))
//  greeting(Array("zhangsan","lisi","wangwu"))
//  greeting(Array("lisi","zhangsan"))
//  greeting(Array("lisi","zhangsan","wangwu"))

  //List模式匹配
//  def greeting(list:List[String]): Unit ={
//    list match {
//      case "zhangsan"::Nil => println("Hi zhangsan")
//      case x::y::Nil => println("Hi "+x+" , "+y)
//      case "zhangsan"::tail => println("Hi zhangsan and other friends...")
//      case _ => println("Hi everybody...")
//    }
//  }
//  greeting(List("zhangsan"))
//  greeting(List("zhangsan","lisi"))
//  greeting(List("zhangsan","lisi","wangwu"))
//  greeting(List("lisi","wangwu"))
//  greeting(List("lisi","wangwu","zhangsan"))

  //Tuple匹配
  def match_tuple(tuple:Any) = tuple match {
    case (0,_) => println("Tuple:"+"0")
    case (x,0) => println("Tuple:"+x)
    case _ => println("something else")
  }
  match_tuple((0,"scala"))
  match_tuple((2,0))
  match_tuple((0,1,2,3,4,5))


  //类型匹配
//  def matchType(obj:Any): Unit ={
//    obj match {
//      case x:Int => println("Int")
//      case x:String => println("String")
//      case x:Map[_,_] => x.foreach(println)
//      case _ => println("other type")
//    }
//  }
//  matchType(Map("name"->"pk"))

  val data = 2
  val result = data match {
    case i if i==1 => "The First"
    case num if num==2 => "The Second"
    case _ => "Not Known Num"
  }
  println(result)

  "Spark !".foreach(c=>println(
    c match {
      case ' ' => "space"
      case ch => "Char: "+ch
    }
  ))

  //case class模式匹配
  class Person
  case class CTO(name:String, floor:String) extends Person
  case class Employee(name:String, floor:String) extends Person
  case class Other(name:String) extends Person

  def caseClassMatch(person: Person): Unit ={
    person match {
      case CTO(name, floor) => println("CTO is "+name+" , floor = "+floor)
      case Employee(name, floor) => println("Employee is "+name+" , floor = "+floor)
      case _ => println("other")
    }
  }
  caseClassMatch(CTO("pk","22"))
  caseClassMatch(Employee("zhangsan","18"))
  caseClassMatch(Other("lisi"))

  //case class 模式匹配高级操作
  abstract class Item
  case class Book(desc:String, price:Double) extends Item
  case class Bundle(desc:String, price:Double, items:Item*) extends Item

  def caseClass_nested(item:Item) = item match {
    case Bundle(_,_, art@Book(_,_), rest@_*) => println(art.desc+" : "+art.price)
//    case Bundle(_,_, Book(desc,_),_*) => println("The 1st description is : "+desc)
    case _ => println("Oops!")
  }

  caseClass_nested {
    Bundle("1111 Special's", 30.0,
      Book("Scala for the Spark Developer", 69.95),
      Bundle("Hadoop", 40.0,
        Book("Hive", 79.95),
        Book("HBase", 32.95)))
  }
}
