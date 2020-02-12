package com.imooc.scala.advanced.course01

object TypeBoundsApp extends App {
  val pair = new Pair("Spark","Hadoop")
  println(pair.bigger)

  val pairInt = new Pair_NotPerfect(3,5)
  println(pairInt.bigger)

  val pairBetterString = new Pair_Better("Java","Scala")
  println(pairBetterString.bigger)

  val pairBetterInt = new Pair_Better(20,12)
  println(pairBetterInt.bigger)
}

//class Pair[T](val first:T, val second:T)
class Pair[T <: Comparable[T]](val first:T, val second:T){  // T 的 上限为 Comparable, <: 不会做视图绑定（view bounds），即对于整数等不是Comparable子类的无法使用
  def bigger = if(first.compareTo(second)>0) first else second
}

class Pair_NotPerfect[T <% Comparable[T]](val first:T, val second:T){ // <% 会进行 view bounds，例如 会将 Int --> RichInt（Comparable的子类）
  def bigger = if(first.compareTo(second)>0) first else second
}

class Pair_Better[T <% Ordered[T]](val first:T, val second:T){ //为了更方便，scala定义了Ordered继承Comparable，但String不是Ordered的子类，会做视图绑定String-->RichString
  def bigger = if(first > second) first else second
}

class Pair_Lower_Bound[T](val first:T, val second:T){
  def replaceFirst[R >: T](newFirst:R) = new Pair_Lower_Bound[R](newFirst, second)  // R 的 下限为 T
}

