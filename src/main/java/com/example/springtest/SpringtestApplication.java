package com.example.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application entry point.
 *
 * <p>{@code @SpringBootApplication} is a convenience annotation that combines:
 * <ul>
 *   <li>{@code @Configuration}     – marks this class as a source of bean definitions</li>
 *   <li>{@code @EnableAutoConfiguration} – enables Spring Boot auto-configuration</li>
 *   <li>{@code @ComponentScan}     – scans this package and sub-packages for components</li>
 * </ul>
 */
@SpringBootApplication
public class SpringtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringtestApplication.class, args);
    }
}
