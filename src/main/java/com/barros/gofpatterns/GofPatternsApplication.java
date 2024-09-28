package com.barros.gofpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GofPatternsApplication {

    /**
     * Projeto Spring Boot gerado via IntelliJ Ultimate
     * Módulos selecionados:
     * <ul>
     *   <li>Spring Data JPA</li>
     *   <li>Spring Web</li>
     *   <li>H2 Database</li>
     *   <li>OpenFeign</li>
     *   <li>JDBC API</li>
     * </ul>
     *
     * JDBC e Postgres serão utilizados posteriormente
     */
    public static void main(String[] args) {
        SpringApplication.run(GofPatternsApplication.class, args);
    }

}
