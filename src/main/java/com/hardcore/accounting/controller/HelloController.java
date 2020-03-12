package com.hardcore.accounting.controller;

import com.hardcore.accounting.model.service.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    private AtomicLong counter = new AtomicLong();

    @GetMapping("v1/greeting")
    public Greeting sayHello(String name) {
        return new Greeting(counter.incrementAndGet(), String.format("Hello, %s", name));
    }
}
