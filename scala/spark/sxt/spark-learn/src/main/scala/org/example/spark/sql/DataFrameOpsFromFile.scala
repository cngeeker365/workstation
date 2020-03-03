package org.example.spark.sql

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object DataFrameOpsFromFile {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("DataFrameFile").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlCtx = new SQLContext(sc)

//    val df = sqlCtx.read.json("hdfs://n1:9000/input/people.json")
    val df = sqlCtx.read.json("F:\\workstation\\scala\\spark\\sxt\\spark-learn\\src\\main\\scala\\org\\example\\spark\\sql\\people.json")

    df.registerTempTable("people")
    sqlCtx.sql("select * from people where age > 20").show

    df.printSchema
    df.show
//    df.select("name").show
//    df.select(df("name"), df("age")+10).show
//    df.filter(df("age")>10).show
//    df.groupBy("age").count.show
  }
}
