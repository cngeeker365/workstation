package org.example.spark.streaming

import java.sql.{Connection, DriverManager, PreparedStatement}

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Durations, StreamingContext}
//import com.mysql.jdbc.Driver

object SparkStreamingOnHDFSToMySQL {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("WindowOperator").setMaster("local")
    val ssc = new StreamingContext(sparkConf,Durations.seconds(5))
    ssc.checkpoint("hdfs://n1:8020/spark/streaming/sscheckpoint")
    val linesDStream = ssc.textFileStream("hdfs://n1:8020/wc/input")
    val wordsDStream = linesDStream.flatMap { _.split(" ") }
    val pairDStream = wordsDStream.map { (_,1) }
    val resultDStream = pairDStream.reduceByKeyAndWindow((v1:Int,v2:Int)=>v1+v2, Durations.seconds(60), Durations.seconds(10))
    resultDStream.foreachRDD(rdd => {
      //每个rdd中包含的数据类型为(String,Int), 把所有数据records定义为Iterator类型，方便我们遍历
      def func(records:Iterator[(String,Int)]): Unit ={
        //注意，conn和stmt定义为var不能是val
        var conn: Connection = null
        var stmt : PreparedStatement = null
        try{
          conn = DriverManager.getConnection("jdbc:mysql://192.168.238.131:3306/test","root","123456")
          records.foreach(p =>{
            stmt = conn.prepareStatement("insert into wordcount(word,word_count) values(?,?)")
            stmt.setString(1,p._1.trim)
            stmt.setInt(2,p._2.toInt)
            stmt.executeUpdate()
          })
        }catch {
          case e : Exception => e.printStackTrace()
        }finally {
          if(stmt != null)
            stmt.close()
          if(conn != null)
            conn.close()
        }
      }
      val repairtitionedRDD = rdd.repartition(3)//将每个rdd重新分区
      repairtitionedRDD.foreachPartition(func)//对重新分区后的rdd执行func函数
    })
    ssc.start()
    ssc.awaitTermination()
    ssc.stop()
  }
}
