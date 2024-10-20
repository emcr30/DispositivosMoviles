package com.example.examenparcial

object Constants {

    // Función que devuelve una lista de preguntas
    fun getQuestion(): ArrayList<Question> {

        // Lista para almacenar las preguntas
        val questionsList = ArrayList<Question>()

        // Creación de las preguntas y adición a la lista
        val que1 = Question(
            1,
            "¿Cuál es el álbum debut de Taylor Swift?", // Pregunta
            R.drawable.taylor1, // Referencia a la imagen asociada
            "Fearless", // Opción 1
            "Taylor Swift", // Opción 2
            "Speak Now", // Opción 3
            "1989", // Opción 4
            2 // Índice de la opción correcta
        )

        val que2 = Question(
            2,
            "¿Qué canción de Taylor Swift tiene la letra 'We are never ever getting back together'?", // Pregunta
            R.drawable.taylor2, // Referencia a la imagen asociada
            "Shake It Off", // Opción 1
            "Love Story", // Opción 2
            "All Too Well", // Opción 3
            "We Are Never Ever Getting Back Together", // Opción 4
            4 // Índice de la opción correcta
        )

        val que3 = Question(
            3,
            "¿Cuál fue el primer sencillo del álbum '1989'?", // Pregunta
            R.drawable.taylor3, // Referencia a la imagen asociada
            "Blank Space", // Opción 1
            "Shake It Off", // Opción 2
            "Style", // Opción 3
            "Wildest Dreams", // Opción 4
            2 // Índice de la opción correcta
        )

        val que4 = Question(
            4,
            "¿En qué año lanzó Taylor Swift su álbum 'Folklore'?", // Pregunta
            R.drawable.taylor4, // Referencia a la imagen asociada
            "2018", // Opción 1
            "2020", // Opción 2
            "2019", // Opción 3
            "2021", // Opción 4
            2 // Índice de la opción correcta
        )

        val que5 = Question(
            5,
            "¿Cuál es el nombre de la gira que apoyó el álbum 'Reputation'?", // Pregunta
            R.drawable.taylor5, // Referencia a la imagen asociada
            "The Red Tour", // Opción 1
            "The 1989 World Tour", // Opción 2
            "The Speak Now World Tour", // Opción 3
            "The Reputation Stadium Tour", // Opción 4
            4 // Índice de la opción correcta
        )

        // Añadir preguntas a la lista
        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)

        // Devuelve la lista de preguntas
        return questionsList
    }
}
