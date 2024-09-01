// Creación de una clase producto con precio y descuento
// Evelyn Milagros Chipana Ramos
// Creación: 01-09-2024
// Finalización:

import java.util.Scanner

//clase producto
class Producto(private var _precio: Double, private var _descuento: Double) {

    var precio: Double
        get() = _precio
        set(value) {
            require(value >= 0) { "El precio no puede ser negativo." } //precio mayor a cero
            _precio = value
        }

    var descuento: Double
        get() = _descuento
        set(value) {
            require(value in 0.0..100.0) { "El descuento debe estar entre 0 y 100." } //descuento entre los limites
            _descuento = value
        }

    val precioFinal: Double
        get() = _precio * (1 - _descuento / 100) //calculo del precio con el descuento

    override fun toString(): String {
        return "Producto(precio=\$${"%.2f".format(precio)}, descuento=${descuento}%, precio final=\$${"%.2f".format(precioFinal)})"
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    println("Ingresa el precio del producto:")
    val precio = scanner.nextDouble()

    println("Ingresa el descuento (%):")
    val descuento = scanner.nextDouble()

    val producto = Producto(precio, descuento)

    println(producto)

    //actualización de datos 
    println("\n¿Quiere actualizar los valores? (si/no)")
    val respuesta = scanner.next()

    if (respuesta.equals("si", ignoreCase = true)) {
        println("Ingresa el nuevo precio:")
        producto.precio = scanner.nextDouble()

        println("Ingresa el nuevo descuento (%):")
        producto.descuento = scanner.nextDouble()

        println(producto)
    }
}
