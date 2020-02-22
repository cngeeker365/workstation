package akka.dt.app.scala.actors

import java.util.StringTokenizer

import akka.actor.{Actor, ActorRef}
import akka.dt.app.scala.messages.{MapData, Word}

import scala.collection.mutable.ListBuffer

class MapActor(reduceActor: ActorRef) extends Actor {

  val STOP_WORDS_LIST = List("a","is")

  override def receive: Receive = {
    case message:String => reduceActor ! evaluateExpression(message)
  }

  def evaluateExpression(line: String) : MapData ={
    var dataList = new ListBuffer[Word]
    var parser: StringTokenizer = new StringTokenizer(line)
    var defaultCount = 1
    while (parser.hasMoreTokens){
      var word : String = parser.nextToken.toLowerCase
      if(!STOP_WORDS_LIST.contains(word)){
        dataList += (new Word(word, defaultCount))
      }
    }
    new MapData(dataList.toList)
  }
}
