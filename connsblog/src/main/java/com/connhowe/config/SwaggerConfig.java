package com.connhowe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration // 声明配置类
@EnableSwagger2 // 开启Swagger2
public class SwaggerConfig {

    // 配置Swagger的Docket的bean实例
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 配置Swagger页面
                .apiInfo(apiInfo())
                .groupName("Conn");
                // enable是否启动Swagger，如果为false，则Swagger不能在浏览器中访问
//                .enable(false)
//                .select()
//                // 扫描设置
//                .apis(RequestHandlerSelectors.basePackage("com.connhowe.controller"))
//                // 过滤路径
////                .paths()
//                .build();
    }

    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("Conn", "http://connhowe.com", "connhowe@163.com");
        return new ApiInfo(
                "Conn's Swagger API Documents",
                "爱一个人，攀一座山，追一个梦。",
                "v1.0",
                "http://connhowe.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
