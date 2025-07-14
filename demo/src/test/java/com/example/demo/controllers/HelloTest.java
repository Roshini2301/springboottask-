package com.example.demo.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {
    @Test
    public void tesHelloTest(){
        Hello heaven = new Hello();
        String str = heaven.helloTest();
        System.out.println(str);
        assertEquals("Hello Test",str);

    }
}
