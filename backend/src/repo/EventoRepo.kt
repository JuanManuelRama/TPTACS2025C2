package repo

import evento.Evento
import evento.FiltroFechaAntes
import java.util.HashSet

interface EventoRepo {
    fun getEventos(): Set<Evento>

    fun getEventosFiltrado(filtro: FiltroFechaAntes): Set<Evento>
}

object EventoRepository : EventoRepo {
    private val eventos = mutableSetOf<Evento>()

    override fun getEventos(): Set<Evento> = HashSet(eventos)

    override fun getEventosFiltrado(filtro: FiltroFechaAntes): Set<Evento> =
        eventos.filter { filtro.cumple(it) }.toSet()
}