package nl.groothedde.apiclients

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

/**
 * HttpClientEngine parameter can be used for testing with the MockEngine of Ktor,
 * see [https://ktor.io/docs/http-client-testing.html]
 */
class GoogleBooksApiClient(engine: HttpClientEngine = HttpClient().engine) {
    private val httpClient: HttpClient = HttpClient(engine) {
        expectSuccess = true
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
        install(Logging)
        install(HttpRequestRetry) {
            retryOnServerErrors(maxRetries = 3)
            exponentialDelay()
        }

    }

    suspend fun getBooks(query: String, language: String?): BookVolumesResponse =
        httpClient.get("https://books.googleapis.com/books/v1/volumes") {
            url {
                parameters.append("orderBy", "newest")
                parameters.append("maxResults", "10")
                parameters.append("q", query)
                if (!language.isNullOrBlank()) parameters.append("langRestrict", language)
            }
            accept(ContentType.Application.Json)
        }.body()


}

