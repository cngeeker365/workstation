package com.imooc.scala.advanced.course04

import scala.swing._

object Hello_GUI_01 extends SimpleSwingApplication{
  def top = new MainFrame{
    title = "Hello GUI"
    contents = new Button{
      text = "Scala => Spark !!!"
    }
  }
}
