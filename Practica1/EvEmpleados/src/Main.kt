//EVALUACIÓN DE EMPLEADOS: Se calificará a los empleados con un puntaje de 0 a 10, para con esto calcular su sueldo por su rendimiento.
//// Evelyn Milagros Chipana Ramos
//// Creación: 25-08-2024
//// Finalización: 25-08-2024

fun main(){
    //ingresar los datos del empleado
    print("Ingrese su nombre: ")
    val nombre = readLine()

    print("Ingrese su puntuación (0 a 10): ")
    val puntuacion = readLine()?.toIntOrNull() ?: return println("Puntuación inválida")

    print("Ingrese su salario: ")
    val salario = readLine()?.toDoubleOrNull() ?: return println("Salario inválido")

    // Calcular el rendimiento
    val rendimiento = when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Rango NO ACEPTADO"
    }

    //calcular sueldo
    val sueldo = if (puntuacion in 0..10) salario * (puntuacion / 10.0) else 0.0

    // Imprimir resultados
    println("EL EMPLEADO: $nombre")
    println("NIVEL DE RENDIMIENTO: $rendimiento")
    println("SUELDO DEL MES: $${"%.2f".format(sueldo)}")

}
