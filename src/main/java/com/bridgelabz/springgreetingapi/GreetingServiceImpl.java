package com.bridgelabz.springgreetingapi;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements IGreetingService {

    private static final String template = "Hello world!";

    public String greet(String name) {
        return template;
    }
}
