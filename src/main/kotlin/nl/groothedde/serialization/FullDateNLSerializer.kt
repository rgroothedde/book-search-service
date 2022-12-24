package nl.groothedde.serialization

import jdk.jshell.spi.ExecutionControl.NotImplementedException
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDate
import java.time.Year
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal
import java.util.*

object FullDateNLSerializer : KSerializer<Temporal> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Temporal", PrimitiveKind.STRING)
    private val localeNL = Locale("nl", "NL")
    //Not used
    override fun deserialize(decoder: Decoder): Temporal {
        throw NotImplementedException("Deserialization of NL Full Date not implemented yet")
    }
    override fun serialize(encoder: Encoder, value: Temporal) {
        encoder.encodeString(when (value){
            is LocalDate -> value.format(
                DateTimeFormatter.ofPattern("d MMMM yyyy", localeNL )
            )
            is YearMonth -> value.format(DateTimeFormatter.ofPattern("MMMM yyyy", localeNL))
            is Year -> value.format(DateTimeFormatter.ofPattern("yyyy"))
            else -> {value.toString()}
        })
    }

}
