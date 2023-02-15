package com.abdalmassih;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

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

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Request
     */
    record Request(
            Integer id,
            String name,
            String mail,
            Integer age) {
    }

    @PostMapping
    public void addCustomer(@RequestBody Request request) {
        Customer c = new Customer(request.age, request.name, request.mail);
        customerRepository.save(c);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Request request) {
        Customer c = customerRepository.findById(request.id).get();
        c.setName(request.name);
        c.setMail(request.mail);
        c.setAge(request.age);
        customerRepository.save(c);
    }
}
