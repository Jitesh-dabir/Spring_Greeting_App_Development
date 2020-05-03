package com.bridgelabz.springgreetingapi.controller;

import com.bridgelabz.springgreetingapi.dto.Greeting;
import com.bridgelabz.springgreetingapi.dto.UserDTO;
import com.bridgelabz.springgreetingapi.service.GreetingServiceImpl;
import com.bridgelabz.springgreetingapi.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingServiceImpl GreetingService;

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
    public Greeting greetingWithRequestBodyUserName(@RequestBody UserDTO user) {
        String template = "Hello, %s %s!";
        return new Greeting(counter.incrementAndGet(), String.format(template, user.getFirstName(), user.getLastName()));
    }

    @PutMapping("/put/{firstName}")
    public Greeting greetingPathVariableAndRequestParam(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        String template = "Hello, %s %s!";
        return new Greeting(counter.incrementAndGet(), String.format(template, firstName, lastName));
    }

    @PostMapping("/getGreeting")
    public UserDTO register(@RequestBody UserDTO userDTO) {
        return GreetingService.greet(userDTO);
    }
}