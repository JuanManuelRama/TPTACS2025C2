package evento

import java.time.LocalDate

interface FiltroEvento { fun cumple(evento: Evento): Boolean }

class FiltroPalabrasClave(val palabra: String) : FiltroEvento {
    override fun cumple(evento: Evento): Boolean = evento.titulo.contains(palabra)
}

class FiltroFechaAntes (val fecha: LocalDate)  : FiltroEvento {
    override fun cumple(evento: Evento): Boolean = evento.fecha.isBefore(fecha)
}

class FiltroFechaDespues(val fecha: LocalDate) : FiltroEvento {
    override fun cumple(evento: Evento): Boolean = evento.fecha.isAfter(fecha)
}

class FiltroCategoria(val categoria: Categoria): FiltroEvento {
    override fun cumple(evento: Evento): Boolean = evento.categorias.contains(categoria)
}

class FiltroPrecioMayor(val precio: Double) : FiltroEvento {
    override fun cumple(evento: Evento): Boolean = evento.precio >= precio
}

class FiltroPrecioMenor(val precio: Double) : FiltroEvento {
    override fun cumple(evento: Evento): Boolean = evento.precio <= precio
}