package com.imooc.scala.base.course03

import java.awt.event.{ActionEvent, ActionListener}

import javax.swing.{JButton, JFrame}

object SAMCurringApp extends App {
  var data = 0
  val frame = new JFrame("SAM Testing")
  val jButton = new JButton("Counter")

  //java方式
//  jButton.addActionListener(new ActionListener {
//    override def actionPerformed(e: ActionEvent): Unit = {
//      data +=1
//      println(data)
//    }
//  })

  //scala 方式
  //sam转换：将样板代码转换，后续只需关注业务代码
  implicit def convertedAction(action:(ActionEvent)=>Unit)={
    new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {action(e)}
    }
  }
  jButton.addActionListener((e:ActionEvent)=>{data+=1;println(data)})

  frame.setContentPane(jButton)
  frame.pack()
  frame.setVisible(true)
}
