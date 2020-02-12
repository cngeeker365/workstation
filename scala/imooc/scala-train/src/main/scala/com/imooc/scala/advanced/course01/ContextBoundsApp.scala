package com.imooc.scala.advanced.course01

object ContextBoundsApp extends App {
  val pair = new Pair_Ordering("Spark","Hadoop")
  println(pair.bigger)

  val pairInt = new Pair_Ordering(3,5)
  println(pairInt.bigger)
}

class Pair_Ordering[T : Ordering](val first:T, val second:T){ // T:Ordering 表明 存在隐式值，类型为Ordering[T]
  def bigger(implicit ordered:Ordering[T]) ={ //方法没有参数，但有一个隐式值ordered
    if(ordered.compare(first,second)>0) first else second
  }
}