package com.imooc.scala.base.course03

//偏函数：参考：https://www.jianshu.com/p/5d3b5881ae13
object PartialFuncApp extends App {
  def sum(a:Int,b:Int,c:Int)=a+b+c

  println(sum(1,2,3))

  val fp_a = sum _   //_代表了缺省的3个参数
  println(fp_a(1,2,3))
  println(fp_a.apply(1,2,3)) //apply为自动生成的，内部调用了sum

  val fp_b = sum(1,_:Int,3) //仅缺省一个参数
  println(fp_b(2))

  val data = List(1,2,3,4,5,6)
  data.foreach(println _)
  data.foreach(println)
}
