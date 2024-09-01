// Creación de una cuenta bancaria con saldo y un límite de retiro
// Evelyn Milagros Chipana Ramos
// Creación: 01-09-2024
// Finalización:

import java.util.Scanner

//creacion de la clase cuenta
class CuentaBancaria(private var saldo: Double, private var limiteRetiro: Double) {
    //implementacion de set y get
    fun getSaldo(): Double {
        return saldo
    }

    fun setSaldo(nuevoSaldo: Double) {
        if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo
        } else {
            println("El saldo no puede ser negativo.")
        }
    }

    fun getLimiteRetiro(): Double {
        return limiteRetiro
    }

    fun setLimiteRetiro(nuevoLimite: Double) {
        if (nuevoLimite >= 0) {
            limiteRetiro = nuevoLimite
        } else {
            println("El límite de retiro no puede ser negativo.")
        }
    }
}


