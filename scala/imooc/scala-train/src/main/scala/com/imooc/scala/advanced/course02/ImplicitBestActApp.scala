package com.imooc.scala.advanced.course02

import java.io.File

import scala.io.Source

object ImplicitBestActApp extends App {
  println(new File_Implicits("F:\\testData.txt").read)  //无需导入，隐式转换在伴生对象中定义了
}

class RicherFile(val file:File){
  def read = Source.fromFile(file.getPath).mkString
}

class File_Implicits(path:String) extends File(path)
//伴生对象中定义了隐式转换，伴生类可以访问伴生对象的所有内容，反之亦然
object File_Implicits{
  implicit def file2RicherFile(file:File):RicherFile = new RicherFile(file)
}