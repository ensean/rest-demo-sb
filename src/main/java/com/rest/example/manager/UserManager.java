package com.rest.example.manager;

import com.rest.example.dto.UserDTO;
import com.rest.example.entity.User;
import com.rest.example.mapper.UserDataMapper;
import com.rest.example.service.UserService;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Random;

@Component
public class UserManager {

    private final UserService userService;
    private final UserDataMapper userDataMapper;

    public UserManager(UserService userService, UserDataMapper userDataMapper) {
        this.userService = userService;
        this.userDataMapper = userDataMapper;
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        Random rand = new Random();

        // Obtain a number between [0 - 49].
        int n = rand.nextInt(50);
        try {
            Thread.sleep(n * 1000); // sleep 0 - 49s
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return userDataMapper.mapToUserDTOList(users);
    }

    public UserDTO getUserById(Long id) {
        User user = userService.getUserById(id);
        return userDataMapper.mapToUserDto(user);
    }

    public UserDTO saveUser(UserDTO userDTO) {
        User user = userService.saveUser(userDataMapper.mapToUser(userDTO));
        return userDataMapper.mapToUserDto(user);
    }
    public long getUid(int delay){

        Random rand = new Random();
        // Obtain a number between [0 - 49].
        int n = rand.nextInt(delay);
        try {
            Thread.sleep(n * 1000L); // sleep 0 - 49s
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return userService.getUid();
    }
}
