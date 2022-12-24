package nl.groothedde.serialization

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test
import java.time.LocalDate
import java.time.YearMonth
import java.time.temporal.Temporal
import kotlin.test.assertEquals


class PartialDateSerializerTest {

    @Serializable
    data class TemporalWrapper(@Serializable(with = PartialDateSerializer::class) val date: Temporal)

    @Test
    fun `String with only month and year becomes YearMonth`() {
        assertEquals(
            YearMonth.of(2022, 2),
            Json.decodeFromString<TemporalWrapper>("{\"date\":\"2022-02\"}").date
        )
    }

    @Test
    fun `String with day, month and year becomes LocalDate`() {
        assertEquals(
            LocalDate.of(2022, 2, 2),
            Json.decodeFromString<TemporalWrapper>("{\"date\":\"2022-02-02\"}").date
        )
    }
}