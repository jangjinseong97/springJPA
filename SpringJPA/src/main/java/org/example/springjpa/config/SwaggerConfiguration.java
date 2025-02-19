package org.example.springjpa.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@OpenAPIDefinition(
        info = @Info(
                title = "${constants.swagger.info.title}"
                , description = "${constants.swagger.info.description}"
                , version = "${constants.swagger.info.version}"
        )
)

public class SwaggerConfiguration {
}
