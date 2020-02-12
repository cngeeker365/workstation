package com.imooc.scala.base.course06

object RegMatchApp extends App {
  val regex="""([0-9]+) ([a-z]+)""".r
  val numPattern = "[0-9]+".r
  val numberPattern = """\s+[0-9]+\s+""".r

  //返回所有匹配项的迭代器
  for(matchStr <- numPattern.findAllIn("3312 spark 1212 hadoop")) println(matchStr)

  //找首个匹配项
  println(numPattern.findFirstIn("99ss java 222 hadoop"))

  val regex(num, item) = "99 hadoop"
  println(num, item)

  val line = "939459 spark"
  line match{
      //基于正则的模式匹配
    case regex(num, item) => println(num+"\t"+item) //提取器Extractor将值提取到num、item
    case _ => println("ohh...")
  }
}
