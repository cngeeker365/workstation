package akka.dt.app.scala.actors

import akka.actor.{Actor, ActorRef, Props}
import akka.dt.app.scala.messages.Result

class MasterActor extends Actor{

  val aggregateActor:ActorRef = context.actorOf(Props[AggregateActor], name="aggregate")
  val reduceActor:ActorRef    = context.actorOf(Props(new ReduceActor(aggregateActor)), name="reduce")
  val mapActor:ActorRef       = context.actorOf(Props(new MapActor(reduceActor)), name = "map")

  println(mapActor.path)
  println(reduceActor.path)
  println(aggregateActor.path)

  override def receive: Receive = {
    case message:String => mapActor ! message
    case message:Result => aggregateActor ! message
    case _ =>
  }
}
