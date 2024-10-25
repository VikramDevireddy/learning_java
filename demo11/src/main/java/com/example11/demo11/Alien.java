package com.example11.demo11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Autowired
    Laptop lappy;

    public void code() {
        lappy.compile();
        System.out.println("this is another class");
    }
}
