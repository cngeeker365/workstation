package com.imooc.scala.advanced.course01

/**
 * 1. 同时拥有上下界
 *    T >: A <: B       //T是A的上界,B的下界
 * 2. 同时拥有多个上界
 *    T <: A with B     //T是A或B的子类
 * 3. 同时拥有多个下界
 *    T >: A with B     //A或B是T的子类
 * 4. 拥有多个视图界定
 *    T <% A <% B       //T必须同时满足能隐式转换成A和B
 * 5. 上下文界定
 *    T : A : B         //T必须同时满足存在A[T]和B[T]这样的隐式值
 */
object MultipleBoundsApp extends App {
  //定义隐式值
  implicit val a = new M_A[Int]
  implicit val b = new M_B[Int]

  def foo[ T : M_A : M_B ](i:T) = println("OK")

  foo(2) //存在隐式值a和b，满足 T : M_A : M_B
}

class M_A[T]
class M_B[T]
