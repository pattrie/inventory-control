package br.com.mba.inventorycontrol.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
class SpringFoxConfig {

  @Value("${swagger.base-path:/}")
  private String basePath;

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(getApiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("br.com.mba"))
        .paths(PathSelectors.any())
        .build()
        .pathMapping(basePath);
  }

  private ApiInfo getApiInfo() {
    return new ApiInfoBuilder()
        .title("API Inventory Control")
        .description("API Inventory Control")
        .version("1.0.0")
        .build();
  }
}
