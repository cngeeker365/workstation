package com.imooc.scala.advanced.course05
//For的强大表现力
object For_Expressive_07 extends App {
  val lauren = Person("Lauren", false)
  val rocky = Person("Rocky", true)
  val vivian = Person("Vivian", false, lauren,rocky)
  val persons = List(lauren,rocky,vivian)

  val result = persons.filter(person => !person.isMale)
                      .flatMap(person=> (person.children.map(child => (person.name, child.name))))
  println(result)

  val forResult = for(person <- persons; if !person.isMale; child<-person.children) yield (person.name, child.name)
  println(forResult)

  val content = for(x<-List(1,2,3); y <- List("Hadoop","Spark","Flink")) yield (x,y)
  println(content)
}

case class Person(name:String, isMale:Boolean, children:Person*)
