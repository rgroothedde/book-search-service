package nl.groothedde

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import nl.groothedde.domain.BoekService
import nl.groothedde.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val booksService = BoekService()
    configureSerialization()
    configureMonitoring()
    configureRouting(booksService)
    configureExceptionHandling()

}
