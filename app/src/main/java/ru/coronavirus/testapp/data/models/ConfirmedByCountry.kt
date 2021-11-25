package ru.coronavirus.testapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import java.util.*

@Serializable
@Entity
data class ConfirmedByCountry(
    @SerialName("Country") val country: String,
    @SerialName("CountryCode") val countryCode: String,
    @SerialName("Province") val province: String,
    @SerialName("City") val city: String,
    @SerialName("CityCode") val cityCode: String,
    @SerialName("Cases") val cases: Int,
    @SerialName("Status") val status: String,
    @SerialName("Date")
    @Contextual
    val date: Date,
) {

    @Transient
    @PrimaryKey(autoGenerate = true)
    var dbKey = 0
}