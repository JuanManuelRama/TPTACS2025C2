package evento.filtro

import evento.Evento

interface FiltroEvento {
    fun cumple(evento: Evento): Boolean
}