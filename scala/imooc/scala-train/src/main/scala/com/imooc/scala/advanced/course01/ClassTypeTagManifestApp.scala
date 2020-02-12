package com.imooc.scala.advanced.course01

import scala.reflect.ClassTag

object ClassTypeTagManifestApp extends App {

  //Manifest 记录上下文，在运行期间，可以通过隐式值，记录泛型T的真实值
  def arrayMake[T:Manifest](first:T, second:T) ={
    val r = new Array[T](2) //通常是不可创建泛型Array的，但由于Manifest的存在，使这成为可能
    r(0)=first
    r(1)=second
    r
  }
  arrayMake(1,2).foreach(println)

  //ClassTag 在运行期间，ClassTag记录泛型T的真实类型，并通过隐式值传给JVM执行
  //ClassTag 仅包含运行时指定的具体类型，比TypeTag更常用，运行时信息足够了
  //TypeTag  包含所有静态类信息
  def mkArray[T:ClassTag](elem:T*) = Array[T](elem:_*)
  mkArray(42,13).foreach(println)
  mkArray("Japan","Brazil","Germany").foreach(println)

  //这里是最原始的写法
  // implicit m: Manifest[T] 通过隐式值记录T的具体类型，这种写法现在不常用，常用ClassTag的形式
  def manif[T](x:List[T])(implicit m:Manifest[T]): Unit ={
    if( m <:< manifest[String])
      println("List Strings")
    else
      println("Some other type")
  }
  manif(List("Spark","Hadoop"))
  manif(List(1,2))
  manif(List("Scala", 3))

  //已下代码已失效
//  val m = manifest[A[String]]
//  println(m)
//  val cm = classManifest[A[String]]
//  println(cm)
}

