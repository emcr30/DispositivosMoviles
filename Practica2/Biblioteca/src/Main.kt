// Sistema de gesstión de una biblioteca, que contiene interfaces y clases, también instancias para ejecutar préstamos y devoluciones
// Evelyn Milagros Chipana Ramos
// Creación: 01-09-2024
// Finalización:


// clase base abstracta Material
abstract class Material(val titulo: String, val autor: String, val anioPublicacion: Int) {
    abstract fun mostrarDetalles(): String
}

// subclase Libro
class Libro(titulo: String, autor: String, anioPublicacion: Int, val genero: String, val numeroPaginas: Int)
    : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles(): String {
        return "Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numeroPaginas"
    }
}

// subclase Revista
class Revista(titulo: String, autor: String, anioPublicacion: Int, val issn: String, val volumen: Int, val numero: Int, val editorial: String)
    : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles(): String {
        return "Revista: $titulo, Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial"
    }
}

data class Usuario(val nombre: String, val apellido: String, val edad: Int)

// interfaz IBiblioteca
interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material): Boolean
    fun devolverMaterial(usuario: Usuario, material: Material): Boolean
    fun mostrarMaterialesDisponibles(): List<String>
    fun mostrarMaterialesReservados(usuario: Usuario): List<String>
}

// clase Biblioteca que implementa IBiblioteca
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
}

fun main() {
    val biblioteca = Biblioteca()

    val libro1 = Libro("1984", "George Orwell", 1949, "Distopía", 328)
    val revista1 = Revista("National Geographic", "Varios", 2023, "0027-9358", 195, 3, "NGM")

    val usuario1 = Usuario("Evelyn", "Ramos", 24)

    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(revista1)
    biblioteca.registrarUsuario(usuario1)

    println("Materiales disponibles antes del préstamo:")
    println(biblioteca.mostrarMaterialesDisponibles())

    biblioteca.prestarMaterial(usuario1, libro1)
    println("\nMateriales disponibles después del préstamo:")
    println(biblioteca.mostrarMaterialesDisponibles())

    println("\nMateriales reservados por ${usuario1.nombre}:")
    println(biblioteca.mostrarMaterialesReservados(usuario1))

    biblioteca.devolverMaterial(usuario1, libro1)
    println("\nMateriales disponibles después de la devolución:")
    println(biblioteca.mostrarMaterialesDisponibles())
}
