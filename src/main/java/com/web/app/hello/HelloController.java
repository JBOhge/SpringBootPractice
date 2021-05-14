package com.web.app.hello;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {


    @GetMapping(path = "/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-bean")
    public HelloBean helloBean() {
        return new HelloBean("Hello World");
    }

    @GetMapping(path = "/hello-bean/{name}")
    public HelloBean helloBeanPath(@PathVariable String name) {
        return new HelloBean("Hello, " + name);
    }
}
