package com.imooc.scala.base.course05

import scala.collection.immutable.Queue

object QueueStackApp extends App {

  val empty = Queue[Int]()
  val q1 = empty.enqueue(1)
  val q2 = q1.enqueue(List(2,3,4,5))
  println(q2)
  val (element, left) = q2.dequeue
  println(element+" : "+left)

  import scala.collection.mutable.Queue
  val queue = Queue[String]()
  queue += "a"
  queue ++= List("b","c")
  println(queue)
  println(queue.dequeue)
  println(queue)

  import scala.collection.mutable.Stack
  val stack = new Stack[Int]
  stack.push(1)
  stack.push(2)
  stack.push(3)
  println(stack)
  println(stack.top)
  println(stack)
  println(stack.pop)
  println(stack)
}
