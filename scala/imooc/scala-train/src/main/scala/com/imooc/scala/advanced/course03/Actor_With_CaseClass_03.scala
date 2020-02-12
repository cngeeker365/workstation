package com.imooc.scala.advanced.course03

import scala.actors.Actor

object Actor_With_CaseClass_03 extends App {
  val hiActor = new HelloActor
  hiActor.start

  hiActor ! Person("Spark", 6)

  //主线程与子线程交互
  Actor.receive{
    case msg => println(Thread.currentThread().getName+"---->"+msg)
  }

}

case class Person(name:String, age:Int)

class HelloActor extends Actor{
  override def act(): Unit = {
    while (true){
      receive{
        case Person(name, age) => {
          println(Thread.currentThread().getName+"---->"+"Name: "+name+" , Age: "+age)
          sender ! "Echo!!!"  //向发送者返回消息
        }
      }
    }
  }
}