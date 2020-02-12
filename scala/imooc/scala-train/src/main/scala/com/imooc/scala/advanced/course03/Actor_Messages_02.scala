package com.imooc.scala.advanced.course03

import scala.actors.Actor


object Actor_Messages_02 extends App {
  val actor_Msg = Actor.actor{
    while(true){
      Actor.receive{
        case msg => println("Message content from index: "+msg)
      }
    }
  }

  val double_Msg = Actor.actor{
    while(true){
      Actor.receive{
        case msg:Double => println("Double Number from index: "+msg)
        case _ => println("Something Unkown")
      }
    }
  }

  Actor_Message.start

  Actor_Message ! "Hadoop"
  actor_Msg ! "Spark"
  double_Msg ! Math.PI
  double_Msg ! "Hadoop"
}

object Actor_Message extends Actor {
  override def act(): Unit = {
    while(true){
      receive{
        case msg => println("Message content from index: "+msg)
      }
    }
  }
}