package collections

import commons.printVector

case class Inmutable (){


  def vector(): Unit = {
    //vector vacio
    val v = Vector[Int]()
    printVector(v, "Vector Vacio")
    val v1 = v :+ 1
    printVector(v1, "Add un elemento a un vector nuevo")

  }

  def run(): Unit = {
    vector()
  }
}
