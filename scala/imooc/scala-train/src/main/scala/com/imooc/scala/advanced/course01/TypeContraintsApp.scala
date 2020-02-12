package com.imooc.scala.advanced.course01

object TypeContraintsApp extends App {
  //A =:= B   //表示A类型等同于B类型
  //A <:< B   //表示A类型是B类型的子类型
  def rocky[T](i:T)(implicit ev: T <:< java.io.Serializable): Unit ={
    println("Life is short, you need spark!")
  }

  rocky("Spark")
}
