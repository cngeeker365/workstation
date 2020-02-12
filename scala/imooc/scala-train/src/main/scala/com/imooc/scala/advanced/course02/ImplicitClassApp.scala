package com.imooc.scala.advanced.course02

import java.io.File

import scala.io.Source

object ImplicitClassApp extends App {
  import Context_Helper._
  println(1.add(2))
  println(new File("F:\\testData.txt").read)
}

object Context_Helper{
  implicit class FileEnhancer(file:File){
    def read = Source.fromFile(file.getPath).mkString
  }
  implicit class Op(x:Int){
    def add(second:Int) = x + second
  }
}