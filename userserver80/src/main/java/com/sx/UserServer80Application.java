package com.sx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sx.mapper")
public class UserServer80Application {
    public static void main(String[] args) {
        SpringApplication.run(UserServer80Application.class);
    }
}
