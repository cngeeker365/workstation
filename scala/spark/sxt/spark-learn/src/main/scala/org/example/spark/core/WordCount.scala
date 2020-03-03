package org.example.spark.core

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    //创建SparkConf，设置运行时环境变量，如需要集群多少个cores，mem，设置applicationName，master
    val sparkConf = new SparkConf().setAppName("WC").setMaster("local[3]")

    //通过传入sparkconf创建sparkContext，SparkContext是程序入口
    val sc = new SparkContext(sparkConf)

    //加载数据源（本地数据）
    val lineRDD = sc.textFile("F:\\testData.txt")

    //切割每一行记录
    val wordRDD = lineRDD.flatMap(_.split(" "))

    //将每个单词计数为1
    val pairRDD = wordRDD.map((_,1))

    //reduceByKey其实是先经过分组，这样每一个key就会对应一组数据，然后对每一组数据使用传入的匿名函数计算
    val resultRDD = pairRDD.reduceByKey(_+_)

    //按照出现次数进行排序, 降序排序
    resultRDD.sortBy(_._2, false).foreach(println)
  }
}
