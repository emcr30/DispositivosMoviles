

import kotlin.random.Random

fun main() {
    val elegir = arrayOf("piedra", "papel", "tijera")
    val PC = elegir[Random.nextInt(elegir.size)]
    print("------- Comencemos -------\n")
    print("Elige piedra, papel o tijera:")
    val usuario = readLine()?.lowercase()
}