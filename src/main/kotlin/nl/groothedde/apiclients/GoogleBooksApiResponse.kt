package nl.groothedde.apiclients

import kotlinx.serialization.Serializable
import nl.groothedde.serialization.TemporalSerializer
import java.time.temporal.Temporal

@Serializable
data class BookVolumesResponse(val items: List<BookVolume>)

@Serializable
data class BookVolume(val volumeInfo: VolumeInfo)

@Serializable
data class VolumeInfo(
    val title: String,
    val authors: List<String>? = emptyList(),

    @Serializable(with = TemporalSerializer::class)
    val publishedDate: Temporal? = null,
    val industryIdentifiers: List<IndustryIdentifier>? = emptyList()
)

@Serializable
data class IndustryIdentifier(val type: String, val identifier: String)