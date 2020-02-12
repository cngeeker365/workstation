package com.imooc.scala.advanced.course02

//复合类型
object CompoundTypeApp extends App {
  def compound_Type(x:Compound_Type1 with Compound_Type2) = println("Compound...")
  compound_Type(new Compound_Type1 with Compound_Type2)

  object compound_Type_obj extends Compound_Type1 with Compound_Type2
  compound_Type(compound_Type_obj)

  type compound_Type_Alias = Compound_Type1 with Compound_Type2
  def compound_Type_Local(x:compound_Type_Alias) = println("compound Type Alias")

  val compound_Type_Class = new Compound_Type
  compound_Type_Local(compound_Type_Class)

  //定义别名：必须实现 1 和 2，还必须有 init 函数
  type scala = Compound_Type1 with Compound_Type2 { def init():Unit }
}

trait Compound_Type1
trait Compound_Type2
class Compound_Type extends Compound_Type1 with Compound_Type2

