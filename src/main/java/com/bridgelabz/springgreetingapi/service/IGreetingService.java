package com.bridgelabz.springgreetingapi.service;

import com.bridgelabz.springgreetingapi.dto.UserDTO;
import org.springframework.stereotype.Service;


public interface IGreetingService {
    public UserDTO greet(UserDTO userDTO);
}
