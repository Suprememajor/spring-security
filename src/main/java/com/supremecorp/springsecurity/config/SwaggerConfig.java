package com.supremecorp.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by suprememajor on the 9/12/21
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.supremecorp.springsecurity")).paths(regex("/api/v1/students.*")).build();
    }
}
