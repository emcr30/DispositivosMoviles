// Creación de una cuenta bancaria con saldo y un límite de retiro
// Evelyn Milagros Chipana Ramos
// Creación: 01-09-2024
// Finalización:

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





