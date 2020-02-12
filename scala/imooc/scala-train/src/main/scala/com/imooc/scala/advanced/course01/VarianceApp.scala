package com.imooc.scala.advanced.course01

//协变与逆变：不常用，理解
object VarianceApp extends App {
  def makeFriendWithYou(s:Student, f:Friend[Student]): Unit ={
    f.makeFriend(s)
  }

  val value:C[Person] = new C[Student](new Student)

  val list:List[_<:Any] = List[String]("Spark")
}

class Person
class Student extends Person
// +T 协变：即 B是A的子类，则 C[B]是C[A]的子类
class C[+T](val args:T)
// 当一个类要继承 形变类，则该类也要支持形变
class S[+T](arg:T) extends C[T](arg)
// -T 逆变：即 A是B的父类，则 F[A]是F[B]的子类
trait Friend[-T]{
  def makeFriend(somebody:T)
}