package com.perfecttravel.model

import java.time.Instant
import javax.persistence.*

@Entity
data class CancellationPolicy (

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        var id: Long? = null,

        @Enumerated(EnumType.STRING)
        var flightStatus: FlightStatus? = FlightStatus.CONFIRMED,

        var until: Instant? = null,

        var lastUpdatedDate: Instant? = Instant.now(),

        @Column(columnDefinition = "TEXT")
        var generalInfo: String = "",

        @Column(columnDefinition = "TEXT")
        var conditions: String = ""

)
