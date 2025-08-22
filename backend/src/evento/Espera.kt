package evento

import usuario.Usuario
import java.time.LocalDateTime
import kotlin.time.Duration
import kotlin.time.toKotlinDuration

data class Espera(
    val usuario: Usuario,
    val evento: Evento,
    val horaInicio: LocalDateTime
) {
    fun tiempoEsperando(): Duration {
        return java.time.Duration.between(this.horaInicio, LocalDateTime.now()).toKotlinDuration()
    }
}