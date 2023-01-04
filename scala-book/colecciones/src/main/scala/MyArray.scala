import commons.printArray

object MyArray {

  /*
    ejemplo de funciones relacionads con builders
   */
  def builder():Unit = {
    val array1 = Array.newBuilder[Int]
    array1 += 1
    array1 += 2
    // se crea una colección a través del creado
    val array2 = array1.result()
    printArray(array2, "RESULT")
  }
  /*
    ejemplo de funciones relacionads con factoryMethods
   */
  def factoryMethods():Unit = {
    val array3 = Array.fill(5)("hello ") // Array repetido 5 veces
    printArray(array3, "FILL")

    val array4 = Array.tabulate(5)(n => s"hello $n") // array con su index
    printArray(array4, "TABULATE")

    val array5 = array3 ++ array4
    printArray(array5, "++")
  }

  /*
    ejemplo de funciones relacionads con transform
 */
  def transforms():Unit = {
    val array = Array(1, 2, 3, 4, 5)
    // crea una nueva colección con los mismos elementos con la operación nueva
    val arrayMap = array.map( x => x*2)
    printArray(arrayMap, "MAP")

    // crea una nueva colección con los elementos que cumpla la condición
    val arrayFilter = array.filter( x => x%2==0)
    printArray(arrayFilter, "FILTER")

    // coge los x primeros elementos
    val arrayTake = array.take(2)
    printArray(arrayTake, "TAKE")

    //crea una nueva colección borrando los x primeros elementos
    val arrayDrop = array.drop(2)
    printArray(arrayDrop, "DROP")

    // crea una nueva colección con los elementos de un rango de index
    val arraySlice = array.slice(1, 4)
    printArray(arraySlice, "SLICE")

    // crea una nueva colección sin duplicados
    val array2 = Array(1, 2, 3, 4, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8)
    val arrayDistinct = array2.distinct
    printArray(arrayDistinct, "Distinct")
  }

  def queries():Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7)
    // Operacion que devuelve el primer número que cumpla la condición
    var isFind = array.find(i => i % 2 == 0 && i > 4)
    println(isFind) // Some(6)
    isFind = array.find(i => i % 2 == 0 && i > 10)
    println(isFind) // None

    // Operación que devuelve un Bolean que te indica si hauy algún elemento que cumple esa condición
    var isExist = array.exists(x => x > 1)
    println(isExist) // true
    isExist = array.exists(_ > 10)
    println(isExist) // false
  }

  def aggregations():Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7)
    printArray(array, "MKSTRING")

    // Toma un valor inicial y una función que utiliza para combinar cada elemento de su colección con el valor inicial, para producir un resultado final:

    val arrayFoldLeft = array.foldLeft(0)((x, y) => x + y) // sum of all elements
    println(arrayFoldLeft)

    val arrayFoldLeft2 = array.foldLeft(1)((x, y) => x * y)
    println(arrayFoldLeft2)

    val arrayFoldLeft3 = array.foldLeft(1)(_*_)
    println(arrayFoldLeft3)

    val arrayGroupBy = array.groupBy(_ % 2)
    arrayGroupBy.foreach( item => {
      val arrayMap = item._2.mkString("[", ", ", "]")
      println("Array:" + item._1 +  " " + arrayMap)
    })


  }

  def main(args: Array[String]): Unit = {
    // builder()
    // factoryMethods()
    // transforms()
    // queries()
    aggregations()
  }

}