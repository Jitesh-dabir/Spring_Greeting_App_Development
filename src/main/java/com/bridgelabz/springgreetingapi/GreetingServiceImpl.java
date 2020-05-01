package com.bridgelabz.springgreetingapi;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements IGreetingService {

    private static final String template = "Hello world!";

    public String greet(String firstName, String lastName) {
        if (firstName == null && lastName == null)
            return template;
        else if (lastName == null)
            return template.replace("world", firstName);
        else if (firstName == null)
            return template.replace("world", lastName);
        return template.replace("world", firstName + " " + lastName);

    }
}
