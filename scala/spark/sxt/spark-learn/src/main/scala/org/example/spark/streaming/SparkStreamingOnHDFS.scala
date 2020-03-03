package org.example.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Durations, StreamingContext}

object SparkStreamingOnHDFS {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("WindowOperator").setMaster("local[2]")

    val ssc = new StreamingContext(sparkConf,Durations.seconds(5))

    ssc.checkpoint("hdfs://n1:8020/spark/streaming/sscheckpoint")

    var linesDStream = ssc.textFileStream("hdfs://n1:8020/wc/input")
    var wordsDStream = linesDStream.flatMap { _.split(" ") }
    var pairDStream = wordsDStream.map { (_,1) }
    /**
     * 1. StreamingContext 中设置，每个DStream是 5s 的数据
     * 2. 此处设置窗口大小 60秒（窗口内有 12个RDD = 60/5 ），每隔 10s 滑动一次
     * 3. 未计算之前，RDD是不会计算的，计算这12个RDD时，reduceByKeyAndWindows是针对窗口操作而非DStream
     */
    var resultDStream = pairDStream.reduceByKeyAndWindow((v1:Int,v2:Int)=>v1+v2, Durations.seconds(60), Durations.seconds(10))
    resultDStream.print()

    ssc.start()
    ssc.awaitTermination()
    ssc.stop()
  }
}
