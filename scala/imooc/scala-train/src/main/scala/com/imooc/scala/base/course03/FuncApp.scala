package com.imooc.scala.base.course03

object FuncApp {
  def main(args: Array[String]): Unit = {
//    println(add(2,3))
//    println(three())
//    println(three) //没有入参的函数，调用时括号可省略
//    sayHello
//    sayName()
//    sayName("lisi")
//    loadConf()
//    loadConf("spark-production.conf") //模擬使用自定義配置文件
    /*命名參數*/
//    println(speed(100, 10))
//    println(speed(distance = 100, time = 10))
//    println(speed(time = 10, distance = 100))
    /*可變參數*/
//    println(sum(1,2,3,4,5))
    /*條件表達式*/
//    val x = 1
//    val a = if(x>0) true else false
//    println(a)
    /*循環表達式: to[左右都闭合], range[左闭右开), until[左闭右开)*/
//    for(i <- 1 to 10 if i % 2 ==0){
//      println(i)
//    }
//    val courses = Array("Hadoop", "Spark SQL","Spark Streaming", "Storm", "Scala")
//    for(course <- courses){
//      println(course)
//    }
    //course即courses内的每个元素，=>即将左边的course作用上一个函数
//    courses.foreach(course => println(course))

    var (num,sum) = (100,0)
    while(num>0){
      sum = sum+num
      num = num - 1
    }
    println(sum)
  }

  def add(x:Int, y:Int):Int = {
    x+y //最后一行是返回值，无需return
  }

  def three()= 1+2

  def sayHello(): Unit ={
    println("Say Hello...")
  }

  def sayName(name:String = "PK"): Unit ={
    println(name)
  }

  def loadConf(conf:String = "spark-defaults.conf"): Unit ={
    printf("使用配置文件：%s\n", conf)
  }

  def speed(distance:Float, time:Float):Float={
    distance/time
  }

  def sum(nums:Int*): Int ={
    var result =0
    for(num <- nums)
      result=result+num
    result
  }
}
