// Sistema de gesstión de una biblioteca, que contiene interfaces y clases, también instancias para ejecutar préstamos y devoluciones
// Evelyn Milagros Chipana Ramos
// Creación: 01-09-2024
// Finalización: 01-09-2024


import java.util.Scanner

// Clase base abstracta Material
abstract class Material(val titulo: String, val autor: String, val anioPublicacion: Int) {
    abstract fun mostrarDetalles(): String
}

// Subclase Libro
class Libro(titulo: String, autor: String, anioPublicacion: Int, val genero: String, val numeroPaginas: Int)
    : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles(): String {
        return "Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numeroPaginas"
    }
}

// Subclase Revista
class Revista(titulo: String, autor: String, anioPublicacion: Int, val issn: String, val volumen: Int, val numero: Int, val editorial: String)
    : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles(): String {
        return "Revista: $titulo, Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial"
    }
}

// Data class Usuario
data class Usuario(val nombre: String, val apellido: String, val edad: Int)

// Interfaz IBiblioteca
interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material): Boolean
    fun devolverMaterial(usuario: Usuario, material: Material): Boolean
    fun mostrarMaterialesDisponibles(): List<String>
    fun mostrarMaterialesReservados(usuario: Usuario): List<String>
}

// Clase Biblioteca que implementa IBiblioteca
class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuariosConPrestamos = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        if (!usuariosConPrestamos.containsKey(usuario)) {
            usuariosConPrestamos[usuario] = mutableListOf()
        }
    }

    override fun prestarMaterial(usuario: Usuario, material: Material): Boolean {
        return if (materialesDisponibles.contains(material)) {
            materialesDisponibles.remove(material)
            usuariosConPrestamos[usuario]?.add(material)
            true
        } else {
            false
        }
    }

    override fun devolverMaterial(usuario: Usuario, material: Material): Boolean {
        return if (usuariosConPrestamos[usuario]?.contains(material) == true) {
            usuariosConPrestamos[usuario]?.remove(material)
            materialesDisponibles.add(material)
            true
        } else {
            false
        }
    }

    override fun mostrarMaterialesDisponibles(): List<String> {
        return materialesDisponibles.map { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesReservados(usuario: Usuario): List<String> {
        return usuariosConPrestamos[usuario]?.map { it.mostrarDetalles() } ?: listOf()
    }

    fun buscarMaterialPorTitulo(titulo: String): Material? {
        return materialesDisponibles.find { it.titulo.equals(titulo, ignoreCase = true) }
    }

    fun buscarMaterialPrestadoPorTitulo(usuario: Usuario, titulo: String): Material? {
        return usuariosConPrestamos[usuario]?.find { it.titulo.equals(titulo, ignoreCase = true) }
    }
}

// Función principal para la interacción del usuario
fun main() {
    val biblioteca = Biblioteca()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\n--- Sistema de Gestión de Biblioteca ---")
        println("1. Registrar Material")
        println("2. Registrar Usuario")
        println("3. Prestar Material")
        println("4. Devolver Material")
        println("5. Mostrar Materiales Disponibles")
        println("6. Mostrar Materiales Reservados por Usuario")
        println("7. Salir")
        print("Seleccione una opción: ")

        when (scanner.nextInt()) {
            1 -> {
                // Registrar Material
                print("Ingrese tipo de material (libro/revista): ")
                val tipo = scanner.next()
                print("Título: ")
                val titulo = scanner.next()
                print("Autor: ")
                val autor = scanner.next()
                print("Año de Publicación: ")
                val anio = scanner.nextInt()

                if (tipo.equals("libro", true)) {
                    print("Género: ")
                    val genero = scanner.next()
                    print("Número de Páginas: ")
                    val paginas = scanner.nextInt()
                    val libro = Libro(titulo, autor, anio, genero, paginas)
                    biblioteca.registrarMaterial(libro)
                    println("Libro registrado con éxito.")
                } else if (tipo.equals("revista", true)) {
                    print("ISSN: ")
                    val issn = scanner.next()
                    print("Volumen: ")
                    val volumen = scanner.nextInt()
                    print("Número: ")
                    val numero = scanner.nextInt()
                    print("Editorial: ")
                    val editorial = scanner.next()
                    val revista = Revista(titulo, autor, anio, issn, volumen, numero, editorial)
                    biblioteca.registrarMaterial(revista)
                    println("Revista registrada con éxito.")
                } else {
                    println("Tipo de material no válido.")
                }
            }

            2 -> {
                // Registrar Usuario
                print("Nombre: ")
                val nombre = scanner.next()
                print("Apellido: ")
                val apellido = scanner.next()
                print("Edad: ")
                val edad = scanner.nextInt()
                val usuario = Usuario(nombre, apellido, edad)
                biblioteca.registrarUsuario(usuario)
                println("Usuario registrado con éxito.")
            }

            3 -> {
                // Prestar Material
                print("Ingrese su nombre: ")
                val nombreUsuario = scanner.next()
                print("Ingrese su apellido: ")
                val apellidoUsuario = scanner.next()
                val usuario = Usuario(nombreUsuario, apellidoUsuario, 0)

                println("Materiales disponibles:")
                biblioteca.mostrarMaterialesDisponibles().forEach { println(it) }

                print("Título del material a prestar: ")
                val tituloMaterial = scanner.next()

                val material = biblioteca.buscarMaterialPorTitulo(tituloMaterial)
                if (material != null) {
                    val prestado = biblioteca.prestarMaterial(usuario, material)
                    if (prestado) {
                        println("Material prestado con éxito.")
                    } else {
                        println("No se pudo prestar el material.")
                    }
                } else {
                    println("Material no disponible.")
                }
            }

            4 -> {
                // Devolver Material
                print("Ingrese su nombre: ")
                val nombreUsuario = scanner.next()
                print("Ingrese su apellido: ")
                val apellidoUsuario = scanner.next()
                val usuario = Usuario(nombreUsuario, apellidoUsuario, 0)

                print("Título del material a devolver: ")
                val tituloMaterial = scanner.next()

                val material = biblioteca.buscarMaterialPrestadoPorTitulo(usuario, tituloMaterial)
                if (material != null) {
                    val devuelto = biblioteca.devolverMaterial(usuario, material)
                    if (devuelto) {
                        println("Material devuelto con éxito.")
                    } else {
                        println("No se pudo devolver el material.")
                    }
                } else {
                    println("No tienes ese material reservado.")
                }
            }

            5 -> {
                // Mostrar Materiales Disponibles
                println("Materiales disponibles:")
                biblioteca.mostrarMaterialesDisponibles().forEach { println(it) }
            }

            6 -> {
                // Mostrar Materiales Reservados por Usuario
                print("Ingrese su nombre: ")
                val nombreUsuario = scanner.next()
                print("Ingrese su apellido: ")
                val apellidoUsuario = scanner.next()
                val usuario = Usuario(nombreUsuario, apellidoUsuario, 0)

                println("Materiales reservados:")
                biblioteca.mostrarMaterialesReservados(usuario).forEach { println(it) }
            }

            7 -> {
                // Salir
                println("Saliendo del sistema...")
                break
            }

            else -> {
                println("Opción no válida.")
            }
        }
    }
    scanner.close()
}
