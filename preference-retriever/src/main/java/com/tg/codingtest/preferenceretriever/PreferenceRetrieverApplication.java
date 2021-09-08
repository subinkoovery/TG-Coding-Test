package com.tg.codingtest.preferenceretriever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PreferenceRetrieverApplication {

    public static void main(String[] args) {
        SpringApplication.run(PreferenceRetrieverApplication.class, args);
    }

}
