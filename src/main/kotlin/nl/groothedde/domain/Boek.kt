package nl.groothedde.domain

import kotlinx.serialization.Serializable
import nl.groothedde.serialization.FullDateNLSerializer
import java.time.temporal.Temporal

@Serializable
data class Boek(
    val titel: String,
    val auteurs: List<String> = emptyList(),
    val isbn: String? = null,
    @Serializable(with= FullDateNLSerializer::class)
    val publicatieDatum: Temporal? = null
)
