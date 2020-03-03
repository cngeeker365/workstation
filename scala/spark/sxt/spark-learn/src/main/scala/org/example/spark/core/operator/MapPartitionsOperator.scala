package org.example.spark.core.operator

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

object MapPartitionsOperator extends App {
  val conf = new SparkConf().setAppName("MapPartitionsOperator").setMaster("local")
  val sc = new SparkContext(conf)

  val arr = Array("xuruyun", "liangyongqi", "wangfei")
  val rdd = sc.parallelize(arr)

  /**
   * 1. x 代表一个 partition 的数据
   * 2. 使用 mapPartition 的好处？
   *    在需要将结果写入 Redis、MySql等数据库时，
   *      a. 若用 map 则 Partition 里的每条记录都要创建一个连接
   *      b. 使用 mapPartition 则每个 Partition 只需要一个连接
   * 3. RDD数据不多时，可用 mapPartition 代替 map，加快处理速度
   * 4. 若一个Partition数据过多，不建议使用 mapPartition，会导致内存溢出
   */
  val result = rdd.mapPartitions(x=>{
    val list = new ListBuffer[String]()
    while(x.hasNext){
      list += x.next()+"==="
    }
    list.iterator
  })

  result.foreach(println)
}
