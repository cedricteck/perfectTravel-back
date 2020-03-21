package com.perfecttravel.repository

import com.perfecttravel.model.CancellationPolicy
import org.springframework.data.jpa.repository.JpaRepository

interface CancellationPolicyRepository : JpaRepository<CancellationPolicy, Long>