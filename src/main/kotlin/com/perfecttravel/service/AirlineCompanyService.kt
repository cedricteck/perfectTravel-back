package com.perfecttravel.service

import com.perfecttravel.model.AirlineCompany
import com.perfecttravel.repository.AirlineCompanyRepository
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class AirlineCompanyService (private val airlineCompanyRepository: AirlineCompanyRepository) {

    fun getAllAirlines() : List<AirlineCompany> {
        return airlineCompanyRepository.findAll()
    }

    fun saveAirline(airlineCompany: AirlineCompany) : AirlineCompany {
        airlineCompany.cancellationPolicy?.lastUpdatedDate = Instant.now()
        return airlineCompanyRepository.save(airlineCompany)
    }

    fun saveAll(airlineCompanies: List<AirlineCompany>): List<AirlineCompany> {
        return airlineCompanyRepository.saveAll(airlineCompanies)
    }

}
