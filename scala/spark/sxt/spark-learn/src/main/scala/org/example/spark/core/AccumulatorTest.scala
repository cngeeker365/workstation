package org.example.spark.core

import org.apache.spark.{SparkConf, SparkContext}

object AccumulatorTest extends App {
  val conf = new SparkConf().setAppName("LineCount").setMaster("local[3]")
  val sc = new SparkContext(conf)

  var accumulator = sc.longAccumulator

  val nums = List(0,1,2,3,4,5)
  val numsRDD = sc.parallelize(nums)
  var results = numsRDD.map(x=>{accumulator.add(x); println("----"+x+"----"); x })
  results = results.cache()
  results.foreach(println)
  println(accumulator)

  sc.stop()
}
