package com.imooc.scala.base.course05

object ArrayApp extends App {
//  val a = new Array[String](5)
//  println(a.length)
//  a(1)="hello"
//  println(a)
//
//  val b = Array("hadoop", "spark", "storm")
//  b(1) = "flink"
//
//  val c = Array(2,3,4,5,6,7,8,9)
//  println(c.sum, c.max, c.min)
//  println(c.mkString(","))
//  println(c.mkString("<",",",">"))

  val d = scala.collection.mutable.ArrayBuffer[Int]()
  println(d.length)
  d+=1
  d+=2
  d+=(3,4,5)
  d++=Array(6,7,8)
  d.insert(0,0)
  d.remove(1)
  d.remove(0,3)
  d.trimEnd(2)
  println(d)
//  for(i<- (0 until d.length).reverse ){
//    println(d(i))
//  }
//  for(i<-d) println(i)
//  d.foreach(i=>println(i))
  println(d.toArray)
}
