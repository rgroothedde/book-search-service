package nl.groothedde.serialization

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test
import java.time.LocalDate
import java.time.YearMonth
import java.time.temporal.Temporal
import kotlin.test.assertEquals


class FullDateNlSerializerTest {

    @Serializable
    data class TemporalWrapper(@Serializable(with = FullDateNLSerializer::class) val date: Temporal)

    @Test
    fun `LocalDate to String`() {
        assertEquals("{\"date\":\"17 augustus 2021\"}",
            Json.encodeToString(TemporalWrapper(LocalDate.of(2021, 8, 17))))
    }

    @Test
    fun `YearMonth to String`() {
        assertEquals("{\"date\":\"augustus 2021\"}",
            Json.encodeToString(TemporalWrapper(YearMonth.of(2021, 8))))
    }
}