// Sistema de gesstión de una biblioteca, que contiene interfaces y clases, también instancias para ejecutar préstamos y devoluciones
// Evelyn Milagros Chipana Ramos
// Creación: 01-09-2024
// Finalización: 01-09-2024

import java.util.Scanner

//clase abstracta con los materiales
abstract class Material(val titulo: String, val autor: String, val anioPublicacion: Int) {
    abstract fun mostrarDetalles(): String
}
//propiedades de los libros
class Libro(titulo: String, autor: String, anioPublicacion: Int, val genero: String, val numeroPaginas: Int)
    : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles(): String {
        return "Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numeroPaginas"
    }
}
//similar a la clase libro, solo que implementada a la revista
class Revista(titulo: String, autor: String, anioPublicacion: Int, val issn: String, val volumen: Int, val numero: Int, val editorial: String)
    : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles(): String {
        return "Revista: $titulo, Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial"
    }
}
//propiedades del usuario
data class Usuario(val nombre: String, val apellido: String, val edad: Int)

//metodos escenciales para la gestión de la biblioteca
interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material): Boolean
    fun devolverMaterial(usuario: Usuario, material: Material): Boolean
    fun mostrarMaterialesDisponibles(): List<String>
    fun mostrarMaterialesReservados(usuario: Usuario): List<String>
}

//implementacion de la biblioteca y gestiona prestamos y devoluciones
class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuariosConPrestamos = mutableMapOf<Usuario, MutableList<Material>>()
    //metodo para registrar material en la biblioteca
    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }
    //metodo para registrar usuario de la biblioteca
    override fun registrarUsuario(usuario: Usuario) {
        if (!usuariosConPrestamos.containsKey(usuario)) {
            usuariosConPrestamos[usuario] = mutableListOf()
        }
    }
    //metodo para prestamos de la biblioteca
    override fun prestarMaterial(usuario: Usuario, material: Material): Boolean {
        if (materialesDisponibles.contains(material)) {
            materialesDisponibles.remove(material)
            usuariosConPrestamos[usuario]?.add(material)
            return true
        }
        return false
    }
    //metodo para devoluciones de la biblioteca
    override fun devolverMaterial(usuario: Usuario, material: Material): Boolean {
        if (usuariosConPrestamos[usuario]?.contains(material) == true) {
            usuariosConPrestamos[usuario]?.remove(material)
            materialesDisponibles.add(material)
            return true
        }
        return false
    }

    override fun mostrarMaterialesDisponibles(): List<String> {
        return materialesDisponibles.map { it.mostrarDetalles() } //materiales disponibles
    }

    override fun mostrarMaterialesReservados(usuario: Usuario): List<String> {
        return usuariosConPrestamos[usuario]?.map { it.mostrarDetalles() } ?: listOf() //materiales reservados
    }

    fun buscarUsuario(nombre: String, apellido: String): Usuario? {
        return usuariosConPrestamos.keys.find { it.nombre.equals(nombre, ignoreCase = true) && it.apellido.equals(apellido, ignoreCase = true) }
    }

    fun buscarMaterialPorTitulo(titulo: String): Material? {
        return materialesDisponibles.find { it.titulo.equals(titulo, ignoreCase = true) }
    }

    fun buscarMaterialPrestadoPorTitulo(usuario: Usuario, titulo: String): Material? {
        return usuariosConPrestamos[usuario]?.find { it.titulo.equals(titulo, ignoreCase = true) }
    }
}

fun main() {
    val biblioteca = Biblioteca()
    val scanner = Scanner(System.`in`)

    while (true) { //menu del sistema
        println("\n***** Sistema de Gestión de Biblioteca *****")
        println("1. Registrar Material")
        println("2. Registrar Usuario")
        println("3. Prestar Material")
        println("4. Devolver Material")
        println("5. Mostrar Materiales Disponibles")
        println("6. Mostrar Materiales Reservados por Usuario")
        println("7. Salir")
        print("Seleccione una opción: ")
        //registros de los datos del libro
        when (scanner.nextInt()) {
            1 -> { //registro de material
                print("Ingrese tipo de material (libro/revista): ")
                val tipo = scanner.next()
                scanner.nextLine()
                print("Título: ")
                val titulo = scanner.nextLine()
                print("Autor: ")
                val autor = scanner.nextLine()
                print("Año de Publicación: ")
                val anio = scanner.nextInt()

                if (tipo.equals("libro", true)) {
                    scanner.nextLine()
                    print("Género: ")
                    val genero = scanner.nextLine()
                    print("Número de Páginas: ")
                    val paginas = scanner.nextInt()
                    val libro = Libro(titulo, autor, anio, genero, paginas)
                    biblioteca.registrarMaterial(libro)
                    println("Libro registrado con éxito.")
                } else if (tipo.equals("revista", true)) {
                    scanner.nextLine()
                    print("ISSN: ")
                    val issn = scanner.nextLine()
                    print("Volumen: ")
                    val volumen = scanner.nextInt()
                    print("Número: ")
                    val numero = scanner.nextInt()
                    scanner.nextLine()
                    print("Editorial: ")
                    val editorial = scanner.nextLine()
                    val revista = Revista(titulo, autor, anio, issn, volumen, numero, editorial)
                    biblioteca.registrarMaterial(revista)
                    println("Revista registrada con éxito.")
                } else {
                    println("Tipo de material no válido.")
                }
            }

            2 -> { //registro de usuarios
                scanner.nextLine()
                print("Nombre: ")
                val nombre = scanner.nextLine()
                print("Apellido: ")
                val apellido = scanner.nextLine()
                print("Edad: ")
                val edad = scanner.nextInt()
                val usuario = Usuario(nombre, apellido, edad)
                biblioteca.registrarUsuario(usuario)
                println("Usuario registrado con éxito.")
            }

            3 -> { //prestamos
                scanner.nextLine()
                print("Ingrese su nombre: ")
                val nombreUsuario = scanner.nextLine()
                print("Ingrese su apellido: ")
                val apellidoUsuario = scanner.nextLine()

                val usuario = biblioteca.buscarUsuario(nombreUsuario, apellidoUsuario)
                if (usuario == null) {
                    println("Usuario no encontrado.")
                    continue
                }

                println("Materiales disponibles:")
                biblioteca.mostrarMaterialesDisponibles().forEach { println(it) } //disponibilidad de libros o revistas

                print("Título del material a prestar: ")
                val tituloMaterial = scanner.nextLine()

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

            4 -> { //devoluciones
                scanner.nextLine()
                print("Ingrese su nombre: ")
                val nombreUsuario = scanner.nextLine()
                print("Ingrese su apellido: ")
                val apellidoUsuario = scanner.nextLine()

                val usuario = biblioteca.buscarUsuario(nombreUsuario, apellidoUsuario)
                if (usuario == null) {
                    println("Usuario no encontrado.")
                    continue
                }

                print("Título del material a devolver: ")
                val tituloMaterial = scanner.nextLine()

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

            5 -> { //disponibilidad de materiales
                println("Materiales disponibles:")
                biblioteca.mostrarMaterialesDisponibles().forEach { println(it) }
            }

            6 -> { //reservas de los usuarios
                scanner.nextLine()
                print("Ingrese su nombre: ")
                val nombreUsuario = scanner.nextLine()
                print("Ingrese su apellido: ")
                val apellidoUsuario = scanner.nextLine()

                val usuario = biblioteca.buscarUsuario(nombreUsuario, apellidoUsuario)
                if (usuario == null) {
                    println("Usuario no encontrado.")
                    continue
                }

                println("Materiales reservados:")
                val reservados = biblioteca.mostrarMaterialesReservados(usuario)
                if (reservados.isEmpty()) {
                    println("No tienes materiales reservados.")
                } else {
                    reservados.forEach { println(it) }
                }
            }

            7 -> { //salida
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


