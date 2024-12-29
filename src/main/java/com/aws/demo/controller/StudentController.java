package com.aws.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StudentController {


    @GetMapping("/")
    public String helloAws()
    {
        return "Welcome to Spring boot with AWS with Bean Stalk with cicd pipeline....";
    }

    @GetMapping("/add")
    public String add(@PathVariable int number)
    {
        return String.valueOf(number*2);
    }
}
