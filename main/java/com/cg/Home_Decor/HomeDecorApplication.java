package com.cg.Home_Decor;
/*
 * Application class to start the Project.
 * @author Thanusha
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.*;
import org.springframework.context.annotation.Bean;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.builders.ApiInfoBuilder;

@EnableSwagger2
@SpringBootApplication
public class HomeDecorApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeDecorApplication.class, args);
	}
	/*
	 * Docket method to execute swagger.
	 */
	@Bean
	public Docket postApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(metadata()).select().paths(regex("/api.*")).build();
	}
	
	/*
	 * ApiInfo method to build the description  
	 */
	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("# Online Home Decor Store #")
				.description("Suppliers and Categories operations are present").build();	
	}

}
