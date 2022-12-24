package nl.groothedde.serialization

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

/**
 * (De)serializes partial dates, for example dates with only month and year.
 * The following formats are supported: 2022, 2022-02, 2022-02-30
 */
object PartialDateSerializer : KSerializer<Temporal> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Temporal", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Temporal {
        val stringValue = decoder.decodeString()
        return try {
            LocalDate.parse(stringValue)
        } catch (e: Throwable){
            try { YearMonth.parse(stringValue)}
            catch(e:Throwable){
                Year.parse(stringValue)
            }
        }
    }

    override fun serialize(encoder: Encoder, value: Temporal) {
        encoder.encodeString(when (value){
            is LocalDate -> value.format(
                DateTimeFormatter.BASIC_ISO_DATE
            )
            is YearMonth -> value.format(DateTimeFormatter.BASIC_ISO_DATE)

            else -> {value.toString()}
        })
    }

}
