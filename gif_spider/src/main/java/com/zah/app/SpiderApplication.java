package com.zah.app;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableAutoConfiguration
@Configurable
@ComponentScan(basePackages = {"com.zah.app"})
@Controller
public class SpiderApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(SpiderApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpiderApplication.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
