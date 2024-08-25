// En este proyecto se visualiza una calculadora con las funciones básicas (suma, resta, multiplicación y división)
// Evelyn Milagros Chipana Ramos
// Creación: 25-08-2024
// Finalización: 25-08-2024

fun main(){
    //control del loop del menú
    var calculadora = true

    while(calculadora){
        println("************ MENÚ ************ ")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicacion")
        println("4. Division")
        println("5. Salir")
        println("Elige una opción del 1 al 5: ")

        //leer la opcion del usuario
        val opcion = readln().toIntOrNull()

        //elegir opciones
        when (opcion) {
            1 -> Operacion("suma")
            2 -> Operacion("resta")
            3 -> Operacion("multiplicacion")
            4 -> Operacion("division")
            5 -> {
                println("SALIENDO DE LA CALCULADORA")
                calculadora = false
            }
            else -> println("Opcion no válida. Elige del 1 al 5")
        }
    }

}

