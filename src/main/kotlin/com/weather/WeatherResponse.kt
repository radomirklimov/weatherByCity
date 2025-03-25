package com.weather

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javax.swing.Icon

@JsonIgnoreProperties(ignoreUnknown = true)
data class WeatherResponse(
    @JsonProperty("main")
    val main: Main?,
    @JsonProperty("name")
    val city: String?,
    @JsonProperty("weather")
    val weather: List<Weather>?,
    @JsonProperty("wind")
    val wind: Wind?,
    @JsonProperty("sys")
    val sys: Sys?,
    @JsonProperty("coord")
    val coord: Coord?
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Main(
        @JsonProperty("temp")
        val temp: Double?,
        @JsonProperty("pressure")
        val pressure: Int?,
        @JsonProperty("feels_like")
        val feelsLike: Double?,
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Weather(
        @JsonProperty("main")
        val main: String?,
        @JsonProperty("description")
        val description: String?,
        @JsonProperty("icon")
        val icon: String?
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Wind(
        @JsonProperty("speed")
        val speed: Double?,
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Sys(
        @JsonProperty("country")
        val country: String?,
        @JsonProperty("sunrise")
        val sunrise: Int?,
        @JsonProperty("sunset")
        val sunset: Int?,
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Coord(
        @JsonProperty("lon")
        val lon: Double,
        @JsonProperty("lat")
        val lat: Double,
    )

    val weatherMain: String? get() = weather?.firstOrNull()?.main
    val weatherDescription: String? get() = weather?.firstOrNull()?.description
    val weatherIcon: String? get() = weather?.firstOrNull()?.icon
}