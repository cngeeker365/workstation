package akka.dt.app.scala.become

import akka.actor.Actor


class SparkFlinkActor extends Actor {
  import context._
  var count = 0

  override def receive: Receive = {
    case Spark =>
      println("Here is Spark!!!")
      count = count + 1
      Thread.sleep(100)
      self ! Flink
      become{
        case Flink =>
          println("Here is Flink!!!")
          count += 1
          Thread.sleep(100)
          self ! Spark
          unbecome
      }
  }
}

case class Spark()
case class Flink()