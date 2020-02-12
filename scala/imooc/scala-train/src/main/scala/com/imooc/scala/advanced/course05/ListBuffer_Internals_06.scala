package com.imooc.scala.advanced.course05

//ListBuffer如何实现高效遍历计算
object ListBuffer_Internals_06 extends App {
  //递归调用，消耗堆栈
  def increment(list:List[Int]) : List[Int] = list match{
    case List() => List()
    case head :: tail => head+1 :: increment(tail)
  }

  //List是不可变的，过程中产生大量中间对象
  def increment_MoreEffective(list:List[Int]):List[Int] = {
    var result = List[Int]()
    for(element <- list) result = result ::: List(element+1)
    result
  }

  //使用可变ListBuffer
  def increment_MostEffective(list:List[Int]):List[Int] = {
    import scala.collection.mutable.ListBuffer
    var buffer = new ListBuffer[Int]
    for(element <- list) buffer += element+1
    buffer.toList
  }
}

