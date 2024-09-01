// En este proyecto se tiene las caraterísticas de las figuras: cuadrado, círculo y rectángulo, las cuales tienen las siguientes propiedades: área y perímetro
// Evelyn Milagros Chipana Ramos
// Creación: 01-09-2024
// Finalización:


// clase abstracta Shape
abstract class Shape {
    abstract val area: Double
    abstract val perimetro: Double

    abstract fun calculateArea(): Double
    abstract fun calculatePerimeter(): Double

    fun printResults() {
        println("Área: $area")
        println("Perímetro: $perimetro")
    }
}


