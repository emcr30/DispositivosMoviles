
package com.example.examenparcial

class Question(
    val id: Int,                // Identificador de la pregunta
    val question: String,       // Texto de la pregunta
    val image: Int,             // Referencia a la imagen
    val option1: String,        // Opción 1
    val option2: String,        // Opción 2
    val option3: String,        // Opción 3
    val option4: String,        // Opción 4
    val correctOption: Int      // Índice de la respuesta correcta
)
