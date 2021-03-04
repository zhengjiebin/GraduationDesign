package com.zheng.blogserver.exception;

import io.swagger.annotations.Api;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return (factory) -> factory.addErrorPages(
                new ErrorPage(HttpStatus.NOT_FOUND,"/404"),
                new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500")
        );
    }

}
