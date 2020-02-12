package com.imooc.scala.base.course05

object ListApp extends App {
  val l1=List(1,2,3,4,5)
  println(l1.head) //1
  println(l1.tail) //2,3,4,5

  val l2=1::Nil
  println(l2)

  val l3 = 2::l2
  val l4 = 1::2::3::Nil

  val l5 = scala.collection.mutable.ListBuffer[Int]()
  l5 += 2
  l5 += (3,4,5)
  l5 ++= List(6,7,8,9)

  l5.filter(_>5).map(print)
  println

  l5 -= 2
  l5 -= 3
  l5 -= (1,4)
  l5 --=List(5,6,7,8)
  println(l5)
  println(l5.toList, l5.toArray)
  println(l5.isEmpty)
  println(l5.head)
  println(l5.tail)
//  println(l5.tail.head)

  def sum(nums:Int*):Int={
    if(nums.length==0){
      0
    }else{
      //递归
      nums.head + sum(nums.tail:_*) // :_* 能将一个seq转换为可变参数
    }
  }
  println(sum())
  println(sum(4,5,6))

  val List(a,b) = List(22,33)
  println("a: "+a+" === "+"b: "+b)
  val x::y::rest = List(1,2,3)
  println("x: "+x+" === y: "+y+" === rest: "+rest)

  println(List(1,2,3,4):::List(4,5):::(List(6,7):::List(8,9)))

  val bigData = List("Hadoop","Spark","Kafka")
  println(bigData.last)  //最后一个
  println(bigData.init)  //除最后一个
  println(bigData.reverse) //反转
  println(bigData take 2) //获取前2个
  println(bigData drop 2) //扔掉前2个
  println(bigData splitAt 2) //从2前分割
  println(bigData apply 2) //取index=2的值
  println(bigData(2)) //取index=2的值

  val data = List('a','b','c','d','e','f')
  println(data.indices) //取索引
  println(data.indices zip data) //zip：拉链操作
  println(data.zipWithIndex)
  println(data.toString)
  println(data.mkString("[",",","]"))
  println(data.mkString("    "))
  println(data mkString)

  val buffer = new StringBuilder
  data addString(buffer, "(", "**", ")")
  println(buffer)

  val array = data.toArray
  println(array.toList)

  val array2 = new Array[Char](10)
  data.copyToArray(array2, 3) //跳过前三个元素
  array2.foreach(print)
  println

  val iterator = data.toIterator
  println(iterator.next)
  println(iterator.next)


}
