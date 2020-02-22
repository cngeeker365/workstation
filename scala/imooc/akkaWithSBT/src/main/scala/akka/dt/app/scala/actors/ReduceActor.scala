package akka.dt.app.scala.actors

import akka.actor.{Actor, ActorRef}
import akka.dt.app.scala.messages.{MapData, ReduceData, Word}

import scala.collection.mutable

class ReduceActor(aggregateActor : ActorRef) extends Actor {
  override def receive: Receive = {
    case message: MapData => aggregateActor ! reduce(message.dataList)
    case _ =>
  }

  def reduce(dataList:List[Word]): ReduceData = {
    var reduceMap = new mutable.HashMap[String, Int]()
    for(wc:Word <- dataList){
      var word : String = wc.word
      if (reduceMap.contains(word)){
        reduceMap += (word-> (reduceMap.get(word).get+1))
      }else{
        reduceMap.put(word,1)
      }
    }
    new ReduceData(reduceMap)
  }
}
