// En este código podremos adivinar un número elegido aleatoriamente por la PC.
// Evelyn Milagros Chipana Ramos
// Creación: 25-08-2024
// Finalización: 25-08-2024

import kotlin.random.Random

fun main(){

    //genera un numero aleatorio entre 1 y 30
    val numGuess = Random.nextInt(1, 31)
    var intentos = 5 //intentos permitidos

    println("Adivina el número entre 1 y 30. Tienes $intentos intentos")
    println("**SUERTE**")

    //comienzo del bucle para varios intentos
    while (intentos > 0){
        println("Ingrese un número: ")
        val trys = readLine()!!.toInt()

        //logica para saber si la entrada es menor o mayor
        when {
            trys == numGuess -> {
                println("ADIVINASTE EL NÚMERO CORRECTO :D")
                break
            }
            trys < numGuess -> print("El número es mayor\n")
            trys > numGuess -> print("El número es menor\n")
        }

        intentos--

        //cantidad de intentos y si la respuesta es incorrecta
        if (intentos > 0){
            println("Te quedan $intentos intentos")
        } else {
            println("PERDISTE :(")
            println("El número era $numGuess")
        }
    }
}