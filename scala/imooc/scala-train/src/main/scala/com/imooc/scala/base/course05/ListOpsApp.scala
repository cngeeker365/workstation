package com.imooc.scala.base.course05

object ListOpsApp extends App {
  println(List(1,2,3,4,5) partition(_%2==0)) //分组
  println(List(1,2,3,4,5) find (_%2==0)) //找出第一个满足条件的元素
  println(List(1,2,3,4,5) find (_ <= 0))
  println(List(1,2,3,4,5) takeWhile(_<4)) //获取满足条件的值
  println(List(1,2,3,4,5) dropWhile(_<4)) //删除满足条件的值
  println(List(1,2,3,4,5) span(_<4)) //将符合条件的分一组，其他另一组

  def hastotallyZeroRow(m:List[List[Int]]) = m exists(row => row forall (_==0)) //exists只要一个满足则返回true，forall全部满足条件则返回true
  val m = List(List(1,0,0),List(0,1,0),List(0,0,0))
  println(hastotallyZeroRow(m))

  println((1 to 100).foldLeft(0)(_+_))
  println((0 /: (1 to 100))(_+_))

  println((1 to 5).foldRight(100)(_-_))
  println(((1 to 5):\100)(_-_))

  println(List(1,2,3,4,5,6) sortWith( _ < _))
  println(List(1,2,3,4,5,6) sortWith( _ > _))

  println(List.apply(1,2,3))
  println(List.range(1,5))
  println(List.range(9,1,-3))

  val zipped = "abcde".toList zip List(1,2,3,4,5)
  println(zipped)
  println(zipped.unzip)

  println(List(List('a','b'),List('c'),List('d','e')).flatten)
  println(List.concat(List(),List('b'),List('c')))


}
