package evento

import usuario.Usuario
import java.time.LocalDateTime
import kotlin.time.Duration

data class Inscripcion(
    val usuario: Usuario,
    val evento: Evento,
    val horaInscripcion: LocalDateTime,
    val espera: Duration?,
) {
}