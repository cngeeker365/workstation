package com.imooc.scala.advanced.course05

object For_Query_08 extends App {
  val books:List[Book] = List(
    Book("Structure and Interpretation", List("Abelson,Harold","Sussman")),
    Book("Principles of Complier Design", List("Aho,Alfred", "Ullman,Jeffrey")),
    Book("Programming in Modula-2", List("Wirth,Niklaus")),
    Book("Introduction to Functional Programming", List("Bird,Richard")),
    Book("The Java Language Specification", List("Gosling,James","Joy,Bill","Steele,Guy","Bracha,Gilad"))
  )
  val result1 = for(b<- books; a<-b.authors if a startsWith "Gosling") yield b.title
  println(result1)

  val result2 = for(b<- books; if (b.title indexOf "Java")>=0) yield b.title
  println(result2)
}

case class Book(title:String, authors:List[String])

