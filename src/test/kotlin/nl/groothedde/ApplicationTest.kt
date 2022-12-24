package nl.groothedde

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import nl.groothedde.domain.BoekService
import nl.groothedde.plugins.configureRouting
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
//    @Test
//    fun testRoot() = testApplication {
//        val boekService = BoekService()
//        application {
//            configureRouting(boekService)
//        }
//        client.get("/").apply {
//            assertEquals(HttpStatusCode.OK, status)
//            assertEquals("Hello World!", bodyAsText())
//        }
//    }
}