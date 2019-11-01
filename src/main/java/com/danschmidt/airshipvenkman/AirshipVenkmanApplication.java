package com.danschmidt.airshipvenkman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirshipVenkmanApplication {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Shutdown Hook in effect!")));
        SpringApplication.run(AirshipVenkmanApplication.class, args);
    }

}
