package com.imooc.scala.base.course05

import scala.collection.mutable

object SetApp extends App {
  val s1 = Set(1,2,2,4,5,6)
  print(s1)

  val s2 = scala.collection.mutable.Set[Int]()
//  val s2 = scala.collection.mutable.Set.empty[Int]
  s2 += 1
  s2 += (1,2,3)
  s2 += 1
  println(s2)
  s2.clear
  println(s2)

  val ts = mutable.TreeSet(9,3,2,8,0,1,7,4,6,5)
  println(ts)
  val ts4c = mutable.TreeSet("Spark","Scala","Hadoop")
  println(ts4c)


}
