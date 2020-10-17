package com.sistematizando.consulta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @author Cristian Camilo Beltrán <ccamilo2303@gmail.com>
 * @since  17 oct. 2020
 */
@Configuration 
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(
						RequestHandlerSelectors
						.basePackage("com.sistematizando.consulta"))
				.paths(PathSelectors.any())
				.build();
	}
}