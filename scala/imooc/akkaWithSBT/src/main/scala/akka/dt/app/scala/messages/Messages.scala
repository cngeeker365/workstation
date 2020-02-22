package akka.dt.app.scala.messages

import scala.collection.mutable._

class Word(val word:String, val count:Int)
case class Result()
class MapData(val dataList:List[Word])
class ReduceData(val reduceDataMap: HashMap[String,Int])