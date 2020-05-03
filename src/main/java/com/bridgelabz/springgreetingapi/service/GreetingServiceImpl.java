package com.bridgelabz.springgreetingapi.service;

import com.bridgelabz.springgreetingapi.dto.UserDTO;
import com.bridgelabz.springgreetingapi.model.User;
import com.bridgelabz.springgreetingapi.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingServiceImpl implements IGreetingService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    private static final String template = "Hello world!";

    @Override
    public UserDTO greet(UserDTO userDTO) {
        if (userDTO.getFirstName() == null && userDTO.getLastName() == null)
            userDTO.setUserGreeting(template);
        else if (userDTO.getLastName() == null)
            userDTO.setUserGreeting(template.replace("world", userDTO.getFirstName()));
        else if (userDTO.getFirstName() == null)
            userDTO.setUserGreeting(template.replace("world", userDTO.getLastName()));
        userDTO.setUserGreeting(template.replace("world", userDTO.getFirstName() + " " + userDTO.getLastName()));
        User regUser = modelMapper.map(userDTO, User.class);
        userRepository.save(regUser);
        userDTO.setId(regUser.getId());
        return userDTO;
    }


    @Override
    public Optional<User> findGreetingById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllGreeting() {
        return userRepository.findAll();
    }
}
