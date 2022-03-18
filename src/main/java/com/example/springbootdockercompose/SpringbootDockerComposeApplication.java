package com.example.springbootdockercompose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootDockerComposeApplication {

    private final StringRedisTemplate stringRedisTemplate;

    public SpringbootDockerComposeApplication(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDockerComposeApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        Long views = stringRedisTemplate.opsForValue().increment("views");
        return "hello welcome SpringBoot, views: " + views;
    }
}
