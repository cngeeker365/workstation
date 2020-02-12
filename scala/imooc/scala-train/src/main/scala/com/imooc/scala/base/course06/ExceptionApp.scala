package com.imooc.scala.base.course06

//Scala异常处理
object ExceptionApp extends App {
  try{

    //open file
    //use file

    val i = 10/0
    println(i)
  }catch {
    case e:ArithmeticException => println("除数不能为0...")
    case e:Exception => println(e.getMessage)
  }finally {
    //释放资源，一定能执行: close file
  }

}
