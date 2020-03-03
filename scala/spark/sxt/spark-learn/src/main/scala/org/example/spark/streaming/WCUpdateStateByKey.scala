package org.example.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Durations, StreamingContext}
//模拟广告投放点击量统计操作
object WCUpdateStateByKey {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("WordCountOnline").setMaster("local[2]")
    val ssc = new StreamingContext(sparkConf,Durations.seconds(5))

    //要实现统计，需要将过往的统计结果做持久化
    ssc.checkpoint("hdfs://n1:9000/sscheckpoint")
//    ssc.checkpoint("./sschkpt")

    val linesDStream = ssc.socketTextStream("n1", 9999, StorageLevel.MEMORY_AND_DISK)
    val wordsDStream = linesDStream.flatMap { _.split(" ") }
    val pairDStream = wordsDStream.map { (_,1) }

    val resultDStream = pairDStream.updateStateByKey(
      (x:Seq[Int],y:Option[Int])=>{
        var result = y.getOrElse(0)
        for (v <- x){
          result += v
        }
        Option(result)
      })
    resultDStream.print()
    ssc.start()
    ssc.awaitTermination()
    ssc.stop()
  }
}