package com.perfecttravel.model

import javax.persistence.*

@Entity
data class AirlineCompany (

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        var id: Long? = null,

        var ltaPrefix: String = "",

        var oaciCode: String = "",

        var iataCode: String = "",

        var name: String = "",

        @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        var cancellationPolicy: CancellationPolicy? = null,

        @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        var saleContact: SaleContact? = null
)
