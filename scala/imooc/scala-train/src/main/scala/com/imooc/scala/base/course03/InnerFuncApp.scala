package com.imooc.scala.base.course03

import scala.io.Source

object InnerFuncApp extends App {

  def processData(filename:String, width:Int): Unit ={
    //定义本地函数，外部不可访问
    def processLine(line:String): Unit ={
      if(line.length > width)
        println(filename+" : "+line)
    }

    val source = Source.fromFile(filename)
    source.getLines().foreach(processLine)
  }

  var increase = (x:Int) => x+1
  println(increase(1))

  val f = (_:Int)+(_:Int)
  println(f(5,6))
}


