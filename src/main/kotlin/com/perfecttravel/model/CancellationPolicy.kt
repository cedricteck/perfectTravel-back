package com.perfecttravel.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class CancellationPolicy (

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        var id: Long? = null,

        var flightStatus: FlightStatus = FlightStatus.CONFIRMED,

        var until: LocalDateTime? = null,

        var lastUpdatedDate: LocalDateTime = LocalDateTime.now(),

        @Column(columnDefinition = "TEXT")
        var generalInfo: String = "",

        @Column(columnDefinition = "TEXT")
        var conditions: String = ""

)