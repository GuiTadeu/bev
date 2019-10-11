package br.com.bev.config;

import br.com.bev.model.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

/**
 * Classe criada para geração da documentação do Swagger.
 *
 * @author Guilherme Tadeu
 * @version 1.0.0
 * @
 */

@Configuration
public class SwaggerConfig {
    /**
     * Método criado para especificar o pacote de controllers
     * que será utilizado para geração da documentação.
     *
     * @see SwaggerConfig#apiInfo()
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.bev.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .ignoredParameterTypes(Usuario.class)
                .globalOperationParameters(
                        Arrays.asList(
                                new ParameterBuilder()
                                        .name("Authorization")
                                        .description("Authorization Bearer")
                                        .modelRef(new ModelRef("string"))
                                        .parameterType("header")
                                        .required(false)
                                        .build()
                        )
                );
    }

    /**
     * Método criado para gerar o cabeçalho de informações
     * da documentação.
     *
     * @return ApiInfo
     * @see Contact
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Bate & Volta",
                "Projeto AM - FIAP",
                "1.0.0",
                null,
                new Contact("Guilherme Tadeu", "https://github.com/GuiTadeu", "guitadeu.py@gmail.com"), null, null, Collections.emptyList());
    }
}
