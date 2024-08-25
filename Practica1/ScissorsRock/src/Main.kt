// Este código te permite jugar PIEDRA, PAPEL y TIJERA, la computadora decidirá quién ganará aleatoriamente,
// Evelyn Milagros Chipana Ramos
// Creación: 24-08-2024

import kotlin.random.Random

fun main() {
    //creacion de un array con las opciones
    val elegir = arrayOf("piedra", "papel", "tijera")
    val PC = elegir[Random.nextInt(elegir.size)]
    print("------- Comencemos -------\n")
    print("Elige piedra, papel o tijera: ")
    //asegurar que el jugador ingrese datos
    val jugador = readLine()?.lowercase()

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

