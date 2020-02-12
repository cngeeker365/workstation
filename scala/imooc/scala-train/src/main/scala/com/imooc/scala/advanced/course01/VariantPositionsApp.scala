package com.imooc.scala.advanced.course01

//协变点与逆变点
//参考资料：
//  1. http://hongjiang.info/scala-pitfalls-10/
//  2. https://segmentfault.com/a/1190000003509191
object VariantPositionsApp extends App {

}

//class P[+T](var first:T, var second:T){
class P[+T](val first:T, val second:T){
  def replaceFirst[R >: T](newFirst:R) = new P[R](newFirst, second)
}