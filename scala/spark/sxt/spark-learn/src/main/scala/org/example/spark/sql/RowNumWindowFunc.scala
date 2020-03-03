package org.example.spark.sql

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

object RowNumWindowFunc {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WindowFunc") //不设 master=local，因要用 hive，只能在集群运行
    val sc = new SparkContext(conf)
    val hiveCtx = new HiveContext(sc)
    //删除已存在的表 --> 创建新表 --> 加载数据
    hiveCtx.sql("DROP TABLE IF EXISTS sales")
    hiveCtx.sql("CREATE TABLE IF NOT EXISTS sales ("
                + "product STRING,"
                + "category STRING,"
                + "revenue BIGINT) row format delimited fields terminated by '\t'"
    )
    hiveCtx.sql("LOAD DATA "
                + "LOCAL INPATH '/root/resource/sales.txt' "
                + "INTO TABLE sales"
    )

    /**
     * row_number()开窗函数的作用： 按照每一个分组的数据，按照其顺序，打上一个分组内的行号：
     *  id=2016 [111, 112, 113]  开窗后变成  id=2016 [111 1, 112 2, 113 3]
     */
    val top3SaleDF = hiveCtx.sql("" +
      "SELECT product, category, revenue " +
      "FROM (" +
              "SELECT product, category, revenue, " +
                    "row_number() OVER (PARTITION BY category ORDER BY revenue DESC) rank " +
              "FROM sales" +
      ") tmp_sales " +
      "WHERE rank <=3")

    //将每组排名前三的数据，保存到一个表中
    hiveCtx.sql("DROP TABLE IF EXISTS top3Sales")
    top3SaleDF.createOrReplaceTempView("top3SalesTmp")  //写入临时表
    hiveCtx.sql("insert overwrite table top3SalesTmp select * from top3SalesTmp") //将临时表数据导入hive表中
    sc.stop()
  }
}
