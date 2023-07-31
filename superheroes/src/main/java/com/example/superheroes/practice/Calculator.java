package com.example.superheroes.practice;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    @PostConstruct
    public void init()
    {
        System.out.println("Calculator has been created!");
    }
    @PreDestroy
    public void destroy()
    {
        System.out.println("Calculator will be destroyed");
    }
    public int addition(int x, int y)
    {
        return x+y;
    }
}
