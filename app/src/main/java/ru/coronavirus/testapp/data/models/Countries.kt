package ru.coronavirus.testapp.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

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
        @SerialName("Date") val date: String,
    ) : Parcelable {

        @IgnoredOnParcel
        @Transient
        @PrimaryKey(autoGenerate = true)
        var dbKey = 0
    }
}
