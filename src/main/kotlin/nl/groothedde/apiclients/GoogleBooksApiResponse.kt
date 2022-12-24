package nl.groothedde.apiclients

import kotlinx.serialization.Serializable
import nl.groothedde.serialization.PartialDateSerializer
import java.time.temporal.Temporal

@Serializable
data class BookVolumesResponse(val items: List<BookVolume>? = emptyList())

@Serializable
data class BookVolume(val volumeInfo: VolumeInfo)

@Serializable
data class VolumeInfo(
    val title: String,
    val authors: List<String>? = emptyList(),

    @Serializable(with = PartialDateSerializer::class)
    val publishedDate: Temporal? = null,
    val industryIdentifiers: List<IndustryIdentifier>? = emptyList()
)

@Serializable
data class IndustryIdentifier(val type: String, val identifier: String)