package org.example.spark.streaming

package com.bjsxt.scala.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Durations
import org.apache.spark.storage.StorageLevel

object WordCountOnline {
  def main(args: Array[String]): Unit = {
    //1. local模拟线程数必须 ≥2，因为一条线程被 receiver 占用接受数据，另一个线程是job执行
    val sparkConf = new SparkConf().setAppName("WordCountOnline").setMaster("local[2]")

    //2. Duration时间的设置，就是能接受的延迟度，需要根据集群的资源情况、监控ganglia、输入数据量和处理速度等来综合判断
    //3. StreamingContext的创建有两种方式：sparkconf、SparkContext
    val ssc = new StreamingContext(sparkConf,Durations.seconds(5))

    //4. 连接指定服务器的指定端口，这里通过 nc -lk 9999，模拟socket发送消息
    //yum install -y nc nmap
    val linesDStream = ssc.socketTextStream("n1", 9999, StorageLevel.MEMORY_AND_DISK)

    //5. streaming 框架启动之后是不能再次添加业务逻辑，故不能调整并行度
    val wordsDStream = linesDStream.flatMap { _.split(" ") }
    val pairDStream = wordsDStream.map { (_,1) }
    val resultDStream = pairDStream.reduceByKey(_+_)

    //5. 业务逻辑完成后，需要有一个output operator 触发执行
    resultDStream.print()

    //6. start()方法 除启停外，还会触发 上文的SocketInputStream 中的 onStart 方法
    ssc.start()
    ssc.awaitTermination()
    //7. stop()实为stop(true)，即将SparkContext一同关闭，之后不能再调用 start()，若后续还要用streamContext，可用stop(false)
    ssc.stop()
  }
}