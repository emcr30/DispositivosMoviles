//EVALUACIÓN DE EMPLEADOS: Se calificará a los empleados con un puntaje de 0 a 10, para con esto calcular su sueldo por su rendimiento.
//// Evelyn Milagros Chipana Ramos
//// Creación: 25-08-2024
//// Finalización: 25-08-2024

fun main(){
    //ingresar los datos del empleado
    print("Ingrese su nombre: ")
    val nombre = readLine()

    print("Ingrese su puntuación: ")
    val puntuacion = readLine().toInt()

    print("Ingrese su salario: ")
    val salario = readLine().toDouble()

    //calcular el rendimiento
    val rendimiento = when (puntuacion){
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
    }

}