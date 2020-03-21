package com.perfecttravel.repository

import com.perfecttravel.model.SaleContact
import org.springframework.data.jpa.repository.JpaRepository

interface SaleContactRepository : JpaRepository<SaleContact, Long>