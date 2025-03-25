package com.weather

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = arrayOf("*"))
class Controller(
    private val service: Service
) {

    @GetMapping("{city}")
    fun postCity(@PathVariable city: String): ResponseEntity<Any> {
        val response = service.weatherResponse(city)

        if (response != null) {
            return ResponseEntity.ok(response)
        }
        return ResponseEntity.badRequest().body("no such city found")
    }
}
