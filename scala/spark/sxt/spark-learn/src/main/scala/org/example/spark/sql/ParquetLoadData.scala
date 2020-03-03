package org.example.spark.sql

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object ParquetLoadData {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("DataFrameJson").setMaster("local")
    val sc = new SparkContext(conf)

    val sqlCtx = new SQLContext(sc)

    //    val df = sqlCtx.read.parquet("hdfs://n1:9000/input/users.parquet")
    val df = sqlCtx.read.parquet("F:\\workstation\\scala\\spark\\sxt\\spark-learn\\src\\main\\scala\\org\\example\\spark\\sql\\users.parquet")
    df.show
    df.printSchema

    df.registerTempTable("users")
    val usersDF = sqlCtx.sql("select * from users")

//    usersDF.rdd.map(row => "Name: "+row(0) ).collect.foreach(println)
    usersDF.rdd.map("Name: "+_(0) ).collect.foreach(println)

  }
}
