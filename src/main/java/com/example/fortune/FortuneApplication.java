package com.example.fortune;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@RestController
public class FortuneApplication {
    private static String[] fortunes;

    public static void main(String[] args) {
        fortunes = FortuneService.loadFortunes();

        SpringApplication.run(FortuneApplication.class, args);
    }

    @RequestMapping("/")
    public String writeFortune(){

        return FortuneService.randomFortune(fortunes);
    }
}
