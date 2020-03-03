package org.example.spark.sql

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext

object RDD2DataFrameByReflection {

  case class Person(name:String, age:Int)

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("DataFrameJson").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlCtx = new SQLContext(sc)
    //导入
    import sqlCtx.implicits._
    //由于之前导入，此处 toDF 可以直接用
    val people = sc.textFile("people.txt").map(_.split(",")).map(p => Person(p(1),p(2).trim.toInt)).toDF()

    people.registerTempTable("people")

    val teenagers = sqlCtx.sql("select name, age from people where age >= 6 and age <= 19")

    //方式一：获取名字
    teenagers.map("Name: "+_(0)).collect().foreach(println)
    //方式二：by field name
    teenagers.map("Name: "+_.getAs[String]("name")).collect().foreach(println)
    //方式三：row.getValuesMap[T] retrieves multiple columns at once into a Map[String, T]
    teenagers.map(_.getValuesMap[Any](List("name","age"))).collect().foreach(a=>println(a.get("name").get))

  }
}
