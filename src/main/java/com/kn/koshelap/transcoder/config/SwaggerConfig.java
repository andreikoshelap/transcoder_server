package com.kn.koshelap.transcoder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kn.koshelap.transcoder.controller.CapitalController;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CapitalController.class.getPackage().getName()))
                .build();
    }
}
