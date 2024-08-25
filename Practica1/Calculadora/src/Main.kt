// En este proyecto se visualiza una calculadora con las funciones básicas (suma, resta, multiplicación y división)
// Evelyn Milagros Chipana Ramos
// Creación: 25-08-2024
// Finalización: 25-08-2024

fun main() {
    // Control del loop del menú
    var calculadora = true

    while (calculadora) {
        println("************ MENÚ ************ ")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        println("Elige una opción del 1 al 5: ")

        // Leer la opción del usuario
        val opcion = readln().toIntOrNull()

        // Elegir opciones
        when (opcion) {
            1 -> Operacion("suma")
            2 -> Operacion("resta")
            3 -> Operacion("multiplicación")
            4 -> Operacion("división")
            5 -> {
                println("SALIENDO DE LA CALCULADORA")
                calculadora = false
            }
            else -> println("Opción no válida. Elige del 1 al 5")
        }
    }
}

// Ingresar los números
fun Operacion(type: String) {
    print("Ingrese el primer número: ")
    val num1 = readln().toDoubleOrNull() ?: run {
        println("Ingreso no válido. Tiene que ser un número.")
        return
    }
    print("Ingrese el segundo número: ")
    val num2 = readln().toDoubleOrNull() ?: run {
        println("Ingreso no válido. Tiene que ser un número.")
        return
    }

    // Realizando las operaciones
    when (type) {
        "suma" -> println("RESPUESTA: ${num1 + num2}")
        "resta" -> println("RESPUESTA: ${num1 - num2}")
        "multiplicación" -> println("RESPUESTA: ${num1 * num2}")
        "división" -> {
            if (num2 != 0.0) { // verificar double
                val respuesta = num1 / num2
                println("RESPUESTA: $respuesta")
            } else {
                println("No se puede dividir entre cero")
            }
        }
    }
}
