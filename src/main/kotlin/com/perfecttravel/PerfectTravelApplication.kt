package com.perfecttravel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class PerfectTravelApplication

fun main(args: Array<String>) {
    runApplication<PerfectTravelApplication>(*args)
}