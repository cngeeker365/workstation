import java.io.{File, PrintWriter}

import scala.io.Source

val file = Source.fromFile("E:\\workstation\\logs\\zheng-cms-rpc-service.log")
for(line <- file.getLines) println(line)
file.close()

val webFile=Source.fromURL("http://spark.apache.org/")
webFile.foreach(print)
webFile.close()

val writer = new PrintWriter(new File("E:\\scalaFile.txt"))
for(i<-1 to 100) writer.println(i)
writer.close()

print("Please enter your input: ")
val line = Console.readLine
println("Input: "+line)