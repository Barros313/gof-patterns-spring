package com.barros.gofpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GofPatternsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GofPatternsApplication.class, args);
    }

}
