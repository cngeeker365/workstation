package org.example.spark.core.operator

import org.apache.spark.{SparkConf, SparkContext}

object SortByKeyOperator {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("SortByKeyOperator").setMaster("local")
    val sc = new SparkContext(conf)
    val scoreList = Array((150,"xuruyun"),(100,"liangyongqi"),(80,"wangfei"))
    val scores = sc.parallelize(scoreList)
    val result = scores.sortByKey(false)
    result.foreach(println)
  }
}
