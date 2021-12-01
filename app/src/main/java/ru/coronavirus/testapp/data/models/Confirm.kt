package ru.coronavirus.testapp.data.models

import androidx.room.*
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
@Entity
data class Confirm(
    //назвал так просто чтоб путаницы небыло в связях базы данных
    @SerialName("Country") val countryConfirmed: String,
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

    @PrimaryKey
    var dbKey: Int = 0
}

data class ConfirmsDBWrapper(
    @Embedded
    val country: Countries.Country,
    @Relation(
        parentColumn = "country",
        entityColumn = "countryConfirmed"
    )
    val confirms: List<Confirm>
)