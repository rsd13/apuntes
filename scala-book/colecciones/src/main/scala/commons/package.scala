package object commons {


  def printArray[T](array: Array[T], msg: String):Unit = {
    println("-----ARRAY "+ msg + "-----")
    println(array.mkString("[", ", ", "]"))
  }



}
