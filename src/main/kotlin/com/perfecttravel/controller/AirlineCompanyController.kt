package com.perfecttravel.controller

import com.perfecttravel.model.AirlineCompany
import com.perfecttravel.service.AirlineCompanyService
import org.slf4j.LoggerFactory
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.MalformedURLException
import java.nio.file.Paths
import javax.servlet.http.HttpServletRequest


@RestController
@CrossOrigin
class AirlineCompanyController(private val airlineCompanyService: AirlineCompanyService) {

    val logger = LoggerFactory.getLogger(AirlineCompanyController::class.java)

    @GetMapping("/airlines")
    fun getAllAirlines() : List<AirlineCompany> {
        return airlineCompanyService.getAllAirlines()
    }

    @PostMapping("/airlines/{id}")
    fun saveAirlines(@PathVariable("id") id: Long, @RequestBody airlineCompany: AirlineCompany) : AirlineCompany {
        return airlineCompanyService.saveAirline(airlineCompany)
    }

    @GetMapping("/download")
    @ResponseBody
    fun download(@RequestParam("token") token: String, request: HttpServletRequest): ResponseEntity<Any> {
        if (token == "cedric") {
            val path = Paths.get("C:\\Users\\cedri\\Downloads\\Hello-SoundBible.com-1812488315.mp3")
            logger.info(request.headerNames.toList().joinToString())
            var resource: Resource? = null
            try {
                resource = UrlResource(path.toUri())
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            }
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"file.mp3\"")
                    .body(resource)
        } else {
            return ResponseEntity.badRequest().body("Bad Token")
        }
    }
}
