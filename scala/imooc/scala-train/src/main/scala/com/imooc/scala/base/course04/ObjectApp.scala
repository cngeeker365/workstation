package com.imooc.scala.base.course04

object ObjectApp extends App {
  println(University.newStudentNo)
  println(University.newStudentNo)
}

class University{
  val id = University.newStudentNo
  private var num = 0
  def aClass(num:Int){this.num+=num}
}

object University{
  private var studentNo = 0
  def newStudentNo = {
    studentNo+=1
    studentNo
  }
}