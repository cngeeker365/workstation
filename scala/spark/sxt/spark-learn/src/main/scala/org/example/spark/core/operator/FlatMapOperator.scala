package org.example.spark.core.operator

import org.apache.spark.{SparkConf, SparkContext}

object FlatMapOperator extends App {
  val conf = new SparkConf().setAppName("FlatMapOperator").setMaster("local")
  val sc = new SparkContext(conf)

  val lineArray = Array("hello xuruyun", "hello xuruyun", "hello wangfei")
  val lines = sc.parallelize(lineArray)
  //{hello,xuruyun,hello,xuruyun,hello,wangfei}
  val wordsWithFlatMap = lines.flatMap(_.split(" "))
  val wordsWithMap = lines.map(_.split(" "))

  wordsWithFlatMap.foreach(println)

  val wordsWithMapResult = wordsWithMap.collect()
  for(a <- wordsWithMapResult){
    a.foreach(print)
    println(a.length)
  }
}
