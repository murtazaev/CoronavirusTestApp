package ru.coronavirus.testapp.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.text.ParseException
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

@Serializable
data class Countries(@SerialName("Countries") val countries: List<Country>) {

    @Serializable
    @Entity
    @Parcelize
    data class Country(
        @SerialName("Country") val country: String,
        @SerialName("CountryCode") val countryCode: String,
        @SerialName("Slug") val slug: String,
        @SerialName("NewConfirmed") val newConfirmed: Int,
        @SerialName("TotalConfirmed") val totalConfirmed: Int,
        @SerialName("NewDeaths") val newDeath: Int,
        @SerialName("TotalDeaths") val totalDeath: Int,
        @SerialName("NewRecovered") val newRecovered: Int,
        @SerialName("TotalRecovered") val totalRecovered: Int,
        @SerialName("Date")
        @Contextual
        val date: Date,
    ) : Parcelable {

        @IgnoredOnParcel
        @Transient
        @PrimaryKey(autoGenerate = true)
        var dbKey = 0
    }
}

class DateSerializer : KSerializer<Date> {
    //в списке и в деталях даты приходят в разном формате почемуто
    private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'", Locale.getDefault())
    private val simpleDateFormat2 = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.getDefault())

    override val descriptor = PrimitiveSerialDescriptor("Date", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: Date) = encoder.encodeLong(value.time)
    override fun deserialize(decoder: Decoder): Date {
        val decodedStr = decoder.decodeString()
        val date = try {
            simpleDateFormat.parse(decodedStr)
        } catch (e: ParseException) {
            simpleDateFormat2.parse(decodedStr)
        }
        return date ?: Date()
    }
}

object DateTypeConverter {
    @TypeConverter
    fun fromTimestamp(value: Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long {
        return date?.time ?: 0
    }
}
