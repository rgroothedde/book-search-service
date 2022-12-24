package nl.groothedde.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import nl.groothedde.domain.BoekService

fun Application.configureRouting(boekService: BoekService) {

    routing {
        get("/boeken") {
            val query = call.parameters["zoektekst"] ?: throw BadRequestException("zoektekst parameter is verplicht")

            call.respond(
                boekService.findBoeken(
                    query = query,
                    language = call.parameters["taal"]
                )
            )
        }
    }
}

