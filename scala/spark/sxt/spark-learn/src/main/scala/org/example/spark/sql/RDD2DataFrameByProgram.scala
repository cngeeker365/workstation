package org.example.spark.sql

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

object RDD2DataFrameByProgram {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("DataFrameJson").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlCtx = new SQLContext(sc)

    val scores = sc.textFile("scores.txt")
    val rowRDD = scores.map(_.split("\t")).map(p=>Row(p(0),p(1).toInt))

    //创建Schema方式一：
    /**
    val schemaString = "clazz:String score:Integer"    //该部分数据可保存在数据库中
    val schema = StructType(
                      schemaString.split(" ").map(
                        fieldName => StructField(
                                        fieldName.split(":")(0),
                                        if(fieldName.split(":")(1).equals("String"))
                                            StringType
                                        else IntegerType, true )
                      ))
*/
    //创建Schema方式二：
    val structFields = Array(StructField("clazz", StringType, true), StructField("score", IntegerType))
    val schema = StructType(structFields)
    //使用 Schema 创建 DataFrame
    val scoresDataFrame = sqlCtx.createDataFrame(rowRDD, schema)
    scoresDataFrame.registerTempTable("clazzScore")
    val results = sqlCtx.sql("select score, clazz from clazzScore")
    results.show
  }
}
