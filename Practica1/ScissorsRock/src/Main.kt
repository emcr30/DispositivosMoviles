// Este código te permite jugar PIEDRA, PAPEL y TIJERA, la computadora decidirá quién ganará aleatoriamente.
// Evelyn Milagros Chipana Ramos
// Creación: 25-08-2024
// Finalización: 25-08-2024

import kotlin.random.Random

fun main() {
    //creacion de un array con las opciones
    val elegir = arrayOf("piedra", "papel", "tijera")
    while (true) {
        val PC = elegir[Random.nextInt(elegir.size)]
        print("-----------------¡A JUGAR! -----------------\n")
        print("NOTA : Escribe 'salir' si quieres abandonar el juego.\n")
        print("*****COMENCEMOS*****\n")
        print("Elige piedra, papel o tijera: ")
        //asegurar que el jugador ingrese datos correctos
        val jugador = readln()?.lowercase()

        if (jugador == "salir") {
            println("Gracias por jugar. ¡Nos vemos pronto!")
            break // salir del bucle si el jugador elige salir
        }

        when {
            jugador == PC -> println("¡Empate!")
            //comprueba que el jugador gana con la eleccion que hizo
            jugador == "piedra" && PC == "tijera" ||
                    jugador == "papel" && PC == "piedra" ||
                    jugador == "tijera" && PC == "papel" -> println("¡GANASTE! :D")
            //verificar que la eleccion sea válida
            jugador in elegir -> println("¡PERDISTE! :( LA PC ELIGIÓ: $PC")
            //por si no coincide la entrada del jugador
            else -> println("Opción no válida")
        }
    }
}
