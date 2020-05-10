package com.perfecttravel

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import com.perfecttravel.model.AirlineCompany
import com.perfecttravel.service.AirlineCompanyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.core.io.ClassPathResource
import javax.annotation.PostConstruct

@SpringBootApplication
open class PerfectTravelApplication: SpringBootServletInitializer() {

    private val csvMapper: CsvMapper = CsvMapper()
    private val bootstrapSchema: CsvSchema = CsvSchema.emptySchema().withHeader().withColumnSeparator(';').withComments()

    @Autowired
    private lateinit var airlineCompanyService: AirlineCompanyService

    @Value("\${perfecttravel.provisioning.file:airlines.csv}")
    var provisioningFile: String = ""

    @PostConstruct
    fun provisioning() {

        val basePackage = "provisioning/"
        if (airlineCompanyService.getAllAirlines().isEmpty()) {
            airlineCompanyService.saveAll(csvMapper.readerFor(AirlineCompany::class.java).with(bootstrapSchema)
                    .readValues<AirlineCompany>(ClassPathResource(basePackage + this.provisioningFile).url)
                    .readAll())
        }
    }

}

fun main(args: Array<String>) {
    runApplication<PerfectTravelApplication>(*args)
}
