package com.example.demo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfiguration
@SpringBootApplication
public class DubbodemoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubbodemoServerApplication.class, args);
    }
}
