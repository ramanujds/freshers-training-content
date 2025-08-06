package com.mynotes.helloworld.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @GetMapping
    public String greet(){
        return "Hello everyone";
    }

}
