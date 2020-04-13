package com.perfecttravel.controller

import com.perfecttravel.model.AirlineCompany
import com.perfecttravel.service.AirlineCompanyService
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin
class AirlineCompanyController(private val airlineCompanyService: AirlineCompanyService) {

    @GetMapping("/airlines")
    fun getAllAirlines() : List<AirlineCompany> {
        return airlineCompanyService.getAllAirlines()
    }

    @PostMapping("/airlines/{id}")
    fun saveAirlines(@PathVariable("id") id: Long, @RequestBody airlineCompany: AirlineCompany) : AirlineCompany {
        return airlineCompanyService.saveAirline(airlineCompany)
    }
}
