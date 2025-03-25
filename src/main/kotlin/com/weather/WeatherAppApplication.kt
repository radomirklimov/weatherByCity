package com.weather

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
class WeatherAppApplication

fun main(args: Array<String>) {
	runApplication<WeatherAppApplication>(*args)
}
