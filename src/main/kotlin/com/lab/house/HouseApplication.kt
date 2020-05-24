package com.lab.house

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.transaction.PlatformTransactionManager
import springfox.documentation.swagger2.annotations.EnableSwagger2
import javax.persistence.EntityManagerFactory

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = ["com.lab.*"])
@EnableSwagger2
@EnableScheduling
class HouseApplication {

	@Bean
	fun transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
		return JpaTransactionManager(entityManagerFactory)
	}

}

fun main(args: Array<String>) {
	runApplication<HouseApplication>(*args)
}
