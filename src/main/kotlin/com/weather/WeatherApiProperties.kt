package com.weather

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestTemplate

@Configuration
@ConfigurationProperties(prefix = "openweather.api")
class WeatherApiProperties {
    var key: String = ""
    var url: String = ""

    fun response(city: String): WeatherResponse? {
        val url = String.format(
            "%s?q=%s&appid=%s&units=metric",
            url,
            city,
            key
        )

        val restTemplate = RestTemplate()

        return try {
            restTemplate.getForObject(url, WeatherResponse::class.java)
        }catch (e: HttpClientErrorException){
            null
        }
    }
}