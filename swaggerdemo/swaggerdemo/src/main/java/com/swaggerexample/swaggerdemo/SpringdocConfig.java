package com.swaggerexample.swaggerdemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;

import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

@OpenAPIDefinition
@Configuration
public class SpringdocConfig {

    @Bean
    public OpenAPI baseOpenAPI(){

        ApiResponse badRequestAPI = new ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples("default",
                                new Example().value("{ \"code\" : 400, \"Status\" : \"Bad Request!\", \"Message\": \"Bad Request\"}")))
        ).description("Bad Request!");

        ApiResponse internalServerErrorAPI = new ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples("default",
                                new Example().value("{ \"code\" : 500, \"Status\" : \"Internal Server Error!\", \"Message\": \"Internal Server Error\"}")))
        ).description("Internal Server Error!");

        Components components = new Components();
        components.addResponses("badRequestAPI", badRequestAPI);
        components.addResponses("internalServerErrorAPI",internalServerErrorAPI);

        return new OpenAPI().components(components).
                info(new Info().title("Contact API Specification").version("1.0.0").description("details"));
    }

}
