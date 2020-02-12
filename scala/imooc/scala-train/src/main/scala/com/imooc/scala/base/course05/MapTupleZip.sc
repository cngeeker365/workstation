import scala.collection.immutable.TreeMap

//Map
val map = Map("book"->10,"gun"->18,"ipad"->1000)
for((k,v)<-map) yield (k,v*0.9)

val scores = scala.collection.mutable.Map("Scala"->7,"Hadoop"->9,"Spark"->10)
val hadoopScore = scores.getOrElse("Hadoop",0)
scores += ("R"->9)
scores -= "Hadoop"

val sortedScore=scala.collection.immutable.SortedMap("Scala"->7,"Hadoop"->9,"Spark"->10)

val map1 = scala.collection.mutable.Map.empty[String,String]
map1("java")="Hadoop"
map1("scala")="Spark"
println(map1)
println(map1("scala"))

val treeMap = TreeMap("scala"->"spark","java"->"hadoop")
println(treeMap)

//Tuple
val tuple = (1,2,3.14,"Rocky","Spark")
val third = tuple._3
val (first,second,third,fourth,fifth)=tuple
val (f,s,_,_,_) = tuple

"Rocky Spark".partition(_.isUpper)

//Zip
val symbols = Array("[","-","]")
val counts = Array(2,5,2)
val pairs = symbols.zip(counts)
for((x,y)<-pairs) print(x*y)
