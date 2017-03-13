package gov.uscis.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * <p>Configures the automatic generation of Swagger v2 API documentation for all endpoint exposed by this application.</p>
 * 
 * <p>This configuration exposes the following API documentation endpoints:</p>
 * <ul>
 * 	<li>Swagger UI - /swagger-ui.html</li>
 * 	<li>Swagger API JSON - /v2/api-docs</li>
 * </ul>
 * 
 * @author Jason Luck
 *
 */
@Configuration
@EnableSwagger2
public class DocumentationConfig {

	/**
	 * Configure the swagger documentation generation
	 * @return
	 */
	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.any())
			.build();
	}
}
