package org.example.spark.sql

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object ParquetDataSourcePartition {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ParquetPartition").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlCtx = new SQLContext(sc)

//    val usersDF = sqlCtx.read.format("parquet").load("hdfs://n1:9000/users/gender=male")   //这样就是读取gender=male分区下的数据，这部分数据默认gender=male
    val usersDF = sqlCtx.read.parquet("F:\\workstation\\scala\\spark\\sxt\\spark-learn\\src\\main\\scala\\org\\example\\spark\\sql\\users")

    usersDF.printSchema
    usersDF.show
  }
}
