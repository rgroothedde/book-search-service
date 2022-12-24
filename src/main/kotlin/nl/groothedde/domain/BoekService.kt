package nl.groothedde.domain

import nl.groothedde.apiclients.BookVolume
import nl.groothedde.apiclients.GoogleBooksApiClient

class BoekService(private val googleBooksApiClient: GoogleBooksApiClient = GoogleBooksApiClient()) {
    suspend fun findBoeken(query: String, language: String?): List<Boek> {
        return googleBooksApiClient.getBooks(query, language)
            .items.map { toBoek(it) }
    }

    private fun toBoek(bookVolume: BookVolume) =
        bookVolume.volumeInfo.let { volumeInfo ->
            Boek(
                titel = volumeInfo.title,
                auteurs = volumeInfo.authors ?: emptyList(),
                isbn = volumeInfo.industryIdentifiers?.find { it.type == "ISBN_13" }?.identifier,
                publicatieDatum = volumeInfo.publishedDate
            )
        }
}