// En este proyecto se tiene las caraterísticas de las figuras: cuadrado, círculo y rectángulo, las cuales tienen las siguientes propiedades: área y perímetro
// Evelyn Milagros Chipana Ramos
// Creación: 01-09-2024
// Finalización:

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
    val cuadrado = Cuadrado(4.0)
    val rectangulo = Rectangulo(4.0, 5.0)
    val circulo = Circulo(3.0)

    println("Resultados del Cuadrado:")
    cuadrado.imprimirResultados()

    println("\nResultados del Rectángulo:")
    rectangulo.imprimirResultados()

    println("\nResultados del Círculo:")
    circulo.imprimirResultados()
}
