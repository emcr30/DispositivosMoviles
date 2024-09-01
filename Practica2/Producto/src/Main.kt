class Producto(private var _precio: Double, private var _descuento: Double) {

    var precio: Double
        get() = _precio
        set(value) {
            require(value >= 0) { "El precio no puede ser negativo." }
            _precio = value
        }

    var descuento: Double
        get() = _descuento
        set(value) {
            require(value in 0.0..100.0) { "El descuento debe estar entre 0 y 100." }
            _descuento = value
        }

    val precioFinal: Double
        get() = _precio * (1 - _descuento / 100)

    override fun toString(): String {
        return "Producto(precio=\$${"%.2f".format(precio)}, descuento=${descuento}%, precio final=\$${"%.2f".format(precioFinal)})"
    }
}

fun main() {
    val producto = Producto(100.0, 10.0)
    println(producto)

    producto.precio = 150.0
    producto.descuento = 20.0
    println(producto)
}
