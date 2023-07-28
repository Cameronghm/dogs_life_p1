package com.example.superheroes.practice;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public int addition(int num1, int num2) {
        return num1 + num2;
    }

    @PostConstruct
    public void init() {
        System.out.println("Calculator has been created!!!");

    }

    @PreDestroy
    public void destroy() {
        System.out.println("Calculator will be destroyed");
    }

}
