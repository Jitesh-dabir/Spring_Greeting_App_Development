package com.bridgelabz.springgreetingapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingServiceImpl service;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greetings")
    public Greeting greetingWithDefaultMessage(@RequestParam(defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public Greeting greetingWithUserName(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping(value = {"/param/{name}"})
    public Greeting greetingWithPathVariableUserName(@PathVariable(value = "name") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/post")
    public Greeting greetingWithRequestBodyUserName(@RequestBody Person person) {
        String template = "Hello, %s %s!";
        return new Greeting(counter.incrementAndGet(), String.format(template, person.getFirstName(), person.getLastName()));
    }

    @PutMapping("/put/{firstName}")
    public Greeting greetingPathVariableAndRequestParam(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        String template = "Hello, %s %s!";
        return new Greeting(counter.incrementAndGet(), String.format(template, firstName, lastName));
    }

    @RequestMapping(value = {"/getGreeting"}, method = RequestMethod.GET)
    public String getGreeting(@RequestParam(value = "firstName", required = false) String firstName,@RequestParam(value = "lastName", required = false) String lastName) {
        return service.greet(firstName,lastName);
    }
}