package com.imooc.scala.advanced.course05

//模式匹配下的For循环
object For_Advanced_01 extends App {
  for( i <- List(1,2,3,4,5)) {println(i)}

  for( index@"Flink" <- List("Hadoop", "Spark", "Flink")){println(index)}  //index是Flink的别名，进行模式匹配

  for( (language, "Hadoop") <- Set("Scala"->"Spark","Java"->"Hadoop")) println(language)

  for((k,v:Int) <- List(("Spark"->5),("Hadoop"->"Big Data"))){println(k)}
}
