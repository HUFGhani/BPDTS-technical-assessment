package io.github.hufghani.bpdts;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RouterFunctions.route;
import static springfox.documentation.builders.PathSelectors.regex;

import java.net.URI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("io.github.hufghani.bpdts.controller"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(metaData());
  }

  private ApiInfo metaData() {
    ApiInfo apiInfo = new ApiInfo(
        "BPDTS-technical-assessment",
        "BPDTS-technical-assessment",
        "1.0",
        "Terms of service",
        new Contact("Hamza Umar Farooq Ghani", "https://hufghani.github.io", "h.u.f.ghani@gmail.com"),
        "Apache License Version 2.0",
        "https://www.apache.org/licenses/LICENSE-2.0");
    return apiInfo;
  }

  @Bean
  RouterFunction<ServerResponse> routerFunction() {
    return route(GET("/"), req ->
        ServerResponse.temporaryRedirect(URI.create("swagger-ui.html")).build());
  }
}
