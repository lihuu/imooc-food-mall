package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by lihu on 11/24/20.
 *
 * @author lihu
 * @date 11/24/20
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createDocket() {
        //Swagger配置
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createApiInfo()).select()
            .apis(RequestHandlerSelectors.basePackage("com.imooc.controller")).paths(PathSelectors.any()).build();
    }

    private ApiInfo createApiInfo() {
        return new ApiInfoBuilder().title("imooc mall 接口文档")
            .contact(new Contact("SilentStorm", "lihuu.top", "silentstorm@lihuu.top")).description("测试使用的接口文档")
            .version("1.0.1").build();
    }

}
