package nl.groothedde.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.configureExceptionHandling(){
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            logError(call, cause)
            if(cause is BadRequestException) {
                call.respondText(text = "Ongeldig request: ${cause.message}" , status = HttpStatusCode.BadRequest)
            } else {
                call.respondText(text = "Interne server error" , status = HttpStatusCode.InternalServerError)
            }
        }
    }
}