package com.imooc.scala.advanced.course02

import scala.io.{BufferedSource, Source}

object AbstractTypeApp extends App {
  val fileReader = new FileReader
  val content = fileReader.read("F:\\testData.txt")
  content.getLines().foreach(println)
}

trait Reader{
  type In           //定义抽象类型
  type Contents     //定义抽象类型
  def read(in:In):Contents
}
class FileReader extends Reader{
  override type In = String                 //复写并确认具体类型
  override type Contents = BufferedSource   //复写并确认具体类型

  override def read(in: String): BufferedSource = Source.fromFile(in)
}