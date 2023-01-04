# Scala Collections

El núcleo de la biblioteca estándar de Scala son sus colecciones: un conjunto común de contenedores y estructuras de datos que comparten todos los programas Scala. Las colecciones de Scala te facilitan la manipulación de arrays, listas enlazadas, conjuntos, mapas y otras estructuras de datos de maneras convenientes, proporcionando incorporadas muchas de las estructuras de datos necesarias para implementar una aplicación típica. 


## Operaciones

Las colecciones en Scala proporcionan muchas operaciones comunes para construirlas, consultarlas o transformarlas. Empezando por los **Arrays**. Los arrays en escala es una estructura mutable de tamaño variable.

### Builder

Por ejemplo para construir un array sin tamaño especifico:


```scala
val array1 = Array.newBuilder[Int]
```

Para añadir nuevos elementos se emplea ```+= ```

```scala
array1 += 1
array1 += 2
// se crea una colección a través del creado
val array2 = array1.result()
```

Los constructores te permiten construir eficientemente una colección de longitud desconocida, "freezing" en la colección que quieras al final. Esto es muy útil para construir Arrays o colecciones inmutables donde no se pueden añadir o eliminar elementos una vez que la colección ha sido construida.


### Factory Methods

Estos metodos es otra forma de instanciar colecciones. Por ejemplo crear con elementos repetidos

```scala
val array3 = Array.fill(5)("hello ")
```

Crear con elementos repetidos junto a su index
```scala
val array4 = Array.tabulate(5)(n => s"hello $n")
```

O juntar dos arrays con ```++ ```
```scala
val array5 = array3 ++ array4
```

### Transforms

Estas operaciones crea una nueva colección, es decir, no modifica la colección sino que crea una nueva. Esto tiene cierta sobrecarga, pero en la mayoría de los casos no debería causar problemas.
Si un trozo de código resulta ser un cuello de botella que ralentiza tu programa, siempre puedes convertir tu código de transformación .map/.filter/etc. en operaciones de mutación., en operaciones mutantes sobre Arrays sin procesar o In-Place Operations (4.3.4) sobre Mutable Collections (4.3) para optimizar el rendimiento. 

Las operaciones mas famosas:

Crea una nueva colección con los mismos elementos con la operación nueva
```scala
Array(1, 2, 3, 4, 5).map( x => x*2)
```

Crea una nueva colección con los elementos que cumpla la condición
```scala
Array(1, 2, 3, 4, 5).filter(x => x%2==0)
```

Crea una nueva colección con los x primeros elementos
```scala
Array(1, 2, 3, 4, 5).take(2)
```

Crea una nueva colección borrando los x primeros elementos
```scala
Array(1, 2, 3, 4, 5).slice(1, 4)
```

Crea una nueva colección sin duplicados
```scala
 Array(1, 2, 3, 4, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8).distinct
```

### Queries

Queries son operaciones que devuelven true o false, o Option (Some/None) para verificar si se cumple una condición. 

Las operacionees mas usadas:

Devuelve un Option si existe devuelve el primer número que cumpla la condición

```scala
Array(1, 2, 3, 4, 5, 6, 7).find(i => i % 2 == 0 && i > 4)
Array(1, 2, 3, 4, 5, 6, 7).find(i => i % 2 == 0 && i > 10)
```

Devuelve un Bolean viendo si cumple la condition
```scala
Array(1, 2, 3, 4, 5, 6, 7).exists(x => x > 1) // are any elements greater than 1?
Array(1, 2, 3, 4, 5, 6, 7).exists(_ < 0) // same as a.exists(x => x < 0)
```

### Aggregations



Stringifica los elementos de una colección y los combina en una cadena larga, con el separador dado.  Opcionalmente puede tomar un delimitador de inicio y final:
```scala
@ Array(1, 2, 3, 4, 5, 6, 7).mkString(",")
res21: String = "1,2,3,4,5,6,7"
@ Array(1, 2, 3, 4, 5, 6, 7).mkString("[", ",", "]")
res22: String = "[1,2,3,4,5,6,7]"
```

Toma un valor inicial y una función que utiliza para combinar cada elemento de su colección con el valor inicial, para producir un resultado final:

```scala
// suma todos los elementos
array.foldLeft(0)((x, y) => x + y)
// multiplica todos los elementos
array.foldLeft(1)((x, y) => x * y) 
// misma resultado, distinta sintaxis
array.foldLeft(1)(_*_)
```

Utilizar el foldLeft es similar a un for con una variable total
```scala
{
    var total = 0
    for (i <- Array(1, 2, 3, 4, 5, 6, 7)) total += i
    total
}
```

Otro metodo es groupBy que separa en 2 Maps los que cumplen esa condición

```scala
val arrayGroupBy = array.groupBy(_ % 2)
arrayGroupBy.foreach( item => {
  val arrayMap = item._2.mkString("[", ", ", "]")
  println("Array:" + item._1 +  " " + arrayMap)
})
```