package org.example.spark.sql.udf_udaf

import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

//UDF( User Defined Function )
object UDF {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("UDF").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlCtx = new SQLContext(sc)

    val names = Array("yarn","Marry","Jack","Tom")
    val namesRDD = sc.parallelize(names, 4)
    val namesRowRDD = namesRDD.map(Row(_))
    val structType = StructType(Array(StructField("name", StringType, true)))
    val namesDF = sqlCtx.createDataFrame(namesRowRDD, structType)
    //注册一张names表
    namesDF.registerTempTable("names")
    //注册自定义函数
    sqlCtx.udf.register("strLen", (str:String)=>str.length)
    //使用自定义函数
    sqlCtx.sql("select name, strLen(name) from names").collect.foreach(println)
  }
}
