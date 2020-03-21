package com.perfecttravel.service

import com.perfecttravel.model.AirlineCompany
import com.perfecttravel.repository.AirlineCompanyRepository
import org.springframework.stereotype.Service

@Service
class AirlineCompanyService (private val airlineCompanyRepository: AirlineCompanyRepository) {

    fun getAllAirlines() : List<AirlineCompany> {
        return airlineCompanyRepository.findAll()
    }

    fun saveAirline(airlineCompany: AirlineCompany) : AirlineCompany {
        return airlineCompanyRepository.save(airlineCompany)
    }

}