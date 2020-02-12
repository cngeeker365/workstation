package com.imooc.scala.base.course04

object PackageApp_Advanced extends App {

}

package spark{
  package navigation{
    private[spark] class Navigator{
      protected [navigation] def useStarChart(){}

      class LegOfJourney{
        private[Navigator] val distance = 100
      }

      private [this] var speed = 200
    }
  }

  package launch{
    import navigation._
    object Vehicle{
      private [launch] val guide = new Navigator
    }
  }
}

class A {
  import A.power
  private def canMakeItTrue = power > 10001
}

object A{
  private def power = 10000
  def makeItTrue(a:A): Boolean ={
    val result = a.canMakeItTrue
    result
  }
}