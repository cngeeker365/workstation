package akka.dt.app.scala.become

import akka.actor.{ActorSystem, Props}

object MyActorSystem {
  def main(args: Array[String]): Unit = {
    val _system = ActorSystem("BecomeUnbecome")
    val sparkFlinkActor = _system.actorOf(Props[SparkFlinkActor])
    sparkFlinkActor ! Spark
    Thread.sleep(2000)
    _system.shutdown
  }
}
