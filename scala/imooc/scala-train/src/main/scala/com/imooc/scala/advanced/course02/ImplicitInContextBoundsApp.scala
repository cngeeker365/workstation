package com.imooc.scala.advanced.course02

object ImplicitInContextBoundsApp {
  println(new Pair_Implicits(7,9).bigger)
  println(new Pair_Implicitly(7,9).bigger)
  println(new Pair_Implicitly_Ordered(7,9).bigger)
}

class Pair_Implicits[T : Ordering](val first:T, val second:T){ // T:Ordering 表明 存在隐式值，类型为Ordering[T]
  def bigger(implicit ordered:Ordering[T]) ={ //方法没有参数，但有一个隐式值ordered
    if(ordered.compare(first,second)>0) first else second
  }
}

class Pair_Implicitly[T : Ordering](val first:T, val second:T){ // T:Ordering 表明 存在隐式值，类型为Ordering[T]
  def bigger = if(implicitly[Ordering[T]].compare(first,second)>0) first else second //implicitly方法将Ordering[T]提取出来
}

class Pair_Implicitly_Ordered[T : Ordering](val first:T, val second:T){ // T:Ordering 表明 存在隐式值，类型为Ordering[T]
  def bigger={ //方法没有参数，但有一个隐式值ordered
    import Ordered._  //引入Ordered，Ordered中有关于Ordering隐式转换为Ordered
    if( first > second ) first else second
  }
}