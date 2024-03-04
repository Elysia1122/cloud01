package com.sx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sx.mapper")
public class OrderServer81Application {
    public static void main(String[] args) {
        SpringApplication.run(OrderServer81Application.class);
    }
}
