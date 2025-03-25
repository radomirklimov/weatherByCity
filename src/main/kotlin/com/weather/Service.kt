package com.weather

import org.springframework.stereotype.Service


@Service
class Service(
    private var weatherApiProperties: WeatherApiProperties,
) {

    fun weatherResponse(city: String): WeatherResponse? {
        return weatherApiProperties.response(city)
    }
}