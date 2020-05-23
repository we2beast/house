package com.lab.house

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = ["com.lab.*"])
@EnableSwagger2
class HouseApplication

fun main(args: Array<String>) {
	runApplication<HouseApplication>(*args)
}
