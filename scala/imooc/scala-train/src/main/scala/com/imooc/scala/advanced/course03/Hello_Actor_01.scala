package com.imooc.scala.advanced.course03

import scala.actors.Actor

object Hello_Actor extends App {
  First_Actor.start
  Second_Actor.start
}

object First_Actor extends Actor {
  override def act(): Unit = {
    for(i <- 1 to 10){
      println(Thread.currentThread().getName+"---->"+i)
      Thread.sleep(2000)
    }
  }
}

object Second_Actor extends Actor {
  override def act(): Unit = {
    for(i <- 1 to 10){
      println(Thread.currentThread().getName+"---->"+i)
      Thread.sleep(2000)
    }
  }
}