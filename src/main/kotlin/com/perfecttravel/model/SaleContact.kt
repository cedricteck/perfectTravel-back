package com.perfecttravel.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class SaleContact (

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    var id: Long? = null,

    var firstName: String = "",

    var lastName: String = "",

    var email: String = "",

    var phoneNumber: String = "",

    var visible: Boolean = true
)