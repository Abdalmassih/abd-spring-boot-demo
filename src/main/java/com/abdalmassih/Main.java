package com.abdalmassih;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        return new GreetResponse(
                "Hi!",
                List.of("Ar", "En"),
                new Person("Sam"));
    }

    record Person(String name) {
    }

    record GreetResponse(
            String greet,
            List<String> langs,
            Person person) {
    }

    @GetMapping("/me")
    public String customerIndex() {

        Customer me = new Customer(1, 20, "Abd", "abd@gmail.com");

        return me.toString();
    }
}
