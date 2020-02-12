package com.imooc.scala.advanced.course02

//结构类型，类似于Duck Typing
object StructuralTypeApp extends App {

  //定义一个函数，参数类型无所谓，但参数必须包含open方法
  //方式1：
//  def init( res:{def open():Unit}): Unit ={
//    res.open
//  }
  //方式2：
  type X = {def open():Unit}  //定义别名
  def init(res:X) = res.open

  init(new {def open()=println("Opened...")})

  object A { def open(){println("A single object Opened...")}}
  init(A)

  val structural = new Structural
  init(structural)

}

class Structural { def open()=println("A class instance Opened...")}