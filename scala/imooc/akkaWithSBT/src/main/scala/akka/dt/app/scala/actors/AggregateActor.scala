package akka.dt.app.scala.actors

import akka.actor.Actor
import akka.dt.app.scala.messages.{ReduceData, Result}

import scala.collection.mutable

class AggregateActor extends Actor{

  var finalReducedMap = new mutable.HashMap[String,Int]

  override def receive: Receive = {
    case message: ReduceData => aggregateInMemoryReduce(message.reduceDataMap)
    case message: Result => println(finalReducedMap.toString)
  }

  def aggregateInMemoryReduce(reduceList: mutable.HashMap[String, Int]): Unit ={
    var count = 0
    for ((key,value) <- reduceList){
      if(finalReducedMap.contains(key)){
        count = reduceList.get(key).get
        count += finalReducedMap.get(key).get
        finalReducedMap.put(key, count)
      }else{
        finalReducedMap.put(key, reduceList.get(key).get)
      }
    }
  }
}
