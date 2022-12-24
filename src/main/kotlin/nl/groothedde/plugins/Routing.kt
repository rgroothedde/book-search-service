package nl.groothedde.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import nl.groothedde.domain.BoekService

fun Application.configureRouting(booksService: BoekService) {

    routing {
        get("/boeken") {
            val query = call.parameters["tekst"] ?: throw BadRequestException("Tekst zoek parameter is verplicht")

            call.respond(
                booksService.findBoeken(
                    query = query,
                    language = call.parameters["taal"]
                )
            )
        }
    }
}

