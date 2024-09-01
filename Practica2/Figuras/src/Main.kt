// En este proyecto se tiene las caraterísticas de las figuras: cuadrado, círculo y rectángulo, las cuales tienen las siguientes propiedades: área y perímetro
// Evelyn Milagros Chipana Ramos
// Creación: 01-09-2024
// Finalización: 01-09-2024

import java.util.Scanner

// clase abstracta Shape
abstract class Shape {
    abstract val area: Double
    abstract val perimetro: Double

    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Área: $area")
        println("Perímetro: $perimetro")
    }
}

// subclase cuadrado
class Cuadrado(val lado: Double) : Shape() {
    override val area: Double
        get() = calcularArea()
    override val perimetro: Double
        get() = calcularPerimetro()

    override fun calcularArea() = lado * lado
    override fun calcularPerimetro() = 4 * lado
}

// subclase rectángulo
class Rectangulo(val ancho: Double, val alto: Double) : Shape() {
    override val area: Double
        get() = calcularArea()
    override val perimetro: Double
        get() = calcularPerimetro()

    override fun calcularArea() = ancho * alto
    override fun calcularPerimetro() = 2 * (ancho + alto)
}

// subclase círculo
class Circulo(val radio: Double) : Shape() {
    override val area: Double
        get() = calcularArea()
    override val perimetro: Double
        get() = calcularPerimetro()

    override fun calcularArea() = Math.PI * radio * radio
    override fun calcularPerimetro() = 2 * Math.PI * radio
}

fun main() {
    val scanner = Scanner(System.`in`)

    println("Seleccione una figura para calcular el área y el perímetro:")
    println("1. Cuadrado")
    println("2. Rectángulo")
    println("3. Círculo")
    print("Opción: ")
    val opcion = scanner.nextInt()

    when (opcion) {
        1 -> {
            print("Ingrese el valor del lado del cuadrado: ")
            val lado = scanner.nextDouble()
            val cuadrado = Cuadrado(lado)
            cuadrado.imprimirResultados()
        }
        2 -> {
            print("Ingrese el valor del ancho del rectángulo: ")
            val ancho = scanner.nextDouble()
            print("Ingrese el valor del alto del rectángulo: ")
            val alto = scanner.nextDouble()
            val rectangulo = Rectangulo(ancho, alto)
            rectangulo.imprimirResultados()
        }
        3 -> {
            print("Ingrese el valor del radio del círculo: ")
            val radio = scanner.nextDouble()
            val circulo = Circulo(radio)
            circulo.imprimirResultados()
        }
        else -> {
            println("Opción no válida")
        }
    }
}
