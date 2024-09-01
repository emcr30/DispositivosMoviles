// Creación de una cuenta bancaria con saldo y un límite de retiro
// Evelyn Milagros Chipana Ramos
// Creación: 01-09-2024
// Finalización: 01-09-2024

import java.util.Scanner
//creacion de la clase cuenta bancaria
class CuentaBancaria(private var saldo: Double, private var limiteRetiro: Double) {
    //implementacion de set y get
    fun getSaldo(): Double { //saldo actual
        return saldo
    }

    fun setSaldo(nuevoSaldo: Double) { //nuevo saldo
        if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo
        } else {
            println("El saldo no puede ser negativo.")
        }
    }

    fun getLimiteRetiro(): Double { //limite de retiro
        return limiteRetiro
    }

    fun setLimiteRetiro(nuevoLimite: Double) { //nuevo limite de retiro
        if (nuevoLimite >= 0) {
            limiteRetiro = nuevoLimite
        } else {
            println("El límite de retiro no puede ser negativo.")
        }
    }

    fun retirar(cantidad: Double): Boolean { //retiro de la cuenta
        return if (cantidad > limiteRetiro) {
            println("La cantidad excede el límite de retiro.")
            false
        } else if (cantidad > saldo) {
            println("Saldo insuficiente.")
            false
        } else {
            saldo -= cantidad
            println("Retiro exitoso. Nuevo saldo: $$saldo")
            true
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`) //leer la entrada del usuario

    println("Ingrese el saldo inicial:")
    val saldoInicial = scanner.nextDouble()

    println("Ingrese el límite de retiro:")
    val limiteInicial = scanner.nextDouble()

    val cuenta = CuentaBancaria(saldoInicial, limiteInicial)

    while (true) { //loop que finaliza el usuario
        //menu
        println("\nSeleccione una opción:")
        println("1. Ver saldo")
        println("2. Establecer saldo")
        println("3. Ver límite de retiro")
        println("4. Establecer límite de retiro")
        println("5. Retirar dinero")
        println("6. Salir")

        when (scanner.nextInt()) {
            1 -> println("Saldo actual: $${cuenta.getSaldo()}")
            2 -> {
                println("Ingrese el nuevo saldo:")
                cuenta.setSaldo(scanner.nextDouble())
            }
            3 -> println("Límite de retiro actual: $${cuenta.getLimiteRetiro()}")
            4 -> {
                println("Ingrese el nuevo límite de retiro:")
                cuenta.setLimiteRetiro(scanner.nextDouble())
            }
            5 -> {
                println("Ingrese la cantidad a retirar:")
                cuenta.retirar(scanner.nextDouble())
            }
            6 -> {
                println("Saliendo...")
                break
            }
            else -> println("Opción no válida. Intente nuevamente.")
        }
    }
}



