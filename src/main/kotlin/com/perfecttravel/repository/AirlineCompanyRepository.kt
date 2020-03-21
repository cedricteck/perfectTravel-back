package com.perfecttravel.repository

import com.perfecttravel.model.AirlineCompany
import org.springframework.data.jpa.repository.JpaRepository

interface AirlineCompanyRepository : JpaRepository<AirlineCompany, Long>