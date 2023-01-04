# Estructuras básicas

## Tuples

Las tuplas son colección de valores. Para acceder al valor hay que especificar la posición empezando con 1. Puede contener de 1 a 22 elementos. Sin embargo si se va a usar muchos elementos es recomendable cambiarlos por una clase:


```scala
val t1:(Int, Boolean, String) = (1, true, "hello")
println("El valor de la tupla es: " + t1._1 + "," + t1._2 + " y " + t1._3)
```
