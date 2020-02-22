package akka.dt.app.scala

import akka.actor._
import akka.dt.app.scala.actors.MasterActor
import akka.dt.app.scala.messages.Result

object MapReduceApplication {
  def main(args: Array[String]): Unit = {
    val _system = ActorSystem.create("HelloAkka")
    val master = _system.actorOf(Props[MasterActor], name="master")

    master ! "Hi! My name is Rocky. I'm so so so happy to be here. "
    master ! "Today, I'm gonna read a news article for you. "
    master ! "I hope you'll like it."

    Thread.sleep(500)
    master ! new Result

    Thread.sleep(500)
//    master ! PoisonPill   //异步停止
//    master ! Kill         //同步停止
    _system.shutdown
  }
}