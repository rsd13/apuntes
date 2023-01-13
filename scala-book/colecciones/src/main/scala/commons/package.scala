package object commons {


  def printArray[T](array: Array[T], msg: String):Unit = {
    println("-----ARRAY "+ msg + "-----")
    println(array.mkString("[", ", ", "]"))
  }

  def printVector[T](vector: Vector[T], msg: String):Unit = {
    println("-----ARRAY "+ msg + "-----")
    println(vector.mkString("[", ", ", "]"))
  }



}
