package usuario

import evento.Evento

class Usuario(val nombre: String) {
    val inscripciones: MutableSet<Evento> = HashSet()
    val esperas: MutableSet<Evento> = HashSet()
    val eventosOrganizados: MutableSet<Evento> = HashSet()

    fun addInscripcion(evento: Evento): Result<Unit> = add(evento, inscripciones)

    fun removeInscripcion(evento: Evento): Result<Unit> = remove(evento, inscripciones, "inscripto")

    fun addEspera(evento: Evento): Result<Unit> = add(evento, esperas)

    fun removeEspera(evento: Evento): Result<Unit> = remove(evento, esperas, "en espera")

    private fun add(evento: Evento, eventos: MutableSet<Evento>): Result<Unit> {
        if (this.anotado(evento)) {
            return Result.failure(RuntimeException("El usuario ya estaba anotado"))
        }
        eventos.add(evento)
        return Result.success(Unit)
    }

    private fun remove(evento: Evento, eventos: MutableSet<Evento>, keyword: String): Result<Unit> {
        return if (eventos.remove(evento)) {
            Result.success(Unit)
        } else {
            Result.failure(RuntimeException("El usuario no estaba $keyword"))
        }
    }

    fun anotado(evento: Evento): Boolean = inscripciones.contains(evento) || esperas.contains(evento)
}