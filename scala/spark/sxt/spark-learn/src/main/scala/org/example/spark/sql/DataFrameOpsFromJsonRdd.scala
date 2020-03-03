package org.example.spark.sql

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object DataFrameOpsFromJsonRdd {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("DataFrameJson").setMaster("local")
    val sc = new SparkContext(conf)

    val sqlCtx = new SQLContext(sc)

    val jsonArr = Array("{'name':'zhangsan','age':55}", "{'name':'lisi','age':30}", "{'name':'wangwu','age':19}")

    val jsonRdd = sc.parallelize(jsonArr)

    val df = sqlCtx.read.json(jsonRdd)

    df.registerTempTable("people")
    sqlCtx.sql("select * from people where age > 20").show

    df.printSchema
    df.show
    df.select("name").show
    df.select(df("name"), df("age")+10).show
    df.filter(df("age")>10).show
    df.groupBy("age").count.show
  }
}
