package com.lab.house.core.configuration

import com.google.common.base.Predicate
import com.google.common.base.Predicates
import io.swagger.annotations.Api
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.RequestHandler
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    @Bean
    fun courseApi(): Docket = Docket(DocumentationType.SWAGGER_2)
            .groupName("houseAPIv1")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.lab.house"))
            .apis(apiPredicates())
            .build()

    private fun apiPredicates(): Predicate<RequestHandler> =
            Predicates.or(
                    RequestHandlerSelectors.withClassAnnotation(RestController::class.java),
                    RequestHandlerSelectors.withClassAnnotation(Api::class.java)
            )
}
