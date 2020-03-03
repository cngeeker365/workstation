package org.example.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Durations, StreamingContext}

//模拟基于滑动窗口的热点搜索词实时统计（优化版）
object WindowOperatorOptimize {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("WindowOperator").setMaster("local[2]")

    val ssc = new StreamingContext(sparkConf,Durations.seconds(5))

//    ssc.checkpoint("hdfs://n1:9000/sscheckpoint")
    ssc.checkpoint("./sschkpt")

    val linesDStream = ssc.socketTextStream("n1", 9999, StorageLevel.MEMORY_AND_DISK)

    val wordsDStream = linesDStream.flatMap { _.split(" ") }
    val pairDStream = wordsDStream.map { (_,1) }
    /**
     * 1. StreamingContext 中设置，每个DStream是 5s 的数据
     * 2. 此处设置窗口大小 60秒（窗口内有 12个RDD = 60/5 ），每隔 10s 滑动一次
     * 3. 未计算之前，RDD是不会计算的，计算这12个RDD时，reduceByKeyAndWindows是针对窗口操作而非DStream
     * 4. 窗口滑动时间 和 窗口时间 必须是 BatchInterval 的整数倍
     * 5. reduceByKeyAndWindow 传入的两个func，第一个实现前一个Window与新增batch的和，第二个实现Window与移除batch的差
     */
    val resultDStream = pairDStream.reduceByKeyAndWindow((v1:Int,v2:Int)=>v1+v2, (v1:Int,v2:Int)=>v1-v2, Durations.seconds(60), Durations.seconds(10))
    //DStream.transform 可以将 RDD取出并进行操作，这样 RDD 可以转换为 DataFrame，就可以用 SparkSql
    val finalDStream = resultDStream.transform(_.sortBy(_._2,false))
    finalDStream.print()
    ssc.start()
    ssc.awaitTermination()
    ssc.stop()
  }
}