package com.example.springboot_02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SpringBoot02Application {

    public static void main(String[] args) {
        //spring容器  ConfigurableApplicationContext
        ConfigurableApplicationContext run = SpringApplication.run(SpringBoot02Application.class, args);


    }

}
