package com.rest.example.service.impl;

import com.rest.example.entity.User;
import com.rest.example.exception.UserNotFoundException;
import com.rest.example.repository.UserRepository;
import com.rest.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            String logMessage = "User not found for the given id: " + id;
            log.error(logMessage);
            throw new UserNotFoundException(logMessage);
        }
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
