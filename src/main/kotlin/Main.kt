var listaOrdenada = listOf<Jugador>()
fun main() {
    val dado1 = Dado()
    val dado2 = Dado(1,3)
    val dado3 = Dado(4,6)


    val listaJugadores = List(100){
        Jugador(it.toString(), dado1,dado2,dado3)
    }

    listaOrdenada = listaJugadores.sortedByDescending { it.sumaTotal }


    println(mostrarResultado())
}

fun mostrarResultado():String {
    var output = ""
    listaOrdenada.forEach { output += it.toString() + "\n" }
    return output
}

class Jugador(val nombre: String, val dado1: Dado, val dado2: Dado, val dado3: Dado) {

    var sumaTotal = 0

    init {
        repeat(100){
            sumaTotal += dado1.tiradaUnica()
            sumaTotal += dado2.tiradaUnica()
            sumaTotal += dado3.tiradaUnica()
        }
    }

    override fun toString(): String {
        return "Jugador $nombre ha sacado $sumaTotal puntos"
    }
}