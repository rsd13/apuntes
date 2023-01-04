package scala.collection


object MyArray {
  def main(args: Array[String]): Unit = {

    val array1 = Array.newBuilder[Int]
    array1 += 1
    array1 += 2

    for(item <- array1){
      println(item)
    }
  }



}