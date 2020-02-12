package com.imooc.scala.base.course07


object FunctionApp extends App {
  /**
   * 1.  匿名函数：函数是可以命名的，也可以不命名
   * （参数名：参数类型...)=>函数体
   */
//  def sayHello(name:String): Unit ={
//    println("Hi: "+name)
//  }
//  sayHello("PK")
//
//  def incr = (x:Int)=>x+1
//  def add=(x:Int,y:Int)=>x+y
//  val m1 = (x:Int)=>x+1
//
//  println(incr(10))
//  println(m1(10))
//  println(add(3,4))

  //2. 将原来接受两个参数的一个函数，转换成2个，这就是Curry化，在Spark Sql中常见
//  def sum(a:Int,b:Int)=a+b
//  println(sum(2,3))
//
//  def sum2(a:Int)(b:Int)=a+b
//  println(sum2(2)(3))

  //3. 高阶函数
  val l = List(1,2,3,4,5,6,7,8)

  //map：逐个去操作集合中的每个元素
  l.map(x => x+1).foreach(println)
  l.map(_+2).foreach(println) //_代表集合中的每个元素
  l.map((_,1)).foreach(println)
  l.foreach(println)

  //filter
  l.map(_*2).filter(_>8).foreach(println)

  //reduce
  println(l.reduce(_+_)) //相邻元素相加
  println(l.reduceLeft(_-_))
  println(l.reduceRight(_-_))

  //fold
  println(l.fold(0)(_-_))

  println(l.max, l.min, l.sum)

  //flatten
  val f = List(List(1,2),List(3,4),List(5,6))
  println(f.flatten)

  //flatMap
  println(f.map(_.map(_*2)))
  println(f.flatMap(_.map(_*2)))

  val txt = scala.io.Source.fromFile("F:/workstation/scala/imooc/scala-train/src/main/scala/com/imooc/scala/course07/hello.txt").mkString
  val t = List(txt)
  t.flatMap(_.split(",")).map((_,1)).foreach(println) //后续如何统计单词量？
  t.flatMap(_.split(",")).map((_,1)).groupBy(_._1).foreach(println)//后续如何统计单词量？
  t.flatMap(_.split(",")).map((_,1)).groupBy(_._1).mapValues(_.map(_._2)).foreach(println)//后续如何统计单词量？
  t.flatMap(_.split(",")).map((_,1)).groupBy(_._1).mapValues(_.map(_._2)).mapValues(_.reduce(_+_)).foreach(println)//后续如何统计单词量？
}
