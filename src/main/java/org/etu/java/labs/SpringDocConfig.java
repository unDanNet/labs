package org.etu.java.labs;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI applicationOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Intelligent Parking Systems Application API")
                .description("Intelligent Parking Systems management service")
                .version("v0.0.1-SNAPSHOT")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"))
            );
    }

    @Bean
    public OpenApiCustomizer addHeaderParamsOpenAPICustomizer() {
        return openApi -> {
            var operations = openApi.getPaths().values().stream().flatMap(
                pathItem -> pathItem.readOperations().stream()
            );

            operations.forEach(op -> {
                var headerParam = new HeaderParameter();

                headerParam.setName(HttpHeaders.ACCEPT_LANGUAGE);
                headerParam.setRequired(false);
                headerParam.setAllowEmptyValue(false);
                headerParam.setExample("ru");

                op.addParametersItem(headerParam);
            });
        };
    }
}
