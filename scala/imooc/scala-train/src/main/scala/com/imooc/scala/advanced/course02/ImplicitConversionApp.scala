package com.imooc.scala.advanced.course02

import java.io.File

import scala.io.Source
//隐式转换
object ImplicitConversionApp extends App {

  import Context._

  println(new File("F:\\testData.txt").read) //存在隐式转换
}
class RichFile(val file:File){
  def read = Source.fromFile(file.getPath()).mkString
}
object Context {
  implicit def file2RichFile(file:File):RichFile = new RichFile(file) //File -> RichFile
}